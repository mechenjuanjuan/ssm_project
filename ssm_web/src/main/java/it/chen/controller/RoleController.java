package it.chen.controller;

import it.chen.domain.Permission;
import it.chen.domain.Role;
import it.chen.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 角色管理
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;

    /**
     * 查询
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = iRoleService.findAllRole();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }

    /**
     * 添加
     */
    @RequestMapping("/save.do")
    public String saveRole(Role role){
        iRoleService.saveRole(role);
        return "redirect:findAll.do";
    }

    /**
     * 根据id查询角色
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String roleId){
        ModelAndView mv = new ModelAndView();
       Role role = iRoleService.findById(roleId);
       mv.addObject("role",role);
       mv.setViewName("role-show");
       return mv;
    }

    /**
     * 给角色添加权限,复选框数组
     */
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true)String roleId,@RequestParam(name = "ids",required = true)String[] permissionIds){
        iRoleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }

    /**
     * 查询角色以及角色可以添加的权限
     */
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true)String roleId){
        ModelAndView mv = new ModelAndView();
        //根据id查询角色
        Role roles = iRoleService.findById(roleId);
        List<Permission> userByIdAndAllRole = iRoleService.findUserByIdAndAllRole(roleId);
        mv.addObject("role",roles);
        mv.addObject("permissionList",userByIdAndAllRole);
        mv.setViewName("role-permission-add");
        return mv;
    }


}
