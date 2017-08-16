package com.greenzone.tobagopartners;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.greenzone.tobagopartners.fragments.AccountFragment;
import com.greenzone.tobagopartners.fragments.HomeFragment;
import com.greenzone.tobagopartners.fragments.SaleFragment;
import com.greenzone.tobagopartners.fragments.TradeFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = MainActivity.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.activity_main_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
        }

        replaceFragment(HomeFragment.class);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_navigation_home:
                replaceFragment(HomeFragment.class);
                return true;
            case R.id.menu_navigation_trade:
                replaceFragment(TradeFragment.class);
                return true;
            case R.id.menu_navigation_sale:
                replaceFragment(SaleFragment.class);
                return true;
            case R.id.menu_navigation_account:
                replaceFragment(AccountFragment.class);
                return true;
        }
        return false;
    }

    public void replaceFragment(Class FragmentClass) {
        try {
            Fragment fragment = (Fragment) FragmentClass.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(android.R.id.content, fragment)
                    .commit();
        } catch (Exception e) {
            Log.e(TAG, "replaceFragment: ", e);
        }

    }
}
