package com.google.sample.cloudvision;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;

import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private ArrayAdapter adapter;
    private String id;
    private String pw;
    private AlertDialog dialog;
    private boolean validate = false;
    String milkS="0";
    String buckwheatS="0"; String peanutS="0"; String soybeanS="0"; String wheatS="0"; String mackerelS="0";
    String crabS="0"; String shrimpS="0"; String porkS="0"; String peachS="0"; String tomatoS="0"; String walnutS="0";
    String pine_nutS="0"; String chickenS="0"; String shellfishS="0"; String oysterS="0"; String abaloneS="0"; String musselsS="0";
    String squidS="0"; String beefS="0";
    boolean checked;
    CheckBox milk,buckwheat,peanut,soybean,wheat,mackerel,crab,shrimp,pork,peach,tomato,walnut,pine_nut,chicken,shellfish,oyster,abalone,mussels,squid,beef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText idText = (EditText)findViewById(R.id.idText);
        final EditText pwText = (EditText)findViewById(R.id.passwordText);


        /*milk = (CheckBox)findViewById(R.id.milk);
        buckwheat = (CheckBox)findViewById(R.id.buckwheat);
        peanut = (CheckBox)findViewById(R.id.peanut);
        soybean = (CheckBox)findViewById(R.id.soybean);
        wheat = (CheckBox)findViewById(R.id.wheat);
        mackerel = (CheckBox)findViewById(R.id.mackerel);
        crab = (CheckBox)findViewById(R.id.crab);
        shrimp = (CheckBox)findViewById(R.id.shrimp);
        pork = (CheckBox)findViewById(R.id.pork);
        peach = (CheckBox)findViewById(R.id.peach);
        tomato = (CheckBox)findViewById(R.id.tomato);
        walnut = (CheckBox)findViewById(R.id.walnut);
        pine_nut = (CheckBox)findViewById(R.id.pine_nut);
        chicken = (CheckBox)findViewById(R.id.chicken);
        shellfish = (CheckBox)findViewById(R.id.shellfish);
        oyster = (CheckBox)findViewById(R.id.oyster);
        abalone = (CheckBox)findViewById(R.id.abalone);
        mussels = (CheckBox)findViewById(R.id.mussels);
        squid = (CheckBox)findViewById(R.id.squid);
        beef = (CheckBox)findViewById(R.id.beef);*/


     /*   milk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    milkS="1";
                }
                else
                {
                    milkS="0";
                }
            }
        });
        buckwheat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    buckwheatS="1";
                }
                else
                {
                    buckwheatS="0";
                }
            }
        });
        peanut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    peanutS="1";
                }
                else
                {
                    peanutS="0";
                }
            }
        });
        soybean.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    soybeanS="1";
                }
                else
                {
                    soybeanS="0";
                }
            }
        });
        wheat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    wheatS="1";
                }
                else
                {
                    wheatS="0";
                }
            }
        });
        mackerel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    mackerelS="1";
                }
                else
                {
                    mackerelS="0";
                }
            }
        });
        crab.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    crabS="1";
                }
                else
                {
                    crabS="0";
                }
            }
        });
        shrimp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    shrimpS="1";
                }
                else
                {
                    shrimpS="0";
                }
            }
        });
        pork.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    porkS="1";
                }
                else
                {
                    porkS="0";
                }
            }
        });
        peach.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    peachS="1";
                }
                else
                {
                    peachS="0";
                }
            }
        });
        tomato.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    tomatoS="1";
                }
                else
                {
                    tomatoS="0";
                }
            }
        });
        walnut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    walnutS="1";
                }
                else
                {
                    walnutS="0";
                }
            }
        });
        pine_nut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    pine_nutS="1";
                }
                else
                {
                    pine_nutS="0";
                }
            }
        });
        chicken.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    chickenS="1";
                }
                else
                {
                    chickenS="0";
                }
            }
        });
        shellfish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    shellfishS="1";
                }
                else{
                    shellfishS="0";
                }
            }
        });

        oyster.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    oysterS="1";
                }
                else
                {
                    oysterS="0";
                }
            }
        });
        abalone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    abaloneS="1";
                }
                else
                {
                    abaloneS="0";
                }
            }
        });
        mussels.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    musselsS="1";
                }
                else
                {
                    musselsS="0";
                }
            }
        });
        squid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    squidS="1";
                }
                else
                {
                    squidS="0";
                }
            }
        });
        beef.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean checked) {
                // TODO Auto-generated method stub
                if(checked)
                {
                    beefS="1";
                }
                else
                {
                    beefS="0";
                }
            }
        });*/

        final Button validateButton = (Button)findViewById(R.id.validateButton);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idText.getText().toString();
                if(validate){
                    return;
                }
                if(id.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("아이디를 입력해주세요.").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }
                Response.Listener<String> responseListener = response -> {
                    try{
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");
                        if(success){
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                            dialog = builder.setMessage("사용 가능한 아이디입니다.").setPositiveButton("확인", null).create();
                            dialog.show();
                            idText.setEnabled(false);
                            validate = true;
                            idText.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            validateButton.setBackgroundColor(getResources().getColor(R.color.colorGray));
                        }
                        else{
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                            dialog = builder.setMessage("사용 불가능한 아이디입니다.").setNegativeButton("확인", null).create();
                            dialog.show();
                        }
                    }catch (Exception e){
                        e.getStackTrace();
                    }
                };
                ValidateRequest validateRequest = new ValidateRequest(id, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(validateRequest);
            }
        });


        Button registerButton = (Button)findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idText.getText().toString();
                String pw = pwText.getText().toString();


                if(!validate){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("아이디 중복 체크 해주세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                if(id.equals("") || pw.equals("") ){
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("빈 칸 없이 입력해주세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog = builder.setMessage("회원 가입 완료").setPositiveButton("확인", null).create();
                                dialog.show();
                                finish();
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog = builder.setMessage("회원 가입 실패").setNegativeButton("확인", null).create();
                                dialog.show();
                            }
                        }catch (Exception e){
                            e.getStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(id, pw,  responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();
        if(dialog != null){
            dialog.dismiss();
            dialog = null;
        }
    }
}