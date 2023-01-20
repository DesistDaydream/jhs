package h.h2;

import h.a2.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u000b\u001a\u00020\f*\u00020\bH\u0002¢\u0006\u0002\b\r\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/io/FilesKt")
/* loaded from: classes3.dex */
public class k {
    @k.e.a.d
    public static final File a(@k.e.a.d File file) {
        return new File(c(file));
    }

    private static final int b(String str) {
        int q3;
        int q32 = StringsKt__StringsKt.q3(str, File.separatorChar, 0, false, 4, null);
        if (q32 == 0) {
            if (str.length() > 1) {
                char charAt = str.charAt(1);
                char c2 = File.separatorChar;
                if (charAt == c2 && (q3 = StringsKt__StringsKt.q3(str, c2, 2, false, 4, null)) >= 0) {
                    int q33 = StringsKt__StringsKt.q3(str, File.separatorChar, q3 + 1, false, 4, null);
                    return q33 >= 0 ? q33 + 1 : str.length();
                }
            }
            return 1;
        } else if (q32 <= 0 || str.charAt(q32 - 1) != ':') {
            if (q32 == -1 && StringsKt__StringsKt.a3(str, ':', false, 2, null)) {
                return str.length();
            }
            return 0;
        } else {
            return q32 + 1;
        }
    }

    @k.e.a.d
    public static final String c(@k.e.a.d File file) {
        String path = file.getPath();
        int b = b(file.getPath());
        Objects.requireNonNull(path, "null cannot be cast to non-null type java.lang.String");
        return path.substring(0, b);
    }

    public static final boolean d(@k.e.a.d File file) {
        return b(file.getPath()) > 0;
    }

    @k.e.a.d
    public static final File e(@k.e.a.d File file, int i2, int i3) {
        return f(file).j(i2, i3);
    }

    @k.e.a.d
    public static final g f(@k.e.a.d File file) {
        List list;
        String path = file.getPath();
        int b = b(path);
        String substring = path.substring(0, b);
        String substring2 = path.substring(b);
        if (substring2.length() == 0) {
            list = CollectionsKt__CollectionsKt.E();
        } else {
            List<String> R4 = StringsKt__StringsKt.R4(substring2, new char[]{File.separatorChar}, false, 0, 6, null);
            ArrayList arrayList = new ArrayList(u.Y(R4, 10));
            for (String str : R4) {
                arrayList.add(new File(str));
            }
            list = arrayList;
        }
        return new g(new File(substring), list);
    }
}
