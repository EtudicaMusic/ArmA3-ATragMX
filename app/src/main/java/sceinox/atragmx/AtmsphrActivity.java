package sceinox.atragmx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class AtmsphrActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atmsphr0);
    }

    public void onDoneClick(View view){
        //ToDo: Save Values
        finish();
    }

    public void onCancelClick(View view){
        finish();
    }

    public void onPrevClick(View view){
        startActivity(new Intent(this, GunActivity.class));
    }

    public void onNextClick(View view){
        System.out.println("next");
    }
}