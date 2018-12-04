package it.chen.service.impl;

import it.chen.dao.IPermissionDao;
import it.chen.domain.Permission;
import it.chen.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 资源权限管理
 */
import java.util.List;
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao iPermissionDao;

    /**
     * 查询
     * @return
     */
    @Override
    public List<Permission> findAll() {
        return iPermissionDao.findAll();
    }

    /**
     * 保存
     * @param permission
     */
    @Override
    public void save(Permission permission) {
        iPermissionDao.save(permission);
    }

    /**
     * 根据id查询
     * @param permissionId
     * @return
     */
    @Override
    public Permission findById(String permissionId) {
        return iPermissionDao.findById(permissionId);
    }
}
