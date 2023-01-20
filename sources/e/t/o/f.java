package e.t.o;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import androidx.collection.ArrayMap;
import com.vector.config.FitConfig;
import com.vector.fitter.ActivityLifecycleCallbackImpl;
import com.vector.fitter.Mode;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/vector/fitter/Fitter;", "", "()V", "appMetrics", "Lcom/vector/fitter/Fitter$Metrics;", "appResources", "Landroid/content/res/Resources;", "getAppResources", "()Landroid/content/res/Resources;", "setAppResources", "(Landroid/content/res/Resources;)V", "callback", "Lcom/vector/fitter/ActivityLifecycleCallbackImpl;", "metricsCache", "Landroidx/collection/ArrayMap;", "Lcom/vector/fitter/Mode;", "fit", "", "context", "Landroid/content/Context;", "mode", "res", "displayMetrics", "Landroid/util/DisplayMetrics;", "getMetrics", MiPushClient.COMMAND_REGISTER, "application", "Landroid/app/Application;", "Metrics", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: c  reason: collision with root package name */
    public static Resources f14601c;
    @k.e.a.e

    /* renamed from: e  reason: collision with root package name */
    private static ActivityLifecycleCallbackImpl f14603e;
    @k.e.a.d
    public static final f a = new f();
    @k.e.a.d
    private static final a b = new a();
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final ArrayMap<Mode, a> f14602d = new ArrayMap<>();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/vector/fitter/Fitter$Metrics;", "", "()V", "density", "", "getDensity", "()F", "setDensity", "(F)V", "densityDpi", "", "getDensityDpi", "()I", "setDensityDpi", "(I)V", "scaledDensity", "getScaledDensity", "setScaledDensity", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private float a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private float f14604c;

        public final float a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final float c() {
            return this.f14604c;
        }

        public final void d(float f2) {
            this.a = f2;
        }

        public final void e(int i2) {
            this.b = i2;
        }

        public final void f(float f2) {
            this.f14604c = f2;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Mode.values().length];
            iArr[Mode.WIDTH.ordinal()] = 1;
            iArr[Mode.HEIGHT.ordinal()] = 2;
            iArr[Mode.FULL_SCREEN.ordinal()] = 3;
            iArr[Mode.DEFAULT.ordinal()] = 4;
            a = iArr;
        }
    }

    private f() {
    }

    public static /* synthetic */ void d(f fVar, Context context, Mode mode, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            mode = FitConfig.a.a();
        }
        fVar.a(context, mode);
    }

    public final void a(@k.e.a.d Context context, @k.e.a.d Mode mode) {
        c(context.getResources().getDisplayMetrics(), mode);
    }

    public final void b(@k.e.a.d Resources resources, @k.e.a.d Mode mode) {
        c(resources.getDisplayMetrics(), mode);
    }

    public final void c(@k.e.a.d DisplayMetrics displayMetrics, @k.e.a.d Mode mode) {
        a f2 = f(mode);
        displayMetrics.density = f2.a();
        displayMetrics.densityDpi = f2.b();
        displayMetrics.scaledDensity = f2.c();
    }

    @k.e.a.d
    public final Resources e() {
        Resources resources = f14601c;
        Objects.requireNonNull(resources);
        return resources;
    }

    @k.e.a.d
    public final a f(@k.e.a.d Mode mode) {
        float e2;
        float f2;
        float f3;
        ArrayMap<Mode, a> arrayMap = f14602d;
        a aVar = arrayMap.get(mode);
        if (aVar != null) {
            return aVar;
        }
        int i2 = b.a[mode.ordinal()];
        if (i2 == 1) {
            e2 = e.t.q.b.a.e();
            f2 = FitConfig.a.f();
        } else if (i2 == 2) {
            e2 = e.t.q.b.a.b();
            f2 = FitConfig.a.c();
        } else {
            if (i2 == 3) {
                e.t.q.b bVar = e.t.q.b.a;
                FitConfig fitConfig = FitConfig.a;
                float e3 = bVar.e() / fitConfig.f();
                f3 = bVar.b() / fitConfig.c();
                if (e3 < f3) {
                    f3 = e3;
                }
            } else if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                f3 = b.a();
            }
            a aVar2 = b;
            a aVar3 = new a();
            aVar3.d(f3);
            aVar3.e((int) (160 * f3));
            aVar3.f((aVar2.c() / aVar2.a()) * f3);
            arrayMap.put(mode, aVar3);
            return aVar3;
        }
        f3 = e2 / f2;
        a aVar22 = b;
        a aVar32 = new a();
        aVar32.d(f3);
        aVar32.e((int) (160 * f3));
        aVar32.f((aVar22.c() / aVar22.a()) * f3);
        arrayMap.put(mode, aVar32);
        return aVar32;
    }

    public final void g(@k.e.a.d Application application) {
        h(application.getResources());
    }

    public final void h(@k.e.a.d Resources resources) {
        f14601c = resources;
    }
}
