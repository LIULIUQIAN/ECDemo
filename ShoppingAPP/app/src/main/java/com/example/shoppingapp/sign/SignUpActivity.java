package com.example.shoppingapp.sign;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.lattecore.net.RestClient;
import com.example.lattecore.net.callback.ISuccess;
import com.example.lattecore.util.desUtil.DESUtil;
import com.example.shoppingapp.Contants.Contants;
import com.example.shoppingapp.MainActivity;
import com.example.shoppingapp.R;
import com.example.shoppingapp.bean.User;
import com.example.shoppingapp.database.DatabaseManager;
import com.example.shoppingapp.database.UserProfile;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {


    @BindView(R.id.sign_up_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.edit_phone)
    TextInputEditText editPhoen;

    @BindView(R.id.edit_password)
    TextInputEditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    @OnClick(R.id.tv_link_sign_in)
    void onSignIn() {
        finish();
    }

    @OnClick(R.id.btn_sign_up)
    void onSignUp() {

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
                .url(Contants.API.REG)
                .params("phone", phone)
                .params("password", DESUtil.encode(Contants.DES_KEY, pwd))
                .loader(this)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {

                        Gson gson = new Gson();
                        User user = gson.fromJson(response, User.class);
                        Toast.makeText(SignUpActivity.this, user.getData().getUsername(), Toast.LENGTH_SHORT).show();
                        finish();

                    }
                })
                .build().post();

    }


}
