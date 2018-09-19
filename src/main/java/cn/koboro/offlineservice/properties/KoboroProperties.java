package cn.koboro.offlineservice.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author xdw
 */
@Data
@Component
@PropertySource("classpath:/koboro.properties")
@ConfigurationProperties(prefix = "koboro")
@EnableConfigurationProperties
public class KoboroProperties {

    private String server;

    private String sendAMessage;


    public String servcieSendAMessage(){
        return server + sendAMessage;
    }
}
