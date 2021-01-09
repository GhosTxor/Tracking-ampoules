package com.example.tracking_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity3 extends AppCompatActivity
{
    Button backButton;
    ListView listofstands;
    List<Integer> listofopen;
    List<Integer> listofgiven;
    List<String> data;
    ArrayAdapter<String> itemsAdapter;
    TextView overall;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        backButton = (Button) findViewById(R.id.back);
        listofstands= (ListView) findViewById(R.id.listofstands);
        overall =(TextView) findViewById(R.id.overall);
        data= new ArrayList<String>();


        for(int k=0;k<10;k++ )
        {
            data.add("");
        }

        try
        {
            listofopen=(List<Integer>) getIntent().getSerializableExtra("listofopen");
            listofgiven= (List<Integer>) getIntent().getSerializableExtra("listofgiven");


            if(listofopen!=null || listofgiven!= null)
            {
                int b=0;
                for (int j = 0; j < data.size() ; j++)
                {
                    b=j+1;
                    data.set(j, "בעמדה מספר " + b +" יש " + listofopen.get(j) + " מנות פתוחות ויש  " + listofgiven.get(j) + " מנות שניתנו ");
                }
                overall.setText("מספר המנות הפתוחות כרגע סהכ הוא:" +listofopen.get(10) + "\nמספר המנות שניתנו עד כה הוא  "  +listofgiven.get(10));
            }



        }catch (Exception error)
        {
            Toast.makeText(Activity3.this,"error in trying to get the data from the lists",Toast.LENGTH_LONG).show();
            error.printStackTrace();
        }

        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        listofstands.setAdapter(itemsAdapter);








        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getIntent());
                i.setClass(Activity3.this,MainActivity.class);
                startActivity(i);

            }
        });




    }



}
