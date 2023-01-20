package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class d extends c {
    private int h0;
    private int i0;

    public d(Context context, String str) {
        super(context, str);
        this.h0 = 0;
        this.i0 = -1;
    }

    private void k(int i2) {
        Integer num;
        Map<Integer, List<j>> map;
        List<j> list;
        if (i2 > this.i0) {
            this.i0 = i2;
            List<Integer> list2 = this.n;
            if (list2 == null || i2 >= list2.size() || (num = this.n.get(i2)) == null || (map = this.f895e) == null || !map.containsKey(num) || (list = this.f895e.get(num)) == null) {
                return;
            }
            this.h0 = list.size() + this.h0;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.f, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.e, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    public void a(int i2, boolean z) {
        try {
            k(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.a(i2, z);
    }

    public int d0() {
        int i2 = this.h0;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
                        case 22:
                        case 23:
                            c2 = ']';
                            c3 = ']';
                    }
                } else if (c2 != ']') {
                    c2 = ']';
                    c3 = ']';
                }
            }
            while (true) {
                switch (c3) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = '[';
                }
            }
        }
        return i2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c
    public int h() {
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
                        case 21:
                            return 2;
                        case 22:
                        case 23:
                            c2 = ']';
                            c3 = ']';
                    }
                } else if (c2 != ']') {
                    c2 = ']';
                    c3 = ']';
                }
            }
            while (true) {
                switch (c3) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        return 2;
                    default:
                        c3 = '[';
                }
            }
        }
    }
}
