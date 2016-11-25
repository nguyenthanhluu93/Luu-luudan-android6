package com.gvn.pets.base.view.root.helper;

import com.gvn.pets.base.view.root.SupportFragment;

/**
 * Created by namIT on 11/21/2016.
 */

public interface ISupport {

    /**
     * load fragment
     *
     * @param containerId id
     * @param toFragment  Fragment
     */
    void loadRootFragment(int containerId, SupportFragment toFragment);

    /**
     * replace Fragment
     */
    void replaceLoadRootFragment(int containerId, SupportFragment toFragment, boolean addToBack);

    /**
     * Load multiple Fragment
     *
     * @param containerId id
     * @param toFragments  Fragments
     */
    void loadMultipleRootFragment(int containerId, int showPosition, SupportFragment... toFragments);

    /**
     * show一Fragment,hide一Fragment ; used mainly in the tabView
     *
     * @param showFragment  show Fragment
     * @param hideFragment  hide Fragment
     */
    void showHideFragment(SupportFragment showFragment, SupportFragment hideFragment);

    /**
     * Starts the target Fragment
     *
     * @param toFragment Fragment
     */
    void start(SupportFragment toFragment);

    /**
     * @param toFragment Fragment
     * @param launchMode mode
     */
    void start(SupportFragment toFragment,int launchMode);

    /**
     * @param toFragment  Fragment
     * @param requestCode requsetCode
     */
    void startForResult(SupportFragment toFragment, int requestCode);

    /**
     * Start the target Fragment and pop the current Fragment
     *
     * @param toFragment Fragment
     */
    void startWithPop(SupportFragment toFragment);

    /**
     * @return Fragment
     */
    SupportFragment getTopFragment();

    /**
     * @param fragmentClass Fragment Class
     * @param <T>           SupportFragment Fragment
     * @return Fragment
     */
    <T extends SupportFragment> T findFragment(Class<T> fragmentClass);

    void pop();

    /**
     * The stack is pushed to the destination Fragment
     *
     * @param fragmentClass Fragment lass
     * @param includeSelf   Fragment
     */
    void popTo(Class<?> fragmentClass, boolean includeSelf);

    /**
     * The stack to the target Fragment, and immediately after the stack Fragment transaction (to prevent the stack, directly to the Fragment transaction exception)
     *
     * @param fragmentClass               Fragment Class
     * @param includeSelf                 Fragment
     * @param afterPopTransactionRunnable Fragment
     */
    void popTo(Class<?> fragmentClass, boolean includeSelf, Runnable afterPopTransactionRunnable);
}

