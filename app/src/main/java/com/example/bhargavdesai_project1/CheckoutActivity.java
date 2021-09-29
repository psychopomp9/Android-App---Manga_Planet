package com.example.bhargavdesai_project1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {
    EditText editName;
    EditText editQuantity;
    RadioGroup grpRadio;
    Button btnPay;
    TextView txtRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_page);

        // get intent and passed data from previous activity
        Intent i = getIntent();
        String title = i.getStringExtra("title");

        editName = findViewById(R.id.editName);
        editQuantity = findViewById(R.id.editQuantity);
        txtRadio = findViewById(R.id.txtRadio);
        txtRadio.setText("Payment Method:");

        grpRadio = findViewById(R.id.grpRadio);
        grpRadio.clearCheck(); // unselect radio buttons at the beginning

        // when a radio button is selected
        grpRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rbtn = findViewById(checkedId);
            }
        });


        btnPay = findViewById(R.id.btnPay);

        // when pay button gets clicked
        btnPay.setOnClickListener(view -> {
            int selectedId = grpRadio.getCheckedRadioButtonId(); // for selected radio button

            // to check if user has entered all the details
            // if he has selected any payment method, entered name, and entered quantity
            if(selectedId == -1 || editName.getText().toString().trim().length() == 0 || editQuantity.getText().toString().trim().length() == 0){
                // if not entered all details, display toast that says "Enter all details to proceed"
                Toast.makeText(CheckoutActivity.this, "Please fill out all the fields to proceed!", Toast.LENGTH_LONG).show();
            }else{

                // if user has provided all the data
                // it'll display a toast thanking for the purchase with entered user name, selected item and type of the purchase selected by user

                RadioButton rbtn = findViewById(selectedId);

                Toast.makeText(CheckoutActivity.this, "Thank you " + editName.getText() + " for purchasing " + title + " using " + rbtn.getText(), Toast.LENGTH_LONG).show();

                // clears out fields at the end
                editName.setText("");
                editQuantity.setText("");
                grpRadio.clearCheck();
            }
        });
    }
}
