package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import com.xiaomi.push.jc;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class bz {
    private static List<a> a = new CopyOnWriteArrayList();

    /* loaded from: classes3.dex */
    public static class a {
        public final String a;
        public final long b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9137c;

        /* renamed from: d  reason: collision with root package name */
        public final Notification.Action[] f9138d;

        public a(String str, long j2, int i2, Notification.Action[] actionArr) {
            this.a = str;
            this.b = j2;
            this.f9137c = i2;
            this.f9138d = actionArr;
        }
    }

    private static void a() {
        for (int size = a.size() - 1; size >= 0; size--) {
            a aVar = a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.b > 5000) {
                a.remove(aVar);
            }
        }
        if (a.size() > 10) {
            a.remove(0);
        }
    }

    public static void a(Context context, StatusBarNotification statusBarNotification, int i2) {
        if (!jc.a(context) || i2 <= 0 || statusBarNotification == null || Build.VERSION.SDK_INT < 20) {
            return;
        }
        a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i2, aa.c(statusBarNotification.getNotification())));
    }

    private static void a(a aVar) {
        a.add(aVar);
        a();
    }
}
