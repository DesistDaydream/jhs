package com.ss.android.downloadlib.addownload.c;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class d {
    private static volatile d a;
    private long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<String, e> f5265c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, Integer> f5266d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private List<String> f5267e = new CopyOnWriteArrayList();

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public long b() {
        return this.b;
    }

    public void c() {
        this.b = System.currentTimeMillis();
    }

    public int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.f5266d == null) {
            this.f5266d = new HashMap<>();
        }
        if (this.f5266d.containsKey(str)) {
            return this.f5266d.get(str).intValue();
        }
        return 0;
    }

    public void a(String str, e eVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5265c.put(str, eVar);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5265c.remove(str);
    }

    @WorkerThread
    public static void a(com.ss.android.downloadad.api.a.b bVar) {
        DownloadInfo downloadInfo;
        if (bVar == null || bVar.b() <= 0 || (downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(bVar.s())) == null) {
            return;
        }
        a(downloadInfo);
    }

    @WorkerThread
    public static void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
