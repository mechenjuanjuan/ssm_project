package it.chen.dao;

import it.chen.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 持久层product
 */
public interface IProductDao {
    /**
     * 查询Product所有信息
     * @return
     */
    @Select("select * from product")
    List<Product> findAll();

    /**
     * 添加
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    /**
     * 根据id查询所有
     */
    @Select("select * from product where id = #{id}")
    Product findById(String id);
}
