package h.h2.p;

import h.k2.v.f0;
import h.t2.u;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.text.StringsKt___StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/io/path/PathRelativizer;", "", "()V", "emptyPath", "Ljava/nio/file/Path;", "kotlin.jvm.PlatformType", "parentPath", "tryRelativeTo", "path", "base", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class b {
    @k.e.a.d

    /* renamed from: c */
    public static final b f14895c = new b();
    private static final Path a = Paths.get("", new String[0]);
    private static final Path b = Paths.get("..", new String[0]);

    private b() {
    }

    @k.e.a.d
    public final Path a(@k.e.a.d Path path, @k.e.a.d Path path2) {
        Path normalize = path2.normalize();
        Path normalize2 = path.normalize();
        Path relativize = normalize.relativize(normalize2);
        int min = Math.min(normalize.getNameCount(), normalize2.getNameCount());
        for (int i2 = 0; i2 < min; i2++) {
            Path name = normalize.getName(i2);
            Path path3 = b;
            if (!f0.g(name, path3)) {
                break;
            } else if (!f0.g(normalize2.getName(i2), path3)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if ((!f0.g(normalize2, normalize)) && f0.g(normalize, a)) {
            return normalize2;
        }
        String obj = relativize.toString();
        return u.J1(obj, relativize.getFileSystem().getSeparator(), false, 2, null) ? relativize.getFileSystem().getPath(StringsKt___StringsKt.t6(obj, relativize.getFileSystem().getSeparator().length()), new String[0]) : relativize;
    }
}
