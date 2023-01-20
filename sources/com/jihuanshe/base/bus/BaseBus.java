package com.jihuanshe.base.bus;

import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ExternalLiveData;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.jihuanshe.base.bus.BaseBus;
import com.qiniu.android.collect.ReportItem;
import com.tencent.qcloud.tuicore.TUIConstants;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import java.lang.ref.WeakReference;
import k.b.a.a.n.n.c;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0001J\u0012\u0010\u000b\u001a\u00060\fR\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eR\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/jihuanshe/base/bus/BaseBus;", "", "()V", "liveData", "Landroidx/lifecycle/ExternalLiveData;", "Lcom/jihuanshe/base/bus/BaseBus$Event;", "send", "", "id", "", c.b, "with", "Lcom/jihuanshe/base/bus/BaseBus$BusObserver;", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "BusObserver", "DefaultEvent", "Event", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseBus {
    @d
    private final ExternalLiveData<b<?>> a = new ExternalLiveData<>();

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\f\u001a\u00060\u0000R\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J/\u0010\u000f\u001a\u00020\u00102%\u0010\u0011\u001a!\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00100\u0012H\u0002J0\u0010\u0017\u001a\u00020\u0010\"\f\b\u0000\u0010\u0018*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00100\u0012J\u001c\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dJ*\u0010\u001e\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u001f\u0012\u0004\u0012\u00020\u00100\u0012J(\u0010 \u001a\u00020\u0010\"\u0004\b\u0000\u0010\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u00020\u00100\u0012R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00030\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/jihuanshe/base/bus/BaseBus$BusObserver;", "", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/jihuanshe/base/bus/BaseBus;Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleEvent", "Landroidx/lifecycle/Lifecycle$Event;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "ref", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "bindUtil", "Lcom/jihuanshe/base/bus/BaseBus;", "event", "observe", "", "action", "Lkotlin/Function1;", "Lcom/jihuanshe/base/bus/BaseBus$Event;", "Lkotlin/ParameterName;", "name", "ev", "onEvent", "R", com.heytap.mcssdk.constant.b.f3343k, "", ReportItem.LogTypeBlock, "onMessage", "Lkotlin/Function0;", "onNullableValue", ExifInterface.GPS_DIRECTION_TRUE, "onValue", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public final class BusObserver {
        @e
        private Lifecycle.Event a;
        @d
        private final WeakReference<LifecycleOwner> b;

        public BusObserver(@d LifecycleOwner lifecycleOwner) {
            BaseBus.this = r1;
            this.b = new WeakReference<>(lifecycleOwner);
        }

        private final LifecycleOwner b() {
            return this.b.get();
        }

        public static /* synthetic */ void c(l lVar, b bVar) {
            f(lVar, bVar);
        }

        public static /* synthetic */ void d(l lVar, b bVar) {
            g(lVar, bVar);
        }

        private final void e(final l<? super b<?>, t1> lVar) {
            LifecycleOwner b = b();
            if (b == null) {
                BaseBus.this.a.observeForever(new Observer() { // from class: e.l.h.d.a
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BaseBus.BusObserver.c(l.this, (BaseBus.b) obj);
                    }
                });
            } else {
                BaseBus.this.a.observe(b, new Observer() { // from class: e.l.h.d.b
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BaseBus.BusObserver.d(l.this, (BaseBus.b) obj);
                    }
                });
            }
        }

        public static final void f(l lVar, b bVar) {
            lVar.invoke(bVar);
        }

        public static final void g(l lVar, b bVar) {
            lVar.invoke(bVar);
        }

        @d
        public final BusObserver a(@d Lifecycle.Event event) {
            this.a = event;
            return this;
        }

        public final <R extends b<?>> void h(@d String str, @d l<? super R, t1> lVar) {
            e(new BaseBus$BusObserver$onEvent$1(str, lVar));
        }

        public final void i(@d String str, @d h.k2.u.a<t1> aVar) {
            e(new BaseBus$BusObserver$onMessage$1(str, aVar));
        }

        public final <T> void j(@d String str, @d l<? super T, t1> lVar) {
            e(new BaseBus$BusObserver$onNullableValue$1(str, lVar));
        }

        public final <T> void k(@d String str, @d l<? super T, t1> lVar) {
            e(new BaseBus$BusObserver$onValue$1(str, lVar));
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/jihuanshe/base/bus/BaseBus$DefaultEvent;", "Lcom/jihuanshe/base/bus/BaseBus$Event;", "", "event", "", "(Ljava/lang/String;)V", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class a extends b<Object> {
        public a(@d String str) {
            super(str);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/jihuanshe/base/bus/BaseBus$Event;", ExifInterface.GPS_DIRECTION_TRUE, "", "event", "", "(Ljava/lang/String;)V", c.b, "getAny", "()Ljava/lang/Object;", "setAny", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getEvent", "()Ljava/lang/String;", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class b<T> {
        @d
        private final String a;
        @e
        private T b;

        public b(@d String str) {
            this.a = str;
        }

        @e
        public final T a() {
            return this.b;
        }

        @d
        public final String b() {
            return this.a;
        }

        public final void c(@e T t) {
            this.b = t;
        }
    }

    public static /* synthetic */ void c(BaseBus baseBus, String str, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: send");
        }
        if ((i2 & 2) != 0) {
            obj = null;
        }
        baseBus.b(str, obj);
    }

    public final void b(@d String str, @e Object obj) {
        a aVar = new a(str);
        aVar.c(obj);
        if (f0.g(Looper.myLooper(), Looper.getMainLooper())) {
            this.a.setValue(aVar);
        } else {
            this.a.postValue(aVar);
        }
    }

    @d
    public final BusObserver d(@d LifecycleOwner lifecycleOwner) {
        return new BusObserver(lifecycleOwner);
    }
}
