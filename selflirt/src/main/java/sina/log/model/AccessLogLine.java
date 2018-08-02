package sina.log.model;

import com.google.common.base.Splitter;
import lombok.Data;

import java.util.List;

/**
 * Created by zhouxuan on 2018/8/1
 *
 * @Author: zhouxuan
 * @Date: 2018/8/1
 */
@Data
public class AccessLogLine {
    String requestId;
    String date;
    String timeOfLog;
    String fromIp;
    String httpMethod;
    String status;
    String costTime;
    String header;
    String params;
    String responseLength;
    String response;

    public AccessLogLine(String tempString) {
        int access = tempString.indexOf("access");
        if (access == -1) {
            System.out.println(tempString);
            return;
        }
        List<String> list = Splitter.on(' ').splitToList(tempString.substring(0, access));
        this.date = list.get(1);
        this.timeOfLog = list.get(2);
        this.fromIp=tempString.substring(tempString.indexOf("from")+5, tempString.indexOf("),"));
    }
}
