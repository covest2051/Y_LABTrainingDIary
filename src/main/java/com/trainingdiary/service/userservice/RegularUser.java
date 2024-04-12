package com.trainingdiary.service.userservice;

import com.trainingdiary.service.functionalservice.Workout;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegularUser extends User {
    private final List<String> auditLog = new ArrayList<>();

    public RegularUser(String username, String password) {
        super(username, password);
        auditLog.add("User " + username + " created");
    }

    @Override
    public void addWorkout(Workout workout) {
        super.addWorkout(workout);
        auditLog.add("Added a new workout");
    }

    @Override
    public void editWorkout(LocalDate date, String workoutType) {
        super.editWorkout(date, workoutType);
        auditLog.add("Edited a workout");
    }

    @Override
    public void deleteWorkout(LocalDate date, String workoutType) {
        super.deleteWorkout(date, workoutType);
        auditLog.add("Deleted a workout");
    }

    @Override
    public void viewWorkoutHistory() {
        super.viewWorkoutHistory();
        auditLog.add("Viewed workout history");
    }

    @Override
    public void viewWorkoutStatistics() {
        super.viewWorkoutStatistics();
        auditLog.add("Viewed workout statistics");
    }

    public List<String> getAuditLog() {
        return auditLog;
    }
}
