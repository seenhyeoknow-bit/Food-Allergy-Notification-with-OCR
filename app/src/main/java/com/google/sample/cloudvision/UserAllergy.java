package com.google.sample.cloudvision;

import android.os.Parcel;
import android.os.Parcelable;

public class UserAllergy implements Parcelable {
    public String userID;
    public String name;
    public int aNum;

    public UserAllergy(Parcel in){
        this.aNum = in.readInt();
        this.userID = in.readString();
        this.name = in.readString();
    }

    public UserAllergy(String userID, String name){
        this.userID = userID;
        this.name = name;
    }
    public UserAllergy(String userID, String name, int aNum){
        this.aNum = aNum;
        this.userID = userID;
        this.name = name;
    }

    public static final Creator<UserAllergy> CREATOR = new Creator<UserAllergy>() {
        @Override
        public UserAllergy createFromParcel(Parcel in) {
            return new UserAllergy(in);
        }

        @Override
        public UserAllergy[] newArray(int size) {
            return new UserAllergy[size];
        }
    };

    public int getaNum(){return aNum;}
    public void setaNum(int aNum){this.aNum = aNum;}
    public String getName(){
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.aNum);
        parcel.writeString(this.userID);
        parcel.writeString(this.name);
    }
}
