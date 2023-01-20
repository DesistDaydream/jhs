package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.bm;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class bh extends bm.b<Long> {
    private long a;

    /* renamed from: d  reason: collision with root package name */
    private String f8278d;

    public bh(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i2, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i2);
        this.a = 0L;
        this.f8278d = str6;
    }

    public static bh a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new bh(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
    }

    @Override // com.xiaomi.push.bm.b
    /* renamed from: a */
    public Long b(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    @Override // com.xiaomi.push.bm.a
    public Object a() {
        return Long.valueOf(this.a);
    }

    @Override // com.xiaomi.push.bm.b
    public void a(Context context, List<Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        this.a = list.get(0).longValue();
    }
}
