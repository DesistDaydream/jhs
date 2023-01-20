package com.tencent.qcloud.tuicore.component.fragments;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

/* loaded from: classes3.dex */
public class BaseFragment extends Fragment {
    public void backward() {
        if (getFragmentManager() == null) {
            return;
        }
        getFragmentManager().popBackStack();
    }

    public void forward(Fragment fragment, boolean z) {
        forward(getId(), fragment, null, z);
    }

    public void forward(int i2, Fragment fragment, String str, boolean z) {
        if (getFragmentManager() == null) {
            return;
        }
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        if (z) {
            beginTransaction.hide(this);
            beginTransaction.add(i2, fragment);
        } else {
            beginTransaction.replace(i2, fragment);
        }
        beginTransaction.addToBackStack(str);
        beginTransaction.commitAllowingStateLoss();
    }
}
