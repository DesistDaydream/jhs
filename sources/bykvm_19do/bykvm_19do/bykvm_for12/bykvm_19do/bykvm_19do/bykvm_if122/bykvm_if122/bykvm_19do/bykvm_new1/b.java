package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

/* loaded from: classes.dex */
public enum b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    
    public final int a;

    b(int i2) {
        this.a = i2;
    }

    public static b a(int i2) {
        b[] values;
        for (b bVar : values()) {
            if (bVar.a == i2) {
                return bVar;
            }
        }
        return null;
    }
}
