package com.trainingdiary.domain;

public class StrengthWorkoutFactory implements WorkoutFactory {
    @Override
    public Workout createWorkout() {
        return new StrengthWorkout();
    }
}
