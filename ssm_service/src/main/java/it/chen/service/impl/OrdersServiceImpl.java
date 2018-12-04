package it.chen.service.impl;

import com.github.pagehelper.PageHelper;
import it.chen.dao.IOrdersDao;
import it.chen.domain.Orders;
import it.chen.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 业务层，订单管理
 * 订单分页实现类
 */
@Service
@Transactional//事务管理注解，即使出现异常情况，它也可以保证数据的一致性
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao iOrdersDao;

    /**
     * 分页
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Orders> findAndPage(int page, int size) {
        PageHelper.startPage(page,size);
        return iOrdersDao.findAll();
    }

    /**
     * 详情
     * @param ordersId
     * @return
     */
    @Override
    public Orders findByid(String ordersId) {
        return iOrdersDao.findById(ordersId);
    }
}
