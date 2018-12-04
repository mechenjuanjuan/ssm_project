package it.chen.service;

import it.chen.domain.Product;

import java.util.List;

/**
 * 业务层接口
 */
public interface IProductService {

    List<Product> findAll();

    void saveServiceProduct(Product product);

    Product findById(String id);
}
