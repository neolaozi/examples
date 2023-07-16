package com.lgcns.tct.proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProxyServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

        System.out.println("Request : "+ req.getRequestURL());
        
        // 날짜 요청에 대한 응답
        if (req.getRequestURI().equals("/requestDate")) {
            res.setStatus(200);
            res.getWriter().write(new Date().toString());
        }

        // 파일 전송 (byte array로 전송)
        else if (req.getRequestURI().equals("/requestFile")) {
            File file = new File("C:\\temp\\LENA.jpg");

            byte[] fileContent = Files.readAllBytes(file.toPath());
            res.setStatus(200); 

            ServletOutputStream stream = res.getOutputStream(); 
            stream.flush();
            stream.write(fileContent);
            stream.flush();
            stream.close();
        
         // MAP의 Value에 binary를 담았는데, 그냥 전송할 수 없어서 serialize하여 전송
        } else if (req.getRequestURI().equals("/requestFile2")) {

            File file = new File("C:\\temp\\LENA.jpg");
            byte[] fileContent = Files.readAllBytes(file.toPath());

            LinkedHashMap<String, byte[]> content = new LinkedHashMap<String, byte[]>();
            content.put("file", fileContent);

            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(content);
            res.setStatus(200);

            ServletOutputStream stream = res.getOutputStream(); 
            stream.flush();
            stream.write(byteOut.toByteArray());   // byte array로 변경하여 전송
            stream.flush();
            stream.close();
        }
    }

	public static void main(String[] args) {
	}

}
