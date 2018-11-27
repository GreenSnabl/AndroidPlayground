package com.example.snbl.diaglogfragmenttoactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class main extends AppCompatActivity implements MyCustomDialog.OnInputListener{

    public static final String TAG = "main";

    // widgets
    private Button mOpenDialog;
    public TextView mInputDisplay;

    // vars
    public String mInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOpenDialog = findViewById(R.id.open_dialog);
        mInputDisplay = findViewById(R.id.input_display);

        mOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: opening dialog.");

                MyCustomDialog dialog = new MyCustomDialog();
                dialog.show(getSupportFragmentManager(), "MyCustomDialog");

            }

        });
    }

    @Override
    public void sendInput(String input) {
        Log.d(TAG, "sendInput: got the input: " + input);

        //mInputDisplay.setText(input);

        mInput = input;
        setInputToTextView();
    }

    // Nach Capture kann man mit input anstellen was man will. Wir haben noch ungenutzte mInput variable: kann verwendet werden
    private void setInputToTextView() {
        mInputDisplay.setText(mInput);

    }

}
