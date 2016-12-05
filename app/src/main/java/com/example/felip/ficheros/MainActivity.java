package com.example.felip.ficheros;

import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    String nomFichero ="ficher.txt";
    EditText et_nombre;
    Button guarda,carga;
    TextView muestra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_nombre = (EditText) findViewById(R.id.et_nom);
        guarda = (Button) findViewById(R.id.btn_add);
        carga = (Button)findViewById(R.id.btn_muestra);
        muestra = (TextView)findViewById(R.id.tv_muestra);


        guarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos= openFileOutput(nomFichero,Context.MODE_APPEND);
                    DataOutputStream dos = new DataOutputStream(fos);
                    String contenido = new String(et_nombre.getText().toString());
                    dos.writeBytes(contenido);
                    fos.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        carga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                   FileInputStream fis = openFileInput(nomFichero);
                    DataInputStream dis = new DataInputStream(fis);
                    byte []buff = new byte[1000];
                    dis.read(buff);
                    muestra.setText(new String(buff));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
