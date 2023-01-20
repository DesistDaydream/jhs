package h.p2.b0.g.t.k.r.i;

import h.p2.b0.g.t.n.z;

/* loaded from: classes3.dex */
public class b extends a implements d {

    /* renamed from: c  reason: collision with root package name */
    private final h.p2.b0.g.t.c.a f15491c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@k.e.a.d h.p2.b0.g.t.c.a aVar, @k.e.a.d z zVar, @k.e.a.e e eVar) {
        super(zVar, eVar);
        if (aVar == null) {
            b(0);
        }
        if (zVar == null) {
            b(1);
        }
        this.f15491c = aVar;
    }

    private static /* synthetic */ void b(int i2) {
        String str = i2 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 2 ? 3 : 2];
        if (i2 == 1) {
            objArr[0] = "receiverType";
        } else if (i2 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else if (i2 != 3) {
            objArr[0] = "callableDescriptor";
        } else {
            objArr[0] = "newType";
        }
        if (i2 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else {
            objArr[1] = "getDeclarationDescriptor";
        }
        if (i2 != 2) {
            if (i2 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "replaceType";
            }
        }
        String format = String.format(str, objArr);
        if (i2 == 2) {
            throw new IllegalStateException(format);
        }
    }

    public String toString() {
        return getType() + ": Ext {" + this.f15491c + "}";
    }
}
