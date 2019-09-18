package com.bbs.controller;

import com.bbs.domain.User;
import com.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.events.Comment;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param request
     * @param response
     * @param userName
     * @param userPass
     * @throws Exception
     */
    @RequestMapping("/login")
    public void Login(HttpServletRequest request,HttpServletResponse response,String userName,String userPass)throws Exception{

            User user = userService.findUserByUserNameAndUserPass(userName,userPass);
            if (user!=null){
                request.getSession().setAttribute("user",user);
                response.setContentType("text/html; charset=utf-8");
                response.getWriter().print("true");
                response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
            }

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
     * 注销（退出登录）
     * @param request
     * @param response
     */
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){


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
    @RequestMapping("/updateUserInfo")
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
     * 普通用户申请高级用户
     * @param userName
     * @param response
     * @throws Exception
     */
    @RequestMapping("/applyUpgrade")
    public void applyUpdate(String userName, HttpServletResponse response)throws Exception{
        int flag = userService.applyUpgrade(userName);
        response.getWriter().print(flag);
    }


    /**
     * 修改密码
     * @param userName
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping("/updatePwd")
    public @ResponseBody String updatePwd(String userName,String oldPassword,String newPassword){
        userService.updatePwd(userName,oldPassword,newPassword);
        return "true";
    }

}
