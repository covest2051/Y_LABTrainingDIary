
package com.trainingdiary.service.applicationservice;


import com.trainingdiary.service.functionalservice.CardioWorkout;
import com.trainingdiary.service.functionalservice.StrengthWorkout;
import com.trainingdiary.service.functionalservice.Workout;
import com.trainingdiary.service.functionalservice.Yoga;
import com.trainingdiary.service.userservice.Admin;
import com.trainingdiary.service.userservice.UserSession;


import static com.trainingdiary.service.applicationservice.WorkoutService.*;

public class InterfaceService {

    public static void showRegularUserMenu() {
        com.trainingdiary.out.OutputManager.print("""
                1. Начать тренировку
                2. История тренировок
                3. Статистика тренировок
                4. Выйти из аккаунта""");
        byte choice = com.trainingdiary.in.InputManager.readByte();
        com.trainingdiary.in.InputManager.readString();
        switch (choice) {
            case 1:
                showStartWorkoutMenu();
                break;
            case 2:
                UserSession.getCurrentUser().viewWorkoutHistory();
                com.trainingdiary.out.OutputManager.print("Чтобы вернуться в меню нажмите Enter");
                com.trainingdiary.in.InputManager.readString();
                showRegularUserMenu();
                break;
            case 3:
                UserSession.getCurrentUser().viewWorkoutStatistics();
                com.trainingdiary.out.OutputManager.print("Чтобы вернуться в меню нажмите Enter");
                com.trainingdiary.in.InputManager.readString();
                showRegularUserMenu();
                break;
            case 4:

        }
    }
    public static void showAdminMenu() {
        com.trainingdiary.out.OutputManager.print("""
                1. Просмотреть тренировки пользователя
                2. Просмотреть аудит действий пользователя
                3. Выйти из аккаунта""");
        byte choice = com.trainingdiary.in.InputManager.readByte();
        com.trainingdiary.in.InputManager.readString();
        switch (choice) {
            case 1:
                com.trainingdiary.out.OutputManager.print("Введите логин пользователя:");
                String username = com.trainingdiary.in.InputManager.readString();
                if (UserSession.getCurrentUser() instanceof Admin) {
                    ((Admin) UserSession.getCurrentUser()).viewUserWorkouts(username);
                }
                showAdminMenu();
                break;
            case 2:
                com.trainingdiary.out.OutputManager.print("Введите логин пользователя:");
                username = com.trainingdiary.in.InputManager.readString();
                if (UserSession.getCurrentUser() instanceof Admin) {
                    ((Admin) UserSession.getCurrentUser()).viewUserAuditLog(username);
                }
                showAdminMenu();
                break;
            case 3:

                InterfaceService.showRegularUserMenu();
                break;
            default:
                com.trainingdiary.out.OutputManager.print("Выбрано неверное значение");
                System.exit(0);
        }
    }



    public static void showStartWorkoutMenu() {
        com.trainingdiary.out.OutputManager.print("Выберите тип тренировки");
        showWorkoutTypes();
        int choice = com.trainingdiary.in.InputManager.readInt();
        com.trainingdiary.in.InputManager.readString();
        Workout workout = createWorkout(choice);
        if (workout != null) {
            String workoutType = workout.getWorkoutType();
            startWorkoutIfNotDoneToday(workout, workoutType);
        } else {
            com.trainingdiary.out.OutputManager.print("Введено неверное значение");
            showStartWorkoutMenu();
        }
    }

    public static Workout createWorkout(int choice) {
        switch (choice) {
            case 1:
                return new CardioWorkout();
            case 2:
                return new StrengthWorkout();
            case 3:
                return new Yoga();
            default:
                return null;
        }
    }


    public static void startWorkoutIfNotDoneToday(Workout workout, String workoutType) {
        if (UserSession.getCurrentUser().hasWorkoutToday(workoutType)) {
            com.trainingdiary.out.OutputManager.print("У вас уже была тренировка данного типа сегодня");
            showRegularUserMenu();
        } else {
            startWorkout(workout);
        }
    }

    static void showWorkoutTypes() {
        com.trainingdiary.out.OutputManager.print("""
                Выберите тип тренировки
                1. Кардио
                2. Силовая тренировка
                3. Йога
                """);
    }
}
