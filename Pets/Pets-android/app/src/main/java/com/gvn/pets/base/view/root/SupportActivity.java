package com.gvn.pets.base.view.root;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.gvn.pets.base.view.root.helper.ISupport;
import com.gvn.pets.base.view.root.anim.DefaultVerticalAnimator;
import com.gvn.pets.base.view.root.anim.FragmentAnimator;

/**
 * Created by namIT on 11/21/2016.
 */

public class SupportActivity extends AppCompatActivity implements ISupport {
    private Fragmentation mFragmentation;

    private FragmentAnimator mFragmentAnimator;

    private int mDefaultFragmentBackground = 0;

    public boolean mPopMultipleNoAnim = false;

    // Anti-shake can be clicked
    private boolean mFragmentClickable = true;

    private Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFragmentation = getFragmentation();

        mFragmentAnimator = onCreateFragmentAnimator();
    }

    public Fragmentation getFragmentation() {
        if (mFragmentation == null) {
            mFragmentation = new Fragmentation(this);
        }
        return mFragmentation;
    }

    public Handler getHandler() {
        if (mHandler == null) {
            mHandler = new Handler();
        }
        return mHandler;
    }

    /**
     * Gets the set global animation, copy
     *
     * @return FragmentAnimator
     */
    public FragmentAnimator getFragmentAnimator() {
        return new FragmentAnimator(
                mFragmentAnimator.getEnter(), mFragmentAnimator.getExit(),
                mFragmentAnimator.getPopEnter(), mFragmentAnimator.getPopExit()
        );
    }

    /**
     * To set the global animation, we recommend using the onCreateFragmentAnimator () setting
     */
    public void setFragmentAnimator(FragmentAnimator fragmentAnimator) {
        this.mFragmentAnimator = fragmentAnimator;
    }

    /**
     * Build Fragment transition animation
     * <p/>
     * If it is in the Activity to achieve, then the activity is to build all the Fragment transition animation,
     * If it is implemented in the Fragment, the construction is the transition of the Fragment animation, then the priority> Activity onCreateFragmentAnimator ()
     *
     * @return FragmentAnimator object
     */
    protected FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultVerticalAnimator();
    }

    /**
     * When the Fragment root layout does not set the background attribute,
     * Fragmentation uses Theme android: windowbackground as the default Fragment background,
     * This method can be used to change the Fragment background.
     */
    protected void setDefaultFragmentBackground(@DrawableRes int backgroundRes) {
        mDefaultFragmentBackground = backgroundRes;
    }

    /**
     * (Because of the asynchronous nature of the transaction). If you want to use the Fragment transaction methods such as start / pop in onCreate (), use this method to queue your tasks
     *
     * @param runnable The tasks that need to be performed
     */
    protected void enqueueAction(Runnable runnable) {
        getHandler().post(runnable);
    }

    /**
     * It is not recommended to override this method, use {@link #onBackPressedSupport} instead
     */
    @Deprecated
    @Override
    public void onBackPressed() {
        if (!mFragmentClickable) {
            setFragmentClickable(true);
        }

        SupportFragment activeFragment = mFragmentation.getActiveFragment(null, getSupportFragmentManager());
        if (mFragmentation.dispatchBackPressedEvent(activeFragment)) return;

        onBackPressedSupport();
    }

    /**
     * The method callback time is, Activity back off the stack within the number of Fragment less than or equal to 1, the default finish Activity
     * Please try to rewrite the method, to avoid duplication onBackPress (), to ensure that the SupportFragment onBackPressedSupport () fallback event normal execution
     */
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            finish();
        }
    }

    @Override
    public void loadRootFragment(int containerId, SupportFragment toFragment) {
        mFragmentation.loadRootTransaction(getSupportFragmentManager(), containerId, toFragment);
    }

    @Override
    public void replaceLoadRootFragment(int containerId, SupportFragment toFragment, boolean addToBack) {
        mFragmentation.replaceLoadRootTransaction(getSupportFragmentManager(), containerId, toFragment, addToBack);
    }

    @Override
    public void loadMultipleRootFragment(int containerId, int showPosition, SupportFragment... toFragments) {
        mFragmentation.loadMultipleRootTransaction(getSupportFragmentManager(), containerId, showPosition, toFragments);
    }

    @Override
    public void showHideFragment(SupportFragment showFragment, SupportFragment hideFragment) {
        mFragmentation.showHideFragment(getSupportFragmentManager(), showFragment, hideFragment);
    }

    @Override
    public void start(SupportFragment toFragment) {
        start(toFragment, SupportFragment.STANDARD);
    }

    @Override
    public void start(SupportFragment toFragment, int launchMode) {
        mFragmentation.dispatchStartTransaction(getSupportFragmentManager(), getTopFragment(), toFragment, 0, launchMode, Fragmentation.TYPE_ADD, null, null);
    }

    @Override
    public void startForResult(SupportFragment toFragment, int requestCode) {
        mFragmentation.dispatchStartTransaction(getSupportFragmentManager(), getTopFragment(), toFragment, requestCode, SupportFragment.STANDARD, Fragmentation.TYPE_ADD_RESULT, null, null);
    }

    @Override
    public void startWithPop(SupportFragment toFragment) {
        mFragmentation.dispatchStartTransaction(getSupportFragmentManager(), getTopFragment(), toFragment, 0, SupportFragment.STANDARD, Fragmentation.TYPE_ADD_WITH_POP, null, null);
    }

    /**
     * Get the Fragment at the top of the stack
     */
    @Override
    public SupportFragment getTopFragment() {
        return mFragmentation.getTopFragment(getSupportFragmentManager());
    }

    /**
     * Gets the fragment object within the stack
     */
    @Override
    public <T extends SupportFragment> T findFragment(Class<T> fragmentClass) {
        return mFragmentation.findStackFragment(fragmentClass, getSupportFragmentManager(), false);
    }

    /**
     * Out stack
     */
    @Override
    public void pop() {
        mFragmentation.back(getSupportFragmentManager());
    }

    /**
     * The stack to the target fragment
     *
     * @param fragmentClass fragment
     * @param includeSelf   Whether or not the fragment is included
     */
    @Override
    public void popTo(Class<?> fragmentClass, boolean includeSelf) {
        mFragmentation.popTo(fragmentClass, includeSelf, null, getSupportFragmentManager());
    }

    /**
     * The FragmentTransaction operation is performed immediately after the stack is released
     */
    @Override
    public void popTo(Class<?> fragmentClass, boolean includeSelf, Runnable afterPopTransactionRunnable) {
        mFragmentation.popTo(fragmentClass, includeSelf, afterPopTransactionRunnable, getSupportFragmentManager());
    }

    public void preparePopMultiple() {
        mPopMultipleNoAnim = true;
    }

    public void popFinish() {
        mPopMultipleNoAnim = false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (!mFragmentClickable) {
                setFragmentClickable(true);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (!mFragmentClickable) return true;

        return super.dispatchTouchEvent(ev);
    }

    /**
     * Anti-shake (to prevent too fast click)
     */
    public void setFragmentClickable(boolean clickable) {
        mFragmentClickable = clickable;
    }

    public int getDefaultFragmentBackground() {
        return mDefaultFragmentBackground;
    }

    public void setFragmentClickable() {
        mFragmentClickable = true;
    }

    /**
     * Displays the stack view dialog, which is used during debugging
     */
    public void showFragmentStackHierarchyView() {
        mFragmentation.showFragmentStackHierarchyView();
    }

    /**
     * Displays the stack view log, which is used during debugging
     */
    public void logFragmentStackHierarchy(String TAG) {
        mFragmentation.logFragmentRecords(TAG);
    }
}
