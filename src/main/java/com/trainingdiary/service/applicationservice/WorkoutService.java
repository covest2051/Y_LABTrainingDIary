package com.trainingdiary.service.applicationservice;
import com.trainingdiary.service.functionalservice.Workout;
import com.trainingdiary.service.userservice.UserSession;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class WorkoutService {

    public static void startWorkout(Workout workoutType) {
        Instant now = Instant.now();
        com.trainingdiary.out.OutputManager.print("Тренировка началась. Нажмите Enter когда закончите");
        com.trainingdiary.in.InputManager.readString();
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
        com.trainingdiary.out.OutputManager.print("Чтобы вернуться в главное меню нажмите Enter ");
        com.trainingdiary.in.InputManager.readString();
        InterfaceService.showRegularUserMenu();
    }


    public static void showResults(Workout workoutType, Instant now, Instant end) {
        Duration duration = Duration.between(now, end);
        long minutes = duration.toMinutes();
        long seconds = duration.minusMinutes(minutes).getSeconds();
        String durationString = String.format("%d:%02d", minutes, seconds);

        workoutType.setWorkoutDuration(durationString);

        Random rand = new Random();
        int burnedCalories = rand.nextInt(601) + 200;

        workoutType.setBurnedCalories((short) burnedCalories);
        com.trainingdiary.out.OutputManager.print("Введите количество выполненных упражнений: ");
        byte countOfExercises = com.trainingdiary.in.InputManager.readByte();
        com.trainingdiary.in.InputManager.readString();
        workoutType.setCountOfExercises(countOfExercises);

        workoutType.gatherWorkoutInfo();




        com.trainingdiary.out.OutputManager.print(workoutType.toString());
    }

}