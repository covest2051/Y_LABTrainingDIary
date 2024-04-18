package com.trainingdiary.domain;

import com.trainingdiary.adapters.in.InputManager;
import com.trainingdiary.adapters.out.OutputManager;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a strength workout.
 */
@Setter
@Getter
public class StrengthWorkout extends Workout
{
    /**
     * The total weight lifted during the workout.
     * -- SETTER --
     *  Sets the total weight lifted during the workout.
     *

     */
    private int totalWeightLifted;

    /**
     * Gathers information about the workout from the user.
     */
    @Override
    public void gatherWorkoutInfo() {
        OutputManager.print("Введите общий поднятый вес: ");
        int totalWeightLifted = InputManager.readInt();
        InputManager.readString();
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
