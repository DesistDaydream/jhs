package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Debug;

/* loaded from: classes.dex */
public class b {
    public static final C0054b a;

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0054b {
        private C0054b() {
        }

        public int a(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int b(Debug.MemoryInfo memoryInfo) {
            return -1;
        }

        public int c(Debug.MemoryInfo memoryInfo) {
            return -1;
        }
    }

    @TargetApi(19)
    /* loaded from: classes.dex */
    public static class c extends C0054b {
        private c() {
            super();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.b.C0054b
        public int a(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalPrivateClean();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.b.C0054b
        public int b(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSharedClean();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.b.C0054b
        public int c(Debug.MemoryInfo memoryInfo) {
            return memoryInfo.getTotalSwappablePss();
        }
    }

    static {
        a = Build.VERSION.SDK_INT >= 19 ? new c() : new C0054b();
    }

    public static int a(Debug.MemoryInfo memoryInfo) {
        return a.a(memoryInfo);
    }

    public static int b(Debug.MemoryInfo memoryInfo) {
        return a.b(memoryInfo);
    }

    public static int c(Debug.MemoryInfo memoryInfo) {
        return a.c(memoryInfo);
    }
}
