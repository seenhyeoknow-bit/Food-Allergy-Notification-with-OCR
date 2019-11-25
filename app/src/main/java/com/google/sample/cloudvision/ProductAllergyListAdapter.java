package com.google.sample.cloudvision;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductAllergyListAdapter extends BaseAdapter {

    private Context context;
    private List<Product> productList;

    public ProductAllergyListAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.product_allergy, null);
        TextView productBarcode = (TextView) v.findViewById(R.id.productBarcode);
        productBarcode.setText(productList.get(i).getBarcode());
        TextView productName = (TextView) v.findViewById(R.id.productName);
        productName.setText(productList.get(i).getPname());
        TextView productCText = (TextView) v.findViewById(R.id.productCText);
        productCText.setText(productList.get(i).getCarbohydate()+"g");
        TextView productPText = (TextView) v.findViewById(R.id.productPText);
        productPText.setText(productList.get(i).getProtein()+"g");
        TextView productFText = (TextView) v.findViewById(R.id.productFText);
        productFText.setText(productList.get(i).getFat()+"g");
        TextView productMText = (TextView) v.findViewById(R.id.productMText);
        productMText.setText(productList.get(i).getCompany());
        TextView productAText = (TextView) v.findViewById(R.id.productAText);
        productAText.setText(productList.get(i).getPallergy());
        TextView productAlterText = (TextView) v.findViewById(R.id.productAlterText);
        productAlterText.setText(productList.get(i).getAlter());

        v.setTag(productList.get(i).getProduct());
        return v;
    }
}
