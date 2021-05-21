package com.gov.erf.config.data;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("ern.app.file")
public class ClaimFileConfigurations {

    private String filesDir;

}
