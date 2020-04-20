package com.example.smsedraak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    EditText messageBody;
    EditText mobilNB;
    Button sendMessage;
    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageBody=(EditText)findViewById(R.id.textMessage);
        mobilNB=(EditText)findViewById(R.id.textPhoneNumber);

        sendMessage=(Button) findViewById(R.id.btn_send);
        call=(Button) findViewById(R.id.btn_call);

        sendMessage.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("sms:"));
            i.setType("vnd.android-dir/mms-sms") ;
            i.putExtra("address",new String(mobilNB.getText().toString()));
            i.putExtra("sms_body",new String(messageBody.getText().toString()));
            startActivity(Intent.createChooser(i,"send sms via:"));


    }
});
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String callphone="+2136206506";
                Intent callintent=new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",callphone,null));
                startActivity(callintent);
            }
        });
    }
}
