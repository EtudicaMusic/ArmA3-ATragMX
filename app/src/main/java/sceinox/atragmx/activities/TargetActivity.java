package sceinox.atragmx.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import sceinox.atragmx.R;
import sceinox.atragmx.logic.FireProfiles;

public class TargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        updateTextViewsFormFireProfile();
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateTextViewsFormFireProfile();
    }

    //region OnClickEvents
    public void onDoneClick(View view) {
        saveChangesToProfile();
        finish();
    }

    public void onCancelClick(View view) {
        finish();
    }

    public void onPrevClick(View view) {
        saveChangesToProfile();
        finish();
        startActivity(new Intent(this, AtmsphrActivity.class));
    }

    public void onNextClick(View view) {
        saveChangesToProfile();
        finish();
        startActivity(new Intent(this, GunActivity.class));
    }
    //endregion

    //region private methods
    private void saveChangesToProfile() {
        FireProfiles.getSelectedProfile().setLatitude(getInputOfText(R.id.Edit_Latitude));
        FireProfiles.getSelectedProfile().setDirOfFire(getInputOfText(R.id.Edit_DirOfFire));
        FireProfiles.getSelectedProfile().setWindSpeed(getInputOfText(R.id.Edit_WindSpeed1));
        FireProfiles.getSelectedProfile().setWindSpeed2(getInputOfText(R.id.Edit_WindSpeed2));
        FireProfiles.getSelectedProfile().setWindDirection(getInputOfText(R.id.Edit_WindDirection));
        FireProfiles.getSelectedProfile().setInclinationAngleFromCosine(getInputOfText(R.id.Edit_InclinationAnglec));
        FireProfiles.getSelectedProfile().setInclinationAngleFromDegree(getInputOfText(R.id.Edit_InclinationAngled));
        FireProfiles.getSelectedProfile().setTargetSpeed(getInputOfText(R.id.Edit_TargetSpeed));
        FireProfiles.getSelectedProfile().setTargetRange(getInputOfText(R.id.Edit_TargetRange));
    }

    private void updateTextViewsFormFireProfile() {
        setTextToTextView(R.id.Edit_Latitude, String.valueOf(FireProfiles.getSelectedProfile().getLatitude()));
        setTextToTextView(R.id.Edit_DirOfFire, String.valueOf(FireProfiles.getSelectedProfile().getDirOfFire()));
        setTextToTextView(R.id.Edit_WindSpeed1, String.valueOf(FireProfiles.getSelectedProfile().getWindSpeed()));
        setTextToTextView(R.id.Edit_WindSpeed2, String.valueOf(FireProfiles.getSelectedProfile().getWindSpeed2()));
        setTextToTextView(R.id.Edit_WindDirection, String.valueOf(FireProfiles.getSelectedProfile().getWindDirection()));
        setTextToTextView(R.id.Edit_InclinationAnglec, String.valueOf(FireProfiles.getSelectedProfile().getInclinationAngleCosine()));
        setTextToTextView(R.id.Edit_InclinationAngled, String.valueOf(FireProfiles.getSelectedProfile().getInclinationAngleDegree()));
        setTextToTextView(R.id.Edit_TargetSpeed, String.valueOf(FireProfiles.getSelectedProfile().getTargetSpeed()));
        setTextToTextView(R.id.Edit_TargetRange, String.valueOf(FireProfiles.getSelectedProfile().getTargetRange()));
    }

    private double getInputOfText(int id) {
        return Double.parseDouble(((TextView) this.findViewById(id)).getText().toString());
    }

    private void setTextToTextView(int id, String text) {
        TextView textView = (TextView) this.findViewById(id);
        textView.setText(text);
    }
    //endregion
}
