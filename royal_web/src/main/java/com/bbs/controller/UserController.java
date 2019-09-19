package com.bbs.controller;

import com.bbs.domain.UserInfo;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.stream.events.Comment;
import java.io.File;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录校验 以及 用户登录
     * @param userName
     * @param userPass
     * @return
     * @throws Exception
     */
    @RequestMapping("/login.do")
    @ResponseBody
    public String login( HttpSession session, String userName,String userPass) throws Exception {
        UserInfo user = userService.login(userName,userPass);
        if (user==null){
            return "false";
        }else{
            userService.updateLoginTime(userName,new Date());

            //测试能不能拿到这个LoginStatus，如果拿到就可以用
            user.setLoginStatus(1);
            session.setAttribute("loginUser",user);
            return "true";
        }
    }

    /**
     * 用户注销
     * @return
     */
    @RequestMapping("/logout.do")
    public String logout( HttpSession session,Integer userId){

        //注销时直接通过，单击传过来的ID改变LoginStatus的值
//        userService.updateLoginStatus(userId);
        session.invalidate();
        return "redirect:/article/findAll.do";
    }

    /*
    注册校验：发送ajax请求判断用户是否已经存在
     */
    @RequestMapping("findByUsername.do")
//    @ResponseBody
    public @ResponseBody String findByUsername(String userName) throws Exception {
        UserInfo findUser = userService.findByUserName(userName);
        if (findUser==null){
            return "true";
        }else {
            return "false";
        }
    }

    /*
    用户注册
     */
    @RequestMapping("/register.do")
    public ModelAndView register(UserInfo user, HttpSession session) throws Exception {
        Date date = new Date();
        user.setLastLoginTime(date);
        user.setRole(1);
        user.setLoginStatus(1);
        userService.register(user);
        session.setAttribute("loginUser",user);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success");
        return mv;
    }

    /**
     * 发帖，添加帖子
     * @param comment
     * @return
     */
    @RequestMapping("/addPost")
    public String addPost(Comment comment){
        userService.addPost(comment);
        return "redirect:findAllPost.do";
    }

    /**
     * 跳转至修改个人信息主页
     * @param method
     * @return
     */
    @RequestMapping("/getUser.do")
    public ModelAndView getUser(String method){
        ModelAndView mv = new ModelAndView();
        mv.setViewName(method);
        return mv;
    }

    /**
     * 修改个人信息
     * @param request
     * @param upload
     * @param userName
     * @param email
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateUserInfo.do")
    public @ResponseBody String update(HttpServletRequest request, MultipartFile upload, String userName, String email) throws Exception {
        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断，该路径是否存在
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }
        // 说明上传文件项
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        // 完成文件上传
        upload.transferTo(new File(path,filename));

        String picUrl = "uploads/"+filename;
        int i = userService.update(userName, email, picUrl);
        return "true";
    }

    /**
     * 修改密码
     * @param userName
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping("/updatePwd.do")
    public @ResponseBody String updatePwd(String userName,String oldPassword,String newPassword){
        userService.updatePwd(userName,oldPassword,newPassword);
        return "true";
    }

    /**
     * 普通用户申请高级用户
     * @param userName
     * @param response
     * @throws Exception
     */
    @RequestMapping("/applyUpgrade.do")
    public void applyUpdate(String userName, HttpServletResponse response)throws Exception{
        int flag = userService.applyUpgrade(userName);
        response.getWriter().print(flag);
    }
}
