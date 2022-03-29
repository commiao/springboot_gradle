package com.miao.tool.excel.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelToolTest {
    @DisplayName("测试读取excel")
    @Test
    public void testRead() {
        String excelPath_demo = "F:\\excel\\demo\\demo.xlsx";
        ExcelReader excelReader = ExcelTool.getExcelReader(excelPath_demo);
        ExcelDemoListener listener = new ExcelDemoListener();
        ReadSheet readSheetSys = EasyExcel.readSheet().head(ExcelDemo.class).registerReadListener(listener).build();
        excelReader.read(readSheetSys);
        List<ExcelDemo> demoList = listener.getDemoList();
        demoList.forEach(y -> System.out.println(y));
        excelReader.finish();
    }

    @DisplayName("测试读取excel1")
    @Test
    public void testRead1() {
        String file_path = "F:\\excel\\demo\\demo.xlsx";
        ExcelDemoListener listener = new ExcelDemoListener();
        EasyExcel.read(file_path, ExcelDemo.class, listener).sheet().doRead();
        listener.getDemoList().forEach(y -> System.out.println(y));
    }

    @DisplayName("测试写入excel")
    @Test
    public void testWrite() {
        String excelPath_demo = "F:\\excel\\demo\\demo2.xlsx";
        ExcelWriter excelWriter = EasyExcel.write(excelPath_demo).build();
        List<ExcelDemo> demoList = buildDemoList(10);
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "demo").head(ExcelDemo.class).build();
        excelWriter.write(demoList, writeSheet);
        excelWriter.finish();
    }

    @DisplayName("测试写入excel2")
    @Test
    public void testWrite2() {
        String file_path = "F:\\excel\\demo\\demo3.xlsx";
        EasyExcel.write(file_path, ExcelDemo.class).sheet().doWrite(buildDemoList(10));
    }

    private List<ExcelDemo> buildDemoList(Integer count) {
        List<ExcelDemo> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(buildExcelDemo(i));
        }
        return list;
    }

    private ExcelDemo buildExcelDemo(Integer id) {
        ExcelDemo demo = new ExcelDemo();
        demo.setId(id);
        demo.setName("张mm" + id);
        demo.setKpi(id + 0.33546);
        demo.setApplyDate(new Date());
        return demo;
    }
}
