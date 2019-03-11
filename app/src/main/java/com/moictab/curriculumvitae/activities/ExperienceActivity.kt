package com.moictab.curriculumvitae.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.moictab.curriculumvitae.R
import com.moictab.curriculumvitae.controller.ExperienceController
import com.moictab.curriculumvitae.model.Experience
import kotlinx.android.synthetic.main.activity_experience.*

class ExperienceActivity : AppCompatActivity() {
  private var experienceId: Int = 0
  private var experience: Experience? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_experience)
    if (intent.extras != null) {
      experienceId = intent.extras!!.getInt(EXPERIENCE_ID)
    }
    val controller = ExperienceController()
    experience = controller.getExperienceFromAssetsById(this, experienceId)
    val actionBar = supportActionBar
    actionBar!!.title = experience!!.place
    actionBar.setDisplayHomeAsUpEnabled(true)
    (title_layout.findViewById<View>(R.id.textview_titulo) as TextView).setText(R.string.title)
    (title_layout.findViewById<View>(R.id.textview_texto) as TextView).text = experience!!.title
    (website_layout.findViewById<View>(R.id.textview_titulo) as TextView).setText(R.string.website)
    (website_layout.findViewById<View>(R.id.textview_texto) as TextView).text = experience!!.website
    this.findViewById<View>(R.id.iv_open_in_browser).setOnClickListener {
      val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(experience!!.website))
      startActivity(browserIntent)
    }
    (period_layout.findViewById<View>(R.id.textview_titulo) as TextView).setText(R.string.period)
    (period_layout.findViewById<View>(R.id.textview_texto) as TextView).text = experience!!.period
    (description_layout.findViewById<View>(R.id.textview_titulo) as TextView).setText(R.string.description)
    (description_layout.findViewById<View>(R.id.textview_texto) as TextView).text = experience!!.description
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      android.R.id.home -> {
        NavUtils.navigateUpFromSameTask(this)
        return true
      }
    }
    return super.onOptionsItemSelected(item)
  }

  companion object {
    private const val EXPERIENCE_ID = "EXPERIENCE_ID"
  }
}
