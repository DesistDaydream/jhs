package com.jihuanshe.viewmodel.photo;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.RecentPhoto;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.k;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class RecentPhotoViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final e.n.f<List<RecentPhoto>> f4503c = new e.n.f<>(null, 1, null);

    public static /* synthetic */ a s0(RecentPhotoViewModel recentPhotoViewModel, String str, Integer num, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            state = null;
        }
        return recentPhotoViewModel.r0(str, num, state);
    }

    @d
    public final e.n.f<List<RecentPhoto>> q0() {
        return this.f4503c;
    }

    @d
    public final a<e<RecentPhoto>> r0(@k.e.a.e String str, @k.e.a.e Integer num, @k.e.a.e LoadMore.State state) {
        return a.h(a.o(BinderKt.b(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).j0(str, num, this.b.a(state).d())), this.f4503c, this.b.f()), null, new RecentPhotoViewModel$getRecentData$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
