package com.example.tracking_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Activity4 extends AppCompatActivity
{
    Button backButton;
    Button saveButton;

    EditText open1;
    EditText open2;
    EditText open3;
    EditText open4;
    EditText open5;
    EditText open6;
    EditText open7;
    EditText open8;
    EditText open9;
    EditText open10;

    EditText given1;
    EditText given2;
    EditText given3;
    EditText given4;
    EditText given5;
    EditText given6;
    EditText given7;
    EditText given8;
    EditText given9;
    EditText given10;


    List<Integer> listOfOpen;
    List<Integer> listOfGiven;

    TextView result;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);

       backButton = (Button) findViewById(R.id.back3);
       saveButton = (Button) findViewById(R.id.save);

       open1= (EditText) findViewById(R.id.open1);
       open2= (EditText) findViewById(R.id.open2);
       open3= (EditText) findViewById(R.id.open3);
       open4= (EditText) findViewById(R.id.open4);
       open5= (EditText) findViewById(R.id.open5);
       open6= (EditText) findViewById(R.id.open6);
       open7= (EditText) findViewById(R.id.open7);
       open8= (EditText) findViewById(R.id.open8);
       open9= (EditText) findViewById(R.id.open9);
       open10= (EditText) findViewById(R.id.open10);


       given1= (EditText) findViewById(R.id.given1);
       given2= (EditText) findViewById(R.id.given2);
       given3= (EditText) findViewById(R.id.given3);
       given4= (EditText) findViewById(R.id.given4);
       given5= (EditText) findViewById(R.id.given5);
       given6= (EditText) findViewById(R.id.given6);
       given7= (EditText) findViewById(R.id.given7);
       given8= (EditText) findViewById(R.id.given8);
       given9= (EditText) findViewById(R.id.given9);
       given10= (EditText) findViewById(R.id.given10);


       result= (TextView) findViewById(R.id.resultdoes);




       backButton.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view)
           {
               Intent i = new Intent(getIntent());
               i.setClass(Activity4.this,MainActivity.class);

               //(List<Integer>)i.getSerializableExtra("listofopen")==null

               if(listOfOpen!= null || listOfGiven!=null)
               {
                   i.putExtra("listofopen", (Serializable) listOfOpen);
                   i.putExtra("listofgiven", (Serializable) listOfGiven);
               }

               startActivity(i);
           }
       });

       saveButton.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view)
           {
               try
               {
                   SetListOpen();
                   SetListGiven();
                   listOfOpen.add(CalaculateSum(listOfOpen));
                   listOfGiven.add(CalaculateSum(listOfGiven));

                   result.setText("הנתונים נשמרו בהצלחה");


               }catch (Exception error)
               {
                   Toast.makeText(Activity4.this,"משהו בנתונים לא תקין",Toast.LENGTH_LONG).show();
                   error.printStackTrace();
               }

           }
       });




    }

    public void SetListOpen()
    {
        String number;
        listOfOpen = new ArrayList<Integer>();

        number=open1.getText().toString();
        if (!number.equals("")) {
            listOfOpen.add(Integer.parseInt(number));
        }
        else
        {
            listOfOpen.add(0);
        }

        number=open2.getText().toString();
        if (!number.equals("")) {
            listOfOpen.add(Integer.parseInt(number));
        }
        else
        {
            listOfOpen.add(0);
        }


        number=open3.getText().toString();
        if (!number.equals("")) {
            listOfOpen.add(Integer.parseInt(number));
        }
        else
        {
            listOfOpen.add(0);
        }

        number=open4.getText().toString();
        if (!number.equals("")) {
            listOfOpen.add(Integer.parseInt(number));
        }
        else
        {
            listOfOpen.add(0);
        }

        number=open5.getText().toString();
        if (!number.equals("")) {
            listOfOpen.add(Integer.parseInt(number));
        }
        else
        {
            listOfOpen.add(0);
        }


        number=open6.getText().toString();
        if (!number.equals("")){
            listOfOpen.add(Integer.parseInt(number));
        }
        else
        {
            listOfOpen.add(0);
        }


        number=open7.getText().toString();
        if (!number.equals("")) {
            listOfOpen.add(Integer.parseInt(number));
        }
        else
        {
            listOfOpen.add(0);
        }

        number=open8.getText().toString();
        if (!number.equals("")) {
            listOfOpen.add(Integer.parseInt(number));
        }
        else
        {
            listOfOpen.add(0);
        }

        number=open9.getText().toString();
        if (!number.equals("")) {
            listOfOpen.add(Integer.parseInt(number));
        }
        else
        {
            listOfOpen.add(0);
        }

        number=open10.getText().toString();
        if (!number.equals("")) {
            listOfOpen.add(Integer.parseInt(number));
        }
        else
        {
            listOfOpen.add(0);
        }


    }


    public void SetListGiven()
    {
        String number;

        listOfGiven = new ArrayList<Integer>();

        number=given1.getText().toString();
        if (!number.equals("")) {
            listOfGiven.add(Integer.parseInt(number));
        }
        else
        {
            listOfGiven.add(0);
        }

        number=given2.getText().toString();
        if (!number.equals("")) {
            listOfGiven.add(Integer.parseInt(number));
        }
        else
        {
            listOfGiven.add(0);
        }


        number=given3.getText().toString();
        if (!number.equals("")) {
            listOfGiven.add(Integer.parseInt(number));
        }
        else
        {
            listOfGiven.add(0);
        }


        number=given4.getText().toString();
        if (!number.equals("")) {
            listOfGiven.add(Integer.parseInt(number));
        }
        else
        {
            listOfGiven.add(0);
        }


        number=given5.getText().toString();
        if (!number.equals("")) {
            listOfGiven.add(Integer.parseInt(number));
        }
        else
        {
            listOfGiven.add(0);
        }


        number=given6.getText().toString();
        if (!number.equals("")){
            listOfGiven.add(Integer.parseInt(number));
        }
        else
        {
            listOfGiven.add(0);
        }


        number=given7.getText().toString();
        if (!number.equals("")) {
            listOfGiven.add(Integer.parseInt(number));
        }
        else
        {
            listOfGiven.add(0);
        }


        number=given8.getText().toString();
        if (!number.equals("")) {
            listOfGiven.add(Integer.parseInt(number));
        }
        else
        {
            listOfGiven.add(0);
        }

        number=given9.getText().toString();
        if (!number.equals("")) {
            listOfGiven.add(Integer.parseInt(number));
        }
        else
        {
            listOfGiven.add(0);
        }

        number=given10.getText().toString();
        if (!number.equals("")) {
            listOfGiven.add(Integer.parseInt(number));
        }
        else
        {
            listOfGiven.add(0);
        }

    }

    public int CalaculateSum(List<Integer> list1)
    {
        int sum=0;

        for(int i=0; i< list1.size() ; i++)
        {
            sum= sum +list1.get(i);
        }

        return sum;
    }




}