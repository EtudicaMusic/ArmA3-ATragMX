package sceinox.atragmx.activities;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import sceinox.atragmx.R;

public class RangeCardActivity extends AppCompatActivity {
    private Thread scrollbarThread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rangecard);
        scrollbarThread = new Thread(connectScrollbars(new Handler()));
        scrollbarThread.start();
    }

    //region onClickEvents
    public void onCancelClick(View view) {
        scrollbarThread.interrupt();
        finish();
    }

    public void onSetupClick(View view) {
        //// TODO: 17.02.2017 rangecard setup
    }
    //endregion

    //region private methods
    private Thread connectScrollbars(Handler handlerForUI) {
        return new Thread(() -> {
            while (true) {
                handlerForUI.post(this::moveScrollbars);
            }
        });
    }

    private void moveScrollbars() {
        ListView listViewMeters = (ListView) this.findViewById(R.id.List_meters);
        ListView listViewElev = (ListView) this.findViewById(R.id.List_Elev);
        ListView listViewWind = (ListView) this.findViewById(R.id.List_Wind);
        ListView listViewTimeOfTmFlt = (ListView) this.findViewById(R.id.List_TmFlt);

        listViewMeters.scrollTo(listViewTimeOfTmFlt.getScrollX(), listViewTimeOfTmFlt.getScrollY());
        listViewElev.scrollTo(listViewTimeOfTmFlt.getScrollX(), listViewTimeOfTmFlt.getScrollY());
        listViewWind.scrollTo(listViewTimeOfTmFlt.getScrollX(), listViewTimeOfTmFlt.getScrollY());
    }
    //endregion
}
