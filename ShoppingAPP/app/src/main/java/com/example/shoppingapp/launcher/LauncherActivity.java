package com.example.shoppingapp.launcher;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lattecore.R2;
import com.example.lattecore.util.storage.LattePreference;
import com.example.lattecore.util.timer.BaseTimerTask;
import com.example.lattecore.util.timer.ITimerListener;
import com.example.shoppingapp.MainActivity;
import com.example.shoppingapp.R;
import com.example.shoppingapp.sign.SignInActivity;


import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LauncherActivity extends AppCompatActivity implements ITimerListener {

    private static final String HAS_FIRST_LAUNCHER_APP = "HAS_FIRST_LAUNCHER_APP";

    @BindView(R.id.tv_launcher_timer)
    TextView mTvTimer;

    private Timer mTime = null;
    private int mCount = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initTimer();
    }

    private void initTimer(){
        mTime = new Timer();
        BaseTimerTask task = new BaseTimerTask(this);
        mTime.schedule(task,0,1000);
    }

    @OnClick(R.id.tv_launcher_timer)
    void onClickTimerView(){

        checkIsShowScroll();
    }


    @Override
    public void onTimer() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTvTimer.setText(MessageFormat.format("跳过\n{0}s",mCount));
                mCount--;
                if (mCount < 0){
                    checkIsShowScroll();
                }
            }
        });

    }

    //判断是否显示滑动启动页
    private void checkIsShowScroll(){
        if (mTime != null){
            mTime.cancel();
            mTime = null;
        }

        if (!LattePreference.getAppFlag(HAS_FIRST_LAUNCHER_APP)){
            Intent intent = new Intent(this,LauncherScrollActivity.class);
            startActivity(intent);
            LattePreference.setAppFlag(HAS_FIRST_LAUNCHER_APP,true);
        }else {
//            Intent intent = new Intent(this, MainActivity.class);
//            startActivity(intent);

            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        }



    }
}
