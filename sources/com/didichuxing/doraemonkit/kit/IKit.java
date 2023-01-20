package com.didichuxing.doraemonkit.kit;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import h.i;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\u0006R\u0016\u0010\u0010\u001a\u00020\r8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8g@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/didichuxing/doraemonkit/kit/IKit;", "", "Landroid/content/Context;", "context", "Lh/t1;", "onClick", "(Landroid/content/Context;)V", "Landroid/app/Activity;", "activity", "", "onClickWithReturn", "(Landroid/app/Activity;)Z", "onAppInit", "", "getName", "()I", "name", "getCategory", "category", "getIcon", "icon", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface IKit {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @i(message = "请使用onClickWithReturn代替")
        public static void onClick(IKit iKit, @e Context context) {
        }

        public static boolean onClickWithReturn(IKit iKit, @d Activity activity) {
            return true;
        }
    }

    int getCategory();

    @DrawableRes
    int getIcon();

    @StringRes
    int getName();

    void onAppInit(@e Context context);

    @i(message = "请使用onClickWithReturn代替")
    void onClick(@e Context context);

    boolean onClickWithReturn(@d Activity activity);
}
