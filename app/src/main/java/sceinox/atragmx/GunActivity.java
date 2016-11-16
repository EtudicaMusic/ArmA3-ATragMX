package sceinox.atragmx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class GunActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gun0);
    }

    //region onClickEvents
    public void onDoneClick(View view){
        //saveChangesToProfile();
        finish();
    }

    public void onCancelClick(View view){
        finish();
    }

    public void onPrevClick(View view){
        finish();
        startActivity(new Intent(this, TargetActivity.class));
    }

    public void onNextClick(View view){
        finish();
        startActivity(new Intent(this, AtmsphrActivity.class));
    }
    //endregion

    //region private methods
    private void saveChangesToProfile(){
        FireProfiles.Profile profile = FireProfiles.getSelectedProfile();

        profile.setBoreHeight(getInputOfText(R.id.Edit_Bore));
        profile.setBulletWeight(getInputOfText(R.id.Edit_BulletWeight));
        profile.setBulletDiameter(getInputOfText(R.id.Edit_BulletDiam));
        profile.setBulletDiameter(getInputOfText(R.id.Edit_C1Coefficient));
        profile.setRifleTwist(getInputOfText(R.id.Edit_RifleTwist));
        profile.setMuzzleVelocity(getInputOfText(R.id.Edit_MuzzleVelocity));
        profile.setZeroRange(getInputOfText(R.id.Edit_ZeroRange));
    }

    private double getInputOfText(int id){
        return Double.parseDouble(((TextView) this.findViewById(id)).getText().toString());
    }
    //endregion
}
//ToDo: Commas should be replaced with dots (text fields)