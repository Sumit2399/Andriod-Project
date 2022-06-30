package com.masterandroid.glbapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;

public class bmi extends AppCompatActivity {

    RadioGroup radioGroup;
    EditText weig;
    EditText heig;
    EditText heig2;
    EditText output;
    TextView textView;
    Button clear;
    RadioButton rb1;
    RadioButton rb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);

        //clear button
        weig=findViewById(R.id.weig);
        heig=findViewById(R.id.heig);
        heig2=findViewById(R.id.heig2);
        output=findViewById(R.id.output);
        clear=findViewById(R.id.clear);

        //calc button
        final EditText e1 = (EditText) findViewById(R.id.weig);
        final EditText e2 = (EditText) findViewById(R.id.heig);
        final TextView tv4 = (TextView) findViewById(R.id.output);

        //radio
        final EditText e3 = (EditText) findViewById(R.id.heig2);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);//doubt
        rb1 = (RadioButton) findViewById(R.id.metric);
        rb2 = (RadioButton) findViewById(R.id.standard);
//clear button
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weig.getText().clear();
                heig.getText().clear();
                heig2.getText().clear();
                output.getText().clear();
                heig.clearFocus();
                heig2.clearFocus();
                weig.clearFocus();
            }

        });

        //radiobutton
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if (checkedId == R.id.metric) {
                    e3.setVisibility(View.INVISIBLE);
                    e2.setVisibility(View.VISIBLE);
                    heig.getText().clear();
                    heig.setHint("in cm");
                    weig.getText().clear();
                    weig.setHint("in kg");
                } else if (checkedId == R.id.standard) {
                    e2.setVisibility(View.VISIBLE);
                    e3.setVisibility(View.VISIBLE);
                    heig.getText().clear();
                    heig.setHint("in feet");
                    heig2.getText().clear();
                    heig2.setHint("in inches");
                    weig.getText().clear();
                    weig.setHint("in pound");
                }
            }
        });
        //calc button
        findViewById(R.id.calc).setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                try {
                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }

                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();
                String str3 = e3.getText().toString();

                if (rb1.isChecked()){

                    if (TextUtils.isEmpty(str1)) {
                        e1.setError("Please enter your weight");
                        e1.requestFocus();
                        return;
                    }

                if (TextUtils.isEmpty(str2)) {
                    e2.setError("Please enter your height");
                    e2.requestFocus();
                    return;
                }


                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2) / 100;


                float bmiValue = calculateBMI(weight, height);


                String bmiInterpretation = interpretBMI(bmiValue);

                tv4.setText(String.valueOf("Your BMI is " +bmiValue+ " indicating your weight is in the "+bmiInterpretation+ " category for adults of your height." ));
            }
                else if (rb2.isChecked())
                {
                    if (TextUtils.isEmpty(str1)) {
                        e1.setError("Please enter your weight");
                        e1.requestFocus();
                        return;
                    }

                    if (TextUtils.isEmpty(str2)) {
                        e2.setError("Please enter your height");
                        e2.requestFocus();
                        return;
                    }

                    if (TextUtils.isEmpty(str3)) {
                        e3.setError("Please enter your height");
                        e3.requestFocus();
                        return;
                    }


                    float weight = Float.parseFloat(str1)*1000/2205;
                    float height = Float.parseFloat(str2) ;
                    float height2 = Float.parseFloat(str3)/10 ;
                    float height3=(height2+height)*3048/10000;


                    float bmiValue = calculateBMI(weight, height3);


                    String bmiInterpretation = interpretBMI(bmiValue);

                    tv4.setText(String.valueOf("Your BMI is " +bmiValue+ " indicating your weight is in the "+bmiInterpretation+ " category for adults of your height."));
                }

            }
        });
    }

    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }


    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }

    }
}