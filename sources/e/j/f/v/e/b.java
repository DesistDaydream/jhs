package e.j.f.v.e;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b {
    private final Map<Integer, Integer> a = new HashMap();

    public Integer a(int i2) {
        return this.a.get(Integer.valueOf(i2));
    }

    public int[] b() {
        ArrayList arrayList = new ArrayList();
        int i2 = -1;
        for (Map.Entry<Integer, Integer> entry : this.a.entrySet()) {
            if (entry.getValue().intValue() > i2) {
                i2 = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == i2) {
                arrayList.add(entry.getKey());
            }
        }
        return e.j.f.v.a.c(arrayList);
    }

    public void c(int i2) {
        Integer num = this.a.get(Integer.valueOf(i2));
        if (num == null) {
            num = 0;
        }
        this.a.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() + 1));
    }
}
