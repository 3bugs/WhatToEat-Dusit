package com.example.whattoeat;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whattoeat.model.Food;
import com.example.whattoeat.model.FoodMenu;

public class MainActivity extends AppCompatActivity {

    FoodMenu mFoodMenu = new FoodMenu();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button randomButton = (Button) findViewById(R.id.random_button);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Food randomFood = mFoodMenu.getRandomFood();

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                // เข้าถึงตัว Inflater ของระบบ Android
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                // ทำการ inflate layout ให้เป็น object
                View layout = inflater.inflate(R.layout.dialog_food, null);

                // อ้างอิงไปยัง ImageView (แสดงภาพอาหาร) ใน layout
                ImageView dishImageView = (ImageView) layout.findViewById(R.id.dish_image_view);
                dishImageView.setImageResource(randomFood.picture);

                // อ้างอิงไปยัง TextView (แสดงชื่ออาหาร) ใน layout
                TextView dishNameTextView = (TextView) layout.findViewById(R.id.dish_name_text_view);
                dishNameTextView.setText(randomFood.name);

                dialog.setView(layout);
                dialog.show();
            }
        });
    }
}
