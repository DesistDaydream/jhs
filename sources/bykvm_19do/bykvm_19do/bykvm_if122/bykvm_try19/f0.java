package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import java.util.List;

/* loaded from: classes.dex */
public class f0 {
    public static <T> boolean a(List<T> list) {
        return list == null || list.size() == 0;
    }

    public static <T> boolean b(List<T> list) {
        return list == null || list.size() == 0 || list.get(0) == null;
    }
}
