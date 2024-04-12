package com.trainingdiary.service.functionalservice;

import java.time.LocalDate;

public abstract class Workout {
    public abstract void gatherWorkoutInfo();

    // Тут мне нужно будет прописать общие методы для типов тренировок, чтобы в будущем было легче добавить новый тип тренировки
    // Также нужно будет создать классы для каждого типа тренировки, которые implements этот интерфейс
    protected LocalDate workoutDate = null;
    protected String workoutType = null;
    protected String workoutDuration = null;
    protected short burnedCalories = 0;
    protected byte countOfExercises = 0;

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


    @Override
    public String toString() {
        return  "\n Дата тренировки: " + workoutDate +
                "\n Тип тренировки: " + workoutType +
                "\n Длительность тренировки: " + workoutDuration +
                "\n Сожжённые калории: " + burnedCalories +
                "\n Количество упражнений: " + countOfExercises;
    }
}