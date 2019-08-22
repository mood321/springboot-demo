package com.mood.springbootmongodb.web.service;

import com.mood.springbootmongodb.web.entry.model.AppVisitLog;

import java.util.Date;

/**
 * @Created by mood321
 * @Date 2019/8/22 0022
 * @Description TODO
 */

public interface AppVisitLogService {

    void save(String uuid, String ipAddress, String userAgent, String requestUrl, String requestClazz, String requestMethod, String requestParam, Date requestTime);

    void save(String uuid, Integer userId, String ipAddress, String userAgent, String requestUrl, String requestClazz, String requestMethod, String requestParam, Date requestTime,Integer status);

    void save(String uuid, Date responseTime, Long costTime, String responseContent,Integer status);

    AppVisitLog findByUuidAndCreateTime(String uuid, Date createTime);
}
