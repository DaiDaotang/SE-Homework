package com.know.utils;

import org.springframework.web.multipart.MultipartFile;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class util {


    public String upload(MultipartFile file, String root, int id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String res = sdf.format(new Date());
        //原始名称
        String originalFilename = file.getOriginalFilename();
        //新的文件名称
        String newFileName = id + "_" + res + originalFilename.substring(originalFilename.lastIndexOf("."));
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

    public String upload(String content, String root, int id){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String res = sdf.format(new Date());
        //新的文件名称
        String newFileName = id + "_" + res + ".txt";
        File newFile = new File(root + File.separator + newFileName);
        //判断目标文件所在的目录是否存在
        if(!newFile.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            newFile.getParentFile().mkdirs();
        }
        try {
            FileWriter fw = new FileWriter(newFile);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            fw.close();
            return newFileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public String download(String root, String fileName) {
        File markdown = new File(root + File.separator + fileName);
        FileInputStream is = null;
        StringBuilder stringBuilder = null;
        try {
            if (markdown.length() != 0) {
                /**
                 * 文件有内容才去读文件
                 */
                is = new FileInputStream(markdown);
                InputStreamReader streamReader = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(streamReader);
                String line;
                stringBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                reader.close();
                is.close();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(stringBuilder);
    }
}
