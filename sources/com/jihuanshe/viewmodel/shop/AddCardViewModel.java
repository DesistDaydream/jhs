package com.jihuanshe.viewmodel.shop;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.model.Category;
import com.jihuanshe.model.Game;
import e.l.h.l.b;
import h.k2.v.u;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class AddCardViewModel extends b {
    @d

    /* renamed from: d  reason: collision with root package name */
    public static final a f4531d = new a(null);
    @d

    /* renamed from: e  reason: collision with root package name */
    private static final String f4532e = "AddCardViewModel";
    @d
    private final NLive<List<Category>> b = new NLive<>(null, 1, null);
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<List<Object>> f4533c = new NLive<>(null, 1, null);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @d
    public final e.g.d.a<?> q0(@d Game game) {
        return e.g.d.a.h(e.g.d.a.o(e.g.d.a.j(FlowKt.b(e.l.o.a.a.a.a.b(game), this.b, true), null, new AddCardViewModel$getCategory$1(this), 1, null), null, AddCardViewModel$getCategory$2.INSTANCE, 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<Category>> r0() {
        return this.b;
    }

    @d
    public final NLive<List<Object>> s0() {
        return this.f4533c;
    }
}
