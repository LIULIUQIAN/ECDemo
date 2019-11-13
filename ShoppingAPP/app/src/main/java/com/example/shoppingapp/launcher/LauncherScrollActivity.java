package com.example.shoppingapp.launcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.shoppingapp.R;

import java.util.ArrayList;

public class LauncherScrollActivity extends AppCompatActivity implements OnItemClickListener {

    private ConvenientBanner convenientBanner;
    private static final ArrayList<Integer> localImages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher_scroll);
        initView();
    }

    private void initView() {

        convenientBanner = findViewById(R.id.convenientBanner);
        localImages.add(R.mipmap.launcher_01);
        localImages.add(R.mipmap.launcher_02);
        localImages.add(R.mipmap.launcher_03);
        localImages.add(R.mipmap.launcher_04);
        localImages.add(R.mipmap.launcher_05);

        convenientBanner.setPages(new LauncherHolderCreator(), localImages)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        System.out.println("==============" + position);
    }
}
