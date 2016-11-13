package sceinox.atragmx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    Bundle savedInstanceState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState=savedInstanceState;
        setContentView(R.layout.activity_main);
    }


    //region onClickEvents

    public void onGunClick(View view) {
        startActivity(new Intent(this, GunActivity.class));
    }

    public void onAtmsphrClick(View view) {
        startActivity(new Intent(this, AtmsphrActivity.class));
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
        Calculator calculator = new Calculator(this);
        //calculator.calculateSolution();
    }

    public void onGunlistClick(View view){
        startActivity(new Intent(this, GunlistActivity.class));
    }
    //endregion

}