package sceinox.atragmx.activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import sceinox.atragmx.R;

public class RangeCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rangecard);
    }

    //region onClickEvents
    public void onCancelClick(View view) {
        finish();
    }

    public void onSetupClick(View view) {
        //// TODO: 17.02.2017 rangecard setup
    }
    //endregion

    //region private methods
    //endregion
}
