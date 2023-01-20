package e.b.a.p.k.x;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@RequiresApi(19)
/* loaded from: classes.dex */
public class n implements l {

    /* renamed from: d  reason: collision with root package name */
    private static final int f9628d = 8;

    /* renamed from: e  reason: collision with root package name */
    private static final Bitmap.Config[] f9629e;

    /* renamed from: f  reason: collision with root package name */
    private static final Bitmap.Config[] f9630f;

    /* renamed from: g  reason: collision with root package name */
    private static final Bitmap.Config[] f9631g;

    /* renamed from: h  reason: collision with root package name */
    private static final Bitmap.Config[] f9632h;

    /* renamed from: i  reason: collision with root package name */
    private static final Bitmap.Config[] f9633i;
    private final c a = new c();
    private final h<b, Bitmap> b = new h<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f9634c = new HashMap();

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class c extends d<b> {
        @Override // e.b.a.p.k.x.d
        /* renamed from: d */
        public b a() {
            return new b(this);
        }

        public b e(int i2, Bitmap.Config config) {
            b b = b();
            b.b(i2, config);
            return b;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f9629e = configArr;
        f9630f = configArr;
        f9631g = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f9632h = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f9633i = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void g(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> k2 = k(bitmap.getConfig());
        Integer num2 = (Integer) k2.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                k2.remove(num);
                return;
            } else {
                k2.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + a(bitmap) + ", this: " + this);
    }

    private b h(int i2, Bitmap.Config config) {
        Bitmap.Config[] j2;
        b e2 = this.a.e(i2, config);
        for (Bitmap.Config config2 : j(config)) {
            Integer ceilingKey = k(config2).ceilingKey(Integer.valueOf(i2));
            if (ceilingKey != null && ceilingKey.intValue() <= i2 * 8) {
                if (ceilingKey.intValue() == i2) {
                    if (config2 == null) {
                        if (config == null) {
                            return e2;
                        }
                    } else if (config2.equals(config)) {
                        return e2;
                    }
                }
                this.a.c(e2);
                return this.a.e(ceilingKey.intValue(), config2);
            }
        }
        return e2;
    }

    public static String i(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    private static Bitmap.Config[] j(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f9630f;
        }
        int i2 = a.a[config.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return i2 != 4 ? new Bitmap.Config[]{config} : f9633i;
                }
                return f9632h;
            }
            return f9631g;
        }
        return f9629e;
    }

    private NavigableMap<Integer, Integer> k(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f9634c.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f9634c.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // e.b.a.p.k.x.l
    public String a(Bitmap bitmap) {
        return i(e.b.a.v.n.h(bitmap), bitmap.getConfig());
    }

    @Override // e.b.a.p.k.x.l
    @Nullable
    public Bitmap b() {
        Bitmap f2 = this.b.f();
        if (f2 != null) {
            g(Integer.valueOf(e.b.a.v.n.h(f2)), f2);
        }
        return f2;
    }

    @Override // e.b.a.p.k.x.l
    public String c(int i2, int i3, Bitmap.Config config) {
        return i(e.b.a.v.n.g(i2, i3, config), config);
    }

    @Override // e.b.a.p.k.x.l
    public void d(Bitmap bitmap) {
        b e2 = this.a.e(e.b.a.v.n.h(bitmap), bitmap.getConfig());
        this.b.d(e2, bitmap);
        NavigableMap<Integer, Integer> k2 = k(bitmap.getConfig());
        Integer num = (Integer) k2.get(Integer.valueOf(e2.b));
        k2.put(Integer.valueOf(e2.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // e.b.a.p.k.x.l
    public int e(Bitmap bitmap) {
        return e.b.a.v.n.h(bitmap);
    }

    @Override // e.b.a.p.k.x.l
    @Nullable
    public Bitmap f(int i2, int i3, Bitmap.Config config) {
        b h2 = h(e.b.a.v.n.g(i2, i3, config), config);
        Bitmap a2 = this.b.a(h2);
        if (a2 != null) {
            g(Integer.valueOf(h2.b), a2);
            a2.reconfigure(i2, i3, config);
        }
        return a2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f9634c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f9634c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class b implements m {
        private final c a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f9635c;

        public b(c cVar) {
            this.a = cVar;
        }

        @Override // e.b.a.p.k.x.m
        public void a() {
            this.a.c(this);
        }

        public void b(int i2, Bitmap.Config config) {
            this.b = i2;
            this.f9635c = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.b == bVar.b && e.b.a.v.n.d(this.f9635c, bVar.f9635c);
            }
            return false;
        }

        public int hashCode() {
            int i2 = this.b * 31;
            Bitmap.Config config = this.f9635c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return n.i(this.b, this.f9635c);
        }

        @VisibleForTesting
        public b(c cVar, int i2, Bitmap.Config config) {
            this(cVar);
            b(i2, config);
        }
    }
}
