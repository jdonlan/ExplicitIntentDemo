package com.joshdonlan.fakedata;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by jdonlan on 8/14/14.
 */
public class Contact implements Serializable {

    private String mFirst;
    private String mLast;
    private String mEmail;
    private String mPhone;

    public Contact(){
        mFirst = "";
        mLast = "";
        mEmail = "";
        mPhone = "";
    }

    public Contact(String first, String last, String email, String phone){
        mFirst = first;
        mLast = last;
        mEmail = email;
        mPhone = phone;
    }
    
    public String getName(){
        return mFirst + " " + mLast;
    }

    public String getFirst() {
        return mFirst;
    }

    public void setFirst(String mFirst) {
        this.mFirst = mFirst;
    }

    public String getLast() {
        return mLast;
    }

    public void setLast(String mLast) {
        this.mLast = mLast;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }
}
