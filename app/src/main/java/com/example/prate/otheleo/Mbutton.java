package com.example.prate.otheleo;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.view.Gravity;

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

    public void setbutton(){
        if(value==MainActivity.player_white){
            setText("●");
            setTextColor(Color.parseColor("white"));

            setTextSize(65);

        }
        if(value==MainActivity.player_black){
            setText("●");
            setTextColor(Color.parseColor("black"));

            setTextSize(65);



        }

    }
}
