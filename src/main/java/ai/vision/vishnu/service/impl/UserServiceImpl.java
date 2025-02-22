package ai.vision.vishnu.service.impl;

import ai.vision.vishnu.entity.User;
import ai.vision.vishnu.enums.Role;
import ai.vision.vishnu.model.UserBean;
import ai.vision.vishnu.repository.UserRepository;
import ai.vision.vishnu.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Log4j2
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserBean userBean) {
        log.info("Attempting to create user: {}", userBean);
        User user = new User();
        try {
            user.setName(userBean.getName());
            user.setEmail(userBean.getEmail());
            user.setRoleId(Role.USER);
            user.setActive(true);
            userRepository.save(user);
        } catch (Exception e) {
            log.error("Error creating user: {}", userBean, e);
        }
        log.info("User created successfully: {}", user);
        return user;
    }

    @Override
    public User registerUser(@AuthenticationPrincipal OidcUser oidcUser) {
        log.info("Attempting to register user: {}", oidcUser.getEmail());
        Map<String, Object> claims = oidcUser.getUserInfo().getClaims();
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail((String) claims.get("email")));
        if (optionalUser.isPresent()) {
            log.info("User already exists: {}", oidcUser.getEmail());
            return optionalUser.get();
        }
        User user = new User();
        user.setName(claims.get("name").toString());
        user.setEmail(claims.get("email").toString());
        user.setPicture(claims.get("picture").toString());
        user.setRoleId(Role.USER);
        user.setActive(true);
        userRepository.save(user);
        log.info("User created successfully: {}", user);
        return user;
    }
}
