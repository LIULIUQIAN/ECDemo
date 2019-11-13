package com.example.shoppingapp.launcher;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lattecore.R2;
import com.example.shoppingapp.R;

import butterknife.BindView;

public class LauncherActivity extends AppCompatActivity {

//    @BindView(R2.id.tv_launcher_timer)
    TextView mTvTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
