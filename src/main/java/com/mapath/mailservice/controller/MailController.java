package com.mapath.mailservice.controller;

import com.mapath.mailservice.exception.CustomerException;
import com.mapath.mailservice.model.ReqSimpleModel;
import com.mapath.mailservice.service.SendMailService;
import com.mapath.mailservice.utils.JsonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

/**
 * Created by ulongx on 2017/2/17.
 */
@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private SendMailService sendMailService;

    @RequestMapping
    public JsonInfo sendMails(ReqSimpleModel reqSimpleModel) {
        JsonInfo jsonInfo = new JsonInfo();
        reqSimpleModel.setName("测试谁是");
        reqSimpleModel.setCategory("Flavors");
        reqSimpleModel.setEmialAddress("123@qq.com");
        reqSimpleModel.setPhoneNumber("13899999999");
        reqSimpleModel.setState("江苏");
        reqSimpleModel.setProjectContext("在那里，您可以选择您所在的州，并快速查看在您的区域中有哪些提供了公共交通。");

        try {
            sendMailService.sendHtmlMail(reqSimpleModel);
            jsonInfo.setMessage("发送成功");
            jsonInfo.setCode(JsonInfo.OK);
        } catch (Exception e) {
            e.printStackTrace();
            jsonInfo.setMessage("发送失败,请参看参数配置");
            jsonInfo.setCode(JsonInfo.ERROR);
//            CustomerException exception = new CustomerException("发送失败,请参看参数配置");
//            throw exception;
        }
        return jsonInfo;
    }
}
