package com.miao.demo.swagger.controller;

import com.miao.demo.swagger.params.HelloParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Slf4j
@Api(value = "Hello", tags = "Hello模块")
public class HelloController {

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ApiOperation(value = "index方法", notes = "index方法描述", tags = "Demo模块")
    public String index(HelloParam helloParam) {
        return "index_" + helloParam.getMessage();
    }

}
