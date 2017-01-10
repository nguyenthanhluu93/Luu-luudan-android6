package com.example.chihirohaku.bonus;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.chihirohaku.bonus.fragments.FragmentEvent;
import com.example.chihirohaku.bonus.fragments.HomeFragment;
import com.example.chihirohaku.bonus.fragments.ListFragment;
import com.github.pwittchen.reactivenetwork.library.Connectivity;
import com.github.pwittchen.reactivenetwork.library.ReactiveNetwork;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentManager.OnBackStackChangedListener {

    private static final String TAG = MainActivity.class.toString();
    ActionBarDrawerToggle toggle;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        replaceFragment(new HomeFragment(), false);

        getSupportFragmentManager().addOnBackStackChangedListener(this);

//        toggle.setDrawerIndicatorEnabled(false);  //disable default icon
//        toggle.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24px);

        ReactiveNetwork.observeInternetConnectivity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Boolean>() {
                    @Override public void call(Boolean isConnectedToInternet) {
                        // do something with isConnectedToInternet value
                        if (isConnectedToInternet) {
                            Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Disconnected", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_home:
                Log.d(TAG, "Home Pressed");
                replaceFragment(new HomeFragment(), false);
                break;
            case R.id.nav_list:
                Log.d(TAG, "List Pressed");
                replaceFragment(new ListFragment(), false);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment, boolean addToBackstack) {
        if (addToBackstack) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fr_main, fragment)
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fr_main, fragment)
                    .commit();
        }
    }

    @Subscribe
    public void onReplaceFragment(FragmentEvent fragmentEvent) {
        replaceFragment(fragmentEvent.getFragment(), fragmentEvent.isAddToBackstack());
    }

    @Override
    public void onBackStackChanged() {
        int fragmentCount = getSupportFragmentManager().getBackStackEntryCount();
        if (fragmentCount > 0) {
            toggle.setDrawerIndicatorEnabled(false);
            toggle.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24px);
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

            toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    getSupportFragmentManager().popBackStack();  // cach 1
                    onBackPressed();  // cach 2
                }
            });
        } else {
            toggle.setDrawerIndicatorEnabled(true);
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            toggle.setToolbarNavigationClickListener(null);
        }
    }
}
