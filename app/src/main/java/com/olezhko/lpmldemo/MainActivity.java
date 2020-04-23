package com.olezhko.lpmldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                return true;
            case R.id.navigation_add_meal:
                Intent addActivityIntent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(addActivityIntent);
                return true;
            case R.id.navigation_my_meal:
                Intent mealActivityIntent = new Intent(MainActivity.this, MealActivity.class);
                startActivity(mealActivityIntent);
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Cafe> cafes = new ArrayList<>();
        cafes.add(new Cafe("McDonalds", "pr. Svobody, 12", R.drawable.burger));
        cafes.add(new Cafe("Kredens", "pr. Svobody, 14", R.drawable.coffee));
        cafes.add(new Cafe("Urban Coffee", "vul. Bandery, 12", R.drawable.coffee));
        cafes.add(new Cafe("Celentano", "vul. Bandery, 30", R.drawable.pizza));

        ListView cafeListView = findViewById(R.id.cafe_list);
        ArrayAdapter cafeAdapter = new CafeAdapter(this, cafes);
        cafeListView.setAdapter(cafeAdapter);
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
    }
}

