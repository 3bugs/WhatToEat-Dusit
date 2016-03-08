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

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] foodArray = new String[]{
            "ข้าวผัด", "ข้าวไข่เจียว", "ข้าวหน้าเป็ด",
            "ข้าวมันไก่", "ข้าวหมูแดง", "ราดหน้า",
            "ผัดซีอิ๊ว", "ผัดไทย", "ส้มตำไก่ย่าง"
    };

    int[] foodPictureArray = new int[]{
            R.drawable.kao_pad, R.drawable.kao_kai_jeaw, R.drawable.kao_na_ped,
            R.drawable.kao_mun_kai, R.drawable.kao_moo_dang, R.drawable.rad_na,
            R.drawable.pad_sie_eew, R.drawable.pad_thai, R.drawable.som_tum_kai_yang
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
                int randomFoodPicture = foodPictureArray[randomIndex];

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                // เข้าถึงตัว Inflater ของระบบ Android
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                // ทำการ inflate layout ให้เป็น object
                View layout = inflater.inflate(R.layout.dialog_food, null);

                // อ้างอิงไปยัง ImageView (แสดงภาพอาหาร) ใน layout
                ImageView dishImageView = (ImageView) layout.findViewById(R.id.dish_image_view);
                dishImageView.setImageResource(randomFoodPicture);

                // อ้างอิงไปยัง TextView (แสดงชื่ออาหาร) ใน layout
                TextView dishNameTextView = (TextView) layout.findViewById(R.id.dish_name_text_view);
                dishNameTextView.setText(randomFood);

                dialog.setView(layout);
                dialog.show();
            }
        });
    }
}
