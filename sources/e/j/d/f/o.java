package e.j.d.f;

import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class o {
    private final Executor a;
    @GuardedBy("this")
    private final Map<Pair<String, String>, e.j.a.b.j.k<a>> b = new ArrayMap();

    public o(Executor executor) {
        this.a = executor;
    }

    public final /* synthetic */ e.j.a.b.j.k a(Pair pair, e.j.a.b.j.k kVar) throws Exception {
        synchronized (this) {
            this.b.remove(pair);
        }
        return kVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized e.j.a.b.j.k<a> b(String str, String str2, q qVar) {
        Pair pair = new Pair(str, str2);
        e.j.a.b.j.k<a> kVar = this.b.get(pair);
        if (kVar != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
                sb.append("Joining ongoing request for: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            return kVar;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 24);
            sb2.append("Making new request for: ");
            sb2.append(valueOf2);
            Log.d("FirebaseInstanceId", sb2.toString());
        }
        e.j.a.b.j.k p = qVar.a().p(this.a, new e.j.a.b.j.c(this, pair) { // from class: e.j.d.f.n
            private final o a;
            private final Pair b;

            {
                this.a = this;
                this.b = pair;
            }

            @Override // e.j.a.b.j.c
            public final Object a(e.j.a.b.j.k kVar2) {
                return this.a.a(this.b, kVar2);
            }
        });
        this.b.put(pair, p);
        return p;
    }
}
