package com.example.hmand13vlasovpressure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    EditText editFio;
    EditText editAge;
    User mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editFio = findViewById(R.id.editFIO);
        editAge = findViewById(R.id.editAge);



    }

    public void clickBtnSave(View view) {

        String fullName;
        int age = 0;

        fullName = editFio.getText().toString();
        String ageInput = editAge.getText().toString();
        if (fullName.isEmpty() || ageInput.isEmpty()) {
            Toast.makeText(this, "Сначала введите ваше ФИО и возраст", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            age = Integer.parseInt(ageInput);


        } catch (NumberFormatException e) {
            Log.e(TAG, "Не верный формат ввода(Возраст)");
            Toast.makeText(this, "Не верный формат ввода(Возраст)", Toast.LENGTH_SHORT).show();
            return;
        }
        mUser = new User(fullName, age);
        Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();
        Log.e(TAG, String.format("Добавлен User %s, возраст: %s",fullName, age));
        editFio.setText("");
        editAge.setText("");


    }

    public void goLife(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityLife.class);
        startActivity(intent);
        Log.e(TAG, "Переход на экран: Жизненные показатели");

    }

    public void goPressure(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityPressure.class);
        startActivity(intent);
        Log.e(TAG, "Переход на экран: К записям давления");

    }

}
