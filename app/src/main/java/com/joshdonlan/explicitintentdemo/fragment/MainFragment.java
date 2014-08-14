package com.joshdonlan.explicitintentdemo.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.joshdonlan.explicitintentdemo.DetailActivity;
import com.joshdonlan.explicitintentdemo.R;
import com.joshdonlan.fakedata.Contact;
import com.joshdonlan.fakedata.ContactAdapter;

import java.util.ArrayList;

/**
 * Created by jdonlan on 8/14/14.
 */
public class MainFragment extends Fragment {

    private final String TAG = "MAINFRAGMENT";
    private ArrayList<Contact> mContactDataList;

    public MainFragment() {
        mContactDataList = new ArrayList<Contact>();
        mContactDataList.add(new Contact("Josh","Donlan","jdonlan@fullsail.com","407-679-0100 x8594"));
        mContactDataList.add(new Contact("Michael","Celey","mceley@fullsail.com","407-679-0100"));
        mContactDataList.add(new Contact("Sherry","Dubin","sdubin@fullsail.com","407-679-0100"));
        mContactDataList.add(new Contact("Gyasi","Story","gstory@fullsail.com","407-679-0100 x8488"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView contactListView = (ListView) getView().findViewById(R.id.contactList);
        ContactAdapter contactAdapter = new ContactAdapter(getView().getContext(), mContactDataList);
        contactListView.setAdapter(contactAdapter);

        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailIntent = new Intent(getView().getContext(), DetailActivity.class);
//                detailIntent.putExtra("first",mContactDataList.get(position).getFirst());
//                detailIntent.putExtra("last",mContactDataList.get(position).getLast());
//                detailIntent.putExtra("email",mContactDataList.get(position).getEmail());
//                detailIntent.putExtra("phone",mContactDataList.get(position).getPhone());
                detailIntent.putExtra("contact",mContactDataList.get(position));
                startActivity(detailIntent);

            }
        });
    }
}