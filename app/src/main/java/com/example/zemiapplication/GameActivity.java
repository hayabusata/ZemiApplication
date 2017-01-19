package com.example.zemiapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import static android.R.attr.button;
import static android.graphics.Color.RED;
import static com.example.zemiapplication.Poker.numToColor;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    //private MyApp myApp;
    private Button button;
    private TextView textView;
    private TextView myHand1, myHand2, myHand3, myHand4, myHand5;
    private TextView yourHand1, yourHand2, yourHand3, yourHand4, yourHand5;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;
    Poker myHand;
    Poker yourHand;
    MyApp myApp;
    int myResult, yourResult;
    boolean[] check; //= new boolean[yourHand.getHandLength()];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        myApp = (MyApp)getApplication();
        myApp.getLevel();
        /*TextView textView = (TextView)findViewById(R.id.test);
        textView.setText(String.format("%d", myApp.getLevel()));*/

        button = (Button)findViewById(R.id.gameButton);
        button.setOnClickListener(this);

        textView = (TextView)findViewById(R.id.gameText);

        myHand1 = (TextView)findViewById(R.id.myHand1);
        myHand2 = (TextView)findViewById(R.id.myHand2);
        myHand3 = (TextView)findViewById(R.id.myHand3);
        myHand4 = (TextView)findViewById(R.id.myHand4);
        myHand5 = (TextView)findViewById(R.id.myHand5);
        yourHand1 = (TextView)findViewById(R.id.yourHand1);
        yourHand2 = (TextView)findViewById(R.id.yourHand2);
        yourHand3 = (TextView)findViewById(R.id.yourHand3);
        yourHand4 = (TextView)findViewById(R.id.yourHand4);
        yourHand5 = (TextView)findViewById(R.id.yourHand5);

        checkBox1 = (CheckBox)findViewById(R.id.check1);
        checkBox2 = (CheckBox)findViewById(R.id.check2);
        checkBox3 = (CheckBox)findViewById(R.id.check3);
        checkBox4 = (CheckBox)findViewById(R.id.check4);
        checkBox5 = (CheckBox)findViewById(R.id.check5);

    }

    public void onClick(View v) {
        if (button.getText().equals("start")) {
            this.setGame();
        } else if (button.getText().equals("change")) {
            boolean[] myCheck = {checkBox1.isChecked(), checkBox2.isChecked(), checkBox3.isChecked(), checkBox4.isChecked(), checkBox5.isChecked()};
            myHand.changeHand(myCheck);

            check = yourHand.decideChangedCard(myApp.getLevel());
            yourHand.changeHand(check);

            myHand1.setText(String.format("%d", myHand.getHand(1)));
            myHand1.setBackgroundColor(numToColor(myHand.getHand(1)));
            myHand2.setText(String.format("%d", myHand.getHand(2)));
            myHand2.setBackgroundColor(numToColor(myHand.getHand(2)));
            myHand3.setText(String.format("%d", myHand.getHand(3)));
            myHand3.setBackgroundColor(numToColor(myHand.getHand(3)));
            myHand4.setText(String.format("%d", myHand.getHand(4)));
            myHand4.setBackgroundColor(numToColor(myHand.getHand(4)));
            myHand5.setText(String.format("%d", myHand.getHand(5)));
            myHand5.setBackgroundColor(numToColor(myHand.getHand(5)));

            yourHand1.setText(String.format("%d", yourHand.getHand(1)));
            yourHand1.setBackgroundColor(numToColor(yourHand.getHand(1)));
            yourHand2.setText(String.format("%d", yourHand.getHand(2)));
            yourHand2.setBackgroundColor(numToColor(yourHand.getHand(2)));
            yourHand3.setText(String.format("%d", yourHand.getHand(3)));
            yourHand3.setBackgroundColor(numToColor(yourHand.getHand(3)));
            yourHand4.setText(String.format("%d", yourHand.getHand(4)));
            yourHand4.setBackgroundColor(numToColor(yourHand.getHand(4)));
            yourHand5.setText(String.format("%d", yourHand.getHand(5)));
            yourHand5.setBackgroundColor(numToColor(yourHand.getHand(5)));

            myResult = myHand.checkPrize();
            yourResult = yourHand.checkPrize();
            textView.setText(String.format("あなた:%s 相手:%s %s．"
                    , myHand.getPrizeString(myResult), yourHand.getPrizeString(yourResult), Poker.getWinner(myResult, yourResult)));

            button.setText("retry");
        } else if (button.getText().equals("retry")) {
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
            checkBox5.setChecked(false);

            setGame();
        }
    }

    public void setGame() {
        myHand = new Poker(5);
        yourHand = new Poker(5);

        myHand1.setText(String.format("%d", myHand.getHand(1)));
        myHand1.setBackgroundColor(numToColor(myHand.getHand(1)));
        myHand2.setText(String.format("%d", myHand.getHand(2)));
        myHand2.setBackgroundColor(numToColor(myHand.getHand(2)));
        myHand3.setText(String.format("%d", myHand.getHand(3)));
        myHand3.setBackgroundColor(numToColor(myHand.getHand(3)));
        myHand4.setText(String.format("%d", myHand.getHand(4)));
        myHand4.setBackgroundColor(numToColor(myHand.getHand(4)));
        myHand5.setText(String.format("%d", myHand.getHand(5)));
        myHand5.setBackgroundColor(numToColor(myHand.getHand(5)));

        yourHand1.setText(String.format("%d", yourHand.getHand(1)));
        yourHand1.setBackgroundColor(numToColor(yourHand.getHand(1)));
        yourHand2.setText(String.format("%d", yourHand.getHand(2)));
        yourHand2.setBackgroundColor(numToColor(yourHand.getHand(2)));
        yourHand3.setText(String.format("%d", yourHand.getHand(3)));
        yourHand3.setBackgroundColor(numToColor(yourHand.getHand(3)));
        yourHand4.setText(String.format("%d", yourHand.getHand(4)));
        yourHand4.setBackgroundColor(numToColor(yourHand.getHand(4)));
        yourHand5.setText(String.format("%d", yourHand.getHand(5)));
        yourHand5.setBackgroundColor(numToColor(yourHand.getHand(5)));

        textView.setText("入れ替えるカードを選択してください．");
        button.setText("change");
    }
}
