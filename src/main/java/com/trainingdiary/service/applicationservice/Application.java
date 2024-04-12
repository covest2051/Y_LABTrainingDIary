package com.trainingdiary.service.applicationservice;

import com.trainingdiary.service.userservice.Admin;
import com.trainingdiary.service.userservice.RegularUser;
import com.trainingdiary.service.userservice.UserSession;

public class Application {
    private final AuthorizationService authService;
    private UserSession session = null;

    public Application() {
        this.authService = new AuthorizationService();
    }

    public void run() {
        while (true) {
            com.trainingdiary.out.OutputManager.print("1. Регистрация\n2. Вход\n3. Выход");
            byte choice = com.trainingdiary.in.InputManager.readByte();
            com.trainingdiary.in.InputManager.readString();
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
                    com.trainingdiary.out.OutputManager.print("Выбрано неверное значение");
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