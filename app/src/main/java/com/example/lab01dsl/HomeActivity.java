package com.example.lab01dsl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // initialize and assign variable
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationViewHome);

        // set the item selected listener of BottomNavigation items
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // By using switch we can easily get
                // the selected fragment
                // by using there id.
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.firstFragment:
                        selectedFragment = new FirstFragment();
                        break;
                    case R.id.secondFragment:
                        selectedFragment = new SecondFragment();
                        break;
                    case R.id.thirdFragment:
                        selectedFragment = new ThirdFragment();
                        break;
                }
                // It will help to replace the
                // one fragment to other.
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainerView, selectedFragment)
                        .commit();
                return true;
            }
        });
    }
}