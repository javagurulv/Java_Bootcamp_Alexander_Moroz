package lv.messages;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "lv.messages")
@PropertySource("classpath:application.properties")
public class SpringConfig {
}
