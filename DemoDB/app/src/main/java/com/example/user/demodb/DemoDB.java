package com.example.user.demodb;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.orm.SugarRecord;

public class DemoDB extends AppCompatActivity {

    public int count = 1;
    public String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_db);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


                Button button1 = (Button)findViewById(R.id.save);
                Button button2 = (Button)findViewById(R.id.load);
                EditText edittext = (EditText)findViewById(R.id.editText);
                button1.setOnClickListener(cSave);
                button2.setOnClickListener(cLoad);
                text = edittext.getText().toString();
            }
        });
    }

    public class studentID extends SugarRecord {
        String MSSV;
        public studentID(){
        }
        public studentID(String MSSV){
            this.MSSV = MSSV;
        }

    }

    private View.OnClickListener cSave = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            studentID sID = new studentID(text);
            count++;
            sID.save();
        }
    };

    private View.OnClickListener cLoad = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //for(int i = 1; i< count; i++){
                studentID sID = studentID.findById(studentID.class, 1);
                Log.d("MSSV", sID.MSSV);
            //}
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_demo_db, menu);
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
