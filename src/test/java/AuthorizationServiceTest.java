import com.trainingdiary.service.applicationservice.AuthorizationService;
import com.trainingdiary.service.userservice.UserSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationServiceTest {
    private AuthorizationService authorizationService;

    @BeforeEach
    void setUp() {
        authorizationService = new AuthorizationService();
    }

    @Test
    void testRegister() {
        // Подготовка ввода пользователя
        String input = "testUser\n" + "testPassword\n" + "regular\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Вызов метода register()
        UserSession session = authorizationService.register();

        // Проверка результата
        assertNotNull(session, "Session should not be null after registration");
    }
}
