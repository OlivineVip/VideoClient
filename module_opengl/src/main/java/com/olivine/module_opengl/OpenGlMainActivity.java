package com.olivine.module_opengl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OpenGlMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_gl_main);
    }


    public void onSimpleClick(View view) {
        startActivity(new Intent(this, SimpleOpenglActivity.class));
    }


}