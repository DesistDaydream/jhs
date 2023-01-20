package e.j.f.p.a;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class c0 extends t {

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f11378f = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f11379g = Pattern.compile("([a-zA-Z0-9\\-]+\\.){1,6}[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    public static boolean q(String str) {
        if (str.contains(ExpandableTextView.N)) {
            return false;
        }
        Matcher matcher = f11378f.matcher(str);
        if (matcher.find() && matcher.start() == 0) {
            return true;
        }
        Matcher matcher2 = f11379g.matcher(str);
        return matcher2.find() && matcher2.start() == 0;
    }

    @Override // e.j.f.p.a.t
    /* renamed from: r */
    public b0 k(e.j.f.k kVar) {
        String c2 = t.c(kVar);
        if (!c2.startsWith("URL:") && !c2.startsWith("URI:")) {
            String trim = c2.trim();
            if (q(trim)) {
                return new b0(trim, null);
            }
            return null;
        }
        return new b0(c2.substring(4).trim(), null);
    }
}
