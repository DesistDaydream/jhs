package e.l.n;

import androidx.exifinterface.media.ExifInterface;
import com.jihuanshe.net.ServiceApiKt;
import com.jihuanshe.net.adapter.FlowCallAdapterFactory;
import com.jihuanshe.net.adapter.RawFlowCallAdapterFactory;
import e.l.n.g.e;
import e.l.r.c0;
import h.k2.v.f0;
import h.t1;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k.b.a.a.n.l;
import k.e.a.d;
import l.s;
import okhttp3.OkHttpClient;

/* loaded from: classes2.dex */
public final class a {
    public static final boolean a = false;
    public static final boolean b = false;

    /* renamed from: c */
    public static final boolean f14094c = true;

    /* renamed from: d */
    public static final boolean f14095d = true;
    @d

    /* renamed from: e */
    private static final Map<String, WeakReference<?>> f14096e = new LinkedHashMap();

    public static /* synthetic */ Object b(boolean z, boolean z2, boolean z3, long j2, boolean z4, int i2, Object obj) {
        boolean z5 = (i2 & 1) != 0 ? true : z;
        boolean z6 = (i2 & 2) != 0 ? false : z2;
        boolean z7 = (i2 & 4) == 0 ? z3 : false;
        if ((i2 & 8) != 0) {
            j2 = 60;
        }
        long j3 = j2;
        boolean z8 = (i2 & 16) != 0 ? true : z4;
        f0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        return d(Object.class, z5, z6, z7, j3, z8);
    }

    private static final <T> T c(Class<T> cls, String str, boolean z, boolean z2, boolean z3, boolean z4, long j2) {
        s.b c2 = new s.b().c(str);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(j2, timeUnit);
        builder.readTimeout(j2, timeUnit);
        builder.writeTimeout(j2, timeUnit);
        if (z4) {
            builder.addInterceptor(new e.l.n.g.d());
        }
        c0 c0Var = new c0();
        if (z2) {
            builder.addInterceptor(new e.l.n.g.b(c0Var));
        }
        if (z3) {
            builder.addInterceptor(new e.l.n.g.a(c0Var));
        }
        if (!z3 && !z2) {
            builder.addInterceptor(new e());
        }
        t1 t1Var = t1.a;
        s.b b2 = c2.j(builder.build()).b(e.l.n.f.a.b.a());
        if (z) {
            b2.a(new FlowCallAdapterFactory());
        } else {
            b2.a(new RawFlowCallAdapterFactory());
        }
        return (T) b2.f().g(cls);
    }

    public static final <T> T d(@d Class<T> cls, boolean z, boolean z2, boolean z3, long j2, boolean z4) {
        Object obj;
        Map<String, WeakReference<?>> map = f14096e;
        synchronized (map) {
            StringBuilder sb = new StringBuilder();
            sb.append(cls);
            sb.append(l.f16189d);
            sb.append(z);
            sb.append(l.f16189d);
            sb.append(z2);
            sb.append(l.f16189d);
            sb.append(z3);
            String sb2 = sb.toString();
            WeakReference<?> weakReference = map.get(sb2);
            obj = weakReference == null ? (T) null : weakReference.get();
            if (obj == null) {
                obj = (T) c(cls, ServiceApiKt.b(cls).getHost(), z, z2, z3, z4, j2);
                map.put(sb2, new WeakReference<>(obj));
            }
        }
        return (T) obj;
    }
}
