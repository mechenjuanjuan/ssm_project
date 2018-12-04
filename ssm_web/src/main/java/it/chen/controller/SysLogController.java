package it.chen.controller;

import it.chen.domain.SysLog;
import it.chen.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * 日志
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private ISysLogService iSysLogService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<SysLog> all = iSysLogService.findAll();
        mv.addObject("sysLogs",all);
        mv.setViewName("syslog-list");
        return mv;
    }
}
