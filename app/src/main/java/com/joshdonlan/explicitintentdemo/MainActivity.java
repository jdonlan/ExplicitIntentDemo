package com.joshdonlan.explicitintentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.joshdonlan.explicitintentdemo.fragment.MainFragment;
import com.joshdonlan.fakedata.Contact;

import java.util.ArrayList;


public class MainActivity extends Activity implements MainFragment.ContactListener {

    private final String TAG = "MAINACTIVITY";

    public static final int DELETEREQUEST = 1;
    public static final String DELETECONTACTEXTRA = "com.jdonlan.explicitintentdemo.Delete";

    private ArrayList<Contact> mContactDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }

        mContactDataList = new ArrayList<Contact>();
        mContactDataList.add(new Contact("Josh","Donlan","jdonlan@fullsail.com","407-679-0100 x8594"));
        mContactDataList.add(new Contact("Michael","Celey","mceley@fullsail.com","407-679-0100"));
        mContactDataList.add(new Contact("Sherry","Dubin","sdubin@fullsail.com","407-679-0100"));
        mContactDataList.add(new Contact("Gyasi","Story","gstory@fullsail.com","407-679-0100 x8488"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == DELETEREQUEST) {
            mContactDataList.remove(data.getIntExtra(DELETECONTACTEXTRA,0));
            MainFragment mf = (MainFragment) getFragmentManager().findFragmentById(R.id.container);
            mf.updateListData();
        }
    }

    //INTERFACE METHODS
    @Override
    public void viewContact(int position){
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra(DetailActivity.CONTACTEXTRA,mContactDataList.get(position));
        startActivity(detailIntent);
    }

    @Override
    public void deleteContact(int position){
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra(DetailActivity.CONTACTEXTRA, mContactDataList.get(position));
        detailIntent.putExtra(DetailActivity.DELETEEXTRA,position);
        startActivityForResult(detailIntent, MainActivity.DELETEREQUEST);
    }

    @Override
    public ArrayList<Contact> getContacts() {
        return mContactDataList;
    }
}
