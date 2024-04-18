package com.trainingdiary.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Abstract class representing a workout.
 * This class should be extended by specific types of workouts.
 */
@Setter
public abstract class Workout {
    /**
     * Gathers information about the workout from the user.
     */
    public abstract void gatherWorkoutInfo();

    // Тут мне нужно будет прописать общие методы для типов тренировок, чтобы в будущем было легче добавить новый тип тренировки
    // Также нужно будет создать классы для каждого типа тренировки, которые implements этот интерфейс
    /**
     * The date of the workout.
     */
    @Getter
    protected LocalDate workoutDate;
    /**
     * The type of the workout.
     */
    @Getter
    protected String workoutType = null;
    /**
     * The duration of the workout.
     */
    protected String workoutDuration = null;
    /**
     * The number of calories burned during the workout.
     */
    @Getter
    protected short burnedCalories = 0;
    /**
     * The number of exercises performed during the workout.
     */
    @Getter
    protected byte countOfExercises = 0;


    // Getters and setters


    public Workout() {
        this.workoutDate = LocalDate.now();
    }

    /**
     * Returns a string representation of the workout.
     *
     * @return A string representation of the workout.
     */

    @Override
    public String toString() {
        return  "\n Дата тренировки: " + workoutDate +
                "\n Тип тренировки: " + workoutType +
                "\n Длительность тренировки: " + workoutDuration +
                "\n Сожжённые калории: " + burnedCalories +
                "\n Количество упражнений: " + countOfExercises;
    }
}