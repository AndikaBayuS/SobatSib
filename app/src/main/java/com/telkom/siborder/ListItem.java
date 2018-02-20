package com.telkom.siborder;

import android.content.Intent;

/**
 * Created by Andika Bayu Santoso on 15/02/2018.
 */

public class ListItem {
    private String mText1;
    private String mText2;
    private Intent mTxt1;

    public ListItem(String text1, String text2) {
        mText1 = text1;
        mText2 = text2;
    }

    public void Open (Intent intent1){
        mTxt1 = intent1;
    }

    public String getText1() {
        return mText1;
    }
    public String getText2() {
        return mText2;
    }
}
