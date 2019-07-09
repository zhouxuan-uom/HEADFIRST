package sina.shxbj;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by zhouxuan on 2018/8/10
 *
 * @Author: zhouxuan
 * @Date: 2018/8/10
 */

public class LogLineReader {
    public static void main(String[] args) throws FileNotFoundException {
        LogLineReader logLineReader = new LogLineReader();
        LogResult aliyunResult = logLineReader.logRead("/Users/zhouxuan/Documents/weibo/需求-视频分片边传边转/筛选后日志/new/aliyunnohead.csv");
        LogResult shxResult = logLineReader.logRead("/Users/zhouxuan/Documents/weibo/需求-视频分片边传边转/筛选后日志/new/shxnohead.csv");
        ShxAliyunResultCompare shxAliyunResultCompare = new ShxAliyunResultCompare();
        shxAliyunResultCompare.setShxResult(shxResult);
        shxAliyunResultCompare.setAliyunResult(aliyunResult);
        System.out.println(JSON.toJSONString(shxAliyunResultCompare));
    }

    /**
     * 日志读取
     *
     * @param filePath
     * @return
     */
    public LogResult logRead(String filePath) throws FileNotFoundException {
        InputStream in = null;
        OriginTotalLogResult logResult = new OriginTotalLogResult();
//        OriginInitLogResult logResult = new OriginInitLogResult();
//        OriginUploadLogResult logResult = new OriginUploadLogResult();
//        OriginMergeLogResult logResult = new OriginMergeLogResult();
        try {
            in = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                this.deal(logResult, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        OriginTotalLogResult
        logResult.setAvgLengthDivTime(logResult.getTotalLengthDivTime().divide(BigDecimal.valueOf(logResult.getCount()), BigDecimal.ROUND_HALF_UP, 2));
//        OriginInitLogResult
//        logResult.setAvgloadStorageContextDuration(logResult.getLoadStorageContextDuration().divide(BigDecimal.valueOf(logResult.getCount()), BigDecimal.ROUND_HALF_UP, 2));
//        logResult.setAvgpikaInitTime(logResult.getPikaInitTime().divide(BigDecimal.valueOf(logResult.getCount()), BigDecimal.ROUND_HALF_UP, 2));
//        logResult.setAvgstorageEngineInitTime(logResult.getStorageEngineInitTime().divide(BigDecimal.valueOf(logResult.getCount()), BigDecimal.ROUND_HALF_UP, 2));
//        logResult.setAvgtotalInitTime(logResult.getTotalInitTime().divide(BigDecimal.valueOf(logResult.getCount()), BigDecimal.ROUND_HALF_UP, 2));

//        OriginUploadLogResult
//        logResult.setAvgtotalWholeSizeDivUploadPieceTime(logResult.getTotalWholeSizeDivUploadPieceTime().divide(BigDecimal.valueOf(logResult.getCount()), BigDecimal.ROUND_HALF_UP, 2));

//        OriginMergeLogResult
//        logResult.setAvgtotalDispatchTime(logResult.getTotalDispatchTime().divide(BigDecimal.valueOf(logResult.getCount()), BigDecimal.ROUND_HALF_UP, 2));
//        logResult.setAvgtotalInitMediaLibTime(logResult.getTotalInitMediaLibTime().divide(BigDecimal.valueOf(logResult.getCount()), BigDecimal.ROUND_HALF_UP, 2));
//        logResult.setAvgtotalNotifyTranscodeTime(logResult.getTotalNotifyTranscodeTime().divide(BigDecimal.valueOf(logResult.getCount()), BigDecimal.ROUND_HALF_UP, 2));
//        logResult.setAvgtotalPostUploadTime(logResult.getTotalPostUploadTime().divide(BigDecimal.valueOf(logResult.getCount()), BigDecimal.ROUND_HALF_UP, 2));
//        logResult.setAvgtotalLastPieceSizeDivReadContentTime(logResult.getTotalLastPieceSizeDivReadContentTime().divide(BigDecimal.valueOf(logResult.getCount()), BigDecimal.ROUND_HALF_UP, 2));
//        logResult.setAvgtotalLastPieceSizeDivUploadContentTime(logResult.getTotalLastPieceSizeDivUploadContentTime().divide(BigDecimal.valueOf(logResult.getCount()), BigDecimal.ROUND_HALF_UP, 2));
//        logResult.setAvgtotalWholeSizeDivMergeCostTime(logResult.getTotalWholeSizeDivMergeCostTime().divide(BigDecimal.valueOf(logResult.getCount()), BigDecimal.ROUND_HALF_UP, 2));
        return logResult;
    }

    private void deal(
            OriginTotalLogResult logResult,
//            OriginInitLogResult logResult,
//            OriginUploadLogResult logResult,
//            OriginMergeLogResult logResult,
            String line) {
        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        List<String> strings = Splitter.on(',').splitToList(line);
        LogLine logLine = new LogLine();
        try {
            logLine.setStart_time(timeformat.parse(strings.get(0)));
            logLine.setEnd_time(timeformat.parse(strings.get(1)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logLine.setBiz_type(strings.get(2));
        logLine.setFile_token(strings.get(3));
        logLine.setInit_time(BigDecimal.valueOf(Double.parseDouble(strings.get(4))));
        logLine.setUpload_piece_time(BigDecimal.valueOf(Double.parseDouble(strings.get(5))));
        logLine.setUpload_finish_time(BigDecimal.valueOf(Double.parseDouble(strings.get(6))));
        logLine.setPost_upload_time(BigDecimal.valueOf(Double.parseDouble(strings.get(7))));
        logLine.setTransback_time(BigDecimal.valueOf(Double.parseDouble(strings.get(8))));
        logLine.setFile_length(BigDecimal.valueOf(Double.parseDouble(strings.get(9))));
        logLine.setFile_split_size(BigDecimal.valueOf(Double.parseDouble(strings.get(10))));
        logLine.setFile_split_count(BigDecimal.valueOf(Double.parseDouble(strings.get(11))));
        logLine.setStorage_engine_init_time(BigDecimal.valueOf(Double.parseDouble(strings.get(12))));
        logLine.setSave_db_redis_pika_duration(BigDecimal.valueOf(Double.parseDouble(strings.get(13))));
        logLine.setLoad_storage_context_duration(BigDecimal.valueOf(Double.parseDouble(strings.get(14))));
        logLine.setUpload_merge_time(BigDecimal.valueOf(Double.parseDouble(strings.get(15))));
        logLine.setInit_media_lib_time(BigDecimal.valueOf(Double.parseDouble(strings.get(16))));
        logLine.setDispatch_init_time(BigDecimal.valueOf(Double.parseDouble(strings.get(17))));
        logLine.setNotify_transcode_time(BigDecimal.valueOf(Double.parseDouble(strings.get(18))));
        logLine.setUpdate_media_state_time(BigDecimal.valueOf(Double.parseDouble(strings.get(19))));
        logLine.setDispatch_callback_time(BigDecimal.valueOf(Double.parseDouble(strings.get(20))));
        logLine.setNotify_cost_time_duration(BigDecimal.valueOf(Double.parseDouble(strings.get(21))));
        logLine.setRead_content_time_duration(BigDecimal.valueOf(Double.parseDouble(strings.get(22))));
        logLine.setUpload_content_time_duration(BigDecimal.valueOf(Double.parseDouble(strings.get(23))));
        logLine.setUpdate_context_duration(BigDecimal.valueOf(Double.parseDouble(strings.get(24))));
        logLine.setRead_stream_duration(BigDecimal.valueOf(Double.parseDouble(strings.get(25))));

        if (!this.checkInvolve(logLine)) {
            return;
        }
        this.imagination(logLine);
        logResult.countPP();
        this.customizeCheck(logLine, logResult);
    }

    /**
     * 定制字段
     *
     * @param logLine
     * @param logResult
     */
    private void customizeCheck(LogLine logLine,
                                OriginTotalLogResult logResult
//                                OriginInitLogResult logResult
//                                OriginUploadLogResult logResult
//                                OriginMergeLogResult logResult
    ) {
//        OriginTotalLogResult
        BigDecimal time = BigDecimal.valueOf(logLine.getEnd_time().getTime() - logLine.getStart_time().getTime());
        BigDecimal finaltime = time.subtract(logLine.getInit_time()).subtract(logLine.getUpload_piece_time())
                .subtract(logLine.getUpload_finish_time()).subtract(logLine.getPost_upload_time())
                .subtract(logLine.getTransback_time());
        if (finaltime.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println(time + "\t" + logLine.getInit_time() + "\t" + logLine.getUpload_piece_time()
                    + "\t" + logLine.getUpload_finish_time() + "\t" + logLine.getPost_upload_time() + "\t"
                    + "\t" + logLine.getTransback_time());
        }
        logResult.setTotalLengthDivTime(logResult.getTotalLengthDivTime().add(
                logLine.getFile_length().divide(time, BigDecimal.ROUND_HALF_UP, 2)));
//        OriginInitLogResult
//        logResult.setTotalInitTime(logResult.getTotalInitTime().add(logLine.getInit_time()));
//        logResult.setPikaInitTime(logResult.getPikaInitTime().add(logLine.getSave_db_redis_pika_duration()));
//        logResult.setStorageEngineInitTime(logResult.getStorageEngineInitTime().add(logLine.getStorage_engine_init_time()));
//        logResult.setLoadStorageContextDuration(logResult.getLoadStorageContextDuration().add(logLine.getLoad_storage_context_duration()));

//        OriginUploadLogResult
//        BigDecimal wholeSizeExceptLastPiece = logLine.getFile_split_count().subtract(BigDecimal.ONE).multiply(logLine.getFile_split_size());
//        if (logLine.getUpload_piece_time().compareTo(BigDecimal.ZERO) == 0) {
//            if (logLine.getFile_split_count().compareTo(BigDecimal.ONE) != 0) {
//                System.out.println(logLine.getFile_token() + "\t" + logLine.getFile_split_count());
//            }
//            logResult.countSS();
//        } else {
//            logResult.setTotalWholeSizeDivUploadPieceTime(logResult.getTotalWholeSizeDivUploadPieceTime()
//                    .add(wholeSizeExceptLastPiece
//                            .divide(logLine.getUpload_piece_time(), BigDecimal.ROUND_HALF_UP, 2)));
//
//        }

//        OriginUploadFinishLogResult
//        logResult.setTotalDispatchTime(logResult.getTotalDispatchTime().add(logLine.getDispatch_init_time()));
//        logResult.setTotalInitMediaLibTime(logResult.getTotalInitMediaLibTime().add(logLine.getInit_media_lib_time()));
//        logResult.setTotalNotifyTranscodeTime(logResult.getTotalNotifyTranscodeTime().add(logLine.getNotify_transcode_time()));
//        logResult.setTotalPostUploadTime(logResult.getTotalPostUploadTime().add(logLine.getPost_upload_time()));
//        BigDecimal lastPieceSize = logLine.getFile_length().subtract(logLine.getFile_split_count().subtract(BigDecimal.ONE).multiply(logLine.getFile_split_size()));
//        logResult.setTotalLastPieceSizeDivReadContentTime(
//                logResult.getTotalLastPieceSizeDivReadContentTime().add(
//                        logLine.getRead_content_time_duration().compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : lastPieceSize.divide(logLine.getRead_content_time_duration(), BigDecimal.ROUND_HALF_UP, 2)));
//        logResult.setTotalLastPieceSizeDivUploadContentTime(
//                logResult.getTotalLastPieceSizeDivUploadContentTime().add(
//                        logLine.getUpload_content_time_duration().compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : lastPieceSize.divide(logLine.getUpload_content_time_duration(), BigDecimal.ROUND_HALF_UP, 2)));
//        logResult.setTotalWholeSizeDivMergeCostTime(
//                logResult.getTotalWholeSizeDivMergeCostTime().add(
//                        logLine.getUpload_merge_time().compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : logLine.getFile_length().divide(logLine.getUpload_merge_time(), BigDecimal.ROUND_HALF_UP, 2)));

    }

    /**
     * 定制包含
     *
     * @param logLine
     */
    private boolean checkInvolve(LogLine logLine) {
//        if (logLine.getFile_length().compareTo(BigDecimal.valueOf(5 * 1024 * 1024)) == -1) {
//            return false;
//        }
        return true;
    }

    /**
     * 定制假设
     *
     * @param logLine
     */
    private void imagination(LogLine logLine) {

    }
}
