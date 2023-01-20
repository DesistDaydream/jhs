package com.xiaomi.push;

import android.util.Log;
import android.util.Pair;
import com.bytedance.msdk.api.AdError;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public class co implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Throwable b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ cn f8353c;

    public co(cn cnVar, String str, Throwable th) {
        this.f8353c = cnVar;
        this.a = str;
        this.b = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list;
        SimpleDateFormat simpleDateFormat;
        String str;
        List list2;
        String str2;
        String str3;
        List list3;
        List list4;
        SimpleDateFormat simpleDateFormat2;
        String str4;
        List list5;
        List list6;
        list = cn.f8347f;
        simpleDateFormat = cn.b;
        str = this.f8353c.f8349c;
        list.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat.format(new Date()), str, this.a), this.b));
        list2 = cn.f8347f;
        if (list2.size() > 20000) {
            list3 = cn.f8347f;
            int size = (list3.size() - AdError.ERROR_CODE_AD_LOAD_SUCCESS) + 50;
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    list5 = cn.f8347f;
                    if (list5.size() > 0) {
                        list6 = cn.f8347f;
                        list6.remove(0);
                    }
                } catch (IndexOutOfBoundsException unused) {
                }
            }
            list4 = cn.f8347f;
            simpleDateFormat2 = cn.b;
            str4 = this.f8353c.f8349c;
            list4.add(new Pair(String.format("%1$s %2$s %3$s ", simpleDateFormat2.format(new Date()), str4, "flush " + size + " lines logs."), null));
        }
        try {
            if (e.d()) {
                this.f8353c.c();
                return;
            }
            str3 = this.f8353c.f8349c;
            Log.w(str3, "SDCard is unavailable.");
        } catch (Exception e2) {
            str2 = this.f8353c.f8349c;
            Log.e(str2, "", e2);
        }
    }
}
