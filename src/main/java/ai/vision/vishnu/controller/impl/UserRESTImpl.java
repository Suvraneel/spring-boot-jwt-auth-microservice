package ai.vision.vishnu.controller.impl;

import ai.vision.vishnu.controller.UserREST;
import ai.vision.vishnu.entity.User;
import ai.vision.vishnu.model.UserBean;
import ai.vision.vishnu.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@Controller
public class UserRESTImpl implements UserREST {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @Override
    public ResponseEntity<User> register(@RequestBody UserBean userBean) {
        log.info("Registering user: {}", userBean);
        return ResponseEntity.ok(userService.createUser(userBean));
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            model.addAttribute("profile", principal.getClaims());
        }
        return "index";
    }
}