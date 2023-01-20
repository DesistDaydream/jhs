package com.vector.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.CallSuper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ServiceLifecycleDispatcher;
import com.huawei.hms.support.api.entity.core.CommonCode;
import e.t.u.l;
import h.w;
import h.z;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0017J\b\u0010\u0010\u001a\u00020\u0011H\u0017J\b\u0010\u0012\u001a\u00020\u0011H\u0017J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH$J\u001a\u0010\u0014\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J\"\u0010\u0017\u001a\u00020\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0017R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/vector/service/ServiceEx;", "Landroid/app/Service;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "dispatcher", "Landroidx/lifecycle/ServiceLifecycleDispatcher;", "getDispatcher", "()Landroidx/lifecycle/ServiceLifecycleDispatcher;", "dispatcher$delegate", "Lkotlin/Lazy;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "onBind", "Landroid/os/IBinder;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onHandleIntent", "onStart", "startId", "", "onStartCommand", "flags", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ServiceEx extends Service implements LifecycleOwner {
    @d
    private final w a = z.c(new ServiceEx$dispatcher$2(this));

    private final ServiceLifecycleDispatcher a() {
        return (ServiceLifecycleDispatcher) this.a.getValue();
    }

    public abstract void b(@d Intent intent);

    @Override // androidx.lifecycle.LifecycleOwner
    @d
    public Lifecycle getLifecycle() {
        return a().getLifecycle();
    }

    @Override // android.app.Service
    @e
    @CallSuper
    public IBinder onBind(@e Intent intent) {
        a().onServicePreSuperOnBind();
        return null;
    }

    @Override // android.app.Service
    @CallSuper
    public void onCreate() {
        a().onServicePreSuperOnCreate();
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        a().onServicePreSuperOnDestroy();
    }

    @Override // android.app.Service
    @CallSuper
    public void onStart(@e Intent intent, int i2) {
        a().onServicePreSuperOnStart();
    }

    @Override // android.app.Service
    @CallSuper
    public int onStartCommand(@e Intent intent, int i2, int i3) {
        if (intent != null) {
            l.a.b(this, intent);
            b(intent);
        }
        return super.onStartCommand(intent, i2, i3);
    }
}
