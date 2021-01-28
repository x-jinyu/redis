package com.crm.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 王金宇
 * 2020/12/30 0030
 */
public class CreateExcelTest {
    public static void main(String[] args) throws Exception {
        //创建一个HSSFWorkbook对象，对应一个excel文件
        HSSFWorkbook wb = new HSSFWorkbook();

        //使用wb创建一个对象，对应一个页
        HSSFSheet sheet = wb.createSheet("学生列表");

        //创建一个HSSFCellStyle对象，对应样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);//居中

        //表头信息，行编号从0开始，0表示第一行
        HSSFRow row = sheet.createRow(0);

        //取列，从0开始
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("学号");

        cell = row.createCell(1);
        cell.setCellValue("姓名");

        cell = row.createCell(2);
        cell.setCellValue("年龄");

        //使用sheet创建10个对象，对应10行
        for (int i = 1; i <= 10; i++) {
            //创建行
            row = sheet.createRow(i);
            //第一列
            cell = row.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue(100 + i);
            //第二列
            cell = row.createCell(1);
            cell.setCellValue("tom" + i);
            //第三列
            cell = row.createCell(2);
            cell.setCellValue(20 + i);
        }

        //使用io流输出，先指定输出位置
        OutputStream os = new FileOutputStream("d:\\student.xls");
        wb.write(os);
        os.flush();
        os.close();
        wb.close();
        System.out.println("finish");
    }
}
