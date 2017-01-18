package sceinox.atragmx.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import sceinox.atragmx.R;
import sceinox.atragmx.logic.DatabaseHelper;
import sceinox.atragmx.logic.FireProfiles;


public class GunlistActivity extends AppCompatActivity {
    private ListView listView;
    private String selected;

    private DatabaseHelper dbHelp = new DatabaseHelper(this);

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


    public void onAddClick(View view) {
        finish();
        startActivity(new Intent(this, GunActivity.class));
        GunActivity.addGunMode = true;
    }

    public void onDeleteClick(View view) {
        dbHelp.deleteGun(selected);
        initListview();
    }

    public void onResetTableClick(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Reset Table")
                .setMessage("Do you really want to reset the guntable to its default values?")
                .setIcon(android.R.drawable.ic_menu_delete)

                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dbHelp.resetDatabase();
                        initListview();
                    }
                })

                .setNegativeButton(android.R.string.no, null).show();
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
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dbHelp.getNamesOfAllGuns());
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
