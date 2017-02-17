package sceinox.atragmx.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import sceinox.atragmx.R;
import sceinox.atragmx.logic.FireProfiles;

public class TargetRangeActivity extends AppCompatActivity {
    public boolean finishToTargetActivity = false;
    private double lastEstimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_targetrange);
    }

    //region onClick Events
    public void onBackClick(View view) {
        finish();
        if (finishToTargetActivity) {
            startActivity(new Intent(this, TargetActivity.class));
        }
    }

    public void onApplyValueClick(View view) {
        saveDistance();
        finish();
        if (finishToTargetActivity) {
            startActivity(new Intent(this, TargetActivity.class));
        }
    }

    public void onCalcClick(View view) {
        setTextToTextView(R.id.Solution_Distance,
                String.valueOf(
                        distanceEstimation(
                                getInputOfText(R.id.Edit_TargetHeight),
                                getInputOfText(R.id.Edit_Mils)
                        )));
    }


    //endregion

    //region private methods
    private double distanceEstimation(double targetSize, double mills) {
        lastEstimation = (targetSize * 1000) / mills;
        return lastEstimation;
    }

    private double getInputOfText(int id) {
        return Double.parseDouble(((TextView) this.findViewById(id)).getText().toString());
    }

    private void setTextToTextView(int id, String text) {
        TextView textView = (TextView) this.findViewById(id);
        textView.setText(text);
    }

    private void saveDistance() {
        FireProfiles.getSelectedProfile().setTargetRange(lastEstimation);
    }
    //endregion
}
