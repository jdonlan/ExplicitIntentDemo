package com.joshdonlan.explicitintentdemo.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joshdonlan.explicitintentdemo.R;
import com.joshdonlan.fakedata.Contact;

/**
 * Created by jdonlan on 8/14/14.
 */
public class DetailFragment extends Fragment{

    private DetailListener mListener;

    public interface DetailListener{
        public Contact getContact();
    }

    public DetailFragment() {

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(activity instanceof DetailListener) {
            mListener = (DetailListener) activity;
        } else {
            throw new IllegalArgumentException("Containing activity must implement DetailListener interface");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView tv = (TextView) getView().findViewById(R.id.detailFirst);
        tv.setText(mListener.getContact().getFirst());
        tv = (TextView) getView().findViewById(R.id.detailLast);
        tv.setText(mListener.getContact().getLast());
        tv = (TextView) getView().findViewById(R.id.detailEmail);
        tv.setText(mListener.getContact().getEmail());
        tv = (TextView) getView().findViewById(R.id.detailPhone);
        tv.setText(mListener.getContact().getPhone());
    }
}