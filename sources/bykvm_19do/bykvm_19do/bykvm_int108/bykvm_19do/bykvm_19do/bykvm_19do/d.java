package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.os.Looper;
import com.bytedance.sdk.component.utils.ProcessUtil;
import com.tencent.android.tpush.common.MessageKey;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class d implements f {
    public static final d a = new d();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a(d dVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.f();
        }
    }

    /* loaded from: classes.dex */
    public class b extends bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c {
        public final /* synthetic */ g b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, g gVar) {
            super(str);
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("TTExecutor start");
            d.this.a(this.b.d());
        }
    }

    /* loaded from: classes.dex */
    public class c extends bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c {
        public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f1134c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, g gVar) {
            super(str);
            this.b = aVar;
            this.f1134c = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this.b, this.f1134c.d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        if (i2 == 0) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a.c();
        } else if (i2 == 1) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.b();
        }
    }

    private void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.a aVar) {
        Executor b2;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.f();
            return;
        }
        g a2 = aVar.a();
        if (a2 == null || (b2 = a2.b()) == null) {
            return;
        }
        b2.execute(new a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, int i2) {
        if (i2 == 0) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a.a(aVar);
        } else if (i2 == 1) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.a(aVar);
        }
    }

    private boolean a(Context context, g gVar) {
        if (context == null || gVar == null) {
            return false;
        }
        if (gVar.d() != 2) {
            try {
                return ProcessUtil.isMainProcess(context);
            } catch (Throwable th) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b(th.getMessage());
            }
        }
        return true;
    }

    private void b(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.a aVar, Context context) {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.c.a(context, "context == null");
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.c.a(aVar, "AdLogConfig == null");
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.c.a(aVar.a(), "AdLogDepend ==null");
    }

    private void b(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        g b2 = j.l().b();
        if (aVar == null || b2 == null || j.l().d() == null || b2.a() == null) {
            return;
        }
        if (j.l().j()) {
            boolean a2 = a(j.l().d(), b2);
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("dispatchEvent mainProcess:" + a2);
            if (!a2) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("sub thread dispatch:" + c());
                if (c()) {
                    b2.a().execute(new c("dispatchEvent", aVar, b2));
                    return;
                } else {
                    a(aVar, b2.d());
                    return;
                }
            }
        }
        j.l().a(aVar);
    }

    private boolean c() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public void a() {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("flushMemoryAndDB");
        j.l().a();
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.a aVar, Context context) {
        b(aVar, context);
        j.l().a(context);
        j.l().a(aVar.g());
        j.l().b(aVar.d());
        j.l().c(aVar.e());
        j.l().a(aVar.b());
        j.l().d(aVar.f());
        j.l().a(aVar.c() == null ? bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e.b : aVar.c());
        j.l().a(aVar.h());
        j.l().a(aVar.a());
        a(aVar);
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        b(aVar);
    }

    public void b() {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("EventMultiUtils start");
        g b2 = j.l().b();
        if (b2 == null || j.l().d() == null || b2.a() == null) {
            return;
        }
        if (!j.l().j() || a(j.l().d(), b2)) {
            j.l().k();
        } else if (c()) {
            b2.a().execute(new b(MessageKey.MSG_ACCEPT_TIME_START, b2));
        } else {
            a(b2.d());
        }
    }
}
