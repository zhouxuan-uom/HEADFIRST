package sina.log.model;

import lombok.Data;

import java.util.List;

/**
 * Created by zhouxuan on 2018/8/1
 *
 * @Author: zhouxuan
 * @Date: 2018/8/1
 */
@Data
public class ExcelMeta {
    String filePath;
    List<ExcelSheetMeta> sheetMetaList;
}
