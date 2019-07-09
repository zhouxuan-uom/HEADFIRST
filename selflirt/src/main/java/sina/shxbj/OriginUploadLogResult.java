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
public class OriginUploadLogResult extends LogResult {
    private BigDecimal totalWholeSizeDivUploadPieceTime = BigDecimal.ZERO;
    private BigDecimal avgtotalWholeSizeDivUploadPieceTime = BigDecimal.ZERO;
}
