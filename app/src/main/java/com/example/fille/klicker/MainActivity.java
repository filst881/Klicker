package com.example.fille.klicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button ButtonClick;
    Button ButtonReset;

    TextView TextCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonClick = (Button)findViewById(R.id.buttonClicker);
        ButtonReset = (Button)findViewById(R.id.buttonReset);

        TextCount = (TextView)findViewById(R.id.textViewCount);

        ButtonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String CountValue = TextCount.getText().toString();

                int intCountValue = Integer.parseInt(CountValue);
                intCountValue++;

                TextCount.setText(String.valueOf(intCountValue));

            }
        });

        ButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextCount.setText(String.valueOf(0));

            }
        });

    }
}
