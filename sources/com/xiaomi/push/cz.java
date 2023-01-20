package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class cz extends m.a {
    private Context a;
    private SharedPreferences b;

    /* renamed from: c */
    private com.xiaomi.push.service.ad f8357c;

    public cz(Context context) {
        this.a = context;
        this.b = context.getSharedPreferences("mipush_extra", 0);
        this.f8357c = com.xiaomi.push.service.ad.a(context);
    }

    private List<gy> a(File file) {
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        cq b = cr.a().b();
        String a = b == null ? "" : b.a();
        FileLock fileLock = null;
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (cu.a) {
            try {
                File file2 = new File(this.a.getExternalFilesDir(null), "push_cdata.lock");
                c.b(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    FileLock lock = randomAccessFile.getChannel().lock();
                    try {
                        fileInputStream = new FileInputStream(file);
                        while (fileInputStream.read(bArr) == 4) {
                            try {
                                int a2 = g.a(bArr);
                                byte[] bArr2 = new byte[a2];
                                if (fileInputStream.read(bArr2) != a2) {
                                    break;
                                }
                                byte[] a3 = ct.a(a, bArr2);
                                if (a3 != null && a3.length != 0) {
                                    gy gyVar = new gy();
                                    ib.a(gyVar, a3);
                                    arrayList.add(gyVar);
                                    a(gyVar);
                                }
                            } catch (Exception unused) {
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused2) {
                                    }
                                }
                                c.a(fileInputStream);
                                c.a(randomAccessFile);
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                fileLock = lock;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException unused3) {
                                    }
                                }
                                c.a(fileInputStream);
                                c.a(randomAccessFile);
                                throw th;
                            }
                        }
                        if (lock != null && lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException unused4) {
                            }
                        }
                        c.a(fileInputStream);
                    } catch (Exception unused5) {
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = null;
                    }
                } catch (Exception unused6) {
                    fileInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                }
            } catch (Exception unused7) {
                randomAccessFile = null;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                fileInputStream = null;
            }
            c.a(randomAccessFile);
        }
        return arrayList;
    }

    private void a(gy gyVar) {
        if (gyVar.b != gs.AppInstallList || gyVar.f8736c.startsWith("same_")) {
            return;
        }
        SharedPreferences.Editor edit = this.b.edit();
        edit.putLong("dc_job_result_time_4", gyVar.a);
        edit.putString("dc_job_result_4", ar.a(gyVar.f8736c));
        edit.commit();
    }

    private boolean b() {
        if (al.f(this.a)) {
            return false;
        }
        if ((al.h(this.a) || al.g(this.a)) && !d()) {
            return true;
        }
        return (al.i(this.a) && !c()) || al.j(this.a);
    }

    private boolean c() {
        if (this.f8357c.a(gv.Upload3GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.b.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max((int) RemoteMessageConst.DEFAULT_TTL, this.f8357c.a(gv.Upload3GFrequency.a(), 432000)));
        }
        return false;
    }

    private boolean d() {
        if (this.f8357c.a(gv.Upload4GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.b.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max((int) RemoteMessageConst.DEFAULT_TTL, this.f8357c.a(gv.Upload4GFrequency.a(), 259200)));
        }
        return false;
    }

    private void e() {
        SharedPreferences.Editor edit = this.b.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    @Override // com.xiaomi.push.m.a
    public String a() {
        return "1";
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.a.getExternalFilesDir(null), "push_cdata.data");
        if (!al.e(this.a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (!b() && file.exists()) {
            List<gy> a = a(file);
            if (!h.a(a)) {
                int size = a.size();
                if (size > 4000) {
                    a = a.subList(size - 4000, size);
                }
                hk hkVar = new hk();
                hkVar.a(a);
                byte[] a2 = c.a(ib.a(hkVar));
                hq hqVar = new hq(GMNetworkPlatformConst.AD_NETWORK_NO_PRICE, false);
                hqVar.c(ha.DataCollection.ah);
                hqVar.a(a2);
                cq b = cr.a().b();
                if (b != null) {
                    b.a(hqVar, gq.Notification, null);
                }
                e();
            }
            file.delete();
        }
    }
}
