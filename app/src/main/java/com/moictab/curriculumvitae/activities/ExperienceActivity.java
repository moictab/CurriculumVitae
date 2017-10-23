package com.moictab.curriculumvitae.activities;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.moictab.curriculumvitae.R;
import com.moictab.curriculumvitae.controller.ExperienceController;
import com.moictab.curriculumvitae.model.Experience;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExperienceActivity extends AppCompatActivity {

    @BindView(R.id.period)
    View viewPeriod;

    @BindView(R.id.description)
    View viewDescription;

    @BindView(R.id.website)
    View viewWebsite;

    @BindView(R.id.title)
    View viewTitle;

    private final static String EXPERIENCE_ID = "EXPERIENCE_ID";
    private int experienceId;
    private Experience experience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
        ButterKnife.bind(this);

        if (getIntent().getExtras() != null) {
            experienceId = getIntent().getExtras().getInt(EXPERIENCE_ID);
        }

        ExperienceController controller = new ExperienceController();
        experience = controller.GetExperienceFromAssetsById(this, experienceId);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(experience.place);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ((TextView) viewTitle.findViewById(R.id.textview_titulo)).setText(R.string.title);
        ((TextView) viewTitle.findViewById(R.id.textview_texto)).setText(experience.title);

        ((TextView) viewWebsite.findViewById(R.id.textview_titulo)).setText(R.string.website);
        ((TextView) viewWebsite.findViewById(R.id.textview_texto)).setText(experience.website);
        this.findViewById(R.id.iv_open_in_browser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(experience.website));
                startActivity(browserIntent);
            }
        });

        ((TextView) viewPeriod.findViewById(R.id.textview_titulo)).setText(R.string.period);
        ((TextView) viewPeriod.findViewById(R.id.textview_texto)).setText(experience.period);

        ((TextView) viewDescription.findViewById(R.id.textview_titulo)).setText(R.string.description);
        ((TextView) viewDescription.findViewById(R.id.textview_texto)).setText(experience.description);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
