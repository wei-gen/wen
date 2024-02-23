package com.example.wenmanager.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import com.example.wenmanager.util.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class FileService {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static String FILE_PARENT_DIR = "";
    private static String IMAGE_FILE_PARENT_DIR="";
    private static String IMAGE = "image";
    static {
        String rootPath = System.getProperty("user.dir");
        // 排除掉最后一个文件分隔符以及这个文件分隔符后面的字符
        int lastSeparatorIndex = rootPath.lastIndexOf(File.separator);
        if (lastSeparatorIndex != -1) {
            rootPath = rootPath.substring(0, lastSeparatorIndex);
        }
        IMAGE_FILE_PARENT_DIR = rootPath + File.separator + IMAGE;
    }

    public String uploadImage(MultipartFile file){

        String fileName = RandomUtil.randomString(15) + FileUtils.getFileSuffix(file.getOriginalFilename());
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();
        String fileParentDirName = currentDate.format(formatter);
        String parentDirPath = IMAGE_FILE_PARENT_DIR + File.separator + fileParentDirName;
        if(!FileUtil.exist(parentDirPath)){
            //创建目录
            FileUtil.mkdir(parentDirPath);
        }
        try {
            file.transferTo(new File(parentDirPath + File.separator + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "/" + IMAGE + "/" + fileParentDirName + "/" + fileName;
    }
}
