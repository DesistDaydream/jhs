package e.j.a.b.c.n.u;

import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.b.c.n.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public class a3 extends c3 {

    /* renamed from: f */
    private final SparseArray<a> f10195f;

    /* loaded from: classes2.dex */
    public class a implements i.c {
        public final int a;
        public final e.j.a.b.c.n.i b;

        /* renamed from: c */
        public final i.c f10196c;

        public a(int i2, e.j.a.b.c.n.i iVar, i.c cVar) {
            a3.this = r1;
            this.a = i2;
            this.b = iVar;
            this.f10196c = cVar;
            iVar.B(this);
        }

        @Override // e.j.a.b.c.n.i.c
        public final void c(@NonNull ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(valueOf);
            Log.d("AutoManageHelper", sb.toString());
            a3.this.n(connectionResult, this.a);
        }
    }

    private a3(k kVar) {
        super(kVar);
        this.f10195f = new SparseArray<>();
        this.a.a("AutoManageHelper", this);
    }

    public static a3 q(j jVar) {
        k d2 = LifecycleCallback.d(jVar);
        a3 a3Var = (a3) d2.e("AutoManageHelper", a3.class);
        return a3Var != null ? a3Var : new a3(d2);
    }

    @Nullable
    private final a t(int i2) {
        if (this.f10195f.size() <= i2) {
            return null;
        }
        SparseArray<a> sparseArray = this.f10195f;
        return sparseArray.get(sparseArray.keyAt(i2));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i2 = 0; i2 < this.f10195f.size(); i2++) {
            a t = t(i2);
            if (t != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(t.a);
                printWriter.println(Constants.COLON_SEPARATOR);
                t.b.j(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // e.j.a.b.c.n.u.c3, com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        boolean z = this.b;
        String valueOf = String.valueOf(this.f10195f);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(ExpandableTextView.N);
        sb.append(valueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.f10207c.get() == null) {
            for (int i2 = 0; i2 < this.f10195f.size(); i2++) {
                a t = t(i2);
                if (t != null) {
                    t.b.g();
                }
            }
        }
    }

    @Override // e.j.a.b.c.n.u.c3, com.google.android.gms.common.api.internal.LifecycleCallback
    public void k() {
        super.k();
        for (int i2 = 0; i2 < this.f10195f.size(); i2++) {
            a t = t(i2);
            if (t != null) {
                t.b.i();
            }
        }
    }

    @Override // e.j.a.b.c.n.u.c3
    public final void m(ConnectionResult connectionResult, int i2) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i2 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        a aVar = this.f10195f.get(i2);
        if (aVar != null) {
            r(i2);
            i.c cVar = aVar.f10196c;
            if (cVar != null) {
                cVar.c(connectionResult);
            }
        }
    }

    @Override // e.j.a.b.c.n.u.c3
    public final void o() {
        for (int i2 = 0; i2 < this.f10195f.size(); i2++) {
            a t = t(i2);
            if (t != null) {
                t.b.g();
            }
        }
    }

    public final void r(int i2) {
        a aVar = this.f10195f.get(i2);
        this.f10195f.remove(i2);
        if (aVar != null) {
            aVar.b.F(aVar);
            aVar.b.i();
        }
    }

    public final void s(int i2, e.j.a.b.c.n.i iVar, i.c cVar) {
        e.j.a.b.c.r.a0.l(iVar, "GoogleApiClient instance cannot be null");
        boolean z = this.f10195f.indexOfKey(i2) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i2);
        e.j.a.b.c.r.a0.r(z, sb.toString());
        d3 d3Var = this.f10207c.get();
        boolean z2 = this.b;
        String valueOf = String.valueOf(d3Var);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i2);
        sb2.append(ExpandableTextView.N);
        sb2.append(z2);
        sb2.append(ExpandableTextView.N);
        sb2.append(valueOf);
        Log.d("AutoManageHelper", sb2.toString());
        this.f10195f.put(i2, new a(i2, iVar, cVar));
        if (this.b && d3Var == null) {
            String valueOf2 = String.valueOf(iVar);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 11);
            sb3.append("connecting ");
            sb3.append(valueOf2);
            Log.d("AutoManageHelper", sb3.toString());
            iVar.g();
        }
    }
}
