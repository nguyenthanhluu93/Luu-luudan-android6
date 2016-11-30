package com.nankai.designlayout.tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.nankai.designlayout.R;

/**
 * Created by namIT on 6/18/2016.
 */
public abstract class BaseCoordinatorLayout extends CoordinatorLayout {

    private CoordinatorLayout header;
    private RelativeLayout content;
    AppBarLayout defaultViewHeader;
    private final int GRAVITY_TOP = 1;
    private final int GRAVITY_BOTTOM = 2;
    private final int DEFAULT_SCROLL_FLAG = -1;
    @AppBarLayout.LayoutParams.ScrollFlags
    int scrollFlag;

    public BaseCoordinatorLayout(Context context) {
        super(context);
//        initView(context, null);
    }

    public BaseCoordinatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
//        initView(context, attrs);
    }

    @SuppressWarnings("WrongConstant")
    public void initView(Context context, AttributeSet attrs) {

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.tab_design);
        int type = a.getInt(R.styleable.tab_design_tabLayoutGravity, GRAVITY_TOP);
        Log.d("namIT", type + " type");
        if (type == GRAVITY_BOTTOM) {
            inflate(getContext(), R.layout.coordinator_layout_bottom_base, this);
        } else {
            inflate(getContext(), R.layout.coordinator_layout_top_base, this);
        }
        scrollFlag = a.getInt(R.styleable.tab_coordinator_scrollFlag, DEFAULT_SCROLL_FLAG);
        Log.d("namIT", scrollFlag + " scrollFlag");
        a.recycle();
        defaultViewHeader = (AppBarLayout) findViewById(R.id.defaultViewHeader);
        header = (CoordinatorLayout) findViewById(R.id.design_header);
        content = (RelativeLayout) findViewById(R.id.design_content);
        if (scrollFlag != DEFAULT_SCROLL_FLAG && type != GRAVITY_BOTTOM) {
            AppBarLayout.LayoutParams params = new AppBarLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setScrollFlags(scrollFlag);
            header.setLayoutParams(params);
        }
    }

    /**
     * @return CoordinatorLayout header
     */
    protected CoordinatorLayout getHeader() {
        return this.header;
    }

    /**
     * add view vào header
     *
     * @param view
     */
    protected void addLayoutHeader(View view) {
        getHeader().removeAllViews();
        getHeader().addView(view);
    }

    /**
     * add view vào header
     *
     * @param view
     * @param layoutParams dùng để xác định layoutParams của view được chuyền vào
     */
    protected void addLayoutHeader(View view, RelativeLayout.LayoutParams layoutParams) {
        getHeader().removeAllViews();
        getHeader().addView(view, layoutParams);
    }

    /**
     * @return RelativeLayout content
     */
    protected RelativeLayout getContent() {
        return this.content;
    }

    /**
     * add view vào content
     *
     * @param view
     */
    protected void addLayoutContent(View view) {
        getContent().removeAllViews();
        getContent().addView(view);
    }

    /**
     * add view vào content
     *
     * @param view
     * @param layoutParams dùng để xác định layoutParams của view được chuyền vào
     */
    protected void addLayoutContent(View view, ViewPager.LayoutParams layoutParams) {
        getContent().removeAllViews();
        getContent().addView(view, layoutParams);
    }
}
