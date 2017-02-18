package com.mapath.mailservice.service.impl;

import com.mapath.mailservice.MailConfigure;
import com.mapath.mailservice.model.ReqSimpleModel;
import com.mapath.mailservice.service.SendMailService;
import com.mapath.mailservice.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * Created by ulongx on 2017/2/17.
 */
@Service("sendMailService")
public class SendMailServiceImpl implements SendMailService{

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine htmlTemplateEngine;

    @Override
    public void sendHtmlMail(ReqSimpleModel reqSimpleModel) throws MessagingException {

        // Prepare message using a Spring helper
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, MailConfigure.EMAIL_TEMPLATE_ENCODING);
        message.setSubject(reqSimpleModel.getName() + " 索取样品");
        message.setFrom("your email name");//此处和配置文件里面写mail要一致
        message.setTo("recipient email"); //接收者的email

        //html 邮件上下文
        final Context ctx = new Context();
        ctx.setVariable("name", reqSimpleModel.getName());
        ctx.setVariable("subscriptionDate", new Date());
        ctx.setVariable("emialAddress", reqSimpleModel.getEmialAddress());
        ctx.setVariable("state", reqSimpleModel.getState());
        ctx.setVariable("category", reqSimpleModel.getCategory());
        ctx.setVariable("phoneNumber", reqSimpleModel.getPhoneNumber());
        ctx.setVariable("projectContext", reqSimpleModel.getProjectContext());

        // HTML body using Thymeleaf
        final String htmlContent = this.htmlTemplateEngine.process(Constant.EMAIL_HTML_TEMPLATE_NAME, ctx);
        message.setText(htmlContent, true /* isHtml */);

        // Send email
        this.mailSender.send(mimeMessage);
    }
}
