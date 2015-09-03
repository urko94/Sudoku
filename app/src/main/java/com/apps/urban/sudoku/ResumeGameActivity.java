package com.apps.urban.sudoku;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class ResumeGameActivity extends ListActivity{

    Intent intent;
    TextView sudokuIdGone;

    DBTools dbTools = new DBTools(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_game);

        ArrayList<HashMap<String, String>> sudokuList = dbTools.getAllSudoku();
        dbTools.getAllSudoku();

        if(sudokuList.size() != 0){
            ListView listView = getListView();
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    sudokuIdGone = (TextView) view.findViewById(R.id.sudokuIdGone);

                    String sudokuIdValue = sudokuIdGone.getText().toString();
                    Intent theIntent = new Intent(getApplication(), GameActivity.class);
                    theIntent.putExtra("sudokuId", sudokuIdValue);
                    startActivity(theIntent);
                }
            });
        }

        ListAdapter adapter = new SimpleAdapter(
                ResumeGameActivity.this, sudokuList, R.layout.saved_game_layout,
                new String[] {"sudokuIdGone", "sudokuId", "sudokuTime"},
                new int[] {R.id.sudokuIdGone, R.id.sudokuId, R.id.sudokuTime});

        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resume_game, menu);
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
