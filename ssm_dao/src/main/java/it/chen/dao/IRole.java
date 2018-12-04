package it.chen.dao;

import it.chen.domain.Permission;
import it.chen.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRole {

    //通过user_role中间表的id查询
    @Select("select * from Role where id in(select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "it.chen.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId);

    @Select("select * from Role")
    List<Role> findAllRole();

    @Insert("insert into role(roleName,roleDesc)values(#{roleName},#{roleDesc})")
    void saveRole(Role role);

    /**
     * 根据id查询角色
     *
     * @param roleId
     * @return
     */
    @Select("select * from role where id=#{roleId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "it.chen.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(String roleId);

    @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findUserByIdAndAllRole(String roleId);

    @Insert("insert into role_permission(roleId,permissionId) values (#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
