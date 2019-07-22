package com.me.cifastlanesample.login;


import androidx.test.runner.AndroidJUnit4;

import com.me.cifastlanesample.BaseTest;
import com.me.cifastlanesample.R;

import org.junit.Test;
import org.junit.runner.RunWith;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class LoginActivityTest extends BaseTest {

	@Test
	public void thatMainActivityIsShown_whenLoginUsingCorrectUsernameAndPassword() {
		// given
		LoginFixture loginFixture = new LoginFixture();

		// when
		loginFixture.load();

		// then
		onView(withId(R.id.activity_main)).check(matches(isDisplayed()));
	}

	@Test
	public void thatErrorIsShown_whenLoginWithInvalidUsernameAndPassword() {
		// given
		LoginFixture loginFixture = new LoginFixture("wrong", "credentials");

		// when
		loginFixture.load();

		// then
		onView(withId(R.id.login_error)).check(matches(isDisplayed()));
	}
}
