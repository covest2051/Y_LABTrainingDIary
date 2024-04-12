package com.trainingdiary.service.userservice;

import com.trainingdiary.service.applicationservice.InterfaceService;
import com.trainingdiary.service.functionalservice.Workout;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public abstract class User {
    protected String username;
    protected String password;
    protected Map<LocalDate, Map<String, Workout>> individualWorkoutsList = new TreeMap<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addWorkout(Workout workout) {
        LocalDate workoutDate = workout.getWorkoutDate();
        String workoutType = workout.getWorkoutType();

        if (!individualWorkoutsList.containsKey(workoutDate)) {
            individualWorkoutsList.put(workoutDate, new HashMap<>());
        }

        if (individualWorkoutsList.get(workoutDate).containsKey(workoutType)) {
            throw new RuntimeException("Уже есть тренировка этого типа на эту дату");
        }

        individualWorkoutsList.get(workoutDate).put(workoutType, workout);
    }

    public boolean hasWorkoutToday(String workoutType) {
        LocalDate today = LocalDate.now();
        return individualWorkoutsList.containsKey(today) && individualWorkoutsList.get(today).containsKey(workoutType);
    }

    public String getPassword() {
        return password;
    }

    public void viewWorkoutHistory() {
        for (Map.Entry<LocalDate, Map<String, Workout>> entry : individualWorkoutsList.entrySet()) {
            com.trainingdiary.out.OutputManager.print("Дата: " + entry.getKey());
            for (Workout workout : entry.getValue().values()) {
                com.trainingdiary.out.OutputManager.print("Тренировка: " + workout);
            }
        }

        com.trainingdiary.out.OutputManager.print("1. Удалить тренировку\n2. Редактировать тренировку\n3. Вернуться назад");
        byte choice = com.trainingdiary.in.InputManager.readByte();
        com.trainingdiary.in.InputManager.readString();
        switch (choice) {
            case 1:
                com.trainingdiary.out.OutputManager.print("Введите дату тренировки, которую хотите удалить (в формате ГГГГ-ММ-ДД):");
                String date = new Scanner(System.in).nextLine();
                LocalDate workoutDate = LocalDate.parse(date);
                com.trainingdiary.out.OutputManager.print("Введите тип тренировки, которую хотите удалить:");
                String workoutType = new Scanner(System.in).nextLine();
                deleteWorkout(workoutDate, workoutType);
                break;
            case 2:
                com.trainingdiary.out.OutputManager.print("Введите дату тренировки, которую хотите редактировать (в формате ГГГГ-ММ-ДД):");
                date = new Scanner(System.in).nextLine();
                workoutDate = LocalDate.parse(date);
                com.trainingdiary.out.OutputManager.print("Введите тип тренировки, которую хотите редактировать:");
                workoutType = new Scanner(System.in).nextLine();
                editWorkout(workoutDate, workoutType);
                break;
            case 3:
                InterfaceService.showRegularUserMenu();
                break;
            default:
                com.trainingdiary.out.OutputManager.print("Выбрано неверное значение");
                System.exit(0);
        }
    }


    public void viewWorkoutStatistics() {
        int totalCaloriesBurned = 0;
        for (Map<String, Workout> workouts : individualWorkoutsList.values()) {
            for (Workout workout : workouts.values()) {
                totalCaloriesBurned += workout.getBurnedCalories();
            }
        }
        com.trainingdiary.out.OutputManager.print("Общее количество сожженных калорий: " + totalCaloriesBurned);
    }

    public void deleteWorkout(LocalDate date, String workoutType) {
        if (individualWorkoutsList.containsKey(date) && individualWorkoutsList.get(date).containsKey(workoutType)) {
            individualWorkoutsList.get(date).remove(workoutType);
            com.trainingdiary.out.OutputManager.print("Тренировка успешно удалена");
        } else {
            com.trainingdiary.out.OutputManager.print("Тренировка не найдена");
        }
    }

    public void editWorkout(LocalDate date, String workoutType) {
        if (individualWorkoutsList.containsKey(date) && individualWorkoutsList.get(date).containsKey(workoutType)) {
            Workout workout = individualWorkoutsList.get(date).get(workoutType);
            com.trainingdiary.out.OutputManager.print("Введите новое количество упражнений: ");
            byte countOfExercises = new Scanner(System.in).nextByte();
            workout.setCountOfExercises(countOfExercises);
            // здесь вы можете добавить больше полей для редактирования
            com.trainingdiary.out.OutputManager.print("Тренировка успешно отредактирована");
        } else {
            com.trainingdiary.out.OutputManager.print("Тренировка не найдена");
        }
    }

    public Map<LocalDate, Map<String, Workout>> getIndividualWorkoutsList() {
        return individualWorkoutsList;
    }

    public String getUsername() {
        return username;
    }
}