package com.example.lab7;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void invalidFirstName() {
        String invalidFirstName = "john1";
        String validLastName = "doe";
        String validEmail = "email@email.com";
        String validPassword = "password";

        onView(withId(R.id.editTextFirstName)).perform(typeText(invalidFirstName), closeSoftKeyboard());
        onView(withId(R.id.editTextLastName)).perform(typeText(validLastName), closeSoftKeyboard());
        onView(withId(R.id.editTextEmail)).perform(typeText(validEmail), closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText(validPassword), closeSoftKeyboard());

        onView(withId(R.id.btnSubmit)).perform(click());

        onView(withId(R.id.textViewMessage)).check(matches(withText("Invalid First Name")));
    }

    @Test
    public void invalidLastName() {
        String validFirstName = "john";
        String invalidLastName = "doe1";
        String validEmail = "email@email.com";
        String validPassword = "password";

        onView(withId(R.id.editTextFirstName)).perform(typeText(validFirstName), closeSoftKeyboard());
        onView(withId(R.id.editTextLastName)).perform(typeText(invalidLastName), closeSoftKeyboard());
        onView(withId(R.id.editTextEmail)).perform(typeText(validEmail), closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText(validPassword), closeSoftKeyboard());

        onView(withId(R.id.btnSubmit)).perform(click());

        onView(withId(R.id.textViewMessage)).check(matches(withText("Invalid Last Name")));
    }

    @Test
    public void invalidEmail() {
        String validFirstName = "john";
        String validLastName = "doe";
        String invalidEmail = "test";
        String validPassword = "password";

        onView(withId(R.id.editTextFirstName)).perform(typeText(validFirstName), closeSoftKeyboard());
        onView(withId(R.id.editTextLastName)).perform(typeText(validLastName), closeSoftKeyboard());
        onView(withId(R.id.editTextEmail)).perform(typeText(invalidEmail), closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText(validPassword), closeSoftKeyboard());

        onView(withId(R.id.btnSubmit)).perform(click());

        onView(withId(R.id.textViewMessage)).check(matches(withText("Invalid Email")));
    }

    @Test
    public void invalidPassword() {
        String validFirstName = "john";
        String validLastName = "doe";
        String validEmail = "email@email.com";
        String invalidPassword = "pass";

        onView(withId(R.id.editTextFirstName)).perform(typeText(validFirstName), closeSoftKeyboard());
        onView(withId(R.id.editTextLastName)).perform(typeText(validLastName), closeSoftKeyboard());
        onView(withId(R.id.editTextEmail)).perform(typeText(validEmail), closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText(invalidPassword), closeSoftKeyboard());

        onView(withId(R.id.btnSubmit)).perform(click());

        onView(withId(R.id.textViewMessage)).check(matches(withText("Invalid Password")));
    }

}
