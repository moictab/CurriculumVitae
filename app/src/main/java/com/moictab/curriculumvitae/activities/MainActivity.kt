package com.moictab.curriculumvitae.activities

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.moictab.curriculumvitae.R
import com.moictab.curriculumvitae.fragments.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, ExperienceFragment.OnFragmentInteractionListener, PresentationFragment.OnFragmentInteractionListener, TrainingFragment.OnFragmentInteractionListener, ContactFragment.OnFragmentInteractionListener, ProjectsFragment.OnFragmentInteractionListener, AboutFragment.OnFragmentInteractionListener {

  private lateinit var drawerLayout: DrawerLayout
  private lateinit var toolbar: Toolbar

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    toolbar = findViewById<View>(R.id.toolbar) as Toolbar
    setSupportActionBar(toolbar)
    supportFragmentManager.beginTransaction().replace(R.id.base_layout, PresentationFragment.newInstance()).commit()
    setNavigationDrawer()
  }

  private fun setNavigationDrawer() {
    drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
    val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
    drawerLayout.addDrawerListener(toggle)
    toggle.syncState()
    val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
    navigationView.setNavigationItemSelectedListener(this)
    navigationView.menu.getItem(0).isChecked = true
  }

  override fun onBackPressed() {
    drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START)
    } else {
      super.onBackPressed()
    }
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    return false
  }

  override fun onNavigationItemSelected(item: MenuItem): Boolean {
    val id = item.itemId
    when (id) {
      R.id.nav_presentation -> {
        supportFragmentManager.beginTransaction().replace(R.id.base_layout, PresentationFragment.newInstance()).commit()
      }
      R.id.nav_experience -> {
        supportFragmentManager.beginTransaction().replace(R.id.base_layout, ExperienceFragment.newInstance()).commit()
      }
      R.id.nav_training -> {
        supportFragmentManager.beginTransaction().replace(R.id.base_layout, TrainingFragment.newInstance()).commit()
      }
      R.id.nav_projects -> {
        supportFragmentManager.beginTransaction().replace(R.id.base_layout, ProjectsFragment.newInstance()).commit()
      }
      R.id.nav_contact -> {
        supportFragmentManager.beginTransaction().replace(R.id.base_layout, ContactFragment.newInstance()).commit()
      }
      R.id.nav_about -> {
        supportFragmentManager.beginTransaction().replace(R.id.base_layout, AboutFragment.newInstance()).commit()
      }
    }

    drawerLayout.closeDrawer(GravityCompat.START)
    return true
  }

  override fun onFragmentInteraction(uri: Uri) {
    // TODO
  }
}
