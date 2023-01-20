package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class b extends a {
    private final d a;
    private final c b;

    /* renamed from: c  reason: collision with root package name */
    private final Queue<String> f1060c;

    public b() {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.f1060c = concurrentLinkedQueue;
        this.a = new f(concurrentLinkedQueue);
        this.b = new c();
    }

    /* JADX WARN: Type inference failed for: r10v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> a(int i2, int i3) {
        List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> a;
        List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> b;
        boolean z;
        synchronized (this) {
            a = this.a.a(i2, i3);
            if (a == null || a.size() == 0) {
                a = this.b.a(i2, i3);
                if (a != null && a.size() != 0) {
                    HashMap hashMap = new HashMap();
                    for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar : a) {
                        hashMap.put(aVar.i(), aVar);
                    }
                    ArrayList<String> arrayList = new ArrayList(this.f1060c);
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("allSendingQueue:" + arrayList.size());
                    if (arrayList.size() != 0) {
                        for (String str : arrayList) {
                            if (hashMap.get(str) != null) {
                                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("db duplicate delete");
                                hashMap.remove(str);
                            }
                        }
                    }
                    a.clear();
                    for (String str2 : hashMap.keySet()) {
                        a.add(hashMap.get(str2));
                    }
                }
            } else {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("memory get " + a.size());
                if ((i2 == 1 || i2 == 2) && (b = this.b.b(a.get(0), a.size())) != null && b.size() != 0) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("db get " + b.size());
                    HashMap hashMap2 = new HashMap();
                    for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar2 : b) {
                        hashMap2.put(aVar2.i(), aVar2);
                    }
                    ArrayList arrayList2 = new ArrayList(this.f1060c);
                    for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar3 : b) {
                        Iterator it = arrayList2.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (TextUtils.equals(aVar3.i(), (String) it.next())) {
                                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a(" duplicate delete ");
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                        if (z) {
                            hashMap2.remove(aVar3.i());
                        }
                    }
                    for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar4 : a) {
                        hashMap2.put(aVar4.i(), aVar4);
                    }
                    a.clear();
                    for (String str3 : hashMap2.keySet()) {
                        a.add(hashMap2.get(str3));
                    }
                }
            }
            if (a != null && !a.isEmpty()) {
                for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar5 : a) {
                    this.f1060c.offer(aVar5.i());
                }
            }
            a = new ArrayList<>();
        }
        return a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public void a(int i2, List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list) {
        synchronized (this) {
            ArrayList<String> arrayList = new ArrayList(this.f1060c.size());
            arrayList.addAll(this.f1060c);
            for (String str : arrayList) {
                for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar : list) {
                    if (TextUtils.equals(str, aVar.i())) {
                        this.f1060c.remove(str);
                    }
                }
            }
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(i2, list);
            }
            c cVar = this.b;
            if (cVar != null) {
                cVar.a(i2, list);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, int i2) {
        d dVar;
        synchronized (this) {
            if (i2 != 5) {
                if (j.l().b().a(j.l().d()) && (dVar = this.a) != null && aVar != null) {
                    dVar.a(aVar, i2);
                }
            }
            c cVar = this.b;
            if (cVar != null && aVar != null) {
                cVar.a(aVar, i2);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d
    public boolean a(int i2, boolean z) {
        boolean z2;
        AtomicLong s;
        synchronized (this) {
            z2 = true;
            if (this.a.a(i2, z)) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("memory meet");
                s = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.E();
            } else if ((i2 == 1 || i2 == 2) && this.b.a(i2, z)) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("db meet");
                s = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.s();
            } else {
                z2 = false;
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(s, 1);
        }
        return z2;
    }
}
