package sceinox.atragmx.activities;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import sceinox.atragmx.R;
import sceinox.atragmx.logic.Calculator;
import sceinox.atragmx.logic.FireProfiles;

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
        initListviews();

        scrollbarThread = new Thread(connectScrollbars(new Handler()));
        scrollbarThread.start();

        //// TODO: 19.03.2017 remove later
        for (int i = 0; i < cool.length; i++) {
            cool[i] = (int) (Math.random() * 100);
        }
        displayRangecard(cool, cool, cool, cool);

        //Todo get values from Rangecard Options
        //loadDataToListViews(0,1000,100);
    }

    //region onClickEvents
    public void onCancelClick(View view) {
        scrollbarThread.interrupt();
        finish();
    }

    public void onSetupClick(View view) {
        //// TODO: 17.02.2017 rangecard options screen
    }
    //endregion

    //region private methods

    //region scrollbars
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
        int scroll = 0;
        try {
            View c = listViewTmFlt.getChildAt(0);
            scroll = -c.getTop() + listViewTmFlt.getFirstVisiblePosition() * c.getHeight();
        } catch (NullPointerException ex) {

        }


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
    //endregion

    //region listviews
    private void initListviews() {
        listViewMeters = (ListView) this.findViewById(R.id.List_meters);
        listViewElev = (ListView) this.findViewById(R.id.List_Elev);
        listViewWind = (ListView) this.findViewById(R.id.List_Wind);
        listViewTmFlt = (ListView) this.findViewById(R.id.List_TmFlt);

        listViewMeters.setEnabled(false);
        listViewElev.setEnabled(false);
        listViewWind.setEnabled(false);

    }

    //// TODO: 19.03.2017 needs testing
    private void loadDataToListViews(int fromMeter, int toMeter, int intervalMeter) {
        if (((toMeter - fromMeter) % intervalMeter) == 0) {
            throw new IllegalArgumentException("not dividable by intervalMeters");
        }
        int steps = (toMeter - fromMeter) / intervalMeter;

        double[] meter = new double[steps];
        double[] elev = new double[steps];
        double[] wind = new double[steps];
        double[] tmFlt = new double[steps];

        //Todo rework after calculator is finished
        FireProfiles.Profile profile = FireProfiles.getSelectedProfile();
        int i = 0;
        while (fromMeter != toMeter) {
            meter[i] = fromMeter;

            elev[i] = new Calculator(profile.getBoreHeight(), profile.getBulletWeight(), profile.getC1Coefficient(), profile.getMuzzleVelocity(), profile.getZeroRange(),
                    profile.getTemperature(), profile.getBarometricPressure(), profile.getHumidity(),
                    profile.getWindSpeed(), profile.getWindDirection(), profile.getInclinationAngleCosine(), profile.getTargetSpeed(), fromMeter)
                    .calculateSolution().getElevation();

            wind[i] = new Calculator(profile.getBoreHeight(), profile.getBulletWeight(), profile.getC1Coefficient(), profile.getMuzzleVelocity(), profile.getZeroRange(),
                    profile.getTemperature(), profile.getBarometricPressure(), profile.getHumidity(),
                    profile.getWindSpeed(), profile.getWindDirection(), profile.getInclinationAngleCosine(), profile.getTargetSpeed(), fromMeter)
                    .calculateSolution().getWind()[0];

            tmFlt[i] = new Calculator(profile.getBoreHeight(), profile.getBulletWeight(), profile.getC1Coefficient(), profile.getMuzzleVelocity(), profile.getZeroRange(),
                    profile.getTemperature(), profile.getBarometricPressure(), profile.getHumidity(),
                    profile.getWindSpeed(), profile.getWindDirection(), profile.getInclinationAngleCosine(), profile.getTargetSpeed(), fromMeter)
                    .calculateSolution().getTOF();

            fromMeter += intervalMeter;
            i++;
        }
        fillListview(listViewMeters, convertToStringArray(meter));
        fillListview(listViewElev, convertToStringArray(elev));
        fillListview(listViewWind, convertToStringArray(wind));
        fillListview(listViewTmFlt, convertToStringArray(tmFlt));

    }

    private void fillListview(ListView listView, String[] data) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
    }
    //endregion

    private String[] convertToStringArray(double[] source) {
        String[] target = new String[source.length];
        for (int i = 0; i < source.length; i++) {
            target[i] = String.valueOf(source[i]);
        }
        return target;
    }
    //endregion

}

