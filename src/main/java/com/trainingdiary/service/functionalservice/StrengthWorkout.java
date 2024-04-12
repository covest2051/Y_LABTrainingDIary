package com.trainingdiary.service.functionalservice;

public class StrengthWorkout extends Workout {
    private int totalWeightLifted;

    @Override
    public void gatherWorkoutInfo() {
        com.trainingdiary.out.OutputManager.print("Введите общий поднятый вес: ");
        int totalWeightLifted = com.trainingdiary.in.InputManager.readInt();
        com.trainingdiary.in.InputManager.readString();
        this.setTotalWeightLifted(totalWeightLifted);
    }

    public StrengthWorkout() {
        this.setWorkoutType("Strength");
    }


    public void setTotalWeightLifted(int totalWeightLifted) {
        this.totalWeightLifted = totalWeightLifted;
    }

    @Override
    public String toString() {
        return  "\nДата тренировки: " + workoutDate +
                "\n Тип тренировки: " + workoutType +
                "\n Длительность тренировки: " + workoutDuration +
                "\n Сожжённые калории: " + burnedCalories +
                "\n Количество упражнений: " + countOfExercises +
                "\n Общий поднятый вес: " + totalWeightLifted;
    }

}
