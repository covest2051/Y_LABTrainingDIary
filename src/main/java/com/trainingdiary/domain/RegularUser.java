package com.trainingdiary.domain;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a regular user.
 */
@Getter
public class RegularUser extends User
{
    /**
     * The audit log for the user's actions.
     * -- GETTER --
     *  Returns the user's audit log.
     *

     */
    protected List<AuditRecord> auditLog = new ArrayList<>();


    /**
     * Constructor for the RegularUser class.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public RegularUser(String username, String password) {
        super(username, password);
        this.auditLog.add(new AuditRecord(LocalDateTime.now(), "User " + username + " created", this.username));
    }

    /**
     * Adds a workout to the user's workout list and updates the audit log.
     */
    @Override
    public Workout addWorkout(WorkoutFactory factory) {
        Workout workout = super.addWorkout(factory);
        this.auditLog.add(new AuditRecord(LocalDateTime.now(), "Added a new workout", this.username));
        return workout;
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
        this.auditLog.add(new AuditRecord(LocalDateTime.now(), "Edited a workout", this.username));
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
        this.auditLog.add(new AuditRecord(LocalDateTime.now(), "Deleted a new workout", this.username));
    }

    /**
     * Views the user's workout history and updates the audit log.
     */
    @Override
    public void viewWorkoutHistory() {
        super.viewWorkoutHistory();
        this.auditLog.add(new AuditRecord(LocalDateTime.now(), "Viewed workout history", this.username));
    }

    /**
     * Views the user's workout statistics and updates the audit log.
     */
    @Override
    public void viewWorkoutStatistics() {
        super.viewWorkoutStatistics();
        this.auditLog.add(new AuditRecord(LocalDateTime.now(), "Viewed workout statistics", this.username));
    }

}