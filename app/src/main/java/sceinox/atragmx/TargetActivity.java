package sceinox.atragmx;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TargetActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target0);
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
        startActivity(new Intent(this, AtmsphrActivity.class));
    }

    public void onNextClick(View view){
        finish();
        startActivity(new Intent(this, GunActivity.class));
    }
}
