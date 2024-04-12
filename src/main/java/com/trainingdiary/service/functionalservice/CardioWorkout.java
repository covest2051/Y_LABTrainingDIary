package com.trainingdiary.service.functionalservice;

public class CardioWorkout extends Workout {
    private int distanceCovered;

    public CardioWorkout() {
        this.setWorkoutType("Cardio");
    }

    @Override
    public void gatherWorkoutInfo() {
        com.trainingdiary.out.OutputManager.print("Введите пройденное расстояние: ");
        int distanceCovered = com.trainingdiary.in.InputManager.readInt();
        com.trainingdiary.in.InputManager.readString();
        this.setDistanceCovered(distanceCovered);
    }

    public void setDistanceCovered(int distanceCovered) {
        this.distanceCovered = distanceCovered;
    }

    @Override
    public String toString() {
        return  "\nДата тренировки: " + workoutDate +
                "\n Тип тренировки: " + workoutType +
                "\n Длительность тренировки: " + workoutDuration +
                "\n Сожжённые калории: " + burnedCalories +
                "\n Количество упражнений: " + countOfExercises +
                "\n Общее пройденное расстояние: " + distanceCovered;
    }

}
