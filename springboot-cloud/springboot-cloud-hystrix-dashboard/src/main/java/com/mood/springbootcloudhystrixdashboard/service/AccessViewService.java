package com.mood.springbootcloudhystrixdashboard.service;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.http.HttpUtil;

/**
 * @Created by mood321
 * @Date 2019/8/12 0012
 * @Description TODO
 */
public class AccessViewService {
    public static void main(String[] args) {

        while(true) {
            ThreadUtil.sleep(1000);
            try {
                String html= HttpUtil.get("http://127.0.0.1:9092/getAll");
                System.out.println("html length:" + html.length());
            }
            catch(Exception e) {
                System.err.println(e.getMessage());
            }

        }

    }
}
