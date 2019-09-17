package com.example.battleship;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String CLICK_COUNT_INDEX = "click_count_index";

    private TextView mClickCounter;
    private TextView mAppTitleView;
    private ImageButton mIconButton;
    private int mClicks = 0;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(CLICK_COUNT_INDEX, mClicks);
    }

    private void restoreState(Bundle savedInstanceState) {
        mClicks = savedInstanceState.getInt(CLICK_COUNT_INDEX);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) restoreState(savedInstanceState);
        setContentView(R.layout.activity_main);
        mClickCounter = findViewById(R.id.click_counter);
        mAppTitleView = findViewById(R.id.app_title);
        mAppTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Welcome to battleship!", Toast.LENGTH_SHORT).show();
            }
        });
        updateCounterText();
        mIconButton = findViewById(R.id.icon_button);
        mIconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++mClicks;
                updateCounterText();
            }
        });
    }

    private void updateCounterText() {
        mClickCounter.setText(mClicks + " Clicks!");
    }
}
