package com.trainingdiary.domain;

public class CardioWorkoutFactory implements WorkoutFactory {
    @Override
    public Workout createWorkout() {
        return new CardioWorkout();
    }
}
