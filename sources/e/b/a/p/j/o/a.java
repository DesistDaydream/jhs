package e.b.a.p.j.o;

import java.io.File;

/* loaded from: classes.dex */
public class a {
    public boolean a(File file) {
        return file.exists();
    }

    public File b(String str) {
        return new File(str);
    }

    public long c(File file) {
        return file.length();
    }
}
