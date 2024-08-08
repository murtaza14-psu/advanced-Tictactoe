package com.example.advancedtictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_players);

        //finding views by id
        EditText player1, player2;
        Button play;
        player1=findViewById(R.id.player_one_name);
        player2 = findViewById(R.id.player_two_name);
        play = findViewById(R.id.start_button);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //receiving values from edit texts
                String player1_name_get = player1.getText().toString();
                String player2_name_get = player2.getText().toString();

                //conditional to catch empty fields
                if(player1_name_get.isEmpty() || player2_name_get.isEmpty()){

                    Toast.makeText(AddPlayers.this, "Please Enter player names", Toast.LENGTH_SHORT).show();

                }else {

                    //sharing data to the 2nd activity(main activity)
                    Intent intent = new Intent(AddPlayers.this, MainActivity.class);
                    intent.putExtra("player1Name", player1_name_get);
                    intent.putExtra("player2Name", player2_name_get);
                    startActivity(intent);

                }

            }



        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.relative_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



    }
}