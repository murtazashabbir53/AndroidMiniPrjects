package com.codewithme.expense_manager;

import androidx.activity.OnBackPressedDispatcher;

import androidx.annotation.FractionRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar=findViewById(R.id.my_toolbar);
        toolbar.setTitle("Expense Manager");
        setSupportActionBar(toolbar);


        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close

        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView=findViewById(R.id.naView);
navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public void onBackPressed() {


        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {


            super.onBackPressed();
        }


    }

public void displaySelectedListener(int itemId){
    Fragment fragment=null;

    switch(itemId){
        case R.id.dashboard:
            break;

        case R.id.income:

            break;

        case R.id.expense:
            break;
    }

    if(fragment!=null){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame,fragment);
        ft.commit();
    }

    DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
    drawerLayout.closeDrawer(GravityCompat.START);
}



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        displaySelectedListener(item.getItemId());
        return true;
    }
}