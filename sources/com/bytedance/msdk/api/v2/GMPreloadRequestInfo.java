package com.bytedance.msdk.api.v2;

import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import java.util.List;

/* loaded from: classes.dex */
public class GMPreloadRequestInfo {
    private GMAdSlotBase a;
    private List<String> b;

    public GMPreloadRequestInfo(GMAdSlotBase gMAdSlotBase, List<String> list) {
        this.a = gMAdSlotBase;
        this.b = list;
    }

    public GMAdSlotBase getGmAdSlot() {
        return this.a;
    }

    public List<String> getPrimeRitList() {
        return this.b;
    }
}
