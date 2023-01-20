package com.eth.ext;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.qcloud.tuicore.TUIConstants;
import h.k2.u.l;
import h.t1;
import i.b.b2;
import i.b.g;
import i.b.n0;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001aF\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\f0\u000b\u001a4\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t\u001aH\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\u000f"}, d2 = {"launch", "Lkotlinx/coroutines/Job;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "context", "Lkotlin/coroutines/CoroutineContext;", MessageKey.MSG_ACCEPT_TIME_START, "Lkotlinx/coroutines/CoroutineStart;", "result", "Lkotlin/Function1;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "eth_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class CoroutineKt {
    @d
    public static final <T> b2 a(@d Flow<? extends T> flow, @d LifecycleOwner lifecycleOwner, @d CoroutineContext coroutineContext, @d CoroutineStart coroutineStart) {
        return c(flow, LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), coroutineContext, coroutineStart);
    }

    @d
    public static final <T> b2 b(@d Flow<? extends T> flow, @d LifecycleOwner lifecycleOwner, @d CoroutineContext coroutineContext, @d CoroutineStart coroutineStart, @d l<? super T, t1> lVar) {
        return d(flow, LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), coroutineContext, coroutineStart, lVar);
    }

    @d
    public static final <T> b2 c(@d Flow<? extends T> flow, @d n0 n0Var, @d CoroutineContext coroutineContext, @d CoroutineStart coroutineStart) {
        return g.e(n0Var, coroutineContext, coroutineStart, new CoroutineKt$launch$2(flow, null));
    }

    @d
    public static final <T> b2 d(@d Flow<? extends T> flow, @d n0 n0Var, @d CoroutineContext coroutineContext, @d CoroutineStart coroutineStart, @d l<? super T, t1> lVar) {
        return g.e(n0Var, coroutineContext, coroutineStart, new CoroutineKt$launch$1(flow, lVar, null));
    }

    public static /* synthetic */ b2 e(Flow flow, LifecycleOwner lifecycleOwner, CoroutineContext coroutineContext, CoroutineStart coroutineStart, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return a(flow, lifecycleOwner, coroutineContext, coroutineStart);
    }

    public static /* synthetic */ b2 f(Flow flow, LifecycleOwner lifecycleOwner, CoroutineContext coroutineContext, CoroutineStart coroutineStart, l lVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return b(flow, lifecycleOwner, coroutineContext, coroutineStart, lVar);
    }

    public static /* synthetic */ b2 g(Flow flow, n0 n0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            n0Var = i.b.t1.a;
        }
        if ((i2 & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return c(flow, n0Var, coroutineContext, coroutineStart);
    }

    public static /* synthetic */ b2 h(Flow flow, n0 n0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            n0Var = i.b.t1.a;
        }
        if ((i2 & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return d(flow, n0Var, coroutineContext, coroutineStart, lVar);
    }
}
