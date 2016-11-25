package com.gvn.pets.base.view.root;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentTransactionBugFixHack;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.gvn.pets.base.view.root.debug.DebugFragmentRecord;
import com.gvn.pets.base.view.root.debug.DebugHierarchyViewContainer;
import com.gvn.pets.base.view.root.helper.FragmentResultRecord;
import com.gvn.pets.base.view.root.helper.OnEnterAnimEndListener;
import com.gvn.pets.base.view.root.helper.OnFragmentDestoryViewListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller
 * Created by namIT on 11/21/2016.
 */
public class Fragmentation {
    static final String TAG = Fragmentation.class.getSimpleName();

    public static final String FRAGMENTATION_ARG_RESULT_RECORD = "fragment_arg_result_record";
    public static final String FRAGMENTATION_ARG_IS_ROOT = "fragmentation_arg_is_root";
    public static final String FRAGMENTATION_ARG_IS_SHARED_ELEMENT = "fragmentation_arg_is_shared_element";
    public static final String FRAGMENTATION_ARG_CONTAINER = "fragmentation_arg_container";

    public static final String FRAGMENTATION_STATE_SAVE_ANIMATOR = "fragmentation_state_save_animator";
    public static final String FRAGMENTATION_STATE_SAVE_IS_HIDDEN = "fragmentation_state_save_status";

    public static final long BUFFER_TIME = 300L;
    public static final long BUFFER_TIME_FOR_RESULT = 50L;

    public static final int TYPE_ADD = 0;
    public static final int TYPE_ADD_WITH_POP = 1;
    public static final int TYPE_ADD_RESULT = 2;

    private SupportActivity mActivity;

    private Handler mHandler;

    public Fragmentation(SupportActivity activity) {
        this.mActivity = activity;
        mHandler = mActivity.getHandler();
    }

    /**
     * load Fragment
     *
     * @param containerId id
     * @param to          Fragment
     */
    public void loadRootTransaction(FragmentManager fragmentManager, int containerId, SupportFragment to) {
        bindContainerId(containerId, to);
        dispatchStartTransaction(fragmentManager, null, to, 0, SupportFragment.STANDARD, TYPE_ADD, null, null);
    }

    /**
     * replace load Fragment
     *
     * @param containerId id
     * @param to          Fragment
     */
    public void replaceLoadRootTransaction(FragmentManager fragmentManager, int containerId, SupportFragment to, boolean addToBack) {
        replaceTransaction(fragmentManager, containerId, to, addToBack);
    }

    /**
     * Multiple load Fragment
     */
    public void loadMultipleRootTransaction(FragmentManager fragmentManager, int containerId, int showPosition, SupportFragment... tos) {
        FragmentTransaction ft = fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        for (int i = 0; i < tos.length; i++) {
            SupportFragment to = tos[i];

            bindContainerId(containerId, tos[i]);

            String toName = to.getClass().getName();
            ft.add(containerId, to, toName);

            if (i != showPosition) {
                ft.hide(to);
            }

            Bundle bundle = to.getArguments();
            bundle.putBoolean(FRAGMENTATION_ARG_IS_ROOT, true);
        }

        ft.commit();
    }

    /**
     * Distribute the start transaction
     *
     * @param from        Fragment
     * @param to          Fragment
     * @param requestCode requestCode
     * @param launchMode  mode
     * @param type        type
     */
    public void dispatchStartTransaction(FragmentManager fragmentManager, SupportFragment from, SupportFragment to, int requestCode, int launchMode, int type, View sharedElement, String name) {
        if (sharedElement != null) {
            FragmentTransactionBugFixHack.reorderIndices(fragmentManager);
        }

        if (type == TYPE_ADD_RESULT) {
            saveRequestCode(to, requestCode);
        }

        if (from != null) {
            bindContainerId(from.getContainerId(), to);
        }

        if (handleLaunchMode(fragmentManager, to, launchMode)) return;

        mActivity.setFragmentClickable(false);

        switch (type) {
            case TYPE_ADD:
            case TYPE_ADD_RESULT:
                start(fragmentManager, from, to, sharedElement, name);
                break;
            case TYPE_ADD_WITH_POP:
                if (from != null) {
                    startWithPop(fragmentManager, from, to);
                } else {
                    throw new RuntimeException("startWithPop(): getTopFragment() is null");
                }
                break;
        }
    }

