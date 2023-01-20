package e.n;

import android.annotation.SuppressLint;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qiniu.android.collect.ReportItem;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.umeng.analytics.pro.am;
import h.k2.v.u;
import h.q0;
import h.t1;
import kotlin.DeprecationLevel;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\rH\u0017J(\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\rH\u0007J*\u0010\u0011\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\t0\u000fH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\r\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\tJ\u0015\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/live/Live;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "default", "(Ljava/lang/Object;)V", "getDefault", "()Ljava/lang/Object;", "Ljava/lang/Object;", "observe", "", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "observeForever", "observeNullable", "refresh", "requireValue", "reset", "setNull", "value", am.aI, "live_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@SuppressLint({"CheckResult"})
/* loaded from: classes2.dex */
public class f<T> extends MutableLiveData<T> {
    @k.e.a.e
    private final T a;

    public f() {
        this(null, 1, null);
    }

    public f(@k.e.a.e T t) {
        this.a = t;
        if (t != null) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                setValue(t);
            } else {
                postValue(t);
            }
        }
    }

    public static /* synthetic */ void b(h.k2.u.l lVar, Object obj) {
        i(lVar, obj);
    }

    public static /* synthetic */ void c(h.k2.u.l lVar, Object obj) {
        h(lVar, obj);
    }

    public static /* synthetic */ void d(h.k2.u.l lVar, Object obj) {
        m(lVar, obj);
    }

    public static /* synthetic */ void e(h.k2.u.l lVar, Object obj) {
        l(lVar, obj);
    }

    public static /* synthetic */ void g(f fVar, LifecycleOwner lifecycleOwner, h.k2.u.l lVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observe");
        }
        if ((i2 & 1) != 0) {
            lifecycleOwner = null;
        }
        fVar.f(lifecycleOwner, lVar);
    }

    public static final void h(h.k2.u.l lVar, Object obj) {
        if (obj != null) {
            lVar.invoke(obj);
        }
    }

    public static final void i(h.k2.u.l lVar, Object obj) {
        if (obj != null) {
            lVar.invoke(obj);
        }
    }

    public static /* synthetic */ void k(f fVar, LifecycleOwner lifecycleOwner, h.k2.u.l lVar, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observeNullable");
        }
        if ((i2 & 1) != 0) {
            lifecycleOwner = null;
        }
        fVar.j(lifecycleOwner, lVar);
    }

    public static final void l(h.k2.u.l lVar, Object obj) {
        lVar.invoke(obj);
    }

    public static final void m(h.k2.u.l lVar, Object obj) {
        lVar.invoke(obj);
    }

    @k.e.a.e
    public final T a() {
        return this.a;
    }

    public void f(@k.e.a.e LifecycleOwner lifecycleOwner, @k.e.a.d final h.k2.u.l<? super T, t1> lVar) {
        if (lifecycleOwner == null) {
            observeForever(new Observer() { // from class: e.n.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    f.c(h.k2.u.l.this, obj);
                }
            });
        } else {
            observe(lifecycleOwner, new Observer() { // from class: e.n.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    f.b(h.k2.u.l.this, obj);
                }
            });
        }
    }

    public void j(@k.e.a.e LifecycleOwner lifecycleOwner, @k.e.a.d final h.k2.u.l<? super T, t1> lVar) {
        if (lifecycleOwner == null) {
            observeForever(new Observer() { // from class: e.n.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    f.e(h.k2.u.l.this, obj);
                }
            });
        } else {
            observe(lifecycleOwner, new Observer() { // from class: e.n.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    f.d(h.k2.u.l.this, obj);
                }
            });
        }
    }

    public void n() {
        setValue(getValue());
    }

    public T o() {
        T value = getValue();
        if (value != null) {
            return value;
        }
        throw new KotlinNullPointerException("value is null");
    }

    @Override // androidx.lifecycle.LiveData
    @h.i(level = DeprecationLevel.WARNING, message = "使用没那么便捷, 而且对象无法区分是否可能为空", replaceWith = @q0(expression = "this.observe(observer)", imports = {}))
    public void observe(@k.e.a.d LifecycleOwner lifecycleOwner, @k.e.a.d Observer<? super T> observer) {
        super.observe(lifecycleOwner, observer);
    }

    @Override // androidx.lifecycle.LiveData
    @h.i(level = DeprecationLevel.WARNING, message = "非空对象但是有存在空的可能性, 对于kotlin语法来讲不适用, 需要使用observeNullable()", replaceWith = @q0(expression = "this.observeNullable(observer)", imports = {}))
    public final void observeForever(@k.e.a.d Observer<? super T> observer) {
        super.observeForever(observer);
    }

    public final void p() {
        setValue(this.a);
    }

    public final void q() {
        setValue(null);
    }

    public final void r(@k.e.a.e T t) {
        setValue(t);
    }

    public /* synthetic */ f(Object obj, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : obj);
    }
}
