package com.bastau.app.ui.auth;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bastau.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class RegisterActivity extends MvpAppCompatActivity implements RegisterView {

    @InjectPresenter
    RegisterPresenter presenter;

    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.repeat_password)
    EditText repeatPassword;
    @BindView(R.id.login)
    EditText login;
    @BindView(R.id.instagram)
    EditText instagram;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        unbinder = ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void registration() {
        if (phone.getText().toString().equals("")) {
            Snackbar.make(password, "Введите номер телефона", Snackbar.LENGTH_LONG).show();
        } else if (password.getText().toString().equals("")) {
            Snackbar.make(password, "Введите пароль", Snackbar.LENGTH_LONG).show();
        } else if (repeatPassword.getText().toString().equals("")) {
            Snackbar.make(password, "Введите пароль повторно", Snackbar.LENGTH_LONG).show();
        } else if (login.getText().toString().equals("")) {
            Snackbar.make(password, "Введите логин", Snackbar.LENGTH_LONG).show();
        } else if (instagram.getText().toString().equals("")) {
            Snackbar.make(password, "Введите логин инстаграма", Snackbar.LENGTH_LONG).show();
        } else {
            presenter.registration(phone.getText().toString(),
                    password.getText().toString(),
                    repeatPassword.getText().toString(),
                    login.getText().toString(),
                    instagram.getText().toString());
        }
    }
}
