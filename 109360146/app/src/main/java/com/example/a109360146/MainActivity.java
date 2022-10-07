package com.example.a109360146;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText playername;
    private TextView showtext,yourname,winner,playermora,computermora;
    private RadioButton scissor,stone,paper;
    private Button mora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playername = findViewById(R.id.playername);
        showtext = findViewById(R.id.showtext);
        yourname = findViewById(R.id.yourname);
        winner = findViewById(R.id.winner);
        playermora = findViewById(R.id.playermora);
        computermora = findViewById(R.id.computermora);
        scissor = findViewById(R.id.scissor);
        stone = findViewById(R.id.stone);
        paper = findViewById(R.id.paper);
        mora = findViewById(R.id.mora);

        mora.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(playername.length()<1)
                    showtext.setText("請先輸入玩家姓名");
                else{
                    yourname.setText(String.format("姓名\n%s",playername.getText().toString()));

                    if(scissor.isChecked())
                        playermora.setText("我方出拳\n剪刀");
                    else if(stone.isClickable())
                        playermora.setText("我方出拳\n石頭");
                    else if(paper.isClickable())
                        playermora.setText("我方出拳\n布");
                    
                    int computer_random = (int)(Math.random()*3);
                    if(computer_random == 0)
                        computermora.setText("電腦出拳\n剪刀");
                    else if(computer_random == 1)
                        computermora.setText("電腦出拳\n石頭");
                    else if(computer_random == 2)
                        computermora.setText("電腦出拳\n布");

                    if((scissor.isChecked() && computer_random == 2) || (stone.isChecked() && computer_random == 0) || (paper.isChecked() && computer_random == 1)){
                        winner.setText("勝利者\n"+playername.getText().toString());
                        showtext.setText("恭喜你獲勝了!");
                    }else if((scissor.isChecked() && computer_random == 1) || (stone.isChecked() && computer_random == 2) || (paper.isChecked() && computer_random == 0)){
                        winner.setText("勝利者\n電腦");
                        showtext.setText("可惜，電腦獲勝了!");
                    }else{
                        winner.setText("勝利者\n平手");
                        showtext.setText("平局，請再試一次!");
                    }
                }
            }

        });

    }
}