package it.chen.controller;

import com.github.pagehelper.PageInfo;
import it.chen.domain.Orders;
import it.chen.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService iOrdersService;
    /**
     * 订单分页
     */
    @RequestMapping("/findAll.do")
    public ModelAndView pageController(@RequestParam(name = "page",required = true,defaultValue = "1")int page,
                                       @RequestParam(name = "size",required = true,defaultValue = "5")int size){
        ModelAndView mv = new ModelAndView();
        List<Orders> pagesList = iOrdersService.findAndPage(page, size);
        PageInfo pageInfo = new PageInfo(pagesList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    /**
     * 订单详情
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String ordersId){
        ModelAndView mv = new ModelAndView();
        Orders orders = iOrdersService.findByid(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

}
