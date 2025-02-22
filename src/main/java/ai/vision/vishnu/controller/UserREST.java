package ai.vision.vishnu.controller;

import ai.vision.vishnu.entity.User;
import ai.vision.vishnu.model.UserBean;
import org.springframework.http.ResponseEntity;

public interface UserREST {
    ResponseEntity<User> register(UserBean userBean);
}
