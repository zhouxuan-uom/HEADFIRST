package sina.shxbj;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by zhouxuan on 2018/8/10
 *
 * @Author: zhouxuan
 * @Date: 2018/8/10
 */
@Data
public class OriginTotalLogResult extends LogResult {
    private BigDecimal totalLengthDivTime = BigDecimal.ZERO;
    private BigDecimal avgLengthDivTime = BigDecimal.ZERO;
}
