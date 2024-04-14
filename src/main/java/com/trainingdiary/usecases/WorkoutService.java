package com.trainingdiary.usecases;
import com.trainingdiary.adapters.in.InputManager;
import com.trainingdiary.adapters.out.OutputManager;
import com.trainingdiary.domain.Workout;
import com.trainingdiary.service.applicationservice.InterfaceService;
import com.trainingdiary.service.userservice.UserSession;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Random;

public class WorkoutService {

    /**
     * Starts a workout and adds it to the current user's workout list.
     *
     * @param workoutType The type of workout to start.
     */
    public static void startWorkout(Workout workoutType) {
        Instant now = Instant.now();
        OutputManager.print("Тренировка началась. Нажмите Enter когда закончите");
        InputManager.readString();
        Instant end = Instant.now();

        // Заполнение данных о тренировке
        workoutType.setWorkoutDate(LocalDate.now());

        Duration duration = Duration.between(now, end);
        long minutes = duration.toMinutes();
        long seconds = duration.minusMinutes(minutes).getSeconds();
        String durationString = String.format("%d:%02d", minutes, seconds);

        workoutType.setWorkoutDuration(durationString); // предполагая, что setWorkoutDuration принимает строку

        // Добавление тренировки в список тренировок пользователя
        UserSession.getCurrentUser().addWorkout(workoutType);

        showResults(workoutType, now, end);
        OutputManager.print("Чтобы вернуться в главное меню нажмите Enter ");
        InputManager.readString();
        InterfaceService.showRegularUserMenu();
    }

    /**
     * Displays the results of a workout.
     *
     * @param workoutType The type of workout.
     * @param now The start time of the workout.
     * @param end The end time of the workout.
     */
    public static void showResults(Workout workoutType, Instant now, Instant end) {
        Duration duration = Duration.between(now, end);
        long minutes = duration.toMinutes();
        long seconds = duration.minusMinutes(minutes).getSeconds();
        String durationString = String.format("%d:%02d", minutes, seconds);

        workoutType.setWorkoutDuration(durationString);

        Random rand = new Random();
        int burnedCalories = rand.nextInt(601) + 200;

        workoutType.setBurnedCalories((short) burnedCalories);
        OutputManager.print("Введите количество выполненных упражнений: ");
        byte countOfExercises = InputManager.readByte();
        InputManager.readString();
        workoutType.setCountOfExercises(countOfExercises);

        workoutType.gatherWorkoutInfo();




        OutputManager.print(workoutType.toString());
    }

}