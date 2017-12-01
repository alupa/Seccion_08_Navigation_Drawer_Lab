package io.github.alupa.seccion_08_navigation_drawer_lab.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import io.github.alupa.seccion_08_navigation_drawer_lab.Fragments.AlertFragment;
import io.github.alupa.seccion_08_navigation_drawer_lab.Fragments.EmailFragment;
import io.github.alupa.seccion_08_navigation_drawer_lab.Fragments.InfoFragment;
import io.github.alupa.seccion_08_navigation_drawer_lab.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, CompoundButton.OnCheckedChangeListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navView);

        setFragmentByDefault();

        /*drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Toast.makeText(MainActivity.this, "Open", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Toast.makeText(MainActivity.this, "Close", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });*/

        navigationView.setNavigationItemSelectedListener(this);

        aSwitch = (Switch) navigationView.getMenu().findItem(R.id.switch_in_nav_options).getActionView();
        aSwitch.setOnCheckedChangeListener(this);

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFragmentByDefault(){
        changeFragment(new EmailFragment(), navigationView.getMenu().getItem(0));
    }

    private void changeFragment(Fragment fragment, MenuItem item){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                // Abrir el menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked)
            Toast.makeText(MainActivity.this, "The option is checked", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "The option is unchecked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.menu_mail:
                fragment = new EmailFragment();
                fragmentTransaction = true;
                break;
            case R.id.menu_alert:
                fragment = new AlertFragment();
                fragmentTransaction = true;
                break;
            case R.id.menu_info:
                fragment = new InfoFragment();
                fragmentTransaction = true;
                break;
        }

        if (fragmentTransaction){
            changeFragment(fragment, item);
            drawerLayout.closeDrawers();
        }

        return true;
    }
}