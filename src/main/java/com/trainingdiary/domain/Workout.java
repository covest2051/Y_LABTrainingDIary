package com.trainingdiary.domain;

import java.time.LocalDate;

/**
 * Abstract class representing a workout.
 * This class should be extended by specific types of workouts.
 */
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
    protected LocalDate workoutDate = null;
    /**
     * The type of the workout.
     */
    protected String workoutType = null;
    /**
     * The duration of the workout.
     */
    protected String workoutDuration = null;
    /**
     * The number of calories burned during the workout.
     */
    protected short burnedCalories = 0;
    /**
     * The number of exercises performed during the workout.
     */
    protected byte countOfExercises = 0;


    // Getters and setters

    public LocalDate getWorkoutDate() {
        return workoutDate;
    }

    public void setWorkoutDate(LocalDate workoutDate) {
        this.workoutDate = workoutDate;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }


    public void setWorkoutDuration(String workoutDuration) {
        this.workoutDuration = workoutDuration;
    }

    public short getBurnedCalories() {
        return burnedCalories;
    }

    public void setBurnedCalories(short burnedCalories) {
        this.burnedCalories = burnedCalories;
    }

    public byte getCountOfExercises() {
        return countOfExercises;
    }

    public void setCountOfExercises(byte countOfExercises) {
        this.countOfExercises = countOfExercises;
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