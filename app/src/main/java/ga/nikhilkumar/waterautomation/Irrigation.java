package ga.nikhilkumar.waterautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;



public class Irrigation extends AppCompatActivity {
    ToggleButton t1, t2, t3, t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irrigation);
        t1 = (ToggleButton) findViewById(R.id.t1);
        t2 = (ToggleButton) findViewById(R.id.t2);
        t3 = (ToggleButton) findViewById(R.id.t3);
        t4 = (ToggleButton) findViewById(R.id.t4);

        t1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sendRequest("http://192.168.4.1/s1on");
                } else {
                    sendRequest("http://192.168.4.1/s1off");
                }
            }
        });
        t2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sendRequest("http://192.168.4.1/s2on");
                } else {
                    sendRequest("http://192.168.4.1/s2off");
                }
            }
        });
        t3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sendRequest("http://192.168.4.1/s3on");
                } else {
                    sendRequest("http://192.168.4.1/s3off");
                }
            }
        });
        t4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sendRequest("http://192.168.4.1/s4on");
                } else {
                    sendRequest("http://192.168.4.1/s4off");
                }
            }
        });
    }
    public void sendRequest(String url) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Irrigation.this, "Yeah :)", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Irrigation.this, "Oh :(", Toast.LENGTH_SHORT).show();
                Toast.makeText(Irrigation.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        mRequestQueue.add(request);
    }
}
