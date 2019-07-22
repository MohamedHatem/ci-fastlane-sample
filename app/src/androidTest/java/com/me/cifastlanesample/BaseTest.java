package com.me.cifastlanesample;


import androidx.test.rule.ActivityTestRule;

import com.me.cifastlanesample.login.LoginActivity;

import org.junit.Rule;


public class BaseTest {

	@Rule
	public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class);
}
