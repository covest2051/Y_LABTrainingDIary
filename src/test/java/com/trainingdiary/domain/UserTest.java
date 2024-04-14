package com.trainingdiary.domain;

import com.trainingdiary.domain.User;
import com.trainingdiary.domain.Workout;
import org.junit.Assert;
import org.testng.annotations.Test;

public class UserTest {
    @Test
    public void testAddWorkout() {
        // Создайте экземпляр класса User
        User user = new RegularUser("testUser", "testPassword");

        // Создайте экземпляр класса Workout
        Workout workout = new Yoga();

        // Добавьте тренировку
        user.addWorkout(workout);

        // Проверьте, была ли тренировка добавлена правильно
        Assert.assertTrue(user.getIndividualWorkoutsList().containsValue(workout));
    }
}
