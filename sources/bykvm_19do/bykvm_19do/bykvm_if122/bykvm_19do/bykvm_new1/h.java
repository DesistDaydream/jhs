package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.f0;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class h {
    public final Map<Integer, Boolean> a = new HashMap();
    private final Map<Integer, AtomicInteger> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f917c = new AtomicInteger();

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f918d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    private final AtomicInteger f919e = new AtomicInteger();

    /* renamed from: f  reason: collision with root package name */
    private final List<Integer> f920f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final AtomicInteger f921g = new AtomicInteger();

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f922h = new CopyOnWriteArrayList();

    /* renamed from: i  reason: collision with root package name */
    private final AtomicBoolean f923i = new AtomicBoolean(false);

    public void a() {
        synchronized (this) {
            if (this.f921g.get() != 0) {
                this.f921g.decrementAndGet();
            }
        }
    }

    public void a(int i2) {
        AtomicInteger atomicInteger = this.b.get(Integer.valueOf(i2));
        if (atomicInteger == null || atomicInteger.get() == 0) {
            return;
        }
        atomicInteger.decrementAndGet();
    }

    public void a(int i2, int i3) {
        this.b.put(Integer.valueOf(i2), new AtomicInteger(i3));
    }

    public void a(int i2, boolean z) {
        synchronized (this) {
            Boolean bool = this.a.get(Integer.valueOf(i2));
            if (bool != null && !bool.booleanValue()) {
                this.a.put(Integer.valueOf(i2), Boolean.valueOf(z));
                this.f917c.decrementAndGet();
            }
        }
    }

    public void a(String str) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                this.f922h.add(str);
            }
            if (this.f919e.get() != 0) {
                this.f919e.decrementAndGet();
            } else {
                Logger.e("TTMediationSDK", "decrementTotalWaterFall--waterfall数量减少一个 ---不用再减了不然就变成-1了");
            }
        }
    }

    public void a(List<Integer> list) {
        if (list != null) {
            this.f917c.set(list.size());
            for (Integer num : list) {
                this.a.put(num, Boolean.FALSE);
            }
        }
    }

    public void a(List<j> list, List<j> list2, List<j> list3) {
        if (list == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            int size = list.size();
            if (list2 != null) {
                size += list2.size();
            }
            if (list3 != null) {
                size += list3.size();
            }
            for (j jVar : list) {
                Iterator<String> it = this.f922h.iterator();
                while (true) {
                    if (it.hasNext()) {
                        String next = it.next();
                        if (!TextUtils.isEmpty(next) && jVar != null && next.equals(jVar.d())) {
                            size--;
                            break;
                        }
                    }
                }
            }
            if (!f0.a(list2)) {
                for (j jVar2 : list2) {
                    Iterator<String> it2 = this.f922h.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!TextUtils.isEmpty(next2) && jVar2 != null && next2.equals(jVar2.d())) {
                                size--;
                                break;
                            }
                        }
                    }
                }
            }
            if (!f0.a(list3)) {
                for (j jVar3 : list3) {
                    Iterator<String> it3 = this.f922h.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            String next3 = it3.next();
                            if (!TextUtils.isEmpty(next3) && jVar3 != null && next3.equals(jVar3.d())) {
                                size--;
                                break;
                            }
                        }
                    }
                }
            }
            if (size < 0) {
                size = 0;
            }
            this.f919e.set(size);
        }
    }

    public void a(boolean z) {
        this.f918d.set(z);
    }

    public int b() {
        return this.f921g.get();
    }

    public int b(int i2) {
        AtomicInteger atomicInteger = this.b.get(Integer.valueOf(i2));
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return -1;
    }

    public void b(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        synchronized (this) {
            AtomicInteger atomicInteger = new AtomicInteger();
            for (Integer num : list) {
                Boolean bool = this.a.get(num);
                if (bool == null || !bool.booleanValue()) {
                    atomicInteger.incrementAndGet();
                }
            }
            this.f917c.set(atomicInteger.get());
        }
    }

    public void b(boolean z) {
        this.f923i.set(z);
    }

    public int c() {
        int i2;
        synchronized (this) {
            i2 = this.f917c.get();
        }
        return i2;
    }

    public boolean c(int i2) {
        Map<Integer, Boolean> map = this.a;
        return (map == null || map.get(Integer.valueOf(i2)) == null || !this.a.get(Integer.valueOf(i2)).booleanValue()) ? false : true;
    }

    public int d() {
        int i2;
        synchronized (this) {
            i2 = this.f919e.get();
        }
        return i2;
    }

    public void d(int i2) {
        this.f920f.add(Integer.valueOf(i2));
    }

    public void e(int i2) {
        this.f919e.set(i2);
    }

    public boolean e() {
        return this.f923i.get();
    }

    public void f(int i2) {
        this.f921g.set(i2);
    }

    public boolean f() {
        return c() == 0 && d() == 0;
    }

    public boolean g() {
        return this.f918d.get();
    }

    public void h() {
        this.f919e.set(0);
        this.f917c.set(0);
        this.a.clear();
        this.b.clear();
        this.f918d.set(false);
        this.f922h.clear();
        this.f920f.clear();
        this.f923i.set(false);
    }
}
