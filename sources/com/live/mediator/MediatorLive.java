package com.live.mediator;

import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.android.tpush.common.MessageKey;
import e.n.f;
import h.k2.v.u;
import h.w;
import h.z;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0017B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J-\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\b\u0000\u0012\u0004\u0018\u00018\u00000\u0011H\u0000¢\u0006\u0002\b\u0012J\r\u0010\u0013\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0014J\u0018\u0010\u0015\u001a\u00020\r2\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0011H\u0016R'\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/live/mediator/MediatorLive;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/live/Live;", "default", "(Ljava/lang/Object;)V", "sources", "", "Lcom/live/mediator/MediatorLive$Source;", "getSources", "()Ljava/util/List;", "sources$delegate", "Lkotlin/Lazy;", "addSource", "", MessageKey.MSG_SOURCE, "Landroidx/lifecycle/LiveData;", "onChanged", "Landroidx/lifecycle/Observer;", "addSource$live_release", "clearSources", "clearSources$live_release", "removeObserver", "observer", "Source", "live_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public class MediatorLive<T> extends f<T> {
    @d
    private final w b;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0002B'\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\b\b\u0000\u0012\u0004\u0018\u00018\u00010\u0002¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\f\u0012\b\b\u0000\u0012\u0004\u0018\u00018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/live/mediator/MediatorLive$Source;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/lifecycle/Observer;", "liveData", "Landroidx/lifecycle/LiveData;", "observer", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/Observer;)V", "onChanged", "", "v", "(Ljava/lang/Object;)V", "plug", "unplug", "live_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class a<V> implements Observer<V> {
        @d
        private final LiveData<V> a;
        @d
        private final Observer<? super V> b;

        public a(@d LiveData<V> liveData, @d Observer<? super V> observer) {
            this.a = liveData;
            this.b = observer;
        }

        public final void a() {
            this.a.observeForever(this);
        }

        public final void b() {
            this.a.removeObserver(this);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@e V v) {
            this.b.onChanged(v);
        }
    }

    public MediatorLive() {
        this(null, 1, null);
    }

    public MediatorLive(@e T t) {
        super(null, 1, null);
        this.b = z.b(LazyThreadSafetyMode.NONE, MediatorLive$sources$2.INSTANCE);
        if (t != null) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                setValue(t);
            } else {
                postValue(t);
            }
        }
    }

    private final List<a<T>> u() {
        return (List) this.b.getValue();
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(@d Observer<? super T> observer) {
        super.removeObserver(observer);
        t();
    }

    public final void s(@d LiveData<T> liveData, @d Observer<? super T> observer) {
        a<T> aVar = new a<>(liveData, observer);
        aVar.a();
        u().add(aVar);
    }

    public final void t() {
        if (!u().isEmpty()) {
            Iterator<T> it = u().iterator();
            while (it.hasNext()) {
                ((a) it.next()).b();
            }
            u().clear();
        }
    }

    public /* synthetic */ MediatorLive(Object obj, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : obj);
    }
}
