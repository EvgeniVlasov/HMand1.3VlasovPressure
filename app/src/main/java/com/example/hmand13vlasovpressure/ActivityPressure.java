package com.example.hmand13vlasovpressure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class ActivityPressure extends AppCompatActivity {
    private static final String TAG = "ActivityPressure";
    UserPressure mUserPressures;
    EditText editPressureUp;
    EditText editPressureDown;
    EditText editPulse;
    CheckBox checkBoxTahird;
    EditText editDate;
    EditText editTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        editPressureUp = findViewById(R.id.editPressureUp);
        editPressureDown = findViewById(R.id.editPressureDown);
        editPulse = findViewById(R.id.editPulse);
        checkBoxTahird = findViewById(R.id.checkBoxTahird);
        editDate = findViewById(R.id.editTextDate);
        editTime = findViewById(R.id.editTextTime);


    }

    public void clickSaveButtonPressure(View view) {
        int pressureUp = 0;
        int pressureDown = 0;
        int pulse = 0;
        boolean tahird = false;

        String date = editDate.getText().toString();
        String time = editTime.getText().toString();
        String pressureUpInput = editPressureUp.getText().toString();
        String pressureDownInput = editPressureDown.getText().toString();
        String pulseInput = editPulse.getText().toString();


        try {
            pressureUp = Integer.parseInt(pressureUpInput);


        } catch (NumberFormatException e) {
            Log.e(TAG, "Не верный формат ввода(Верхнее давление)");
            Toast.makeText(this, "Не верный формат ввода(Верхнее давление)", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            pressureDown = Integer.parseInt(pressureDownInput);

        } catch (NumberFormatException e) {
            Log.e(TAG, "Не верный формат ввода(Нижнее давление)");
            Toast.makeText(this, "Не верный формат ввода(Нижнее давление)", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            pulse = Integer.parseInt(pulseInput);
        } catch (NumberFormatException e) {
            Log.e(TAG, "Не верный формат ввода(Пульс)");
            Toast.makeText(this, "Не верный формат ввода(Пульс)", Toast.LENGTH_SHORT).show();
            return;
        }
        tahird =checkBoxTahird.isChecked();

        mUserPressures = new UserPressure(pressureUp, pressureDown, pulse, tahird, date, time);
        Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
        Log.e(TAG, String.format("Добавлены данные о давлении : (Верхнее давление: %s),(Нижнее давление: %s),(Пульс: %s),(Тахикордия: %s),(Дата: %s),(Время: %s) ",pressureUp,pressureDown,pulse,tahird,date,time));
        editPressureUp.setText("");
        editPressureDown.setText("");
        editPulse.setText("");
        checkBoxTahird.setChecked(false);
        editDate.setText("");
        editTime.setText("");


    }

    public void btnBackPressure(View view) {
        finish();
        Log.e(TAG, "Возврат на экран ФИО и возраста");
    }


}
