package com.google.sample.cloudvision;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class UserAllergyListAdapter extends BaseAdapter {

    private Context context;
    private List<UserAllergy> userAllergyList;

    public UserAllergyListAdapter(Context context, List<UserAllergy> userAllergyList) {
        this.context = context;
        this.userAllergyList = userAllergyList;
    }

    @Override
    public int getCount() {
        return userAllergyList.size();
    }

    @Override
    public Object getItem(int i) {
        return userAllergyList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.user_allergy, null);
        TextView userAllergyTxt = (TextView) v.findViewById(R.id.userAllergyTxt);

        userAllergyTxt.setText(userAllergyList.get(i).getName());

        v.setTag(userAllergyList.get(i).getName());
        return v;
    }

}