    private void bindContainerId(int containerId, SupportFragment to) {
        Bundle args = to.getArguments();
        if (args == null) {
            args = new Bundle();
            to.setArguments(args);
        }
        args.putInt(FRAGMENTATION_ARG_CONTAINER, containerId);
    }

    /**
     * Replace transaction, mainly used between the child Fragment replace
     *
     * @param from      Fragment
     * @param to        Fragment
     * @param addToBack IsAdded to the rollback stack
     */
    public void replaceTransaction(SupportFragment from, SupportFragment to, boolean addToBack) {
        replaceTransaction(from.getFragmentManager(), from.getContainerId(), to, addToBack);
    }

    /**
     * Replace transaction, mainly used between the child Fragment replace
     */
    void replaceTransaction(FragmentManager fragmentManager, int containerId, SupportFragment to, boolean addToBack) {
        bindContainerId(containerId, to);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(containerId, to, to.getClass().getName());
        if (addToBack) {
            ft.addToBackStack(to.getClass().getName());
        }
        Bundle bundle = to.getArguments();
        bundle.putBoolean(FRAGMENTATION_ARG_IS_ROOT, true);
        ft.commit();
    }

    /**
     * Show a Fragment, hide a Fragment; Mainly used for similar WeChat home page that switch tab
     *
     * @param showFragment show Fragment
     * @param hideFragment hide Fragment
     */
    public void showHideFragment(FragmentManager fragmentManager, SupportFragment showFragment, SupportFragment hideFragment) {
        if (showFragment == hideFragment) return;

        fragmentManager.beginTransaction()
                .show(showFragment)
                .hide(hideFragment)
                .commit();
    }

    void start(FragmentManager fragmentManager, SupportFragment from, SupportFragment to, View sharedElement, String name) {
        String toName = to.getClass().getName();
        FragmentTransaction ft = fragmentManager.beginTransaction();

        if (sharedElement == null) {
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        } else {
            Bundle bundle = to.getArguments();
            bundle.putBoolean(FRAGMENTATION_ARG_IS_SHARED_ELEMENT, true);
            ft.addSharedElement(sharedElement, name);
        }
        if (from == null) {
            ft.add(to.getArguments().getInt(FRAGMENTATION_ARG_CONTAINER), to, toName);

            Bundle bundle = to.getArguments();
            bundle.putBoolean(FRAGMENTATION_ARG_IS_ROOT, true);
        } else {
            ft.add(from.getContainerId(), to, toName);
            ft.hide(from);
        }

        ft.addToBackStack(toName);
        ft.commit();
    }

    void startWithPop(FragmentManager fragmentManager, SupportFragment from, SupportFragment to) {
        SupportFragment preFragment = getPreFragment(from);
        handlePopAnim(preFragment, from, to);

        fragmentManager.beginTransaction().remove(from).commit();
        handleBack(fragmentManager, true);

        String toName = to.getClass().getName();
        FragmentTransaction ft = fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .add(from.getContainerId(), to, toName)
                .addToBackStack(toName);

        if (preFragment != null) {
            ft.hide(preFragment);
        }
        ft.commit();
    }

    /**
     * Get the top supportFragment
     */
    public SupportFragment getTopFragment(FragmentManager fragmentManager) {
        List<Fragment> fragmentList = fragmentManager.getFragments();
        if (fragmentList == null) return null;

        for (int i = fragmentList.size() - 1; i >= 0; i--) {
            Fragment fragment = fragmentList.get(i);
            if (fragment instanceof SupportFragment) {
                return (SupportFragment) fragment;
            }
        }
        return null;
    }

