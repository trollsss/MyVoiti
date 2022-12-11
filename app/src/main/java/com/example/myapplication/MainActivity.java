package com.example.myapplication;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    // РћР±СЉСЏРІР»СЏРµРј РѕР± РёСЃРїРѕР»СЊР·РѕРІР°РЅРёРё СЃР»РµРґСѓСЋС‰РёС… РѕР±СЉРµРєС‚РѕРІ:
    private EditText username;
    private EditText password;
    private Button login;
    private TextView loginLocked;
    private TextView attempts;
    private TextView numberOfAttempts;

    // Р§РёСЃР»Рѕ РґР»СЏ РїРѕРґСЃС‡РµС‚Р° РїРѕРїС‹С‚РѕРє Р·Р°Р»РѕРіРёРЅРёС‚СЊСЃСЏ:
    int numberOfRemainingLoginAttempts = 3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // РЎРІСЏР·С‹РІР°РµРјСЃСЏ СЃ СЌР»РµРјРµРЅС‚Р°РјРё РЅР°С€РµРіРѕ РёРЅС‚РµСЂС„РµР№СЃР°:
        username = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPersonName1);
        login = (Button) findViewById(R.id.button);
        loginLocked = (TextView) findViewById(R.id.login_locked);
        attempts = (TextView) findViewById(R.id.attempts);
        numberOfAttempts = (TextView) findViewById(R.id.number_of_attempts);
        numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));

    }



    // РћР±СЂР°Р±Р°С‚С‹РІР°РµРј РЅР°Р¶Р°С‚РёРµ РєРЅРѕРїРєРё "Р’РѕР№С‚Рё":
    public void Login(View view) {

        // Р•СЃР»Рё РІРІРµРґРµРЅРЅС‹Рµ Р»РѕРіРёРЅ Рё РїР°СЂРѕР»СЊ Р±СѓРґСѓС‚ СЃР»РѕРІРѕРј "admin",
        // РїРѕРєР°Р·С‹РІР°РµРј Toast СЃРѕРѕР±С‰РµРЅРёРµ РѕР± СѓСЃРїРµС€РЅРѕРј РІС…РѕРґРµ:
        if (username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Р’С…РѕРґ РІС‹РїРѕР»РЅРµРЅ!",Toast.LENGTH_SHORT).show();

            // Р’С‹РїРѕР»РЅСЏРµРј РїРµСЂРµС…РѕРґ РЅР° РґСЂСѓРіРѕР№ СЌРєСЂР°РЅ:
            Intent intent = new Intent(MainActivity.this, SecondJava.class);
            startActivity(intent);
        }

        // Р’ РґСЂСѓРіРѕРј СЃР»СѓС‡Р°Рµ РІС‹РґР°РµРј СЃРѕРѕР±С‰РµРЅРёРµ СЃ РѕС€РёР±РєРѕР№:
        else {
            Toast.makeText(getApplicationContext(), "РќРµРїСЂР°РІРёР»СЊРЅС‹Рµ РґР°РЅРЅС‹Рµ!",Toast.LENGTH_SHORT).show();
            numberOfRemainingLoginAttempts--;

            // Р”РµР»Р°РµРј РІРёРґРёРјС‹РјРё С‚РµРєСЃС‚РѕРІС‹Рµ РїРѕР»СЏ, СѓРєР°Р·С‹РІР°СЋС‰РёРµ РЅР° РєРѕР»РёС‡РµСЃС‚РІРѕ РѕСЃС‚Р°РІС€РёС…СЃСЏ РїРѕРїС‹С‚РѕРє:
            attempts.setVisibility(View.VISIBLE);
            numberOfAttempts.setVisibility(View.VISIBLE);
            numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));

            // РљРѕРіРґР° РІС‹РїРѕР»РЅРµРЅРѕ 3 Р±РµР·СѓСЃРїРµС€РЅС‹С… РїРѕРїС‹С‚РєРё Р·Р°Р»РѕРіРёРЅРёС‚СЊСЃСЏ,
            // РґРµР»Р°РµРј РІРёРґРёРјС‹Рј С‚РµРєСЃС‚РѕРІРѕРµ РїРѕР»Рµ СЃ РЅР°РґРїРёСЃСЊСЋ, С‡С‚Рѕ РІСЃРµ РїСЂРѕРїР°Р»Рѕ Рё РІС‹СЃС‚Р°РІР»СЏРµРј
            // РєРЅРѕРїРєРµ РЅР°СЃС‚СЂРѕР№РєСѓ РЅРµРІРѕР·РјРѕР¶РЅРѕСЃС‚Рё РЅР°Р¶Р°С‚РёСЏ setEnabled(false):
            if (numberOfRemainingLoginAttempts == 0) {
                login.setEnabled(false);
                loginLocked.setVisibility(View.VISIBLE);
                loginLocked.setBackgroundColor(Color.RED);
                loginLocked.setText("Р’С…РѕРґ Р·Р°Р±Р»РѕРєРёСЂРѕРІР°РЅ!!!");
            }
        }
    }

}