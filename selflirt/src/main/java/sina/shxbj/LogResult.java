package sina.shxbj;

import lombok.Data;

/**
 * Created by zhouxuan on 2018/8/10
 *
 * @Author: zhouxuan
 * @Date: 2018/8/10
 */
@Data
public class LogResult {
    private Integer count = 0;

    public void countPP() {
        this.count++;
    }

    public void countSS() {
        this.count--;
    }
}
