package com.nankai.designlayout.tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.nankai.designlayout.R;
import com.nankai.designlayout.tabs.buider.Builder;


/**
 * Created by namIT on 6/18/2016.
 */
public class CoordinatorTabLayout extends BaseCoordinatorLayout {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdapter tabAdapter;
    private View headerView;
    private View contentView;

    int tabBackground;
    int tabIndicatorColor;
    int tabSelectedTextColor;
    int tabTextColor;
    float heightIndicator;

    private TabViewListener onTabViewListener;

    public interface TabViewListener extends TabListener {
    }

    public CoordinatorTabLayout(Context context) {
        super(context);
        initView(context, null);
        initViewTab(context, null);
    }

    public CoordinatorTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
        initViewTab(context, attrs);
    }

    public void initViewTab(Context context, AttributeSet attrs) {
        if (attrs == null) {
            tabBackground = R.color.colorBackground;
            tabIndicatorColor = R.color.white;
            tabSelectedTextColor = R.color.colorBackground;
            tabTextColor = R.color.textColorSecondary;
            heightIndicator = 0;
        } else {
            //TODO
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.tab_coordinator);
            tabBackground = a.getInt(R.styleable.tab_coordinator_tabLayoutBackground, R.color.colorBackground);
            tabIndicatorColor = a.getInt(R.styleable.tab_coordinator_tabLayoutIndicatorColor, R.color.white);
            tabSelectedTextColor = a.getInt(R.styleable.tab_coordinator_tabLayoutSelectedTextColor, R.color.colorBackground);
            tabTextColor = a.getInt(R.styleable.tab_coordinator_tabLayoutTextColor, R.color.textColorSecondary);
            heightIndicator = a.getDimension(R.styleable.tab_coordinator_tabLayoutIndicatorHeight, 0);
            a.recycle();
        }

        headerView = LayoutInflater.from(getContext()).inflate(R.layout.item_tab_layout, null, false);
        contentView = LayoutInflater.from(getContext()).inflate(R.layout.item_view_pager, null, false);
        tabLayout = (TabLayout) headerView.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) contentView.findViewById(R.id.content);

        addLayoutHeader(headerView);
        addLayoutContent(contentView);

        initTabLayout();
    }

    private void initTabLayout() {
        tabLayout.setBackgroundColor(tabBackground);
        tabLayout.setSelectedTabIndicatorColor(tabIndicatorColor);
        tabLayout.setSelectedTabIndicatorHeight(Math.round(heightIndicator));
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
            this.onTabViewListener = (TabViewListener) builder.onTabViewListener;
        setViewPager();
    }

    private void setViewPager() {
        ViewPager.LayoutParams layoutParamsViewPager = new
                ViewPager.LayoutParams();
        addLayoutContent(viewPager, layoutParamsViewPager);
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