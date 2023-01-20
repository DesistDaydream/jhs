package e.j.a.b.c.r;

import androidx.annotation.NonNull;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class x {
    private static final n b = new n("LibraryVersion", "");

    /* renamed from: c  reason: collision with root package name */
    private static x f10442c = new x();
    private ConcurrentHashMap<String, String> a = new ConcurrentHashMap<>();

    @e.j.a.b.c.m.a
    public static x a() {
        return f10442c;
    }

    @e.j.a.b.c.m.a
    public String b(@NonNull String str) {
        a0.h(str, "Please provide a valid libraryName");
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        Properties properties = new Properties();
        String str2 = null;
        try {
            InputStream resourceAsStream = x.class.getResourceAsStream(String.format("/%s.properties", str));
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                str2 = properties.getProperty("version", null);
                n nVar = b;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(str2).length());
                sb.append(str);
                sb.append(" version is ");
                sb.append(str2);
                nVar.l("LibraryVersion", sb.toString());
            } else {
                n nVar2 = b;
                String valueOf = String.valueOf(str);
                nVar2.e("LibraryVersion", valueOf.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf) : new String("Failed to get app version for libraryName: "));
            }
        } catch (IOException e2) {
            n nVar3 = b;
            String valueOf2 = String.valueOf(str);
            nVar3.f("LibraryVersion", valueOf2.length() != 0 ? "Failed to get app version for libraryName: ".concat(valueOf2) : new String("Failed to get app version for libraryName: "), e2);
        }
        if (str2 == null) {
            b.c("LibraryVersion", ".properties file is dropped during release process. Failure to read app version isexpected druing Google internal testing where locally-built libraries are used");
            str2 = GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        this.a.put(str, str2);
        return str2;
    }
}
