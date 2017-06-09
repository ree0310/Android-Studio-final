package com.example.finalproject2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    // 추가내용
    private TextView tv;
    private CheckBox cb1;
    private CheckBox cb2;


    // 추가내용
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        String result = ""; // 문자열 초기화는 빈문자열로 하자

        if(cb1.isChecked()) result += cb1.getText().toString() + ", ";
        if(cb2.isChecked()) result += cb2.getText().toString() + ". ";

        tv.setText("체크항목: " + result);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 추가내용
        cb1 = (CheckBox)findViewById(R.id.checkBox1);
        cb2 = (CheckBox)findViewById(R.id.checkBox2);
        tv = (TextView)findViewById(R.id.textView2);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // 추가내용
        Button mBtn1 = (Button) findViewById(R.id.button1); /*alt + enter*/


        mBtn1.setOnClickListener(new View.OnClickListener() { /*이름이 없는 익명의 클래스를 생성(Anonymous클래스 생성)*/
             @Override
             public void onClick(View v) { /*자동으로 써지는데, public void ~~~가 안뜨면 View.OnClickListener에서 alt + enter*/
                 // 코드 작성
                 Intent intent = new Intent( MainActivity.this, SubActivity.class);
                 startActivity(intent);
                             }
         });

        // 추가내용
        Button mBtn2 = (Button) findViewById(R.id.button2); /*alt + enter*/


        mBtn1.setOnClickListener(new View.OnClickListener() { /*이름이 없는 익명의 클래스를 생성(Anonymous클래스 생성)*/
            @Override
            public void onClick(View v) { /*자동으로 써지는데, public void ~~~가 안뜨면 View.OnClickListener에서 alt + enter*/
                // 코드 작성
                Intent intent = new Intent( MainActivity.this, Sub2Activity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
