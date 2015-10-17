package com.tas.navigationpoc;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class NavigationActivity extends Activity implements ActionBar.TabListener {

    private ViewPager viewPager;
    private TabsAdapter tabsAdapter;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
//        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        tabsAdapter = new TabsAdapter(getFragmentManager());

        viewPager.setAdapter(tabsAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        //add the tabs

        for(String tabName: TabsAdapter.getTabNames()){
            ActionBar.Tab aTab = actionBar.newTab()
                    .setText(tabName)
                    .setTabListener(this);
            actionBar.addTab(aTab);
        }

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                Toast.makeText(this,"Selected Settings", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_rateup:
                Toast.makeText(this,"This App Rules", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
