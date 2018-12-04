package it.chen.controller;


import it.chen.domain.Role;
import it.chen.domain.UserInfo;
import it.chen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 用户管理
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    /**
     * 给用户添加角色
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true)String userId,@RequestParam(name = "ids",required = true)String[] roleIds){
        iUserService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

    /**
     *  查询用户以及用户可以添加的角色(然后再添加角色)
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true)String userid){
        ModelAndView mv = new ModelAndView();
        //1.根据用户id查询用户
        UserInfo user = iUserService.findById(userid);
        List<Role> userByIdAndAllRole = iUserService.findUserByIdAndAllRole(userid);
        mv.addObject("user",user);
        mv.addObject("roleList",userByIdAndAllRole);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     * 查询用户
     * @return
     */
    @RequestMapping("/findAll.do")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userList = iUserService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 保存
     * 权限控制
     */
    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username='chen'")
    public String saveUser(UserInfo userInfo){
        iUserService.saveService(userInfo);
        return "redirect:findAll.do";
    }

    /**
     *  详情
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = iUserService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show1");
        return mv;
    }
}
