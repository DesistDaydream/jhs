package h.p2.b0.g.t.g;

import h.k2.v.f0;
import h.t2.u;
import kotlin.reflect.jvm.internal.impl.name.State;

/* loaded from: classes3.dex */
public final class e {

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.BEGINNING.ordinal()] = 1;
            iArr[State.AFTER_DOT.ordinal()] = 2;
            iArr[State.MIDDLE.ordinal()] = 3;
            a = iArr;
        }
    }

    private static final boolean a(String str, String str2) {
        return u.u2(str, str2, false, 2, null) && str.charAt(str2.length()) == '.';
    }

    public static final boolean b(@k.e.a.d c cVar, @k.e.a.d c cVar2) {
        if (f0.g(cVar, cVar2) || cVar2.d()) {
            return true;
        }
        return a(cVar.b(), cVar2.b());
    }

    public static final boolean c(@k.e.a.e String str) {
        if (str == null) {
            return false;
        }
        State state = State.BEGINNING;
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            i2++;
            int i3 = a.a[state.ordinal()];
            if (i3 == 1 || i3 == 2) {
                if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
                state = State.MIDDLE;
            } else if (i3 != 3) {
                continue;
            } else if (charAt == '.') {
                state = State.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(charAt)) {
                return false;
            }
        }
        return state != State.AFTER_DOT;
    }

    @k.e.a.d
    public static final c d(@k.e.a.d c cVar, @k.e.a.d c cVar2) {
        return (!b(cVar, cVar2) || cVar2.d()) ? cVar : f0.g(cVar, cVar2) ? c.f15413c : new c(cVar.b().substring(cVar2.b().length() + 1));
    }
}
