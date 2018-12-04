package it.chen.controller;

import it.chen.domain.Permission;
import it.chen.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 资源权限管理
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService iPermissionService;
//    查询
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Permission> permissionList = iPermissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }
//    保存
    @RequestMapping("/save.do")
    private String save(Permission permission){
        iPermissionService.save(permission);
        return "redirect:findAll.do";
    }

    /**
     * 根据id查询
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String permissionId){
        ModelAndView mv = new ModelAndView();
        Permission permission = iPermissionService.findById(permissionId);
        mv.addObject("permission",permission);
        mv.setViewName("permission-show");
        return mv;
    }
}
