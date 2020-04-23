package com.olezhko.lpmldemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;

public class MealActivity extends AppCompatActivity {

    protected BottomNavigationView navigation;
    private TextView mealName;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                Intent mainActivityIntent = new Intent(MealActivity.this, MainActivity.class);
                startActivity(mainActivityIntent);
                return true;
            case R.id.navigation_add_meal:
                Intent addActivityIntent = new Intent(MealActivity.this, AddActivity.class);
                startActivity(addActivityIntent);
                return true;
            case R.id.navigation_my_meal:
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_my_meal);

        Bundle incomingIntentBundle = getIntent().getExtras();
        if (incomingIntentBundle != null) {
            String mealData = incomingIntentBundle.getString("mealData");
            mealName = findViewById(R.id.my_meal_name);
            mealName.setText(mealData);
        }


//        Cafe incomingCafe = (Cafe) getIntent().getSerializableExtra("mealData");
//        if (incomingCafe != null) {
//            mealName = findViewById(R.id.my_meal_name);
//            mealName.setText(incomingCafe.getName());
//        }
    }
}
