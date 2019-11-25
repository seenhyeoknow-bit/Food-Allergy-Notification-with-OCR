package com.google.sample.cloudvision;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {
    public static String userID;
    private AlertDialog dialog;
    boolean checked;
    private ArrayList<Integer> aNumList;
    CheckBox milk, buckwheat, peanut, soybean, wheat, mackerel, crab, shrimp, pork, peach, tomato, walnut, pine_nut, chicken, shellfish, oyster, abalone, mussels, squid, beef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        userID = getIntent().getStringExtra("userID");
        milk = (CheckBox) findViewById(R.id.milk);
        buckwheat = (CheckBox) findViewById(R.id.buckwheat);
        peanut = (CheckBox) findViewById(R.id.peanut);
        soybean = (CheckBox) findViewById(R.id.soybean);
        wheat = (CheckBox) findViewById(R.id.wheat);
        mackerel = (CheckBox) findViewById(R.id.mackerel);
        crab = (CheckBox) findViewById(R.id.crab);
        shrimp = (CheckBox) findViewById(R.id.shrimp);
        pork = (CheckBox) findViewById(R.id.pork);
        peach = (CheckBox) findViewById(R.id.peach);
        tomato = (CheckBox) findViewById(R.id.tomato);
        walnut = (CheckBox) findViewById(R.id.walnut);
        pine_nut = (CheckBox) findViewById(R.id.pine_nut);
        chicken = (CheckBox) findViewById(R.id.chicken);
        shellfish = (CheckBox) findViewById(R.id.shellfish);
        oyster = (CheckBox) findViewById(R.id.oyster);
        abalone = (CheckBox) findViewById(R.id.abalone);
        mussels = (CheckBox) findViewById(R.id.mussels);
        squid = (CheckBox) findViewById(R.id.squid);
        beef = (CheckBox) findViewById(R.id.beef);
        aNumList = (ArrayList<Integer>) getIntent().getSerializableExtra("aNumList");
        final Button registerButton = (Button) findViewById(R.id.registerButton);
        for (int i = 0; i < aNumList.size(); i++) {
            if (aNumList.get(i) == 1)
                milk.setChecked(true);
            if (aNumList.get(i) == 2)
                buckwheat.setChecked(true);
            if (aNumList.get(i) == 3)
                peanut.setChecked(true);
            if (aNumList.get(i) == 4)
                soybean.setChecked(true);
            if (aNumList.get(i) == 5)
                wheat.setChecked(true);
            if (aNumList.get(i) == 6)
                mackerel.setChecked(true);
            if (aNumList.get(i) == 7)
                crab.setChecked(true);
            if (aNumList.get(i) == 8)
                shrimp.setChecked(true);
            if (aNumList.get(i) == 9)
                pork.setChecked(true);
            if (aNumList.get(i) == 10)
                peach.setChecked(true);
            if (aNumList.get(i) == 11)
                tomato.setChecked(true);
            if (aNumList.get(i) == 12)
                walnut.setChecked(true);
            if (aNumList.get(i) == 13)
                peanut.setChecked(true);
            if (aNumList.get(i) == 14)
                chicken.setChecked(true);
            if (aNumList.get(i) == 15)
                shellfish.setChecked(true);
            if (aNumList.get(i) == 16)
                oyster.setChecked(true);
            if (aNumList.get(i) == 17)
                abalone.setChecked(true);
            if (aNumList.get(i) == 18)
                mussels.setChecked(true);
            if (aNumList.get(i) == 19)
                squid.setChecked(true);
            if (aNumList.get(i) == 20)
                beef.setChecked(true);
            registerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    /*AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                                    dialog = builder.setMessage("알러지 정보 수정 성공").setPositiveButton("확인", null).create();
                                    dialog.show();*/
                                    Intent intent001 = new Intent(SettingActivity.this, MainActivity.class);
                                    intent001.putExtra("userID", userID);
                                    startActivity(intent001);
                                    finish();
                                } else {
                                    /*AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                                    dialog = builder.setMessage("알러지 정보 수정 실패").setPositiveButton("확인", null).create();
                                    dialog.show();*/
                                    Intent intent001 = new Intent(SettingActivity.this, MainActivity.class);
                                    intent001.putExtra("userID", userID);
                                    startActivity(intent001);
                                    finish();
                                }
                            } catch (Exception e) {
                                e.getStackTrace();
                            }
                        }
                    };
                    if (milk.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "1", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "1", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (buckwheat.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "2", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "2", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (peanut.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "3", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "3", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (soybean.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "4", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "4", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (wheat.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "5", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "5", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (mackerel.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "6", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "6", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (crab.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "7", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "7", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (shrimp.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "8", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "8", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (pork.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "9", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "9", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (peach.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "10", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "10", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (tomato.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "11", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "11", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (walnut.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "12", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "12", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (pine_nut.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "13", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "13", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (chicken.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "14", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "14", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (shellfish.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "15", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "15", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (oyster.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "16", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "16", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (abalone.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "17", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "17", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (mussels.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "18", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "18", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (squid.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "19", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "19", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }
                    if (beef.isChecked()) {
                        InsertUserAllergyRequest insertUserAllergyRequest = new InsertUserAllergyRequest(userID, "20", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(insertUserAllergyRequest);
                    } else {
                        DeleteUserAllergyRequest deleteUserAllergyRequest = new DeleteUserAllergyRequest(userID, "20", responseListener);
                        RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                        queue.add(deleteUserAllergyRequest);
                    }

                }
            });

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
}



