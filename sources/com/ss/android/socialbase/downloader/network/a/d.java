package com.ss.android.socialbase.downloader.network.a;

import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes3.dex */
public class d implements i {
    public final Object a;
    private final List<com.ss.android.socialbase.downloader.model.c> b;

    /* renamed from: c  reason: collision with root package name */
    private i f5852c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5853d;

    /* renamed from: e  reason: collision with root package name */
    private long f5854e;

    /* renamed from: f  reason: collision with root package name */
    private InputStream f5855f;

    @Override // com.ss.android.socialbase.downloader.network.i
    public InputStream a() throws IOException {
        InputStream inputStream = this.f5855f;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    public boolean a(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public int b() throws IOException {
        i iVar = this.f5852c;
        if (iVar != null) {
            return iVar.b();
        }
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public void c() {
        i iVar = this.f5852c;
        if (iVar != null) {
            iVar.c();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.i
    public void d() {
        i iVar = this.f5852c;
        if (iVar != null) {
            iVar.d();
        }
    }

    public void e() throws InterruptedException {
        synchronized (this.a) {
            if (this.f5853d && this.f5852c == null) {
                this.a.wait();
            }
        }
    }

    public List<com.ss.android.socialbase.downloader.model.c> f() {
        return this.b;
    }

    public boolean g() {
        try {
            i iVar = this.f5852c;
            if (iVar != null) {
                return a(iVar.b());
            }
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean h() {
        return System.currentTimeMillis() - this.f5854e < b.a;
    }

    @Override // com.ss.android.socialbase.downloader.network.g
    public String a(String str) {
        i iVar = this.f5852c;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }
}
