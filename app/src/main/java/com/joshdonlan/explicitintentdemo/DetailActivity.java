package com.joshdonlan.explicitintentdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.joshdonlan.explicitintentdemo.fragment.DetailFragment;
import com.joshdonlan.fakedata.Contact;

public class DetailActivity extends Activity implements DetailFragment.DetailListener {

    private final String TAG = "DETAILACTIVITY";

    private Contact mContact;
    private int mDelete;

    public static final String CONTACTEXTRA = "com.jdonlan.explicitintentdemo.Contact";
    public static final String DELETEEXTRA = "com.jdonlan.explicitintentdemo.Delete";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new DetailFragment())
                    .commit();
        }

        Intent detailIntent = getIntent();
        if(detailIntent != null){
            mContact = (Contact) detailIntent.getSerializableExtra(CONTACTEXTRA);
            mDelete = detailIntent.getIntExtra(DELETEEXTRA, 0);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
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

    //INTERFACE METHODS

    @Override
    public Contact getContact() {
        return mContact;
    }

    @Override
    public int getDelete(){
        return mDelete;
    }

    @Override
    public void deleteContact() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra(MainActivity.DELETECONTACTEXTRA, mDelete);
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
