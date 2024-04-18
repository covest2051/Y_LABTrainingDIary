package com.trainingdiary.service.applicationservice;

import com.trainingdiary.adapters.in.InputManager;
import com.trainingdiary.adapters.out.OutputManager;
import com.trainingdiary.domain.Admin;
import com.trainingdiary.domain.RegularUser;
import com.trainingdiary.service.userservice.UserSession;
import com.trainingdiary.usecases.AuthorizationService;

/**
 * Main entry point of the application.
 */
public class Application {
    /**
     * Used for user registration and login.
     */
    private final AuthorizationService authService;

    /**
     * Current UserSession. Null if no user is logged in.
     */
    private UserSession session = null;

    /**
     * Initializes the AuthorizationService.
     */
    public Application() {
        this.authService = new AuthorizationService();
    }

    /**
     * Handles the user's session and provides an interface for user interaction.
     */
    public void run() {
        while (true) {
            OutputManager.print("1. Регистрация\n2. Вход\n3. Выход");
            byte choice = InputManager.readByte();
            InputManager.readString();
            if (choice == 3) {
                break;
            }
            switch (choice) {
                case 1:
                    session = authService.register();
                    if (session == null) {
                        continue;
                    }
                    break;
                case 2:
                    session = authService.login();
                    if (session == null) {
                        continue;
                    }
                    break;
                default:
                    OutputManager.print("Выбрано неверное значение");
                    System.exit(0);
            }

            if (UserSession.getCurrentUser() instanceof RegularUser) {
                InterfaceService.showRegularUserMenu();
            } else if (UserSession.getCurrentUser() instanceof Admin) {
                InterfaceService.showAdminMenu();
            }
        }
    }
}