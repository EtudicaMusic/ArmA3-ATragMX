package sceinox.atragmx;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


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

    public void onGunlistClick(View view){
        startActivity(new Intent(this, GunlistActivity.class));
    }

    public void onAClick(View view){
        colorProfileSwitch('a');
        fireFrofileSwitch('a');


        System.out.println("a");
    }

    public void onBClick(View view){
        colorProfileSwitch('b');
        fireFrofileSwitch('b');

        System.out.println("b");
    }

    public void onCClick(View view){
        colorProfileSwitch('c');
        colorProfileSwitch('c');

        System.out.println("c");
    }

    public void onDClick(View view){
        colorProfileSwitch('d');
        colorProfileSwitch('d');

        System.out.println("d");
    }

    public void onMClick(View view) {
        messurementColorSwitch('m');
    }

    public void onEClick(View view) {
        messurementColorSwitch('e');
    }

    public void onUpperDClick(View view) {
        messurementColorSwitch('d');
    }
    //endregion

    //region private methods
    private void messurementColorSwitch(char profile){
        Button d = (Button) findViewById(R.id.Button_D);
        Button e = (Button) findViewById(R.id.Button_E);
        Button m = (Button) findViewById(R.id.Button_M);

        switch (profile){
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

    private void colorProfileSwitch(char profile){
        Button a = (Button) this.findViewById(R.id.Button_A);
        Button b = (Button) this.findViewById(R.id.Button_B);
        Button c = (Button) this.findViewById(R.id.Button_C);
        Button d = (Button) this.findViewById(R.id.Button_D_Profile);

        switch (profile){
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

    private void fireFrofileSwitch(char profile){
        switch (profile){
            case 'a':
                //FireProfiles.setSelectedProfileToA();
                break;

            case 'b':
                //FireProfiles.setSelectedProfileToB();
                break;

            case 'c':
                //FireProfiles.setSelectedProfileToC();
                break;

            case 'd':
                //FireProfiles.setSelectedProfileToD();
                break;
        }
    }

    //endregion

}