package com.yapd.alexander.yapd.client.venture_details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;
import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.util.code.StringUtil;
import com.yapd.alexander.yapd.client.util.view.common.BaseActivity;
import com.yapd.alexander.yapd.core.model.Venture;

import java.util.List;

public class VentureDetailsActivity extends BaseActivity {
    public static final String VENTURE_KEY = "VENTURE";
    private ViewBinder viewBinder;
    private Venture venture;

    public static Intent getLaunchIntent(Context context, Venture venture) {
        Intent intent = new Intent(context, VentureDetailsActivity.class);
        intent.putExtra(VENTURE_KEY, venture);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venture_details);
        setStatusBarColorResource(R.color.black);
        venture = getIntent().getParcelableExtra(VENTURE_KEY);
        viewBinder = new ViewBinder(findViewById(android.R.id.content));
        setupViewPager(venture.getCompany().getFeaturedImageUrls());
        setupPageIndicator();
        setFieldsForVenture(venture);
    }

    private void setFieldsForVenture(Venture venture) {
        viewBinder.getCompanyName().setText(venture.getCompany().getName());
        viewBinder.getVentureDescriptionTextView().setVisibility(StringUtil.isEmpty(venture.getDescription()) ? View.GONE : View.VISIBLE);
        if (!StringUtil.isEmpty(venture.getDescription())) {
            viewBinder.getVentureDescriptionTextView().setText(venture.getDescription());
        }
        viewBinder.getCompanyDescriptionTitle().setText(getString(R.string.what_is_company, venture.getCompany().getName()));
        viewBinder.getCompanyDescription().setText(venture.getCompany().getDescription());
        viewBinder.getVentureProblem().setText(venture.getProblem());
        viewBinder.getVentureSolution().setText(venture.getSolution());
        viewBinder.getVentureBusinessModel().setText(venture.getMonetization());
        viewBinder.getVentureLessonLearned().setText(venture.getLesson());
    }

    private void setupPageIndicator() {
        viewBinder.getPageIndicator().setViewPager(viewBinder.getSlidesViewPager());
    }

    public void setupViewPager(List<String> urls) {
        viewBinder.getSlidesViewPager().setAdapter(new SlidesPageAdapter(urls));
    }

    // ------ VIEW BINDER ------

    private class ViewBinder extends com.yapd.alexander.yapd.client.util.view.common.ViewBinder {
        private ViewPager slidesViewPager;
        private CirclePageIndicator pageIndicator;
        private TextView companyName;
        private TextView ventureDescriptionTextView;
        private TextView companyDescriptionTitle;
        private TextView companyDescription;
        private TextView ventureProblem;
        private TextView ventureSolution;
        private TextView ventureBusinessModel;
        private TextView ventureLessonLearned;

        public ViewBinder(View view) {
            super(view);
        }

        public ViewPager getSlidesViewPager() {
            return slidesViewPager = getView(slidesViewPager, R.id.activity_venture_details_view_pager);
        }

        public PageIndicator getPageIndicator() {
            return pageIndicator = getView(pageIndicator, R.id.activity_venture_details_view_pager_indicator);
        }

        public TextView getCompanyName() {
            return companyName = getView(companyName, R.id.activity_venture_details_company_name);
        }

        public TextView getVentureDescriptionTextView() {
            return ventureDescriptionTextView = getView(ventureDescriptionTextView, R.id.activity_venture_details_venture_description);
        }

        public TextView getCompanyDescriptionTitle() {
            return companyDescriptionTitle = getView(companyDescriptionTitle, R.id.activity_venture_details_company_description_title_text_view);
        }

        public TextView getCompanyDescription() {
            return companyDescription = getView(companyDescription, R.id.activity_venture_details_company_description_text_view);
        }

        public TextView getVentureProblem() {
            return ventureProblem = getView(ventureProblem, R.id.activity_venture_details_problem_text_view);
        }

        public TextView getVentureSolution() {
            return ventureSolution = getView(ventureSolution, R.id.activity_venture_details_solution_text_view);
        }

        public TextView getVentureBusinessModel() {
            return ventureBusinessModel = getView(ventureBusinessModel, R.id.activity_venture_details_business_model_text_view);
        }

        public TextView getVentureLessonLearned() {
            return ventureLessonLearned = getView(ventureLessonLearned, R.id.activity_venture_details_lesson_text_view);
        }
    }
}
