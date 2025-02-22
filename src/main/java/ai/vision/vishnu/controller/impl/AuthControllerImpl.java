package ai.vision.vishnu.controller.impl;

import ai.vision.vishnu.controller.AuthController;
import ai.vision.vishnu.model.UserBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthControllerImpl implements AuthController {
    @GetMapping("/me")
    public UserBean whoAmI(@AuthenticationPrincipal OidcUser oidcUser) {
        log.info("Getting user info");
        UserBean userBean = new UserBean();
        userBean.setEmail(oidcUser.getEmail());
        userBean.setName(oidcUser.getFullName());
        userBean.setPicture(oidcUser.getPicture());
        return userBean;
    }
}
