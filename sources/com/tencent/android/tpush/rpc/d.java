package com.tencent.android.tpush.rpc;

import android.content.Intent;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.e;
import com.tencent.android.tpush.rpc.a;

/* loaded from: classes3.dex */
public class d extends a.AbstractBinderC0223a {
    @Override // com.tencent.android.tpush.rpc.a
    @JgMethodChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.INTENTSCHEMECHECK, EType.INTENTCHECK})
    public void a(String str, b bVar) {
        try {
            e.a(com.tencent.android.tpush.service.b.e()).a(Intent.parseUri(str, 0));
            bVar.a();
        } catch (Throwable th) {
            TLogger.e("ITaskImpl", "Show", th);
        }
    }

    @Override // com.tencent.android.tpush.rpc.a
    public void b() {
    }

    @Override // com.tencent.android.tpush.rpc.a
    public void a() {
        try {
            TLogger.d("ITaskImpl", "start XGService");
            com.tencent.android.tpush.service.b.a(com.tencent.android.tpush.service.b.e());
        } catch (Throwable th) {
            TLogger.e("ITaskImpl", "startService", th);
        }
    }
}
