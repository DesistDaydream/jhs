package h.g2;

import androidx.exifinterface.media.ExifInterface;
import com.caverock.androidsvg.SVG;
import h.k2.v.f0;
import h.p0;
import h.s0;
import h.t;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0083\b¢\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", ExifInterface.GPS_DIRECTION_TRUE, "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class l {
    @h.k2.d
    @k.e.a.d
    public static final k a;

    static {
        k kVar;
        Object newInstance;
        Object newInstance2;
        int c2 = c();
        if (c2 >= 65544) {
            try {
                try {
                    newInstance = Class.forName("h.g2.r.a").newInstance();
                    try {
                    } catch (ClassCastException e2) {
                        ClassLoader classLoader = newInstance.getClass().getClassLoader();
                        ClassLoader classLoader2 = k.class.getClassLoader();
                        throw new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e2);
                    }
                } catch (ClassNotFoundException unused) {
                    Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    try {
                        if (newInstance3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        kVar = (k) newInstance3;
                    } catch (ClassCastException e3) {
                        ClassLoader classLoader3 = newInstance3.getClass().getClassLoader();
                        ClassLoader classLoader4 = k.class.getClassLoader();
                        throw new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + classLoader4).initCause(e3);
                    }
                }
            } catch (ClassNotFoundException unused2) {
            }
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            kVar = (k) newInstance;
            a = kVar;
        }
        if (c2 >= 65543) {
            try {
                try {
                    newInstance2 = Class.forName("h.g2.q.a").newInstance();
                    try {
                    } catch (ClassCastException e4) {
                        ClassLoader classLoader5 = newInstance2.getClass().getClassLoader();
                        ClassLoader classLoader6 = k.class.getClassLoader();
                        throw new ClassCastException("Instance classloader: " + classLoader5 + ", base type classloader: " + classLoader6).initCause(e4);
                    }
                } catch (ClassNotFoundException unused3) {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    try {
                        if (newInstance4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        kVar = (k) newInstance4;
                    } catch (ClassCastException e5) {
                        ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                        ClassLoader classLoader8 = k.class.getClassLoader();
                        throw new ClassCastException("Instance classloader: " + classLoader7 + ", base type classloader: " + classLoader8).initCause(e5);
                    }
                }
            } catch (ClassNotFoundException unused4) {
            }
            if (newInstance2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            kVar = (k) newInstance2;
            a = kVar;
        }
        kVar = new k();
        a = kVar;
    }

    @p0
    @s0(version = SVG.f2474i)
    public static final boolean a(int i2, int i3, int i4) {
        return t.f15672f.g(i2, i3, i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f
    private static final /* synthetic */ <T> T b(Object obj) {
        try {
            f0.y(1, ExifInterface.GPS_DIRECTION_TRUE);
            return obj;
        } catch (ClassCastException e2) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            f0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
            ClassLoader classLoader2 = Object.class.getClassLoader();
            throw new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e2);
        }
    }

    private static final int c() {
        String property = System.getProperty("java.specification.version");
        if (property != null) {
            int q3 = StringsKt__StringsKt.q3(property, '.', 0, false, 6, null);
            if (q3 < 0) {
                try {
                    return Integer.parseInt(property) * 65536;
                } catch (NumberFormatException unused) {
                    return 65542;
                }
            }
            int i2 = q3 + 1;
            int q32 = StringsKt__StringsKt.q3(property, '.', i2, false, 4, null);
            if (q32 < 0) {
                q32 = property.length();
            }
            Objects.requireNonNull(property, "null cannot be cast to non-null type java.lang.String");
            String substring = property.substring(0, q3);
            Objects.requireNonNull(property, "null cannot be cast to non-null type java.lang.String");
            try {
                return (Integer.parseInt(substring) * 65536) + Integer.parseInt(property.substring(i2, q32));
            } catch (NumberFormatException unused2) {
                return 65542;
            }
        }
        return 65542;
    }
}
