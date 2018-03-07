package com.jk.controller.log;

import com.alibaba.fastjson.JSON;
import com.jk.controller.common.ConstantConf;
import com.jk.controller.common.ResultBean;
import com.jk.model.log.LogBean;
import com.jk.service.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("log")
public class LogController {

    @Autowired
    private LogService logService;

    /**
     * 保存
     * @return
     */
    @RequestMapping(value = "saveLog")
    public Boolean saveLog(@RequestParam String log){

        try {
            LogBean logBean = JSON.parseObject(log, LogBean.class);
            logService.saveLog(logBean);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
          return true;
    }

@RequestMapping(value = "getLogList")
    public String getLogList(@RequestParam Integer page, @RequestParam Integer rows){

    ResultBean resultBean = new ResultBean();

    try {
        List<LogBean> logList = logService.getLogList(page, rows);
        resultBean.setCode(ConstantConf.SUCCESS);
        resultBean.setData(logList);
        resultBean.setMsg("成功");
        resultBean.setCount(logService.getLogListPage());
        String s = JSON.toJSONString(resultBean);
        return s;

    } catch (Exception e) {
        resultBean.setCode(ConstantConf.ERROR);
        resultBean.setMsg(e.getMessage());
        e.printStackTrace();
        return "查询失败";

     }
    }
}
