package e.l.h.i;

import com.vector.design.ui.delegate.LoadMore;
import h.k2.v.u;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/jihuanshe/base/model/Page;", "", "()V", "limit", "", "getLimit", "()I", "setLimit", "(I)V", "num", "getNum", "setNum", "change", "state", "Lcom/vector/design/ui/delegate/LoadMore$State;", "inc", "refresh", "", "reset", "rollback", "Companion", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class f {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final a f12129c = new a(null);

    /* renamed from: d  reason: collision with root package name */
    public static final int f12130d = 20;

    /* renamed from: e  reason: collision with root package name */
    public static final int f12131e = 1;
    private int a = 1;
    private int b = 20;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/jihuanshe/base/model/Page$Companion;", "", "()V", "LIMIT", "", "START", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public static /* synthetic */ f b(f fVar, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            state = null;
        }
        return fVar.a(state);
    }

    @k.e.a.d
    public final f a(@k.e.a.e LoadMore.State state) {
        if (state == null) {
            return g();
        }
        return e(state);
    }

    public final int c() {
        return this.b;
    }

    public final int d() {
        return this.a;
    }

    @k.e.a.d
    public final f e(@k.e.a.d LoadMore.State state) {
        if (state == LoadMore.State.CONTINUE) {
            this.a++;
        }
        return this;
    }

    public final boolean f() {
        return this.a == 1;
    }

    @k.e.a.d
    public final f g() {
        this.a = 1;
        return this;
    }

    @k.e.a.d
    public final f h() {
        int i2 = this.a;
        if (i2 != 1) {
            this.a = i2 - 1;
        }
        return this;
    }

    public final void i(int i2) {
        this.b = i2;
    }

    public final void j(int i2) {
        this.a = i2;
    }
}
