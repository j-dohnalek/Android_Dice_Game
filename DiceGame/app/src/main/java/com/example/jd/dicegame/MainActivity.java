package com.example.jd.dicegame;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;



public class MainActivity extends AppCompatActivity {

    /**
     * Track the score of player 1
     */
    private int player1TotalScore = 0;

    /**
     * Track the score of player 2
     */
    private int player2TotalScore = 0;

    /**
     * Track the throws of player 1
     */
    private int player1Throws = 0;

    /**
     * Track the throws of player 2
     */
    private int player2Throws = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button next = (Button) findViewById(R.id.go_to_rules);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), RulesActivity.class);
                startActivityForResult(myIntent, 0);
            }

        });

    }



    /**
     * Player 1 throws dice
     */
    public void player1RoleDice(View view){
        player1Throws++;

        ImageView dice1 = (ImageView)findViewById(R.id.dice1);
        int die1 = rollingDice(dice1);

        ImageView dice2 = (ImageView)findViewById(R.id.dice2);
        int die2 = rollingDice(dice2);

        ImageView dice3 = (ImageView)findViewById(R.id.dice3);
        int die3 = rollingDice(dice3);

        ThreeDice game = new ThreeDice(die1, die2, die3);

        int currentThrow = game.getScore();
        player1TotalScore += currentThrow;

        TextView resultThrow = (TextView) findViewById(R.id.throw_result);
        resultThrow.setText(game.getResult());

        TextView totalThrows = (TextView) findViewById(R.id.player_1_throws);
        totalThrows.setText(Integer.toString(player1Throws));

        TextView player1throw = (TextView) findViewById(R.id.player_1_current_throw_points);
        player1throw.setText(Integer.toString(currentThrow));

        TextView player1score = (TextView) findViewById(R.id.player_1_total_score);
        player1score.setText(Integer.toString(player1TotalScore));
    }


    /**
     * Player 2 throws dice
     */
    public void player2RoleDice(View view){
        player2Throws++;

        ImageView dice1 = (ImageView)findViewById(R.id.dice1);
        int die1 = rollingDice(dice1);

        ImageView dice2 = (ImageView)findViewById(R.id.dice2);
        int die2 = rollingDice(dice2);

        ImageView dice3 = (ImageView)findViewById(R.id.dice3);
        int die3 = rollingDice(dice3);

        ThreeDice game = new ThreeDice(die1, die2, die3);

        int currentThrow = game.getScore();
        player2TotalScore += currentThrow;

        TextView resultThrow = (TextView) findViewById(R.id.throw_result);
        resultThrow.setText(game.getResult());

        TextView totalThrows = (TextView) findViewById(R.id.player_2_throws);
        totalThrows.setText(Integer.toString(player2Throws));


        TextView player1throw = (TextView) findViewById(R.id.player_2_current_throw_points);
        player1throw.setText(Integer.toString(currentThrow));

        TextView player1score = (TextView) findViewById(R.id.player_2_total_score);
        player1score.setText(Integer.toString(player2TotalScore));
    }


    /**
     * Reset the game
     */
    public void resetGame(View view){

        TextView resultThrow = (TextView) findViewById(R.id.throw_result);

        if(player1TotalScore > player2TotalScore){
            resultThrow.setText("The winner is Player 1");
        }
        else if(player1TotalScore < player2TotalScore){
            resultThrow.setText("The winner is Player 2");
        }
        else{
            resultThrow.setText("There was a draw");
        }

        player1TotalScore = 0;
        player2TotalScore = 0;

        player1Throws = 0;
        player2Throws = 0;


        // Player 1

        TextView player1TotalThrows = (TextView) findViewById(R.id.player_1_throws);
        player1TotalThrows.setText("0");

        TextView player1throw = (TextView) findViewById(R.id.player_1_current_throw_points);
        player1throw.setText("0");

        TextView player1score = (TextView) findViewById(R.id.player_1_total_score);
        player1score.setText("0");

        // Player 2

        TextView player2TotalThrows = (TextView) findViewById(R.id.player_2_throws);
        player2TotalThrows.setText("0");

        TextView player2throw = (TextView) findViewById(R.id.player_2_current_throw_points);
        player2throw.setText("0");

        TextView player2score = (TextView) findViewById(R.id.player_2_total_score);
        player2score.setText("0");

        ImageView dice1 = (ImageView)findViewById(R.id.dice1);
        dice1.setImageResource(R.drawable.blank);
        ImageView dice2 = (ImageView)findViewById(R.id.dice2);
        dice2.setImageResource(R.drawable.blank);
        ImageView dice3 = (ImageView)findViewById(R.id.dice3);
        dice3.setImageResource(R.drawable.blank);

    }


    /**
     * Select random dice
     */
    private int rollingDice(ImageView dice){
        Random rand = new Random();
        int  diceSide = rand.nextInt(6) + 1;
        switch(diceSide){
            case 1:
                dice.setImageResource(R.drawable.side1);
                return 1;
            case 2:
                dice.setImageResource(R.drawable.side2);
                return 2;
            case 3:
                dice.setImageResource(R.drawable.side3);
                return 3;
            case 4:
                dice.setImageResource(R.drawable.side4);
                return 4;
            case 5:
                dice.setImageResource(R.drawable.side5);
                return 5;
            case 6:
                dice.setImageResource(R.drawable.side6);
                return 6;
        }
        return 0;
    }
}
