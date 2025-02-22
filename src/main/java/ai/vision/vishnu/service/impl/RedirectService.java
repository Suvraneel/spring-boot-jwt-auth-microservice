package ai.vision.vishnu.service.impl;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RedirectService {

    @Value("${ui.base.url}")
    private String uibaseUrl;

    public void redirectToPage(HttpServletResponse response) throws IOException {
        response.sendRedirect(uibaseUrl);
    }
}