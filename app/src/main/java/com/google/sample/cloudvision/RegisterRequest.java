package com.google.sample.cloudvision;


import android.widget.CheckBox;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    final static private String URL="http://ki0051.cafe24.com/UserRegister.php";
    private Map<String, String> parameters;
    public RegisterRequest(
            String userID, String pw, Response.Listener<String> listener){
        super(Request.Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", pw);

    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
