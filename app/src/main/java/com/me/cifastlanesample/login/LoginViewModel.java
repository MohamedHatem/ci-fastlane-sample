package com.me.cifastlanesample.login;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;

import io.reactivex.Completable;

public class LoginViewModel extends BaseObservable {

	public final ObservableBoolean isErrorShown = new ObservableBoolean(false);

	public final ObservableField<String> username = new ObservableField<>();
	public final ObservableField<String> password = new ObservableField<>();

	public Completable doLogin() {
		return Completable.fromAction(() -> {
			if (!("foo".equals(username.get()) && "bar".equals(password.get()))) {
				isErrorShown.set(true);
				throw new BadCredentialsException();
			}
		});
	}
}
