package kotlinx.coroutines.flow;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.am;
import h.a2.t;
import i.b.v3.h;
import i.b.v3.u;
import i.b.v3.x;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Li/b/v3/u;", "Li/b/v3/x;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", am.av, "(Li/b/v3/x;)Lkotlinx/coroutines/flow/Flow;", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "()I", "", "c", "J", "replayExpiration", "b", "stopTimeout", "<init>", "(JJ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class StartedWhileSubscribed implements u {
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f16968c;

    public StartedWhileSubscribed(long j2, long j3) {
        this.b = j2;
        this.f16968c = j3;
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("stopTimeout(" + j2 + " ms) cannot be negative").toString());
        }
        if (j3 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j3 + " ms) cannot be negative").toString());
    }

    @Override // i.b.v3.u
    @d
    public Flow<SharingCommand> a(@d x<Integer> xVar) {
        return h.l0(h.p0(h.m2(xVar, new StartedWhileSubscribed$command$1(this, null)), new StartedWhileSubscribed$command$2(null)));
    }

    public boolean equals(@e Object obj) {
        if (obj instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
            if (this.b == startedWhileSubscribed.b && this.f16968c == startedWhileSubscribed.f16968c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (Long.valueOf(this.b).hashCode() * 31) + Long.valueOf(this.f16968c).hashCode();
    }

    @d
    public String toString() {
        List j2 = t.j(2);
        if (this.b > 0) {
            j2.add("stopTimeout=" + this.b + "ms");
        }
        if (this.f16968c < Long.MAX_VALUE) {
            j2.add("replayExpiration=" + this.f16968c + "ms");
        }
        List a = t.a(j2);
        return "SharingStarted.WhileSubscribed(" + CollectionsKt___CollectionsKt.Z2(a, null, null, null, 0, null, null, 63, null) + ')';
    }
}
