package com.miao.tool.excel.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ExcelDemo {
    @ExcelProperty("主键")
    Integer id;

    @ExcelProperty("姓名")
    String name;

    @ExcelProperty("KPI")
    @NumberFormat("##.00")
    private Double kpi;

    @ExcelProperty("日期")
    @DateTimeFormat("yyyy-MM-dd")
    private Date applyDate;
}
