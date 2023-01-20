package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

/* loaded from: classes.dex */
public class b {
    private EnumC0014b a;

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0014b {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    /* loaded from: classes.dex */
    public static class d {
        private static final b a = new b();
    }

    private b() {
        EnumC0014b enumC0014b = EnumC0014b.OFF;
        new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a();
    }

    public static void a(EnumC0014b enumC0014b) {
        synchronized (b.class) {
            d.a.a = enumC0014b;
        }
    }
}
