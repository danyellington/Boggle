package com.example.guest.bogglesolitare;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Random;



public class BoggleAdapter extends BaseAdapter{
    String[] allLetters;

    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Object getItem(int position) {
        String letter = mLetters[position];
        String vowel = mVowels[position];
        return String.format("%s", letter);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            // get layout from xml file
            gridView = inflater.inflate(R.layout.alphabet_grid_item, null);


            // pull views
            TextView letterView = (TextView) gridView
                    .findViewById(R.id.grid_item_letter);

            // set values into views
            int rnd = new Random().nextInt(mLetters.length);
            int rnd2 = new Random().nextInt(mVowels.length);
            String[] eightLetters = {mLetters[rnd], mLetters[rnd], mVowels[rnd2], mLetters[rnd], mLetters[rnd],
                    mLetters[rnd], mLetters[rnd], mVowels[rnd2]};

            letterView.setText(eightLetters[position]);
            letterView.setTypeface(mTypeface);


        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }

    private Context mContext;
    private String[] mLetters;
    private String[] mVowels;
    private Typeface mTypeface;


    public BoggleAdapter (Context context, String[] letters, String[] vowels, Typeface typeface) {
        this.mContext = context;
        this.mLetters = letters;
        this.mVowels = vowels;
        this.mTypeface = typeface;
    }


}
