package it.chen.service;

import it.chen.domain.Role;
import it.chen.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll();

    void saveService(UserInfo userInfo);

    UserInfo findById(String id);

    void addRoleToUser(String userId, String[] roleIds);

    List<Role> findUserByIdAndAllRole(String userid);
}
