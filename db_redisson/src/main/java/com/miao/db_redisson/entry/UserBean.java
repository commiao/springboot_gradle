package com.miao.db_redisson.entry;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserBean<T> implements Serializable {
    private static final long serialVersionUID = 6295320163812685137L;
    private String name;
    private Integer age;
    private Date birthday;
    private BigDecimal count;
    private List<UserBean> parents;
    private Map<Integer, UserBean> countMap;
    private SonBean sonBean;
    private List<T> dataList;
}
