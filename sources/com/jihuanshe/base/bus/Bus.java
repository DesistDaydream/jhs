package com.jihuanshe.base.bus;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.jihuanshe.base.bus.Bus;
import com.qiniu.android.collect.ReportItem;
import com.tencent.qcloud.tuicore.TUIConstants;
import e.l.h.d.e;
import e.l.h.d.h;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ6\u0010\u000b\u001a\u00020\u0000\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0014\b\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00100\u0013H\u0086\bø\u0001\u0000J6\u0010\u0014\u001a\u00020\u0000\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0014\b\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00100\u0013H\u0086\bø\u0001\u0000J6\u0010\u0015\u001a\u00020\u0000\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0014\b\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00100\u0013H\u0086\bø\u0001\u0000J*\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, d2 = {"Lcom/jihuanshe/base/bus/Bus;", "Lcom/jihuanshe/base/bus/BusMutableLiveData;", "Lcom/jihuanshe/base/bus/Event;", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "live", "(Landroidx/lifecycle/LifecycleOwner;Lcom/jihuanshe/base/bus/BusMutableLiveData;)V", "getLive", "()Lcom/jihuanshe/base/bus/BusMutableLiveData;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "observe", "flag", "", ReportItem.LogTypeBlock, "Lkotlin/Function0;", "", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/Function1;", "observeOnPause", "observeOnResume", "subscribe", "observer", "Landroidx/lifecycle/Observer;", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class Bus extends e<h> {
    @d

    /* renamed from: c  reason: collision with root package name */
    private final LifecycleOwner f3773c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final e<h> f3774d;

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "event", "Lcom/jihuanshe/base/bus/Event;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class a<T> implements Observer {
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l<T, t1> f3775c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(String str, l<? super T, t1> lVar) {
            this.b = str;
            this.f3775c = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(h hVar) {
            if (Bus.this.e().getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED || !f0.g(hVar.g(), this.b)) {
                return;
            }
            Object f2 = hVar.f();
            l<T, t1> lVar = this.f3775c;
            if (f2 != null) {
                f0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (f2 instanceof Object) {
                    lVar.invoke(f2);
                }
            }
            new e.t.l.h();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "event", "Lcom/jihuanshe/base/bus/Event;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class b<T> implements Observer {
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l<T, t1> f3776c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(String str, l<? super T, t1> lVar) {
            this.b = str;
            this.f3776c = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(h hVar) {
            if (Bus.this.e().getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED && Bus.this.e().getLifecycle().getCurrentState() == Lifecycle.State.CREATED && f0.g(hVar.g(), this.b)) {
                Object f2 = hVar.f();
                l<T, t1> lVar = this.f3776c;
                if (f2 != null) {
                    f0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
                    if (f2 instanceof Object) {
                        lVar.invoke(f2);
                    }
                }
                new e.t.l.h();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "event", "Lcom/jihuanshe/base/bus/Event;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class c<T> implements Observer {
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l<T, t1> f3777c;

        /* JADX WARN: Multi-variable type inference failed */
        public c(String str, l<? super T, t1> lVar) {
            this.b = str;
            this.f3777c = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(h hVar) {
            if (Bus.this.e().getLifecycle().getCurrentState() == Lifecycle.State.RESUMED && f0.g(hVar.g(), this.b)) {
                Object f2 = hVar.f();
                l<T, t1> lVar = this.f3777c;
                if (f2 != null) {
                    f0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
                    if (f2 instanceof Object) {
                        lVar.invoke(f2);
                    }
                }
                new e.t.l.h();
            }
        }
    }

    public Bus(@d LifecycleOwner lifecycleOwner, @d e<h> eVar) {
        this.f3773c = lifecycleOwner;
        this.f3774d = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Bus bus, String str, h.k2.u.a aVar, h hVar) {
        if (bus.e().getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED && f0.g(hVar.g(), str) && hVar.f() == null) {
            aVar.invoke();
        }
    }

    @d
    public final e<h> d() {
        return this.f3774d;
    }

    @d
    public final LifecycleOwner e() {
        return this.f3773c;
    }

    @d
    public final Bus g(@d final String str, @d final h.k2.u.a<t1> aVar) {
        l(this.f3773c, this.f3774d, new Observer() { // from class: e.l.h.d.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                Bus.i(Bus.this, str, aVar, (h) obj);
            }
        });
        return this;
    }

    public final /* synthetic */ <T> Bus h(String str, l<? super T, t1> lVar) {
        f0.w();
        l(e(), d(), new a(str, lVar));
        return this;
    }

    public final /* synthetic */ <T> Bus j(String str, l<? super T, t1> lVar) {
        f0.w();
        l(e(), d(), new b(str, lVar));
        return this;
    }

    public final /* synthetic */ <T> Bus k(String str, l<? super T, t1> lVar) {
        f0.w();
        l(e(), d(), new c(str, lVar));
        return this;
    }

    public final void l(@d final LifecycleOwner lifecycleOwner, @d final e<h> eVar, @d final Observer<h> observer) {
        eVar.observeForever(observer);
        lifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.jihuanshe.base.bus.Bus$subscribe$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@d LifecycleOwner lifecycleOwner2, @d Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    Observer<h> observer2 = eVar.b().get(Integer.valueOf(observer.hashCode()));
                    if (observer2 != null) {
                        eVar.removeObserver(observer2);
                    }
                    eVar.b().remove(Integer.valueOf(observer.hashCode()));
                    lifecycleOwner.getLifecycle().removeObserver(this);
                }
            }
        });
    }
}
