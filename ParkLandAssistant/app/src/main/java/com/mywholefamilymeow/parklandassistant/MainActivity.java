package com.mywholefamilymeow.parklandassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "catplusplus.firstcat.MESSAGE";

    /** Called when the user clicks the R.string.button_send button */
    public void sendMessage(View view) {
        Intent intent_cat = new Intent(this, DisplayMessageActivity.class);
        EditText editText_cat = (EditText) findViewById(R.id.edit_field);
        String cat_message = editText_cat.getText().toString();
        intent_cat.putExtra(EXTRA_MESSAGE, cat_message);
        startActivity(intent_cat);
    }

    /** Called when the user clicks the R.string.message_meow button */
    public void toastOnClick(View view) {
        Toast.makeText(MainActivity.this, R.string.message_meow,
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