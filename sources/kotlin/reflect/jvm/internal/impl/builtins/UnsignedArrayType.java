package kotlin.reflect.jvm.internal.impl.builtins;

import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.g.f;
import k.e.a.d;

/* loaded from: classes3.dex */
public enum UnsignedArrayType {
    UBYTEARRAY(b.e("kotlin/UByteArray")),
    USHORTARRAY(b.e("kotlin/UShortArray")),
    UINTARRAY(b.e("kotlin/UIntArray")),
    ULONGARRAY(b.e("kotlin/ULongArray"));
    
    @d
    private final b classId;
    @d
    private final f typeName;

    UnsignedArrayType(b bVar) {
        this.classId = bVar;
        this.typeName = bVar.j();
    }

    @d
    public final f getTypeName() {
        return this.typeName;
    }
}
