package com.eth.model;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.mobads.sdk.internal.bp;
import com.qiniu.android.collect.ReportItem;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.umeng.analytics.pro.d;
import e.g.e.a;
import e.n.f;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0014B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J&\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u000eJ5\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\n0\u000eJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/eth/model/NLive;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/live/Live;", "default", "(Ljava/lang/Object;)V", d.O, "Lcom/eth/model/Error;", "state", "Lcom/eth/model/NLive$State;", "onError", "", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "onState", "Lkotlin/ParameterName;", "name", "setError", "setState", "State", "eth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public class NLive<T> extends f<T> {
    @k.e.a.d
    private final f<State> b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final f<a> f2571c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/eth/model/NLive$State;", "", "(Ljava/lang/String;I)V", "LOADING", bp.f1533l, "SUCCESS", "CANCEL", "eth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public enum State {
        LOADING,
        ERROR,
        SUCCESS,
        CANCEL
    }

    public NLive() {
        this(null, 1, null);
    }

    public NLive(@e T t) {
        super(t);
        this.b = new f<>(null, 1, null);
        this.f2571c = new f<>(null, 1, null);
    }

    public static /* synthetic */ void t(NLive nLive, LifecycleOwner lifecycleOwner, l lVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onError");
        }
        if ((i2 & 1) != 0) {
            lifecycleOwner = null;
        }
        nLive.s(lifecycleOwner, lVar);
    }

    public static /* synthetic */ void v(NLive nLive, LifecycleOwner lifecycleOwner, l lVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onState");
        }
        if ((i2 & 1) != 0) {
            lifecycleOwner = null;
        }
        nLive.u(lifecycleOwner, lVar);
    }

    public final void s(@e LifecycleOwner lifecycleOwner, @k.e.a.d l<? super a, t1> lVar) {
        this.f2571c.f(lifecycleOwner, lVar);
    }

    public final void u(@e LifecycleOwner lifecycleOwner, @k.e.a.d l<? super State, t1> lVar) {
        this.b.f(lifecycleOwner, lVar);
    }

    public final void w(@k.e.a.d a aVar) {
        this.f2571c.setValue(aVar);
    }

    public final void x(@k.e.a.d State state) {
        this.b.setValue(state);
    }

    public /* synthetic */ NLive(Object obj, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : obj);
    }
}
