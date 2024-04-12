package com.trainingdiary.service.userservice;

import com.trainingdiary.service.applicationservice.AuthorizationService;
import com.trainingdiary.service.functionalservice.Workout;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Represents an admin user.
 */
public class Admin extends User {
    /**
     * The AuthorizationService instance used for user operations.
     */
    private final AuthorizationService authService;

    /**
     * Constructor for the Admin class.
     *
     * @param username The username of the admin.
     * @param password The password of the admin.
     * @param authService The AuthorizationService instance.
     */
    public Admin(String username, String password, AuthorizationService authService) {
        super(username, password);
        this.authService = authService;
    }

    /**
     * Views the audit log of a user.
     *
     * @param username The username of the user.
     */
    public void viewUserAuditLog(String username) {
        User user = authService.getUserByUsername(username);
        if (user instanceof RegularUser) {
            List<String> auditLog = ((RegularUser) user).getAuditLog();
            if (auditLog.isEmpty()) {
                com.trainingdiary.out.OutputManager.print("У пользователя " + username + " нет записей аудита.");
            } else {
                com.trainingdiary.out.OutputManager.print("Аудит пользователя " + username + ":");
                for (String log : auditLog) {
                    com.trainingdiary.out.OutputManager.print(log);
                }
            }
        } else {
            com.trainingdiary.out.OutputManager.print("Пользователь с таким логином не найден или не является обычным пользователем");
        }
    }

    /**
     * Views the workouts of a user.
     *
     * @param username The username of the user.
     */
    public void viewUserWorkouts(String username) {
        User user = authService.getUserByUsername(username);
        if (user != null) {
            Map<LocalDate, Map<String, Workout>> workoutsList = user.getIndividualWorkoutsList();
            if (workoutsList.isEmpty()) {
                com.trainingdiary.out.OutputManager.print("У пользователя " + username + " нет тренировок.");
            } else {
                com.trainingdiary.out.OutputManager.print("Тренировки пользователя " + username + ":");
                for (Map.Entry<LocalDate, Map<String, Workout>> entry : workoutsList.entrySet()) {
                    com.trainingdiary.out.OutputManager.print("Дата: " + entry.getKey());
                    for (Workout workout : entry.getValue().values()) {
                        com.trainingdiary.out.OutputManager.print("Тренировка: " + workout);
                    }
                }
            }
        } else {
            com.trainingdiary.out.OutputManager.print("Пользователь с таким логином не найден");
        }
    }
}