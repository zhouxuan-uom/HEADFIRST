package sina.log;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import sina.log.impl.LogDealerImpl;
import sina.log.model.AccessLogLine;
import sina.log.model.ExcelMeta;
import sina.log.model.ExcelSheetMeta;
import sina.log.model.TitleFieldMapping;

import java.util.List;

/**
 * Created by zhouxuan on 2018/8/1
 *
 * @Author: zhouxuan
 * @Date: 2018/8/1
 */

public class Log2Excel {

    public static void main(String[] args) throws Exception {
        LogDealer logDealer = new LogDealerImpl();
        List<AccessLogLine> logLineList = logDealer.logRead("/Users/zhouxuan/myProject/weibo/sve_log/access.log.20180726-00.gz");
        ExcelMeta excelMeta = new ExcelMeta();
        excelMeta.setFilePath("/Users/zhouxuan/myProject/weibo/sve_log/output/access_log_20180726-00.xls");
        ExcelSheetMeta sheetMeta = new ExcelSheetMeta();
        sheetMeta.setSheetName("access log");
        sheetMeta.setTitleFieldMappings(JSON.parseArray(FIELD_TITLE_MAPPING_JSON, TitleFieldMapping.class));
        excelMeta.setSheetMetaList(Lists.newArrayList(sheetMeta));
        System.out.println(logDealer.excelWriter(logLineList, excelMeta));
    }

    public static final String FIELD_TITLE_MAPPING_JSON = "[{\"field\":\"requestId\",\"title\":\"request id\"},{\"field\":\"date\",\"title\":\"日期\"},{\"field\":\"timeOfLog\",\"title\":\"时间\"},{\"field\":\"fromIp\",\"title\":\"访问ip\"},{\"field\":\"httpMethod\",\"title\":\"http调用方法\"},{\"field\":\"status\",\"title\":\"http状态码\"},{\"field\":\"costTime\",\"title\":\"耗时\"},{\"field\":\"header\",\"title\":\"http header\"},{\"field\":\"params\",\"title\":\"http参数\"},{\"field\":\"responseLength\",\"title\":\"http response长度\"},{\"field\":\"response\",\"title\":\"http response内容\"}]";
}
