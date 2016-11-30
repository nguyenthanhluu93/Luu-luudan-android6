package com.gvn.pets.ui.activity;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.gvn.pets.R;
import com.gvn.pets.base.model.ServerResponse;
import com.gvn.pets.base.view.root.BaseActivityDefaultCallBack;
import com.gvn.pets.presenter.SignUpPresenter;
import com.gvn.pets.widget.FontTextView;
import com.viewpagerindicator.BigCirclePageIndicator;

import retrofit2.Response;

/**
 * Created by namIT on 11/29/2016.
 */

public class SignUpActivity extends BaseActivityDefaultCallBack<SignUpPresenter> {

    private static String TAG = SplashActivity.class.getSimpleName();
    private static final String ELEMENT_LOGO = "logo";

    private ViewPager mViewPager;
    private MyPagerAdapter pagerAdapter;
    private BigCirclePageIndicator mCirclePageIndicator;
    private ImageView logo;
    private FontTextView textContent;

    public static void launch(AppCompatActivity activity, ImageView logo) {
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, logo, ELEMENT_LOGO);
        Intent intent = new Intent(activity, SignUpActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_signup;
    }

    @Override
    protected void initInject() {
        //Register fragment
        getActivityComponent().inject(this);

        textContent = bindView(R.id.activity_signup_content_text);
        logo = bindView(R.id.activity_signup_logo);
        mViewPager = bindView(R.id.activity_signup_viewpager);
        mCirclePageIndicator = bindView(R.id.activity_signup_indicator);
        pagerAdapter = new MyPagerAdapter();
    }

    @Override
    protected void onViewReady() {
        textContent.setText(getString(R.string.introduction_1));
        ViewCompat.setTransitionName(logo, ELEMENT_LOGO);
        mViewPager.setAdapter(pagerAdapter);
        mCirclePageIndicator.setViewPager(mViewPager);
        logo.callOnClick();
        mViewPager.addOnPageChangeListener(pageChangeListener);
    }

    ViewPager.OnPageChangeListener pageChangeListener = new  ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            textContent.setText("");
            if (position == 0) {
                textContent.setText(getString(R.string.introduction_1));
            } else if (position == 1) {
                textContent.setText(getString(R.string.introduction_2));
            } else {
                textContent.setText(getString(R.string.introduction_3));
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @Override
    public <E extends ServerResponse> void showContent(Response<E> response) {

    }

    private class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 3;
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == (RelativeLayout) object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view;
            if (position == 0) {
                view = View.inflate(getApplicationContext(),
                        R.layout.item_pager_introduction_1, null);
            } else if (position == 1) {
                view = View.inflate(getApplicationContext(),
                        R.layout.item_pager_introduction_2, null);
            } else {
                view = View.inflate(getApplicationContext(),
                        R.layout.item_pager_introduction_3, null);
            }

            ((ViewPager) container).addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
        }

    }
}