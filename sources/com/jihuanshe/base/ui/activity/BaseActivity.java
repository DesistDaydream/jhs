package com.jihuanshe.base.ui.activity;

import com.vector.design.ui.activity.ActivityEx;
import e.l.h.l.b;
import h.i;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/jihuanshe/base/ui/activity/BaseActivity;", "VM", "Lcom/jihuanshe/base/viewmodel/BaseViewModel;", "Lcom/vector/design/ui/activity/ActivityEx;", "()V", "onBackPressed", "", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@i(message = "Don't extend this class")
/* loaded from: classes2.dex */
public abstract class BaseActivity<VM extends b> extends ActivityEx<VM> {
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finishAfterTransition();
    }
}
