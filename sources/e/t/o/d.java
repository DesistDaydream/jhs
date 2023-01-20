package e.t.o;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.vector.config.FitConfig;
import com.vector.fitter.Mode;
import h.k2.k;
import h.k2.v.u;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/vector/fitter/DpFitter;", "", "()V", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    @k.e.a.d
    public static final a a = new a(null);
    @k.e.a.d
    private static final ArrayMap<Mode, c> b = new ArrayMap<>();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0005H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/vector/fitter/DpFitter$Companion;", "", "()V", "mapMode", "Landroidx/collection/ArrayMap;", "Lcom/vector/fitter/Mode;", "Lcom/vector/fitter/DpComputer;", "get", "context", "Landroid/content/Context;", "mode", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* renamed from: e.t.o.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public /* synthetic */ class C0415a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[Mode.values().length];
                iArr[Mode.WIDTH.ordinal()] = 1;
                iArr[Mode.HEIGHT.ordinal()] = 2;
                iArr[Mode.FULL_SCREEN.ordinal()] = 3;
                iArr[Mode.DEFAULT.ordinal()] = 4;
                a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public static /* synthetic */ c c(a aVar, Mode mode, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mode = FitConfig.a.a();
            }
            return aVar.b(mode);
        }

        @k
        @k.e.a.d
        public final c a(@k.e.a.e Context context) {
            return new b();
        }

        @k
        @k.e.a.d
        public final c b(@k.e.a.d Mode mode) {
            c cVar = (c) d.b.get(mode);
            if (cVar == null) {
                int i2 = C0415a.a[mode.ordinal()];
                if (i2 == 1) {
                    cVar = new j();
                } else if (i2 == 2) {
                    cVar = new h();
                } else if (i2 == 3) {
                    cVar = new g();
                } else if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    cVar = new b();
                }
                d.b.put(mode, cVar);
            }
            return cVar;
        }
    }

    @k
    @k.e.a.d
    public static final c b(@k.e.a.e Context context) {
        return a.a(context);
    }

    @k
    @k.e.a.d
    public static final c c(@k.e.a.d Mode mode) {
        return a.b(mode);
    }
}
