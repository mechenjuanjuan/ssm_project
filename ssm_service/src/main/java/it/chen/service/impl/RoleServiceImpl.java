package it.chen.service.impl;

import it.chen.dao.IRole;
import it.chen.domain.Permission;
import it.chen.domain.Role;
import it.chen.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 角色管理
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRole iRoledao;

    /**
     * 查询
     * @return
     */
    @Override
    public List<Role> findAllRole() {
        return iRoledao.findAllRole();
    }

    /**
     * 保存
     * @param role
     */
    @Override
    public void saveRole(Role role) {
        iRoledao.saveRole(role);
    }

    /**
     * 根据id查询角色
     * @param roleId
     * @return
     */
    @Override
    public Role findById(String roleId) {
        return iRoledao.findById(roleId);
    }

    /**
     * 查询角色以及角色可以添加的权限
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> findUserByIdAndAllRole(String roleId) {
        return iRoledao.findUserByIdAndAllRole(roleId);
    }

    /**
     * 给角色添加权限
     */
    @Override
    public void addPermissionToRole(String roleId,String[] permissionIds) {
        for (String permissionId : permissionIds) {
            iRoledao.addPermissionToRole(roleId,permissionId);
        }
    }
}
