package cn.koboro.offlineservice.utils;

import cn.koboro.offlineservice.properties.SftpProp;
import com.jcraft.jsch.SftpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author xdw
 */
public class FileUpload {

    public static Logger logger = LoggerFactory.getLogger(FileUpload.class);

    public static String upload(MultipartFile file) throws IOException {

        String originalFilename = file.getOriginalFilename();
        int lastIndex = originalFilename.lastIndexOf(".");
        String suffix = "";
        if (lastIndex != -1) {
            suffix = originalFilename.substring(lastIndex);
        }
        String fileName = StringUtil.getShortUUID() + suffix;

        SftpProp sftpProp = SpringContextHolder.getBean(SftpProp.class);

        SFTPUtil sftp = new SFTPUtil(sftpProp.getUsername(), sftpProp.getPassword(), sftpProp.getHost(), sftpProp.getPort());
        sftp.login();

        try {
            sftp.upload("healthThemeTask",  fileName, file.getInputStream());
        } catch (SftpException e) {
            e.printStackTrace();
            logger.info(e.getMessage(), e);
        }
        sftp.logout();

        return sftpProp.getUrl()+fileName;
    }
}
