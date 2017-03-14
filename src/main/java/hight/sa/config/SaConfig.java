package hight.sa.config;

import hight.sa.config.web.WebSecurityConfig;
import hight.sa.config.web.WebMvcConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by neron.liu on 10/03/2017.
 */
@Configuration
//@Import(value = {WebMvcConfig.class, WebSecurityConfig.class})
@Import(value = {WebSecurityConfig.class})
public class SaConfig {

}
