package com.mood.springbootmongodb.web.entry.model;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @Created by mood321
 * @Date 2019/8/22 0022
 * @Description TODO
 */
@Data
@ToString
public class AppVisitLog {
    @Id
    private ObjectId id;

    private String uuid;

    private Integer userId;

    private String ipAddress;

    private String userAgent;

    private String requestUrl;

    private String requestClazz;

    private String requestMethod;

    private String requestParam;

    private Date requestTime;

    private Date responseTime;

    private Long costTime;

    private Integer status;

    private String responseContent;
}
