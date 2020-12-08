package com.example.mechcubie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Button firstfrag,secondfrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstfrag=findViewById(R.id.btn_first);
        secondfrag=findViewById(R.id.btn_second);
        loadfrag(new FirstFragment());

        firstfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadfrag(new FirstFragment());
                firstfrag.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple));
                secondfrag.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.color_blue));

            }
        });
        secondfrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadfrag(new SecondFragment());

                secondfrag.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.purple));
                firstfrag.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.color_blue));
            }
        });
    }
    private void loadfrag(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame,fragment);
        fragmentTransaction.commit();

    }
}