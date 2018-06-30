

package com.example.prate.otheleo;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    LinearLayout rootLayout;
    Mbutton board[][];
    public static int currentplayer;
    public static int oppositeplayer;
    public final static int player_white = 1;
    public final static int player_black = 2;
    public final static int player_no = -1;
    ArrayList<LinearLayout> row_layout;
    int row = 8;
    int col = 8;
    boolean current_status;
    int x[]={-1,-1,-1,0,1,1,1,0};
    int y[]={-1,0,1,1,1,0,-1,-1};

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootLayout = findViewById(R.id.root);

        setupBoard();

        board[3][3].setValue(player_white);
        board[4][4].setValue(player_white);
        board[3][3].setbutton();
        board[4][4].setbutton();

        board[3][4].setValue(player_black);
        board[3][4].setbutton();

        board[4][3].setValue(player_black);
        board[4][3].setbutton();


    }

    @SuppressLint("NewApi")
    public void setupBoard() {
        rootLayout.removeAllViews();
        row_layout = new ArrayList<>();

        current_status = true;
        currentplayer = player_white;
        oppositeplayer = player_black;
        for (int i = 0; i < row; i++) {
            LinearLayout linearLayout = new LinearLayout(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setLayoutParams(params);
            rootLayout.addView(linearLayout);
            row_layout.add(linearLayout);


        }

        board = new Mbutton[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Mbutton button = new Mbutton(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
                button.setLayoutParams(params);
                button.i = i;
                button.j = j;

                button.setValue(player_no);
                board[i][j] = button;
                LinearLayout xc = row_layout.get(i);

                button.setBackground(getDrawable(R.drawable.no_button_player));
                xc.addView(button);
                button.setOnClickListener(this);

            }
        }


    }

    @Override
    public void onClick(View view) {
        Mbutton button = (Mbutton) view;
        if (current_status) {

            if (checkneighbour(button)) {
                button.setValue(currentplayer);
                button.setbutton();
                button.setEnabled(false);

                checkAtend(button.i,button.j);
                toggle();


                }

            }

        }

  public void toggle(){
        if(currentplayer==player_white){
            currentplayer=player_black;
            oppositeplayer=player_white;
        }
        if(currentplayer==player_black){
            currentplayer=player_white;
            oppositeplayer=player_black;
        }
  }

    public boolean checkneighbour(Mbutton button) {
        for(int k=0;k<8;k++){
           int xi=button.i +x[k];
            int yi=button.j+y[k];
            if(xi>=0 && xi<row && yi>=0 && yi<col && board[xi][yi].getValue()==oppositeplayer && board[xi][yi].getValue()!=player_no && board[xi][yi].getValue()!=currentplayer){
                return true;
            }
        }
        return false;
    }
    public void checkAtend(int i,int j){

        for(int k=0;k<8;k++){
            int xi=i+x[k];
           int yj=j+y[k];
            if(xi>=0 && yj>=0 && xi<row && yj<col && board[xi][yj].getValue()==oppositeplayer ) {
                if (recursiongotoend(xi, yj, k)) {
                    board[xi][yj].setValue(currentplayer);
                    board[xi][yj].setbutton();
                    board[xi][yj].setEnabled(false);

                }
            }
        }

    }
    public boolean recursiongotoend(int i,int j,int k ){
        if(i<=0 && j<=0 && i>row &&j>col && board[i][j].getValue()==player_no) {
            return false;
        }
        if(board[i][j].getValue()==currentplayer ) {
            board[i - x[k]][j - y[k]].setValue(currentplayer);
            board[i - x[k]][j - y[k]].setbutton();

            return true;
        }

        return recursiongotoend(i+x[k],j+y[k],k);
    }

}


