package cn.koboro.offlineservice.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sftp")
@Data
public class SftpProp {

    private String host;

    private Integer port;

    private String username;

    private String password;

    private String url;

}
