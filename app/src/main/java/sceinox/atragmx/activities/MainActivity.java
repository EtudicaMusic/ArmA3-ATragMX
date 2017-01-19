package sceinox.atragmx.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sceinox.atragmx.R;
import sceinox.atragmx.logic.Calculator;
import sceinox.atragmx.logic.FireProfiles;


public class MainActivity extends AppCompatActivity {

    Bundle savedInstanceState;

    //region activity states
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        setContentView(R.layout.activity_main);
        new FireProfiles(this);
        FireProfiles.setStartWeapon();
        fireProfileSwitch('a');
    }

    @Override
    protected void onStart() {
        super.onStart();
        initTextViews();
    }
    //endregion

    //region onClickEvents
    public void onGunClick(View view) {
        startActivity(new Intent(this, GunActivity.class));
    }

    public void onAtmsphrClick(View view) {
        startActivity(new Intent(this, AtmsphrActivity.class));
    }

    public void onTargetClick(View view) {
        startActivity(new Intent(this, TargetActivity.class));
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

    public void onGunlistClick(View view) {
        startActivity(new Intent(this, GunListActivity.class));
    }

    public void onAClick(View view) {
        colorProfileSwitch('a');
        fireProfileSwitch('a');
        initTextViews();

        System.out.println("a");
    }

    public void onBClick(View view) {
        colorProfileSwitch('b');
        fireProfileSwitch('b');
        initTextViews();

        System.out.println("b");
    }

    public void onCClick(View view) {
        colorProfileSwitch('c');
        fireProfileSwitch('c');
        initTextViews();

        System.out.println("c");
    }

    public void onDClick(View view) {
        colorProfileSwitch('d');
        fireProfileSwitch('d');
        initTextViews();

        System.out.println("d");
    }

    public void onMClick(View view) {
        measurementColorSwitch('m');
    }

    public void onEClick(View view) {
        measurementColorSwitch('e');
    }

    public void onUpperDClick(View view) {
        measurementColorSwitch('d');
    }

    public void onLeadClick(View view) {
        if (getTextFromTextView(R.id.Text_WS).equals("WS")) {
            setTextToTextView(R.id.Text_WS, "WS/WS2");
            setTextToTextView(R.id.Text_WSVal, String.valueOf(FireProfiles.getSelectedProfile().getWindSpeed()) + "/" +
                    String.valueOf(FireProfiles.getSelectedProfile().getWindSpeed2()));
            setTextToTextView(R.id.Button_Lead, "Wind 2");
        } else {
            setTextToTextView(R.id.Text_WS, "WS");
            setTextToTextView(R.id.Text_WSVal, String.valueOf(FireProfiles.getSelectedProfile().getWindSpeed()));
            setTextToTextView(R.id.Button_Lead, "Lead");
        }
    }
    //endregion

    //region private methods
    private void measurementColorSwitch(char profile) {
        Button d = (Button) findViewById(R.id.Button_D);
        Button e = (Button) findViewById(R.id.Button_E);
        Button m = (Button) findViewById(R.id.Button_M);

        switch (profile) {
            case 'd':
                d.setBackgroundColor(Color.BLACK);
                d.setTextColor(Color.WHITE);

                e.setBackgroundColor(Color.WHITE);
                e.setTextColor(Color.BLACK);

                m.setBackgroundColor(Color.WHITE);
                m.setTextColor(Color.BLACK);
                break;

            case 'e':
                e.setBackgroundColor(Color.BLACK);
                e.setTextColor(Color.WHITE);

                d.setBackgroundColor(Color.WHITE);
                d.setTextColor(Color.BLACK);

                m.setBackgroundColor(Color.WHITE);
                m.setTextColor(Color.BLACK);
                break;

            case 'm':
                m.setBackgroundColor(Color.BLACK);
                m.setTextColor(Color.WHITE);

                d.setBackgroundColor(Color.WHITE);
                d.setTextColor(Color.BLACK);

                e.setBackgroundColor(Color.WHITE);
                e.setTextColor(Color.BLACK);
                break;
        }
    }

    private void colorProfileSwitch(char profile) {
        Button a = (Button) this.findViewById(R.id.Button_A_Profile);
        Button b = (Button) this.findViewById(R.id.Button_B_Profile);
        Button c = (Button) this.findViewById(R.id.Button_C_Profile);
        Button d = (Button) this.findViewById(R.id.Button_D_Profile);

        switch (profile) {
            case 'a':
                a.setBackgroundColor(Color.BLACK);
                a.setTextColor(Color.WHITE);

                b.setBackgroundColor(Color.WHITE);
                b.setTextColor(Color.BLACK);

                c.setBackgroundColor(Color.WHITE);
                c.setTextColor(Color.BLACK);

                d.setBackgroundColor(Color.WHITE);
                d.setTextColor(Color.BLACK);
                break;

            case 'b':
                a.setBackgroundColor(Color.WHITE);
                a.setTextColor(Color.BLACK);

                b.setBackgroundColor(Color.BLACK);
                b.setTextColor(Color.WHITE);

                c.setBackgroundColor(Color.WHITE);
                c.setTextColor(Color.BLACK);

                d.setBackgroundColor(Color.WHITE);
                d.setTextColor(Color.BLACK);
                break;

            case 'c':
                a.setBackgroundColor(Color.WHITE);
                a.setTextColor(Color.BLACK);

                b.setBackgroundColor(Color.WHITE);
                b.setTextColor(Color.BLACK);

                c.setBackgroundColor(Color.BLACK);
                c.setTextColor(Color.WHITE);

                d.setBackgroundColor(Color.WHITE);
                d.setTextColor(Color.BLACK);
                break;

            case 'd':
                a.setBackgroundColor(Color.WHITE);
                a.setTextColor(Color.BLACK);

                b.setBackgroundColor(Color.WHITE);
                b.setTextColor(Color.BLACK);

                c.setBackgroundColor(Color.WHITE);
                c.setTextColor(Color.BLACK);

                d.setBackgroundColor(Color.BLACK);
                d.setTextColor(Color.WHITE);
                break;
        }
    }

    private void fireProfileSwitch(char profile) {
        switch (profile) {
            case 'a':
                FireProfiles.setSelectedProfileToA();
                break;

            case 'b':
                FireProfiles.setSelectedProfileToB();
                break;

            case 'c':
                FireProfiles.setSelectedProfileToC();
                break;

            case 'd':
                FireProfiles.setSelectedProfileToD();
                break;
        }
    }

    private void initTextViews() {
        //Header
        setTextToTextView(R.id.Text_CaliberVal, FireProfiles.getSelectedProfile().getWeaponName());

        //Gun
        setTextToTextView(R.id.Text_BHVal, String.valueOf(FireProfiles.getSelectedProfile().getBoreHeight()));
        setTextToTextView(R.id.Text_BWVal, String.valueOf(FireProfiles.getSelectedProfile().getBulletWeight()));
        setTextToTextView(R.id.Text_C1Val, String.valueOf(FireProfiles.getSelectedProfile().getC1Coefficient()));
        setTextToTextView(R.id.Text_MVVal, String.valueOf(FireProfiles.getSelectedProfile().getMuzzleVelocity()));
        setTextToTextView(R.id.Text_ZRVal, String.valueOf(FireProfiles.getSelectedProfile().getZeroRange()));

        //Atmosphere
        setTextToTextView(R.id.Text_TmpVal, String.valueOf(FireProfiles.getSelectedProfile().getTemperature()));
        setTextToTextView(R.id.Text_AltVal, String.valueOf(FireProfiles.getSelectedProfile().getAltitude()));
        //TODO barPress,humidity

        //Target
        setTextToTextView(R.id.Text_WSVal, String.valueOf(FireProfiles.getSelectedProfile().getWindSpeed()));
        setTextToTextView(R.id.Text_WDVal, String.valueOf(FireProfiles.getSelectedProfile().getWindDirection()));
        setTextToTextView(R.id.Text_IAVal, String.valueOf(FireProfiles.getSelectedProfile().getInclinationAngleDegree()));
        setTextToTextView(R.id.Text_TSVal, String.valueOf(FireProfiles.getSelectedProfile().getTargetSpeed()));
        setTextToTextView(R.id.Text_TRVal, String.valueOf(FireProfiles.getSelectedProfile().getTargetRange()));
    }

    private void setTextToTextView(int id, String text) {
        TextView textView = (TextView) this.findViewById(id);
        textView.setText(text);
    }

    private String getTextFromTextView(int id) {
        return ((TextView) this.findViewById(id)).getText().toString();
    }


    //endregion

}