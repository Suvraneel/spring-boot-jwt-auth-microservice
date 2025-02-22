package ai.vision.vishnu.service;

import ai.vision.vishnu.entity.User;
import ai.vision.vishnu.model.UserBean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public interface UserService {
    User createUser(UserBean userBean);

    User registerUser(@AuthenticationPrincipal OidcUser oidcUser);
}
