package com.gvn.pets.base.view.root.helper;

import android.view.View;

import com.gvn.pets.base.view.root.SupportFragment;

/**
 * Created by namIT on 11/21/2016.
 */

public interface ISupportFragment extends ISupport {

    /**
     * add Fragment, addSharedElement
     *
     * @param toFragment    Fragment
     * @param sharedElement A View in a disappearing Fragment to match with a View in an
     *                      appearing Fragment.
     * @param name          The transitionName for a View in an appearing Fragment to match to the shared
     *                      element.
     */
    void startWithSharedElement(SupportFragment toFragment, View sharedElement, String name);

    /**
     * startForResult addSharedElement
     */
    void startForResultWithSharedElement(SupportFragment toFragment, int requestCode, View sharedElement, String name);

    /**
     * replace Fragment, Fragment replace
     *
     * @param toFragment Fragment
     * @param addToBack  Is added to the rollback stack
     */
    void replaceFragment(SupportFragment toFragment, boolean addToBack);

    /**
     * @return The child at the top of the stack Fragment
     */
    SupportFragment getTopChildFragment();

    /**
     * @return The previous Fragment of the current Fragment
     */
    SupportFragment getPreFragment();

    /**
     * @param fragmentClass Class of target child Fragment
     * @param <T>          Fragment inherited from SupportFragment
     * @return Target sub-fragment
     */
    <T extends SupportFragment> T findChildFragment(Class<T> fragmentClass);

    /**
     * Stack out the stack
     */
    void popChild();

    /**
     * Stack the stack to the target Fragment
     *
     * @param fragmentClass Class of the target Fragment
     * @param includeSelf   Whether or not the target Fragment is included
     */
    void popToChild(Class<?> fragmentClass, boolean includeSelf);

    /**
     * Sub-stack stack to the target Fragment, and immediately after the stack Fragment transaction (to prevent the stack, the direct Fragment transaction exception)
     *
     * @param fragmentClass               Class of the target Fragment
     * @param includeSelf                 Whether or not the target Fragment is included
     * @param afterPopTransactionRunnable Immediately after the stack out of the Fragment transaction
     */
    void popToChild(Class<?> fragmentClass, boolean includeSelf, Runnable afterPopTransactionRunnable);
}

