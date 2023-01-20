package e.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.SingleRequest;
import e.b.a.t.k.m;
import e.b.a.t.k.p;
import e.b.a.t.k.r;
import e.b.a.v.l;
import e.b.a.v.n;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class i<TranscodeType> extends e.b.a.t.a<i<TranscodeType>> implements Cloneable, h<i<TranscodeType>> {
    public static final e.b.a.t.h j0 = new e.b.a.t.h().t(e.b.a.p.k.h.f9533c).A0(Priority.LOW).I0(true);
    private final Context V;
    private final j W;
    private final Class<TranscodeType> X;
    private final c Y;
    private final e Z;
    @NonNull
    private k<?, ? super TranscodeType> a0;
    @Nullable
    private Object b0;
    @Nullable
    private List<e.b.a.t.g<TranscodeType>> c0;
    @Nullable
    private i<TranscodeType> d0;
    @Nullable
    private i<TranscodeType> e0;
    @Nullable
    private Float f0;
    private boolean g0;
    private boolean h0;
    private boolean i0;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Priority.values().length];
            b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @SuppressLint({"CheckResult"})
    public i(@NonNull c cVar, j jVar, Class<TranscodeType> cls, Context context) {
        this.g0 = true;
        this.Y = cVar;
        this.W = jVar;
        this.X = cls;
        this.V = context;
        this.a0 = jVar.w(cls);
        this.Z = cVar.j();
        h1(jVar.u());
        l(jVar.v());
    }

    private e.b.a.t.e W0(p<TranscodeType> pVar, @Nullable e.b.a.t.g<TranscodeType> gVar, e.b.a.t.a<?> aVar, Executor executor) {
        return X0(new Object(), pVar, gVar, null, this.a0, aVar.R(), aVar.O(), aVar.N(), aVar, executor);
    }

    private e.b.a.t.e X0(Object obj, p<TranscodeType> pVar, @Nullable e.b.a.t.g<TranscodeType> gVar, @Nullable RequestCoordinator requestCoordinator, k<?, ? super TranscodeType> kVar, Priority priority, int i2, int i3, e.b.a.t.a<?> aVar, Executor executor) {
        e.b.a.t.b bVar;
        e.b.a.t.b bVar2;
        if (this.e0 != null) {
            bVar2 = new e.b.a.t.b(obj, requestCoordinator);
            bVar = bVar2;
        } else {
            bVar = null;
            bVar2 = requestCoordinator;
        }
        e.b.a.t.e Y0 = Y0(obj, pVar, gVar, bVar2, kVar, priority, i2, i3, aVar, executor);
        if (bVar == null) {
            return Y0;
        }
        int O = this.e0.O();
        int N = this.e0.N();
        if (n.w(i2, i3) && !this.e0.l0()) {
            O = aVar.O();
            N = aVar.N();
        }
        i<TranscodeType> iVar = this.e0;
        e.b.a.t.b bVar3 = bVar;
        bVar3.n(Y0, iVar.X0(obj, pVar, gVar, bVar3, iVar.a0, iVar.R(), O, N, this.e0, executor));
        return bVar3;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [e.b.a.t.a] */
    private e.b.a.t.e Y0(Object obj, p<TranscodeType> pVar, e.b.a.t.g<TranscodeType> gVar, @Nullable RequestCoordinator requestCoordinator, k<?, ? super TranscodeType> kVar, Priority priority, int i2, int i3, e.b.a.t.a<?> aVar, Executor executor) {
        Priority g1;
        i<TranscodeType> iVar = this.d0;
        if (iVar != null) {
            if (!this.i0) {
                k<?, ? super TranscodeType> kVar2 = iVar.g0 ? kVar : iVar.a0;
                if (iVar.d0()) {
                    g1 = this.d0.R();
                } else {
                    g1 = g1(priority);
                }
                Priority priority2 = g1;
                int O = this.d0.O();
                int N = this.d0.N();
                if (n.w(i2, i3) && !this.d0.l0()) {
                    O = aVar.O();
                    N = aVar.N();
                }
                e.b.a.t.j jVar = new e.b.a.t.j(obj, requestCoordinator);
                e.b.a.t.e z1 = z1(obj, pVar, gVar, aVar, jVar, kVar, priority, i2, i3, executor);
                this.i0 = true;
                i<TranscodeType> iVar2 = this.d0;
                e.b.a.t.e X0 = iVar2.X0(obj, pVar, gVar, jVar, kVar2, priority2, O, N, iVar2, executor);
                this.i0 = false;
                jVar.m(z1, X0);
                return jVar;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.f0 != null) {
            e.b.a.t.j jVar2 = new e.b.a.t.j(obj, requestCoordinator);
            jVar2.m(z1(obj, pVar, gVar, aVar, jVar2, kVar, priority, i2, i3, executor), z1(obj, pVar, gVar, aVar.clone().H0(this.f0.floatValue()), jVar2, kVar, g1(priority), i2, i3, executor));
            return jVar2;
        } else {
            return z1(obj, pVar, gVar, aVar, requestCoordinator, kVar, priority, i2, i3, executor);
        }
    }

    private i<TranscodeType> a1() {
        return q().d1(null).F1(null);
    }

    @NonNull
    private Priority g1(@NonNull Priority priority) {
        int i2 = a.b[priority.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3 && i2 != 4) {
                    throw new IllegalArgumentException("unknown priority: " + R());
                }
                return Priority.IMMEDIATE;
            }
            return Priority.HIGH;
        }
        return Priority.NORMAL;
    }

    @SuppressLint({"CheckResult"})
    private void h1(List<e.b.a.t.g<Object>> list) {
        for (e.b.a.t.g<Object> gVar : list) {
            U0(gVar);
        }
    }

    private <Y extends p<TranscodeType>> Y k1(@NonNull Y y, @Nullable e.b.a.t.g<TranscodeType> gVar, e.b.a.t.a<?> aVar, Executor executor) {
        l.d(y);
        if (this.h0) {
            e.b.a.t.e W0 = W0(y, gVar, aVar, executor);
            e.b.a.t.e request = y.getRequest();
            if (W0.h(request) && !n1(aVar, request)) {
                if (!((e.b.a.t.e) l.d(request)).isRunning()) {
                    request.d();
                }
                return y;
            }
            this.W.r(y);
            y.setRequest(W0);
            this.W.Q(y, W0);
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean n1(e.b.a.t.a<?> aVar, e.b.a.t.e eVar) {
        return !aVar.c0() && eVar.isComplete();
    }

    @NonNull
    private i<TranscodeType> y1(@Nullable Object obj) {
        if (Z()) {
            return q().y1(obj);
        }
        this.b0 = obj;
        this.h0 = true;
        return E0();
    }

    private e.b.a.t.e z1(Object obj, p<TranscodeType> pVar, e.b.a.t.g<TranscodeType> gVar, e.b.a.t.a<?> aVar, RequestCoordinator requestCoordinator, k<?, ? super TranscodeType> kVar, Priority priority, int i2, int i3, Executor executor) {
        Context context = this.V;
        e eVar = this.Z;
        return SingleRequest.w(context, eVar, obj, this.b0, this.X, aVar, i2, i3, priority, pVar, gVar, this.c0, requestCoordinator, eVar.f(), kVar.c(), executor);
    }

    @NonNull
    public p<TranscodeType> A1() {
        return B1(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public p<TranscodeType> B1(int i2, int i3) {
        return j1(m.b(this.W, i2, i3));
    }

    @NonNull
    public e.b.a.t.d<TranscodeType> C1() {
        return D1(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @NonNull
    public e.b.a.t.d<TranscodeType> D1(int i2, int i3) {
        e.b.a.t.f fVar = new e.b.a.t.f(i2, i3);
        return (e.b.a.t.d) l1(fVar, fVar, e.b.a.v.f.a());
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> E1(float f2) {
        if (Z()) {
            return q().E1(f2);
        }
        if (f2 >= 0.0f && f2 <= 1.0f) {
            this.f0 = Float.valueOf(f2);
            return E0();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> F1(@Nullable i<TranscodeType> iVar) {
        if (Z()) {
            return q().F1(iVar);
        }
        this.d0 = iVar;
        return E0();
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> G1(@Nullable List<i<TranscodeType>> list) {
        i<TranscodeType> iVar = null;
        if (list != null && !list.isEmpty()) {
            for (int size = list.size() - 1; size >= 0; size--) {
                i<TranscodeType> iVar2 = list.get(size);
                if (iVar2 != null) {
                    iVar = iVar == null ? iVar2 : iVar2.F1(iVar);
                }
            }
            return F1(iVar);
        }
        return F1(null);
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> H1(@Nullable i<TranscodeType>... iVarArr) {
        if (iVarArr != null && iVarArr.length != 0) {
            return G1(Arrays.asList(iVarArr));
        }
        return F1(null);
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> I1(@NonNull k<?, ? super TranscodeType> kVar) {
        if (Z()) {
            return q().I1(kVar);
        }
        this.a0 = (k) l.d(kVar);
        this.g0 = false;
        return E0();
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> U0(@Nullable e.b.a.t.g<TranscodeType> gVar) {
        if (Z()) {
            return q().U0(gVar);
        }
        if (gVar != null) {
            if (this.c0 == null) {
                this.c0 = new ArrayList();
            }
            this.c0.add(gVar);
        }
        return E0();
    }

    @Override // e.b.a.t.a
    @NonNull
    @CheckResult
    /* renamed from: V0 */
    public i<TranscodeType> l(@NonNull e.b.a.t.a<?> aVar) {
        l.d(aVar);
        return (i) super.l(aVar);
    }

    @Override // e.b.a.t.a
    @CheckResult
    /* renamed from: Z0 */
    public i<TranscodeType> q() {
        i<TranscodeType> iVar = (i) super.clone();
        iVar.a0 = (k<?, ? super TranscodeType>) iVar.a0.clone();
        if (iVar.c0 != null) {
            iVar.c0 = new ArrayList(iVar.c0);
        }
        i<TranscodeType> iVar2 = iVar.d0;
        if (iVar2 != null) {
            iVar.d0 = iVar2.q();
        }
        i<TranscodeType> iVar3 = iVar.e0;
        if (iVar3 != null) {
            iVar.e0 = iVar3.q();
        }
        return iVar;
    }

    @CheckResult
    @Deprecated
    public e.b.a.t.d<File> b1(int i2, int i3) {
        return f1().D1(i2, i3);
    }

    @CheckResult
    @Deprecated
    public <Y extends p<File>> Y c1(@NonNull Y y) {
        return (Y) f1().j1(y);
    }

    @NonNull
    public i<TranscodeType> d1(@Nullable i<TranscodeType> iVar) {
        if (Z()) {
            return q().d1(iVar);
        }
        this.e0 = iVar;
        return E0();
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> e1(Object obj) {
        if (obj == null) {
            return d1(null);
        }
        return d1(a1().h(obj));
    }

    @NonNull
    @CheckResult
    public i<File> f1() {
        return new i(File.class, this).l(j0);
    }

    @Deprecated
    public e.b.a.t.d<TranscodeType> i1(int i2, int i3) {
        return D1(i2, i3);
    }

    @NonNull
    public <Y extends p<TranscodeType>> Y j1(@NonNull Y y) {
        return (Y) l1(y, null, e.b.a.v.f.b());
    }

    @NonNull
    public <Y extends p<TranscodeType>> Y l1(@NonNull Y y, @Nullable e.b.a.t.g<TranscodeType> gVar, Executor executor) {
        return (Y) k1(y, gVar, this, executor);
    }

    @NonNull
    public r<ImageView, TranscodeType> m1(@NonNull ImageView imageView) {
        i<TranscodeType> iVar;
        n.b();
        l.d(imageView);
        if (!k0() && i0() && imageView.getScaleType() != null) {
            switch (a.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    iVar = clone().o0();
                    break;
                case 2:
                    iVar = clone().p0();
                    break;
                case 3:
                case 4:
                case 5:
                    iVar = clone().r0();
                    break;
                case 6:
                    iVar = clone().p0();
                    break;
            }
            return (r) k1(this.Z.a(imageView, this.X), null, iVar, e.b.a.v.f.b());
        }
        iVar = this;
        return (r) k1(this.Z.a(imageView, this.X), null, iVar, e.b.a.v.f.b());
    }

    @NonNull
    @CheckResult
    public i<TranscodeType> o1(@Nullable e.b.a.t.g<TranscodeType> gVar) {
        if (Z()) {
            return q().o1(gVar);
        }
        this.c0 = null;
        return U0(gVar);
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: p1 */
    public i<TranscodeType> g(@Nullable Bitmap bitmap) {
        return y1(bitmap).l(e.b.a.t.h.Z0(e.b.a.p.k.h.b));
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: q1 */
    public i<TranscodeType> f(@Nullable Drawable drawable) {
        return y1(drawable).l(e.b.a.t.h.Z0(e.b.a.p.k.h.b));
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: r1 */
    public i<TranscodeType> b(@Nullable Uri uri) {
        return y1(uri);
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: s1 */
    public i<TranscodeType> e(@Nullable File file) {
        return y1(file);
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: t1 */
    public i<TranscodeType> j(@Nullable @DrawableRes @RawRes Integer num) {
        return y1(num).l(e.b.a.t.h.q1(e.b.a.u.a.a(this.V)));
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: u1 */
    public i<TranscodeType> h(@Nullable Object obj) {
        return y1(obj);
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: v1 */
    public i<TranscodeType> k(@Nullable String str) {
        return y1(str);
    }

    @Override // e.b.a.h
    @CheckResult
    @Deprecated
    /* renamed from: w1 */
    public i<TranscodeType> a(@Nullable URL url) {
        return y1(url);
    }

    @Override // e.b.a.h
    @NonNull
    @CheckResult
    /* renamed from: x1 */
    public i<TranscodeType> c(@Nullable byte[] bArr) {
        i<TranscodeType> y1 = y1(bArr);
        if (!y1.a0()) {
            y1 = y1.l(e.b.a.t.h.Z0(e.b.a.p.k.h.b));
        }
        return !y1.h0() ? y1.l(e.b.a.t.h.s1(true)) : y1;
    }

    @SuppressLint({"CheckResult"})
    public i(Class<TranscodeType> cls, i<?> iVar) {
        this(iVar.Y, iVar.W, cls, iVar.V);
        this.b0 = iVar.b0;
        this.h0 = iVar.h0;
        l(iVar);
    }
}
