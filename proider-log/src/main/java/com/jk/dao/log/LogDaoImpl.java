package com.jk.dao.log;

import com.jk.model.log.LogBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogDaoImpl implements LogDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveLog(LogBean logBean) {
       mongoTemplate.insert(logBean);
    }

    /**
     * 查询
     * @param skip
     * @param limit
     * @return
     */
    @Override
    public List<LogBean> getLogList(Integer skip, Integer limit) {
        return mongoTemplate.find(new Query().skip(skip).limit(limit),LogBean.class);
    }

    @Override
    public Integer getLogListPage() {
        return (int)mongoTemplate.count(new Query(),LogBean.class,"log");
    }
}
