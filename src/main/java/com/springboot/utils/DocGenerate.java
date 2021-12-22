package com.springboot.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author Wuhall
 */
public class DocGenerate {

    /**
     * 执行策略
     */
    public static void proxy(DocType type, Map<String, String> map) throws Exception {
        switch (type) {
            case REIMBURSE:
                reimburseGeneratex(map);break;
            case OTHER:
                System.out.println("other");break;
        }
    }

    /**
     * 报销单
     * 以下这种获取路径的方式不适用于jar包
     */
    @Deprecated
    public static void reimburseGenerate(Map<String, String> map) throws Exception {
        String path = DocGenerate.class.getClassLoader().getResource("").getPath();
        String code = map.get("code");
        String templatePath = path + "/documentStatic/template/reimburseList.xls";
        String filePath = path + "/documentStatic/download/" + code + ".xls";
        FileInputStream fis = new FileInputStream(new File(templatePath));
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String[] date = ft.format(new Date()).split("-");
        for (int i = 1; i < 4; i++) {
            map.put("date" + i, date[i - 1]);
        }
        // 获取sheet1（26行*14列）
        HSSFSheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i < 26; i++) {
            HSSFRow row = sheet.getRow(i);
            for (int j = 0; j < 14; j++) {
                HSSFCell cell = row.getCell(j);
                replaceCellValue(cell, map);
            }
        }
        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);
        out.close();
        fis.close();
    }

    /**
     * 报销单
     */
    public static void reimburseGeneratex(Map<String, String> map) throws Exception {
        String code = map.get("code");
        InputStream inputStream = DocGenerate.class.getResourceAsStream("/documentStatic/template/reimburseList.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        String[] date = ft.format(new Date()).split("-");
        for (int i = 1; i < 4; i++) {
            map.put("date" + i, date[i - 1]);
        }
        // 获取sheet1（26行*14列）
        HSSFSheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i < 26; i++) {
            HSSFRow row = sheet.getRow(i);
            for (int j = 0; j < 14; j++) {
                HSSFCell cell = row.getCell(j);
                replaceCellValue(cell, map);
            }
        }
        String filePath = System.getProperty("user.dir") + "/" + code + ".xls";
        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);
        out.close();
        inputStream.close();
    }

    public static void replaceCellValue(HSSFCell cell, Map<String,String> map) {
        if (null == cell) {
            return;
        }
        String cellValue = cell.getStringCellValue();
        if (cellValue.indexOf("${code}") != -1) {
            cell.setCellValue(map.get("code"));
        }
        if (cellValue.indexOf("${use}") != -1) {
            cell.setCellValue(map.get("use"));
        }
        if (cellValue.indexOf("${amount}") != -1) {
            cell.setCellValue(map.get("amount"));
        }
        if (cellValue.indexOf("${date1}") != -1) {
            String str = cellValue.replace("${date1}", map.get("date1"));
            cell.setCellValue(str);
        }
        if (cellValue.indexOf("${date2}") != -1) {
            String str = cellValue.replace("${date2}", map.get("date2"));
            cell.setCellValue(str);
        }
        if (cellValue.indexOf("${date3}") != -1) {
            String str = cellValue.replace("${date3}", map.get("date3"));
            cell.setCellValue(str);
        }
        if (cellValue.indexOf("${x1}") != -1) {
            float n1 = Float.valueOf(map.get("amount"));
            int n2 = (int)(n1 * 100);
            int x9 = n2 % 10;
            int x8 = n2 / 10 % 10;
            int x7 = n2 / 100 % 10;
            int x6 = n2 / 1000 % 10;
            int x5 = n2 / 10000 % 10;
            int x4 = n2 / 100000 % 10;
            int x3 = n2 / 1000000 % 10;
            int x2 = n2 / 10000000 % 10;
            int x1 = n2 / 100000000 % 10;
            String str = cellValue.replace("${x9}", numTransfer(x9))
                    .replace("${x8}", numTransfer(x8))
                    .replace("${x7}", numTransfer(x7))
                    .replace("${x6}", numTransfer(x6))
                    .replace("${x5}", numTransfer(x5))
                    .replace("${x4}", numTransfer(x4))
                    .replace("${x3}", numTransfer(x3))
                    .replace("${x2}", numTransfer(x2))
                    .replace("${x1}", numTransfer(x1));
            cell.setCellValue(str);
        }
    }

    public static  String numTransfer(int num) {
        switch (num) {
            case 1 : return "壹";
            case 2 : return "贰";
            case 3 : return "叁";
            case 4 : return "肆";
            case 5 : return "伍";
            case 6 : return "陆";
            case 7 : return "柒";
            case 8 : return "捌";
            case 9 : return "玖";
        }
        return "〇";
    }
}
