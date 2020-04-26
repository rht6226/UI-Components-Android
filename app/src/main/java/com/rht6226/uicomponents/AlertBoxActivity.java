package com.rht6226.uicomponents;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlertBoxActivity extends AppCompatActivity {

    private Button exitBtn;
    private AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertbox_main);

        exitBtn = findViewById(R.id.exitBtn);

        exitBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                alertBuilder= new AlertDialog.Builder(AlertBoxActivity.this);
                alertBuilder.setTitle(getResources().getString(R.string.alert_title));
                alertBuilder.setMessage(getResources().getString(R.string.alert_question));
                alertBuilder.setCancelable(false);
                alertBuilder.setIcon(android.R.drawable.ic_menu_close_clear_cancel);

                alertBuilder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertBoxActivity.this.finish();
                    }
                });

                alertBuilder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = alertBuilder.create();
                dialog.show();
            }

        });
    }
}
