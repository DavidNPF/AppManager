package com.personal.npf.appmanager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tab)
    TabLayout tab;
    @InjectView(R.id.vp)
    ViewPager vp;
    @InjectView(R.id.nav)
    NavigationView nav;
    @InjectView(R.id.tool)
    Toolbar tool;
    @InjectView(R.id.dl)
    DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        View headerView = nav.getHeaderView(0);
        headerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "头部", Toast.LENGTH_SHORT);
            }
        });
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_app_update:

                        Toast.makeText(MainActivity.this, "点击了应用更新", Toast.LENGTH_LONG).show();

                        break;


                    case R.id.menu_message:

                        Toast.makeText(MainActivity.this, "点击了消息", Toast.LENGTH_LONG).show();

                        break;
                }
                return false;
            }
        });
    tool.inflateMenu(R.menu.toolbar_menu);
        ActionBarDrawerToggle drawerToggle=new ActionBarDrawerToggle(this,dl,tool,R.string.open,R.string.close);
        drawerToggle.syncState();
        dl.addDrawerListener(drawerToggle);
    }
}
