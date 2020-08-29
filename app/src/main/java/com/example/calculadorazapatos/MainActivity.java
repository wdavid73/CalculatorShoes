package com.example.calculadorazapatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner gender, type, brand;
    private TextView result;
    private EditText quantities;
    private String[] optionsGender, optionsType, optionsBrand;
    private String validateNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gender = findViewById(R.id.spGender);
        type = findViewById(R.id.spType);
        brand = findViewById(R.id.spBrand);
        quantities = findViewById(R.id.txtQuantity);
        result = findViewById(R.id.lblResult);

        optionsGender = getResources().getStringArray(R.array.genders);
        optionsType = getResources().getStringArray(R.array.types);
        optionsBrand = getResources().getStringArray(R.array.brands);

        ArrayAdapter<String>adapterGender = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, optionsGender);

        ArrayAdapter<String>adapterType = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, optionsType);

        ArrayAdapter<String>adapterBrand = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, optionsBrand);

        gender.setAdapter(adapterGender);
        type.setAdapter(adapterType);
        brand.setAdapter(adapterBrand);
    }

    public void Calculate(View v){
        int quantity, opcGender, opcType, opcBrand;
        double res = 0,price = 0 ;
        result.setText("");
        if(validate()){
            quantity = Integer.parseInt(String.valueOf(quantities.getText()));
            opcGender = gender.getSelectedItemPosition();
            opcType = type.getSelectedItemPosition();
            opcBrand = brand.getSelectedItemPosition();
            switch (opcGender){
                case 1:
                    /* MASCULINO */
                    switch (opcType){
                        case 1:
                            /* CLASICO */
                            switch (opcBrand){
                                case 1:
                                    /* NIKE */
                                    price = 50000;
                                    break;
                                case 2:
                                    /* ADIDAS */
                                    price = 80000;
                                    break;
                                case 3:
                                    /* PUMA */
                                    price = 100000;
                                    break;
                            }
                            break;
                        case 2:
                            /* ZAPATILLA */
                            switch (opcBrand){
                                case 1:
                                    /* NIKE */
                                    price = 120000;
                                    break;
                                case 2:
                                    /* ADIDAS */
                                    price = 140000;
                                    break;
                                case 3:
                                    /* PUMA */
                                    price = 130000;
                                    break;
                            }
                            break;
                    }
                    break;
                case 2:
                    /* FEMENINO */
                    switch (opcType){
                        case 1:
                            /* CLASICO */
                            switch (opcBrand){
                                case 1:
                                    /* NIKE */
                                    price = 60000;
                                    break;
                                case 2:
                                    /* ADIDAS */
                                    price = 70000;
                                    break;
                                case 3:
                                    /* PUMA */
                                    price = 120000;
                                    break;
                            }
                            break;
                        case 2:
                            /* ZAPATILLA */
                            switch (opcBrand){
                                case 1:
                                    /* NIKE */
                                    price = 100000;
                                    break;
                                case 2:
                                    /* ADIDAS */
                                    price = 130000;
                                    break;
                                case 3:
                                    /* PUMA */
                                    price = 110000;
                                    break;
                            }
                            break;
                    }
                    break;
            }
            res = price * quantity;
            result.setText("$" + res);
        }

    }

    public void clear(View v){
        gender.setSelection(0);
        type.setSelection(0);
        brand.setSelection(0);
        quantities.setText("");
        result.setText("");
    }

    public boolean validate(){
        if(gender.getSelectedItemPosition() == 0){
            Toast.makeText(this, R.string.validate_selected_gender, Toast.LENGTH_LONG).show();
            return false;
        }

        if(type.getSelectedItemPosition() == 0){
            Toast.makeText(this, R.string.validate_selected_type, Toast.LENGTH_LONG).show();
            return false;
        }

        if(brand.getSelectedItemPosition() == 0){
            Toast.makeText(this, R.string.validated_selected_brand, Toast.LENGTH_LONG).show();
            return false;
        }

        if(quantities.getText().toString().isEmpty()){
            quantities.setError(getString(R.string.validate_number));
            quantities.requestFocus();
            return false;
        }

        if(Integer.parseInt(quantities.getText().toString()) == 0){
            quantities.setError(getString(R.string.validate_number));
            quantities.requestFocus();
            return false;
        }
        return true;
    }
}