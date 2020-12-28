package com.harrison.mutidatasource.controller;

import com.harrison.mutidatasource.server.MysqlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: HanYu
 * @Date: 2020/11/16
 **/
@Slf4j
@RestController
public class MysqlController {
    
    @Resource
    private MysqlService service;
    
    
    @GetMapping("/local")
    public  void local(){
        service.local();
    }

    @GetMapping("/remote")
    public  void remote(){
        service.remote();
    }



}
