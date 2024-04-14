package com.trainingdiary.domain;

import com.trainingdiary.adapters.in.InputManager;
import com.trainingdiary.adapters.out.OutputManager;

/**
 * Represents a yoga workout.
 */
public class Yoga extends Workout
{

    /**
     * The number of asana performed during the workout.
     */
    private int numberOfAsanaPerformed;

    /**
     * Sets the number of asana performed during the workout.
     *
     * @param numberOfAsanaPerformed The number of asanas performed.
     */
    public void setNumberOfAsanaPerformed(int numberOfAsanaPerformed) {
        this.numberOfAsanaPerformed = numberOfAsanaPerformed;
    }

    /**
     * Constructor for the Yoga class.
     * Sets the workout type to "Yoga".
     */
    public Yoga() {
        this.setWorkoutType("Yoga");
    }

    /**
     * Gathers information about the workout from the user.
     */
    @Override
    public void gatherWorkoutInfo() {
        OutputManager.print("Введите количество асанов: ");
        int asanaCount = InputManager.readInt();
        InputManager.readString();
        this.setNumberOfAsanaPerformed(asanaCount);
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
                "\n Общее количество асанов: " + numberOfAsanaPerformed;
    }

    public int getNumberOfAsanaPerformed() {
        return numberOfAsanaPerformed;
    }
}
