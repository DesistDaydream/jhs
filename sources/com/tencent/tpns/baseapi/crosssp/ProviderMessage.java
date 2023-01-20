package com.tencent.tpns.baseapi.crosssp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Process;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.tpns.baseapi.base.SettingsContentProvider;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class ProviderMessage {
    private static SettingsContentProvider a;
    private static ConcurrentHashMap<String, List<Long>> b = new ConcurrentHashMap<>();

    /* loaded from: classes3.dex */
    public static class a<T> extends TTask {
        public static long a;
        public static long b;

        /* renamed from: c  reason: collision with root package name */
        public static long f6901c;

        /* renamed from: d  reason: collision with root package name */
        public static long f6902d;

        /* renamed from: e  reason: collision with root package name */
        private Context f6903e;

        /* renamed from: g  reason: collision with root package name */
        private Uri f6904g;

        /* renamed from: h  reason: collision with root package name */
        private String[] f6905h;

        /* renamed from: i  reason: collision with root package name */
        private String f6906i;

        /* renamed from: j  reason: collision with root package name */
        private String[] f6907j;

        /* renamed from: k  reason: collision with root package name */
        private String f6908k;

        /* renamed from: l  reason: collision with root package name */
        private ContentValues f6909l;

        /* renamed from: m  reason: collision with root package name */
        private String f6910m;
        private int n = 4;
        private boolean o;
        private T p;

        public a(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2, boolean z) {
            this.f6903e = context;
            this.f6904g = uri;
            this.f6905h = strArr;
            this.f6906i = str;
            this.f6907j = strArr2;
            this.f6908k = str2;
            this.o = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.tpns.baseapi.base.util.TTask
        public void TRun() {
            Object query;
            try {
                int i2 = this.n;
                if (i2 != 1) {
                    if (i2 == 2) {
                        query = this.o ? ProviderMessage.b().insert(this.f6904g, this.f6909l) : this.f6903e.getContentResolver().insert(this.f6904g, this.f6909l);
                    } else if (i2 == 3) {
                        query = this.o ? ProviderMessage.b().getType(this.f6904g) : this.f6903e.getContentResolver().getType(this.f6904g);
                    } else if (i2 != 4) {
                        query = i2 != 5 ? null : Integer.valueOf(this.f6903e.getContentResolver().delete(this.f6904g, this.f6910m, this.f6907j));
                    } else {
                        query = Integer.valueOf(this.f6903e.getContentResolver().update(this.f6904g, this.f6909l, this.f6910m, this.f6907j));
                    }
                } else if (this.o) {
                    query = ProviderMessage.b().query(this.f6904g, this.f6905h, this.f6906i, this.f6907j, this.f6908k);
                } else {
                    query = this.f6903e.getContentResolver().query(this.f6904g, this.f6905h, this.f6906i, this.f6907j, this.f6908k);
                }
                a(query);
            } catch (Throwable th) {
                Logger.e("ProviderMessage", "call", th);
            }
        }

        public T a() {
            return this.p;
        }

        public void a(T t) {
            this.p = t;
        }

        public static Cursor a(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            boolean z;
            if (!ProviderMessage.b(context, uri)) {
                z = false;
            } else if (Thread.currentThread().getId() != context.getMainLooper().getThread().getId()) {
                return ProviderMessage.b().query(uri, strArr, str, strArr2, str2);
            } else {
                z = true;
            }
            a aVar = new a(context, uri, strArr, str, strArr2, str2, z);
            Thread thread = new Thread(aVar);
            StringBuilder sb = new StringBuilder();
            sb.append("tpnsQ-");
            long j2 = a;
            a = 1 + j2;
            sb.append(j2);
            thread.setName(sb.toString());
            thread.start();
            try {
                thread.join(1000L);
            } catch (Throwable th) {
                Logger.e("ProviderMessage", "myQuery", th);
            }
            return (Cursor) aVar.a();
        }

        public a(Context context, Uri uri, ContentValues contentValues, boolean z) {
            this.f6903e = context;
            this.f6904g = uri;
            this.f6909l = contentValues;
            this.o = z;
        }

        public static Uri a(Context context, Uri uri, ContentValues contentValues) {
            boolean z;
            if (!ProviderMessage.b(context, uri)) {
                z = false;
            } else if (Thread.currentThread().getId() != context.getMainLooper().getThread().getId()) {
                return ProviderMessage.b().insert(uri, contentValues);
            } else {
                z = true;
            }
            a aVar = new a(context, uri, contentValues, z);
            Thread thread = new Thread(aVar);
            StringBuilder sb = new StringBuilder();
            sb.append("tpnsT-");
            long j2 = b;
            b = 1 + j2;
            sb.append(j2);
            thread.setName(sb.toString());
            thread.start();
            try {
                thread.join(1000L);
            } catch (Throwable th) {
                Logger.e("ProviderMessage", "myInsert", th);
            }
            return (Uri) aVar.a();
        }

        public a(Context context, Uri uri, boolean z) {
            this.f6903e = context;
            this.f6904g = uri;
            this.o = z;
        }

        public a(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
            this.f6903e = context;
            this.f6904g = uri;
            this.f6909l = contentValues;
            this.f6910m = str;
            this.f6907j = strArr;
        }

        public static String a(Context context, Uri uri) {
            boolean z;
            int myPid = Process.myPid();
            if (!ProviderMessage.b(context, uri)) {
                z = false;
            } else if (Thread.currentThread().getId() != context.getMainLooper().getThread().getId()) {
                return ProviderMessage.b().getType(uri);
            } else {
                z = true;
            }
            a aVar = new a(context, uri, z);
            Thread thread = new Thread(aVar);
            StringBuilder sb = new StringBuilder();
            sb.append("tpnsT");
            sb.append(myPid);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            long j2 = f6901c;
            f6901c = 1 + j2;
            sb.append(j2);
            thread.setName(sb.toString());
            thread.start();
            try {
                thread.join(1000L);
            } catch (Throwable th) {
                Logger.e("ProviderMessage", "myGetType", th);
            }
            return (String) aVar.a();
        }

        public a(Context context, Uri uri, String str, String[] strArr) {
            this.f6903e = context;
            this.f6904g = uri;
            this.f6910m = str;
            this.f6907j = strArr;
        }

        public static int a(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
            a aVar = new a(context, uri, contentValues, str, strArr);
            Thread thread = new Thread(aVar);
            thread.setName("tpnsU");
            thread.start();
            try {
                thread.join(1000L);
            } catch (Throwable th) {
                Logger.e("ProviderMessage", "myUpdate", th);
            }
            return ((Integer) aVar.a()).intValue();
        }

        public static int a(Context context, Uri uri, String str, String[] strArr) {
            a aVar = new a(context, uri, str, strArr);
            Thread thread = new Thread(aVar);
            StringBuilder sb = new StringBuilder();
            sb.append("tpnsD-");
            long j2 = f6902d;
            f6902d = 1 + j2;
            sb.append(j2);
            thread.setName(sb.toString());
            thread.start();
            try {
                thread.join(1000L);
            } catch (Throwable th) {
                Logger.e("ProviderMessage", "myDelete", th);
            }
            return ((Integer) aVar.a()).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SettingsContentProvider b() {
        if (a == null) {
            a = new SettingsContentProvider();
        }
        return a;
    }

    public static int delete(Context context, String str, String str2, String str3, String[] strArr) {
        return delete(context, Uri.parse("content://" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + str2), str3, strArr);
    }

    public static String getType(Context context, Uri uri) {
        try {
            return a.a(context, uri);
        } catch (Throwable th) {
            Logger.e("ProviderMessage", "getType", th);
            return null;
        }
    }

    public static Uri insert(Context context, Uri uri, ContentValues contentValues) {
        try {
            return a.a(context, uri, contentValues);
        } catch (Throwable th) {
            Logger.e("ProviderMessage", "insert", th);
            return null;
        }
    }

    public static void log(String str) {
        Logger.d("ProviderMessage", "" + str);
    }

    public static Cursor query(Context context, String str, String str2, String[] strArr, String str3, String[] strArr2, String str4) {
        return query(context, Uri.parse("content://" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + str2), strArr, str3, strArr2, str4);
    }

    public static int update(Context context, String str, String str2, ContentValues contentValues, String str3, String[] strArr) {
        return update(context, Uri.parse("content://" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + str2), contentValues, str3, strArr);
    }

    public static String getType(Context context, String str, String str2) {
        return getType(context, Uri.parse("content://" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + str2));
    }

    public static Uri insert(Context context, String str, String str2, ContentValues contentValues) {
        return insert(context, Uri.parse("content://" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + str2), contentValues);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context, Uri uri) {
        System.nanoTime();
        int providerPid = SettingsContentProvider.getProviderPid();
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".");
        sb.append(SettingsContentProvider.PREFFERENCE_AUTHORITY);
        return myPid == providerPid && sb.toString().equals(uri.getHost());
    }

    public static int delete(Context context, Uri uri, String str, String[] strArr) {
        try {
            return a.a(context, uri, str, strArr);
        } catch (Throwable th) {
            Logger.e("ProviderMessage", "delete", th);
            return 0;
        }
    }

    public static Cursor query(Context context, Uri uri, String[] strArr, String str) {
        return query(context, uri, strArr, str, null, null);
    }

    public static int update(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            return a.a(context, uri, contentValues, str, strArr);
        } catch (Throwable th) {
            Logger.e("ProviderMessage", "update", th);
            return 0;
        }
    }

    public static Cursor query(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return a.a(context, uri, strArr, str, strArr2, str2);
        } catch (Throwable th) {
            Logger.e("ProviderMessage", "query", th);
            return null;
        }
    }
}
