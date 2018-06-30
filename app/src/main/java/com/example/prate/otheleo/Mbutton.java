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
        if(this.getValue()==MainActivity.player_white){
            this.setText("●");
           this.setTextColor(Color.parseColor("white"));

            this.setTextSize(65);

        }
        if(this.getValue()==MainActivity.player_black){
            this.setText("●");
           this.setTextColor(Color.parseColor("black"));

            this.setTextSize(65);



        }

    }
}
