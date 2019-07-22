package com.me.cifastlanesample;


import androidx.test.runner.AndroidJUnit4;

import com.me.cifastlanesample.login.LoginFixture;

import org.junit.Test;
import org.junit.runner.RunWith;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends BaseTest {

	@Test
	public void thatUsernameIsShown_whenLoginWasSuccessful() {
		// given
		LoginFixture loginFixture = new LoginFixture();
		String expectedUsername = loginFixture.getUsername();

		// when
		loginFixture.load();

		// then
		onView(withId(R.id.username)).check(matches(withText(expectedUsername)));
	}
}
