package org.ahocorasick.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k.a.a.c;

/* loaded from: classes4.dex */
public class IntervalNode {
    private IntervalNode a;
    private IntervalNode b;

    /* renamed from: c  reason: collision with root package name */
    private int f17113c;

    /* renamed from: d  reason: collision with root package name */
    private List<c> f17114d = new ArrayList();

    /* loaded from: classes4.dex */
    public enum Direction {
        LEFT,
        RIGHT
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Direction.values().length];
            a = iArr;
            try {
                iArr[Direction.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Direction.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public IntervalNode(List<c> list) {
        this.f17113c = e(list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (c cVar : list) {
            if (cVar.H() < this.f17113c) {
                arrayList.add(cVar);
            } else if (cVar.getStart() > this.f17113c) {
                arrayList2.add(cVar);
            } else {
                this.f17114d.add(cVar);
            }
        }
        if (arrayList.size() > 0) {
            this.a = new IntervalNode(arrayList);
        }
        if (arrayList2.size() > 0) {
            this.b = new IntervalNode(arrayList2);
        }
    }

    public void a(c cVar, List<c> list, List<c> list2) {
        for (c cVar2 : list2) {
            if (!cVar2.equals(cVar)) {
                list.add(cVar2);
            }
        }
    }

    public List<c> b(c cVar, Direction direction) {
        ArrayList arrayList = new ArrayList();
        for (c cVar2 : this.f17114d) {
            int i2 = a.a[direction.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 && cVar2.H() >= cVar.getStart()) {
                    arrayList.add(cVar2);
                }
            } else if (cVar2.getStart() <= cVar.H()) {
                arrayList.add(cVar2);
            }
        }
        return arrayList;
    }

    public List<c> c(c cVar) {
        return b(cVar, Direction.LEFT);
    }

    public List<c> d(c cVar) {
        return b(cVar, Direction.RIGHT);
    }

    public int e(List<c> list) {
        int i2 = -1;
        int i3 = -1;
        for (c cVar : list) {
            int start = cVar.getStart();
            int H = cVar.H();
            if (i2 == -1 || start < i2) {
                i2 = start;
            }
            if (i3 == -1 || H > i3) {
                i3 = H;
            }
        }
        return (i2 + i3) / 2;
    }

    public List<c> f(IntervalNode intervalNode, c cVar) {
        if (intervalNode == null) {
            return Collections.emptyList();
        }
        return intervalNode.g(cVar);
    }

    public List<c> g(c cVar) {
        ArrayList arrayList = new ArrayList();
        if (this.f17113c < cVar.getStart()) {
            a(cVar, arrayList, f(this.b, cVar));
            a(cVar, arrayList, d(cVar));
        } else if (this.f17113c > cVar.H()) {
            a(cVar, arrayList, f(this.a, cVar));
            a(cVar, arrayList, c(cVar));
        } else {
            a(cVar, arrayList, this.f17114d);
            a(cVar, arrayList, f(this.a, cVar));
            a(cVar, arrayList, f(this.b, cVar));
        }
        return arrayList;
    }
}
