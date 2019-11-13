package com.example.shoppingapp.sign;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.lattecore.net.RestClient;
import com.example.lattecore.net.callback.IError;
import com.example.lattecore.net.callback.ISuccess;
import com.example.lattecore.util.desUtil.DESUtil;
import com.example.shoppingapp.Contants.Contants;
import com.example.shoppingapp.R;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity {

    @BindView(R.id.edit_phone)
    TextInputEditText editPhoen;

    @BindView(R.id.edit_password)
    TextInputEditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    @OnClick(R.id.btn_sign_in)
    void onSignIn() {

        String phone = editPhoen.getText().toString().trim();
        String pwd = editPassword.getText().toString().trim();

        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "请输入手机号码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        RestClient.builder()
                .url(Contants.API.LOGIN)
                .params("phone", phone)
                .params("password", DESUtil.encode(Contants.DES_KEY, pwd))
                .loader(this)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        System.out.println("response===" + response);
                    }
                })
                .build().post();

    }

    @OnClick(R.id.tv_link_sign_up)
    void onSignUp() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

}
