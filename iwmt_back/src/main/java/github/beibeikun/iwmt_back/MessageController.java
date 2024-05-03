package github.beibeikun.iwmt_back;

// 导入所需的包
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class MessageController {

    @CrossOrigin(origins = "http://localhost:3000") // 替换为你的Vue应用的实际URL和端口
    @PostMapping("/message")
    public ResponseEntity<String> receiveMessage(@RequestBody Message message) {
        System.out.println("Received message: " + message.getContent());
        // 这里可以添加业务逻辑
        return ResponseEntity.ok("Message received: " + message.getContent());
    }

    // 使用一个内部类来映射 JSON 数据
    static class Message {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
