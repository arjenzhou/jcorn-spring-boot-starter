package cn.jcorn.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(ExampleService.class)
@EnableConfigurationProperties(ExampleServiceProperties.class)
public class AutoConfigure {
    @Autowired
    private ExampleServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "example.service", value = "enabled", havingValue = "true")
    ExampleService exampleService() {
        return new ExampleService(properties.getPrefix(), properties.getSuffix());
    }
}