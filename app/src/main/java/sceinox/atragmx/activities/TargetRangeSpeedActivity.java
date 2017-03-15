package sceinox.atragmx.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sceinox.atragmx.R;
import sceinox.atragmx.logic.FireProfiles;


public class TargetRangeSpeedActivity extends AppCompatActivity {
    public static boolean targetRangeMode = true;
    public static boolean finishToTargetActivity = false;
    private double lastRangeEstimation;
    private double lastSpeedEstimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_range_speed);
        modeSwitch();
    }

    //region onClick Events
    public void onBackClick(View view) {
        finish();
        if (finishToTargetActivity) {
            finishToTargetActivity = false;
            startActivity(new Intent(this, TargetActivity.class));
        }
    }

    public void onApplyValueClick(View view) {
        saveDistanceOrSpeed();
        finish();
        if (finishToTargetActivity) {
            finishToTargetActivity = false;
            startActivity(new Intent(this, TargetActivity.class));
        }
    }

    public void onCalcClick(View view) {
        if (targetRangeMode) {
            setTextToTextView(R.id.Solution_Distance_Speed,
                    String.valueOf(
                            distanceEstimation(
                                    getInputOfText(R.id.Edit_Target_Height_Range),
                                    getInputOfText(R.id.Edit_Mills)
                            )));
        } else {
            setTextToTextView(R.id.Solution_Distance_Speed,
                    String.valueOf(
                            speedEstimation(
                                    getInputOfText(R.id.Edit_Target_Height_Range),
                                    getInputOfText(R.id.Edit_Mills),
                                    getInputOfText(R.id.Edit_Time)
                            )
                    ));
        }
    }

    public void onStartClick(View view) {
        //TODO count seconds until pressed again
    }


    //endregion

    //region private methods
    private double distanceEstimation(double targetSize, double mills) {
        lastRangeEstimation = (targetSize * 1000) / mills;
        return lastRangeEstimation;
    }

    private double speedEstimation(double targetRange, double mills, double secs) {
        // TODO: 14.03.2017  do calculating
        //lastSpeedEstimation = ###add formula here###
        return lastSpeedEstimation;
    }

    private double getInputOfText(int id) {
        return Double.parseDouble(((TextView) this.findViewById(id)).getText().toString());
    }

    private void setTextToTextView(int id, String text) {
        TextView textView = (TextView) this.findViewById(id);
        textView.setText(text);
    }

    private void saveDistanceOrSpeed() {
        if (targetRangeMode) {
            FireProfiles.getSelectedProfile().setTargetRange(lastRangeEstimation);
        } else {
            FireProfiles.getSelectedProfile().setTargetSpeed(lastSpeedEstimation);
        }
    }

    private void modeSwitch() {
        TextView textTime = (TextView) this.findViewById(R.id.Text_Time);
        TextView editTime = (TextView) this.findViewById(R.id.Edit_Time);
        Button startTime = (Button) this.findViewById(R.id.Button_Time_Start);
        if (targetRangeMode) {
            setTextToTextView(R.id.Text_TargetHeight_Range, "Target Height (m)");
            setTextToTextView(R.id.Edit_Target_Height_Range, "2");
            setTextToTextView(R.id.Text_Mils, "MIL in Scope");
            setTextToTextView(R.id.Edit_Mills, "0.5");
            setTextToTextView(R.id.Text_Distance_Speed, "Distance");
            setTextToTextView(R.id.Solution_Distance_Speed, "");

            textTime.setVisibility(View.INVISIBLE);
            editTime.setVisibility(View.INVISIBLE);
            startTime.setVisibility(View.INVISIBLE);
        } else {
            setTextToTextView(R.id.Text_TargetHeight_Range, "Target Range (m)");
            setTextToTextView(R.id.Edit_Target_Height_Range, "800");
            setTextToTextView(R.id.Text_Mils, "MIL in Scope");
            setTextToTextView(R.id.Edit_Mills, "2");
            setTextToTextView(R.id.Text_Time, "Time (secs)");
            setTextToTextView(R.id.Edit_Time, "");
            setTextToTextView(R.id.Text_Distance_Speed, "Speed");
            setTextToTextView(R.id.Solution_Distance_Speed, "");

            textTime.setVisibility(View.VISIBLE);
            editTime.setVisibility(View.VISIBLE);
            startTime.setVisibility(View.VISIBLE);
        }
    }
    //endregion

}
