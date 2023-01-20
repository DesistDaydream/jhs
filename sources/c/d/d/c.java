package c.d.d;

import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements OnReceiveContentViewBehavior {
    public static final /* synthetic */ c a = new c();

    @Override // androidx.core.view.OnReceiveContentViewBehavior
    public final ContentInfoCompat onReceiveContent(ContentInfoCompat contentInfoCompat) {
        ViewCompat.a(contentInfoCompat);
        return contentInfoCompat;
    }
}
