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
    Button login,ptp,test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ssid=(EditText) findViewById(R.id.ssid);
        pwd=(EditText) findViewById(R.id.pwd);
        login=(Button) findViewById(R.id.login);
        ptp=(Button) findViewById(R.id.ptp);
        test=(Button) findViewById(R.id.test);
        final Context context=this.getApplicationContext();

        final Intent dash=new Intent(this,MainActivity.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.setEnabled(false);
                Vars.connect_wifi(context, String.valueOf(ssid.getText()), String.valueOf(pwd.getText()));
                while (!Vars.check_wifi_status(context)) {}
                if (Vars.get_wifi_ssid(context).equals(String.format("\"%s\"", String.valueOf(ssid.getText())))) {
                    Vars.put_string_sp(context,"ssid",String.valueOf(ssid.getText()));
                    Vars.put_string_sp(context,"key",String.valueOf(pwd.getText()));
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
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, Vars.get_string_sp(context,"name"), Toast.LENGTH_SHORT).show();
            }
        });
    }
}