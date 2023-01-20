package e.j.a.b.c.r;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class y {

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public static final class a {
        private final List<String> a;
        private final Object b;

        private a(Object obj) {
            this.b = a0.k(obj);
            this.a = new ArrayList();
        }

        @e.j.a.b.c.m.a
        public final a a(String str, @Nullable Object obj) {
            List<String> list = this.a;
            String str2 = (String) a0.k(str);
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(valueOf).length());
            sb.append(str2);
            sb.append("=");
            sb.append(valueOf);
            list.add(sb.toString());
            return this;
        }

        @e.j.a.b.c.m.a
        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.b.getClass().getSimpleName());
            sb.append('{');
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(this.a.get(i2));
                if (i2 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    private y() {
        throw new AssertionError("Uninstantiable");
    }

    @e.j.a.b.c.m.a
    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @e.j.a.b.c.m.a
    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @e.j.a.b.c.m.a
    public static a c(Object obj) {
        return new a(obj);
    }
}
