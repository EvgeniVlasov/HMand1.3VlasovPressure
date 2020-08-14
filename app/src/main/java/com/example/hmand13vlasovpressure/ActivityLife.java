package com.example.hmand13vlasovpressure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityLife extends AppCompatActivity {
    private static final String TAG = "ActivityLife";
    UserLife mUserLife;
    EditText editWeigt;
    EditText editSteps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        editWeigt = findViewById(R.id.editWeight);
        editSteps = findViewById(R.id.editSteps);
    }

    public void clickBtnSaveLife(View view) { // кнопка сохранить данные шагов и веса
        double weight = 0.0;
        int steps = 0;
        String weightInput = editWeigt.getText().toString();
        String stepsInput = editSteps.getText().toString();
        if (weightInput.isEmpty() || stepsInput.isEmpty()) {
            Log.e(TAG, "При вводе отсутвовали символы");
            Toast.makeText(this, "Сначала введите ваш Вес и количество шагов", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            weight = Double.parseDouble(weightInput);
            // list сохранения данных веса из класса UserLife
        } catch (NumberFormatException e) {
            Log.e(TAG, "Не верный формат ввода(Вес)");
            Toast.makeText(this, "Не верный формат ввода(Вес)", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            steps = Integer.parseInt(stepsInput);

        } catch (NumberFormatException e) {
            Log.e(TAG, "Не верный формат ввода(Количество шагов)");
            Toast.makeText(this, "Не верный формат ввода(Количество шагов)", Toast.LENGTH_SHORT).show();
            return;
        }
        mUserLife = new UserLife(weight, steps);
        Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
        Log.e(TAG, String.format("Добавлены данные о Жизненных показателях:(Вес:%s),(Количество шагов: %s)",weight,steps));
        editWeigt.setText("");
        editSteps.setText("");


    }

    public void backOfLifeBtn(View view) { // кнопка вернутся назад
        finish();
        Log.e(TAG, "Возврат на экран ФИО и возраста");
    }
}
