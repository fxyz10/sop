package com.hysz.sop.controller;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 测试用。controller层只传递参数，具体逻辑写到service层。
 */
@RestController
@RequestMapping(value = "/file")
public class UploadController {

    private final String upDir = "D:\\workspace\\filesDir\\up";
    private final String downDir = "D:\\workspace\\filesDir\\down";

    @GetMapping(value = "upFile")
    public String upFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        System.out.println("up file start");
        System.out.println("server up path: " + upDir);
        String fileName = multipartFile.getOriginalFilename();
        // size单位byte，转KB除1024。
        int size = (int) multipartFile.getSize();
        String content = new String(multipartFile.getBytes(), StandardCharsets.UTF_8);
        System.out.println("up_file_name: " + fileName);
        System.out.println("up_file_size: " + size);
        System.out.println("up_file_content: " + content);
        System.out.println("read start");
        // 上传文件转为inputStream后，可以直接用Workbook接收。
        BufferedInputStream bis = new BufferedInputStream(multipartFile.getInputStream());
        InputStreamReader isr = new InputStreamReader(bis);
        int ch;
        while ((ch = isr.read()) != -1) {
            System.out.print((char) ch);
        }
        isr.close();
        bis.close();
        System.out.println("read end");
        Assert.notNull(fileName, "文件名不能为空");
        File file = new File(upDir, fileName);
        multipartFile.transferTo(file);
        System.out.println("up file end");
        return "success";
    }

    @GetMapping(value = "upFiles")
    public String upFiles(@RequestParam("files") MultipartFile[] multipartFileArray) throws IOException {
        System.out.println("up files start");
        System.out.println("server up path: " + upDir);
        for (MultipartFile multipartFile : multipartFileArray) {
            String fileName = multipartFile.getOriginalFilename();
            // size单位byte，转KB除1024。
            int size = (int) multipartFile.getSize();
            System.out.println("up_file_name: " + fileName);
            System.out.println("up_file_size: " + size);
            Assert.notNull(fileName, "文件名不能为空");
            File file = new File(upDir, fileName);
            multipartFile.transferTo(file);
        }
        System.out.println("up files start");
        return "success";
    }

    @GetMapping(value = "/down")
    public void downFile(HttpServletResponse response) throws Exception {
        System.out.println("down file start");
        System.out.println("server down path: " + downDir);
        String fileName = "downTest.txt";
        File file = new File(downDir, fileName);
        response.setContentType("application/x-download");
        fileName = new String("下载测试文件.txt".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        OutputStream os = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int i = bis.read(buffer);
        while (i != -1) {
            os.write(buffer, 0, i);
            i = bis.read(buffer);
        }
        os.close();
        bis.close();
        fis.close();
        System.out.println("down file end");
    }
}
