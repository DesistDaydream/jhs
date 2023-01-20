package e.j.d.b.a;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public interface a {

    @e.j.a.b.c.m.a
    /* renamed from: e.j.d.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0375a {
        @e.j.a.b.c.m.a
        void a();

        @e.j.a.b.c.m.a
        void b(Set<String> set);

        @e.j.a.b.c.m.a
        void unregister();
    }

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public interface b {
        @e.j.a.b.c.m.a
        void a(int i2, @Nullable Bundle bundle);
    }

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public static class c {
        @e.j.a.b.c.m.a
        public String a;
        @e.j.a.b.c.m.a
        public String b;
        @e.j.a.b.c.m.a

        /* renamed from: c  reason: collision with root package name */
        public Object f11194c;
        @e.j.a.b.c.m.a

        /* renamed from: d  reason: collision with root package name */
        public String f11195d;
        @e.j.a.b.c.m.a

        /* renamed from: e  reason: collision with root package name */
        public long f11196e;
        @e.j.a.b.c.m.a

        /* renamed from: f  reason: collision with root package name */
        public String f11197f;
        @e.j.a.b.c.m.a

        /* renamed from: g  reason: collision with root package name */
        public Bundle f11198g;
        @e.j.a.b.c.m.a

        /* renamed from: h  reason: collision with root package name */
        public String f11199h;
        @e.j.a.b.c.m.a

        /* renamed from: i  reason: collision with root package name */
        public Bundle f11200i;
        @e.j.a.b.c.m.a

        /* renamed from: j  reason: collision with root package name */
        public long f11201j;
        @e.j.a.b.c.m.a

        /* renamed from: k  reason: collision with root package name */
        public String f11202k;
        @e.j.a.b.c.m.a

        /* renamed from: l  reason: collision with root package name */
        public Bundle f11203l;
        @e.j.a.b.c.m.a

        /* renamed from: m  reason: collision with root package name */
        public long f11204m;
        @e.j.a.b.c.m.a
        public boolean n;
        @e.j.a.b.c.m.a
        public long o;
    }

    @e.j.a.b.c.m.a
    void a(@NonNull c cVar);

    @e.j.a.b.c.m.a
    void b(@NonNull String str, @NonNull String str2, Bundle bundle);

    @e.j.a.b.c.m.a
    void c(@NonNull String str, @NonNull String str2, Object obj);

    @e.j.a.b.c.m.a
    @WorkerThread
    Map<String, Object> d(boolean z);

    @e.j.a.b.c.m.a
    @WorkerThread
    int e(@NonNull @Size(min = 1) String str);

    @e.j.a.b.c.m.a
    void f(@NonNull @Size(max = 24, min = 1) String str, @Nullable String str2, @Nullable Bundle bundle);

    @e.j.a.b.c.m.a
    @WorkerThread
    List<c> g(@NonNull String str, @Nullable @Size(max = 23, min = 1) String str2);

    @e.j.a.b.c.m.a
    InterfaceC0375a h(String str, b bVar);
}
