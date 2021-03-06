package com.springboot.utils;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Wuhall
 */
public class HanyupinyinUtil {
    /**
     * 将文字转为汉语拼音,全拼(复兴路=>fuxinglu)
     *
     * @param ChineseLanguage 要转换的文字
     * @return String
     */
    public static String getPinyinString(String ChineseLanguage) {
        char[] cl_chars = ChineseLanguage.trim().toCharArray();
        String hanyupinyin = "";
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 输出拼音全部小写
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不带声调
        defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        try {
            for (int i = 0; i < cl_chars.length; i++) {
                if (String.valueOf(cl_chars[i]).matches("[\u4e00-\u9fa5]+")) {// 如果字符是中文,则将中文转为汉语拼音
                    hanyupinyin += PinyinHelper.toHanyuPinyinStringArray(cl_chars[i], defaultFormat)[0];
                } else {// 如果字符不是中文,则不转换
                    hanyupinyin += cl_chars[i];
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            System.out.println("字符不能转成汉语拼音");
        }
        return hanyupinyin;
    }

    /**
     * 取每个汉字的第一个字符,大写(复兴路=>FXL)
     *
     * @param ChineseLanguage 要转换的文字
     * @return String
     */
    public static String getFirstLettersUp(String ChineseLanguage) {
        return getFirstLetters(ChineseLanguage, HanyuPinyinCaseType.UPPERCASE);
    }

    /**
     * 取每个汉字的第一个字符,小写(复兴路=>fxl)
     *
     * @param ChineseLanguage 要转换的文字
     * @return String
     */
    public static String getFirstLettersLo(String ChineseLanguage) {
        return getFirstLetters(ChineseLanguage, HanyuPinyinCaseType.LOWERCASE);
    }

    /**
     * 将文字转为汉语拼音首字母,大写或小写需要自己指定(用上面的就行了,这个就别用了)
     *
     * @param ChineseLanguage 要转换的文字
     * @param caseType        UPPERCASE->大写,LOWERCASE->小写
     * @return String
     */
    public static String getFirstLetters(String ChineseLanguage, HanyuPinyinCaseType caseType) {
        char[] cl_chars = ChineseLanguage.trim().toCharArray();
        String hanyupinyin = "";
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(caseType);// 输出拼音全部大写
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不带声调
        hanyupinyin = getHanYuPinYinString(cl_chars, hanyupinyin, defaultFormat);
        return hanyupinyin;
    }

    /**
     * 取第一个汉字的第一个字符(复兴路=>F)
     *
     * @param ChineseLanguage 要转换的文字
     * @return String
     */
    public static String getFirstLetter(String ChineseLanguage) {
        char[] cl_chars = ChineseLanguage.trim().toCharArray();
        String hanyupinyin = "";
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);// 输出拼音全部大写
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不带声调
        try {
            String str = String.valueOf(cl_chars[0]);
            if (str.matches("[\u4e00-\u9fa5]+")) {// 如果字符是中文,则将中文转为汉语拼音,并取第一个字母
                hanyupinyin = PinyinHelper.toHanyuPinyinStringArray(
                        cl_chars[0], defaultFormat)[0].substring(0, 1);
                ;
            } else if (str.matches("[0-9]+")) {// 如果字符是数字,取数字
                hanyupinyin += cl_chars[0];
            } else if (str.matches("[a-zA-Z]+")) {// 如果字符是字母,取字母

                hanyupinyin += cl_chars[0];
            } else {// 否则不转换

            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            System.out.println("字符不能转成汉语拼音");
        }
        return hanyupinyin;
    }

    //获取汉语拼音
    private static String getHanYuPinYinString(char[] cl_chars, String hanyupinyin, HanyuPinyinOutputFormat defaultFormat) {
        try {
            for (int i = 0; i < cl_chars.length; i++) {
                String str = String.valueOf(cl_chars[i]);
                if (str.matches("[\u4e00-\u9fa5]+")) {// 如果字符是中文,则将中文转为汉语拼音,并取第一个字母
                    hanyupinyin += PinyinHelper.toHanyuPinyinStringArray(cl_chars[i], defaultFormat)[0].substring(0, 1);
                } else if (str.matches("[0-9]+")) {// 如果字符是数字,取数字
                    hanyupinyin += cl_chars[i];
                } else if (str.matches("[a-zA-Z]+")) {// 如果字符是字母,取字母
                    hanyupinyin += cl_chars[i];
                } else {// 否则不转换
                    hanyupinyin += cl_chars[i];//如果是标点符号的话，带着
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            System.out.println("字符不能转成汉语拼音");
        }
        return hanyupinyin;
    }

    @Test
    public void test1() {
        System.out.println("getPinyinString===============" + getPinyinString("复兴路"));
        System.out.println("getFirstLettersUp===============" + getFirstLettersUp("复兴路"));
        System.out.println("getFirstLettersLo===============" + getFirstLettersLo("复兴路"));
        System.out.println("getFirstLetter===============" + getFirstLetter("复兴路"));
    }

    @Test
    public void test2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:/Users/87883/Desktop/reimburseList.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        // 获取sheet1（26行*14列）
        HSSFSheet sheet = workbook.getSheetAt(0);
        String userName = "";
        String mobileLast = "";
        String email = "";
        for (int i = 1; i < 2048; i++) {
            HSSFRow row = sheet.getRow(i);
            for (int j = 0; j < 2; j++) {
                HSSFCell cell = row.getCell(j);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                if (j % 2 == 0) {
                    userName = cell.getStringCellValue();
                }
                else {
                    mobileLast = cell.getStringCellValue();
                }
            }
            System.out.println(getPinyinString(userName) + mobileLast.substring(mobileLast.length()-4) + ".cutcc@chinaccs.cn");
        }
//        FileOutputStream out = new FileOutputStream(filePath);
//        workbook.write(out);
//        out.close();
        fileInputStream.close();
    }
}
