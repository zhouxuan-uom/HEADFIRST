package sina.shxbj;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


/**
 * Created by zhouxuan on 2018/8/10
 *
 * @Author: zhouxuan
 * @Date: 2018/8/10
 */
@Data
public class LogLine {
    private Date start_time;
    private Date end_time;
    private String biz_type;
    private String file_token;
    private BigDecimal init_time;
    private BigDecimal upload_piece_time;
    private BigDecimal upload_finish_time;
    private BigDecimal post_upload_time;
    private BigDecimal transback_time;
    private BigDecimal file_length;
    private BigDecimal file_split_size;
    private BigDecimal file_split_count;
    private BigDecimal storage_engine_init_time;
    private BigDecimal save_db_redis_pika_duration;
    private BigDecimal load_storage_context_duration;
    private BigDecimal upload_merge_time;
    private BigDecimal init_media_lib_time;
    private BigDecimal dispatch_init_time;
    private BigDecimal notify_transcode_time;
    private BigDecimal update_media_state_time;
    private BigDecimal dispatch_callback_time;
    private BigDecimal notify_cost_time_duration;
    private BigDecimal read_content_time_duration;
    private BigDecimal upload_content_time_duration;
    private BigDecimal update_context_duration;
    private BigDecimal read_stream_duration;
}