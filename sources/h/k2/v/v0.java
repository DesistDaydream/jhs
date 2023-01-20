package h.k2.v;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.KVariance;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\b\u0010\u001e\u001a\u00020\u0005H\u0016R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lkotlin/jvm/internal/TypeParameterReference;", "Lkotlin/reflect/KTypeParameter;", "container", "", "name", "", "variance", "Lkotlin/reflect/KVariance;", "isReified", "", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "bounds", "", "Lkotlin/reflect/KType;", "()Z", "getName", "()Ljava/lang/String;", "upperBounds", "getUpperBounds$annotations", "()V", "getUpperBounds", "()Ljava/util/List;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", TTDownloadField.TT_HASHCODE, "", "setUpperBounds", "", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@h.s0(version = "1.4")
/* loaded from: classes3.dex */
public final class v0 implements h.p2.s {
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final a f14940f = new a(null);
    private volatile List<? extends h.p2.r> a;
    private final Object b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final String f14941c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final KVariance f14942d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f14943e;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/jvm/internal/TypeParameterReference$Companion;", "", "()V", "toString", "", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        @k.e.a.d
        public final String a(@k.e.a.d h.p2.s sVar) {
            StringBuilder sb = new StringBuilder();
            int i2 = u0.a[sVar.o().ordinal()];
            if (i2 == 2) {
                sb.append("in ");
            } else if (i2 == 3) {
                sb.append("out ");
            }
            sb.append(sVar.getName());
            return sb.toString();
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public v0(@k.e.a.e Object obj, @k.e.a.d String str, @k.e.a.d KVariance kVariance, boolean z) {
        this.b = obj;
        this.f14941c = str;
        this.f14942d = kVariance;
        this.f14943e = z;
    }

    public static /* synthetic */ void a() {
    }

    public final void b(@k.e.a.d List<? extends h.p2.r> list) {
        if (this.a == null) {
            this.a = list;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (obj instanceof v0) {
            v0 v0Var = (v0) obj;
            if (f0.g(this.b, v0Var.b) && f0.g(getName(), v0Var.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // h.p2.s
    @k.e.a.d
    public String getName() {
        return this.f14941c;
    }

    @Override // h.p2.s
    @k.e.a.d
    public List<h.p2.r> getUpperBounds() {
        List list = this.a;
        if (list != null) {
            return list;
        }
        List<h.p2.r> k2 = h.a2.t.k(n0.l(Object.class));
        this.a = k2;
        return k2;
    }

    public int hashCode() {
        Object obj = this.b;
        return ((obj != null ? obj.hashCode() : 0) * 31) + getName().hashCode();
    }

    @Override // h.p2.s
    public boolean l() {
        return this.f14943e;
    }

    @Override // h.p2.s
    @k.e.a.d
    public KVariance o() {
        return this.f14942d;
    }

    @k.e.a.d
    public String toString() {
        return f14940f.a(this);
    }
}
