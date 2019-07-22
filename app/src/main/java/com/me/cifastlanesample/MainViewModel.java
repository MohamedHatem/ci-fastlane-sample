package com.me.cifastlanesample;

import androidx.databinding.BaseObservable;

public class MainViewModel extends BaseObservable {

	private String name;

	public MainViewModel(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
