package sceinox.atragmx.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sceinox.atragmx.logic.DatabaseHelper;
import sceinox.atragmx.logic.FireProfiles;
import sceinox.atragmx.R;

public class GunActivity extends AppCompatActivity{
    public static boolean addGunMode=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gun);
        updateToOrFromAddGunMode();
    }

    //region onClickEvents
    public void onDoneClick(View view){
        if (!addGunMode) {
            saveChangesToProfile();
        }
        addGunMode=false;
        finish();
    }

    public void onCancelClick(View view){
        finish();
    }

    public void onPrevClick(View view){
        saveChangesToProfile();
        finish();
        startActivity(new Intent(this, TargetActivity.class));
    }

    public void onNextClick(View view){
        if (!addGunMode) {
            saveChangesToProfile();
            finish();
            startActivity(new Intent(this, AtmsphrActivity.class));
        }else {
            DatabaseHelper dbHelp=new DatabaseHelper(this);

            dbHelp.addNewGun(
                    getInputOfText(R.id.Edit_GunName,true),
                    getInputOfText(R.id.Edit_Bore),
                    getInputOfText(R.id.Edit_BulletWeight),
                    getInputOfText(R.id.Edit_BulletDiam),
                    getInputOfText(R.id.Edit_C1Coefficient),
                    getInputOfText(R.id.Edit_RifleTwist),
                    getInputOfText(R.id.Edit_MuzzleVelocity),
                    (int) getInputOfText(R.id.Edit_ZeroRange),
                    null
            );

            addGunMode=false;
            finish();
        }
    }
    //endregion

    //region private methods
    private void saveChangesToProfile(){
        FireProfiles.Profile profile = FireProfiles.getSelectedProfile();

        profile.setBoreHeight(getInputOfText(R.id.Edit_Bore));
        profile.setBulletWeight(getInputOfText(R.id.Edit_BulletWeight));
        profile.setBulletDiameter(getInputOfText(R.id.Edit_BulletDiam));
        profile.setC1Coefficient(getInputOfText(R.id.Edit_C1Coefficient));
        profile.setRifleTwist(getInputOfText(R.id.Edit_RifleTwist));
        profile.setMuzzleVelocity(getInputOfText(R.id.Edit_MuzzleVelocity));
        profile.setZeroRange(getInputOfText(R.id.Edit_ZeroRange));
    }

    private double getInputOfText(int id){
        return Double.parseDouble(((TextView) this.findViewById(id)).getText().toString());
    }
    private String getInputOfText(int id,boolean asString){
        return ((TextView) this.findViewById(id)).getText().toString();
    }

    private void updateToOrFromAddGunMode(){
        Button done = (Button) findViewById(R.id.Button_Done);
        Button cancel = (Button) findViewById(R.id.Button_Cancel);
        Button prev = (Button) findViewById(R.id.Button_Prev);
        Button next = (Button) findViewById(R.id.Button_Next);
        TextView nameText= (TextView) findViewById(R.id.Text_GunName);
        TextView nameEdit= (TextView) findViewById(R.id.Edit_GunName);

        if (addGunMode){
            nameText.setVisibility(View.VISIBLE);
            nameEdit.setVisibility(View.VISIBLE);
            done.setText("Cancel");
            cancel.setVisibility(View.INVISIBLE);
            prev.setVisibility(View.INVISIBLE);
            next.setText("Add");
        }else {
            nameText.setVisibility(View.INVISIBLE);
            nameEdit.setVisibility(View.INVISIBLE);
            done.setText("Done");
            cancel.setVisibility(View.VISIBLE);
            prev.setVisibility(View.VISIBLE);
            next.setText("Next");
        }
    }
    //endregion
}