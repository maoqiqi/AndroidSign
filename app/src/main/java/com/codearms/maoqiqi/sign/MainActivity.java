package com.codearms.maoqiqi.sign;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.about);
        setSupportActionBar(toolbar);

        TextView tvInfo = findViewById(R.id.tv_info);
        TextView tvFunctionIntroduction = findViewById(R.id.tv_function_introduction);
        TextView tvCheckUpdate = findViewById(R.id.tv_check_update);
        TextView tvUpdateDescription = findViewById(R.id.tv_update_description);
        TextView tvStar = findViewById(R.id.tv_star);

        StringBuilder builder = new StringBuilder();
        builder.append("BuildConfig.LOG_DEBUG = " + BuildConfig.LOG_DEBUG + "\n");

        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            builder.append("当前版本号:").append(packageInfo.versionCode).append("\n");
            builder.append("当前版本名称:").append(packageInfo.versionName).append("\n");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        builder.append("当前包名:").append(getPackageName()).append("\n");
        tvInfo.setText(builder.toString());

        tvFunctionIntroduction.setOnClickListener(this);
        tvCheckUpdate.setOnClickListener(this);
        tvUpdateDescription.setOnClickListener(this);
        tvStar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this, getPackageName(), Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}