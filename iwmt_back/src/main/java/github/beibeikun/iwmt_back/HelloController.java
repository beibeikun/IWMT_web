package github.beibeikun.iwmt_back;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @CrossOrigin(origins = "http://localhost:5173") // 替换为你的Vue应用的实际URL和端口
    @GetMapping("/api/hello")
    public String hello() {
        return "{\"message\":\"Hello, Spring Boot from Vue!\"}";
    }
}