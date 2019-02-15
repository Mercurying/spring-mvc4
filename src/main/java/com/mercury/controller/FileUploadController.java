package com.mercury.controller;


import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file/")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping(value = {"upload"}, method = RequestMethod.POST)
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {

        // 将文件通过流的形式保存在指定位置
        String path = "F:/Data/" + file.getOriginalFilename();
        FileUtils.writeByteArrayToFile(new File(path), file.getBytes());
        logger.info("文件上传文件成功,文件名:{},保存位置:{}", file.getOriginalFilename(), path);
        return "upload finished.";
    }
}
