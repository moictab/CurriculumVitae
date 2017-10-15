package com.moictab.curriculumvitae.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.moictab.curriculumvitae.R;
import com.moictab.curriculumvitae.controller.ExperienceController;
import com.moictab.curriculumvitae.model.Experience;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExperienceActivity extends AppCompatActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.tv_period)
    TextView tvPeriod;
    @BindView(R.id.tv_place)
    TextView tvPlace;

    private int index;
    private final static String EXPERIENCE_ID = "EXPERIENCE_ID";
    private ExperienceController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent().getExtras() != null) {
            index = getIntent().getIntExtra(EXPERIENCE_ID, 0);
        }

        controller = new ExperienceController();
        List<Experience> experiences = controller.GetExperiencesFromAssets(this);
        Experience experience = experiences.get(index);

        tvDescription.setText(experience.description);
        tvPeriod.setText(experience.period);
        tvPlace.setText(experience.place);
        tvTitle.setText(experience.title);
    }
}
