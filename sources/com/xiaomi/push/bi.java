package com.xiaomi.push;

import com.xiaomi.push.bm;

/* loaded from: classes3.dex */
public class bi extends bm.d {
    public String a;

    public bi(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr);
        this.a = "MessageDeleteJob";
        this.a = str3;
    }

    public static bi a(String str) {
        return new bi(str, "status = ?", new String[]{String.valueOf(2)}, "a job build to delete uploaded job");
    }
}
