package com.moictab.curriculumvitae.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.moictab.curriculumvitae.R;
import com.moictab.curriculumvitae.fragments.AboutFragment;
import com.moictab.curriculumvitae.fragments.ContactFragment;
import com.moictab.curriculumvitae.fragments.ExperienceFragment;
import com.moictab.curriculumvitae.fragments.TrainingFragment;
import com.moictab.curriculumvitae.fragments.PresentationFragment;
import com.moictab.curriculumvitae.fragments.ProjectsFragment;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        ExperienceFragment.OnFragmentInteractionListener,
        PresentationFragment.OnFragmentInteractionListener,
        TrainingFragment.OnFragmentInteractionListener,
        ContactFragment.OnFragmentInteractionListener,
        ProjectsFragment.OnFragmentInteractionListener,
        AboutFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment fragment = new PresentationFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.base_layout, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
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
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        FragmentManager manager = getSupportFragmentManager();

        if (id == R.id.nav_presentation) {
            Fragment fragment = new PresentationFragment();
            manager.beginTransaction().replace(R.id.base_layout, fragment).commit();
        } else if (id == R.id.nav_experience) {
            Fragment fragment = new ExperienceFragment();
            manager.beginTransaction().replace(R.id.base_layout, fragment).commit();
        } else if (id == R.id.nav_training) {
            Fragment fragment = new TrainingFragment();
            manager.beginTransaction().replace(R.id.base_layout, fragment).commit();
        } else if (id == R.id.nav_projects) {
            Fragment fragment = new ProjectsFragment();
            manager.beginTransaction().replace(R.id.base_layout, fragment).commit();
        } else if (id == R.id.nav_contact) {
            Fragment fragment = new ContactFragment();
            manager.beginTransaction().replace(R.id.base_layout, fragment).commit();
        } else if (id == R.id.nav_about) {
            Fragment fragment = new AboutFragment();
            manager.beginTransaction().replace(R.id.base_layout, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        // TODO
    }
}
