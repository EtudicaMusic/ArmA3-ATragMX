package sceinox.atragmx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class GunlistActivity extends AppCompatActivity {
    private ArrayAdapter adapter;
    private ListView listView;
    private String selected;

    private DatabaseHelper dbHelp=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunlist);
        initListview();
    }

    //region onClickEvents
    public void onOpenClick(View view) {
        listView.setSelection(4);

        FireProfiles.getSelectedProfile().setGun(selected);
        finish();
    }

    public void onSaveClick(View view) {
        System.out.println("test");
    }

    public void onAddClick(View view) {
        finish();
        startActivity(new Intent(this, GunActivity.class));
        GunActivity.addGunMode=true;
    }

    public void onDeleteClick(View view) {
        System.out.println("test");
    }

    public void onNoteClick(View view) {
        System.out.println("test");
    }

    public void onDoneClick(View view) {
        finish();
    }
    //endregion

    //region private methods
    private void initListview() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dbHelp.getNamesOfAllGuns());
        listView = (ListView) findViewById(R.id.List_Gunlist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                selected = (String) listView.getItemAtPosition(position);
            }
        });
    }

    //endregion
}
