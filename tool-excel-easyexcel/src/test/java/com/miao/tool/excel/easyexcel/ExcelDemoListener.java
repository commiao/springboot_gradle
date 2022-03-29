package com.miao.tool.excel.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONObject;
import com.miao.tool.excel.easyexcel.utils.Utils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ExcelDemoListener extends AnalysisEventListener<ExcelDemo> {

    private List<ExcelDemo> demoList = new ArrayList<>();

    @Override
    public void invoke(ExcelDemo data, AnalysisContext context) {
        log.debug("解析到一条数据:{}", JSONObject.toJSONString(data));
        if (!Utils.checkObjAllFieldsIsNull(data)) {
            demoList.add(data);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成！");
    }

    public List<ExcelDemo> getDemoList() {
        return demoList;
    }
}
