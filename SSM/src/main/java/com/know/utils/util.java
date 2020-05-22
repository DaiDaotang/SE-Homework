package com.know.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class util {

    public String upload(MultipartFile file, String root){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String res = sdf.format(new Date());
        //原始名称
        String originalFilename = file.getOriginalFilename();
        //新的文件名称
        String newFileName = res + originalFilename.substring(originalFilename.lastIndexOf("."));
        File newFile = new File(root + File.separator + newFileName);
        //判断目标文件所在的目录是否存在
        if(!newFile.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }
        System.out.println(newFile);
        try{
            //将内存中的数据写入磁盘
            file.transferTo(newFile);
            return newFileName;
        } catch (Exception e) {
            return null;
        }
    }
}