    /**
     * Gets the previous Fragment of the target Fragment
     *
     * @param fragment Fragment
     */
    public SupportFragment getPreFragment(Fragment fragment) {
        List<Fragment> fragmentList = fragment.getFragmentManager().getFragments();
        if (fragmentList == null) return null;

        int index = fragmentList.indexOf(fragment);
        for (int i = index - 1; i >= 0; i--) {
            Fragment preFragment = fragmentList.get(i);
            if (preFragment instanceof SupportFragment) {
                return (SupportFragment) preFragment;
            }
        }
        return null;
    }

    /**
     * find Fragment from FragmentStack
     */
    @SuppressWarnings("unchecked")
    public <T extends SupportFragment> T findStackFragment(Class<T> fragmentClass, FragmentManager fragmentManager, boolean isChild) {
        Fragment fragment = null;
        if (isChild) {
            List<Fragment> childFragmentList = fragmentManager.getFragments();
            if (childFragmentList == null) return null;

            int sizeChildFrgList = childFragmentList.size();

            for (int i = sizeChildFrgList - 1; i >= 0; i--) {
                Fragment childFragment = childFragmentList.get(i);
                if (childFragment instanceof SupportFragment && childFragment.getClass().getName().equals(fragmentClass.getName())) {
                    fragment = childFragment;
                    break;
                }
            }
        } else {
            fragment = fragmentManager.findFragmentByTag(fragmentClass.getName());
        }
        if (fragment == null) {
            return null;
        }
        return (T) fragment;
    }

    /**
     * Looks from the top of the stack, the status of the show & userVisible the Fragment
     */
    public SupportFragment getActiveFragment(SupportFragment parentFragment, FragmentManager fragmentManager) {
        List<Fragment> fragmentList = fragmentManager.getFragments();
        if (fragmentList == null) {
            return parentFragment;
        }
        for (int i = fragmentList.size() - 1; i >= 0; i--) {
            Fragment fragment = fragmentList.get(i);
            if (fragment instanceof SupportFragment) {
                SupportFragment supportFragment = (SupportFragment) fragment;
                if (!supportFragment.isHidden() && supportFragment.getUserVisibleHint()) {
                    return getActiveFragment(supportFragment, supportFragment.getChildFragmentManager());
                }
            }
        }
        return parentFragment;
    }

    /**
     * The Fragment that dispatches the fallback event to the top of the stack (with the stack being the top of the stack)
     */
    public boolean dispatchBackPressedEvent(SupportFragment activeFragment) {
        if (activeFragment != null) {
            boolean result = activeFragment.onBackPressedSupport();
            if (result) {
                return true;
            }

            Fragment parentFragment = activeFragment.getParentFragment();
            if (dispatchBackPressedEvent((SupportFragment) parentFragment)) {
                return true;
            }
        }

        return false;
    }

    /**
     * handle LaunchMode
     */
    private boolean handleLaunchMode(FragmentManager fragmentManager, SupportFragment toragment, int launchMode) {
        SupportFragment topFragment = getTopFragment(fragmentManager);
        if (topFragment == null) return false;
        Fragment stackToFragment = findStackFragment(toragment.getClass(), fragmentManager, false);
        if (stackToFragment == null) return false;

        if (launchMode == SupportFragment.SINGLETOP) {
            if (toragment == topFragment || toragment.getClass().getName().equals(topFragment.getClass().getName())) {
                handleNewBundle(toragment, stackToFragment);
                return true;
            }
        } else if (launchMode == SupportFragment.SINGLETASK) {
            popToFix(toragment.getClass(), 0, fragmentManager);
            handleNewBundle(toragment, stackToFragment);
            return true;
        }

        return false;
    }

    private void handleNewBundle(SupportFragment toFragment, Fragment stackToFragment) {
        Bundle argsNewBundle = toFragment.getNewBundle();

        Bundle args = toFragment.getArguments();
        if (args.containsKey(FRAGMENTATION_ARG_CONTAINER)) {
            args.remove(FRAGMENTATION_ARG_CONTAINER);
        }

        if (argsNewBundle != null) {
            args.putAll(argsNewBundle);
        }

        ((SupportFragment) stackToFragment).onNewBundle(args);
    }

