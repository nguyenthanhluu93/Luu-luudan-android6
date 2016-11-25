package com.gvn.pets.base.view.root.debug;

import java.util.List;

/**
 * Created by namIT on 11/21/2016.
 */

public class DebugFragmentRecord {
    public String fragmentName;
    public List<DebugFragmentRecord> childFragmentRecord;

    public DebugFragmentRecord(String fragmentName, List<DebugFragmentRecord> childFragmentRecord) {
        this.fragmentName = fragmentName;
        this.childFragmentRecord = childFragmentRecord;
    }
}