package com.trainingdiary.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a regular user.
 */
public class RegularUser extends User
{
    /**
     * The audit log for the user's actions.
     */
    private final List<String> auditLog = new ArrayList<>();

    /**
     * Constructor for the RegularUser class.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public RegularUser(String username, String password) {
        super(username, password);
        auditLog.add("User " + username + " created");
    }

    /**
     * Adds a workout to the user's workout list and updates the audit log.
     *
     * @param workout The workout to add.
     */
    @Override
    public void addWorkout(Workout workout) {
        super.addWorkout(workout);
        auditLog.add("Added a new workout");
    }

    /**
     * Edits a workout in the user's workout list and updates the audit log.
     *
     * @param date The date of the workout.
     * @param workoutType The type of the workout.
     */
    @Override
    public void editWorkout(LocalDate date, String workoutType) {
        super.editWorkout(date, workoutType);
        auditLog.add("Edited a workout");
    }

    /**
     * Deletes a workout from the user's workout list and updates the audit log.
     *
     * @param date The date of the workout.
     * @param workoutType The type of the workout.
     */
    @Override
    public void deleteWorkout(LocalDate date, String workoutType) {
        super.deleteWorkout(date, workoutType);
        auditLog.add("Deleted a workout");
    }

    /**
     * Views the user's workout history and updates the audit log.
     */
    @Override
    public void viewWorkoutHistory() {
        super.viewWorkoutHistory();
        auditLog.add("Viewed workout history");
    }

    /**
     * Views the user's workout statistics and updates the audit log.
     */
    @Override
    public void viewWorkoutStatistics() {
        super.viewWorkoutStatistics();
        auditLog.add("Viewed workout statistics");
    }

    /**
     * Returns the user's audit log.
     *
     * @return The user's audit log.
     */
    public List<String> getAuditLog() {
        return auditLog;
    }
}
