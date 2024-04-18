package com.trainingdiary.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkoutTest {

    @Test
    public void testCardioWorkout() {
        CardioWorkout workout = new CardioWorkout();
        workout.setDistanceCovered(5);
        assertEquals(5, workout.getDistanceCovered());
    }

    @Test
    public void testStrengthWorkout() {
        StrengthWorkout workout = new StrengthWorkout();
        workout.setTotalWeightLifted(100);
        assertEquals(100, workout.getTotalWeightLifted());
    }

    @Test
    public void testYoga() {
        Yoga workout = new Yoga();
        workout.setNumberOfAsanaPerformed(10);
        assertEquals(10, workout.getNumberOfAsanaPerformed());
    }
}
