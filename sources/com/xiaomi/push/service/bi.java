package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.gq;
import com.xiaomi.push.hg;
import com.xiaomi.push.hi;
import com.xiaomi.push.hm;
import com.xiaomi.push.hn;
import com.xiaomi.push.hq;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.hw;
import com.xiaomi.push.hy;
import com.xiaomi.push.ia;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;

/* loaded from: classes3.dex */
public class bi {
    public static ic a(Context context, hn hnVar) {
        if (hnVar.c()) {
            return null;
        }
        byte[] f2 = hnVar.f();
        ic a = a(hnVar.a(), hnVar.f8856c);
        if (a != null) {
            ib.a(a, f2);
        }
        return a;
    }

    private static ic a(gq gqVar, boolean z) {
        switch (bj.a[gqVar.ordinal()]) {
            case 1:
                return new hs();
            case 2:
                return new hy();
            case 3:
                return new hw();
            case 4:
                return new ia();
            case 5:
                return new hu();
            case 6:
                return new hg();
            case 7:
                return new hm();
            case 8:
                return new ht();
            case 9:
                if (z) {
                    return new hq();
                }
                hi hiVar = new hi();
                hiVar.a(true);
                return hiVar;
            case 10:
                return new hm();
            default:
                return null;
        }
    }
}
