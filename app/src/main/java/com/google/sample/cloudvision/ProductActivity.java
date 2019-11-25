package com.google.sample.cloudvision;

import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Thread.sleep;

public class ProductActivity extends AppCompatActivity {


    public static String barcode;
    private List<Product> productList = new ArrayList<Product>();;
    private ListView productListView;
    private ProductAllergyListAdapter productAllergyListAdapter;

    private ArrayList<Integer> aNumList;

    private List<String> allergyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        barcode = getIntent().getStringExtra("barcode");

        aNumList= (ArrayList<Integer>) getIntent().getSerializableExtra("aNumList");
        //aNumList = getIntent().getParcelableArrayListExtra("aNumList");


        productListView = (ListView) findViewById(R.id.productAllergyListview);
        //productList = new ArrayList<Product>();
        productList.clear();



        Product product = new Product(barcode, "상품명", "탄수화물", "단백질", "지방", "제조회사", "");
        productList.add(product);


        productAllergyListAdapter = new ProductAllergyListAdapter(getApplicationContext(), productList);
        productListView.setAdapter(productAllergyListAdapter);





        new BackgroundTask().execute();
        new BackgroundTask2().execute();

        productAllergyListAdapter.notifyDataSetChanged();

    }
    @Override
    protected  void onStop() {
        super.onStop();
    }


    class BackgroundTask extends AsyncTask<Void, Void, String> {
        String target;

        @Override
        protected  void onPreExecute(){
                target="http://ki0051.cafe24.com/SelectProduct.php?barcode="+barcode;
        }

        @Override
        protected String doInBackground(Void... voids){
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp = bufferedReader.readLine())!= null){
                    stringBuilder.append(temp+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            }catch (Exception e){
                e.printStackTrace();
            }
            productAllergyListAdapter.notifyDataSetChanged();
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values){
            super.onProgressUpdate();
        }

        @Override
        public void onPostExecute(String result){
            try{
                //productList.clear();
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = 0;
                String pbarcode, name, carbohydrate, protein, fat, company, allergy;
                if(jsonArray.length() == 0){

                    Dialog dialog;
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProductActivity.this);
                    dialog = builder.setMessage("인식된 결과가 없습니다.").setPositiveButton("확인",null).create();
                    dialog.show();
                }
                while(count<jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    pbarcode = object.getString("barcode");
                    name = object.getString("name");
                    carbohydrate = object.getString("carbohydate");
                    protein = object.getString("protein");
                    fat = object.getString("fat");
                    company = object.getString("company");
                    allergy = "알러지";

                    Product product = new Product(pbarcode, name, carbohydrate, protein, fat, company, allergy);
                    //productList.add(product);

                            productList.get(0).setPname(name);
                            productList.get(0).setCarbohydate(carbohydrate);
                            productList.get(0).setProtein(protein);
                            productList.get(0).setFat(fat);
                            productList.get(0).setCompany(company);
                    count++;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            productAllergyListAdapter.notifyDataSetChanged();
        }
    }
    class BackgroundTask2 extends AsyncTask<Void, Void, String> {
        String target;

        @Override
        protected  void onPreExecute(){
                target="http://ki0051.cafe24.com/SelectProductAllergy.php?barcode="+barcode;
        }

        @Override
        protected String doInBackground(Void... voids){
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while((temp = bufferedReader.readLine())!= null){
                    stringBuilder.append(temp+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            }catch (Exception e){
                e.printStackTrace();
            }
            productAllergyListAdapter.notifyDataSetChanged();
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values){
            super.onProgressUpdate();
        }

        @Override
        public void onPostExecute(String result){
            try{
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = 0, check = 0;

                String pbarcode, bAllergy;
                while(count<jsonArray.length()){
                    JSONObject object = jsonArray.getJSONObject(count);
                    pbarcode = object.getString("barcode");
                    bAllergy = object.getString("bAllergy");

                    String allergy="알러지내용";
                    switch (bAllergy){
                        case "1":
                            allergy = "우유";
                            break;

                        case "2":
                            allergy = "메밀";
                            break;

                        case "3":
                            allergy = "땅콩";
                            break;

                        case "4":
                            allergy = "대두";
                            break;

                        case "5":
                            allergy = "밀";
                            break;

                        case "6":
                            allergy = "고등어";
                            break;

                        case "7":
                            allergy = "게";
                            break;

                        case "8":
                            allergy = "새우";
                            break;

                        case "9":
                            allergy = "돼지고기";
                            break;

                        case "10":
                            allergy = "복숭아";
                            break;

                        case "11":
                            allergy = "토마토";
                            break;

                        case "12":
                            allergy = "호두";
                            break;

                        case "13":
                            allergy = "잣";
                            break;

                        case "14":
                            allergy = "닭고기";
                            break;

                        case "15":
                            allergy = "조개";
                            break;

                        case "16":
                            allergy = "굴";
                            break;

                        case "17":
                            allergy = "전복";
                            break;

                        case "18":
                            allergy = "홍합";
                            break;

                        case "19":
                            allergy = "오징어";
                            break;

                        case "20":
                            allergy = "쇠고기";
                            break;
                    }

                    String pallergy = productList.get(0).getPallergy();
                    if(!pallergy.equals(""))
                        productList.get(0).setPallergy(pallergy + "\n" + allergy);
                    else
                        productList.get(0).setPallergy(pallergy  + allergy);
/*
                    Dialog dialog;
                   AlertDialog.Builder builder = new AlertDialog.Builder(ProductActivity.this);
                    dialog = builder.setMessage(aNumList.get(0)+"").setPositiveButton("확인",null).create();
                    dialog.show();*/
                    for(int i = 0; i < aNumList.size(); i++){
                        if(check == 0) {
                            if (aNumList.get(i) == Integer.parseInt(bAllergy)) {
                                productList.get(0).setAlter("알레르기 유발 성분이 포함되어있습니다.");
                                check = 1;
                            } else {
                                productList.get(0).setAlter("안전하므로 먹어도 됩니다.");
                            }
                        }
                    }
                    count++;
                }
            }catch (Exception e){
                e.printStackTrace();

                Dialog dialog;
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductActivity.this);
                dialog = builder.setMessage(e.getMessage()).setPositiveButton("확인",null).create();
                dialog.show();
            }
            productAllergyListAdapter.notifyDataSetChanged();
        }
    }
}
