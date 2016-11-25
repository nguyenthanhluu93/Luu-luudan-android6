package com.gvn.pets.base.view.root.helper;

/**
 * On devices prior to 5.0, popTo (Class <?> FragmentClass, boolean includeSelf, Runnable afterPopTransactionRunnable)
 *   * An instantaneous splash occurs when multiple Fragments are released and then immediately executed.
 *   * The Listener is meant to solve the problem.
 * Created by namIT on 11/21/2016.
 */
public interface OnFragmentDestoryViewListener {
    void onDestoryView();
}