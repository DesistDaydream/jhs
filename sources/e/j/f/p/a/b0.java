package e.j.f.p.a;

import com.google.zxing.client.result.ParsedResultType;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class b0 extends q {

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f11376d = Pattern.compile(":/*([^/@]+)@[^/]+");
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11377c;

    public b0(String str, String str2) {
        super(ParsedResultType.URI);
        this.b = h(str);
        this.f11377c = str2;
    }

    private static boolean f(String str, int i2) {
        int i3 = i2 + 1;
        int indexOf = str.indexOf(47, i3);
        if (indexOf < 0) {
            indexOf = str.length();
        }
        return t.e(str, i3, indexOf - i3);
    }

    private static String h(String str) {
        String trim = str.trim();
        int indexOf = trim.indexOf(58);
        return (indexOf < 0 || f(trim, indexOf)) ? "http://".concat(String.valueOf(trim)) : trim;
    }

    @Override // e.j.f.p.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        q.b(this.f11377c, sb);
        q.b(this.b, sb);
        return sb.toString();
    }

    public String d() {
        return this.f11377c;
    }

    public String e() {
        return this.b;
    }

    public boolean g() {
        return f11376d.matcher(this.b).find();
    }
}
