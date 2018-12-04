package it.chen.service;

import it.chen.domain.Permission;
import it.chen.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAllRole();

    void saveRole(Role role);

    Role findById(String roleId);

    List<Permission> findUserByIdAndAllRole(String userId);

    void addPermissionToRole(String roleId,String[] permissionIds);
}
