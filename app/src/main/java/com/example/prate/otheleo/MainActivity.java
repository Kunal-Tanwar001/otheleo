

package com.example.prate.otheleo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
 LinearLayout rootLayout;
    public static final int row=8;
    public static final int col=8;
    ArrayList<LinearLayout> rows;
    Mbutton[][] board;
    boolean currentstatus;
     int current_playerW=0;
    int current_playerB=1;
    int currentopposite;
    int no_player=-1;
    int x[]={-1,-1,-1,0,1,1,1,0};
    int y[]={-1,0,1,1,1,0,-1,-1};
    int currentplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout=findViewById(R.id.root);
        setupBoard();
    }
    public void setupBoard() {
         rootLayout.removeAllViews();
         rows=new ArrayList<>();
         currentstatus=true;
         currentplayer=current_playerB;
         currentopposite=current_playerW
        for(int i=0;i<row;i++){
            LinearLayout linearLayout=new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,0,1);
            linearLayout.setLayoutParams(params);
            rootLayout.addView(linearLayout);
            rows.add(linearLayout);

        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                Mbutton button =new Mbutton(MainActivity.this);
                LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1);
                button.setLayoutParams(params);
                LinearLayout extralayout=rows.get(i);
                extralayout.addView(button);
                board[i][j]=button;
                button.revealed=false;
                button.i=i;
                button.j=j;

                button.setValue(no_player);
                button.setOnClickListener(this);

            }
        }
           setuppeices();

    }


    @Override
    public void onClick(View view) {
        Mbutton button=(Mbutton)view;
        if(currentstatus ){
          checking checked=checkneighbour(button,button.i,button.j,int currenplayer);
        }
    }
    public void getneighbour(int i,int j,Mbutton button,){

    }
    public checking  checkneighbour(Mbutton button,int i,int j,int current){
        for(int k=0;k<8;k++){
            int q=i+x[k];
            int w=j+y[k];
            if(q>=0 && q<row && w>=0 && w<col){
                if(!board[q][w].revealed && board[q][w].getValue()==current) {

                }
            }
        }

    }
    public void setuppeices(){

    }
}
