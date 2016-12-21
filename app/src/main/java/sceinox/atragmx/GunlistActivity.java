package sceinox.atragmx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;

public class GunlistActivity extends AppCompatActivity {
    private ArrayAdapter adapter;
    private ListView listView;
    private String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunlist);
        initListview();
    }

    //region onClickEvents
    public void onOpenClick(View view) {
        listView.setSelection(4);
        HashMap guns = getGunNames();
        FireProfiles.getSelectedProfile().setGun((Integer) guns.get(selected));
        finish();
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
        finish();
    }
    //endregion

    //region private methods
    private void initListview() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getGunNamesArray());
        listView = (ListView) findViewById(R.id.List_Gunlist);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                selected = (String) listView.getItemAtPosition(position);
            }
        });
    }

    private HashMap<String, Integer> getGunNames() {
        int[] ids = {R.array.cal_127x108mm, R.array.cal_127x99mm, R.array.cal_127x99mm_AMAX, R.array.cal_127x99mm_API, R.array.cal_127x54mm,
                R.array.cal_408_CheyTac, R.array.cal_93x64mm, R.array.cal_338LM_250gr, R.array.cal_338LM_300gr, R.array.cal_338LM_API526,
                R.array.cal_300WM_Mk248_Mod0, R.array.cal_300WM_Mk248_Mod1, R.array.cal_300WM_Berger_OTM};
        HashMap<String, Integer> guns = new HashMap<>();
        for (int id : ids) {
            String[] gun = this.getResources().getStringArray(id);
            guns.put(gun[7], id);
        }
        return guns;
    }

    private String[] getGunNamesArray() {
        HashMap<String, Integer> guns = getGunNames();
        String[] names = new String[guns.size()];
        int itt = 0;
        for (String name : guns.keySet()) {
            names[itt] = name;
            itt++;
        }
        return names;
    }
    //endregion
}
