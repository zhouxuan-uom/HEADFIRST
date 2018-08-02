package sina.log.impl;

import com.google.common.collect.Lists;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import sina.log.LogDealer;
import sina.log.model.AccessLogLine;
import sina.log.model.ExcelMeta;
import sina.log.model.TitleFieldMapping;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

/**
 * Created by zhouxuan on 2018/8/1
 *
 * @Author: zhouxuan
 * @Date: 2018/8/1
 */

public class LogDealerImpl implements LogDealer {
    /**
     * 日志读取
     *
     * @param filePath
     * @return
     */
    public List<AccessLogLine> logRead(String filePath) throws FileNotFoundException {
        InputStream in = null;
        List<AccessLogLine> logLines = Lists.newArrayList();
        try {
            in = new GZIPInputStream(new FileInputStream(filePath));
            Scanner sc = new Scanner(in);
            while (sc.hasNextLine()) {
                logLines.add(new AccessLogLine(sc.nextLine()));
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
        return logLines;
    }

    /**
     * excel写入
     *
     * @param logs
     * @return
     */
    public String excelWriter(List<AccessLogLine> logs, ExcelMeta excelMeta) {
        Workbook workbook = null;
        if (excelMeta.getFilePath().toLowerCase().endsWith("xls")) {//2003
            workbook = new XSSFWorkbook();
        } else if (excelMeta.getFilePath().toLowerCase().endsWith("xlsx")) {//2007
            workbook = new HSSFWorkbook();
        } else {
//			logger.debug("invalid file name,should be xls or xlsx");
        }
        //create sheet
        Sheet sheet = workbook.createSheet(excelMeta.getSheetMetaList().get(0).getSheetName());
        int rowIndex = 0;//标识位，用于标识sheet的行号
        //遍历数据集，将其写入excel中
        try {
            //写表头数据
            Row titleRow = sheet.createRow(rowIndex);
            List<TitleFieldMapping> titleFieldMappings = excelMeta.getSheetMetaList().get(0).getTitleFieldMappings();
            for (int i = 0; i < titleFieldMappings.size(); i++) {
                //创建表头单元格,填值
                titleRow.createCell(i).setCellValue(titleFieldMappings.get(i).getTitle());
            }
            rowIndex++;
            //循环写入主表数据
            for (AccessLogLine logLine : logs) {
                //create sheet row
                Row row = sheet.createRow(rowIndex);
                for (int i = 0; i < titleFieldMappings.size(); i++) {
                    //create sheet colum(单元格)
                    Cell cell = row.createCell(i);
                    cell.setCellValue(this.reflectGetValue(logLine, titleFieldMappings.get(i).getField()));
                }
                rowIndex++;
            }
            FileOutputStream fos = new FileOutputStream(excelMeta.getFilePath());
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return excelMeta.getFilePath();
    }

    private String reflectGetValue(AccessLogLine logLine, String field) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String first = (field.charAt(0) + "").toUpperCase();
        Method method = AccessLogLine.class.getMethod("get" + first + field.substring(1));
        return (String) method.invoke(logLine);
    }

}
