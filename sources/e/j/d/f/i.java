package e.j.d.f;

import android.os.Bundle;
import android.util.Log;
import com.google.firebase.iid.zzad;

/* loaded from: classes2.dex */
public abstract class i<T> {
    public final int a;
    public final e.j.a.b.j.l<T> b = new e.j.a.b.j.l<>();

    /* renamed from: c  reason: collision with root package name */
    public final int f11233c;

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f11234d;

    public i(int i2, int i3, Bundle bundle) {
        this.a = i2;
        this.f11233c = i3;
        this.f11234d = bundle;
    }

    public abstract void a(Bundle bundle);

    public final void b(zzad zzadVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzadVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length());
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.b.b(zzadVar);
    }

    public final void c(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length());
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.b.setResult(t);
    }

    public abstract boolean d();

    public String toString() {
        int i2 = this.f11233c;
        int i3 = this.a;
        boolean d2 = d();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i2);
        sb.append(" id=");
        sb.append(i3);
        sb.append(" oneWay=");
        sb.append(d2);
        sb.append("}");
        return sb.toString();
    }
}
