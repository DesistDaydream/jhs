package kotlin.reflect.jvm.internal.impl.builtins;

import h.k2.v.f0;
import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.g.f;
import k.e.a.d;

/* loaded from: classes3.dex */
public enum UnsignedType {
    UBYTE(b.e("kotlin/UByte")),
    USHORT(b.e("kotlin/UShort")),
    UINT(b.e("kotlin/UInt")),
    ULONG(b.e("kotlin/ULong"));
    
    @d
    private final b arrayClassId;
    @d
    private final b classId;
    @d
    private final f typeName;

    UnsignedType(b bVar) {
        this.classId = bVar;
        f j2 = bVar.j();
        this.typeName = j2;
        this.arrayClassId = new b(bVar.h(), f.f(f0.C(j2.b(), "Array")));
    }

    @d
    public final b getArrayClassId() {
        return this.arrayClassId;
    }

    @d
    public final b getClassId() {
        return this.classId;
    }

    @d
    public final f getTypeName() {
        return this.typeName;
    }
}
