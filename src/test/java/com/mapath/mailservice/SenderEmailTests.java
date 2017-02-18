package com.mapath.mailservice;

import com.mapath.mailservice.model.ReqSimpleModel;
import com.mapath.mailservice.service.SendMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;

/**
 * Created by ulongx on 2017/2/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SenderEmailTests {

    @Autowired
    private SendMailService sendMailService;

    @Test
    public void sendEmail(){
        ReqSimpleModel reqSimpleModel = new ReqSimpleModel();
        reqSimpleModel.setName("测试谁是");
        reqSimpleModel.setCategory("Flavors");
        reqSimpleModel.setEmialAddress("123@qq.com");
        reqSimpleModel.setPhoneNumber("13899999999");
        reqSimpleModel.setState("江苏");
        reqSimpleModel.setProjectContext("在那里，您可以选择您所在的州，并快速查看在您的区域中有哪些提供了公共交通。");

        try {
            sendMailService.sendHtmlMail(reqSimpleModel);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}