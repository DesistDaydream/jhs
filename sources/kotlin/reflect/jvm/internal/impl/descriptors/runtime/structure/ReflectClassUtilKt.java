package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import h.a2.t0;
import h.a2.u;
import h.k2.a;
import h.k2.u.b;
import h.k2.u.c;
import h.k2.u.e;
import h.k2.u.f;
import h.k2.u.g;
import h.k2.u.h;
import h.k2.u.i;
import h.k2.u.j;
import h.k2.u.k;
import h.k2.u.l;
import h.k2.u.m;
import h.k2.u.n;
import h.k2.u.o;
import h.k2.u.p;
import h.k2.u.q;
import h.k2.u.s;
import h.k2.u.t;
import h.k2.u.v;
import h.k2.u.w;
import h.k2.v.f0;
import h.k2.v.n0;
import h.r;
import h.z0;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k.e.a.d;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes3.dex */
public final class ReflectClassUtilKt {
    @d
    private static final List<h.p2.d<? extends Object>> a;
    @d
    private static final Map<Class<? extends Object>, Class<? extends Object>> b;
    @d

    /* renamed from: c */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f16478c;
    @d

    /* renamed from: d */
    private static final Map<Class<? extends r<?>>, Integer> f16479d;

    static {
        int i2 = 0;
        List<h.p2.d<? extends Object>> L = CollectionsKt__CollectionsKt.L(n0.d(Boolean.TYPE), n0.d(Byte.TYPE), n0.d(Character.TYPE), n0.d(Double.TYPE), n0.d(Float.TYPE), n0.d(Integer.TYPE), n0.d(Long.TYPE), n0.d(Short.TYPE));
        a = L;
        ArrayList arrayList = new ArrayList(u.Y(L, 10));
        Iterator<T> it = L.iterator();
        while (it.hasNext()) {
            h.p2.d dVar = (h.p2.d) it.next();
            arrayList.add(z0.a(a.e(dVar), a.f(dVar)));
        }
        b = t0.B0(arrayList);
        List<h.p2.d<? extends Object>> list = a;
        ArrayList arrayList2 = new ArrayList(u.Y(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            h.p2.d dVar2 = (h.p2.d) it2.next();
            arrayList2.add(z0.a(a.f(dVar2), a.e(dVar2)));
        }
        f16478c = t0.B0(arrayList2);
        List L2 = CollectionsKt__CollectionsKt.L(h.k2.u.a.class, l.class, p.class, q.class, h.k2.u.r.class, s.class, t.class, h.k2.u.u.class, v.class, w.class, b.class, c.class, h.k2.u.d.class, e.class, f.class, g.class, h.class, i.class, j.class, k.class, m.class, n.class, o.class);
        ArrayList arrayList3 = new ArrayList(u.Y(L2, 10));
        for (Object obj : L2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            arrayList3.add(z0.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        f16479d = t0.B0(arrayList3);
    }

    @d
    public static final h.p2.b0.g.t.g.b a(@d Class<?> cls) {
        if (!cls.isPrimitive()) {
            if (!cls.isArray()) {
                if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                    if (!(cls.getSimpleName().length() == 0)) {
                        Class<?> declaringClass = cls.getDeclaringClass();
                        h.p2.b0.g.t.g.b d2 = declaringClass == null ? null : a(declaringClass).d(h.p2.b0.g.t.g.f.f(cls.getSimpleName()));
                        return d2 == null ? h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c(cls.getName())) : d2;
                    }
                }
                h.p2.b0.g.t.g.c cVar = new h.p2.b0.g.t.g.c(cls.getName());
                return new h.p2.b0.g.t.g.b(cVar.e(), h.p2.b0.g.t.g.c.k(cVar.g()), true);
            }
            throw new IllegalArgumentException(f0.C("Can't compute ClassId for array type: ", cls));
        }
        throw new IllegalArgumentException(f0.C("Can't compute ClassId for primitive type: ", cls));
    }

    @d
    public static final String b(@d Class<?> cls) {
        if (cls.isPrimitive()) {
            String name = cls.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            return "D";
                        }
                        break;
                    case 104431:
                        if (name.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                            return ExpandableTextView.P;
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            return "B";
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            return "C";
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            return "J";
                        }
                        break;
                    case 3625364:
                        if (name.equals("void")) {
                            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
                        }
                        break;
                    case 64711720:
                        if (name.equals("boolean")) {
                            return "Z";
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            return "F";
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            return ExifInterface.LATITUDE_SOUTH;
                        }
                        break;
                }
            }
            throw new IllegalArgumentException(f0.C("Unsupported primitive type: ", cls));
        } else if (cls.isArray()) {
            return h.t2.u.j2(cls.getName(), '.', Attributes.InternalPrefix, false, 4, null);
        } else {
            return 'L' + h.t2.u.j2(cls.getName(), '.', Attributes.InternalPrefix, false, 4, null) + ';';
        }
    }

    @k.e.a.e
    public static final Integer c(@d Class<?> cls) {
        return f16479d.get(cls);
    }

    @d
    public static final List<Type> d(@d Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return parameterizedType.getOwnerType() == null ? ArraysKt___ArraysKt.ey(parameterizedType.getActualTypeArguments()) : SequencesKt___SequencesKt.V2(SequencesKt___SequencesKt.A0(SequencesKt__SequencesKt.o(type, ReflectClassUtilKt$parameterizedTypeArguments$1.INSTANCE), ReflectClassUtilKt$parameterizedTypeArguments$2.INSTANCE));
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @k.e.a.e
    public static final Class<?> e(@d Class<?> cls) {
        return b.get(cls);
    }

    @d
    public static final ClassLoader f(@d Class<?> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        return classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader;
    }

    @k.e.a.e
    public static final Class<?> g(@d Class<?> cls) {
        return f16478c.get(cls);
    }

    public static final boolean h(@d Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }
}
