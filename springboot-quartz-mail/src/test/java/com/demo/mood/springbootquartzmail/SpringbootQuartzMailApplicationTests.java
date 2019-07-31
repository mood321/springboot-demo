package com.demo.mood.springbootquartzmail;

import com.demo.mood.springbootquartzmail.mail.service.impl.MailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootQuartzMailApplicationTests {
    @Autowired
    MailServiceImpl mailService;

    @Test
    public void testMail() {
        mailService.sendEmail("794643619@qq.com","主题","ceshiText");
    }

    @Test
    public void fileMailTest() {
        String to = "794643619@qq.com";
        String subject = "测试邮件2";
        String text = "Hello World 2019";
        String filePath = "D:\\direct1.png";
        this.mailService.sendEmailWithFile(to,subject,text,filePath);
    }

    @Test
    public void htmlMailTest() {
        String to = "794643619@qq.com";
        String subject = "测试邮件3";
        String text = "<html><body><h1>这是一封html邮件,啦啦啦</h1></body></html>";
        this.mailService.sendWithHtml(to,subject,text);
    }

    @Test
    public void htmlFileMailTest() {
        String to = "794643619@qq.com";
        String subject = "测试邮件4";
        String text = "<html>" +
                "<h1>这是一封有图有真相的html邮件,啦啦啦</h1>" +
                "<img style='width:200px;height:200px' src='cid:picture1'>" +
                "<img style='width:200px;height:200px' src='cid:picture2'>" +
                "</html>";
        Map<String,String> map = new HashMap<>(16);
        map.put("picture1","D:\\direct.png");
        map.put("picture2","D:\\direct1.png");
        this.mailService.sendWithImageHtml(to,subject,text,map);
    }
}
