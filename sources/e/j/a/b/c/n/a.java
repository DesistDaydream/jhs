package e.j.a.b.c.n;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import e.j.a.b.c.n.a.d;
import e.j.a.b.c.n.i;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.e;
import e.j.a.b.c.x.d0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class a<O extends d> {
    private final AbstractC0333a<?, O> a;
    private final i<?, O> b;

    /* renamed from: c  reason: collision with root package name */
    private final g<?> f10159c;

    /* renamed from: d  reason: collision with root package name */
    private final j<?> f10160d;

    /* renamed from: e  reason: collision with root package name */
    private final String f10161e;

    @e.j.a.b.c.m.a
    @d0
    /* renamed from: e.j.a.b.c.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0333a<T extends f, O> extends e<T, O> {
        @e.j.a.b.c.m.a
        public abstract T c(Context context, Looper looper, e.j.a.b.c.r.f fVar, O o, i.b bVar, i.c cVar);
    }

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public interface b {
    }

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public static class c<C extends b> {
    }

    /* loaded from: classes2.dex */
    public interface d {

        /* renamed from: e.j.a.b.c.n.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public interface InterfaceC0334a extends c, e {
            Account getAccount();
        }

        /* loaded from: classes2.dex */
        public interface b extends c {
            GoogleSignInAccount j();
        }

        /* loaded from: classes2.dex */
        public interface c extends d {
        }

        /* renamed from: e.j.a.b.c.n.a$d$d  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0335d implements e {
            private C0335d() {
            }
        }

        /* loaded from: classes2.dex */
        public interface e extends d {
        }

        /* loaded from: classes2.dex */
        public interface f extends c, e {
        }
    }

    @e.j.a.b.c.m.a
    @d0
    /* loaded from: classes2.dex */
    public static abstract class e<T extends b, O> {
        @e.j.a.b.c.m.a
        public static final int a = 1;
        @e.j.a.b.c.m.a
        public static final int b = 2;
        @e.j.a.b.c.m.a

        /* renamed from: c  reason: collision with root package name */
        public static final int f10162c = Integer.MAX_VALUE;

        @e.j.a.b.c.m.a
        public List<Scope> a(O o) {
            return Collections.emptyList();
        }

        @e.j.a.b.c.m.a
        public int b() {
            return Integer.MAX_VALUE;
        }
    }

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public interface f extends b {
        @e.j.a.b.c.m.a
        Feature[] a();

        @e.j.a.b.c.m.a
        void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        @e.j.a.b.c.m.a
        void disconnect();

        @e.j.a.b.c.m.a
        boolean e();

        @e.j.a.b.c.m.a
        boolean f();

        @e.j.a.b.c.m.a
        String g();

        @e.j.a.b.c.m.a
        void h(e.c cVar);

        @e.j.a.b.c.m.a
        boolean i();

        @e.j.a.b.c.m.a
        boolean isConnected();

        @e.j.a.b.c.m.a
        boolean isConnecting();

        @e.j.a.b.c.m.a
        boolean j();

        @Nullable
        @e.j.a.b.c.m.a
        IBinder k();

        @e.j.a.b.c.m.a
        void m(e.j.a.b.c.r.q qVar, Set<Scope> set);

        @e.j.a.b.c.m.a
        void p(e.InterfaceC0339e interfaceC0339e);

        @e.j.a.b.c.m.a
        int s();

        @e.j.a.b.c.m.a
        Feature[] u();

        @e.j.a.b.c.m.a
        Intent v();
    }

    @e.j.a.b.c.m.a
    @d0
    /* loaded from: classes2.dex */
    public static final class g<C extends f> extends c<C> {
    }

    /* loaded from: classes2.dex */
    public interface h<T extends IInterface> extends b {
        String c();

        Context getContext();

        void o(int i2, T t);

        String q();

        T r(IBinder iBinder);
    }

    @d0
    /* loaded from: classes2.dex */
    public static abstract class i<T extends h, O> extends e<T, O> {
    }

    @d0
    /* loaded from: classes2.dex */
    public static final class j<C extends h> extends c<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(String str, AbstractC0333a<C, O> abstractC0333a, g<C> gVar) {
        a0.l(abstractC0333a, "Cannot construct an Api with a null ClientBuilder");
        a0.l(gVar, "Cannot construct an Api with a null ClientKey");
        this.f10161e = str;
        this.a = abstractC0333a;
        this.b = null;
        this.f10159c = gVar;
        this.f10160d = null;
    }

    public final c<?> a() {
        g<?> gVar = this.f10159c;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    public final String b() {
        return this.f10161e;
    }

    public final e<?, O> c() {
        return this.a;
    }

    public final AbstractC0333a<?, O> d() {
        a0.r(this.a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.a;
    }
}
