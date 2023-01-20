package j;

import com.baidu.mobads.sdk.internal.bj;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\u0001*\u00020\b¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\u000b\u001a\u00020\u0005*\u00020\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u001d\u0010\u0010\u001a\u00020\u0001*\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0011\u0010\u0012\u001a\u00020\u0001*\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0014\u001a\u00020\u0005*\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u001a\u001a\u00020\u0001*\u00020\u00162\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a'\u0010\u001c\u001a\u00020\u0005*\u00020\u00162\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017\"\u00020\u0018H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\"\u001e\u0010\"\u001a\u00020\u000e*\u00060\u001ej\u0002`\u001f8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010!\"$\u0010)\u001a\n $*\u0004\u0018\u00010#0#8\u0002@\u0002X\u0082\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Ljava/io/OutputStream;", "Lj/k0;", "g", "(Ljava/io/OutputStream;)Lj/k0;", "Ljava/io/InputStream;", "Lj/m0;", NotifyType.LIGHTS, "(Ljava/io/InputStream;)Lj/m0;", "Ljava/net/Socket;", "h", "(Ljava/net/Socket;)Lj/k0;", "m", "(Ljava/net/Socket;)Lj/m0;", "Ljava/io/File;", "", "append", "f", "(Ljava/io/File;Z)Lj/k0;", "b", "(Ljava/io/File;)Lj/k0;", "k", "(Ljava/io/File;)Lj/m0;", "Ljava/nio/file/Path;", "", "Ljava/nio/file/OpenOption;", "options", "i", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lj/k0;", "n", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lj/m0;", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", e.j.a.b.c.f.f10128d, "(Ljava/lang/AssertionError;)Z", "isAndroidGetsocknameError", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", am.av, "Ljava/util/logging/Logger;", "c", "()Ljava/util/logging/Logger;", bj.a, "okio"}, k = 5, mv = {1, 4, 0}, xs = "okio/Okio")
/* loaded from: classes4.dex */
public final /* synthetic */ class a0 {
    private static final Logger a = Logger.getLogger("okio.Okio");

    @k.e.a.d
    public static final k0 b(@k.e.a.d File file) throws FileNotFoundException {
        return z.h(new FileOutputStream(file, true));
    }

    private static final Logger c() {
        return a;
    }

    public static final boolean d(@k.e.a.d AssertionError assertionError) {
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            return message != null ? StringsKt__StringsKt.V2(message, "getsockname failed", false, 2, null) : false;
        }
        return false;
    }

    @h.k2.h
    @k.e.a.d
    public static final k0 e(@k.e.a.d File file) throws FileNotFoundException {
        return j(file, false, 1, null);
    }

    @h.k2.h
    @k.e.a.d
    public static final k0 f(@k.e.a.d File file, boolean z) throws FileNotFoundException {
        return z.h(new FileOutputStream(file, z));
    }

    @k.e.a.d
    public static final k0 g(@k.e.a.d OutputStream outputStream) {
        return new d0(outputStream, new o0());
    }

    @k.e.a.d
    public static final k0 h(@k.e.a.d Socket socket) throws IOException {
        l0 l0Var = new l0(socket);
        return l0Var.sink(new d0(socket.getOutputStream(), l0Var));
    }

    @k.e.a.d
    @IgnoreJRERequirement
    public static final k0 i(@k.e.a.d Path path, @k.e.a.d OpenOption... openOptionArr) throws IOException {
        return z.h(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)));
    }

    public static /* synthetic */ k0 j(File file, boolean z, int i2, Object obj) throws FileNotFoundException {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return z.g(file, z);
    }

    @k.e.a.d
    public static final m0 k(@k.e.a.d File file) throws FileNotFoundException {
        return z.m(new FileInputStream(file));
    }

    @k.e.a.d
    public static final m0 l(@k.e.a.d InputStream inputStream) {
        return new y(inputStream, new o0());
    }

    @k.e.a.d
    public static final m0 m(@k.e.a.d Socket socket) throws IOException {
        l0 l0Var = new l0(socket);
        return l0Var.source(new y(socket.getInputStream(), l0Var));
    }

    @k.e.a.d
    @IgnoreJRERequirement
    public static final m0 n(@k.e.a.d Path path, @k.e.a.d OpenOption... openOptionArr) throws IOException {
        return z.m(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)));
    }
}
