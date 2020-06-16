package com.example.mygridviewdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private Intent intent;
    String[] countryNames;

    int[] flags = {R.drawable.afg,R.drawable.armenia,R.drawable.azer,R.drawable.bahrain,R.drawable.ban,R.drawable.bhutan,R.drawable.china,
            R.drawable.ind,R.drawable.japan,R.drawable.nepal,R.drawable.pak,R.drawable.sri};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridViewId);

        countryNames = getResources().getStringArray(R.array.country_names);

        CustomAdapter adapter = new CustomAdapter(MainActivity.this,countryNames,flags);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countryNames[position];
                Toast.makeText(MainActivity.this,value +" "+position,Toast.LENGTH_SHORT).show();

                if(position == 4){
                    intent = new Intent(MainActivity.this,ProfileActivity.class);
                    intent.putExtra("name","Bangladesh");
                    startActivity(intent);
                }if(position==7){
                    intent = new Intent(MainActivity.this,ProfileActivity.class);
                    intent.putExtra("name","India");
                    startActivity(intent);
                }if(position==10){
                    intent = new Intent(MainActivity.this,ProfileActivity.class);
                    intent.putExtra("name","Pakistan");
                    startActivity(intent);
                }

            }
        });
    }


    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

        //for setting title
        alertDialogBuilder.setTitle(R.string.title_text);

        //for setting message
        alertDialogBuilder.setMessage(R.string.message_text);

        //for setting icon
        alertDialogBuilder.setIcon(R.drawable.questionicon);

        //creating positive button
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(MainActivity.this,"You Exit Country Profile Project",Toast.LENGTH_SHORT).show();

                finish();
            }
        });

        //creating negative button
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        //creating neutral button
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(MainActivity.this,"You click Cancel button",Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
