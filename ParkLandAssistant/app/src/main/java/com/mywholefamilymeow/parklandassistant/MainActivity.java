package com.mywholefamilymeow.parklandassistant;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    public final static String MESSAGE_TO_SENT = "catplusplus.firstcat.MESSAGE";

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText text = (EditText) findViewById(R.id.text_field01_main);
        String data_to_sent = text.getText().toString();
        intent.putExtra(MESSAGE_TO_SENT, data_to_sent);
        startActivity(intent);
    }

    public void openWebLink(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        EditText text = (EditText) findViewById(R.id.text_field02_main);
        String data_to_sent = text.getText().toString();
        data_to_sent =  this.getString(R.string.prefix_http) + data_to_sent;
        intent.setData(Uri.parse(data_to_sent));
        startActivity(intent);
    }

    public void toastOnClick(View view) {
        Toast.makeText(this,
                       R.string.message_meow,
                       Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
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
}