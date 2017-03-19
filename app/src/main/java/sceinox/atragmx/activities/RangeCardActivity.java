package sceinox.atragmx.activities;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import sceinox.atragmx.R;

public class RangeCardActivity extends AppCompatActivity {
    private ListView listViewMeters;
    private ListView listViewElev;
    private ListView listViewWind;
    private ListView listViewTmFlt;
    private Thread scrollbarThread;

    //// TODO: 19.03.2017 remove later
    private double[] cool = new double[10];


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rangecard);
        loadListviews();

        scrollbarThread = new Thread(connectScrollbars(new Handler()));
        scrollbarThread.start();

        //// TODO: 19.03.2017 remove later
        for (int i = 0; i < cool.length; i++) {
            cool[i] = (int) (Math.random() * 100);
        }
        displayRangecard(cool, cool, cool, cool);
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
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void moveScrollbars() {
        View c = listViewTmFlt.getChildAt(0);
        int scroll = -c.getTop() + listViewTmFlt.getFirstVisiblePosition() * c.getHeight();

        listViewMeters.scrollTo(0, scroll);
        listViewElev.scrollTo(0, scroll);
        listViewWind.scrollTo(0, scroll);
    }

    private void displayRangecard(double[] meter, double[] elev, double[] wind, double[] tmFlt) {
        fillListview(listViewMeters, convertToStringArray(meter));
        fillListview(listViewElev, convertToStringArray(elev));
        fillListview(listViewWind, convertToStringArray(wind));
        fillListview(listViewTmFlt, convertToStringArray(tmFlt));
    }

    private void fillListview(ListView listView, String[] data) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        //disable listviews without scrollbar
        if (!listView.equals(listViewTmFlt)) {
            listView.setEnabled(false);
        }
    }

    private String[] convertToStringArray(double[] source) {
        String[] target = new String[source.length];
        for (int i = 0; i < source.length; i++) {
            target[i] = String.valueOf(source[i]);
        }
        return target;
    }

    private void loadListviews() {
        listViewMeters = (ListView) this.findViewById(R.id.List_meters);
        listViewElev = (ListView) this.findViewById(R.id.List_Elev);
        listViewWind = (ListView) this.findViewById(R.id.List_Wind);
        listViewTmFlt = (ListView) this.findViewById(R.id.List_TmFlt);
    }
    //endregion

}

