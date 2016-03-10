package com.example.whattoeat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whattoeat.model.Food;
import com.example.whattoeat.model.FoodMenu;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    /*
        String[] foodArray = new String[]{
                "ข้าวผัด", "ข้าวมันไก่", "ข้าวหน้าเป็ด",
                "ราดหน้า", "ผัดซีอิ๊ว", "ผัดไทย",
                "ข้าวไข่เจียว", "ข้าวหมูแดง", "ส้มตำไก่ย่าง"
        };

        int[] foodPictureArray = new int[]{
                R.drawable.kao_pad, R.drawable.kao_mun_kai, R.drawable.kao_na_ped,
                R.drawable.rad_na, R.drawable.pad_sie_eew, R.drawable.pad_thai,
                R.drawable.kao_kai_jeaw, R.drawable.kao_moo_dang, R.drawable.som_tum_kai_yang
        };
    */
    //Food[] foodMenu = new Food[9];

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FoodMenu foodMenu = new FoodMenu(this);

        Button randomButton = (Button) findViewById(R.id.random_button);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Food f = foodMenu.getRandomFood();
                String randomFood = f.name;
                String randomFoodPicture = f.picture;

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View layout = inflater.inflate(R.layout.dialog_food, null);

                // อ้างอิงไปยัง ImageView ที่แสดงรูปอาหาร
                ImageView foodImageView = (ImageView) layout.findViewById(R.id.food_image_view);
                // อ้างอิงไปยัง TextView ที่แสดงชื่ออาหาร
                TextView foodNameTextView = (TextView) layout.findViewById(R.id.food_name_text_view);

                // กำหนดรูปอาหารที่สุ่มได้
                foodImageView.setImageDrawable(getDrawableFromAssets(randomFoodPicture));
                // กำหนดชื่ออาหารที่สุ่มได้
                foodNameTextView.setText(randomFood);

                dialog.setView(layout);
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

    public Drawable getDrawableFromAssets(String fileName) {
        AssetManager am = getAssets();
        InputStream stream = null;

        try {
            stream = am.open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "Error opening image file: " + fileName);
        }

        Drawable image = Drawable.createFromStream(stream, null);
        return image;
    }
}
