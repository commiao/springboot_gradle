package com.miao.demo.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
@Slf4j
@Api(value = "Demo", tags = "Demo模块")
public class DemoController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ApiOperation(value = "index方法", notes = "index方法描述")
    @ApiImplicitParam(name = "message", value = "将要输出的消息", required = true, dataType = "String", allowableValues = "ok,yes,no,none")
    public String index(String message) {
        return "index_" + message;
    }
}
