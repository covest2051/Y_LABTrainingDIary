package com.trainingdiary.usecases;

import com.trainingdiary.service.userservice.UserSession;
import org.junit.jupiter.api.Test;
import com.trainingdiary.domain.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AuthorizationServiceTest {
    @Test
    public void testRegister() {
        AuthorizationService authService = mock(AuthorizationService.class);
        UserSession session = authService.register();
        verify(authService, times(1)).register();
    }

    @Test
    public void testLogin() {
        AuthorizationService authService = mock(AuthorizationService.class);
        UserSession session = authService.login();
        verify(authService, times(1)).login();
    }
}
