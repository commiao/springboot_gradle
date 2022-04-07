package com.miao.demo.swagger.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "HelloParam对象", description = "HelloParam对象描述")
public class HelloParam {
    @ApiModelProperty(name = "message", value = "将要输出的消息", dataType = "String", required = true, allowableValues = "ok,yes,no,none")
    String message;

    @ApiModelProperty(allowableValues = "111,222")
    String code;
}
