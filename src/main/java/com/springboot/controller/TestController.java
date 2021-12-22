package com.springboot.controller;

import com.springboot.utils.DocGenerate;
import com.springboot.utils.DocType;
import com.springboot.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.bean.Student;
import com.springboot.service.StudentService;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class TestController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "act", method = RequestMethod.GET)
	public void downReimburseList(String code, String use, HttpServletResponse response) throws Exception {
		if (null == code || null == use || "".equals(code) || "".equals(use)) {
			return;
		}
		Pattern p = Pattern.compile("\\w*-\\d*\\.\\d*");
		Matcher m = p.matcher(code);
		if (!m.matches()) {
			return;
		}
		String[] temp = code.split("-");
		String amount = temp[1];
		Map<String, String> map = new HashMap<>();
		map.put("code", code);
		map.put("use", use);
		map.put("amount", amount);
		DocGenerate.proxy(DocType.REIMBURSE, map);
		FileUtils.downFile(code + ".xls", response);
	}


	@RequestMapping(value = "querystudent", method = RequestMethod.GET)
	public Student queryStudentBySno(String sno) {
		return this.studentService.queryStudentBySno(sno);
	}

}
