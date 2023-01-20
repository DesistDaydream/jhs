package l;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class k {
    private final Method a;
    private final List<?> b;

    public k(Method method, List<?> list) {
        this.a = method;
        this.b = Collections.unmodifiableList(list);
    }

    public static k c(Method method, List<?> list) {
        Objects.requireNonNull(method, "method == null");
        Objects.requireNonNull(list, "arguments == null");
        return new k(method, new ArrayList(list));
    }

    public List<?> a() {
        return this.b;
    }

    public Method b() {
        return this.a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.a.getDeclaringClass().getName(), this.a.getName(), this.b);
    }
}
