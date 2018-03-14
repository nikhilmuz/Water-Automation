package ga.nikhilkumar.waterautomation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class IrrigationFragment extends Fragment {
Button s1onbtn,s1offbtn,s1autobtn,s2onbtn,s2offbtn,s2autobtn,s3onbtn,s3offbtn,s3autobtn,s4onbtn,s4offbtn,s4autobtn;
String ip="192.168.4.1";
    public IrrigationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_irrigation, container, false);
        // Inflate the layout for this fragment
        s1onbtn = (Button) v.findViewById(R.id.oneon);
        s1onbtn.setOnClickListener(onclick);
        s1offbtn = (Button) v.findViewById(R.id.oneoff);
        s1offbtn.setOnClickListener(onclick);
        s1autobtn = (Button) v.findViewById(R.id.oneauto);
        s1autobtn.setOnClickListener(onclick);
        s2onbtn = (Button) v.findViewById(R.id.twoon);
        s2onbtn.setOnClickListener(onclick);
        s2offbtn = (Button) v.findViewById(R.id.twooff);
        s2offbtn.setOnClickListener(onclick);
        s2autobtn = (Button) v.findViewById(R.id.twoauto);
        s2autobtn.setOnClickListener(onclick);
        s3onbtn = (Button) v.findViewById(R.id.threeon);
        s3onbtn.setOnClickListener(onclick);
        s3offbtn = (Button) v.findViewById(R.id.threeoff);
        s3offbtn.setOnClickListener(onclick);
        s3autobtn = (Button) v.findViewById(R.id.threeauto);
        s3autobtn.setOnClickListener(onclick);
        s4onbtn = (Button) v.findViewById(R.id.fouron);
        s4onbtn.setOnClickListener(onclick);
        s4offbtn = (Button) v.findViewById(R.id.fouroff);
        s4offbtn.setOnClickListener(onclick);
        s4autobtn = (Button) v.findViewById(R.id.fourauto);
        s4autobtn.setOnClickListener(onclick);

        return v;
    }
    public void sendRequest(String url) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(), "Success :)", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Connectivity Error :(", Toast.LENGTH_SHORT).show();
            }
        });
        mRequestQueue.add(request);
    }
    private View.OnClickListener onclick;

    {
        onclick = new View.OnClickListener() {
            String req="";
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.oneon: {
                        req="11";
                        break;
                    }
                    case R.id.oneoff: {
                        req="10";
                        break;
                    }
                    case R.id.oneauto: {
                        req="12";
                        break;
                    }
                    case R.id.twoon: {
                        req="21";
                        break;
                    }
                    case R.id.twooff: {
                        req="20";
                        break;
                    }
                    case R.id.twoauto: {
                        req="22";
                        break;
                    }
                    case R.id.threeon: {
                        req="31";
                        break;
                    }
                    case R.id.threeoff: {
                        req="30";
                        break;
                    }
                    case R.id.threeauto: {
                        req="32";
                        break;
                    }
                    case R.id.fouron: {
                        req="41";
                        break;
                    }
                    case R.id.fouroff: {
                        req="40";
                        break;
                    }
                    case R.id.fourauto: {
                        req="42";
                        break;
                    }
                    default: {
                        Toast.makeText(getActivity(), "Fatal Error", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
                sendRequest("http://"+ip+"/"+req);
                Toast.makeText(getActivity(), "Requested!!! Please Wait...", Toast.LENGTH_SHORT).show();

            }
        };
    }
}