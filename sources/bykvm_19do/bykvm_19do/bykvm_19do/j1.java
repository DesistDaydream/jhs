package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final class j1<SERVICE, RESULT> {
    private final CountDownLatch a = new CountDownLatch(1);
    private final Intent b;

    /* renamed from: c  reason: collision with root package name */
    private final b<SERVICE, RESULT> f130c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f131d;

    /* loaded from: classes.dex */
    public class a implements ServiceConnection {
        private final CountDownLatch a;
        private final b<SERVICE, RESULT> b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public SERVICE f132c;

        public a(j1 j1Var, CountDownLatch countDownLatch, b<SERVICE, RESULT> bVar) {
            this.a = countDownLatch;
            this.b = bVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            t0.b("Oaid#", "ServiceBlockBinder#onServiceConnected " + componentName);
            try {
                this.f132c = this.b.a(iBinder);
                this.a.countDown();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            t0.b("Oaid#", "ServiceBlockBinder#onServiceDisconnected" + componentName);
            try {
                this.a.countDown();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b<T, RESULT> {
        T a(IBinder iBinder);

        RESULT a(T t);
    }

    public j1(Context context, Intent intent, b<SERVICE, RESULT> bVar) {
        this.f131d = context;
        this.b = intent;
        this.f130c = bVar;
    }

    private void a(j1<SERVICE, RESULT>.a aVar) {
        if (aVar != null) {
            try {
                this.f131d.unbindService(aVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public RESULT a() {
        Throwable th;
        j1<SERVICE, RESULT>.a aVar;
        RESULT result = null;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            try {
                aVar = new a(this, this.a, this.f130c);
                this.f131d.bindService(this.b, aVar, 1);
                this.a.await();
                try {
                    result = this.f130c.a((b<SERVICE, RESULT>) aVar.f132c);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        return result;
                    } finally {
                        a(aVar);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                aVar = null;
            }
        }
        return result;
    }
}
