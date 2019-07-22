package com.me.cifastlanesample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.me.cifastlanesample.databinding.MainActivityBinding;


public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String username = getIntent().getStringExtra("username");

		MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
		MainViewModel viewModel = new MainViewModel(username);
		binding.setViewModel(viewModel);
	}
}
