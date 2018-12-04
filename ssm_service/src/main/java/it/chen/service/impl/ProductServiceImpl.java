package it.chen.service.impl;

import it.chen.dao.IProductDao;
import it.chen.domain.Product;
import it.chen.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 业务层实现了类
 * 订单管理
 */
@Service
@Transactional//事务管理注解，即使出现异常情况，它也可以保证数据的一致性
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductDao iProductDao;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Product> findAll() {
        List<Product> productList = iProductDao.findAll();
        return productList;
    }

    /**
     * 添加
     * @param product
     */
    @Override
    public void saveServiceProduct(Product product) {
        iProductDao.save(product);
    }

    @Override
    public Product findById(String id) {
      return   iProductDao.findById(id);
    }
}
