package demo.lock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by zhouxuan on 2019-07-08
 *
 * @Author: zhouxuan
 * @Date: 2019-07-08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DemoObject {
    private String string;
    private Integer integer;
    private List<Long> list;
}
