package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108;

/* loaded from: classes.dex */
public class b {
    private EnumC0018b a;
    private c b;

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0018b {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    /* loaded from: classes.dex */
    public static class d {
        private static final b a = new b();
    }

    private b() {
        this.a = EnumC0018b.OFF;
        this.b = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.a();
    }

    public static void a(String str, String str2) {
        if (d.a.a.compareTo(EnumC0018b.DEBUG) <= 0) {
            d.a.b.a(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (d.a.a.compareTo(EnumC0018b.ERROR) <= 0) {
            d.a.b.b(str, str2);
        }
    }
}
