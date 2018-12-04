package it.chen.dao;

import it.chen.domain.Member;
import it.chen.domain.Orders;
import it.chen.domain.Product;
import it.chen.domain.Traveller;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 持久层orders
 */
public interface IOrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "it.chen.dao.IProductDao.findById")),
    })
    List<Orders> findAll();


    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",one = @One(select = "it.chen.dao.IProductDao.findById")),
            @Result(property = "member",column = "memberId",one = @One(select = "it.chen.dao.IMemberDao.findByid")),
            @Result(property = "travellers",column = "id",many = @Many(select = "it.chen.dao.ITraveller.findByOrderId")),
    })
    Orders findById(String orderId);
}
