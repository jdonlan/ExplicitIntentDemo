package com.joshdonlan.fakedata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.joshdonlan.explicitintentdemo.R;

import java.util.ArrayList;

/**
 * Created by jdonlan on 8/14/14.
 */
public class ContactAdapter extends BaseAdapter {

    private static final long ID_CONSTANT = 0x01000000;

    Context mContext;
    ArrayList<Contact> mContacts;

    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        mContext = context;
        mContacts = contacts;
    }

    @Override
    public int getCount() {
        return mContacts.size();
    }

    @Override
    public Contact getItem(int position) {
        return mContacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ID_CONSTANT + position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.contact_list_item, parent, false);
        }

        Contact contact = getItem(position);
        TextView contactNameView = (TextView) convertView.findViewById(R.id.contactName);
        contactNameView.setText(contact.getName());

        return convertView;
    }
}