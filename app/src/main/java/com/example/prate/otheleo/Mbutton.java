package com.example.prate.otheleo;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;

public class Mbutton extends AppCompatButton {
    public boolean revealed;
    private int value;
    int i,j;
    public Mbutton(Context context) {
        super(context);

    }
    public int getValue(){
        return this.value;
    }
    public void setValue(int value){
        this.value=value;
    }



}
