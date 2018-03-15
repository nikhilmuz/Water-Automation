package ga.nikhilkumar.waterautomation;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Login extends AppCompatActivity {

    String ssid="ESPap",pwd="thereisnospoon";
    Button login,ptp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=(Button) findViewById(R.id.login);
        ptp=(Button) findViewById(R.id.ptp);
        final Context context=this.getApplicationContext();

        final Intent dash=new Intent(this,MainActivity.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.setEnabled(false);
                Vars.connect_wifi(context, ssid, pwd);
                while (!Vars.check_wifi_status(context)) {}
                if (Vars.get_wifi_ssid(context).equals(String.format("\"%s\"", ssid))) {
                    Vars.put_string_sp(context,"ssid",ssid);
                    Vars.put_string_sp(context,"key",pwd);
                    login.setEnabled(true);
                    startActivity(dash);
                    finish();
                }
                else{
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                    login.setEnabled(true);
                }
            }
        });
        ptp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(dash);
                finish();
            }
        });
    }
}