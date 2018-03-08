package ga.nikhilkumar.waterautomation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


/**
 * A simple {@link Fragment} subclass.
 */
public class IrrigationFragment extends Fragment {
ToggleButton t1,t2;

    public IrrigationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_irrigation, container, false);
        // Inflate the layout for this fragment
        t1 = (ToggleButton) v.findViewById(R.id.t1);
        t2 = (ToggleButton) v.findViewById(R.id.t2);

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
        return v;
    }
    public void sendRequest(String url) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(), "Yeah :)", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Oh :(", Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        mRequestQueue.add(request);
    }
}