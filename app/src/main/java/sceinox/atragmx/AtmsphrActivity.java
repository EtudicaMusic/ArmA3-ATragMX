package sceinox.atragmx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AtmsphrActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atmsphr0);
    }

    //region OnClickEvents
    public void onDoneClick(View view){
        //saveChangesToProfile();
        finish();
    }

    public void onCancelClick(View view){
        finish();
    }

    public void onPrevClick(View view){
        finish();
        startActivity(new Intent(this, GunActivity.class));
    }

    public void onNextClick(View view){
        finish();
        startActivity(new Intent(this, TargetActivity.class));
    }
    //endregion

    //region private methods
    private void saveChangesToProfile(){
        FireProfiles.Profile profile = FireProfiles.getSelectedProfile();

        profile.setAltitude(R.id.Edit_Altitude);
        profile.setTemperature(R.id.Edit_Temperature);
    }

    private double getInputOfText(int id){
        return Double.parseDouble(((TextView) this.findViewById(id)).getText().toString());
    }
    //endregion
}
