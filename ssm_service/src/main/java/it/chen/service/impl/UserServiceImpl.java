package it.chen.service.impl;

import it.chen.dao.IUserDao;
import it.chen.domain.Role;
import it.chen.domain.UserInfo;
import it.chen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理
 *
 */
@Service("userService")
@Transactional//事务管理注解，即使出现异常情况，它也可以保证数据的一致性。
public class UserServiceImpl implements IUserService {
    //注入到ioc容器
    @Autowired
    private IUserDao iUserDao;
    //加密
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 安全认证
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = iUserDao.findByName(username);
        //处理自己的用户对象封装成UserDetails，加{noop}是密码过于简单，不被认为是密码
//        User user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true,true,true,true,getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(),userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    /**
     * 查询用户
     * @return
     */
    @Override
    public List<UserInfo> findAll() {
        return iUserDao.findAll();
    }

    /**
     * 保存
     * @param userInfo
     */
    @Override
    public void saveService(UserInfo userInfo) {
        //加密
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        iUserDao.saveDao(userInfo);
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @Override
    public UserInfo findById(String id) {
        return iUserDao.findById(id);
    }

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     */
    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId : roleIds) {
            iUserDao.addRoleToUser(userId,roleId);
        }
    }

    /**
     * 查询用户以及用户可以添加的角色
     * @param userid
     */
    @Override
    public List<Role> findUserByIdAndAllRole(String userid) {
        return iUserDao.findUserByIdAndAllRole(userid);
    }
}
