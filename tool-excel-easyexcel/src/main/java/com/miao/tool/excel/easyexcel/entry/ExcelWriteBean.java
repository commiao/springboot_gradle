package com.miao.tool.excel.easyexcel.entry;

import lombok.Data;

import java.util.List;

@Data
public class ExcelWriteBean<T> {
    Integer sheetNo;
    String sheetName;
    List<T> list;
    Class<T> clazz;
}
