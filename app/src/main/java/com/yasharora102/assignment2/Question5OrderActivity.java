package com.yasharora102.assignment2;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Question5OrderActivity extends AppCompatActivity {

    private EditText etCustomerName;
    private RadioGroup rgBreadLength;
    private CheckBox cbPaneer, cbOnion, cbMushroom, cbJalapeno;
    private AutoCompleteTextView actvDrink;
    private Button btnOrder;
    private TextView tvCurrentDate, tvCurrentTime; // TextViews for date and time

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5_order);

        etCustomerName = findViewById(R.id.etCustomerName);
        rgBreadLength = findViewById(R.id.rgBreadLength);
        cbPaneer = findViewById(R.id.cbPaneer);
        cbOnion = findViewById(R.id.cbOnion);
        cbMushroom = findViewById(R.id.cbMushroom);
        cbJalapeno = findViewById(R.id.cbJalapeno);
        actvDrink = findViewById(R.id.actvDrink);
        btnOrder = findViewById(R.id.btnOrder);
        tvCurrentDate = findViewById(R.id.tvCurrentDate); // Initialize date TextView
        tvCurrentTime = findViewById(R.id.tvCurrentTime); // Initialize time TextView

        // Drinks list for AutoCompleteTextView
        String[] drinks = {"Coke", "Pepsi", "Fanta"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, drinks);
        actvDrink.setAdapter(adapter);

        // Set current date and time in respective TextViews
        setCurrentDateTime();

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateOrder();
            }
        });
    }

    private void setCurrentDateTime() {
        // Get current date and time
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

        // Set date and time in TextViews
        tvCurrentDate.setText(currentDate);
        tvCurrentTime.setText(currentTime);
    }

    private void calculateOrder() {
        String customerName = etCustomerName.getText().toString();
        if (customerName.isEmpty()) {
            Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Calculate bread length cost
        int breadCost = 0;
        int selectedBreadId = rgBreadLength.getCheckedRadioButtonId();
        if (selectedBreadId == R.id.rb15cm) {
            breadCost = 100;
        } else if (selectedBreadId == R.id.rb30cm) {
            breadCost = 200;
        } else {
            Toast.makeText(this, "Please select a bread length.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Calculate toppings cost
        int toppingsCost = 0;
        if (cbPaneer.isChecked()) toppingsCost += 50;
        if (cbMushroom.isChecked()) toppingsCost += 50;
        if (cbOnion.isChecked()) toppingsCost += 30;
        if (cbJalapeno.isChecked()) toppingsCost += 30;

        // Calculate drink cost
        int drinkCost = 0;
        String selectedDrink = actvDrink.getText().toString();
        if (!selectedDrink.isEmpty() && (selectedDrink.equalsIgnoreCase("Coke") ||
                selectedDrink.equalsIgnoreCase("Pepsi") || selectedDrink.equalsIgnoreCase("Fanta"))) {
            drinkCost = 40;
        } else {
            Toast.makeText(this, "Please select a valid drink.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Calculate total cost
        int totalCost = breadCost + toppingsCost + drinkCost;

        // Retrieve current date and time from TextViews
        String currentDate = tvCurrentDate.getText().toString();
        String currentTime = tvCurrentTime.getText().toString();

        // Display order summary in an alert dialog
        String orderSummary = "Customer Name: " + customerName + "\n" +
                "Order Date: " + currentDate + "\n" +
                "Order Time: " + currentTime + "\n" +
                "Bread Length: " + ((selectedBreadId == R.id.rb15cm) ? "15cm" : "30cm") + "\n" +
                "Toppings: " +
                (cbPaneer.isChecked() ? "Paneer, " : "") +
                (cbMushroom.isChecked() ? "Mushroom, " : "") +
                (cbOnion.isChecked() ? "Onion, " : "") +
                (cbJalapeno.isChecked() ? "Jalapeno" : "") + "\n" +
                "Drink: " + selectedDrink + "\n" +
                "Total Cost: Rs. " + totalCost;

        new AlertDialog.Builder(this)
                .setTitle("Order Summary")
                .setMessage(orderSummary)
                .setPositiveButton("OK", null)
                .show();
    }
}
