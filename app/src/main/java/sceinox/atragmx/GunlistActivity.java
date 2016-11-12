package sceinox.atragmx;



import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GunlistActivity extends AppCompatActivity {


    public GunlistActivity(MainActivity mainActivity){
        mainActivity.setContentView(R.layout.activity_gunlist);
    }

    //region onClickEvents
    public void onOpenClick(View view){
        System.out.println("1");
    }

    public void onSaveClick(View view){
        System.out.println("2");
    }

    public void onAddClick(View view){
        System.out.println("3");
    }

    public void onDeleteClick(View view){
        System.out.println("4");
    }

    public void onNoteClick(View view){
        System.out.println("5");
    }

    public void onDoneClick(View view){
        System.out.println("6");
    }
    //endregion

}
