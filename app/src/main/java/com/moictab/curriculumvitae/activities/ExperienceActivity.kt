package com.moictab.curriculumvitae.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.moictab.curriculumvitae.R
import com.moictab.curriculumvitae.controller.ExperienceController
import com.moictab.curriculumvitae.model.Experience

class ExperienceActivity : AppCompatActivity() {

    @BindView(R.id.period)
    internal var viewPeriod: View? = null

    @BindView(R.id.description)
    internal var viewDescription: View? = null

    @BindView(R.id.website)
    internal var viewWebsite: View? = null

    @BindView(R.id.title)
    internal var viewTitle: View? = null
    private var experienceId: Int = 0
    private var experience: Experience? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experience)
        ButterKnife.bind(this)

        if (intent.extras != null) {
            experienceId = intent.extras!!.getInt(EXPERIENCE_ID)
        }

        val controller = ExperienceController()
        experience = controller.GetExperienceFromAssetsById(this, experienceId)

        val actionBar = supportActionBar
        actionBar!!.title = experience!!.place
        actionBar.setDisplayHomeAsUpEnabled(true)

        (viewTitle!!.findViewById<View>(R.id.textview_titulo) as TextView).setText(R.string.title)
        (viewTitle!!.findViewById<View>(R.id.textview_texto) as TextView).text = experience!!.title

        (viewWebsite!!.findViewById<View>(R.id.textview_titulo) as TextView).setText(R.string.website)
        (viewWebsite!!.findViewById<View>(R.id.textview_texto) as TextView).text = experience!!.website
        this.findViewById<View>(R.id.iv_open_in_browser).setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(experience!!.website))
            startActivity(browserIntent)
        }

        (viewPeriod!!.findViewById<View>(R.id.textview_titulo) as TextView).setText(R.string.period)
        (viewPeriod!!.findViewById<View>(R.id.textview_texto) as TextView).text = experience!!.period

        (viewDescription!!.findViewById<View>(R.id.textview_titulo) as TextView).setText(R.string.description)
        (viewDescription!!.findViewById<View>(R.id.textview_texto) as TextView).text = experience!!.description
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

        private val EXPERIENCE_ID = "EXPERIENCE_ID"
    }
}
