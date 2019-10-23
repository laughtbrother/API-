package com.mybatisdemo1.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局捕获异常类，只要作用在@RequestMapping上，所有的异常都会被捕获
 */
@ResponseBody
@ControllerAdvice
public class MyControllerAdvice {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> errorHandle(Exception e){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",-1);
        map.put("msg",e.getMessage());
        logger.error(e.getMessage());
        return map;
    }
    @ExceptionHandler(value = BusinessException.class)
    public Map<String,Object> errorHandle(BusinessException e){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",e.getCode());
        map.put("msg",e.getMsg());
        return map;
    }
}
