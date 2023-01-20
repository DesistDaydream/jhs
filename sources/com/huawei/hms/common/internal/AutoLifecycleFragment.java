package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.api.HuaweiApiClient;

/* loaded from: classes2.dex */
public class AutoLifecycleFragment extends Fragment {
    private final SparseArray<a> a = new SparseArray<>();
    private boolean b;

    /* loaded from: classes2.dex */
    public static class a {
        public final HuaweiApiClient a;

        public a(int i2, HuaweiApiClient huaweiApiClient) {
            this.a = huaweiApiClient;
        }

        public void a() {
            this.a.disconnect();
        }
    }

    public static AutoLifecycleFragment getInstance(Activity activity) {
        Preconditions.checkMainThread("Must be called on the main thread");
        try {
            AutoLifecycleFragment autoLifecycleFragment = (AutoLifecycleFragment) activity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (autoLifecycleFragment == null) {
                AutoLifecycleFragment autoLifecycleFragment2 = new AutoLifecycleFragment();
                fragmentManager.beginTransaction().add(autoLifecycleFragment2, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
                fragmentManager.executePendingTransactions();
                return autoLifecycleFragment2;
            }
            return autoLifecycleFragment;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", e2);
        }
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.b = true;
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.valueAt(i2).a.connect((Activity) null);
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.b = false;
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.valueAt(i2).a.disconnect();
        }
    }

    public void startAutoMange(int i2, HuaweiApiClient huaweiApiClient) {
        Preconditions.checkNotNull(huaweiApiClient, "HuaweiApiClient instance cannot be null");
        boolean z = this.a.indexOfKey(i2) < 0;
        Preconditions.checkState(z, "Already managing a HuaweiApiClient with this clientId: " + i2);
        this.a.put(i2, new a(i2, huaweiApiClient));
        if (this.b) {
            huaweiApiClient.connect((Activity) null);
        }
    }

    public void stopAutoManage(int i2) {
        a aVar = this.a.get(i2);
        this.a.remove(i2);
        if (aVar != null) {
            aVar.a();
        }
    }
}
