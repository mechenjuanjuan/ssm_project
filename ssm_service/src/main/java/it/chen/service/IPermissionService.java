package it.chen.service;

import it.chen.domain.Permission;

import java.util.List;

public interface IPermissionService {

    public List<Permission> findAll();

    void save(Permission permission);

    Permission findById(String permissionId);
}
