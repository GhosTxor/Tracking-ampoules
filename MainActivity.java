package com.example.tracking_app;

import android.content.Intent;
import android.media.midi.MidiDeviceService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    List<Integer> listOfOpen;
    List<Integer> listOfGiven;
    Button viewButton;
    Button updateButton;
    Button calculate;
    Intent i= new Intent();




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewButton = (Button) findViewById(R.id.view);
        updateButton= (Button) findViewById(R.id.update);
        calculate = (Button) findViewById(R.id.calculate);

        listOfOpen = new ArrayList<Integer>();
        listOfGiven= new ArrayList<Integer>();

        try
        {

            listOfOpen= (List<Integer>) getIntent().getSerializableExtra("listofopen");
            listOfGiven= (List<Integer>) getIntent().getSerializableExtra("listofgiven");

            i.putExtra("listofopen", (Serializable) listOfOpen);
            i.putExtra("listofgiven", (Serializable) listOfGiven);

        }catch (Exception error)
        {
            //Toast.makeText(MainActivity.this,"error in trying to get data from the lists",Toast.LENGTH_LONG).show();
            error.printStackTrace();
        }



        viewButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               i.setClass(MainActivity.this,Activity3.class);
               startActivity(i);
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                 i.setClass(MainActivity.this,Activity2.class);
                startActivity(i);
            }
        });


        calculate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                i.setClass(MainActivity.this,Activity4.class);
                startActivity(i);
            }
        });

    }
}
