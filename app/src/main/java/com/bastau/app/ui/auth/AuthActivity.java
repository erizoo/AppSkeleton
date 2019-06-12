package com.bastau.app.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bastau.app.R;
import com.bastau.app.data.models.ResponseAuth;
import com.bastau.app.ui.MainActivity;
import com.pixplicity.easyprefs.library.Prefs;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AuthActivity extends MvpAppCompatActivity implements AuthView {

    @InjectPresenter
    AuthPresenter presenter;

    @BindView(R.id.login)
    EditText login;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        unbinder = ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void signIn() {
        if (login.getText().toString().equals("")) {
            Snackbar.make(login, "Введите логин", Snackbar.LENGTH_LONG).show();
        } else if (password.getText().toString().equals("")) {
            Snackbar.make(login, "Введите пароль", Snackbar.LENGTH_LONG).show();
        } else {
            progressBar.setVisibility(View.VISIBLE);
            presenter.singInAuth(login.getText().toString(), password.getText().toString());
        }
    }

    @OnClick(R.id.link)
    public void registration() {
        startActivity(new Intent(this, RegisterActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onLogged(ResponseAuth responseAuth) {
        progressBar.setVisibility(View.GONE);
        if (responseAuth.getOk()) {
            Prefs.putString("LOGIN", login.getText().toString());
            Prefs.putString("PASSWORD", password.getText().toString());
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Snackbar.make(login, "Ошибка авторизации", Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void error(Throwable throwable) {
        progressBar.setVisibility(View.GONE);
        Snackbar.make(login, "Ошибка авторизации", Snackbar.LENGTH_LONG).show();
    }
}
