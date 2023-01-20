package e.l.q.b.m;

import android.content.Intent;
import com.jihuanshe.ui.page.web.WebRequest;
import com.vector.design.ui.activity.SimpleActivityEx;
import com.vector.view.WebViewEx;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public interface b {
    boolean a(@d SimpleActivityEx simpleActivityEx, @d WebViewEx webViewEx, @d WebRequest webRequest);

    void onActivityResult(int i2, int i3, @e Intent intent);

    void onRequestPermissionsResult(int i2, @d String[] strArr, @d int[] iArr);
}
