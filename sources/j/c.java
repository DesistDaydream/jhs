package j;

import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import h.q0;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b$\u0010%J+\u0010&\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018H\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0004H\u0007¢\u0006\u0004\b*\u0010+¨\u0006."}, d2 = {"Lj/c;", "", "Ljava/io/File;", "file", "Lj/k0;", am.av, "(Ljava/io/File;)Lj/k0;", "sink", "Lj/n;", "c", "(Lj/k0;)Lj/n;", "Lj/m0;", MessageKey.MSG_SOURCE, "Lj/o;", e.j.a.b.c.f.f10128d, "(Lj/m0;)Lj/o;", com.huawei.hms.push.e.a, "Ljava/io/OutputStream;", "outputStream", "f", "(Ljava/io/OutputStream;)Lj/k0;", "Ljava/nio/file/Path;", "path", "", "Ljava/nio/file/OpenOption;", "options", "h", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lj/k0;", "Ljava/net/Socket;", "socket", "g", "(Ljava/net/Socket;)Lj/k0;", "i", "(Ljava/io/File;)Lj/m0;", "Ljava/io/InputStream;", "inputStream", "j", "(Ljava/io/InputStream;)Lj/m0;", NotifyType.LIGHTS, "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lj/m0;", "k", "(Ljava/net/Socket;)Lj/m0;", "b", "()Lj/k0;", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
@h.i(message = "changed in Okio 2.x")
/* loaded from: classes4.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "file.appendingSink()", imports = {"okio.appendingSink"}))
    @k.e.a.d
    public final k0 a(@k.e.a.d File file) {
        return z.a(file);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "blackholeSink()", imports = {"okio.blackholeSink"}))
    @k.e.a.d
    public final k0 b() {
        return z.b();
    }

    @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "sink.buffer()", imports = {"okio.buffer"}))
    @k.e.a.d
    public final n c(@k.e.a.d k0 k0Var) {
        return z.c(k0Var);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "source.buffer()", imports = {"okio.buffer"}))
    @k.e.a.d
    public final o d(@k.e.a.d m0 m0Var) {
        return z.d(m0Var);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "file.sink()", imports = {"okio.sink"}))
    @k.e.a.d
    public final k0 e(@k.e.a.d File file) {
        return a0.j(file, false, 1, null);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "outputStream.sink()", imports = {"okio.sink"}))
    @k.e.a.d
    public final k0 f(@k.e.a.d OutputStream outputStream) {
        return z.h(outputStream);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "socket.sink()", imports = {"okio.sink"}))
    @k.e.a.d
    public final k0 g(@k.e.a.d Socket socket) {
        return z.i(socket);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "path.sink(*options)", imports = {"okio.sink"}))
    @k.e.a.d
    public final k0 h(@k.e.a.d Path path, @k.e.a.d OpenOption... openOptionArr) {
        return z.j(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "file.source()", imports = {"okio.source"}))
    @k.e.a.d
    public final m0 i(@k.e.a.d File file) {
        return z.l(file);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "inputStream.source()", imports = {"okio.source"}))
    @k.e.a.d
    public final m0 j(@k.e.a.d InputStream inputStream) {
        return z.m(inputStream);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "socket.source()", imports = {"okio.source"}))
    @k.e.a.d
    public final m0 k(@k.e.a.d Socket socket) {
        return z.n(socket);
    }

    @h.i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "path.source(*options)", imports = {"okio.source"}))
    @k.e.a.d
    public final m0 l(@k.e.a.d Path path, @k.e.a.d OpenOption... openOptionArr) {
        return z.o(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }
}
