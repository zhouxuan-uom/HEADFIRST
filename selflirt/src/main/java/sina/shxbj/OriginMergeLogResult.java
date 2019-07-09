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
public class OriginMergeLogResult extends LogResult {
    private BigDecimal totalLastPieceSizeDivUploadContentTime = BigDecimal.ZERO;
    private BigDecimal avgtotalLastPieceSizeDivUploadContentTime = BigDecimal.ZERO;
    private BigDecimal totalLastPieceSizeDivReadContentTime = BigDecimal.ZERO;
    private BigDecimal avgtotalLastPieceSizeDivReadContentTime = BigDecimal.ZERO;
    private BigDecimal totalWholeSizeDivMergeCostTime = BigDecimal.ZERO;
    private BigDecimal avgtotalWholeSizeDivMergeCostTime = BigDecimal.ZERO;
    private BigDecimal totalPostUploadTime = BigDecimal.ZERO;
    private BigDecimal avgtotalPostUploadTime = BigDecimal.ZERO;
    private BigDecimal totalDispatchTime = BigDecimal.ZERO;
    private BigDecimal avgtotalDispatchTime = BigDecimal.ZERO;
    private BigDecimal totalInitMediaLibTime = BigDecimal.ZERO;
    private BigDecimal avgtotalInitMediaLibTime = BigDecimal.ZERO;
    private BigDecimal totalNotifyTranscodeTime = BigDecimal.ZERO;
    private BigDecimal avgtotalNotifyTranscodeTime = BigDecimal.ZERO;

}
