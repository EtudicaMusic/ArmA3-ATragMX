package sceinox.atragmx.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import sceinox.atragmx.R;
import sceinox.atragmx.logic.DatabaseHelper;
import sceinox.atragmx.logic.FireProfiles;

public class GunNoteActivity extends AppCompatActivity {
    private final String STANDARD_STRING ="Nothing to display here, you can start adding a note by clicking on the Edit-Button";

    private DatabaseHelper dbHelp=new DatabaseHelper(this);
    private String[] selectedGun;
    private TextView noteText;
    public static String selectedGunName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunnote);
        initGUI();
        setupParent(findViewById(R.id.Layout_Linear_Note));
    }

    @Override
    protected void onStart() {
        super.onStart();
        initGUI();
    }

    //region onClickEvents
    public void onCancelClick(View view){
        finish();
        startActivity(new Intent(this, GunListActivity.class));
    }

    public void onSaveClick(View view){
        if (!String.valueOf(noteText.getText()).equals(STANDARD_STRING)){
            dbHelp.updateNote(selectedGun[1], String.valueOf(noteText.getText()));
        }
        finish();
        startActivity(new Intent(this, GunListActivity.class));

    }

    public void onEditClick(View view){
        if (noteText.isEnabled()){
            noteText.setEnabled(false);
        }else {
            noteText.setEnabled(true);
        }
        if (String.valueOf(noteText.getText()).equals(STANDARD_STRING)){
            noteText.setText("");
        }
    }
    //endregion

    //region private Methods
    private void initGUI(){
        if (!(selectedGunName==null)){
            selectedGun=dbHelp.getGunAsArrayByName(selectedGunName);
        }else {
            selectedGun=dbHelp.getGunAsArrayByName(FireProfiles.getSelectedProfile().getWeaponName());
        }
        noteText=(TextView) findViewById(R.id.Edit_NoteText);

        noteText.setEnabled(false);
        setTextToTextView(R.id.Text_GunInfo,selectedGun[1]);
        if (selectedGun[9] == null){
            noteText.setText(STANDARD_STRING);
        }else {
            noteText.setText(selectedGun[9]);
        }
    }

    private void setTextToTextView(int id, String text) {
        TextView textView = (TextView) this.findViewById(id);
        textView.setText(text);
    }

    private void setupParent(View view) {
        //Set up touch listener for non-text box views to hide keyboard.
        if(!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard();
                    return false;
                }
            });
        }
        //If a layout container, iterate over children
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupParent(innerView);
            }
        }
    }

    private void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow( this.getCurrentFocus().getWindowToken(), 0);
    }

    //endregion
}
