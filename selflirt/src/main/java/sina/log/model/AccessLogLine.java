package sina.log.model;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    String methodName;

    public AccessLogLine(String tempString) {
        Pattern pattern = Pattern.compile("\\[INFO] (\\d{8}) (\\d{2}:\\d{2}:\\d{2}\\.\\d{3}) \\[catalina-exec-.*] access - " +
                "\\(from (\\d+\\.\\d+\\.\\d+\\.\\d+)\\), (.*) (.*\\.json) status=(\\d+), cost=(\\d+) ms, header=(.*), " +
                "params=(.*), response \\(len=(\\d+)\\) (\\{.*}) (req.*)");
        Matcher matcher = pattern.matcher(tempString);
        if (matcher.find()) {
            this.date = matcher.group(1);
            this.timeOfLog = matcher.group(2);
            this.fromIp = matcher.group(3);
            this.httpMethod = matcher.group(4);
            this.methodName = matcher.group(5);
            this.status = matcher.group(6);
            this.costTime = matcher.group(7);
            this.header = matcher.group(8);
            this.params = matcher.group(9);
            this.responseLength = matcher.group(10);
            this.response = matcher.group(11);
            this.requestId = matcher.group(12);
        }
    }
}
