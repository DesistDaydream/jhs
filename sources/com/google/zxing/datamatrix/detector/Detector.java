package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.tencent.android.tpns.mqtt.MqttTopic;
import e.j.f.l;
import e.j.f.q.f;
import e.j.f.q.h;
import e.j.f.q.l.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Detector {
    private final e.j.f.q.b a;
    private final c b;

    /* loaded from: classes2.dex */
    public static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<b> {
        private ResultPointsAndTransitionsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return bVar.c() - bVar2.c();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        private final l a;
        private final l b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3256c;

        public l a() {
            return this.a;
        }

        public l b() {
            return this.b;
        }

        public int c() {
            return this.f3256c;
        }

        public String toString() {
            return this.a + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.b + Attributes.InternalPrefix + this.f3256c;
        }

        private b(l lVar, l lVar2, int i2) {
            this.a = lVar;
            this.b = lVar2;
            this.f3256c = i2;
        }
    }

    public Detector(e.j.f.q.b bVar) throws NotFoundException {
        this.a = bVar;
        this.b = new c(bVar);
    }

    private l a(l lVar, l lVar2, l lVar3, l lVar4, int i2) {
        float f2 = i2;
        float d2 = d(lVar, lVar2) / f2;
        float d3 = d(lVar3, lVar4);
        l lVar5 = new l(lVar4.c() + (((lVar4.c() - lVar3.c()) / d3) * d2), lVar4.d() + (d2 * ((lVar4.d() - lVar3.d()) / d3)));
        float d4 = d(lVar, lVar3) / f2;
        float d5 = d(lVar2, lVar4);
        l lVar6 = new l(lVar4.c() + (((lVar4.c() - lVar2.c()) / d5) * d4), lVar4.d() + (d4 * ((lVar4.d() - lVar2.d()) / d5)));
        if (f(lVar5)) {
            return (f(lVar6) && Math.abs(h(lVar3, lVar5).c() - h(lVar2, lVar5).c()) > Math.abs(h(lVar3, lVar6).c() - h(lVar2, lVar6).c())) ? lVar6 : lVar5;
        } else if (f(lVar6)) {
            return lVar6;
        } else {
            return null;
        }
    }

    private l b(l lVar, l lVar2, l lVar3, l lVar4, int i2, int i3) {
        float d2 = d(lVar, lVar2) / i2;
        float d3 = d(lVar3, lVar4);
        l lVar5 = new l(lVar4.c() + (((lVar4.c() - lVar3.c()) / d3) * d2), lVar4.d() + (d2 * ((lVar4.d() - lVar3.d()) / d3)));
        float d4 = d(lVar, lVar3) / i3;
        float d5 = d(lVar2, lVar4);
        l lVar6 = new l(lVar4.c() + (((lVar4.c() - lVar2.c()) / d5) * d4), lVar4.d() + (d4 * ((lVar4.d() - lVar2.d()) / d5)));
        if (f(lVar5)) {
            return (f(lVar6) && Math.abs(i2 - h(lVar3, lVar5).c()) + Math.abs(i3 - h(lVar2, lVar5).c()) > Math.abs(i2 - h(lVar3, lVar6).c()) + Math.abs(i3 - h(lVar2, lVar6).c())) ? lVar6 : lVar5;
        } else if (f(lVar6)) {
            return lVar6;
        } else {
            return null;
        }
    }

    private static int d(l lVar, l lVar2) {
        return e.j.f.q.l.a.c(l.b(lVar, lVar2));
    }

    private static void e(Map<l, Integer> map, l lVar) {
        Integer num = map.get(lVar);
        map.put(lVar, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    private boolean f(l lVar) {
        return lVar.c() >= 0.0f && lVar.c() < ((float) this.a.n()) && lVar.d() > 0.0f && lVar.d() < ((float) this.a.j());
    }

    private static e.j.f.q.b g(e.j.f.q.b bVar, l lVar, l lVar2, l lVar3, l lVar4, int i2, int i3) throws NotFoundException {
        float f2 = i2 - 0.5f;
        float f3 = i3 - 0.5f;
        return h.b().c(bVar, i2, i3, 0.5f, 0.5f, f2, 0.5f, f2, f3, 0.5f, f3, lVar.c(), lVar.d(), lVar4.c(), lVar4.d(), lVar3.c(), lVar3.d(), lVar2.c(), lVar2.d());
    }

    private b h(l lVar, l lVar2) {
        int c2 = (int) lVar.c();
        int d2 = (int) lVar.d();
        int c3 = (int) lVar2.c();
        int d3 = (int) lVar2.d();
        int i2 = 0;
        boolean z = Math.abs(d3 - d2) > Math.abs(c3 - c2);
        if (z) {
            d2 = c2;
            c2 = d2;
            d3 = c3;
            c3 = d3;
        }
        int abs = Math.abs(c3 - c2);
        int abs2 = Math.abs(d3 - d2);
        int i3 = (-abs) / 2;
        int i4 = d2 < d3 ? 1 : -1;
        int i5 = c2 >= c3 ? -1 : 1;
        boolean f2 = this.a.f(z ? d2 : c2, z ? c2 : d2);
        while (c2 != c3) {
            boolean f3 = this.a.f(z ? d2 : c2, z ? c2 : d2);
            if (f3 != f2) {
                i2++;
                f2 = f3;
            }
            i3 += abs2;
            if (i3 > 0) {
                if (d2 == d3) {
                    break;
                }
                d2 += i4;
                i3 -= abs;
            }
            c2 += i5;
        }
        return new b(lVar, lVar2, i2);
    }

    public f c() throws NotFoundException {
        l lVar;
        l lVar2;
        e.j.f.q.b g2;
        l[] c2 = this.b.c();
        l lVar3 = c2[0];
        l lVar4 = c2[1];
        l lVar5 = c2[2];
        l lVar6 = c2[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(h(lVar3, lVar4));
        arrayList.add(h(lVar3, lVar5));
        arrayList.add(h(lVar4, lVar6));
        arrayList.add(h(lVar5, lVar6));
        l lVar7 = null;
        Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
        b bVar = (b) arrayList.get(0);
        b bVar2 = (b) arrayList.get(1);
        HashMap hashMap = new HashMap();
        e(hashMap, bVar.a());
        e(hashMap, bVar.b());
        e(hashMap, bVar2.a());
        e(hashMap, bVar2.b());
        l lVar8 = null;
        l lVar9 = null;
        for (Map.Entry entry : hashMap.entrySet()) {
            l lVar10 = (l) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                lVar8 = lVar10;
            } else if (lVar7 == null) {
                lVar7 = lVar10;
            } else {
                lVar9 = lVar10;
            }
        }
        if (lVar7 != null && lVar8 != null && lVar9 != null) {
            l[] lVarArr = {lVar7, lVar8, lVar9};
            l.e(lVarArr);
            l lVar11 = lVarArr[0];
            l lVar12 = lVarArr[1];
            l lVar13 = lVarArr[2];
            if (!hashMap.containsKey(lVar3)) {
                lVar = lVar3;
            } else if (hashMap.containsKey(lVar4)) {
                lVar = !hashMap.containsKey(lVar5) ? lVar5 : lVar6;
            } else {
                lVar = lVar4;
            }
            int c3 = h(lVar13, lVar).c();
            int c4 = h(lVar11, lVar).c();
            if ((c3 & 1) == 1) {
                c3++;
            }
            int i2 = c3 + 2;
            if ((c4 & 1) == 1) {
                c4++;
            }
            int i3 = c4 + 2;
            if (i2 * 4 < i3 * 7 && i3 * 4 < i2 * 7) {
                l a2 = a(lVar12, lVar11, lVar13, lVar, Math.min(i3, i2));
                if (a2 != null) {
                    lVar = a2;
                }
                int max = Math.max(h(lVar13, lVar).c(), h(lVar11, lVar).c()) + 1;
                if ((max & 1) == 1) {
                    max++;
                }
                int i4 = max;
                g2 = g(this.a, lVar13, lVar12, lVar11, lVar, i4, i4);
                lVar2 = lVar13;
            } else {
                lVar2 = lVar13;
                l b2 = b(lVar12, lVar11, lVar13, lVar, i2, i3);
                if (b2 != null) {
                    lVar = b2;
                }
                int c5 = h(lVar2, lVar).c();
                int c6 = h(lVar11, lVar).c();
                if ((c5 & 1) == 1) {
                    c5++;
                }
                int i5 = c5;
                if ((c6 & 1) == 1) {
                    c6++;
                }
                g2 = g(this.a, lVar2, lVar12, lVar11, lVar, i5, c6);
            }
            return new f(g2, new l[]{lVar2, lVar12, lVar11, lVar});
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
