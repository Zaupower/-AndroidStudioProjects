package com.example.jogodaspalavras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

class MainActivity extends AppCompatActivity {

    private TextView wordTv;
    private EditText editText;
    private Button btn_validate, btn_newWord;
    private String wordToFind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordTv = findViewById(R.id.word_tv);
        editText = findViewById(R.id.editText);
        btn_validate = findViewById(R.id.btn_validate);
        btn_newWord = findViewById(R.id.btn_newWord);
        btn_newWord();
        btn_validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_validate();
            }
        });

        btn_newWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_newWord();
            }
        });
    }

    void btn_validate(){

        String w = editText.getText().toString();

        if (wordToFind.equals(w)){
            Toast.makeText(this,"Congratolations you find " + wordToFind, Toast.LENGTH_SHORT).show();
            btn_newWord();
        }else {
            Toast.makeText(this,"Retry", Toast.LENGTH_SHORT).show();
        }
    }
    void btn_newWord(){

        wordToFind = Anagram.randomWord();
        String randWord = Anagram.shuffleWord(wordToFind);
        wordTv.setText(randWord);
        editText.setText("");
    }
}
