package com.mapath.mailservice.exception;

import com.mapath.mailservice.utils.JsonInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ulongx on 2017/2/18.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomerException.class)
    @ResponseBody
    public JsonInfo<String> jsonErrorHandler(HttpServletRequest req, CustomerException e) throws Exception {
        JsonInfo<String> r = new JsonInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(JsonInfo.ERROR);
        r.setData(e.getData());
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
