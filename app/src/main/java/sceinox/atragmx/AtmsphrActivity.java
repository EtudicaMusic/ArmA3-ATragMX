package sceinox.atragmx;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AtmsphrActivity extends AppCompatActivity{
    private Boolean MethodIsTBH=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atmsphr);
        buttonColorSwitch("tbh");
        updateCalcMethod();
    }

    //region OnClickEvents
    public void onDoneClick(View view){
        saveChangesToProfile();
        finish();
    }

    public void onCancelClick(View view){
        finish();
    }

    public void onPrevClick(View view){
        saveChangesToProfile();
        finish();
        startActivity(new Intent(this, GunActivity.class));
    }

    public void onNextClick(View view){
        saveChangesToProfile();
        finish();
        startActivity(new Intent(this, TargetActivity.class));
    }

    public void onATClick(View view) {
        MethodIsTBH=false;
        updateCalcMethod();
        buttonColorSwitch("at");
    }

    public void onTBHClick(View view) {
        MethodIsTBH=true;
        updateCalcMethod();
        buttonColorSwitch("tbh");
    }
    //endregion

    //region private methods
    private void saveChangesToProfile(){
        FireProfiles.Profile profile = FireProfiles.getSelectedProfile();
        if (MethodIsTBH){
            profile.setTemperature(getInputOfText(R.id.Edit_Altitude_Temperature));
            profile.setBarometricPressure(getInputOfText(R.id.Edit_Temperature_BarPress));
            profile.setHumidity(getInputOfText(R.id.Edit_None_Humidity));
        }else {
            profile.setAltitude(getInputOfText(R.id.Edit_Altitude_Temperature));
            profile.setTemperature(getInputOfText(R.id.Edit_Temperature_BarPress));
        }
    }

    private void updateCalcMethod(){
        TextView humidityText=(TextView) this.findViewById(R.id.Text_None_Humidity);
        TextView humidityEdit=(TextView) this.findViewById(R.id.Edit_None_Humidity);
        if (MethodIsTBH){
            humidityText.setVisibility(View.VISIBLE);
            humidityEdit.setVisibility(View.VISIBLE);

            setTextToTextView(R.id.Text_Altitude_Temperature,"Temperature (°C)");
            setTextToTextView(R.id.Edit_Altitude_Temperature, String.valueOf(FireProfiles.getSelectedProfile().getTemperature()));
            setTextToTextView(R.id.Text_Temperature_BarPress,"Pressure (hPa)");
            setTextToTextView(R.id.Edit_Temperature_BarPress, String.valueOf(FireProfiles.getSelectedProfile().getBarometricPressure()));
            setTextToTextView(R.id.Text_None_Humidity, "Humidity (%)");
            setTextToTextView(R.id.Edit_None_Humidity, String.valueOf(FireProfiles.getSelectedProfile().getHumidity()));
        }else {
            humidityText.setVisibility(View.INVISIBLE);
            humidityEdit.setVisibility(View.INVISIBLE);

            setTextToTextView(R.id.Text_Altitude_Temperature,"Altitude (m)");
            setTextToTextView(R.id.Edit_Altitude_Temperature, String.valueOf(FireProfiles.getSelectedProfile().getAltitude()));
            setTextToTextView(R.id.Text_Temperature_BarPress,"Temperature (°C)");
            setTextToTextView(R.id.Edit_Temperature_BarPress, String.valueOf(FireProfiles.getSelectedProfile().getTemperature()));
        }
    }

    private void setTextToTextView(int id, String text) {
        TextView textView = (TextView) this.findViewById(id);
        textView.setText(text);
    }

    private double getInputOfText(int id){
        return Double.parseDouble(((TextView) this.findViewById(id)).getText().toString());
    }

    private void buttonColorSwitch(String calcMethod){
        Button at = (Button) findViewById(R.id.Button_AT);
        Button tbh = (Button) findViewById(R.id.Button_TBH);

        if (calcMethod.equals("at")){
            at.setBackgroundColor(Color.BLACK);
            at.setTextColor(Color.WHITE);

            tbh.setBackgroundColor(Color.WHITE);
            tbh.setTextColor(Color.BLACK);
        } else if (calcMethod.equals("tbh")){
            tbh.setBackgroundColor(Color.BLACK);
            tbh.setTextColor(Color.WHITE);

            at.setBackgroundColor(Color.WHITE);
            at.setTextColor(Color.BLACK);
        }
    }
    //endregion
}
