package com.trainingdiary.service.userservice;

import com.trainingdiary.service.applicationservice.AuthorizationService;
import com.trainingdiary.service.applicationservice.WorkoutService;
import com.trainingdiary.service.functionalservice.Workout;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserSession {
    private static User currentUser;
    private final List<String> auditLog = new ArrayList<>();

    public UserSession(User user, AuthorizationService authService, WorkoutService workoutService) {
        currentUser = user;
        auditLog.add("User " + user.getUsername() + " logged in");
    }

    public static User getCurrentUser() {
        return currentUser;
    }
}
