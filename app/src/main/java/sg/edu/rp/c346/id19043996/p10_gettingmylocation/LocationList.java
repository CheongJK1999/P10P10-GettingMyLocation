package sg.edu.rp.c346.id19043996.p10_gettingmylocation;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LocationList extends AppCompatActivity {
    ArrayList<Locations> alLocation;
    LocationAdapter aaLocation;
    ListView lvLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location);

        lvLocation = findViewById(R.id.lvUpdates);
        alLocation = new ArrayList<>();
        DBHelper db = new DBHelper(LocationList.this);
        alLocation = db.getAllLocations();
        aaLocation = new LocationAdapter(this, R.layout.row, alLocation);
        lvLocation.setAdapter(aaLocation);

    }
}
