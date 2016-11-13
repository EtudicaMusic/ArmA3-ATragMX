package sceinox.atragmx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GunActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gun0);
    }

    public void onDoneClick(View view){
        //ToDo: Save Values
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

}
//Commas should be replaced with dots (text fields)