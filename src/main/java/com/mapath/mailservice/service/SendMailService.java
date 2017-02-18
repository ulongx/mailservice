package com.mapath.mailservice.service;

import com.mapath.mailservice.model.ReqSimpleModel;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * Created by ulongx on 2017/2/17.
 */

public interface SendMailService {

    public void sendHtmlMail(ReqSimpleModel reqSimpleModel) throws MessagingException;
}
