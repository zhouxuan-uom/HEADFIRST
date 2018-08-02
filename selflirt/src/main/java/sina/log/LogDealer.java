package sina.log;

import sina.log.model.AccessLogLine;
import sina.log.model.ExcelMeta;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by zhouxuan on 2018/8/1
 *
 * @Author: zhouxuan
 * @Date: 2018/8/1
 */

public interface LogDealer {
    /**
     * 日志读取
     *
     * @param filePath
     * @return
     */
    List<AccessLogLine> logRead(String filePath) throws FileNotFoundException;

    /**
     * excel写入
     *
     * @param logs
     * @return
     */
    String excelWriter(List<AccessLogLine> logs, ExcelMeta excelMeta);
}
