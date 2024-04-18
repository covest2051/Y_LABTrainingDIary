package com.trainingdiary.domain;

/**
 * Interface for workout factories.
 * A workout factory is responsible for creating workouts of a specific type.
 */
public interface WorkoutFactory {
    /**
     * Creates a new workout.
     *
     * @return A new workout.
     */
    Workout createWorkout();
}
