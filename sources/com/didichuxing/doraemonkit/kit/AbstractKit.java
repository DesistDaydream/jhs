package com.didichuxing.doraemonkit.kit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.didichuxing.doraemonkit.kit.IKit;
import com.didichuxing.doraemonkit.kit.core.BaseFragment;
import h.i;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J=\u0010\f\u001a\u00020\u000b2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/didichuxing/doraemonkit/kit/AbstractKit;", "Lcom/didichuxing/doraemonkit/kit/IKit;", "Ljava/lang/Class;", "Lcom/didichuxing/doraemonkit/kit/core/BaseFragment;", "fragmentClass", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", TTLiveConstants.BUNDLE_KEY, "", "isSystemFragment", "Lh/t1;", "startUniversalActivity", "(Ljava/lang/Class;Landroid/content/Context;Landroid/os/Bundle;Z)V", "", "innerKitId", "()Ljava/lang/String;", "Landroid/app/Activity;", "currentActivity", "()Landroid/app/Activity;", "isInnerKit", "()Z", "", "getCategory", "()I", "category", "canShow", "Z", "getCanShow", "setCanShow", "(Z)V", "<init>", "()V", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public abstract class AbstractKit implements IKit {
    private boolean canShow = true;

    public static /* synthetic */ void startUniversalActivity$default(AbstractKit abstractKit, Class cls, Context context, Bundle bundle, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                bundle = null;
            }
            if ((i2 & 8) != 0) {
                z = false;
            }
            abstractKit.startUniversalActivity(cls, context, bundle, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startUniversalActivity");
    }

    @e
    public final Activity currentActivity() {
        return null;
    }

    public final boolean getCanShow() {
        return this.canShow;
    }

    @Override // com.didichuxing.doraemonkit.kit.IKit
    public int getCategory() {
        return 9;
    }

    @d
    public String innerKitId() {
        return "";
    }

    public boolean isInnerKit() {
        return false;
    }

    @Override // com.didichuxing.doraemonkit.kit.IKit
    @i(message = "请使用onClickWithReturn代替")
    public void onClick(@e Context context) {
        IKit.DefaultImpls.onClick(this, context);
    }

    @Override // com.didichuxing.doraemonkit.kit.IKit
    public boolean onClickWithReturn(@d Activity activity) {
        return IKit.DefaultImpls.onClickWithReturn(this, activity);
    }

    public final void setCanShow(boolean z) {
        this.canShow = z;
    }

    public final void startUniversalActivity(@d Class<? extends BaseFragment> cls, @e Context context, @e Bundle bundle, boolean z) {
    }
}
