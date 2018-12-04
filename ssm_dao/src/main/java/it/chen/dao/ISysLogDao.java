package it.chen.dao;

import it.chen.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {

    @Select("select * from sysLog")
    List<SysLog> findAll();

    @Insert("insert into sysLog(visitTime,username,ip,url,executionTime,method)values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);
}
