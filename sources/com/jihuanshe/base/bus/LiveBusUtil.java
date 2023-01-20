package com.jihuanshe.base.bus;

import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.jihuanshe.base.bus.LiveBusUtil;
import h.k2.v.f0;
import h.w;
import h.z;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0006\u0010\u000e\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\u000fJ'\u0010\u0010\u001a\u00020\n\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0006\u0010\u000e\u001a\u0002H\u000b¢\u0006\u0002\u0010\u000fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/jihuanshe/base/bus/LiveBusUtil;", "", "()V", "sMainHandler", "Landroid/os/Handler;", "getSMainHandler", "()Landroid/os/Handler;", "sMainHandler$delegate", "Lkotlin/Lazy;", "postValue", "", ExifInterface.GPS_DIRECTION_TRUE, "live", "Landroidx/lifecycle/MutableLiveData;", "data", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Object;)V", "setValue", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class LiveBusUtil {
    @d
    public static final LiveBusUtil a = new LiveBusUtil();
    @d
    private static final w b = z.c(LiveBusUtil$sMainHandler$2.INSTANCE);

    private LiveBusUtil() {
    }

    private final Handler a() {
        return (Handler) b.getValue();
    }

    public static /* synthetic */ void b(MutableLiveData mutableLiveData, Object obj) {
        d(mutableLiveData, obj);
    }

    private final <T> void c(final MutableLiveData<T> mutableLiveData, final T t) {
        a().post(new Runnable() { // from class: e.l.h.d.d
            @Override // java.lang.Runnable
            public final void run() {
                LiveBusUtil.b(MutableLiveData.this, t);
            }
        });
    }

    public static final void d(MutableLiveData mutableLiveData, Object obj) {
        mutableLiveData.setValue(obj);
    }

    public final <T> void e(@d MutableLiveData<T> mutableLiveData, T t) {
        if (f0.g(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            mutableLiveData.setValue(t);
        } else {
            c(mutableLiveData, t);
        }
    }
}
