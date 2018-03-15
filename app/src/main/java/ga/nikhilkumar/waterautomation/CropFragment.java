package ga.nikhilkumar.waterautomation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


/**
 * A simple {@link Fragment} subclass.
 */
public class CropFragment extends Fragment {
String ip=Vars.ip;
EditText min,max;
Button setminmax;
    public CropFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_crop, container, false);
        min=(EditText) v.findViewById(R.id.min);
        max=(EditText)v.findViewById(R.id.max);
        setminmax=(Button)v.findViewById(R.id.setminmax);
        setminmax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest("http://"+ip+"/");
                Toast.makeText(getActivity(), String.valueOf(min.getText())+","+String.valueOf(max.getText())+Vars.ip, Toast.LENGTH_SHORT).show();
            }
        });
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
}
