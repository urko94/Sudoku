package com.apps.urban.sudoku;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;


public class NewGameActivity extends ActionBarActivity {

    private Button playButton;
    private SeekBar difficultSeekBar;
    private EditText difficultEditText;
    private int difficult = 40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        playButton = (Button) findViewById(R.id.playButton);
        difficultSeekBar = (SeekBar) findViewById(R.id.difficultSeekBar);
        difficultEditText = (EditText) findViewById(R.id.showDifficultEditText);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewGameActivity.this, GameActivity.class);
                intent.putExtra("KEY_difficult", difficult);
                startActivity(intent);
            }
        });
        difficultSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                showDifficult();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                showDifficult();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                showDifficult();
            }
        });

        difficultEditText.setEnabled(false);
    }

    private void showDifficult(){
        try {
            difficult = difficultSeekBar.getProgress();
        }
        catch (Exception e){
            difficult = 40;
        }
        difficult = 40 - difficult;
        difficultEditText.setText(difficult +" numbers");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_game, menu);
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
