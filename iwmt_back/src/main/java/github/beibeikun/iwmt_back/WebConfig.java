package github.beibeikun.iwmt_back;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 应用于所有的访问路径
        registry.addMapping("/**")
                // 允许从这个origin发起跨域请求
                .allowedOrigins("http://192.168.3.28:3000") // 替换为你的Vue应用的实际URL和端口
                // 允许的请求方式
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                // 允许的请求头
                .allowedHeaders("*")
                // 是否允许证书（cookies）
                .allowCredentials(true)
                // 客户端缓存预检请求的时间，单位为秒
                .maxAge(3600);
    }
}
