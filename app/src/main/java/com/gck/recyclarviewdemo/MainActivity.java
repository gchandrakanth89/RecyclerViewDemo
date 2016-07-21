package com.gck.recyclarviewdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudentListFragment studentListFragment;
    private boolean isShowing = false;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            studentListFragment = StudentListFragment.newInstance();
            fragmentTransaction.add(R.id.frag_container, studentListFragment);
            fragmentTransaction.commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_search:
                Toast.makeText(this, "Search", Toast.LENGTH_LONG).show();
                if (studentListFragment == null) {
                    List<Fragment> fragments = fragmentManager.getFragments();
                    studentListFragment= (StudentListFragment) fragments.get(0);
                }
                studentListFragment.showEditText(!isShowing);
                isShowing = !isShowing;
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
