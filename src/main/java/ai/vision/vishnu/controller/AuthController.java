package ai.vision.vishnu.controller;

import ai.vision.vishnu.model.UserBean;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthController {
    ResponseEntity<String> register(@RequestBody UserBean userBean) throws BadRequestException;

    ResponseEntity<?> login(@RequestBody UserBean userBean);
}
