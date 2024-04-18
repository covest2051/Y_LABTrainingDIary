
package com.trainingdiary.service.applicationservice;


import com.trainingdiary.adapters.in.InputManager;
import com.trainingdiary.adapters.out.OutputManager;
import com.trainingdiary.domain.*;
import com.trainingdiary.service.userservice.UserSession;
import com.trainingdiary.usecases.WorkoutService;
import java.time.Instant;

import static com.trainingdiary.usecases.WorkoutService.*;

/**
 * Provides user interfaces for regular users and admins.
 */
public class InterfaceService {

    /**
     * Displays the menu for regular users.
     */
    public static void showRegularUserMenu() {
        OutputManager.print("""
                1. Начать тренировку
                2. История тренировок
                3. Статистика тренировок
                4. Выйти из аккаунта""");
        byte choice = InputManager.readByte();
        InputManager.readString();
        switch (choice) {
            case 1:
                showStartWorkoutMenu();
                break;
            case 2:
                UserSession.getCurrentUser().viewWorkoutHistory();
                OutputManager.print("Чтобы вернуться в меню нажмите Enter");
                InputManager.readString();
                showRegularUserMenu();
                break;
            case 3:
                UserSession.getCurrentUser().viewWorkoutStatistics();
                OutputManager.print("Чтобы вернуться в меню нажмите Enter");
                InputManager.readString();
                showRegularUserMenu();
                break;
            case 4:

        }
    }

    /**
     * Displays the menu for admin users.
     */
    public static void showAdminMenu() {
        OutputManager.print("""
                1. Просмотреть тренировки пользователя
                2. Просмотреть аудит действий пользователя
                3. Выйти из аккаунта""");
        byte choice = InputManager.readByte();
        InputManager.readString();
        switch (choice) {
            case 1:
                OutputManager.print("Введите логин пользователя:");
                String username = InputManager.readString();
                if (UserSession.getCurrentUser() instanceof Admin) {
                    ((Admin) UserSession.getCurrentUser()).viewUserWorkouts(username);
                }
                showAdminMenu();
                break;
            case 2:
                OutputManager.print("Введите логин пользователя:");
                username = InputManager.readString();
                if (UserSession.getCurrentUser() instanceof Admin) {
                    ((Admin) UserSession.getCurrentUser()).viewUserAuditLog(username);
                }
                showAdminMenu();
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
     * Displays the menu for starting a workout.
     */
    public static void showStartWorkoutMenu() {
        OutputManager.print("Выберите тип тренировки");
        showWorkoutTypes();
        int choice = InputManager.readInt();
        InputManager.readString();
        WorkoutFactory factory = createWorkoutFactory(choice);
        if (factory != null) {
            Workout workout = UserSession.getCurrentUser().addWorkout(factory);

            // Если addWorkout вернул null, возвращаем пользователя в меню
            if (workout == null) {
                showRegularUserMenu();
                return;
            }

            OutputManager.print("Тренировка началась. Нажмите Enter когда закончите");
            Instant start = Instant.now();
            InputManager.readString();
            Instant end = Instant.now();

            // Вызываем метод showResults здесь
            WorkoutService.showResults(workout, start, end);

            OutputManager.print("Тренировка успешно добавлена. Нажмите Enter, чтобы вернуться в меню.");
            InputManager.readString();
            showRegularUserMenu();
        } else {
            OutputManager.print("Введено неверное значение");
            showStartWorkoutMenu();
        }
    }

    public static WorkoutFactory createWorkoutFactory(int choice) {
        return switch (choice) {
            case 1 -> new CardioWorkoutFactory();
            case 2 -> new StrengthWorkoutFactory();
            case 3 -> new YogaWorkoutFactory();
            default -> null;
        };
    }

    /**
     * Creates a new Workout based on the user's choice.
     *
     * @param choice The user's choice of workout type.
     * @return A new Workout of the chosen type, or null if the choice is invalid.
     */
    public static Workout createWorkout(int choice) {
        return switch (choice) {
            case 1 -> new CardioWorkout();
            case 2 -> new StrengthWorkout();
            case 3 -> new Yoga();
            default -> null;
        };
    }

    /**
     * Starts a workout if the user has not done a workout of the same type today.
     *
     * @param workout The workout to start.
     * @param workoutType The type of the workout.
     */
    public static void startWorkoutIfNotDoneToday(Workout workout, String workoutType) {
        if (UserSession.getCurrentUser().hasWorkoutToday(workoutType)) {
            OutputManager.print("У вас уже была тренировка данного типа сегодня");
            showRegularUserMenu();
        } else {
            startWorkout(workout);
        }
    }

    /**
     * Displays the available workout types to the user.
     */
    static void showWorkoutTypes() {
        OutputManager.print("""
                Выберите тип тренировки
                1. Кардио
                2. Силовая тренировка
                3. Йога
                """);
    }
}
