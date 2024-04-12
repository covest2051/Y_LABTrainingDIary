package com.trainingdiary.service.userservice;

import com.trainingdiary.service.applicationservice.AuthorizationService;
import com.trainingdiary.service.applicationservice.WorkoutService;
import com.trainingdiary.service.functionalservice.Workout;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user session.
 */
public class UserSession {

    /**
     * The current user of the session.
     */
    private static User currentUser;

    /**
     * The audit log for the session's actions.
     */
    private final List<String> auditLog = new ArrayList<>();

    /**
     * Constructor for the UserSession class.
     *
     * @param user The user of the session.
     * @param authService The AuthorizationService instance.
     * @param workoutService The WorkoutService instance.
     */
    public UserSession(User user, AuthorizationService authService, WorkoutService workoutService) {
        currentUser = user;
        auditLog.add("User " + user.getUsername() + " logged in");
    }

    /**
     * Returns the current user of the session.
     *
     * @return The current user of the session.
     */
    public static User getCurrentUser() {
        return currentUser;
    }
}
