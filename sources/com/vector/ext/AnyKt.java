package com.vector.ext;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.IntRange;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.qiniu.android.collect.ReportItem;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.vector.ext.AnyKt;
import com.vector.model.MapList;
import e.t.l.h;
import h.k2.u.a;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.u.q;
import h.k2.v.f0;
import h.t1;
import i.b.b1;
import i.b.b2;
import i.b.i;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\u001am\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u000328\u0010\u0006\u001a4\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0005\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0007¢\u0006\u0002\u0010\n\u001a\u0092\u0001\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u000b\"\u0004\b\u0003\u0010\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u00032\b\u0010\f\u001a\u0004\u0018\u0001H\u000b2M\u0010\u0006\u001aI\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\r¢\u0006\u0002\u0010\u000e\u001a%\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u0012\"\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0002\u0010\u0014\u001a&\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c\u001a \u0010\u001d\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c\u001a\u0018\u0010\u001e\u001a\u00020\u00162\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00160\u001cj\u0002`\u001f\u001a6\u0010\u001e\u001a\u00020\u00162\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00160\u001cj\u0002`\u001f\u001a\u0018\u0010$\u001a\u00020\u00162\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00160\u001cj\u0002`\u001f\u001a4\u0010$\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00160\u001cj\u0002`\u001f\u001a\"\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'2\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00160\u001cj\u0002`\u001fH\u0002\u001a@\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'2\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00160\u001cj\u0002`\u001fH\u0002\u001a.\u0010(\u001a\u00020)\"\u0006\b\u0000\u0010*\u0018\u0001*\u0004\u0018\u00010\u00132\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00160+H\u0086\bø\u0001\u0000\u001a&\u0010,\u001a\u00020\u0016\"\n\b\u0000\u0010*\u0018\u0001*\u00020\u0013*\u0002H*2\u0006\u0010-\u001a\u0002H*H\u0086\b¢\u0006\u0002\u0010.\u001a1\u0010/\u001a\f\u0012\u0006\b\u0000\u0012\u0002H*\u0018\u000100\"\b\b\u0000\u0010**\u00020\u0013*\u0002H*2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H*00¢\u0006\u0002\u00102\u001a1\u0010/\u001a\f\u0012\u0006\b\u0000\u0012\u0002H*\u0018\u000100\"\b\b\u0000\u0010**\u00020\u0013*\u0002H*2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H*03¢\u0006\u0002\u00104\u001aK\u00105\u001a\u0004\u0018\u0001H6\"\b\b\u0000\u0010**\u00020\u0013\"\b\b\u0001\u00106*\u000207*\u0002H*2\f\u00108\u001a\b\u0012\u0004\u0012\u0002H6032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H6\u0012\u0004\u0012\u00020\u0016\u0018\u00010+¢\u0006\u0002\u00109\u001a;\u0010:\u001a\u00020\u0016\"\u0004\b\u0000\u0010**\u0004\u0018\u0001H*2\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00160+j\b\u0012\u0004\u0012\u0002H*`;H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010<\u001a)\u0010=\u001a\u00020\u0016\"\u0004\b\u0000\u0010**\u0004\u0018\u0001H*2\u0010\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00160\u001cj\u0002`\u001f¢\u0006\u0002\u0010>\u001a\u0017\u0010?\u001a\u00020\u0010\"\u0004\b\u0000\u0010**\u0004\u0018\u0001H*¢\u0006\u0002\u0010@\u001a\u0017\u0010A\u001a\u00020\u0010\"\u0004\b\u0000\u0010**\u0004\u0018\u0001H*¢\u0006\u0002\u0010@\u001a5\u0010B\u001a\u0002H\u0001\"\u0004\b\u0000\u0010*\"\u0004\b\u0001\u0010\u0001*\u0002H*2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002H\u00010+H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010D\u001a)\u0010E\u001a\u0002H*\"\u0004\b\u0000\u0010**\u0002H*2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010F\u001a#\u0010G\u001a\u0002H*\"\u0004\b\u0000\u0010**\u0004\u0018\u0001H*2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I¢\u0006\u0002\u0010J*(\u0010K\u001a\u0004\b\u0000\u0010*\"\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00160+2\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u00160+*\u0016\u0010L\"\b\u0012\u0004\u0012\u00020\u00160\u001c2\b\u0012\u0004\u0012\u00020\u00160\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006M"}, d2 = {"doOnNotNull", "R", "T1", "T2", "t1", "t2", ReportItem.LogTypeBlock, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "t3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "notNull", "", "ts", "", "", "([Ljava/lang/Object;)Z", "postDelay", "", "looper", "Landroid/os/Looper;", "delay", "", "runnable", "Lkotlin/Function0;", "postRunnable", "runOnMainThread", "Lcom/vector/ext/NoArgClosure;", "timeUnit", "Ljava/util/concurrent/TimeUnit;", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "runOnSubThread", "runOnTargetThread", "context", "Lkotlin/coroutines/CoroutineContext;", "cast", "Lcom/vector/ext/CastError;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "copyFields", "toCopy", "(Ljava/lang/Object;Ljava/lang/Object;)V", "findSuperClass", "Ljava/lang/Class;", "clazz", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Class;", "Lkotlin/reflect/KClass;", "(Ljava/lang/Object;Lkotlin/reflect/KClass;)Ljava/lang/Class;", "getAnnotation", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "annotationClass", "(Ljava/lang/Object;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)Ljava/lang/annotation/Annotation;", "ifNotNull", "Lcom/vector/ext/Closure;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "ifNull", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "isNotNull", "(Ljava/lang/Object;)Z", "isNull", "map", "action", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "self", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "throwIfNull", "text", "", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;", "Closure", "NoArgClosure", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AnyKt {
    public static /* synthetic */ void A(long j2, TimeUnit timeUnit, LifecycleOwner lifecycleOwner, a aVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            lifecycleOwner = null;
        }
        y(j2, timeUnit, lifecycleOwner, aVar);
    }

    public static final void B(long j2, @d TimeUnit timeUnit, @e LifecycleOwner lifecycleOwner, @d a<t1> aVar) {
        E(b1.c(), j2, timeUnit, lifecycleOwner, aVar);
    }

    public static final void C(@d a<t1> aVar) {
        F(b1.c(), aVar);
    }

    public static /* synthetic */ void D(long j2, TimeUnit timeUnit, LifecycleOwner lifecycleOwner, a aVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            lifecycleOwner = null;
        }
        B(j2, timeUnit, lifecycleOwner, aVar);
    }

    private static final void E(CoroutineContext coroutineContext, @IntRange(from = 0) long j2, TimeUnit timeUnit, LifecycleOwner lifecycleOwner, a<t1> aVar) {
        b2 f2;
        f2 = i.f(i.b.t1.a, coroutineContext, null, new AnyKt$runOnTargetThread$2(timeUnit, j2, aVar, null), 2, null);
        CoroutineKt.a(f2, lifecycleOwner);
    }

    private static final void F(CoroutineContext coroutineContext, a<t1> aVar) {
        i.f(i.b.t1.a, coroutineContext, null, new AnyKt$runOnTargetThread$1(aVar, null), 2, null);
    }

    public static /* synthetic */ void G(CoroutineContext coroutineContext, long j2, TimeUnit timeUnit, LifecycleOwner lifecycleOwner, a aVar, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            lifecycleOwner = null;
        }
        E(coroutineContext, j2, timeUnit, lifecycleOwner, aVar);
    }

    public static final <T> T H(T t, @d a<t1> aVar) {
        aVar.invoke();
        return t;
    }

    public static final <T> T I(@e T t, @e String str) throws NullPointerException {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static /* synthetic */ Object J(Object obj, String str, int i2, Object obj2) throws NullPointerException {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return I(obj, str);
    }

    public static final /* synthetic */ <T> h a(Object obj, l<? super T, t1> lVar) {
        if (obj != null) {
            f0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (obj instanceof Object) {
                lVar.invoke(obj);
            }
        }
        return new h();
    }

    public static final /* synthetic */ <T> void b(T t, T t2) {
        int i2;
        Field[] declaredFields = t2.getClass().getDeclaredFields();
        MapList mapList = new MapList();
        Class<?> cls = t.getClass();
        while (true) {
            i2 = 0;
            if (cls == null || f0.g(cls, Object.class)) {
                break;
            }
            Field[] declaredFields2 = cls.getDeclaredFields();
            int length = declaredFields2.length;
            while (i2 < length) {
                Field field = declaredFields2[i2];
                mapList.add((MapList) field.getName(), (String) field);
                i2++;
            }
            cls = cls.getSuperclass();
        }
        int length2 = declaredFields.length;
        while (i2 < length2) {
            Field field2 = declaredFields[i2];
            Field field3 = (Field) mapList.getByKey(field2.getName());
            if (field3 != null) {
                field3.setAccessible(true);
                field2.setAccessible(true);
                field3.set(t, field2.get(t2));
            }
            i2++;
        }
    }

    @e
    public static final <T1, T2, T3, R> R c(@e T1 t1, @e T2 t2, @e T3 t3, @d q<? super T1, ? super T2, ? super T3, ? extends R> qVar) {
        if (q(t1, t2, t3)) {
            return qVar.invoke(t1, t2, t3);
        }
        return null;
    }

    @e
    public static final <T1, T2, R> R d(@e T1 t1, @e T2 t2, @d p<? super T1, ? super T2, ? extends R> pVar) {
        if (q(t1, t2)) {
            return pVar.invoke(t1, t2);
        }
        return null;
    }

    @e
    public static final <T> Class<? super T> e(@d T t, @d Class<T> cls) {
        Class<? super T> cls2 = (Class<? super T>) t.getClass();
        while (cls2 != null && !f0.g(cls2, Object.class) && !f0.g(cls2, cls)) {
            cls2 = (Class<? super T>) cls2.getSuperclass();
        }
        return cls2;
    }

    @e
    public static final <T> Class<? super T> f(@d T t, @d h.p2.d<T> dVar) {
        return e(t, h.k2.a.c(dVar));
    }

    @e
    public static final <T, A extends Annotation> A g(@d T t, @d h.p2.d<A> dVar, @e l<? super A, t1> lVar) {
        A a = (A) t.getClass().getAnnotation(h.k2.a.c(dVar));
        if (a != null && lVar != null) {
            lVar.invoke(a);
        }
        return a;
    }

    public static /* synthetic */ Annotation h(Object obj, h.p2.d dVar, l lVar, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            lVar = null;
        }
        return g(obj, dVar, lVar);
    }

    public static final <T> void i(@e T t, @d l<? super T, t1> lVar) {
        if (t != null) {
            lVar.invoke(t);
        }
    }

    public static final <T> void j(@e T t, @d a<t1> aVar) {
        if (l(t)) {
            aVar.invoke();
        }
    }

    public static final <T> boolean k(@e T t) {
        return t != null;
    }

    public static final <T> boolean l(@e T t) {
        return t == null;
    }

    public static final <T, R> R p(T t, @d l<? super T, ? extends R> lVar) {
        return lVar.invoke(t);
    }

    public static final boolean q(@d Object... objArr) {
        for (Object obj : objArr) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static final void r(@d Looper looper, long j2, @d final a<t1> aVar) {
        new Handler(looper).postDelayed(new Runnable() { // from class: e.t.l.c
            @Override // java.lang.Runnable
            public final void run() {
                AnyKt.t(aVar);
            }
        }, j2);
    }

    public static /* synthetic */ void s(Looper looper, long j2, a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            looper = Looper.getMainLooper();
        }
        r(looper, j2, aVar);
    }

    public static final void t(a aVar) {
        aVar.invoke();
    }

    public static final void u(@e Looper looper, @d final a<t1> aVar) {
        if (looper != null) {
            new Handler(looper).post(new Runnable() { // from class: e.t.l.a
                @Override // java.lang.Runnable
                public final void run() {
                    AnyKt.x(aVar);
                }
            });
            return;
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        new Handler(myLooper).post(new Runnable() { // from class: e.t.l.b
            @Override // java.lang.Runnable
            public final void run() {
                AnyKt.w(aVar);
            }
        });
    }

    public static /* synthetic */ void v(Looper looper, a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            looper = null;
        }
        u(looper, aVar);
    }

    public static final void w(a aVar) {
        aVar.invoke();
    }

    public static final void x(a aVar) {
        aVar.invoke();
    }

    public static final void y(@IntRange(from = 0) long j2, @d TimeUnit timeUnit, @e LifecycleOwner lifecycleOwner, @d a<t1> aVar) {
        E(b1.e(), j2, timeUnit, lifecycleOwner, aVar);
    }

    public static final void z(@d a<t1> aVar) {
        F(b1.e(), aVar);
    }
}
