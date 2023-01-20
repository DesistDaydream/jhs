package e.l.r;

import android.app.Activity;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.ui.page.web.CommonWebViewActivityCreator;

/* loaded from: classes2.dex */
public final class n0 {
    @k.e.a.d
    public static final n0 a = new n0();

    private n0() {
    }

    public final void a(@k.e.a.d Activity activity) {
        CommonWebViewActivityCreator.create(h.k2.v.f0.C("https://yzf.qq.com/xv/web/static/chat/index.html?sign=37ef9b97d07054c2204599bc19b2b461c769d021c12da3ce39bd24ee3fa38d322fdd30821c61282722ec3083bacd253264c9d271&c1=", Integer.valueOf(UserKV.f3913c.v()))).start(activity);
    }
}
