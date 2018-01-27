package ga.nikhilkumar.waterautomation;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity implements View.OnClickListener{

    Button login, irri, tankMag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        irri = (Button) findViewById(R.id.irri);
        tankMag = (Button) findViewById(R.id.tankmag);
        irri.setOnClickListener(this);
        tankMag.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int tempId = view.getId();
        Class tempCla;
            if (tempId == irri.getId()) {
             tempCla = Irrigation.class;
         } else if (tempId == tankMag.getId()) {
             tempCla = TankManagement.class;
         } else {
             Toast.makeText(this , "something went wrong :(",Toast.LENGTH_SHORT).show();
            return;
         }
        Intent stAc = new Intent(this, tempCla);
        startActivity(stAc);
    }
}
