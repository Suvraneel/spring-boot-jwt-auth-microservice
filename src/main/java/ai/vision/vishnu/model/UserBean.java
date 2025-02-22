package ai.vision.vishnu.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class UserBean {
    private String name;
    private String email;
    private String picture;
}
