package com.example.tipcalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText enteredAmount;
    private SeekBar seekBar;
    private TextView totalResultTextView;
    private Button calculateButton;
    private TextView textViewSeekbar;
    private int seekbarPercentage;
    private float enteredBillFloat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredAmount=(EditText) findViewById(R.id.billAmountID);
        seekBar=(SeekBar) findViewById(R.id.seekBar);
        calculateButton=(Button) findViewById(R.id.button);
        totalResultTextView=(TextView) findViewById(R.id.resultID);
        textViewSeekbar=(TextView) findViewById(R.id.textViewSeekbar);

        calculateButton.setOnClickListener(this);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                textViewSeekbar.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                seekbarPercentage=seekBar.getProgress();


            }
        });

    }


    @Override
    public void onClick(View v) {
        calculate();

    }

    public void calculate(){
        float result = 0.0f;
        if (!enteredAmount.getText().toString().equals("")){
        enteredBillFloat= Float.parseFloat(enteredAmount.getText().toString());
        result=enteredBillFloat*seekbarPercentage/100;

//        Log.d("checking", String.valueOf(result));
//        Log.d("seekbar", String.valueOf(seekbarPercentage));

        totalResultTextView.setText( "your tip will be " + result + " Rupees" );
    }
        else
        {
            Toast.makeText(this,"Please enter bill amount",Toast.LENGTH_LONG).show();
            totalResultTextView.setText("");

        }
}}
