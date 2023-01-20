package h.k2.v;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class r0 {
    private final ArrayList<Object> a;

    public r0(int i2) {
        this.a = new ArrayList<>(i2);
    }

    public void a(Object obj) {
        this.a.add(obj);
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.a, objArr);
            }
        } else if (obj instanceof Collection) {
            this.a.addAll((Collection) obj);
        } else if (obj instanceof Iterable) {
            for (Object obj2 : (Iterable) obj) {
                this.a.add(obj2);
            }
        } else if (obj instanceof Iterator) {
            Iterator it = (Iterator) obj;
            while (it.hasNext()) {
                this.a.add(it.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int c() {
        return this.a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.a.toArray(objArr);
    }
}
