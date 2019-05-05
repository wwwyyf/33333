package com.example.secondwork;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    private Context context = MainActivity.this;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        //使用activity作为监听器
        btn1.setOnClickListener(this);
        //使用匿名内部类进行监听
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TextView textView=findViewById(R.id.textView);
                textView.setText("使用匿名内部类进行监听");
            }
        });
        //内部类
        MyButtonlistener listener = new MyButtonlistener();
        btn4.setOnClickListener(listener);
        //外部类
        final TextView textView=findViewById(R.id.textView);
        btn5.setOnClickListener(new MyOnClickListener(textView));
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ConfigurationTest.class);
                startActivity(i);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ProgressDialogTest.class);
                startActivity(i);
            }
        });
    }
    public void lucky(View v){
        final TextView textView=findViewById(R.id.textView);
        textView.setText("使用绑定到标签进行监听");
    }
    @Override
    public void onClick(View v) {
        final TextView textView=findViewById(R.id.textView);
        textView.setText("使用activity进行监听");
    }
    class MyButtonlistener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            final TextView textView=findViewById(R.id.textView);
            textView.setText("使用内部类进行监听");
        }
    }
    @OnClick(R.id.button6)
    public void butterKnifeClick(){
        final TextView textView=findViewById(R.id.textView);
        textView.setText("使用ButterKnife进行监听");
    }

}

//直接绑定到标签
class MyOnClickListener implements View.OnClickListener{
    private TextView textView;

    MyOnClickListener(TextView textView){
        this.textView=textView;
    }

    @Override
    public void onClick(View view) {
        textView.setText("使用外部类作为监听器");
    }
}
