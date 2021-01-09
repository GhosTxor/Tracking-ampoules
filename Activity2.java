package com.example.tracking_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Activity2 extends AppCompatActivity
{

    EditText expection;
    EditText open ;
    EditText given ;
    TextView result;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Button backButton = (Button) findViewById(R.id.back2);
        Button submitButton = (Button) findViewById(R.id.submit);

        expection = (EditText) findViewById(R.id.expection);
        open = (EditText) findViewById(R.id.open);
        given = (EditText) findViewById(R.id.given);

        result = (TextView) findViewById(R.id.result);
        result.setVisibility(View.INVISIBLE);

        i= getIntent();

        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                i.setClass(Activity2.this,MainActivity.class);
                startActivity(i);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    int needed_doses=0;
                    String openall="";
                    String givenall="";
                    String expect ="";

                    expect=expection.getText().toString();
                    openall=open.getText().toString();
                    givenall=given.getText().toString();

                    if(!openall.equals("") && !givenall.equals("") && !expect.equals(""))
                    {
                        needed_doses= Integer.parseInt(expection.getText().toString())-(Integer.parseInt(given.getText().toString())+Integer.parseInt(open.getText().toString()));
                    }
                    else if (!expect.equals(""))
                    {

                        List<Integer> listofopen=(List<Integer>) i.getSerializableExtra("listofopen");

                        List<Integer> listofgiven=(List<Integer>) i.getSerializableExtra("listofgiven");
                        needed_doses=  Integer.parseInt(expect)- ( listofgiven.get(10) +listofopen.get(10) );



                    }
                    else
                    {
                        Toast.makeText(Activity2.this,"משהו בנתונים לא תקין",Toast.LENGTH_LONG).show();
                    }


                    result.setText(" צריך  עוד " + needed_doses + " מנות ");
                    result.setVisibility(View.VISIBLE);


                }catch (Exception error)
                {
                    Toast.makeText(Activity2.this,"משהו בנתונים לא תקין",Toast.LENGTH_LONG).show();
                    error.printStackTrace();
                }

            }
        });





    }


}