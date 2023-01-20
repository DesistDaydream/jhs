package e.l;

import com.jihuanshe.JApp;
import com.tencent.qcloud.tim.tuiofflinepush.IPushUploader;

/* loaded from: classes2.dex */
public final /* synthetic */ class b implements IPushUploader {
    public static final /* synthetic */ b a = new b();

    @Override // com.tencent.qcloud.tim.tuiofflinepush.IPushUploader
    public final void upload(String str) {
        JApp.A(str);
    }
}
