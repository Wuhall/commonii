package com.springboot.utils;

/**
 * .docx文件转为.pdf 文件
 */
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import java.io.File;
import java.net.ConnectException;

public class OpenOfficeAndJodconverter {
    public OpenOfficeAndJodconverter() {
    }

    public static void main(String[] args) throws Exception {
        doDocToPdf("C:/Users/41539/Desktop/湖南电信-天翼采购-代码审计报告V1.0(2019-11-19)_银基.docx", "d:/湖南电信-天翼采购-代码审计报告V1.0(2019-11-19)_银基.pdf");
    }

    public static void doDocToPdf(String inFilePath, String outFilePath) throws ConnectException {
        File inputFile = new File(inFilePath);
        File outputFile = new File(outFilePath);
//        String doc_ppt_to_pdf_officeport = SysParamUtils.getSysParam("doc_ppt_to_pdf_officeport");
        int doc_ppt_to_pdf_officeport = 8100;
        SocketOpenOfficeConnection connection = new SocketOpenOfficeConnection(doc_ppt_to_pdf_officeport);

        try {
            connection.connect();
            DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
            converter.convert(inputFile, outputFile);
        } catch (ConnectException var10) {
            var10.printStackTrace();
            throw new ConnectException("连接office插件服务失败，端口：" + doc_ppt_to_pdf_officeport);
        } finally {
            connection.disconnect();
        }

    }
}
