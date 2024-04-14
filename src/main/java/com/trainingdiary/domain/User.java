package com.trainingdiary.domain;

import com.trainingdiary.adapters.in.InputManager;
import com.trainingdiary.adapters.out.OutputManager;
import com.trainingdiary.service.applicationservice.InterfaceService;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Abstract class representing a user.
 * This class should be extended by specific types of users.
 */
public abstract class User {
    protected WorkoutFactory factory;
    private final List<AuditRecord> auditLog = new ArrayList<>();
    /**
     * The username of the user.
     * -- GETTER --
     *  Returns the username of the user.
     *

     */
    @Getter
    protected String username;
    /**
     * The password of the user.
     * -- GETTER --
     *  Returns the user's password.
     *

     */
    @Getter
    protected String password;
    /**
     * The list of workouts performed by the user.
     * -- GETTER --
     *  Returns the user's list of workouts.
     *

     */
    protected Map<LocalDate, Map<String, Workout>> individualWorkoutsList = new TreeMap<>();

    /**
     * Constructor for the User class.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.auditLog.add(new AuditRecord(LocalDateTime.now(), "User created", username));
        this.individualWorkoutsList = new TreeMap<>();
    }

    /**
     * Adds a workout to the user's workout list.
     */
    public Workout addWorkout(WorkoutFactory factory) {
        Workout workout = factory.createWorkout();
        LocalDate workoutDate = workout.getWorkoutDate();
        String workoutType = workout.getWorkoutType();

        if (!individualWorkoutsList.containsKey(workoutDate)) {
            individualWorkoutsList.put(workoutDate, new HashMap<>());
        }

        if (individualWorkoutsList.get(workoutDate).containsKey(workoutType)) {
            OutputManager.print("У вас уже есть тренировка данного типа на эту дату");
            return null; // прекращаем выполнение, если тренировка уже есть
        } else {
            individualWorkoutsList.get(workoutDate).put(workoutType, workout);
        }
        return workout; // возвращаем добавленный объект Workout
    }


    /**
     * Checks if the user has done a workout of the given type today.
     *
     * @param workoutType The type of the workout.
     * @return true if the user has done a workout of the given type today, false otherwise.
     */
    public boolean hasWorkoutToday(String workoutType) {
        LocalDate today = LocalDate.now();
        return individualWorkoutsList.containsKey(today) && individualWorkoutsList.get(today).containsKey(workoutType);
    }

    /**
     * Displays the user's workout history.
     */
    public void viewWorkoutHistory() {
        for (Map.Entry<LocalDate, Map<String, Workout>> entry : individualWorkoutsList.entrySet()) {
            OutputManager.print("Дата: " + entry.getKey());
            for (Workout workout : entry.getValue().values()) {
                OutputManager.print("Тренировка: " + workout);
            }
        }

        OutputManager.print("1. Удалить тренировку\n2. Редактировать тренировку\n3. Вернуться назад");
        byte choice = InputManager.readByte();
        InputManager.readString();
        switch (choice) {
            case 1:
                OutputManager.print("Введите дату тренировки, которую хотите удалить (в формате ГГГГ-ММ-ДД):");
                String date = new Scanner(System.in).nextLine();
                LocalDate workoutDate = LocalDate.parse(date);
                OutputManager.print("Введите тип тренировки, которую хотите удалить:");
                String workoutType = new Scanner(System.in).nextLine();
                deleteWorkout(workoutDate, workoutType);
                break;
            case 2:
                OutputManager.print("Введите дату тренировки, которую хотите редактировать (в формате ГГГГ-ММ-ДД):");
                date = new Scanner(System.in).nextLine();
                workoutDate = LocalDate.parse(date);
                OutputManager.print("Введите тип тренировки, которую хотите редактировать:");
                workoutType = new Scanner(System.in).nextLine();
                editWorkout(workoutDate, workoutType);
                break;
            case 3:
                InterfaceService.showRegularUserMenu();
                break;
            default:
                OutputManager.print("Выбрано неверное значение");
                System.exit(0);
        }
    }

    /**
     * Displays the user's workout statistics.
     */
    public void viewWorkoutStatistics() {
        int totalCaloriesBurned = 0;
        for (Map<String, Workout> workouts : individualWorkoutsList.values()) {
            for (Workout workout : workouts.values()) {
                totalCaloriesBurned += workout.getBurnedCalories();
            }
        }
        OutputManager.print("Общее количество сожженных калорий: " + totalCaloriesBurned);
    }

    /**
     * Deletes a workout from the user's workout list.
     *
     * @param date The date of the workout.
     * @param workoutType The type of the workout.
     */
    public void deleteWorkout(LocalDate date, String workoutType) {
        if (individualWorkoutsList.containsKey(date) && individualWorkoutsList.get(date).containsKey(workoutType)) {
            individualWorkoutsList.get(date).remove(workoutType);
            OutputManager.print("Тренировка успешно удалена");
        } else {
            OutputManager.print("Тренировка не найдена");
        }
    }

    /**
     * Edits a workout in the user's workout list.
     *
     * @param date The date of the workout.
     * @param workoutType The type of the workout.
     */
    public void editWorkout(LocalDate date, String workoutType) {
        if (individualWorkoutsList.containsKey(date) && individualWorkoutsList.get(date).containsKey(workoutType)) {
            Workout workout = individualWorkoutsList.get(date).get(workoutType);
            OutputManager.print("Введите новое количество упражнений: ");
            byte countOfExercises = new Scanner(System.in).nextByte();
            workout.setCountOfExercises(countOfExercises);
            // здесь вы можете добавить больше полей для редактирования
            OutputManager.print("Тренировка успешно отредактирована");
        } else {
            OutputManager.print("Тренировка не найдена");
        }
    }

}