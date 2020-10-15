package com.example.ning.sendargs;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import javax.xml.transform.Source;

/**
 * Created by Ning on 2019/10/10.
 */

//public class User implements Serializable{
public class User implements Parcelable{
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getName());
        parcel.writeInt(getAge());

    }
    public  static  final  Creator<User>CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel.readString(), parcel.readInt());
        }

        @Override
        public User[] newArray(int i) {
            return new User[i];
        }
    };

    private  String name;
    private  int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  User(String name, int age){
        this.name = name;
        this.age = age;
    }

}
