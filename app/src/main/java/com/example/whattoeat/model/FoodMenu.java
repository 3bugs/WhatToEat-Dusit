package com.example.whattoeat.model;

import com.example.whattoeat.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Promlert on 3/9/2016.
 */
public class FoodMenu {

    private ArrayList<Food> mFoodList = new ArrayList<>();

    public FoodMenu() {
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
    }

    public Food getRandomFood() {
        Random r = new Random();
        int randomIndex = r.nextInt(mFoodList.size());
        Food randomFood = mFoodList.get(randomIndex);
        return randomFood;
    }
}
