package com.example.android.glumci.activities;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.android.glumci.R;
import com.example.android.glumci.adapters.*;
import com.example.android.glumci.fragments.DetailFragment;
import com.example.android.glumci.fragments.ListFragment;
import com.example.android.glumci.fragments.ListaGlumacaFragment;
import com.example.android.glumci.model.NavigationItem;

import java.util.ArrayList;

public class FirstActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener {

    boolean landscape = false;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private RelativeLayout drawerPane;
    private CharSequence drawerTitle;
    private ArrayList<NavigationItem> drawerItems = new ArrayList<NavigationItem>();
    private android.app.AlertDialog dialog;
    private boolean landscapeMode = false;
    private boolean listShown = false;
    private boolean detailShown = false;
    private int itemId = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }


        drawerItems.add(new NavigationItem(getString(R.string.drawer_home_glumci), getString(R.string.drawer_home_glumci_long), R.drawable.ic_action_product));
        drawerItems.add(new NavigationItem(getString(R.string.drawer_settings), getString(R.string.drawer_settings_long), R.drawable.ic_action_settings));


        drawerTitle = getTitle();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerList = (ListView) findViewById(R.id.navList);

        drawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        DrawerAdapter adapter = new DrawerAdapter(this, drawerItems);

        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        drawerList.setAdapter(adapter);

        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu();
            }
        };


        if (savedInstanceState == null) {

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ListFragment listFragment = new ListFragment();
            ft.add(R.id.fl_list, listFragment, "List_Fragment_1");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }


        if (findViewById(R.id.fl_detail) != null) {
            landscapeMode = true;
            getFragmentManager().popBackStack();

            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.fl_detail);
            if (detailFragment == null) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                detailFragment = new DetailFragment();
                ft.replace(R.id.fl_detail, detailFragment, "Detail_Fragment_1");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }

        listShown = true;
        detailShown = false;
        itemId = 0;
    }

    @Override
    public void onItemSelected(int id) {

        itemId = id;

        if (landscapeMode) {

            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.fl_detail);
            detailFragment.updateContent(id);
        } else {

            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setContent(id);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fl_list, detailFragment, "Detail_Fragment_2");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();

            listShown = false;
            detailShown = true;
        }
    }


    @Override
    public void onBackPressed() {

        if (landscapeMode) {
            finish();
        } else if (listShown == true) {
            finish();
        } else if (detailShown == true) {
            getFragmentManager().popBackStack();
            ListFragment listFragment = new ListFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fl_list, listFragment, "List_Fragment");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

            listShown = true;
            detailShown = false;
        }

    }

    // onCreateOptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }




    // Toolbar - message in toast
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create:
                Toast.makeText(this, "Novi glumac je dodan", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_update:
                Toast.makeText(this, "Podaci o glumcu su izmenjeni", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                Toast.makeText(this, "Glumac je izbrisan", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);

        drawerToggle.onConfigurationChanged(configuration);
    }


    // click listner for Draw Items
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                ListaGlumacaFragment listaGlumacaFragment = new ListaGlumacaFragment();
                fragmentTransaction.replace(R.id.fl_list,listaGlumacaFragment,"List_Fragment3");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit();

                getFragmentManager().beginTransaction().replace(R.id.fl_list, new ListaGlumacaFragment(),"List_Fragment3").addToBackStack(null).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();



            }else if (position == 1) {
                Intent settings = new Intent(FirstActivity.this, SettingsActivity.class);
                startActivity(settings);
            }
            drawerList.setItemChecked(position, true);
            setTitle(drawerItems.get(position).getTitle());
            drawerLayout.closeDrawer(drawerPane);
        }
    }

}
