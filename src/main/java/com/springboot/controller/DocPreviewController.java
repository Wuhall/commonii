package com.springboot.controller;

import com.springboot.utils.OpenOfficeAndJodconverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@RestController
public class DocPreviewController {

    @ResponseBody
    @RequestMapping("${adminPath}/item/personalDiary/preview2")
    public void findPdf(String id, HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
//        String fileName = personalDiaryService.getFileName(id);
        String fileName = "test";
        String filepath = session.getServletContext().getRealPath("/")+"documentStatic/download/personalDiary/"+fileName;
        File file = new File(filepath + ".pdf");
        if (!file.exists()) {
            OpenOfficeAndJodconverter.doDocToPdf(filepath + ".docx", filepath + ".pdf");
        }
        FileInputStream in = new FileInputStream(file);
        OutputStream out = response.getOutputStream();
        byte[] b = new byte[512];
        while ((in.read(b)) != -1) {
            out.write(b);
        }
        out.flush();
        in.close();
        out.close();
    }
}
