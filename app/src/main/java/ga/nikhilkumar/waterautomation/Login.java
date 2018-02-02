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

    EditText ssid,pwd;
    Button login,ptp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ssid=(EditText) findViewById(R.id.ssid);
        pwd=(EditText) findViewById(R.id.pwd);
        login=(Button) findViewById(R.id.login);
        ptp=(Button) findViewById(R.id.ptp);
        Context context=this.getApplicationContext();
        WifiConfiguration wifiConfig = new WifiConfiguration();

        wifiConfig.SSID = String.format("\"%s\"", "Nikhil");
        wifiConfig.preSharedKey = String.format("\"%s\"", "password");

        WifiManager wifiManager=(WifiManager)context.getSystemService(WIFI_SERVICE);
        int netId = wifiManager.addNetwork(wifiConfig);
        wifiManager.disconnect();
        wifiManager.enableNetwork(netId, true);
        wifiManager.reconnect();

        final Intent dash=new Intent(this,Dashboard.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Login.this, "Unavailable", Toast.LENGTH_SHORT).show();
            }
        });
        ptp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(dash);
            }
        });
    }
}