package com.nankai.designlayout.tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.nankai.designlayout.R;
import com.nankai.designlayout.tabs.buider.Builder;

/**
 * Created by namIT on 11/8/2016.
 */
@Deprecated
public class DesignTabLayout extends RelativeLayout {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdapter tabAdapter;
    private int GRAVITY_TOP = 1;
    private int GRAVITY_BOTTOM = 2;

    int tabBackground;
    int tabIndicatorColor;
    int tabSelectedTextColor;
    int tabTextColor;

    private DesignTabLayout.TabViewListener onTabViewListener;

    public interface TabViewListener extends TabListener {
    }

    public DesignTabLayout(Context context) {
        super(context);
        initViewTab(context, null);
    }

    public DesignTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViewTab(context, attrs);
    }

    protected void initViewTab(Context context, AttributeSet attrs) {
        if (attrs == null) {
            tabBackground = R.color.colorBackground;
            tabIndicatorColor = R.color.white;
            tabSelectedTextColor = R.color.colorBackground;
            tabTextColor = R.color.textColorSecondary;
            inflate(getContext(), R.layout.tab_design_layout_top_base, this);
        } else {
            //TODO
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.tab_design);
            int type = a.getInt(R.styleable.tab_design_tabLayoutGravity, GRAVITY_TOP);
            if (type == GRAVITY_BOTTOM) {
                inflate(getContext(), R.layout.tab_design_layout_bottom_base, this);
            } else {
                inflate(getContext(), R.layout.tab_design_layout_top_base, this);
            }
            tabBackground = a.getInt(R.styleable.tab_design_tabLayoutBackground, R.color.colorBackground);
            tabIndicatorColor = a.getInt(R.styleable.tab_design_tabLayoutIndicatorColor, R.color.white);
            tabSelectedTextColor = a.getInt(R.styleable.tab_design_tabLayoutSelectedTextColor, R.color.colorBackground);
            tabTextColor = a.getInt(R.styleable.tab_design_tabLayoutTextColor, R.color.textColorSecondary);
        }

        viewPager = (ViewPager) findViewById(R.id.content);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        initTabLayout();
    }

    private void initTabLayout() {
        tabLayout.setBackgroundColor(tabBackground);
        tabLayout.setSelectedTabIndicatorColor(tabIndicatorColor);
        tabLayout.setTabTextColors(tabTextColor, tabSelectedTextColor);
    }

    /**
     * @param tabBackground
     */
    public void setBackgroundTab(@ColorInt int tabBackground) {
        this.tabBackground = tabBackground;
        initTabLayout();
    }

    /**
     * @param tabIndicatorColor
     */
    public void setIndicatorColorTab(@ColorInt int tabIndicatorColor) {
        this.tabIndicatorColor = tabIndicatorColor;
    }

    /**
     * @param tabSelectedTextColor
     */
    public void setSelectedTextColorTab(@ColorInt int tabSelectedTextColor) {
        this.tabSelectedTextColor = tabSelectedTextColor;
    }

    /**
     * @param tabTextColor
     */
    public void setTextColorTab(@ColorInt int tabTextColor) {
        this.tabTextColor = tabTextColor;
    }

    public void setBuilder(Builder builder) {
        if (builder == null)
            return;
        initBuilder(builder);
    }

    private void initBuilder(Builder builder) {
        if (builder.tabAdapter != null && builder.viewPager != null) {
            this.tabAdapter = builder.tabAdapter;
            this.viewPager = builder.viewPager;
        } else {
            return;
        }

        if (builder.onTabViewListener != null)
            this.onTabViewListener = (DesignTabLayout.TabViewListener) builder.onTabViewListener;
    }

    public Fragment getCurrentFragment(int index) {
        return tabAdapter.getItem(index);
    }

    public void setFocusTabIndex(int index) {
        try {
            viewPager.setCurrentItem(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TabLayout getTabLayout() {
        if (tabLayout == null)
            return tabLayout = new TabLayout(getContext());
        return tabLayout;
    }

    public ViewPager getViewPager() {
        if (viewPager == null)
            return viewPager = new ViewPager(getContext());
        return viewPager;
    }

    public TabAdapter getTabAdapter() {
        if (tabAdapter == null)
            return null;
        return tabAdapter;
    }
}
