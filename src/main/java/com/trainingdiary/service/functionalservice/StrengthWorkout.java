package com.trainingdiary.service.functionalservice;

/**
 * Represents a strength workout.
 */
public class StrengthWorkout extends Workout {
    /**
     * The total weight lifted during the workout.
     */
    private int totalWeightLifted;

    /**
     * Gathers information about the workout from the user.
     */
    @Override
    public void gatherWorkoutInfo() {
        com.trainingdiary.out.OutputManager.print("Введите общий поднятый вес: ");
        int totalWeightLifted = com.trainingdiary.in.InputManager.readInt();
        com.trainingdiary.in.InputManager.readString();
        this.setTotalWeightLifted(totalWeightLifted);
    }

    /**
     * Constructor for the StrengthWorkout class.
     * Sets the workout type to "Strength".
     */
    public StrengthWorkout() {
        this.setWorkoutType("Strength");
    }


    /**
     * Sets the total weight lifted during the workout.
     *
     * @param totalWeightLifted The total weight lifted.
     */
    public void setTotalWeightLifted(int totalWeightLifted) {
        this.totalWeightLifted = totalWeightLifted;
    }

    /**
     * Returns a string representation of the workout.
     *
     * @return A string representation of the workout.
     */
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
