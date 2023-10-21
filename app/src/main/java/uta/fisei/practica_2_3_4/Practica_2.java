package uta.fisei.practica_2_3_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class Practica_2 extends AppCompatActivity {
// currency and percent formatter objects
private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
private static final NumberFormat percentFormat = NumberFormat.getPercentInstance();
private double billAmount = 0.0; // bill amount entered by the user
private double percent = 0.15; // initial tip percentage
private TextView amountTextView; // shows formatted bill amount
private TextView percentTextView; // shows tip percentage
private TextView tipTextView; // shows calculated tip amount
private TextView totalTextView; // shows calculated total bill amount
    // listener object for the SeekBar's progress changed events
private final SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            percent = progress / 100.0; // set percent based on progress
            calculate(); // calculate and display tip and total
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
private final TextWatcher amountEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try { // get bill amount and display currency formatted value
                billAmount = Double.parseDouble(s.toString()) / 100.0;
                amountTextView.setText(currencyFormat.format(billAmount));
            }
            catch (NumberFormatException e) { // if s is empty or non-numeric
                amountTextView.setText("");
                billAmount = 0.0;
            }
            calculate();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica2);

        amountTextView = (TextView) findViewById(R.id.textView_amount);
        percentTextView = (TextView) findViewById(R.id.percentTextView);
        tipTextView = (TextView) findViewById(R.id.tipLabelTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        tipTextView.setText(currencyFormat.format(0)); // set text to 0
        totalTextView.setText(currencyFormat.format(0));

        EditText amountEditText = (EditText) findViewById(R.id.amountEditText);
        amountEditText.addTextChangedListener(amountEditTextWatcher);

        SeekBar percentSeekBar = (SeekBar) findViewById(R.id.seekBar);
        percentSeekBar.setOnSeekBarChangeListener(seekBarListener);

    }

    // calculate and display tip and total amounts
 private void calculate() {
    // format percent and display in percentTextView
     percentTextView.setText(percentFormat.format(percent));
     // calculate the tip and total
    double tip = billAmount * percent;
    double total = billAmount + tip;

   // display tip and total formatted as currency
     tipTextView.setText(currencyFormat.format(tip));
     totalTextView.setText(currencyFormat.format(total));
    }
}