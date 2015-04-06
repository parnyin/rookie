package com.mywholefamilymeow.parklandassistant;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends BaseActivity {

    public final static String TAG = "MainActivity";
    public final static String MESSAGE_TO_SENT = "Message from MainActivity";
    public final static String MESSAGE_TO_RETURN = "Message from MessageBackwardActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        todo: remove the TAG and all the log.d(TAG) after understanding the life cycle.
        Log.d(TAG,"onCreate");
        setContentView(R.layout.layout_main);
    }

    public void sendMessage(View view) {
        Intent intent1 = new Intent(this, MessageBackwardActivity.class);
        Intent intent2 = new Intent(this, MessageForwardActivity.class);
        EditText text = (EditText) findViewById(R.id.text_field01);
        String data_to_sent = text.getText().toString();
        if (data_to_sent.equals("")) {
            startActivityForResult(intent1, 1);
        }
        else{
        intent2.putExtra(MESSAGE_TO_SENT, data_to_sent);
        startActivity(intent2);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returned_data = data.getStringExtra(MESSAGE_TO_RETURN);
                    Toast.makeText(this,returned_data,Toast.LENGTH_SHORT).show();
//                    todo: put returned_data into the text field?
                }
        }
    }

    public void openWebLink(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        EditText text = (EditText) findViewById(R.id.text_field02);
        String data_to_sent = text.getText().toString();
        data_to_sent =  this.getString(R.string.prefix_http) + data_to_sent;
        intent.setData(Uri.parse(data_to_sent));
        startActivity(intent);
    }

    public void toastOnClick(View view) {
        EditText text = (EditText) findViewById(R.id.text_field03);
        String data_to_sent = text.getText().toString();
        data_to_sent =  data_to_sent + this.getString(R.string.message_meow) ;
        Toast.makeText(this,data_to_sent,Toast.LENGTH_SHORT).show();
    }

//    todo:
//    is there a way to use parameter to combine openWebLink, toastOnClick and callSomeone?
//    now it seems that the OnClick can't use parameter.
    public void callSomeone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        EditText text = (EditText) findViewById(R.id.text_field04);
        String data_to_sent = text.getText().toString();
        data_to_sent =  this.getString(R.string.prefix_tel) + data_to_sent;
        intent.setData(Uri.parse(data_to_sent));
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_add_pic:
//                AddPicture();
                return true;
            case R.id.action_share:
//                Share();
                return true;
            case R.id.action_search:
//                openSearch();
                return true;
            case R.id.action_settings:
//                openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

}