package e.l.r;

import android.net.Uri;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;
import h.t1;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class l0 {
    @k.e.a.d
    public static final l0 a = new l0();
    @k.e.a.d
    private static final UploadManager b = new UploadManager(new Configuration.Builder().connectTimeout(90).useHttps(true).useConcurrentResumeUpload(true).concurrentTaskCount(3).responseTimeout(90).build());

    private l0() {
    }

    public static final void e(h.k2.u.l lVar, String str, ResponseInfo responseInfo, JSONObject jSONObject) {
        e.l.h.k.b bVar = e.l.h.k.b.a;
        bVar.d("qiniu", ((Object) str) + ",\r\n " + responseInfo + ",\r\n " + jSONObject);
        if (responseInfo.isOK()) {
            lVar.invoke(str);
        } else {
            lVar.invoke(null);
        }
    }

    public static final void f(h.k2.u.l lVar, String str, ResponseInfo responseInfo, JSONObject jSONObject) {
        e.l.h.k.b bVar = e.l.h.k.b.a;
        bVar.d("qiniu", ((Object) str) + ",\r\n " + responseInfo + ",\r\n " + jSONObject);
        if (responseInfo.isOK()) {
            lVar.invoke(str);
        } else {
            lVar.invoke(null);
        }
    }

    public final void c(@k.e.a.d Uri uri, @k.e.a.d String str, @k.e.a.d String str2, @k.e.a.d final h.k2.u.l<? super String, t1> lVar) {
        b.put(uri, e.t.a.b().getContentResolver(), str, str2, new UpCompletionHandler() { // from class: e.l.r.n
            @Override // com.qiniu.android.storage.UpCompletionHandler
            public final void complete(String str3, ResponseInfo responseInfo, JSONObject jSONObject) {
                l0.e(lVar, str3, responseInfo, jSONObject);
            }
        }, null);
    }

    public final void d(@k.e.a.d File file, @k.e.a.d String str, @k.e.a.d String str2, @k.e.a.d final h.k2.u.l<? super String, t1> lVar) {
        b.put(file.getAbsolutePath(), str, str2, new UpCompletionHandler() { // from class: e.l.r.m
            @Override // com.qiniu.android.storage.UpCompletionHandler
            public final void complete(String str3, ResponseInfo responseInfo, JSONObject jSONObject) {
                l0.f(lVar, str3, responseInfo, jSONObject);
            }
        }, (UploadOptions) null);
    }
}
