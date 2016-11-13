package sceinox.atragmx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GunlistActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunlist);
    }

    //region onClickEvents
    public void onOpenClick(View view) {
        System.out.println("test");
    }

    public void onSaveClick(View view) {
        System.out.println("test");
    }

    public void onAddClick(View view) {
        System.out.println("test");
    }

    public void onDeleteClick(View view) {
        System.out.println("test");
    }

    public void onNoteClick(View view) {
        System.out.println("test");
    }

    public void onDoneClick(View view) {
        System.out.println("test");
    }
    //endregion

}
