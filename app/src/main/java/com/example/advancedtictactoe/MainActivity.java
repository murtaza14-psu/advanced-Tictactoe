package com.example.advancedtictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declaring views
    TextView player1, player2;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    int flag = 0, count = 0;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Finding views by id
        player1 = findViewById(R.id.player_one);
        player2 = findViewById(R.id.player_two);
        btn1 = findViewById(R.id.box1);
        btn2 = findViewById(R.id.box2);
        btn3 = findViewById(R.id.box3);
        btn4 = findViewById(R.id.box4);
        btn5 = findViewById(R.id.box5);
        btn6 = findViewById(R.id.box6);
        btn7 = findViewById(R.id.box7);
        btn8 = findViewById(R.id.box8);
        btn9 = findViewById(R.id.box9);

        // Receiving info from the first activity
        Intent intent = getIntent();
        String player1_name = intent.getStringExtra("player1Name");
        String player2_name = intent.getStringExtra("player2Name");

        player1.setText(player1_name + "\nX");
        player2.setText(player2_name + "\nO");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Method for all buttons
    public void check(View view) {
        Button buttonCurr = (Button) view;

        if (buttonCurr.getText().toString().isEmpty()) {

            // To alternatively print X and O
            if (flag == 0) {
                buttonCurr.setTextColor(getResources().getColor(R.color.red_cross));
                buttonCurr.setText("X");
                count++;
                flag = 1;
            } else {
                buttonCurr.setTextColor(getResources().getColor(R.color.grey_circle));
                buttonCurr.setText("O");
                count++;
                flag = 0;
            }

            // To check for the winner
            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                String winner = null;

                // Condition for rows
                if (b1.equals(b2) && b2.equals(b3) && !b1.isEmpty()) {
                    winner = flag == 1 ? player2.getText().toString() : player1.getText().toString();
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.isEmpty()) {
                    winner = flag == 1 ? player2.getText().toString() : player1.getText().toString();
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.isEmpty()) {
                    winner = flag == 1 ? player2.getText().toString() : player1.getText().toString();
                }
                // Condition for columns
                else if (b1.equals(b4) && b4.equals(b7) && !b1.isEmpty()) {
                    winner = flag == 1 ? player2.getText().toString() : player1.getText().toString();
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.isEmpty()) {
                    winner = flag == 1 ? player2.getText().toString() : player1.getText().toString();
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.isEmpty()) {
                    winner = flag == 1 ? player2.getText().toString() : player1.getText().toString();
                }
                // Condition for diagonals
                else if (b1.equals(b5) && b5.equals(b9) && !b1.isEmpty()) {
                    winner = flag == 1 ? player2.getText().toString() : player1.getText().toString();
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.isEmpty()) {
                    winner = flag == 1 ? player2.getText().toString() : player1.getText().toString();
                } else if (count == 9) {
                    winner = "Draw";
                }

                if (winner != null) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("winner", winner);
                    startActivity(intent);
                }
            }
        }
    }
}
