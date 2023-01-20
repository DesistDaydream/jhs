package e.t.k.a.c.h;

import androidx.fragment.app.Fragment;
import h.a2.y;
import h.k2.u.l;
import h.k2.v.u;
import java.util.ArrayList;
import java.util.List;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0002'(B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020&RA\u0010\u0003\u001a)\u0012#\u0012!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R=\u0010\u0016\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00068F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000f¨\u0006)"}, d2 = {"Lcom/vector/design/ui/adapter/pager/Pager;", "", "()V", "multi", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "Landroidx/fragment/app/Fragment;", "Lcom/vector/design/ui/adapter/pager/Constructor;", "getMulti", "()Ljava/util/List;", "setMulti", "(Ljava/util/List;)V", "requiredCurrentItem", "getRequiredCurrentItem", "()Ljava/lang/Integer;", "setRequiredCurrentItem", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "single", "getSingle", "()Lkotlin/jvm/functions/Function1;", "setSingle", "(Lkotlin/jvm/functions/Function1;)V", "<set-?>", "size", "getSize", "()I", "titles", "", "", "getTitles", "setTitles", "createFragment", "newBuilder", "Lcom/vector/design/ui/adapter/pager/Pager$Builder;", "Builder", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final b f14558f = new b(null);
    private int a;
    @e
    private List<l<Integer, Fragment>> b;
    @e

    /* renamed from: c  reason: collision with root package name */
    private l<? super Integer, ? extends Fragment> f14559c;
    @e

    /* renamed from: d  reason: collision with root package name */
    private List<String> f14560d;
    @e

    /* renamed from: e  reason: collision with root package name */
    private Integer f14561e;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J]\u0010\u0003\u001a\u00020\u00002P\u0010\u0015\u001a)\u0012%\b\u0001\u0012!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b0\u0016\"!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b¢\u0006\u0002\u0010\u0017J5\u0010\u0003\u001a\u00020\u00002-\u0010\u0015\u001a)\u0012#\u0012!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b\u0018\u00010\u0011J\u0015\u0010\f\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0019J1\u0010\u000e\u001a\u00020\u00002)\u0010\u0015\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006J\u0016\u0010\u0010\u001a\u00020\u00002\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011R5\u0010\u0003\u001a)\u0012#\u0012!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR1\u0010\u000e\u001a%\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/vector/design/ui/adapter/pager/Pager$Builder;", "", "()V", "multi", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "Landroidx/fragment/app/Fragment;", "Lcom/vector/design/ui/adapter/pager/Constructor;", "requiredCurrentItem", "Ljava/lang/Integer;", "single", "size", "titles", "", "", "build", "Lcom/vector/design/ui/adapter/pager/Pager;", "value", "", "([Lkotlin/jvm/functions/Function1;)Lcom/vector/design/ui/adapter/pager/Pager$Builder;", "currentItem", "(Ljava/lang/Integer;)Lcom/vector/design/ui/adapter/pager/Pager$Builder;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private int a;
        @e
        private List<l<Integer, Fragment>> b;
        @e

        /* renamed from: c  reason: collision with root package name */
        private l<? super Integer, ? extends Fragment> f14562c;
        @e

        /* renamed from: d  reason: collision with root package name */
        private List<String> f14563d;
        @e

        /* renamed from: e  reason: collision with root package name */
        private Integer f14564e;

        @k.e.a.d
        public final c a() {
            c cVar = new c(null);
            cVar.a = this.a;
            cVar.i(this.b);
            cVar.k(this.f14562c);
            cVar.l(this.f14563d);
            cVar.j(this.f14564e);
            return cVar;
        }

        @k.e.a.d
        public final a b(@e List<? extends l<? super Integer, ? extends Fragment>> list) {
            this.b = list == null ? null : CollectionsKt___CollectionsKt.L5(list);
            return this;
        }

        @k.e.a.d
        public final a c(@k.e.a.d l<? super Integer, ? extends Fragment>... lVarArr) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            List<l<Integer, Fragment>> list = this.b;
            if (list != null) {
                y.s0(list, lVarArr);
            }
            return this;
        }

        @k.e.a.d
        public final a d(@e Integer num) {
            this.f14564e = num;
            return this;
        }

        @k.e.a.d
        public final a e(@e l<? super Integer, ? extends Fragment> lVar) {
            this.f14562c = lVar;
            return this;
        }

        @k.e.a.d
        public final a f(int i2) {
            this.a = i2;
            return this;
        }

        @k.e.a.d
        public final a g(@e List<String> list) {
            this.f14563d = list;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/vector/design/ui/adapter/pager/Pager$Companion;", "", "()V", "newBuilder", "Lcom/vector/design/ui/adapter/pager/Pager$Builder;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @k.e.a.d
        public final a a() {
            return new a();
        }
    }

    private c() {
    }

    public /* synthetic */ c(u uVar) {
        this();
    }

    @e
    public final Fragment b(int i2) {
        l<? super Integer, ? extends Fragment> lVar = this.f14559c;
        if (lVar == null) {
            List<l<Integer, Fragment>> list = this.b;
            lVar = list == null ? null : (l) CollectionsKt___CollectionsKt.J2(list, i2);
        }
        if (lVar == null) {
            return null;
        }
        return lVar.invoke(Integer.valueOf(i2));
    }

    @e
    public final List<l<Integer, Fragment>> c() {
        return this.b;
    }

    @e
    public final Integer d() {
        return this.f14561e;
    }

    @e
    public final l<Integer, Fragment> e() {
        return this.f14559c;
    }

    public final int f() {
        if (this.f14559c == null) {
            List<l<Integer, Fragment>> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return this.a;
    }

    @e
    public final List<String> g() {
        return this.f14560d;
    }

    @k.e.a.d
    public final a h() {
        return new a().b(this.b).f(f()).e(this.f14559c).g(this.f14560d).d(this.f14561e);
    }

    public final void i(@e List<l<Integer, Fragment>> list) {
        this.b = list;
    }

    public final void j(@e Integer num) {
        this.f14561e = num;
    }

    public final void k(@e l<? super Integer, ? extends Fragment> lVar) {
        this.f14559c = lVar;
    }

    public final void l(@e List<String> list) {
        this.f14560d = list;
    }
}
