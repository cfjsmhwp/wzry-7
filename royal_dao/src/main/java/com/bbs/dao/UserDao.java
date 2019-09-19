package com.bbs.dao;

import com.bbs.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserDao {

    @Insert("insert into commment () values ()")
    void addPost();

    /**
     * 查询在线用户名称
     * @return
     */
    @Select("select userName from bbs_user_table where loginStatus = 1")
    String[] findOnlineUserName();


    /**
     * 查询在线用户数
     * @return
     */
    @Select("select count(userId) from bbs_user_table where loginStatus = 1")
    Integer findOnlineUserCount();

    @Select("select * from bbs_user_table where  userName = #{userName}")
    UserInfo findByUsername(String userName);
    /**
     * 用户注册
     * @param user
     * @throws Exception
     */
    @Insert("insert into bbs_user_table (userName,userPass,email,lastLoginTime,loginStatus) values (#{userName},#{userPass},#{email},#{lastLoginTime},#{loginStatus})")
    void register(UserInfo user) throws Exception;

    /**
     * 用户登录
     * @param userName
     * @param userPass
     * @return
     * @throws Exception
     */
    @Select("select * from bbs_user_table where userName = #{userName} and userPass = #{userPass}")
    UserInfo login(@Param("userName") String userName, @Param("userPass") String userPass) throws Exception;

    /**
     * 注册时发送ajax查询用户是否可用
     * @param userName
     * @return
     * @throws Exception
     */
    @Select("select * from bbs_user_table where userName = #{userName}")
    UserInfo findByUserName(String userName) throws Exception;


    /**
     * 登录更新时间
     * @param userName
     * @param date
     * @throws Exception
     */
    @Update("update bbs_user_table set lastLoginTime = #{date} where userName =#{userName}")
    void updateLoginTime(@Param("userName") String userName, @Param("date") Date date) throws Exception;

    @Select("select * from bbs_user_table")
    List<UserInfo> findByPage();
    /**
     * 更新个人邮箱，头像
     * @param userName
     * @param email
     * @param picUrl
     * @return
     */
    @Update("update bbs_user_table set email = #{email},picUrl = #{picUrl} where userName = #{userName}")
    int update(@Param("userName")String userName,@Param("email")  String email, @Param("picUrl")String picUrl);

    /**
     * 修改密码
     * @param userName
     * @param oldPassword
     * @param newPassword
     */
    @Update("update bbs_user_table set userPass = #{newPassword} where userName = #{userName} and userPass = #{oldPassword}")
    void updatePwd(@Param("userName") String userName, @Param("oldPassword")String oldPassword,@Param("newPassword")String newPassword);

    /**
     * 普通用户申请为高级用户
     * @param userName
     * @return
     */
    @Update("update bbs_user_table set isupdating = 1 where userName = #{userName}")
    int applyUpgrade(String userName);
}
