package com.example.whattoeat.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.whattoeat.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Promlert on 3/9/2016.
 */
public class FoodMenu {

    private ArrayList<Food> foodList = new ArrayList<>();

    private Context context;
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public FoodMenu(Context context) {
/*
        foodList.add(new Food("ข้าวผัด", R.drawable.kao_pad));
        foodList.add(new Food("ข้าวมันไก่", R.drawable.kao_mun_kai));
        foodList.add(new Food("ข้าวหน้าเป็ด", R.drawable.kao_na_ped));
        foodList.add(new Food("ราดหน้า", R.drawable.rad_na));
        foodList.add(new Food("ผัดซีอิ๊ว", R.drawable.pad_sie_eew));
        foodList.add(new Food("ผัดไทย", R.drawable.pad_thai));
        foodList.add(new Food("ข้าวไข่เจียว", R.drawable.kao_kai_jeaw));
        foodList.add(new Food("ข้าวหมูแดง", R.drawable.kao_moo_dang));
        foodList.add(new Food("ส้มตำไก่ย่าง", R.drawable.som_tum_kai_yang));
*/
        this.context = context;
        this.dbHelper = new DatabaseHelper(context);
        this.database = this.dbHelper.getWritableDatabase();

        loadFromDatabase();
    }

    private void loadFromDatabase() {
        foodList.clear();

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex(DatabaseHelper.COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME));
            String fileName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_FILENAME));

            Food f = new Food(name, fileName);
            foodList.add(f);
        }

        cursor.close();
    }

    public Food getRandomFood() {
        Random r = new Random();
        int randomIndex = r.nextInt(foodList.size());
        Food f = foodList.get(randomIndex);
        return f;
    }
}
