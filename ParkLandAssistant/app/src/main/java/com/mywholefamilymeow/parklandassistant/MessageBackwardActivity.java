package com.mywholefamilymeow.parklandassistant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by TheFreedomKnight on 2015/4/6.
 */
public class MessageBackwardActivity extends BaseActivity {

    public final static String MESSAGE_TO_RETURN = "Message from MessageBackwardActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_message_backward);

        Button button01 = (Button) findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                EditText text = (EditText) findViewById(R.id.text_field01);
                String data_to_sent = text.getText().toString();
                intent.putExtra(MESSAGE_TO_RETURN,data_to_sent);
                setResult(1,intent);
                finish();
            }
        });

        Button button02 = (Button) findViewById(R.id.button02);
        button02.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ActivityCollector.finishAll();
            }
        });
    }

    //    todo: combine the duplicate codes in onBackPressed and onCreate
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        EditText text = (EditText) findViewById(R.id.text_field01);
        String data_to_sent = text.getText().toString();
        intent.putExtra(MESSAGE_TO_RETURN,data_to_sent);
        setResult(2,intent);
        finish();

    }
}
