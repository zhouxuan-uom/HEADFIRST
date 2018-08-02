package sina;

import java.io.IOException;

/**
 * Need class description here...
 *
 * @Author: zhouxuan
 * @Date: 2018/5/18
 * @Copyright (c) 2013, bitmain.com All Rights Reserved
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Interview interview = new Interview();
        interview.recurPath("/Users/zhouxuan/myProject/personal/HEADFIRST/selflirt/src/main/java/sina");
        interview.display();
    }
}