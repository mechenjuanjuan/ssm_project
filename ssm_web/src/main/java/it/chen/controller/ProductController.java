package it.chen.controller;

import it.chen.domain.Product;
import it.chen.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 表现层
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    /**
     * 查询所有订单
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView productFindAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> productList = iProductService.findAll();
        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * 添加
     */
    @RequestMapping("/save.do")
    public String saveProduct(Product product){
       iProductService.saveServiceProduct(product);
        //redirect重定向
        return "redirect:findAll.do";
    }
}
