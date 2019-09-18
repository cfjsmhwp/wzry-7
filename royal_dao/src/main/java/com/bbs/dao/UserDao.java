package com.bbs.dao;

import com.bbs.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


public interface UserDao {

    @Insert("insert into commment () values ()")
    void addPost();

    @Select("select * from bbs_user_table where userName = #{userName} and userPass = #{userPass}")
    User findUserByUserNameAndUserPass(@Param("userName") String userName, @Param("userPass") String userPass);


    @Update("update bbs_user_table set email = #{email},picUrl = #{picUrl} where userName = #{userName}")
    int update(@Param("userName")String userName,@Param("email")  String email, @Param("picUrl")String picUrl);

    @Update("update bbs_user_table set isupdating = 1 where userName = #{userName}")
    int applyUpgrade(String userName);

    @Update("update bbs_user_table set userPass = #{newPassword} where userName = #{userName} and userPass = #{oldPassword}")
    void updatePwd(@Param("userName") String userName, @Param("oldPassword")String oldPassword,@Param("newPassword")String newPassword);
}
