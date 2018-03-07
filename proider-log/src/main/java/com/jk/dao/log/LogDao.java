package com.jk.dao.log;

import com.jk.model.log.LogBean;

import java.util.List;

public interface LogDao {
    void saveLog(LogBean logBean);

    List<LogBean> getLogList(Integer skip, Integer limit);

    Integer getLogListPage();
}
