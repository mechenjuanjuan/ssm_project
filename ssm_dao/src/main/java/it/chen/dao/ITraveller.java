package it.chen.dao;

import it.chen.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITraveller {

    @Select("select * from traveller where id in(select TRAVELLERID from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrderId(String ordersId);
}
