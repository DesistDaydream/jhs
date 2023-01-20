package com.bytedance.pangle;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public final class LocalBroadcastManager {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f2192f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static LocalBroadcastManager f2193g;
    private final Context a;
    private final HashMap<PluginBroadcastReceiver, ArrayList<b>> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, ArrayList<b>> f2194c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<a> f2195d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final Handler f2196e;

    /* loaded from: classes.dex */
    public static final class a {
        public final Intent a;
        public final ArrayList<b> b;

        public a(Intent intent, ArrayList<b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public final IntentFilter a;
        public final PluginBroadcastReceiver b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2197c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2198d;

        public b(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
            this.a = intentFilter;
            this.b = pluginBroadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.a);
            if (this.f2198d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.a = context;
        this.f2196e = new Handler(context.getMainLooper()) { // from class: com.bytedance.pangle.LocalBroadcastManager.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.a();
                }
            }
        };
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (f2192f) {
            if (f2193g == null) {
                f2193g = new LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = f2193g;
        }
        return localBroadcastManager;
    }

    public final void a() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.b) {
                size = this.f2195d.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.f2195d.toArray(aVarArr);
                this.f2195d.clear();
            }
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = aVarArr[i2];
                int size2 = aVar.b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    b bVar = aVar.b.get(i3);
                    if (!bVar.f2198d) {
                        bVar.b.onReceive(this.a, aVar.a);
                    }
                }
            }
        }
    }

    public final void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.b) {
            b bVar = new b(intentFilter, pluginBroadcastReceiver);
            ArrayList<b> arrayList = this.b.get(pluginBroadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.b.put(pluginBroadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<b> arrayList2 = this.f2194c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f2194c.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public final boolean sendBroadcast(Intent intent) {
        int i2;
        String str;
        ArrayList arrayList;
        ArrayList<b> arrayList2;
        String str2;
        synchronized (this.b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList3 = this.f2194c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    b bVar = arrayList3.get(i3);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + bVar.a);
                    }
                    if (bVar.f2197c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i2 = i3;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i2 = i3;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = bVar.a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.f2197c = true;
                            i3 = i2 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: ".concat(match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i3 = i2 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                        ((b) arrayList5.get(i4)).f2197c = false;
                    }
                    this.f2195d.add(new a(intent, arrayList5));
                    if (!this.f2196e.hasMessages(1)) {
                        this.f2196e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public final void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            a();
        }
    }

    public final void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
        synchronized (this.b) {
            ArrayList<b> remove = this.b.remove(pluginBroadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                b bVar = remove.get(size);
                bVar.f2198d = true;
                for (int i2 = 0; i2 < bVar.a.countActions(); i2++) {
                    String action = bVar.a.getAction(i2);
                    ArrayList<b> arrayList = this.f2194c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            b bVar2 = arrayList.get(size2);
                            if (bVar2.b == pluginBroadcastReceiver) {
                                bVar2.f2198d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f2194c.remove(action);
                        }
                    }
                }
            }
        }
    }
}
