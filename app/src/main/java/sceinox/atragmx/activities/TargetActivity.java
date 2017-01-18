package sceinox.atragmx.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import sceinox.atragmx.logic.FireProfiles;
import sceinox.atragmx.R;

public class TargetActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
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
        startActivity(new Intent(this, AtmsphrActivity.class));
    }

    public void onNextClick(View view){
        saveChangesToProfile();
        finish();
        startActivity(new Intent(this, GunActivity.class));
    }
    //endregion

    //region private methods
    private void saveChangesToProfile(){
        FireProfiles.Profile profile = FireProfiles.getSelectedProfile();

        profile.setLatitude(getInputOfText(R.id.editText8));
        profile.setDirOfFire(getInputOfText(R.id.Edit_DirOfFire));
        profile.setWindSpeed(getInputOfText(R.id.Edit_WindSpeed1));
        profile.setWindSpeed2(getInputOfText(R.id.Edit_WindSpeed2));
        profile.setWindDirection(getInputOfText(R.id.Edit_WindDirection));
        profile.setInclinationAngleFromCosine(getInputOfText(R.id.Edit_InclinationAnglec));
        profile.setInclinationAngleFromDegree(getInputOfText(R.id.Edit_InclinationAngled));
        profile.setTargetSpeed(getInputOfText(R.id.Edit_TargetSpeed));
        profile.setTargetRange(getInputOfText(R.id.Edit_TargetRange));
    }

    private double getInputOfText(int id){
        return Double.parseDouble(((TextView) this.findViewById(id)).getText().toString());
    }
    //endregion
}