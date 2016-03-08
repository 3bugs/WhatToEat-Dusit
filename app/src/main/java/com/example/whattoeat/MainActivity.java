package com.example.whattoeat;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] foodArray = new String[]{
        "ข้าวผัด", "ข้าวมันไก่", "ข้าวหน้าเป็ด",
        "ราดหน้า", "ผัดซีอิ๊ว", "ผัดไทย"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button randomButton = (Button) findViewById(R.id.random_button);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int randomIndex = r.nextInt(foodArray.length);
                String randomFood = foodArray[randomIndex];

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("What To Eat");
                dialog.setMessage("You may want to eat: " + randomFood);
                dialog.show();

                Toast t = Toast.makeText(
                        getApplicationContext(),
                        randomFood,
                        Toast.LENGTH_SHORT
                );
                t.show();
            }
        });
    }
}
