package sceinox.atragmx;

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
        System.out.println("done");
    }

    public void onCancelClick(View view){
        System.out.println("cancel");
    }

    public void onPrevClick(View view){
        System.out.println("prev");
    }

    public void onNextClick(View view){
        System.out.println("next");
    }

}
