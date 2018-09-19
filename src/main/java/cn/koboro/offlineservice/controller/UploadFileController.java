package cn.koboro.offlineservice.controller;
import java.io.InputStream;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.koboro.offlineservice.utils.PropertiesUtil;
import cn.koboro.offlineservice.utils.SftpFileUtil;
import cn.koboro.offlineservice.utils.Validator;
@Controller
@RequestMapping("/upload")
public class UploadFileController {
    @PostMapping("/uploadingFile")
    @ResponseBody
    public String uploadFile(MultipartFile file) {
        //上传图片
        String fileName = "";
        if (!Validator.isEmpty(file.getOriginalFilename())) {
            fileName = uploadFileSftp(file);
        }
        System.out.println(fileName);
        return fileName;
    }

    /**
     * 上传
     * @param file
     * @return
     */
    public String uploadFileSftp(MultipartFile file) {
    	String folder="";
        String fileName = System.currentTimeMillis() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String[] keyName = new String[]{"userName", "password", "host", "port", "dir",};
        try {
            InputStream is = file.getInputStream();
            Map<String, String> map = PropertiesUtil.getPropertiesValue(keyName);
            SftpFileUtil sftpFileUtil = new SftpFileUtil(map.get("userName"), map.get("password"), map.get("host"), Integer.valueOf(map.get("port")));
            //链接ftp
            sftpFileUtil.login();
            sftpFileUtil.upload(map.get("dir"), fileName, is);
            folder=map.get("dir");
        } catch (Exception e) {
            //图片上传失败
            System.out.println(e);
            return "";
        }
        return folder+fileName;
    }
}