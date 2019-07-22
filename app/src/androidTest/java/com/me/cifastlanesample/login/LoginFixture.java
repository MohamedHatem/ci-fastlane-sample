package com.me.cifastlanesample.login;

import androidx.test.espresso.ViewInteraction;


import com.me.cifastlanesample.R;
import com.me.cifastlanesample.common.Fixture;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

public class LoginFixture implements Fixture {

	private String username = "foo";
	private String password = "bar";

	public LoginFixture() {
	}

	public LoginFixture(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public void load() {
		ViewInteraction usernameInput = onView(
				allOf(
						withId(R.id.username),
						isDisplayed()
				));
		ViewInteraction passwordInput = onView(
				allOf(
						withId(R.id.password),
						isDisplayed()
				));
		ViewInteraction loginButton = onView(
				allOf(
						withId(R.id.login_action),
						isDisplayed()
				));

		usernameInput.perform(replaceText(username));
		passwordInput.perform(replaceText(password));
		loginButton.perform(click());
	}

	public String getUsername() {
		return username;
	}
}
