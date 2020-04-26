package com.rht6226.uicomponents;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheckBoxesActivity extends AppCompatActivity {

    private Button submitBtn;
    private TextView output;
    private CheckBox [] checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkboxes_main);

        submitBtn = findViewById(R.id.submitBtn);
        output = findViewById(R.id.outputView);
        checkBoxes = new CheckBox[]{
                findViewById(R.id.dogCheckbox), findViewById(R.id.catCheckbox), findViewById(R.id.bunnyCheckbox), findViewById(R.id.turtleCheckbox)
        };

        submitBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for(CheckBox checkBox: checkBoxes){
                            if(checkBox.isChecked())
                                stringBuilder.append("I have a pet ").append(checkBox.getText()).append(".\n");
                        }
                        output.setText(stringBuilder);
                    }
                }
        );

    }
}
