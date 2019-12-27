package pt.ipp.estg.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView mResultado = findViewById(R.id.textView4);
        final EditText mEditText = findViewById(R.id.editText);
        Button mButtom = findViewById(R.id.button);

        mButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value= mEditText.getText().toString();
                int finalValue=Integer.parseInt(value);

                if(finalValue == 5) {
                    mResultado.setText("O Resultado esta certo ");
                }else {
                    mResultado.setText("O Resultado esta errado ");
                }
            }
        });

    }
}
