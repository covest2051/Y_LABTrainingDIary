package com.trainingdiary.service.functionalservice;

/**
 * Represents a cardio workout.
 */
public class CardioWorkout extends Workout {
    /**
     * The distance covered during the workout.
     */
    private int distanceCovered;

    /**
     * Constructor for the CardioWorkout class.
     * Sets the workout type to "Cardio".
     */
    public CardioWorkout() {
        this.setWorkoutType("Cardio");
    }

    /**
     * Gathers information about the workout from the user.
     */
    @Override
    public void gatherWorkoutInfo() {
        com.trainingdiary.out.OutputManager.print("Введите пройденное расстояние: ");
        int distanceCovered = com.trainingdiary.in.InputManager.readInt();
        com.trainingdiary.in.InputManager.readString();
        this.setDistanceCovered(distanceCovered);
    }

    /**
     * Sets the distance covered during the workout.
     *
     * @param distanceCovered The distance covered.
     */
    public void setDistanceCovered(int distanceCovered) {
        this.distanceCovered = distanceCovered;
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
                "\n Общее пройденное расстояние: " + distanceCovered;
    }

}
