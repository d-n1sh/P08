package sg.edu.rp.c346.id21012612.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);

    }

    @Override
    protected void onPause() {
        super.onPause();

        //Step 1a: Get user input from the EditText and store it in variable
        String strName = etName.getText().toString();
        float floatGPA = Float.parseFloat(etGPA.getText().toString());

        //Step 1b: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        //Step 1c: Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Step 1d: Add the key-value pair
        prefEdit.putString("Username", strName);
        prefEdit.putFloat("GPA", floatGPA);

        //Step 1e: Call commit() tto save the changes into SharedPreferences
        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Step 2a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        //Step 2b: Retrieve the saved data from the SharedPreferences object
        String strName = prefs.getString("Username", etName.getText().toString());
        float floatGPA = prefs.getFloat("GPA", 0);

        //Step 2c: Update the UI element with the value
        etName.setText(strName);
        etGPA.setText(floatGPA + "");

    }
}