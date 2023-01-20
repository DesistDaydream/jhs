package h.p2.b0.g.t.c.b1;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.n.z;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;

/* loaded from: classes3.dex */
public class d implements c {
    private final z a;
    private final Map<h.p2.b0.g.t.g.f, h.p2.b0.g.t.k.n.g<?>> b;

    /* renamed from: c  reason: collision with root package name */
    private final o0 f15083c;

    public d(@k.e.a.d z zVar, @k.e.a.d Map<h.p2.b0.g.t.g.f, h.p2.b0.g.t.k.n.g<?>> map, @k.e.a.d o0 o0Var) {
        if (zVar == null) {
            b(0);
        }
        if (map == null) {
            b(1);
        }
        if (o0Var == null) {
            b(2);
        }
        this.a = zVar;
        this.b = map;
        this.f15083c = o0Var;
    }

    private static /* synthetic */ void b(int i2) {
        String str = (i2 == 3 || i2 == 4 || i2 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 3 || i2 == 4 || i2 == 5) ? 2 : 3];
        if (i2 == 1) {
            objArr[0] = "valueArguments";
        } else if (i2 == 2) {
            objArr[0] = MessageKey.MSG_SOURCE;
        } else if (i2 == 3 || i2 == 4 || i2 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i2 == 3) {
            objArr[1] = "getType";
        } else if (i2 == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i2 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i2 != 3 && i2 != 4 && i2 != 5) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i2 != 3 && i2 != 4 && i2 != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @k.e.a.d
    public Map<h.p2.b0.g.t.g.f, h.p2.b0.g.t.k.n.g<?>> a() {
        Map<h.p2.b0.g.t.g.f, h.p2.b0.g.t.k.n.g<?>> map = this.b;
        if (map == null) {
            b(4);
        }
        return map;
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @k.e.a.e
    public h.p2.b0.g.t.g.c e() {
        return c.a.a(this);
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @k.e.a.d
    public o0 getSource() {
        o0 o0Var = this.f15083c;
        if (o0Var == null) {
            b(5);
        }
        return o0Var;
    }

    @Override // h.p2.b0.g.t.c.b1.c
    @k.e.a.d
    public z getType() {
        z zVar = this.a;
        if (zVar == null) {
            b(3);
        }
        return zVar;
    }

    public String toString() {
        return DescriptorRenderer.f16750g.t(this, null);
    }
}
