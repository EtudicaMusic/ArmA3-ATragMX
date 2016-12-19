package sceinox.atragmx;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AtmsphrActivity extends AppCompatActivity{

    static FireProfiles fireProfiles;

    public void setFireProfiles(FireProfiles fireProfiles) {
        this.fireProfiles = fireProfiles;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atmsphr0);
    }

    //region OnClickEvents
    public void onDoneClick(View view){
        saveChangesToProfile();
        finish();
    }

    public void onCancelClick(View view){
        finish();
    }

    public void onPrevClick(View view){
        saveChangesToProfile();
        finish();
        startActivity(new Intent(this, GunActivity.class));
    }

    public void onNextClick(View view){
        saveChangesToProfile();
        finish();
        startActivity(new Intent(this, TargetActivity.class));
    }

    public void onATClick(View view) {
        buttonColorSwitch("at");
    }

    public void onTBHClick(View view) {
        buttonColorSwitch("tbh");
    }
    //endregion

    //region private methods
    private void saveChangesToProfile(){
        FireProfiles.Profile profile = fireProfiles.getSelectedProfile();

        profile.setAltitude(getInputOfText(R.id.Edit_Altitude));
        profile.setTemperature(getInputOfText(R.id.Edit_Temperature));
    }

    private double getInputOfText(int id){
        return Double.parseDouble(((TextView) this.findViewById(id)).getText().toString());
    }

    private void buttonColorSwitch(String calcMethod){
        Button at = (Button) findViewById(R.id.Button_AT);
        Button tbh = (Button) findViewById(R.id.Button_TBH);

        if (calcMethod.equals("at")){
            at.setBackgroundColor(Color.BLACK);
            at.setTextColor(Color.WHITE);

            tbh.setBackgroundColor(Color.WHITE);
            tbh.setTextColor(Color.BLACK);
        } else if (calcMethod.equals("tbh")){
            tbh.setBackgroundColor(Color.BLACK);
            tbh.setTextColor(Color.WHITE);

            at.setBackgroundColor(Color.WHITE);
            at.setTextColor(Color.BLACK);
        }
    }
    //endregion
}
