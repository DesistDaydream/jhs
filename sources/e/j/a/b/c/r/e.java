package e.j.a.b.c.r;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.zzb;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import e.j.a.b.c.r.m;
import e.j.a.b.c.r.s;
import e.j.a.b.c.r.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public abstract class e<T extends IInterface> {
    @e.j.a.b.c.m.a
    public static final int B = 1;
    @e.j.a.b.c.m.a
    public static final int C = 4;
    @e.j.a.b.c.m.a
    public static final int D = 5;
    @e.j.a.b.c.m.a
    public static final String F = "pendingIntent";
    @e.j.a.b.c.m.a
    public static final String G = "<<default account>>";
    @e.j.a.b.c.x.d0
    public AtomicInteger A;
    private int a;
    private long b;

    /* renamed from: c */
    private long f10379c;

    /* renamed from: d */
    private int f10380d;

    /* renamed from: e */
    private long f10381e;
    @e.j.a.b.c.x.d0

    /* renamed from: f */
    private f1 f10382f;

    /* renamed from: g */
    private final Context f10383g;

    /* renamed from: h */
    private final Looper f10384h;

    /* renamed from: i */
    private final m f10385i;

    /* renamed from: j */
    private final e.j.a.b.c.f f10386j;

    /* renamed from: k */
    public final Handler f10387k;

    /* renamed from: l */
    private final Object f10388l;

    /* renamed from: m */
    private final Object f10389m;
    @GuardedBy("mServiceBrokerLock")
    private t n;
    @e.j.a.b.c.x.d0
    public c o;
    @GuardedBy("mLock")
    private T p;
    private final ArrayList<h<?>> q;
    @GuardedBy("mLock")
    private j r;
    @GuardedBy("mLock")
    private int s;
    private final a t;
    private final b u;
    private final int v;
    private final String w;
    private ConnectionResult x;
    private boolean y;
    private volatile zzb z;
    private static final Feature[] E = new Feature[0];
    @e.j.a.b.c.m.a
    public static final String[] H = {"service_esmobile", "service_googleme"};

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public interface a {
        @e.j.a.b.c.m.a
        void a(@Nullable Bundle bundle);

        @e.j.a.b.c.m.a
        void onConnectionSuspended(int i2);
    }

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public interface b {
        void c(@NonNull ConnectionResult connectionResult);
    }

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public interface c {
        @e.j.a.b.c.m.a
        void a(@NonNull ConnectionResult connectionResult);
    }

    /* loaded from: classes2.dex */
    public class d implements c {
        @e.j.a.b.c.m.a
        public d() {
            e.this = r1;
        }

        @Override // e.j.a.b.c.r.e.c
        public void a(@NonNull ConnectionResult connectionResult) {
            if (!connectionResult.isSuccess()) {
                if (e.this.u != null) {
                    e.this.u.c(connectionResult);
                    return;
                }
                return;
            }
            e eVar = e.this;
            eVar.m(null, eVar.E());
        }
    }

    @e.j.a.b.c.m.a
    /* renamed from: e.j.a.b.c.r.e$e */
    /* loaded from: classes2.dex */
    public interface InterfaceC0339e {
        @e.j.a.b.c.m.a
        void a();
    }

    /* loaded from: classes2.dex */
    public abstract class f extends h<Boolean> {

        /* renamed from: d */
        private final int f10390d;

        /* renamed from: e */
        private final Bundle f10391e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @BinderThread
        public f(int i2, Bundle bundle) {
            super(Boolean.TRUE);
            e.this = r2;
            this.f10390d = i2;
            this.f10391e = bundle;
        }

        @Override // e.j.a.b.c.r.e.h
        public final /* synthetic */ void c(Boolean bool) {
            if (bool == null) {
                e.this.S(1, null);
                return;
            }
            int i2 = this.f10390d;
            if (i2 == 0) {
                if (g()) {
                    return;
                }
                e.this.S(1, null);
                f(new ConnectionResult(8, null));
            } else if (i2 != 10) {
                e.this.S(1, null);
                Bundle bundle = this.f10391e;
                f(new ConnectionResult(this.f10390d, bundle != null ? (PendingIntent) bundle.getParcelable(e.F) : null));
            } else {
                e.this.S(1, null);
                throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", getClass().getSimpleName(), e.this.c(), e.this.q()));
            }
        }

        @Override // e.j.a.b.c.r.e.h
        public final void d() {
        }

        public abstract void f(ConnectionResult connectionResult);

        public abstract boolean g();
    }

    /* loaded from: classes2.dex */
    public final class g extends e.j.a.b.f.b.e {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Looper looper) {
            super(looper);
            e.this = r1;
        }

        private static void a(Message message) {
            h hVar = (h) message.obj;
            hVar.d();
            hVar.b();
        }

        private static boolean b(Message message) {
            int i2 = message.what;
            return i2 == 2 || i2 == 1 || i2 == 7;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ConnectionResult connectionResult;
            ConnectionResult connectionResult2;
            if (e.this.A.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                    return;
                }
                return;
            }
            int i2 = message.what;
            if ((i2 == 1 || i2 == 7 || ((i2 == 4 && !e.this.y()) || message.what == 5)) && !e.this.isConnecting()) {
                a(message);
                return;
            }
            int i3 = message.what;
            if (i3 == 4) {
                e.this.x = new ConnectionResult(message.arg2);
                if (!e.this.i0() || e.this.y) {
                    if (e.this.x != null) {
                        connectionResult2 = e.this.x;
                    } else {
                        connectionResult2 = new ConnectionResult(8);
                    }
                    e.this.o.a(connectionResult2);
                    e.this.I(connectionResult2);
                    return;
                }
                e.this.S(3, null);
            } else if (i3 == 5) {
                if (e.this.x != null) {
                    connectionResult = e.this.x;
                } else {
                    connectionResult = new ConnectionResult(8);
                }
                e.this.o.a(connectionResult);
                e.this.I(connectionResult);
            } else if (i3 == 3) {
                Object obj = message.obj;
                ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
                e.this.o.a(connectionResult3);
                e.this.I(connectionResult3);
            } else if (i3 == 6) {
                e.this.S(5, null);
                if (e.this.t != null) {
                    e.this.t.onConnectionSuspended(message.arg2);
                }
                e.this.J(message.arg2);
                e.this.X(5, 1, null);
            } else if (i3 == 2 && !e.this.isConnected()) {
                a(message);
            } else if (b(message)) {
                ((h) message.obj).e();
            } else {
                int i4 = message.what;
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i4);
                Log.wtf("GmsClient", sb.toString(), new Exception());
            }
        }
    }

    /* loaded from: classes2.dex */
    public abstract class h<TListener> {
        private TListener a;
        private boolean b = false;

        public h(TListener tlistener) {
            e.this = r1;
            this.a = tlistener;
        }

        public final void a() {
            synchronized (this) {
                this.a = null;
            }
        }

        public final void b() {
            a();
            synchronized (e.this.q) {
                e.this.q.remove(this);
            }
        }

        public abstract void c(TListener tlistener);

        public abstract void d();

        public final void e() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.a;
                if (this.b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    c(tlistener);
                } catch (RuntimeException e2) {
                    d();
                    throw e2;
                }
            } else {
                d();
            }
            synchronized (this) {
                this.b = true;
            }
            b();
        }
    }

    @e.j.a.b.c.x.d0
    /* loaded from: classes2.dex */
    public static final class i extends s.a {
        private e b;

        /* renamed from: c */
        private final int f10394c;

        public i(@NonNull e eVar, int i2) {
            this.b = eVar;
            this.f10394c = i2;
        }

        @Override // e.j.a.b.c.r.s
        @BinderThread
        public final void g(int i2, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            a0.l(this.b, "onPostInitComplete can be called only once per call to getRemoteService");
            this.b.K(i2, iBinder, bundle, this.f10394c);
            this.b = null;
        }

        @Override // e.j.a.b.c.r.s
        @BinderThread
        public final void o(int i2, @NonNull IBinder iBinder, @NonNull zzb zzbVar) {
            a0.l(this.b, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            a0.k(zzbVar);
            this.b.W(zzbVar);
            g(i2, iBinder, zzbVar.zzda);
        }

        @Override // e.j.a.b.c.r.s
        @BinderThread
        public final void q(int i2, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }
    }

    @e.j.a.b.c.x.d0
    /* loaded from: classes2.dex */
    public final class j implements ServiceConnection {
        private final int a;

        public j(int i2) {
            e.this = r1;
            this.a = i2;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            t c0342a;
            if (iBinder == null) {
                e.this.Z(16);
                return;
            }
            synchronized (e.this.f10389m) {
                e eVar = e.this;
                if (iBinder == null) {
                    c0342a = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (queryLocalInterface != null && (queryLocalInterface instanceof t)) {
                        c0342a = (t) queryLocalInterface;
                    } else {
                        c0342a = new t.a.C0342a(iBinder);
                    }
                }
                eVar.n = c0342a;
            }
            e.this.R(0, null, this.a);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (e.this.f10389m) {
                e.this.n = null;
            }
            Handler handler = e.this.f10387k;
            handler.sendMessage(handler.obtainMessage(6, this.a, 1));
        }
    }

    /* loaded from: classes2.dex */
    public final class k extends f {

        /* renamed from: g */
        private final IBinder f10395g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @BinderThread
        public k(int i2, IBinder iBinder, Bundle bundle) {
            super(i2, bundle);
            e.this = r1;
            this.f10395g = iBinder;
        }

        @Override // e.j.a.b.c.r.e.f
        public final void f(ConnectionResult connectionResult) {
            if (e.this.u != null) {
                e.this.u.c(connectionResult);
            }
            e.this.I(connectionResult);
        }

        @Override // e.j.a.b.c.r.e.f
        public final boolean g() {
            try {
                String interfaceDescriptor = this.f10395g.getInterfaceDescriptor();
                if (!e.this.q().equals(interfaceDescriptor)) {
                    String q = e.this.q();
                    StringBuilder sb = new StringBuilder(String.valueOf(q).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(q);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface r = e.this.r(this.f10395g);
                if (r == null || !(e.this.X(2, 4, r) || e.this.X(3, 4, r))) {
                    return false;
                }
                e.this.x = null;
                Bundle l2 = e.this.l();
                if (e.this.t != null) {
                    e.this.t.a(l2);
                    return true;
                }
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class l extends f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @BinderThread
        public l(int i2, @Nullable Bundle bundle) {
            super(i2, null);
            e.this = r1;
        }

        @Override // e.j.a.b.c.r.e.f
        public final void f(ConnectionResult connectionResult) {
            if (e.this.y() && e.this.i0()) {
                e.this.Z(16);
                return;
            }
            e.this.o.a(connectionResult);
            e.this.I(connectionResult);
        }

        @Override // e.j.a.b.c.r.e.f
        public final boolean g() {
            e.this.o.a(ConnectionResult.RESULT_SUCCESS);
            return true;
        }
    }

    @e.j.a.b.c.m.a
    public e(Context context, Looper looper, int i2, a aVar, b bVar, String str) {
        this(context, looper, m.a(context), e.j.a.b.c.f.i(), i2, (a) a0.k(aVar), (b) a0.k(bVar), str);
    }

    public final void S(int i2, T t) {
        f1 f1Var;
        f1 f1Var2;
        a0.a((i2 == 4) == (t != null));
        synchronized (this.f10388l) {
            this.s = i2;
            this.p = t;
            L(i2, t);
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    if (this.r != null && (f1Var2 = this.f10382f) != null) {
                        String c2 = f1Var2.c();
                        String a2 = this.f10382f.a();
                        StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 70 + String.valueOf(a2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(c2);
                        sb.append(" on ");
                        sb.append(a2);
                        Log.e("GmsClient", sb.toString());
                        this.f10385i.b(this.f10382f.c(), this.f10382f.a(), this.f10382f.b(), this.r, g0());
                        this.A.incrementAndGet();
                    }
                    this.r = new j(this.A.get());
                    if (this.s == 3 && C() != null) {
                        f1Var = new f1(getContext().getPackageName(), C(), true, ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED);
                    } else {
                        f1Var = new f1(G(), c(), false, ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED);
                    }
                    this.f10382f = f1Var;
                    if (!this.f10385i.c(new m.a(f1Var.c(), this.f10382f.a(), this.f10382f.b()), this.r, g0())) {
                        String c3 = this.f10382f.c();
                        String a3 = this.f10382f.a();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(c3).length() + 34 + String.valueOf(a3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(c3);
                        sb2.append(" on ");
                        sb2.append(a3);
                        Log.e("GmsClient", sb2.toString());
                        R(16, null, this.A.get());
                    }
                } else if (i2 == 4) {
                    H(t);
                }
            } else if (this.r != null) {
                this.f10385i.b(this.f10382f.c(), this.f10382f.a(), this.f10382f.b(), this.r, g0());
                this.r = null;
            }
        }
    }

    public final void W(zzb zzbVar) {
        this.z = zzbVar;
    }

    public final boolean X(int i2, int i3, T t) {
        synchronized (this.f10388l) {
            if (this.s != i2) {
                return false;
            }
            S(i3, t);
            return true;
        }
    }

    public final void Z(int i2) {
        int i3;
        if (h0()) {
            i3 = 5;
            this.y = true;
        } else {
            i3 = 4;
        }
        Handler handler = this.f10387k;
        handler.sendMessage(handler.obtainMessage(i3, this.A.get(), 16));
    }

    @Nullable
    private final String g0() {
        String str = this.w;
        return str == null ? this.f10383g.getClass().getName() : str;
    }

    private final boolean h0() {
        boolean z;
        synchronized (this.f10388l) {
            z = this.s == 3;
        }
        return z;
    }

    public final boolean i0() {
        if (this.y || TextUtils.isEmpty(q()) || TextUtils.isEmpty(C())) {
            return false;
        }
        try {
            Class.forName(q());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @e.j.a.b.c.m.a
    public Feature[] A() {
        return E;
    }

    @e.j.a.b.c.m.a
    public Bundle B() {
        return new Bundle();
    }

    @Nullable
    @e.j.a.b.c.m.a
    public String C() {
        return null;
    }

    @e.j.a.b.c.m.a
    public final Looper D() {
        return this.f10384h;
    }

    @e.j.a.b.c.m.a
    public Set<Scope> E() {
        return Collections.EMPTY_SET;
    }

    @e.j.a.b.c.m.a
    public final T F() throws DeadObjectException {
        T t;
        synchronized (this.f10388l) {
            if (this.s != 5) {
                x();
                a0.r(this.p != null, "Client is connected but service is null");
                t = this.p;
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    @e.j.a.b.c.m.a
    public String G() {
        return "com.google.android.gms";
    }

    @e.j.a.b.c.m.a
    @CallSuper
    public void H(@NonNull T t) {
        this.f10379c = System.currentTimeMillis();
    }

    @e.j.a.b.c.m.a
    @CallSuper
    public void I(ConnectionResult connectionResult) {
        this.f10380d = connectionResult.getErrorCode();
        this.f10381e = System.currentTimeMillis();
    }

    @e.j.a.b.c.m.a
    @CallSuper
    public void J(int i2) {
        this.a = i2;
        this.b = System.currentTimeMillis();
    }

    @e.j.a.b.c.m.a
    public void K(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.f10387k;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new k(i2, iBinder, bundle)));
    }

    @e.j.a.b.c.m.a
    public void L(int i2, T t) {
    }

    @e.j.a.b.c.m.a
    public void M(int i2) {
        Handler handler = this.f10387k;
        handler.sendMessage(handler.obtainMessage(6, this.A.get(), i2));
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.x.d0
    public void N(@NonNull c cVar, int i2, @Nullable PendingIntent pendingIntent) {
        this.o = (c) a0.l(cVar, "Connection progress callbacks cannot be null.");
        Handler handler = this.f10387k;
        handler.sendMessage(handler.obtainMessage(3, this.A.get(), i2, pendingIntent));
    }

    public final void R(int i2, @Nullable Bundle bundle, int i3) {
        Handler handler = this.f10387k;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(i2, null)));
    }

    @NonNull
    @e.j.a.b.c.m.a
    public abstract String c();

    @e.j.a.b.c.m.a
    public void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i2;
        T t;
        t tVar;
        synchronized (this.f10388l) {
            i2 = this.s;
            t = this.p;
        }
        synchronized (this.f10389m) {
            tVar = this.n;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i2 == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i2 == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i2 == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i2 == 4) {
            printWriter.print("CONNECTED");
        } else if (i2 != 5) {
            printWriter.print(GrsBaseInfo.CountryCodeSource.UNKNOWN);
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append((CharSequence) q()).append(TIMMentionEditText.TIM_MENTION_TAG).append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (tVar == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(tVar.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f10379c > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j2 = this.f10379c;
            String format = simpleDateFormat.format(new Date(this.f10379c));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j2);
            sb.append(ExpandableTextView.N);
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.b > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i3 = this.a;
            if (i3 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i3 != 2) {
                printWriter.append((CharSequence) String.valueOf(i3));
            } else {
                printWriter.append("CAUSE_NETWORK_LOST");
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j3 = this.b;
            String format2 = simpleDateFormat.format(new Date(this.b));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j3);
            sb2.append(ExpandableTextView.N);
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.f10381e > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) e.j.a.b.c.n.f.a(this.f10380d));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j4 = this.f10381e;
            String format3 = simpleDateFormat.format(new Date(this.f10381e));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j4);
            sb3.append(ExpandableTextView.N);
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    @e.j.a.b.c.m.a
    public void disconnect() {
        this.A.incrementAndGet();
        synchronized (this.q) {
            int size = this.q.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.q.get(i2).a();
            }
            this.q.clear();
        }
        synchronized (this.f10389m) {
            this.n = null;
        }
        S(1, null);
    }

    @e.j.a.b.c.m.a
    public boolean e() {
        return false;
    }

    @e.j.a.b.c.m.a
    public boolean f() {
        return false;
    }

    @e.j.a.b.c.m.a
    public String g() {
        f1 f1Var;
        if (isConnected() && (f1Var = this.f10382f) != null) {
            return f1Var.a();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @e.j.a.b.c.m.a
    public final Context getContext() {
        return this.f10383g;
    }

    @e.j.a.b.c.m.a
    public void h(@NonNull c cVar) {
        this.o = (c) a0.l(cVar, "Connection progress callbacks cannot be null.");
        S(2, null);
    }

    @e.j.a.b.c.m.a
    public boolean i() {
        return true;
    }

    @e.j.a.b.c.m.a
    public boolean isConnected() {
        boolean z;
        synchronized (this.f10388l) {
            z = this.s == 4;
        }
        return z;
    }

    @e.j.a.b.c.m.a
    public boolean isConnecting() {
        boolean z;
        synchronized (this.f10388l) {
            int i2 = this.s;
            z = i2 == 2 || i2 == 3;
        }
        return z;
    }

    @e.j.a.b.c.m.a
    public boolean j() {
        return false;
    }

    @Nullable
    @e.j.a.b.c.m.a
    public IBinder k() {
        synchronized (this.f10389m) {
            t tVar = this.n;
            if (tVar == null) {
                return null;
            }
            return tVar.asBinder();
        }
    }

    @e.j.a.b.c.m.a
    public Bundle l() {
        return null;
    }

    @e.j.a.b.c.m.a
    @WorkerThread
    public void m(q qVar, Set<Scope> set) {
        Bundle B2 = B();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.v);
        getServiceRequest.zzy = this.f10383g.getPackageName();
        getServiceRequest.zzdk = B2;
        if (set != null) {
            getServiceRequest.zzdj = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (j()) {
            getServiceRequest.zzdl = z() != null ? z() : new Account("<<default account>>", e.j.a.b.c.r.b.a);
            if (qVar != null) {
                getServiceRequest.zzdi = qVar.asBinder();
            }
        } else if (e()) {
            getServiceRequest.zzdl = z();
        }
        getServiceRequest.zzdm = E;
        getServiceRequest.zzdn = A();
        try {
            synchronized (this.f10389m) {
                t tVar = this.n;
                if (tVar != null) {
                    tVar.l(new i(this, this.A.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            M(1);
        } catch (RemoteException e3) {
            e = e3;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            K(8, null, null, this.A.get());
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            K(8, null, null, this.A.get());
        }
    }

    @e.j.a.b.c.m.a
    public void p(@NonNull InterfaceC0339e interfaceC0339e) {
        interfaceC0339e.a();
    }

    @NonNull
    @e.j.a.b.c.m.a
    public abstract String q();

    @Nullable
    @e.j.a.b.c.m.a
    public abstract T r(IBinder iBinder);

    @e.j.a.b.c.m.a
    public int s() {
        return e.j.a.b.c.f.a;
    }

    @Nullable
    @e.j.a.b.c.m.a
    public final Feature[] u() {
        zzb zzbVar = this.z;
        if (zzbVar == null) {
            return null;
        }
        return zzbVar.zzdb;
    }

    @e.j.a.b.c.m.a
    public Intent v() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @e.j.a.b.c.m.a
    public void w() {
        int k2 = this.f10386j.k(this.f10383g, s());
        if (k2 != 0) {
            S(1, null);
            N(new d(), k2, null);
            return;
        }
        h(new d());
    }

    @e.j.a.b.c.m.a
    public final void x() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @e.j.a.b.c.m.a
    public boolean y() {
        return false;
    }

    @e.j.a.b.c.m.a
    public Account z() {
        return null;
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.x.d0
    public e(Context context, Looper looper, m mVar, e.j.a.b.c.f fVar, int i2, a aVar, b bVar, String str) {
        this.f10388l = new Object();
        this.f10389m = new Object();
        this.q = new ArrayList<>();
        this.s = 1;
        this.x = null;
        this.y = false;
        this.z = null;
        this.A = new AtomicInteger(0);
        this.f10383g = (Context) a0.l(context, "Context must not be null");
        this.f10384h = (Looper) a0.l(looper, "Looper must not be null");
        this.f10385i = (m) a0.l(mVar, "Supervisor must not be null");
        this.f10386j = (e.j.a.b.c.f) a0.l(fVar, "API availability must not be null");
        this.f10387k = new g(looper);
        this.v = i2;
        this.t = aVar;
        this.u = bVar;
        this.w = str;
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.x.d0
    public e(Context context, Handler handler, m mVar, e.j.a.b.c.f fVar, int i2, a aVar, b bVar) {
        this.f10388l = new Object();
        this.f10389m = new Object();
        this.q = new ArrayList<>();
        this.s = 1;
        this.x = null;
        this.y = false;
        this.z = null;
        this.A = new AtomicInteger(0);
        this.f10383g = (Context) a0.l(context, "Context must not be null");
        this.f10387k = (Handler) a0.l(handler, "Handler must not be null");
        this.f10384h = handler.getLooper();
        this.f10385i = (m) a0.l(mVar, "Supervisor must not be null");
        this.f10386j = (e.j.a.b.c.f) a0.l(fVar, "API availability must not be null");
        this.v = i2;
        this.t = aVar;
        this.u = bVar;
        this.w = null;
    }
}
