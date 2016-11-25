package com.gvn.pets.base.view.root;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;

import com.gvn.pets.base.view.root.anim.FragmentAnimator;
import com.gvn.pets.base.view.root.helper.ISupportFragment;
import com.gvn.pets.base.view.root.helper.AnimatorHelper;
import com.gvn.pets.base.view.root.helper.DebounceAnimListener;
import com.gvn.pets.base.view.root.helper.FragmentResultRecord;
import com.gvn.pets.base.view.root.helper.OnEnterAnimEndListener;
import com.gvn.pets.base.view.root.helper.OnFragmentDestoryViewListener;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by namIT on 11/21/2016.
 */

public class SupportFragment extends Fragment implements ISupportFragment {
    // LaunchMode
    public static final int STANDARD = 0;
    public static final int SINGLETOP = 1;
    public static final int SINGLETASK = 2;

    // ResultCode
    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_OK = -1;

    private static final long SHOW_SPACE = 200L;
    private static final long DEFAULT_ANIM_DURATION = 300L;

    private Bundle mNewBundle;

    private boolean mIsRoot, mIsSharedElement;
    private boolean mIsHidden = true;   // Used to record the Fragment show / hide state

    private InputMethodManager mIMM;
    private boolean mNeedHideSoft; // Hide the soft keyboard

    private OnEnterAnimEndListener mOnAnimEndListener; // fragmentation required

    protected SupportActivity mActivity;
    protected Fragmentation mFragmentation;
    private int mContainerId;   //The Fragment Container in which the id

    private FragmentAnimator mFragmentAnimator;
    private AnimatorHelper mAnimHelper;
    private boolean mNoneEnterAnimFlag = false;//Used to record no animation, the anti-shake processing

    protected boolean mLocking; // Whether to lock for Fragmentation-SwipeBack

