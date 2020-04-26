package com.rht6226.uicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RadioButtonActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button submit;
    private TextView output;
    private String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_main);

        radioGroup = findViewById(R.id.radioGroupID);
        submit = findViewById(R.id.printBtn);
        output = findViewById(R.id.output);

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        output.setText(response);
                    }
                }
        );

        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        radioButton = findViewById(checkedId);
                        switch (checkedId){
                            case R.id.yesID:
                                Log.d("Checked Value Changed", "Attending");
                                response = "Attending!";
                                break;
                            case R.id.noID:
                                Log.d("Checked Value Changed", "NOT Attending");
                                response = "Not Attending! What You gonna Do?";
                                break;
                            case R.id.maybeID:
                                Log.d("Checked Value Changed", "Not Sure!!");
                                response = "Don't Know Yet";
                                break;
                        }
                    }
                }
        );
    }
}
