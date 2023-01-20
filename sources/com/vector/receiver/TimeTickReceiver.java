package com.vector.receiver;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.lifecycle.LifecycleOwner;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.qiniu.android.collect.ReportItem;
import com.tencent.qcloud.tuicore.TUIConstants;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J5\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162%\u0010\u0017\u001a!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\fj\u0002`\u0011J\u001c\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR1\u0010\u000b\u001a%\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fj\u0004\u0018\u0001`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/vector/receiver/TimeTickReceiver;", "Lcom/vector/receiver/BaseReceiver;", "unit", "Lcom/vector/receiver/TimeTickUnit;", "count", "", "(Lcom/vector/receiver/TimeTickUnit;J)V", "filter", "Landroid/content/IntentFilter;", "getFilter", "()Landroid/content/IntentFilter;", "onTimeTick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "currentTimeMillis", "", "Lcom/vector/receiver/OnTimeTick;", "realCount", "", "observe", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", ReportItem.LogTypeBlock, "onReceive", "context", "Landroid/content/Context;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class TimeTickReceiver extends BaseReceiver {
    @d
    private final TimeTickUnit b;

    /* renamed from: c  reason: collision with root package name */
    private final long f7864c;
    @e

    /* renamed from: d  reason: collision with root package name */
    private l<? super Long, t1> f7865d;

    /* renamed from: e  reason: collision with root package name */
    private int f7866e;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TimeTickUnit.values().length];
            iArr[TimeTickUnit.MINUTE.ordinal()] = 1;
            iArr[TimeTickUnit.HOURS.ordinal()] = 2;
            a = iArr;
        }
    }

    public TimeTickReceiver(@d TimeTickUnit timeTickUnit, long j2) {
        this.b = timeTickUnit;
        this.f7864c = j2;
    }

    @Override // com.vector.receiver.BaseReceiver
    @d
    public IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.TIME_TICK");
        intentFilter.addAction("android.intent.action.TIME_SET");
        return intentFilter;
    }

    public final void g(@d LifecycleOwner lifecycleOwner, @d l<? super Long, t1> lVar) {
        e(lifecycleOwner);
        lVar.invoke(Long.valueOf(System.currentTimeMillis()));
        this.f7865d = lVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@e Context context, @e Intent intent) {
        if (b()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (f0.g(intent == null ? null : intent.getAction(), "android.intent.action.TIME_SET")) {
            l<? super Long, t1> lVar = this.f7865d;
            if (lVar != null) {
                lVar.invoke(Long.valueOf(currentTimeMillis));
            }
            this.f7866e = 0;
            return;
        }
        this.f7866e++;
        int i2 = a.a[this.b.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 && this.f7866e >= this.f7864c * 60) {
                l<? super Long, t1> lVar2 = this.f7865d;
                if (lVar2 != null) {
                    lVar2.invoke(Long.valueOf(currentTimeMillis));
                }
                this.f7866e = 0;
            }
        } else if (this.f7866e >= this.f7864c) {
            l<? super Long, t1> lVar3 = this.f7865d;
            if (lVar3 != null) {
                lVar3.invoke(Long.valueOf(currentTimeMillis));
            }
            this.f7866e = 0;
        }
    }
}
