package com.rht6226.uicomponents;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class SeekbarActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView output;
    private View window;
    private ToggleButton toggleButton;
    private int painValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar_main);

        seekBar = findViewById(R.id.seekBar);
        output = findViewById(R.id.output);
        window = findViewById(R.id.background);
        toggleButton = findViewById(R.id.toggleButton);

        output.setText("Pain : " + 0 + "/" + seekBar.getMax());


        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        painValue = seekBar.getProgress();
                        if(painValue >= 7) {
                            seekBar.getProgressDrawable().setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY));
                            output.setTextColor(Color.RED);
                        } else {
                            seekBar.getProgressDrawable().setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.MULTIPLY));
                            output.setTextColor(getResources().getColor(R.color.colorPrimary));
                        }
//                        output.setText("Loading . . . .");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Log.d("SeekBar", "Started Dragging");
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        Log.d("SeekBar", "Ended Dragging");
                        output.setText("Pain : " + painValue + "/" + seekBar.getMax());
                    }
                }
        );

        toggleButton.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked)
                            window.setBackgroundColor(getResources().getColor(R.color.gray_bg));
                        else
                            window.setBackgroundColor(Color.TRANSPARENT);
                    }
                }
        );
    }
}
