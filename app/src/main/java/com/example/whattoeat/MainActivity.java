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

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Food> mFoodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Food f = new Food("ข้าวผัด", R.drawable.kao_pad);
        mFoodList.add(f);

        f = new Food("ข้าวไข่เจียว", R.drawable.kao_kai_jeaw);
        mFoodList.add(f);

        f = new Food("ข้าวหน้าเป็ด", R.drawable.kao_na_ped);
        mFoodList.add(f);

        f = new Food("ข้าวมันไก่", R.drawable.kao_mun_kai);
        mFoodList.add(f);

        f = new Food("ข้าวหมูแดง", R.drawable.kao_moo_dang);
        mFoodList.add(f);

        f = new Food("ราดหน้า", R.drawable.rad_na);
        mFoodList.add(f);

        f = new Food("ผัดซีอิ๊ว", R.drawable.pad_sie_eew);
        mFoodList.add(f);

        f = new Food("ผัดไทย", R.drawable.pad_thai);
        mFoodList.add(f);

        f = new Food("ส้มตำไก่ย่าง", R.drawable.som_tum_kai_yang);
        mFoodList.add(f);

        Button randomButton = (Button) findViewById(R.id.random_button);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int randomIndex = r.nextInt(mFoodList.size());
                Food randomFood = mFoodList.get(randomIndex);

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
