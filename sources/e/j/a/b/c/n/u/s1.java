package e.j.a.b.c.n.u;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public interface s1 {
    <A extends a.b, T extends d.a<? extends e.j.a.b.c.n.p, A>> T c(@NonNull T t);

    void connect();

    void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    void disconnect();

    <A extends a.b, R extends e.j.a.b.c.n.p, T extends d.a<R, A>> T e(@NonNull T t);

    ConnectionResult f(long j2, TimeUnit timeUnit);

    @Nullable
    ConnectionResult g(@NonNull e.j.a.b.c.n.a<?> aVar);

    boolean h(s sVar);

    void i();

    boolean isConnected();

    boolean isConnecting();

    void j();

    ConnectionResult k();
}
