package com.miao.db_redisson.entry;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SonBean implements Serializable {
    private static final long serialVersionUID = -1417744965593024159L;
    private String sonName;
    private Date createTime;
    private Integer sonDay;
}
