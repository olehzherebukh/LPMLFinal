package com.olezhko.lpmldemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    protected BottomNavigationView navigation;
    private EditText mealNameEditText;
    private Button addButton;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                Intent mainActivityIntent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(mainActivityIntent);
                return true;
            case R.id.navigation_add_meal:
                return true;
            case R.id.navigation_my_meal:
                Intent mealActivityIntent = new Intent(AddActivity.this, MealActivity.class);
                startActivity(mealActivityIntent);
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_add_meal);

        mealNameEditText = findViewById(R.id.meal_name);
        addButton = findViewById(R.id.add_meal);



        addButton.setOnClickListener(v -> {
            String mealName = mealNameEditText.getText().toString();
            Intent mealIntent = new Intent(AddActivity.this, MealActivity.class);
            Bundle args = new Bundle();
            args.putString("mealData", mealName);
            mealIntent.putExtras(args);
            startActivity(mealIntent);

            
//            Cafe myCafe = new Cafe("Starbucks", "Lodia", R.drawable.cafe);
//            Intent mealIntent = new Intent(AddActivity.this, MealActivity.class);
//            Bundle args = new Bundle();
//            args.putSerializable("mealData", myCafe);
//            mealIntent.putExtras(args);
//            startActivity(mealIntent);
        });
    }
}
