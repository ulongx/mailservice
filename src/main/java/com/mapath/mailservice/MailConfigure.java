package com.mapath.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Collections;
import java.util.Properties;

/**
 * email 参数设置类
 * Created by ulongx on 2017/2/17.
 */
@Configuration
@PropertySource("classpath:email/emailconfig.properties")
public class MailConfigure {

    public static final String EMAIL_TEMPLATE_ENCODING = "UTF-8";

    private static final String HOST = "mail.server.host";
//    private static final String PORT = "mail.server.port";
    private static final String PROTOCOL = "mail.server.protocol";
    private static final String USERNAME = "mail.server.username";
    private static final String PASSWORD = "mail.server.password";
    private static final String AUTH = "mail.smtp.auth";
    private static final String STARTTLS = "mail.smtp.starttls.enable";
    private static final String QUITWAIT = "mail.smtp.quitwait";
    private static final String TIMEOUT = "mail.smtp.timeout";

    @Autowired
    private Environment environment;

    @Bean
    public JavaMailSender getJavaMailSenderImpl(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(environment.getProperty(HOST));
//        mailSender.setPort(Integer.parseInt(environment.getProperty(PORT)));
        mailSender.setProtocol(environment.getProperty(PROTOCOL));
        mailSender.setUsername(environment.getProperty(USERNAME));
        mailSender.setPassword(environment.getProperty(PASSWORD));

        Properties props = new Properties();
        props.put(AUTH, environment.getProperty(AUTH));
        props.put(TIMEOUT, environment.getProperty(TIMEOUT));
        props.put(STARTTLS, environment.getProperty(STARTTLS));
        props.put(QUITWAIT, environment.getProperty(QUITWAIT));
        mailSender.setJavaMailProperties(props);

        return mailSender;
    }

    @Bean
    public ClassLoaderTemplateResolver emailTemplateResolver(){
        ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
        emailTemplateResolver.setResolvablePatterns(Collections.singleton("templates/*"));
        emailTemplateResolver.setPrefix("/templates/");
        emailTemplateResolver.setSuffix(".html");
        emailTemplateResolver.setTemplateMode("HTML5");
        emailTemplateResolver.setCharacterEncoding(EMAIL_TEMPLATE_ENCODING);
        emailTemplateResolver.setCacheable(false);
        emailTemplateResolver.setOrder(1);

        return emailTemplateResolver;
    }

}
