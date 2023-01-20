package kotlin.reflect.jvm.internal.impl.builtins;

import h.a2.d1;
import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.g.f;
import h.w;
import h.z;
import java.util.Set;
import k.e.a.d;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes3.dex */
public enum PrimitiveType {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");
    
    @d
    public static final a Companion = new a(null);
    @h.k2.d
    @d
    public static final Set<PrimitiveType> NUMBER_TYPES;
    @d
    private final w arrayTypeFqName$delegate;
    @d
    private final f arrayTypeName;
    @d
    private final w typeFqName$delegate;
    @d
    private final f typeName;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        PrimitiveType primitiveType;
        PrimitiveType primitiveType2;
        PrimitiveType primitiveType3;
        PrimitiveType primitiveType4;
        PrimitiveType primitiveType5;
        PrimitiveType primitiveType6;
        NUMBER_TYPES = d1.u(r0, primitiveType, primitiveType2, primitiveType3, primitiveType4, primitiveType5, primitiveType6);
    }

    PrimitiveType(String str) {
        this.typeName = f.f(str);
        this.arrayTypeName = f.f(f0.C(str, "Array"));
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.typeFqName$delegate = z.b(lazyThreadSafetyMode, new PrimitiveType$typeFqName$2(this));
        this.arrayTypeFqName$delegate = z.b(lazyThreadSafetyMode, new PrimitiveType$arrayTypeFqName$2(this));
    }

    @d
    public final c getArrayTypeFqName() {
        return (c) this.arrayTypeFqName$delegate.getValue();
    }

    @d
    public final f getArrayTypeName() {
        return this.arrayTypeName;
    }

    @d
    public final c getTypeFqName() {
        return (c) this.typeFqName$delegate.getValue();
    }

    @d
    public final f getTypeName() {
        return this.typeName;
    }
}
