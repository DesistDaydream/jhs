package e.j.a.c.b0;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static final int f10570e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static final int f10571f = 1500;

    /* renamed from: g  reason: collision with root package name */
    private static final int f10572g = 2750;

    /* renamed from: h  reason: collision with root package name */
    private static b f10573h;
    @NonNull
    private final Object a = new Object();
    @NonNull
    private final Handler b = new Handler(Looper.getMainLooper(), new a());
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private c f10574c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private c f10575d;

    /* loaded from: classes2.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.d((c) message.obj);
            return true;
        }
    }

    /* renamed from: e.j.a.c.b0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0350b {
        void a(int i2);

        void show();
    }

    /* loaded from: classes2.dex */
    public static class c {
        @NonNull
        public final WeakReference<InterfaceC0350b> a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f10576c;

        public c(int i2, InterfaceC0350b interfaceC0350b) {
            this.a = new WeakReference<>(interfaceC0350b);
            this.b = i2;
        }

        public boolean a(@Nullable InterfaceC0350b interfaceC0350b) {
            return interfaceC0350b != null && this.a.get() == interfaceC0350b;
        }
    }

    private b() {
    }

    private boolean a(@NonNull c cVar, int i2) {
        InterfaceC0350b interfaceC0350b = cVar.a.get();
        if (interfaceC0350b != null) {
            this.b.removeCallbacksAndMessages(cVar);
            interfaceC0350b.a(i2);
            return true;
        }
        return false;
    }

    public static b c() {
        if (f10573h == null) {
            f10573h = new b();
        }
        return f10573h;
    }

    private boolean g(InterfaceC0350b interfaceC0350b) {
        c cVar = this.f10574c;
        return cVar != null && cVar.a(interfaceC0350b);
    }

    private boolean h(InterfaceC0350b interfaceC0350b) {
        c cVar = this.f10575d;
        return cVar != null && cVar.a(interfaceC0350b);
    }

    private void m(@NonNull c cVar) {
        int i2 = cVar.b;
        if (i2 == -2) {
            return;
        }
        if (i2 <= 0) {
            i2 = i2 == -1 ? 1500 : f10572g;
        }
        this.b.removeCallbacksAndMessages(cVar);
        Handler handler = this.b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i2);
    }

    private void o() {
        c cVar = this.f10575d;
        if (cVar != null) {
            this.f10574c = cVar;
            this.f10575d = null;
            InterfaceC0350b interfaceC0350b = cVar.a.get();
            if (interfaceC0350b != null) {
                interfaceC0350b.show();
            } else {
                this.f10574c = null;
            }
        }
    }

    public void b(InterfaceC0350b interfaceC0350b, int i2) {
        synchronized (this.a) {
            if (g(interfaceC0350b)) {
                a(this.f10574c, i2);
            } else if (h(interfaceC0350b)) {
                a(this.f10575d, i2);
            }
        }
    }

    public void d(@NonNull c cVar) {
        synchronized (this.a) {
            if (this.f10574c == cVar || this.f10575d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(InterfaceC0350b interfaceC0350b) {
        boolean g2;
        synchronized (this.a) {
            g2 = g(interfaceC0350b);
        }
        return g2;
    }

    public boolean f(InterfaceC0350b interfaceC0350b) {
        boolean z;
        synchronized (this.a) {
            z = g(interfaceC0350b) || h(interfaceC0350b);
        }
        return z;
    }

    public void i(InterfaceC0350b interfaceC0350b) {
        synchronized (this.a) {
            if (g(interfaceC0350b)) {
                this.f10574c = null;
                if (this.f10575d != null) {
                    o();
                }
            }
        }
    }

    public void j(InterfaceC0350b interfaceC0350b) {
        synchronized (this.a) {
            if (g(interfaceC0350b)) {
                m(this.f10574c);
            }
        }
    }

    public void k(InterfaceC0350b interfaceC0350b) {
        synchronized (this.a) {
            if (g(interfaceC0350b)) {
                c cVar = this.f10574c;
                if (!cVar.f10576c) {
                    cVar.f10576c = true;
                    this.b.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void l(InterfaceC0350b interfaceC0350b) {
        synchronized (this.a) {
            if (g(interfaceC0350b)) {
                c cVar = this.f10574c;
                if (cVar.f10576c) {
                    cVar.f10576c = false;
                    m(cVar);
                }
            }
        }
    }

    public void n(int i2, InterfaceC0350b interfaceC0350b) {
        synchronized (this.a) {
            if (g(interfaceC0350b)) {
                c cVar = this.f10574c;
                cVar.b = i2;
                this.b.removeCallbacksAndMessages(cVar);
                m(this.f10574c);
                return;
            }
            if (h(interfaceC0350b)) {
                this.f10575d.b = i2;
            } else {
                this.f10575d = new c(i2, interfaceC0350b);
            }
            c cVar2 = this.f10574c;
            if (cVar2 == null || !a(cVar2, 4)) {
                this.f10574c = null;
                o();
            }
        }
    }
}
