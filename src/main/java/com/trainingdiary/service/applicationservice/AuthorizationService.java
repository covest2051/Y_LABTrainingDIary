package com.trainingdiary.service.applicationservice;

import com.trainingdiary.service.userservice.Admin;
import com.trainingdiary.service.userservice.RegularUser;
import com.trainingdiary.service.userservice.User;
import com.trainingdiary.service.userservice.UserSession;


import java.util.HashMap;
import java.util.Map;

/**
 * Handles user registration and login.
 */
public class AuthorizationService {
    /**
     * Stores registered users.
     */
    private final Map<String, User> users = new HashMap<>();
    private static final int MIN_USERNAME_LENGTH = 6;
    private static final int MIN_PASSWORD_LENGTH = 6;

    /**
     * Registers a new user.
     *
     * @return UserSession for the registered user, or null if registration failed.
     */
    public UserSession register() {
        com.trainingdiary.out.OutputManager.print("Введите имя пользователя:");
        String username = com.trainingdiary.in.InputManager.readString();
        if (username.length() < MIN_USERNAME_LENGTH) {
            com.trainingdiary.out.OutputManager.print("Имя пользователя должно содержать минимум " + MIN_USERNAME_LENGTH + " символов.");
            return null;
        }

        com.trainingdiary.out.OutputManager.print("Введите пароль:");
        String password = com.trainingdiary.in.InputManager.readString();
        if (password.length() < MIN_PASSWORD_LENGTH) {
            com.trainingdiary.out.OutputManager.print("Пароль должен содержать минимум " + MIN_PASSWORD_LENGTH + " символов.");
            return null;
        }

        com.trainingdiary.out.OutputManager.print("Введите тип пользователя (admin или regular):");
        String userType = com.trainingdiary.in.InputManager.readString();

        if (users.containsKey(username)) {
            com.trainingdiary.out.OutputManager.print("Пользователь с таким логином уже существует");
            return null;
        }

        User user;
        if ("admin".equals(userType)) {
            user = new Admin(username, password, this);
        } else {
            user = new RegularUser(username, password);
        }

        users.put(username, user);
        return new UserSession(user, this, new WorkoutService());
    }

    /**
     * Logs in a user.
     *
     * @return UserSession for the logged-in user, or null if login failed.
     */
    public UserSession login() {
        com.trainingdiary.out.OutputManager.print("Введите имя пользователя:");
        String username = com.trainingdiary.in.InputManager.readString();
        com.trainingdiary.out.OutputManager.print("Введите пароль:");
        String password = com.trainingdiary.in.InputManager.readString();

        User user = users.get(username);
        if (user == null || !user.getPassword().equals(password)) {
            com.trainingdiary.out.OutputManager.print("Неверное имя пользователя или пароль");
            return null;
        }
        return new UserSession(user, this, new WorkoutService());
    }

    /**
     * Retrieves a User by username.
     *
     * @param username The username of the User.
     * @return The User with the given username.
     */
    public User getUserByUsername(String username) {
        return users.get(username);
    }
}