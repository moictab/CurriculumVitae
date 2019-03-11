package com.moictab.curriculumvitae.activities

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View

import com.moictab.curriculumvitae.R
import com.moictab.curriculumvitae.fragments.AboutFragment
import com.moictab.curriculumvitae.fragments.ContactFragment
import com.moictab.curriculumvitae.fragments.ExperienceFragment
import com.moictab.curriculumvitae.fragments.TrainingFragment
import com.moictab.curriculumvitae.fragments.PresentationFragment
import com.moictab.curriculumvitae.fragments.ProjectsFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, ExperienceFragment.OnFragmentInteractionListener, PresentationFragment.OnFragmentInteractionListener, TrainingFragment.OnFragmentInteractionListener, ContactFragment.OnFragmentInteractionListener, ProjectsFragment.OnFragmentInteractionListener, AboutFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fragment = PresentationFragment()
        supportFragmentManager.beginTransaction().replace(R.id.base_layout, fragment).commit()

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.menu.getItem(0).isChecked = true
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        val manager = supportFragmentManager

        if (id == R.id.nav_presentation) {
            val fragment = PresentationFragment()
            manager.beginTransaction().replace(R.id.base_layout, fragment).commit()
        } else if (id == R.id.nav_experience) {
            val fragment = ExperienceFragment()
            manager.beginTransaction().replace(R.id.base_layout, fragment).commit()
        } else if (id == R.id.nav_training) {
            val fragment = TrainingFragment()
            manager.beginTransaction().replace(R.id.base_layout, fragment).commit()
        } else if (id == R.id.nav_projects) {
            val fragment = ProjectsFragment()
            manager.beginTransaction().replace(R.id.base_layout, fragment).commit()
        } else if (id == R.id.nav_contact) {
            val fragment = ContactFragment()
            manager.beginTransaction().replace(R.id.base_layout, fragment).commit()
        } else if (id == R.id.nav_about) {
            val fragment = AboutFragment()
            manager.beginTransaction().replace(R.id.base_layout, fragment).commit()
        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onFragmentInteraction(uri: Uri) {
        // TODO
    }
}
