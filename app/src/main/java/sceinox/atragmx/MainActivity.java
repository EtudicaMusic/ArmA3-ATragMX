package sceinox.atragmx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //region onClickEvents
    public void onGunClick(View view) {

    }

    public void onAtmsphrClick(View view) {

    }

    public void onTargetClick(View view) {

    }

    public void onRCClick(View view) {
        setContentView(R.layout.activity_rangecard);
    }

    public void onResetClick(View view) {

    }

    public void onUpdateClick(View view) {

    }

    public void onTSClick(View view) {

    }

    public void onTRClick(View view) {

    }

    public void onCalcClick(View view) {

    }
    //endregion

    private void printFireSolution(FireSolution newFS, FireSolution oldFS){
                TextView absElev= (TextView) this.findViewById(R.id.Text_Abs_Elev);
    }
}