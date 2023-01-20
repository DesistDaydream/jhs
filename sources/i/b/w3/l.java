package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.umeng.analytics.pro.am;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.internal.MainDispatcherFactory;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b&\u0010'J(\u0010\u0007\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0082\b¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J.\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0017*\u00020\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00028\u00000\u0019H\u0082\b¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\rH\u0000¢\u0006\u0004\b!\u0010\"J1\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b#\u0010\u000fR\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010$¨\u0006("}, d2 = {"Li/b/w3/l;", "", "Ljava/lang/Class;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "", "serviceClass", am.av, "(Ljava/lang/Class;Ljava/lang/String;)Lkotlinx/coroutines/internal/MainDispatcherFactory;", ExifInterface.LATITUDE_SOUTH, "service", "Ljava/lang/ClassLoader;", "loader", "", "c", "(Ljava/lang/Class;Ljava/lang/ClassLoader;)Ljava/util/List;", "name", "b", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "Ljava/net/URL;", "url", "f", "(Ljava/net/URL;)Ljava/util/List;", "R", "Ljava/util/jar/JarFile;", "Lkotlin/Function1;", ReportItem.LogTypeBlock, "h", "(Ljava/util/jar/JarFile;Lh/k2/u/l;)Ljava/lang/Object;", "Ljava/io/BufferedReader;", "r", "g", "(Ljava/io/BufferedReader;)Ljava/util/List;", e.j.a.b.c.f.f10128d, "()Ljava/util/List;", com.huawei.hms.push.e.a, "Ljava/lang/String;", "PREFIX", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class l {
    private static final String a = "META-INF/services/";
    public static final l b = new l();

    private l() {
    }

    private final MainDispatcherFactory a(Class<MainDispatcherFactory> cls, String str) {
        try {
            return cls.cast(Class.forName(str, true, cls.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final <S> S b(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> c(Class<S> cls, ClassLoader classLoader) {
        try {
            return e(cls, classLoader);
        } catch (Throwable unused) {
            return CollectionsKt___CollectionsKt.I5(ServiceLoader.load(cls, classLoader));
        }
    }

    private final List<String> f(URL url) {
        String url2 = url.toString();
        if (h.t2.u.u2(url2, "jar", false, 2, null)) {
            String t5 = StringsKt__StringsKt.t5(StringsKt__StringsKt.m5(url2, "jar:file:", null, 2, null), '!', null, 2, null);
            String m5 = StringsKt__StringsKt.m5(url2, "!/", null, 2, null);
            JarFile jarFile = new JarFile(t5, false);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(m5)), "UTF-8"));
                List<String> g2 = b.g(bufferedReader);
                h.h2.b.a(bufferedReader, null);
                jarFile.close();
                return g2;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        jarFile.close();
                        throw th2;
                    } catch (Throwable th3) {
                        h.m.a(th, th3);
                        throw th;
                    }
                }
            }
        }
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(url.openStream()));
        try {
            List<String> g3 = b.g(bufferedReader2);
            h.h2.b.a(bufferedReader2, null);
            return g3;
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                h.h2.b.a(bufferedReader2, th4);
                throw th5;
            }
        }
    }

    private final List<String> g(BufferedReader bufferedReader) {
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String u5 = StringsKt__StringsKt.u5(readLine, MqttTopic.MULTI_LEVEL_WILDCARD, null, 2, null);
                Objects.requireNonNull(u5, "null cannot be cast to non-null type kotlin.CharSequence");
                String obj = StringsKt__StringsKt.B5(u5).toString();
                int i2 = 0;
                while (true) {
                    if (i2 >= obj.length()) {
                        z = true;
                        break;
                    }
                    char charAt = obj.charAt(i2);
                    if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                        z = false;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    if (obj.length() > 0) {
                        linkedHashSet.add(obj);
                    }
                } else {
                    throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
                }
            } else {
                return CollectionsKt___CollectionsKt.I5(linkedHashSet);
            }
        }
    }

    private final <R> R h(JarFile jarFile, h.k2.u.l<? super JarFile, ? extends R> lVar) {
        try {
            R invoke = lVar.invoke(jarFile);
            h.k2.v.c0.d(1);
            jarFile.close();
            h.k2.v.c0.c(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                h.k2.v.c0.d(1);
                try {
                    jarFile.close();
                    h.k2.v.c0.c(1);
                    throw th2;
                } catch (Throwable th3) {
                    h.m.a(th, th3);
                    throw th;
                }
            }
        }
    }

    @k.e.a.d
    public final List<MainDispatcherFactory> d() {
        MainDispatcherFactory mainDispatcherFactory;
        if (!m.a()) {
            return c(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 != null) {
                arrayList.add(mainDispatcherFactory2);
                return arrayList;
            }
            return arrayList;
        } catch (Throwable unused3) {
            return c(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
    }

    @k.e.a.d
    public final <S> List<S> e(@k.e.a.d Class<S> cls, @k.e.a.d ClassLoader classLoader) {
        ArrayList<URL> list = Collections.list(classLoader.getResources(a + cls.getName()));
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            h.a2.y.q0(arrayList, b.f(url));
        }
        Set<String> N5 = CollectionsKt___CollectionsKt.N5(arrayList);
        if (!N5.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(h.a2.u.Y(N5, 10));
            for (String str : N5) {
                arrayList2.add(b.b(str, classLoader, cls));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}
