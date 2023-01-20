package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ao\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u000228\u0010\b\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00028\u00000\u0004H\u0082\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\u000e\u001a\u00028\u0000\"\u000e\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\f*\u00028\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u001c\u0010\u0019\u001a\u00020\u00148\u0002@\u0003X\u0083\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Li/b/w3/f0;", ExifInterface.LATITUDE_SOUTH, "", "id", "Lkotlin/Function2;", "Lh/k0;", "name", "prev", "createNewSegment", "Li/b/w3/g0;", e.j.a.b.c.f.f10128d, "(Li/b/w3/f0;JLh/k2/u/p;)Ljava/lang/Object;", "Li/b/w3/g;", "N", "c", "(Li/b/w3/g;)Li/b/w3/g;", "", am.av, ExpandableTextView.P, "POINTERS_SHIFT", "Li/b/w3/i0;", "b", "Li/b/w3/i0;", "getCLOSED$annotations", "()V", "CLOSED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class f {
    private static final int a = 16;
    private static final i0 b = new i0("CLOSED");

    public static final /* synthetic */ i0 b() {
        return b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [i.b.w3.g] */
    @k.e.a.d
    public static final <N extends g<N>> N c(@k.e.a.d N n) {
        while (true) {
            Object e2 = n.e();
            if (e2 == b) {
                return n;
            }
            ?? r0 = (g) e2;
            if (r0 != 0) {
                n = r0;
            } else if (n.j()) {
                return n;
            }
        }
    }

    public static final <S extends f0<S>> Object d(S s, long j2, h.k2.u.p<? super Long, ? super S, ? extends S> pVar) {
        while (true) {
            if (s.o() < j2 || s.g()) {
                Object e2 = s.e();
                if (e2 == b) {
                    return g0.b(b);
                }
                S s2 = (S) ((g) e2);
                if (s2 == null) {
                    s2 = pVar.invoke(Long.valueOf(s.o() + 1), s);
                    if (s.m(s2)) {
                        if (s.g()) {
                            s.l();
                        }
                    }
                }
                s = s2;
            } else {
                return g0.b(s);
            }
        }
    }

    private static /* synthetic */ void e() {
    }
}
