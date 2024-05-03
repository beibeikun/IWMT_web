package github.beibeikun.iwmt_back;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class ImageController {

    private final Path rootLocation = Paths.get("/Volumes/CameraDatabase/thumbnail");

    @GetMapping("/api/images/{filename:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        filename=filename+".JPG";
        try {
            Path file = rootLocation.resolve(filename);
            if (file.toFile().exists()) {
                Resource resource = new UrlResource(file.toUri());
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG) // Adjust media type according to the file type
                        .body(resource);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "File not found");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to read file", e);
        }
    }
}
