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
public class OriginInitLogResult extends LogResult {
    private BigDecimal totalInitTime = BigDecimal.ZERO;
    private BigDecimal pikaInitTime = BigDecimal.ZERO;
    private BigDecimal storageEngineInitTime = BigDecimal.ZERO;
    private BigDecimal loadStorageContextDuration = BigDecimal.ZERO;
    private BigDecimal avgtotalInitTime = BigDecimal.ZERO;
    private BigDecimal avgpikaInitTime = BigDecimal.ZERO;
    private BigDecimal avgstorageEngineInitTime = BigDecimal.ZERO;
    private BigDecimal avgloadStorageContextDuration = BigDecimal.ZERO;
}
