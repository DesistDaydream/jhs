package e.b.a.p.l;

import e.b.a.p.l.j;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public interface h {
    @Deprecated
    public static final h a = new a();
    public static final h b = new j.a().c();

    /* loaded from: classes.dex */
    public class a implements h {
        @Override // e.b.a.p.l.h
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    }

    Map<String, String> getHeaders();
}
