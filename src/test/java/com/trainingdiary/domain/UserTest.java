package com.trainingdiary.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void testAddWorkout() {
        User user = new RegularUser("testUser", "testPassword");
        WorkoutFactory workoutFactory = new CardioWorkoutFactory();
        user.addWorkout(workoutFactory);
        LocalDate today = LocalDate.now();
        assertTrue(user.getIndividualWorkoutsList().get(today).containsKey("Cardio"));
    }

    @Test
    public void testHasWorkoutToday() {
        User user = new RegularUser("testUser", "testPassword");
        WorkoutFactory workoutFactory = new CardioWorkoutFactory();
        String workoutType = "Cardio";
        assertFalse(user.hasWorkoutToday(workoutType));
        user.addWorkout(workoutFactory);
        assertTrue(user.hasWorkoutToday(workoutType));
    }
}
