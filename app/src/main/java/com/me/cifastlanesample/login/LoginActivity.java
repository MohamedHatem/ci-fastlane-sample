package com.me.cifastlanesample.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.me.cifastlanesample.MainActivity;
import com.me.cifastlanesample.R;
import com.me.cifastlanesample.databinding.LoginActivityBinding;

import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class LoginActivity extends AppCompatActivity {

	private final CompositeDisposable disposables = new CompositeDisposable();
	private LoginViewModel viewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LoginActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.login_activity);
		viewModel = new LoginViewModel();
		binding.setViewModel(viewModel);
		binding.loginAction.setOnClickListener(v -> onLoginCLick());

		ButterKnife.bind(this);
	}

	@Override
	protected void onDestroy() {
		disposables.clear();
		super.onDestroy();
	}

	private void openMainActivity() {
		Intent openMain = new Intent(this, MainActivity.class);

		openMain.putExtra("username", viewModel.username.get());

		startActivity(openMain);
		finish();
	}

	private void onLoginCLick() {
		disposables.add(viewModel.doLogin()
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(this::onLoginSuccess, this::onLoginError));
	}

	private void onLoginSuccess() {
		openMainActivity();
	}

	private void onLoginError(Throwable throwable) {
	}

}
