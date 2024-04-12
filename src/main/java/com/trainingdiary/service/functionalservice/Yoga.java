package com.trainingdiary.service.functionalservice;

public class Yoga extends Workout {
    private int numberOfAsanaPerformed;

    public void setNumberOfAsanaPerformed(int numberOfAsanaPerformed) {
        this.numberOfAsanaPerformed = numberOfAsanaPerformed;
    }

    public Yoga() {
        this.setWorkoutType("Yoga");
    }

    @Override
    public void gatherWorkoutInfo() {
        com.trainingdiary.out.OutputManager.print("Введите количество асанов: ");
        int asanaCount = com.trainingdiary.in.InputManager.readInt();
        com.trainingdiary.in.InputManager.readString();
        this.setNumberOfAsanaPerformed(asanaCount);
    }

    @Override
    public String toString() {
        return  "\nДата тренировки: " + workoutDate +
                "\n Тип тренировки: " + workoutType +
                "\n Длительность тренировки: " + workoutDuration +
                "\n Сожжённые калории: " + burnedCalories +
                "\n Количество упражнений: " + countOfExercises +
                "\n Общее количество асанов: " + numberOfAsanaPerformed;
    }
}
