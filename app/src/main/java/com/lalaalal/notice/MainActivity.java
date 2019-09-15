package com.lalaalal.notice;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lalaalal.notice.ui.SectionsPagerAdapter;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
            ViewPager viewPager = findViewById(R.id.view_pager);
            viewPager.setAdapter(sectionsPagerAdapter);

            TabLayout tabs = findViewById(R.id.tabs);
            tabs.setupWithViewPager(viewPager);

            final Intent intent = new Intent(this, SettingActivity.class);

            Button settingBtn = findViewById(R.id.setting_btn);
            settingBtn.setOnClickListener((v) -> startActivity(intent));
        } catch (SQLException e) {
            Log.d("SQLException", e.getSQLState());
            Toast.makeText(this, "SQLException", Toast.LENGTH_SHORT).show();
            // TODO: make dialog and quit app
        } catch (ClassNotFoundException e) {
            Toast.makeText(this, "ClassNotFound", Toast.LENGTH_SHORT).show();
        }

    }
}
