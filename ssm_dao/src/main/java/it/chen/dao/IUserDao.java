package it.chen.dao;

import it.chen.domain.Role;
import it.chen.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",many = @Many(select = "it.chen.dao.IRole.findRoleByUserId")),
    })
    public UserInfo findByName(String username);


    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(username,email,password,phoneNum,status)values(#{username},#{email},#{password},#{phoneNum},#{status})")
    void saveDao(UserInfo userInfo);

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",many = @Many(select = "it.chen.dao.IRole.findRoleByUserId")),
    })
    UserInfo findById(String id);

    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     * 传递两个参数，注解指定参数
     */
    @Insert("insert into users_role(userId,roleId)values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId);

    @Select("select * from role where id not in(select roleId from users_role where userid=#{userid})")
    List<Role> findUserByIdAndAllRole(String userid);
}
