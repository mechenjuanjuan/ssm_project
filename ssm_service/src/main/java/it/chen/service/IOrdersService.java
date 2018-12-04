package it.chen.service;

import it.chen.domain.Orders;

import java.util.List;

/**
 * 业务层接口
 * 订单分页
 */
public interface IOrdersService {

    List<Orders> findAndPage(int page,int size);

    Orders findByid(String ordersId);
}
