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

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        // Finding views by id
        TextView result = findViewById(R.id.result);
        Button play_again = findViewById(R.id.play_again_button);

        // Receiving intent
        Intent intent = getIntent();
        String winner = intent.getStringExtra("winner");

        // Setting the result text
        if ("Draw".equals(winner)) {
            result.setText("It's a Draw!!!");
        } else {
            result.setText(winner + " wins!!!!");
        }

        // Handling "Play Again" button click
        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, AddPlayers.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // This clears the previous activities
                startActivity(intent);
                finish(); // Close the resultActivity
            }
        });

        // Handling system bars insets for edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.result_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
