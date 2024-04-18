package com.trainingdiary.domain;

public class YogaWorkoutFactory implements WorkoutFactory {
    @Override
    public Workout createWorkout() {
        return new Yoga();
    }
}
