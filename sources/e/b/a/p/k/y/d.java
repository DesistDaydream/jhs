package e.b.a.p.k.y;

import e.b.a.p.k.y.a;
import java.io.File;

/* loaded from: classes.dex */
public class d implements a.InterfaceC0310a {

    /* renamed from: c  reason: collision with root package name */
    private final long f9638c;

    /* renamed from: d  reason: collision with root package name */
    private final c f9639d;

    /* loaded from: classes.dex */
    public class a implements c {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // e.b.a.p.k.y.d.c
        public File a() {
            return new File(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class b implements c {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // e.b.a.p.k.y.d.c
        public File a() {
            return new File(this.a, this.b);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        File a();
    }

    public d(String str, long j2) {
        this(new a(str), j2);
    }

    @Override // e.b.a.p.k.y.a.InterfaceC0310a
    public e.b.a.p.k.y.a build() {
        File a2 = this.f9639d.a();
        if (a2 == null) {
            return null;
        }
        if (a2.isDirectory() || a2.mkdirs()) {
            return e.c(a2, this.f9638c);
        }
        return null;
    }

    public d(String str, String str2, long j2) {
        this(new b(str, str2), j2);
    }

    public d(c cVar, long j2) {
        this.f9638c = j2;
        this.f9639d = cVar;
    }
}
