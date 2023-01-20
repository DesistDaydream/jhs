package com.huawei.hms.hatool;

import android.os.Build;
import android.util.Log;

/* loaded from: classes2.dex */
public class z {
    public boolean a = false;
    public int b = 4;

    public static String a() {
        return "FormalHASDK_2.2.0.313" + k1.a();
    }

    public void a(int i2) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 19) {
            sb.append(System.lineSeparator());
            sb.append("======================================= ");
            sb.append(System.lineSeparator());
            sb.append(a());
            sb.append("");
            sb.append(System.lineSeparator());
            str = "=======================================";
        } else {
            sb.append("====================");
            sb.append(a());
            str = "===================";
        }
        sb.append(str);
        Log.i("FormalHASDK", sb.toString());
        this.b = i2;
        this.a = true;
    }

    public void a(int i2, String str, String str2) {
        if (i2 == 3) {
            Log.d(str, str2);
        } else if (i2 == 5) {
            Log.w(str, str2);
        } else if (i2 != 6) {
            Log.i(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public void b(int i2, String str, String str2) {
        a(i2, "FormalHASDK", str + "=> " + str2);
    }

    public boolean b(int i2) {
        return this.a && i2 >= this.b;
    }
}
