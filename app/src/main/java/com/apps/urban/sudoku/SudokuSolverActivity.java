package com.apps.urban.sudoku;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;


public class SudokuSolverActivity extends ActionBarActivity {

    private ToggleButton number1ToggleButton;
    private ToggleButton number2ToggleButton;
    private ToggleButton number3ToggleButton;
    private ToggleButton number4ToggleButton;
    private ToggleButton number5ToggleButton;
    private ToggleButton number6ToggleButton;
    private ToggleButton number7ToggleButton;
    private ToggleButton number8ToggleButton;
    private ToggleButton number9ToggleButton;
    private ToggleButton deleteToggleButton;
    private Button solveButton;

    private EditText[][] tabEditText = new EditText[9][9];
    public static int[][] tabSudoku = new int[9][9];

    private static final int color_button_dark = Color.parseColor("#FF029ACC");
    private static final int color_button_light = Color.parseColor("#d235c5f6");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_solver);

        number1ToggleButton = (ToggleButton) findViewById(R.id.toggleButton1);
        number2ToggleButton = (ToggleButton) findViewById(R.id.toggleButton2);
        number3ToggleButton = (ToggleButton) findViewById(R.id.toggleButton3);
        number4ToggleButton = (ToggleButton) findViewById(R.id.toggleButton4);
        number5ToggleButton = (ToggleButton) findViewById(R.id.toggleButton5);
        number6ToggleButton = (ToggleButton) findViewById(R.id.toggleButton6);
        number7ToggleButton = (ToggleButton) findViewById(R.id.toggleButton7);
        number8ToggleButton = (ToggleButton) findViewById(R.id.toggleButton8);
        number9ToggleButton = (ToggleButton) findViewById(R.id.toggleButton9);
        deleteToggleButton = (ToggleButton) findViewById(R.id.toggleButtonDel);
        solveButton = (Button) findViewById(R.id.solveButton);

        initializationTabEditText();

        number1ToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableAllToggleButton();
                number1ToggleButton.setChecked(true);
                number1ToggleButton.setBackgroundColor(color_button_dark);
            }
        });
        number2ToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableAllToggleButton();
                number2ToggleButton.setChecked(true);
                number2ToggleButton.setBackgroundColor(color_button_dark);
            }
        });
        number3ToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableAllToggleButton();
                number3ToggleButton.setChecked(true);
                number3ToggleButton.setBackgroundColor(color_button_dark);
            }
        });
        number4ToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableAllToggleButton();
                number4ToggleButton.setChecked(true);
                number4ToggleButton.setBackgroundColor(color_button_dark);
            }
        });
        number5ToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableAllToggleButton();
                number5ToggleButton.setChecked(true);
                number5ToggleButton.setBackgroundColor(color_button_dark);
            }
        });
        number6ToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableAllToggleButton();
                number6ToggleButton.setChecked(true);
                number6ToggleButton.setBackgroundColor(color_button_dark);
            }
        });
        number7ToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableAllToggleButton();
                number7ToggleButton.setChecked(true);
                number7ToggleButton.setBackgroundColor(color_button_dark);
            }
        });
        number8ToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableAllToggleButton();
                number8ToggleButton.setChecked(true);
                number8ToggleButton.setBackgroundColor(color_button_dark);
            }
        });
        number9ToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableAllToggleButton();
                number9ToggleButton.setChecked(true);
                number9ToggleButton.setBackgroundColor(color_button_dark);
            }
        });
        deleteToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableAllToggleButton();
                deleteToggleButton.setChecked(true);
                deleteToggleButton.setBackgroundColor(color_button_dark);
            }
        });

        for(int i=0; i<tabEditText.length; i++){
            for(int j=0; j<tabEditText[i].length; j++){
                final int finalI = i;
                final int finalJ = j;
                tabEditText[finalI][finalJ].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int num = getSelectedButton();
                        tabSudoku[finalI][finalJ] = num;
                        String text = "";
                        if (num > 0) {
                            text = num + "";
                        }
                        tabEditText[finalI][finalJ].setText(text);
                    }
                });
            }
        }

        solveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solveSudoku();
            }
        });
    }

    private void initializationTabEditText(){
        tabEditText[0][0] = (EditText) findViewById(R.id.sudoku11EditText);
        tabEditText[0][1] = (EditText) findViewById(R.id.sudoku12EditText);
        tabEditText[0][2] = (EditText) findViewById(R.id.sudoku13EditText);
        tabEditText[0][3] = (EditText) findViewById(R.id.sudoku14EditText);
        tabEditText[0][4] = (EditText) findViewById(R.id.sudoku15EditText);
        tabEditText[0][5] = (EditText) findViewById(R.id.sudoku16EditText);
        tabEditText[0][6] = (EditText) findViewById(R.id.sudoku17EditText);
        tabEditText[0][7] = (EditText) findViewById(R.id.sudoku18EditText);
        tabEditText[0][8] = (EditText) findViewById(R.id.sudoku19EditText);

        tabEditText[1][0] = (EditText) findViewById(R.id.sudoku21EditText);
        tabEditText[1][1] = (EditText) findViewById(R.id.sudoku22EditText);
        tabEditText[1][2] = (EditText) findViewById(R.id.sudoku23EditText);
        tabEditText[1][3] = (EditText) findViewById(R.id.sudoku24EditText);
        tabEditText[1][4] = (EditText) findViewById(R.id.sudoku25EditText);
        tabEditText[1][5] = (EditText) findViewById(R.id.sudoku26EditText);
        tabEditText[1][6] = (EditText) findViewById(R.id.sudoku27EditText);
        tabEditText[1][7] = (EditText) findViewById(R.id.sudoku28EditText);
        tabEditText[1][8] = (EditText) findViewById(R.id.sudoku29EditText);

        tabEditText[2][0] = (EditText) findViewById(R.id.sudoku31EditText);
        tabEditText[2][1] = (EditText) findViewById(R.id.sudoku32EditText);
        tabEditText[2][2] = (EditText) findViewById(R.id.sudoku33EditText);
        tabEditText[2][3] = (EditText) findViewById(R.id.sudoku34EditText);
        tabEditText[2][4] = (EditText) findViewById(R.id.sudoku35EditText);
        tabEditText[2][5] = (EditText) findViewById(R.id.sudoku36EditText);
        tabEditText[2][6] = (EditText) findViewById(R.id.sudoku37EditText);
        tabEditText[2][7] = (EditText) findViewById(R.id.sudoku38EditText);
        tabEditText[2][8] = (EditText) findViewById(R.id.sudoku39EditText);

        tabEditText[3][0] = (EditText) findViewById(R.id.sudoku41EditText);
        tabEditText[3][1] = (EditText) findViewById(R.id.sudoku42EditText);
        tabEditText[3][2] = (EditText) findViewById(R.id.sudoku43EditText);
        tabEditText[3][3] = (EditText) findViewById(R.id.sudoku44EditText);
        tabEditText[3][4] = (EditText) findViewById(R.id.sudoku45EditText);
        tabEditText[3][5] = (EditText) findViewById(R.id.sudoku46EditText);
        tabEditText[3][6] = (EditText) findViewById(R.id.sudoku47EditText);
        tabEditText[3][7] = (EditText) findViewById(R.id.sudoku48EditText);
        tabEditText[3][8] = (EditText) findViewById(R.id.sudoku49EditText);

        tabEditText[4][0] = (EditText) findViewById(R.id.sudoku51EditText);
        tabEditText[4][1] = (EditText) findViewById(R.id.sudoku52EditText);
        tabEditText[4][2] = (EditText) findViewById(R.id.sudoku53EditText);
        tabEditText[4][3] = (EditText) findViewById(R.id.sudoku54EditText);
        tabEditText[4][4] = (EditText) findViewById(R.id.sudoku55EditText);
        tabEditText[4][5] = (EditText) findViewById(R.id.sudoku56EditText);
        tabEditText[4][6] = (EditText) findViewById(R.id.sudoku57EditText);
        tabEditText[4][7] = (EditText) findViewById(R.id.sudoku58EditText);
        tabEditText[4][8] = (EditText) findViewById(R.id.sudoku59EditText);

        tabEditText[5][0] = (EditText) findViewById(R.id.sudoku61EditText);
        tabEditText[5][1] = (EditText) findViewById(R.id.sudoku62EditText);
        tabEditText[5][2] = (EditText) findViewById(R.id.sudoku63EditText);
        tabEditText[5][3] = (EditText) findViewById(R.id.sudoku64EditText);
        tabEditText[5][4] = (EditText) findViewById(R.id.sudoku65EditText);
        tabEditText[5][5] = (EditText) findViewById(R.id.sudoku66EditText);
        tabEditText[5][6] = (EditText) findViewById(R.id.sudoku67EditText);
        tabEditText[5][7] = (EditText) findViewById(R.id.sudoku68EditText);
        tabEditText[5][8] = (EditText) findViewById(R.id.sudoku69EditText);

        tabEditText[6][0] = (EditText) findViewById(R.id.sudoku71EditText);
        tabEditText[6][1] = (EditText) findViewById(R.id.sudoku72EditText);
        tabEditText[6][2] = (EditText) findViewById(R.id.sudoku73EditText);
        tabEditText[6][3] = (EditText) findViewById(R.id.sudoku74EditText);
        tabEditText[6][4] = (EditText) findViewById(R.id.sudoku75EditText);
        tabEditText[6][5] = (EditText) findViewById(R.id.sudoku76EditText);
        tabEditText[6][6] = (EditText) findViewById(R.id.sudoku77EditText);
        tabEditText[6][7] = (EditText) findViewById(R.id.sudoku78EditText);
        tabEditText[6][8] = (EditText) findViewById(R.id.sudoku79EditText);

        tabEditText[7][0] = (EditText) findViewById(R.id.sudoku81EditText);
        tabEditText[7][1] = (EditText) findViewById(R.id.sudoku82EditText);
        tabEditText[7][2] = (EditText) findViewById(R.id.sudoku83EditText);
        tabEditText[7][3] = (EditText) findViewById(R.id.sudoku84EditText);
        tabEditText[7][4] = (EditText) findViewById(R.id.sudoku85EditText);
        tabEditText[7][5] = (EditText) findViewById(R.id.sudoku86EditText);
        tabEditText[7][6] = (EditText) findViewById(R.id.sudoku87EditText);
        tabEditText[7][7] = (EditText) findViewById(R.id.sudoku88EditText);
        tabEditText[7][8] = (EditText) findViewById(R.id.sudoku89EditText);

        tabEditText[8][0] = (EditText) findViewById(R.id.sudoku91EditText);
        tabEditText[8][1] = (EditText) findViewById(R.id.sudoku92EditText);
        tabEditText[8][2] = (EditText) findViewById(R.id.sudoku93EditText);
        tabEditText[8][3] = (EditText) findViewById(R.id.sudoku94EditText);
        tabEditText[8][4] = (EditText) findViewById(R.id.sudoku95EditText);
        tabEditText[8][5] = (EditText) findViewById(R.id.sudoku96EditText);
        tabEditText[8][6] = (EditText) findViewById(R.id.sudoku97EditText);
        tabEditText[8][7] = (EditText) findViewById(R.id.sudoku98EditText);
        tabEditText[8][8] = (EditText) findViewById(R.id.sudoku99EditText);

    }

    private void disableAllToggleButton(){
        number1ToggleButton.setChecked(false);
        number2ToggleButton.setChecked(false);
        number3ToggleButton.setChecked(false);
        number4ToggleButton.setChecked(false);
        number5ToggleButton.setChecked(false);
        number6ToggleButton.setChecked(false);
        number7ToggleButton.setChecked(false);
        number8ToggleButton.setChecked(false);
        number9ToggleButton.setChecked(false);
        deleteToggleButton.setChecked(false);

        number1ToggleButton.setBackgroundColor(color_button_light);
        number2ToggleButton.setBackgroundColor(color_button_light);
        number3ToggleButton.setBackgroundColor(color_button_light);
        number4ToggleButton.setBackgroundColor(color_button_light);
        number5ToggleButton.setBackgroundColor(color_button_light);
        number6ToggleButton.setBackgroundColor(color_button_light);
        number7ToggleButton.setBackgroundColor(color_button_light);
        number8ToggleButton.setBackgroundColor(color_button_light);
        number9ToggleButton.setBackgroundColor(color_button_light);
        deleteToggleButton.setBackgroundColor(color_button_light);
    }

    private int getSelectedButton(){
        if(number1ToggleButton.isChecked()){
            return 1;
        }
        else if(number2ToggleButton.isChecked()){
            return 2;
        }
        else if(number3ToggleButton.isChecked()){
            return 3;
        }
        else if(number4ToggleButton.isChecked()){
            return 4;
        }
        else if(number5ToggleButton.isChecked()){
            return 5;
        }
        else if(number6ToggleButton.isChecked()){
            return 6;
        }
        else if(number7ToggleButton.isChecked()){
            return 7;
        }
        else if(number8ToggleButton.isChecked()){
            return 8;
        }
        else if(number9ToggleButton.isChecked()){
            return 9;
        }
        else{
            return 0;
        }
    }

    private void writeNumbers(){
        for(int i=0; i<tabEditText.length; i++){
            for(int j=0; j<tabEditText[i].length; j++){
                if(tabSudoku[i][j] == 0){
                    tabEditText[i][j].setText("");
                }
                else{
                    tabEditText[i][j].setText(tabSudoku[i][j] + "");
                }
            }
        }

    }

    private void solveSudoku(){
        boolean igra = sudoku(0,0);
        if(igra){
            writeNumbers();
        }
        else{
            System.out.println("Igra nima resitve!");
            Toast.makeText(getApplicationContext(), "This sudoku has no solution!", Toast.LENGTH_LONG).show();
        }
    }

    private static boolean sudoku(int i, int j){
        if(i > 8){
            return true;
        }
        else if(j > 8){
            return sudoku(i+1, 0);
        }
        else if(tabSudoku[i][j] != 0){
            return sudoku(i, j+1);
        }
        for (int val = 1; val <= 9; val++) {
            if (correct(i, j, val)) {
                tabSudoku[i][j] = val;
                if (sudoku(i, j + 1)) {
                    return true;
                }
            }
        }
        tabSudoku[i][j] = 0;

        return false;
    }

    private static boolean correct(int i, int j, int val){

        for(int k = 0; k<tabSudoku.length; k++){
            if(tabSudoku[k][j] == val){
                return false;
            }
        }

        for(int k = 0; k<tabSudoku[i].length; k++){
            if(tabSudoku[i][k] == val){
                return false;
            }
        }
        int vrstOd = (i/3)*3;
        int stolpOd = (j/3)*3;

        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                if (tabSudoku[vrstOd + m][stolpOd + n] == val) {
                    return false;
                }
            }
        }

        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sudoku_solver, menu);
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
