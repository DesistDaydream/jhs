package j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import kotlin.Metadata;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@Metadata(bv = {1, 0, 3}, d1 = {"j/a0", "j/b0"}, d2 = {}, k = 4, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class z {
    @k.e.a.d
    public static final k0 a(@k.e.a.d File file) throws FileNotFoundException {
        return a0.b(file);
    }

    @h.k2.g(name = "blackhole")
    @k.e.a.d
    public static final k0 b() {
        return b0.a();
    }

    @k.e.a.d
    public static final n c(@k.e.a.d k0 k0Var) {
        return b0.b(k0Var);
    }

    @k.e.a.d
    public static final o d(@k.e.a.d m0 m0Var) {
        return b0.c(m0Var);
    }

    public static final boolean e(@k.e.a.d AssertionError assertionError) {
        return a0.d(assertionError);
    }

    @h.k2.h
    @k.e.a.d
    public static final k0 f(@k.e.a.d File file) throws FileNotFoundException {
        return a0.j(file, false, 1, null);
    }

    @h.k2.h
    @k.e.a.d
    public static final k0 g(@k.e.a.d File file, boolean z) throws FileNotFoundException {
        return a0.f(file, z);
    }

    @k.e.a.d
    public static final k0 h(@k.e.a.d OutputStream outputStream) {
        return a0.g(outputStream);
    }

    @k.e.a.d
    public static final k0 i(@k.e.a.d Socket socket) throws IOException {
        return a0.h(socket);
    }

    @k.e.a.d
    @IgnoreJRERequirement
    public static final k0 j(@k.e.a.d Path path, @k.e.a.d OpenOption... openOptionArr) throws IOException {
        return a0.i(path, openOptionArr);
    }

    @k.e.a.d
    public static final m0 l(@k.e.a.d File file) throws FileNotFoundException {
        return a0.k(file);
    }

    @k.e.a.d
    public static final m0 m(@k.e.a.d InputStream inputStream) {
        return a0.l(inputStream);
    }

    @k.e.a.d
    public static final m0 n(@k.e.a.d Socket socket) throws IOException {
        return a0.m(socket);
    }

    @k.e.a.d
    @IgnoreJRERequirement
    public static final m0 o(@k.e.a.d Path path, @k.e.a.d OpenOption... openOptionArr) throws IOException {
        return a0.n(path, openOptionArr);
    }
}
