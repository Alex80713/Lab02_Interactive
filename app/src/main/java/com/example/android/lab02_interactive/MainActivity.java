package com.example.android.lab02_interactive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String mName = "鳴人";
    private int mQuantity = 0;
    private int mPrice = 50;
    private StringBuilder mPriceMessage = new StringBuilder("NT" + mPrice);
    private StringBuilder mQuantityMessage = new StringBuilder(mQuantity);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayPriceMessage();
    }

    public void submitOrder(View view) {
        clearPriceMessageString();
        concatPriceMessageString();
        displayPriceMessage();

    }



    public void increment(View view) {
        ++mQuantity;
        displayQuantityMessage();
        resetPriceMessageString();
        displayPriceMessage();
    }

    private int getQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        String quantityString = quantityTextView.getText().toString();
        return Integer.parseInt(quantityString);
    }

    public void decrement(View view) {
        if (mQuantity == 0) {
            return;
        }
        --mQuantity;
        displayQuantityMessage();
        resetPriceMessageString();
        displayPriceMessage();

    }

    private void displayPriceMessage() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(mPriceMessage);
    }



    private void displayQuantityMessage() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int start = 0;
        int end = mQuantityMessage.length();
        mQuantityMessage.delete(start, end).append(mQuantity);
        quantityTextView.setText(mQuantityMessage);
    }

    private void clearPriceMessageString() {
        int start = 0;
        int end = mPriceMessage.length();
        mPriceMessage.delete(start, end);
    }

    private void concatPriceMessageString() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.toppings_checkbox);
        mPriceMessage.append("Name: ")
                .append(mName)
                .append("\n")
                .append("臭豆腐")
                .append("\n")
                .append("加泡菜 ? ")
                .append(checkBox.isChecked())
                .append("\n");
        if (mQuantity == 0) {
            mPriceMessage.append("Free");
        } else {
            mPriceMessage.append("Quantity: ")
                    .append(mQuantity)
                    .append("\n")
                    .append("Total: ")
                    .append("NT$")
                    .append(mPrice * mQuantity)
                    .append("\n")
                    .append("Thank you!")
                    .append("\n");
        }
    }

    public void clickToppings(View view) {
        resetPriceMessageString();
        displayPriceMessage();
    }

    private void resetPriceMessageString() {
        clearPriceMessageString();
        displayPriceMessage();
    }

}
