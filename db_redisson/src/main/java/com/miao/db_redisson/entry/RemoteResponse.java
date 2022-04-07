package com.miao.db_redisson.entry;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class RemoteResponse<T> implements Serializable {
    private Integer status = 405;
    private String message;
    private T data;
}
