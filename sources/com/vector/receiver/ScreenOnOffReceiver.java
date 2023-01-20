package com.vector.receiver;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.lifecycle.LifecycleOwner;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.tencent.qcloud.tuicore.TUIConstants;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import i.b.q0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J5\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112%\u0010\u0007\u001a!\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bj\u0002`\u000eJ\u001c\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R1\u0010\u0007\u001a%\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\u0004\u0018\u0001`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/vector/receiver/ScreenOnOffReceiver;", "Lcom/vector/receiver/BaseReceiver;", "()V", "filter", "Landroid/content/IntentFilter;", "getFilter", "()Landroid/content/IntentFilter;", "onScreenOnOff", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", q0.f15781d, "", "Lcom/vector/receiver/OnScreenOnOff;", "observe", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "onReceive", "context", "Landroid/content/Context;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ScreenOnOffReceiver extends BaseReceiver {
    @e
    private l<? super Boolean, t1> b;

    @Override // com.vector.receiver.BaseReceiver
    @d
    public IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        return intentFilter;
    }

    public final void g(@d LifecycleOwner lifecycleOwner, @d l<? super Boolean, t1> lVar) {
        e(lifecycleOwner);
        this.b = lVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@e Context context, @e Intent intent) {
        if (intent == null || b()) {
            return;
        }
        if (f0.g(intent.getAction(), "android.intent.action.SCREEN_ON")) {
            l<? super Boolean, t1> lVar = this.b;
            if (lVar == null) {
                return;
            }
            lVar.invoke(Boolean.TRUE);
            return;
        }
        l<? super Boolean, t1> lVar2 = this.b;
        if (lVar2 == null) {
            return;
        }
        lVar2.invoke(Boolean.FALSE);
    }
}
