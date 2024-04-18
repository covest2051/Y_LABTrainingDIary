package com.trainingdiary.service.userservice;

import com.trainingdiary.domain.AuditRecord;
import com.trainingdiary.domain.User;
import com.trainingdiary.usecases.AuthorizationService;
import com.trainingdiary.usecases.WorkoutService;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user session.
 */
public class UserSession {

    /**
     * The current user of the session.
     * -- GETTER --
     *  Returns the current user of the session.
     *

     */
    @Getter
    private static User currentUser;

    /**
     * The audit log for the session's actions.
     */
    protected List<AuditRecord> auditLog = new ArrayList<>();

    /**
     * Constructor for the UserSession class.
     *
     * @param user The user of the session.
     * @param authService The AuthorizationService instance.
     * @param workoutService The WorkoutService instance.
     */
    public UserSession(User user, AuthorizationService authService, WorkoutService workoutService) {
        currentUser = user;
        this.auditLog.add(new AuditRecord(LocalDateTime.now(), "User " + user.getUsername() + " logged in", user.getUsername()));

    }

}
