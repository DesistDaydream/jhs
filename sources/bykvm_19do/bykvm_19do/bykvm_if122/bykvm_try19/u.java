package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class u {
    private static Map<Integer, Integer> a = new ConcurrentHashMap();

    public static Integer a(int i2) {
        Integer num = a.get(Integer.valueOf(i2));
        if (num == null) {
            Integer valueOf = Integer.valueOf(i2);
            a.put(Integer.valueOf(i2), valueOf);
            return valueOf;
        }
        return num;
    }
}
