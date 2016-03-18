package com.example.android.lab02_interactive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private final String mNT$ = "NT$";
    private int number;
    private int mQuantity = 0;
    private int mPrice = 5;
    private StringBuilder mTotalPriceMessage = new StringBuilder(mNT$);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        displaytotalPrice();
    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));

        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        int price = 5;
        int total = price * number;
        String myString = NumberFormat.getCurrencyInstance().format(total);
        priceTextView.setText(myString);

    }

    public void increment(View view) {
        ++mQuantity;
        displayQuantity();
        resetTotolPrice();
    }

    private int getQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        String quantityString = quantityTextView.getText().toString();
        return Integer.parseInt(quantityString);
    }

    public void decrement(View view) {
        if (mQuantity > 0) {
            --mQuantity;
            displayQuantity();
            resetTotolPrice();

        }
    }

    private void resetTotolPrice() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("");
    }

    private void displayQuantity() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(mQuantity));
    }

    private void displaytotalPrice() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        int total = mPrice * mQuantity;
        int startIndex = mNT$.length();
        int endIndex = mTotalPriceMessage.length();
        mTotalPriceMessage.delete(startIndex, endIndex).append(total)
                .append(mQuantity == 0 ? "\nFree" : "\nThank you!");
        priceTextView.setText(mTotalPriceMessage);
        String myString = NumberFormat.getCurrencyInstance().format(total);
        String message = myString + (mQuantity == 0 ? "\nFree" : "\nThank you!");
        priceTextView.setText(message);
    }
}