    /**
     * save requestCode
     */
    private void saveRequestCode(Fragment to, int requestCode) {
        Bundle bundle = to.getArguments();
        if (bundle == null) {
            bundle = new Bundle();
            to.setArguments(bundle);
        }
        FragmentResultRecord resultRecord = new FragmentResultRecord();
        resultRecord.requestCode = requestCode;
        bundle.putParcelable(FRAGMENTATION_ARG_RESULT_RECORD, resultRecord);
    }

    public void back(FragmentManager fragmentManager) {
        if (fragmentManager == null) return;

        int count = fragmentManager.getBackStackEntryCount();
        if (count > 1) {
            handleBack(fragmentManager, false);
        }
    }

    /**
     * handle result
     */
    private void handleBack(final FragmentManager fragmentManager, boolean fromStartWithPop) {
        List<Fragment> fragmentList = fragmentManager.getFragments();

        boolean flag = false;

        FragmentResultRecord fragmentResultRecord = null;
        long lastAnimTime = 0;

        for (int i = fragmentList.size() - 1; i >= 0; i--) {
            Fragment fragment = fragmentList.get(i);
            if (fragment instanceof SupportFragment) {
                final SupportFragment supportFragment = (SupportFragment) fragment;
                if (!flag) {
                    Bundle args = supportFragment.getArguments();
                    if (args == null || !args.containsKey(FRAGMENTATION_ARG_RESULT_RECORD)) break;
                    fragmentResultRecord = args.getParcelable(FRAGMENTATION_ARG_RESULT_RECORD);
                    if (fragmentResultRecord == null) break;

                    lastAnimTime = supportFragment.getExitAnimDuration();
                    flag = true;
                } else {
                    final FragmentResultRecord finalFragmentResultRecord = fragmentResultRecord;
                    long animTime = supportFragment.getPopEnterAnimDuration();

                    if (fromStartWithPop) {
                        fragmentManager.popBackStack();
                    } else {
                        fragmentManager.popBackStackImmediate();
                    }

                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            supportFragment.onFragmentResult(finalFragmentResultRecord.requestCode, finalFragmentResultRecord.resultCode, finalFragmentResultRecord.resultBundle);
                        }
                    }, Math.max(animTime, lastAnimTime) + BUFFER_TIME_FOR_RESULT);
                    return;
                }
            }
        }

        if (fromStartWithPop) {
            fragmentManager.popBackStack();
        } else {
            fragmentManager.popBackStackImmediate();
        }
    }

    /**
     * The stack to the target fragment
     *
     * @param fragmentClass fragment
     * @param includeSelf   Whether or not the fragment is included
     */
    public void popTo(Class<?> fragmentClass, boolean includeSelf, Runnable afterPopTransactionRunnable, FragmentManager fragmentManager) {
        if (fragmentManager == null) return;
        Fragment targetFragment = fragmentManager.findFragmentByTag(fragmentClass.getName());

        if (targetFragment == null) {
            Log.e(TAG, "Pop failure! Can't find " + fragmentClass.getSimpleName() + " in the FragmentManager's Stack.");
            return;
        }

        int flag;
        if (includeSelf) {
            flag = FragmentManager.POP_BACK_STACK_INCLUSIVE;
            targetFragment = getPreFragment(targetFragment);
        } else {
            flag = 0;
        }

        SupportFragment fromFragment = getTopFragment(fragmentManager);

        if (afterPopTransactionRunnable != null) {
            if (targetFragment == fromFragment) {
                mHandler.post(afterPopTransactionRunnable);
                return;
            }

            hackPopToAnim(targetFragment, fromFragment);

            popToFix(fragmentClass, flag, fragmentManager);
            mHandler.post(afterPopTransactionRunnable);
        } else {
            popToFix(fragmentClass, flag, fragmentManager);
        }
    }

    /**
     * Solve the popTo multiple fragments when the animation caused by the abnormal problem
     */
    private void popToFix(Class<?> fragmentClass, int flag, final FragmentManager fragmentManager) {
        if (fragmentManager.getFragments() == null) return;

        mActivity.preparePopMultiple();
        fragmentManager.popBackStackImmediate(fragmentClass.getName(), flag);
        mActivity.popFinish();

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                FragmentTransactionBugFixHack.reorderIndices(fragmentManager);
            }
        });
    }

    /**
     * hack anim
     */
    @Nullable
    private void handlePopAnim(SupportFragment preFragment, SupportFragment from, SupportFragment to) {
        if (preFragment != null) {
            View view = preFragment.getView();
            handlePopAnim(from, view, to);
        }
    }

    /**
     * hack popTo anim
     */
    @Nullable
    private void hackPopToAnim(Fragment targetFragment, SupportFragment fromFragment) {
        if (targetFragment != null) {
            View view = targetFragment.getView();
            handlePopAnim(fromFragment, view, null);
        }
    }

    private void handlePopAnim(SupportFragment fromFragment, View view, SupportFragment toFragment) {
        try {
            if (view != null) {
                ViewGroup preViewGroup = null;
                SupportFragment preFragment = null;
                // devices before 5.0, devices prior to 5.0, popTo (Class <?> FragmentClass, boolean includeSelf, Runnable afterPopTransactionRunnable)
                //In the stack of multiple Fragment and then immediately start operation, there will be an instant splash screen. The following code to solve the problem
                if (toFragment == null && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                    preFragment = getPreFragment(fromFragment);
                    if (preFragment != null) {
                        View preView = preFragment.getView();
                        if (preView != null && preView instanceof ViewGroup) {
                            preViewGroup = (ViewGroup) preView;
                        }
                    }
                }

                view.setVisibility(View.VISIBLE);

                final ViewGroup viewGroup;
                final View fromView = fromFragment.getView();

                if (fromView != null && view instanceof ViewGroup) {
                    viewGroup = (ViewGroup) view;
                    ViewGroup container = (ViewGroup) mActivity.findViewById(fromFragment.getContainerId());
                    if (container != null) {
                        container.removeView(fromView);
                        if (fromView.getLayoutParams().height != ViewGroup.LayoutParams.MATCH_PARENT) {
                            fromView.getLayoutParams().height = ViewGroup.LayoutParams.MATCH_PARENT;
                        }

                        if (preViewGroup != null) {
                            final ViewGroup finalPreViewGroup = preViewGroup;
                            preFragment.setOnFragmentDestoryViewListener(new OnFragmentDestoryViewListener() {
                                @Override
                                public void onDestoryView() {
                                    finalPreViewGroup.removeView(fromView);

                                    if (viewGroup instanceof LinearLayout) {
                                        viewGroup.addView(fromView, 0);
                                    } else {
                                        viewGroup.addView(fromView);
                                    }
                                }
                            });
                        }

                        if (viewGroup instanceof LinearLayout) {
                            if (preViewGroup != null) {
                                preViewGroup.addView(fromView, 0);
                            } else {
                                viewGroup.addView(fromView, 0);
                            }
                        } else {
                            if (preViewGroup != null) {
                                preViewGroup.addView(fromView);
                            } else {
                                viewGroup.addView(fromView);
                            }
                        }

                        if (toFragment == null) { // pop multiple fragment
                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    viewGroup.removeView(fromView);
                                }
                            }, Math.max(fromFragment.getExitAnimDuration(), BUFFER_TIME));
                        } else { // pop single fragment
                            toFragment.setEnterAnimEndListener(new OnEnterAnimEndListener() {
                                @Override
                                public void onAnimationEnd() {
                                    viewGroup.removeView(fromView);
                                }
                            });
                        }
                    }
                }
            }
        } catch (Exception e) {
            // ignore
        }
    }

    /**
     * Debug-related: Display the stack view as dialog
     */
    public void showFragmentStackHierarchyView() {
        DebugHierarchyViewContainer container = new DebugHierarchyViewContainer(mActivity);
        container.bindFragmentRecords(getFragmentRecords());
        container.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        new AlertDialog.Builder(mActivity)
                .setTitle("Stack view")
                .setView(container)
                .setPositiveButton("shut down", null)
                .setCancelable(true)
                .show();
    }

    /**
     * 调试相关:以log形式 打印 栈视图
     */
    public void logFragmentRecords(String tag) {
        List<DebugFragmentRecord> fragmentRecordList = getFragmentRecords();
        if (fragmentRecordList == null) return;

        StringBuilder sb = new StringBuilder();

        for (int i = fragmentRecordList.size() - 1; i >= 0; i--) {
            DebugFragmentRecord fragmentRecord = fragmentRecordList.get(i);

            if (i == fragmentRecordList.size() - 1) {
                sb.append("═══════════════════════════════════════════════════════════════════════════════════\n");
                if (i == 0) {
                    sb.append("\tTop of the stack\t\t\t").append(fragmentRecord.fragmentName).append("\n");
                    sb.append("═══════════════════════════════════════════════════════════════════════════════════");
                } else {
                    sb.append("\tTop of the stack\t\t\t").append(fragmentRecord.fragmentName).append("\n\n");
                }
            } else if (i == 0) {
                sb.append("\tTop of the stack\t\t\t").append(fragmentRecord.fragmentName).append("\n\n");
                processChildLog(fragmentRecord.childFragmentRecord, sb, 1);
                sb.append("═══════════════════════════════════════════════════════════════════════════════════");
                Log.i(tag, sb.toString());
                return;
            } else {
                sb.append("\t↓\t\t\t").append(fragmentRecord.fragmentName).append("\n\n");
            }

            processChildLog(fragmentRecord.childFragmentRecord, sb, 1);
        }
    }

    private List<DebugFragmentRecord> getFragmentRecords() {
        List<DebugFragmentRecord> fragmentRecordList = new ArrayList<>();

        List<Fragment> fragmentList = mActivity.getSupportFragmentManager().getFragments();

        if (fragmentList == null || fragmentList.size() < 1) return null;

        for (Fragment fragment : fragmentList) {
            if (fragment == null) continue;
            fragmentRecordList.add(new DebugFragmentRecord(fragment.getClass().getSimpleName(), getChildFragmentRecords(fragment)));
        }
        return fragmentRecordList;
    }

    private void processChildLog(List<DebugFragmentRecord> fragmentRecordList, StringBuilder sb, int childHierarchy) {
        if (fragmentRecordList == null || fragmentRecordList.size() == 0) return;

        for (int j = 0; j < fragmentRecordList.size(); j++) {
            DebugFragmentRecord childFragmentRecord = fragmentRecordList.get(j);
            for (int k = 0; k < childHierarchy; k++) {
                sb.append("\t\t\t");
            }
            if (j == 0) {
                sb.append("\tSub-stack top\t\t").append(childFragmentRecord.fragmentName).append("\n\n");
            } else if (j == fragmentRecordList.size() - 1) {
                sb.append("\tSub-stack top\t\t").append(childFragmentRecord.fragmentName).append("\n\n");
                processChildLog(childFragmentRecord.childFragmentRecord, sb, ++childHierarchy);
                return;
            } else {
                sb.append("\t↓\t\t\t").append(childFragmentRecord.fragmentName).append("\n\n");
            }

            processChildLog(childFragmentRecord.childFragmentRecord, sb, childHierarchy);
        }
    }

    private List<DebugFragmentRecord> getChildFragmentRecords(Fragment parentFragment) {
        List<DebugFragmentRecord> fragmentRecords = new ArrayList<>();

        List<Fragment> fragmentList = parentFragment.getChildFragmentManager().getFragments();
        if (fragmentList == null || fragmentList.size() < 1) return null;


        for (int i = fragmentList.size() - 1; i >= 0; i--) {
            Fragment fragment = fragmentList.get(i);
            if (fragment != null) {
                fragmentRecords.add(new DebugFragmentRecord(fragment.getClass().getSimpleName(), getChildFragmentRecords(fragment)));
            }
        }
        return fragmentRecords;
    }
}
