package com.google.sample.cloudvision;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainRequest extends StringRequest {
    final static private String URL="http://ki0051.cafe24.com/Login.php";
    private Map<String, String> parameters;

    public MainRequest(String Barcode, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("barcode", Barcode);

    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
