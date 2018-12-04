package it.chen.service;

import it.chen.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    List<SysLog> findAll();

    void save(SysLog sysLog);
}
