package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.bm;

/* loaded from: classes3.dex */
public class bg extends bi {
    public bg(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static bg a(Context context, String str, int i2) {
        com.xiaomi.a.a.a.c.b("delete  messages when db size is too bigger");
        String a = bm.a(context).a(str);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("rowDataId in (select ");
        sb.append("rowDataId from " + a);
        sb.append(" order by createTimeStamp asc");
        sb.append(" limit ?)");
        return new bg(str, sb.toString(), new String[]{String.valueOf(i2)}, "a job build to delete history message");
    }

    private void a(long j2) {
        String[] strArr = ((bm.d) this).f8295d;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        strArr[0] = String.valueOf(j2);
    }

    @Override // com.xiaomi.push.bm.a
    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a = bs.a(c());
            long j2 = be.b;
            if (a <= j2) {
                com.xiaomi.a.a.a.c.b("db size is suitable");
                return;
            }
            long j3 = (long) ((((a - j2) * 1.2d) / j2) * longValue);
            a(j3);
            az a2 = az.a(context);
            a2.a("begin delete " + j3 + "noUpload messages , because db size is " + a + "B");
            super.a(context, obj);
        }
    }
}
