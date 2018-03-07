package com.jk.service.log;

import com.jk.model.log.LogBean;

import java.util.List;

public interface LogService {
    void saveLog(LogBean logBean);

    List<LogBean> getLogList(Integer page, Integer rows);

    Integer getLogListPage();
}
