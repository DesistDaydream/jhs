package com.qiniu.android.common;

import com.qiniu.android.common.Zone;
import com.qiniu.android.storage.UpToken;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class FixedZone extends Zone {
    private ZonesInfo zonesInfo;
    public static final Zone zone0 = new FixedZone(new String[]{"upload.qiniup.com", "up.qiniup.com"}, new String[]{"upload.qbox.me", "up.qbox.me"}, "z0");
    public static final Zone zone1 = new FixedZone(new String[]{"upload-z1.qiniup.com", "up-z1.qiniup.com"}, new String[]{"upload-z1.qbox.me", "up-z1.qbox.me"}, "z1");
    public static final Zone zone2 = new FixedZone(new String[]{"upload-z2.qiniup.com", "up-z2.qiniup.com"}, new String[]{"upload-z2.qbox.me", "up-z2.qbox.me"}, "z2");
    public static final Zone zoneNa0 = new FixedZone(new String[]{"upload-na0.qiniup.com", "up-na0.qiniup.com"}, new String[]{"upload-na0.qbox.me", "up-na0.qbox.me"}, "na0");
    public static final Zone zoneAs0 = new FixedZone(new String[]{"upload-as0.qiniup.com", "up-as0.qiniup.com"}, new String[]{"upload-as0.qbox.me", "up-as0.qbox.me"}, "as0");
    public static final Zone zoneFogCnEast1 = new FixedZone(new String[]{"upload-fog-cn-east-1.qiniup.com", "up-fog-cn-east-1.qiniup.com"}, new String[]{"upload-fog-cn-east-1.qiniup.com", "up-fog-cn-east-1.qiniup.com"}, "fog-cn-east-1");

    public FixedZone(ZoneInfo zoneInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(zoneInfo);
        this.zonesInfo = new ZonesInfo(arrayList);
    }

    private ZonesInfo createZonesInfo(String[] strArr, String[] strArr2, String str) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ZoneInfo buildInfo = ZoneInfo.buildInfo(new ArrayList(Arrays.asList(strArr)), strArr2 != null ? new ArrayList(Arrays.asList(strArr2)) : null, str);
        if (buildInfo == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(buildInfo);
        return new ZonesInfo(arrayList);
    }

    public static FixedZone localsZoneInfo() {
        ArrayList<ZoneInfo> arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add((FixedZone) zone0);
        arrayList2.add((FixedZone) zone1);
        arrayList2.add((FixedZone) zone2);
        arrayList2.add((FixedZone) zoneNa0);
        arrayList2.add((FixedZone) zoneAs0);
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ZonesInfo zonesInfo = ((FixedZone) it.next()).zonesInfo;
            if (zonesInfo != null && (arrayList = zonesInfo.zonesInfo) != null) {
                arrayList3.addAll(arrayList);
            }
        }
        return new FixedZone(new ZonesInfo(arrayList3, true));
    }

    @Override // com.qiniu.android.common.Zone
    public ZonesInfo getZonesInfo(UpToken upToken) {
        return this.zonesInfo;
    }

    @Override // com.qiniu.android.common.Zone
    public void preQuery(UpToken upToken, Zone.QueryHandler queryHandler) {
        if (queryHandler != null) {
            queryHandler.complete(0, null, null);
        }
    }

    public FixedZone(ZonesInfo zonesInfo) {
        this.zonesInfo = zonesInfo;
    }

    public FixedZone(String[] strArr) {
        this(strArr, null);
    }

    public FixedZone(String[] strArr, String str) {
        this(strArr, null, str);
    }

    private FixedZone(String[] strArr, String[] strArr2, String str) {
        this.zonesInfo = createZonesInfo(strArr, strArr2, str);
    }
}