    private OnFragmentDestoryViewListener mFragmentDestoryViewListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof SupportActivity) {
            this.mActivity = (SupportActivity) activity;
            mFragmentation = mActivity.getFragmentation();
        } else {
            throw new RuntimeException(activity.toString() + "must extends SupportActivity!");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            mIsRoot = bundle.getBoolean(Fragmentation.FRAGMENTATION_ARG_IS_ROOT, false);
            mIsSharedElement = bundle.getBoolean(Fragmentation.FRAGMENTATION_ARG_IS_SHARED_ELEMENT, false);
            mContainerId = bundle.getInt(Fragmentation.FRAGMENTATION_ARG_CONTAINER);
        }

        if (savedInstanceState == null) {
            mFragmentAnimator = onCreateFragmentAnimator();
            if (mFragmentAnimator == null) {
                mFragmentAnimator = mActivity.getFragmentAnimator();
            }
        } else {
            mFragmentAnimator = savedInstanceState.getParcelable(Fragmentation.FRAGMENTATION_STATE_SAVE_ANIMATOR);
            mIsHidden = savedInstanceState.getBoolean(Fragmentation.FRAGMENTATION_STATE_SAVE_IS_HIDDEN);
        }

        if (restoreInstanceState()) {
            processRestoreInstanceState(savedInstanceState);
        }

        initAnim();
    }

    private void processRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden()) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }
    }

    /**
     * After the memory restart, whether to allow Fragmentation to help you restore the child Fragment state
     *  
     */
    protected boolean restoreInstanceState() {
        return true;
    }

    private void initAnim() {
        mAnimHelper = new AnimatorHelper(mActivity.getApplicationContext(), mFragmentAnimator);
        if (!mNoneEnterAnimFlag) {
            mAnimHelper.enterAnim.setAnimationListener(new DebounceAnimListener(this));
        }
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (mActivity.mPopMultipleNoAnim || mLocking) {
            if (transit == FragmentTransaction.TRANSIT_FRAGMENT_CLOSE && enter) {
                return mAnimHelper.getNoneAnimFixed();
            }
            return mAnimHelper.getNoneAnim();
        }
        if (transit == FragmentTransaction.TRANSIT_FRAGMENT_OPEN) {
            if (enter) {
                if (mIsRoot) {
                    mNoneEnterAnimFlag = true;
                    return mAnimHelper.getNoneAnim();
                }
                return mAnimHelper.enterAnim;
            } else {
                return mAnimHelper.popExitAnim;
            }
        } else if (transit == FragmentTransaction.TRANSIT_FRAGMENT_CLOSE) {
            return enter ? mAnimHelper.popEnterAnim : mAnimHelper.exitAnim;
        } else {
            if (mIsSharedElement && !enter && getEnterTransition() == null) {
                return mAnimHelper.exitAnim;
            }
            mNoneEnterAnimFlag = true;
            return super.onCreateAnimation(transit, enter, nextAnim);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(Fragmentation.FRAGMENTATION_STATE_SAVE_ANIMATOR, mFragmentAnimator);
        outState.putBoolean(Fragmentation.FRAGMENTATION_STATE_SAVE_IS_HIDDEN, isHidden());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        initFragmentBackground(view);
        if (view != null) {
            view.setClickable(true);
        }

        if (savedInstanceState != null) {
            notifyEnterAnimationEnd(savedInstanceState);
            mActivity.setFragmentClickable(true);
        } else if (mNoneEnterAnimFlag) {
            notifyEnterAnimationEnd(null);
            mActivity.setFragmentClickable(true);
        }
    }

    protected void initFragmentBackground(View view) {
        setBackground(view);
    }

    protected void setBackground(View view) {
        if (view != null && view.getBackground() == null) {
            int defaultBg = mActivity.getDefaultFragmentBackground();
            if (defaultBg == 0) {
                int background = getWindowBackground();
                view.setBackgroundResource(background);
            } else {
                view.setBackgroundResource(defaultBg);
            }
        }
    }

    protected int getWindowBackground() {
        TypedArray a = mActivity.getTheme().obtainStyledAttributes(new int[]{
                android.R.attr.windowBackground
        });
        int background = a.getResourceId(0, 0);
        a.recycle();
        return background;
    }

    /**
     * Only meaningful after memory restart (saveInstanceState! = Null)
     *
     * @return Fragment state hide: show
     *      
     */
    public boolean isSupportHidden() {
        return mIsHidden;
    }

    /**
     * Gets the container id where the fragment is located
     */
    public int getContainerId() {
        return mContainerId;
    }

    long getEnterAnimDuration() {
        if (mIsRoot) {
            return 0;
        }
        if (mAnimHelper == null) {
            return DEFAULT_ANIM_DURATION;
        }
        return mAnimHelper.enterAnim.getDuration();
    }

    public long getExitAnimDuration() {
        if (mAnimHelper == null) {
            return DEFAULT_ANIM_DURATION;
        }
        return mAnimHelper.exitAnim.getDuration();
    }

    public long getPopEnterAnimDuration() {
        if (mAnimHelper == null) {
            return DEFAULT_ANIM_DURATION;
        }
        return mAnimHelper.popEnterAnim.getDuration();
    }

    long getPopExitAnimDuration() {
        if (mAnimHelper == null) {
            return DEFAULT_ANIM_DURATION;
        }
        return mAnimHelper.popExitAnim.getDuration();
    }

    /**
     * Set the current Fragmemt animation to a higher priority than in SupportActivity
     */
    protected FragmentAnimator onCreateFragmentAnimator() {
        return mActivity.getFragmentAnimator();
    }

    /**
     * Pushed to the end of the animation, the callback
     */
    protected void onEnterAnimationEnd(Bundle savedInstanceState) {
    }

    private void notifyEnterAnimationEnd(final Bundle savedInstanceState) {
        mActivity.getHandler().post(new Runnable() {
            @Override
            public void run() {
                onEnterAnimationEnd(savedInstanceState);
            }
        });
    }

    /**
     * (Because of the asynchronous nature of the transaction). If you want to use the start / pop method in onCreateView / onActivityCreated, use this method to queue your task
     *
     * @param runnable The tasks that need to be performed
     */
    protected void enqueueAction(Runnable runnable) {
        mActivity.getHandler().postDelayed(runnable, getEnterAnimDuration());
    }

    /**
     *Hide the soft keyboard
     */
    protected void hideSoftInput() {
        if (getView() != null) {
            initImm();
            mIMM.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        }
    }

    /**
     *Display the soft keyboard, call the method, the onPause will automatically hide the soft keyboard
     */
    protected void showSoftInput(final View view) {
        if (view == null) return;
        initImm();
        view.requestFocus();
        mNeedHideSoft = true;
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                mIMM.showSoftInput(view, InputMethodManager.SHOW_FORCED);
            }
        }, SHOW_SPACE);
    }

    private void initImm() {
        if (mIMM == null) {
            mIMM = (InputMethodManager) mActivity.getSystemService(Context.INPUT_METHOD_SERVICE);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mNeedHideSoft) {
            hideSoftInput();
        }
    }

    @IntDef({STANDARD, SINGLETOP, SINGLETASK})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LaunchMode {
    }

    /**
     * Press the Back key to trigger, provided the SupportActivity's onBackPressed () method can be called
     *
     * @return False will continue to pass up, true is consumed the event
     */
    public boolean onBackPressedSupport() {
        return false;
    }

    @Override
    public void loadRootFragment(int containerId, SupportFragment toFragment) {
        mFragmentation.loadRootTransaction(getChildFragmentManager(), containerId, toFragment);
    }

    @Override
    public void replaceLoadRootFragment(int containerId, SupportFragment toFragment, boolean addToBack) {
        mFragmentation.replaceLoadRootTransaction(getChildFragmentManager(), containerId, toFragment, addToBack);
    }

    @Override
    public void loadMultipleRootFragment(int containerId, int showPosition, SupportFragment... toFragments) {
        mFragmentation.loadMultipleRootTransaction(getChildFragmentManager(), containerId, showPosition, toFragments);
    }

    @Override
    public void showHideFragment(SupportFragment showFragment, SupportFragment hideFragment) {
        mFragmentation.showHideFragment(getChildFragmentManager(), showFragment, hideFragment);
    }

    @Override
    public void start(SupportFragment toFragment) {
        start(toFragment, STANDARD);
    }

    @Override
    public void start(final SupportFragment toFragment, @LaunchMode final int launchMode) {
        mFragmentation.dispatchStartTransaction(getFragmentManager(), this, toFragment, 0, launchMode, Fragmentation.TYPE_ADD, null, null);
    }

    @Override
    public void startForResult(SupportFragment toFragment, int requestCode) {
        mFragmentation.dispatchStartTransaction(getFragmentManager(), this, toFragment, requestCode, STANDARD, Fragmentation.TYPE_ADD_RESULT, null, null);
    }

    @Override
    public void startWithPop(SupportFragment toFragment) {
        mFragmentation.dispatchStartTransaction(getFragmentManager(), this, toFragment, 0, STANDARD, Fragmentation.TYPE_ADD_WITH_POP, null, null);
    }

    @Override
    public void startWithSharedElement(SupportFragment toFragment, View sharedElement, String name) {
        mFragmentation.dispatchStartTransaction(getFragmentManager(), this, toFragment, 0, STANDARD, Fragmentation.TYPE_ADD, sharedElement, name);
    }

    @Override
    public void startForResultWithSharedElement(SupportFragment toFragment, int requestCode, View sharedElement, String name) {
        mFragmentation.dispatchStartTransaction(getFragmentManager(), this, toFragment, requestCode, STANDARD, Fragmentation.TYPE_ADD_RESULT, sharedElement, name);
    }

    @Override
    public void replaceFragment(SupportFragment toFragment, boolean addToBack) {
        mFragmentation.replaceTransaction(this, toFragment, addToBack);
    }

    /**
     * @return Fragment at the top of the stack
     */
    @Override
    public SupportFragment getTopFragment() {
        return mFragmentation.getTopFragment(getFragmentManager());
    }

    /**
     * @return The child Fragment at the top of the stack
     */
    @Override
    public SupportFragment getTopChildFragment() {
        return mFragmentation.getTopFragment(getChildFragmentManager());
    }

    /**
     * @return The previous Fragment at the current Fragment
     */
    @Override
    public SupportFragment getPreFragment() {
        return mFragmentation.getPreFragment(this);
    }

    /**
     * @return The fragment object for the fragmentClass inside the stack
     */
    @Override
    public <T extends SupportFragment> T findFragment(Class<T> fragmentClass) {
        return mFragmentation.findStackFragment(fragmentClass, getFragmentManager(), false);
    }

    /**
     * @return The fragment object of the fragmentClass within the stack
     */
    @Override
    public <T extends SupportFragment> T findChildFragment(Class<T> fragmentClass) {
        return mFragmentation.findStackFragment(fragmentClass, getChildFragmentManager(), true);
    }

    /**
     * Out stack
     */
    @Override
    public void pop() {
        mFragmentation.back(getFragmentManager());
    }

    /**
     * Stack out the stack
     */
    @Override
    public void popChild() {
        mFragmentation.back(getChildFragmentManager());
    }

    /**
     * The stack to the target fragment
     *
     * @param fragmentClass fragment
     * @param includeSelf   Whether or not the fragment is included
     */
    @Override
    public void popTo(Class<?> fragmentClass, boolean includeSelf) {
        popTo(fragmentClass, includeSelf, null);
    }

    /**
     * Sub-stack
     */
    @Override
    public void popToChild(Class<?> fragmentClass, boolean includeSelf) {
        popToChild(fragmentClass, includeSelf, null);
    }

    /**
     * The FragmentTransaction operation is performed immediately after the stack is released
     */
    @Override
    public void popTo(Class<?> fragmentClass, boolean includeSelf, Runnable afterPopTransactionRunnable) {
        mFragmentation.popTo(fragmentClass, includeSelf, afterPopTransactionRunnable, getFragmentManager());
    }

    /**
     * Sub-stack
     */
    @Override
    public void popToChild(Class<?> fragmentClass, boolean includeSelf, Runnable afterPopTransactionRunnable) {
        mFragmentation.popTo(fragmentClass, includeSelf, afterPopTransactionRunnable, getChildFragmentManager());
    }

    void popForSwipeBack() {
        mLocking = true;
        mFragmentation.back(getFragmentManager());
        mLocking = false;
    }

    /**
     *Setting Result Data (via startForResult)
     *
     * @param resultCode resultCode
     * @param bundle     Set the Result data
     */
    public void setFramgentResult(int resultCode, Bundle bundle) {
        Bundle args = getArguments();
        if (args == null || !args.containsKey(Fragmentation.FRAGMENTATION_ARG_RESULT_RECORD)) {
            return;
        }

        FragmentResultRecord fragmentResultRecord = args.getParcelable(Fragmentation.FRAGMENTATION_ARG_RESULT_RECORD);
        if (fragmentResultRecord != null) {
            fragmentResultRecord.resultCode = resultCode;
            fragmentResultRecord.resultBundle = bundle;
        }
    }

    /**
     * Accept Result data (return data via startForResult)
     *
     * @param requestCode requestCode
     * @param resultCode  resultCode
     * @param data        Result data
     */
    public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
    }

    /**
     * In the start (TargetFragment, LaunchMode), the start mode SingleTask / SingleTop, callback TargetFragment of the method
     *
     * @param args passed through the Fragment putNewBundle (Bundle newBundle) when the data transmission
     */
    public void onNewBundle(Bundle args) {
    }

    /**
     * Add NewBundle when starting the mode for SingleTask / SingleTop
     */
    public void putNewBundle(Bundle newBundle) {
        this.mNewBundle = newBundle;
    }

    public Bundle getNewBundle() {
        return mNewBundle;
    }

    public void setEnterAnimEndListener(OnEnterAnimEndListener onAnimEndListener) {
        this.mOnAnimEndListener = onAnimEndListener;
    }

    /**
     * Admission at the end of the animation, callback
     */
    public final void notifyEnterAnimEnd() {
        notifyEnterAnimationEnd(null);
        mActivity.setFragmentClickable(true);

        if (mOnAnimEndListener != null) {
            mOnAnimEndListener.onAnimationEnd();
        }
    }

    /**
     * @see OnFragmentDestoryViewListener
     */
    public void setOnFragmentDestoryViewListener(OnFragmentDestoryViewListener listener) {
        this.mFragmentDestoryViewListener = listener;
    }

    @Override
    public void onDestroyView() {
        if (mFragmentDestoryViewListener != null) {
            mFragmentDestoryViewListener.onDestoryView();
        }
        super.onDestroyView();
        mFragmentDestoryViewListener = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mOnAnimEndListener = null;
    }
}
