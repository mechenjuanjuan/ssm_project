package it.chen.service.impl;

import it.chen.dao.ISysLogDao;
import it.chen.domain.SysLog;
import it.chen.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 日志
 */
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao iSysLogDao;
    @Override
    public List<SysLog> findAll() {
        return iSysLogDao.findAll();
    }

    @Override
    public void save(SysLog sysLog) {
        iSysLogDao.save(sysLog);
    }
}
