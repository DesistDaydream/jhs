package e.t.i;

import android.content.Context;
import androidx.annotation.Dimension;
import com.vector.view.swipe.footer.BaseFooter;
import com.vector.view.swipe.header.BaseHeader;
import h.k2.k;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\"\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 ¨\u0006%"}, d2 = {"Lcom/vector/config/ListConfig;", "", "()V", "footerConstructor", "Lkotlin/Function1;", "Landroid/content/Context;", "Lcom/vector/view/swipe/footer/BaseFooter;", "getFooterConstructor", "()Lkotlin/jvm/functions/Function1;", "setFooterConstructor", "(Lkotlin/jvm/functions/Function1;)V", "forceClearMemoryCache", "", "getForceClearMemoryCache", "()Z", "setForceClearMemoryCache", "(Z)V", "headerConstructor", "Lcom/vector/view/swipe/header/BaseHeader;", "getHeaderConstructor", "setHeaderConstructor", "headerMax", "", "getHeaderMax", "()Ljava/lang/Integer;", "setHeaderMax", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "initOffset", "getInitOffset", "()I", "setInitOffset", "(I)V", "limit", "getLimit", "setLimit", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    @d

    /* renamed from: g  reason: collision with root package name */
    public static final a f14464g = new a(null);

    /* renamed from: h  reason: collision with root package name */
    public static final int f14465h = 1;

    /* renamed from: i  reason: collision with root package name */
    public static final int f14466i = 0;
    private int a;
    private int b = 1;
    @e

    /* renamed from: c  reason: collision with root package name */
    private l<? super Context, ? extends BaseHeader> f14467c;
    @e

    /* renamed from: d  reason: collision with root package name */
    private l<? super Context, ? extends BaseFooter> f14468d;
    @Dimension(unit = 0)
    @e

    /* renamed from: e  reason: collision with root package name */
    private Integer f14469e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14470f;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0006\u001a\u00020\u00072\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/vector/config/ListConfig$Companion;", "", "()V", "LIST_LIMIT", "", "LIST_OFFSET", "build", "Lcom/vector/config/ListConfig;", "init", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        @d
        public final b a(@d l<? super b, t1> lVar) {
            b bVar = new b();
            lVar.invoke(bVar);
            return bVar;
        }
    }

    @k
    @d
    public static final b a(@d l<? super b, t1> lVar) {
        return f14464g.a(lVar);
    }

    @e
    public final l<Context, BaseFooter> b() {
        return this.f14468d;
    }

    public final boolean c() {
        return this.f14470f;
    }

    @e
    public final l<Context, BaseHeader> d() {
        return this.f14467c;
    }

    @e
    public final Integer e() {
        return this.f14469e;
    }

    public final int f() {
        return this.a;
    }

    public final int g() {
        return this.b;
    }

    public final void h(@e l<? super Context, ? extends BaseFooter> lVar) {
        this.f14468d = lVar;
    }

    public final void i(boolean z) {
        this.f14470f = z;
    }

    public final void j(@e l<? super Context, ? extends BaseHeader> lVar) {
        this.f14467c = lVar;
    }

    public final void k(@e Integer num) {
        this.f14469e = num;
    }

    public final void l(int i2) {
        this.a = i2;
    }

    public final void m(int i2) {
        this.b = i2;
    }
}
