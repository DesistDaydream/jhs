package com.tencent.qcloud.tuicore.component.imageEngine.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.bumptech.glide.Priority;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.imageEngine.ImageEngine;
import e.b.a.c;
import e.b.a.i;
import e.b.a.t.g;
import e.b.a.t.h;
import java.io.File;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
public class GlideEngine implements ImageEngine {
    public static void clear(ImageView imageView) {
        try {
            c.D(TUILogin.getAppContext()).q(imageView);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static Bitmap loadBitmap(Object obj, int i2) throws InterruptedException, ExecutionException {
        if (obj == null) {
            return null;
        }
        return c.D(TUILogin.getAppContext()).m().h(obj).l(new h().z(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).i1(i2, i2).get();
    }

    public static void loadCornerImage(ImageView imageView, String str, g gVar, float f2) {
        CornerTransform cornerTransform = new CornerTransform(TUILogin.getAppContext(), f2);
        c.D(TUILogin.getAppContext()).k(str).l(new h().n().y0(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon)).L0(cornerTransform)).o1(gVar).m1(imageView);
    }

    public static void loadCornerImageWithoutPlaceHolder(ImageView imageView, String str, g gVar, float f2) {
        CornerTransform cornerTransform = new CornerTransform(TUILogin.getAppContext(), f2);
        c.D(TUILogin.getAppContext()).k(str).l(new h().n().L0(cornerTransform)).o1(gVar).m1(imageView);
    }

    public static void loadImage(ImageView imageView, String str, int i2, float f2) {
        loadCornerImage(imageView, str, null, f2);
    }

    public static void loadProfileImage(ImageView imageView, String str, g gVar) {
        c.D(TUILogin.getAppContext()).k(str).o1(gVar).l(new h().z(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).m1(imageView);
    }

    private static i<Drawable> loadTransform(Context context, @DrawableRes int i2, float f2) {
        return c.D(context).j(Integer.valueOf(i2)).l(new h().n().L0(new CornerTransform(context, f2)));
    }

    public static void loadUserIcon(ImageView imageView, Object obj) {
        loadUserIcon(imageView, obj, 0);
    }

    @Override // com.tencent.qcloud.tuicore.component.imageEngine.ImageEngine
    public void loadGifImage(Context context, int i2, int i3, ImageView imageView, Uri uri) {
        c.D(context).p().b(uri).l(new h().x0(i2, i3).A0(Priority.HIGH).D()).m1(imageView);
    }

    @Override // com.tencent.qcloud.tuicore.component.imageEngine.ImageEngine
    public void loadGifThumbnail(Context context, int i2, Drawable drawable, ImageView imageView, Uri uri) {
        c.D(context).m().b(uri).l(new h().x0(i2, i2).z0(drawable).n()).m1(imageView);
    }

    @Override // com.tencent.qcloud.tuicore.component.imageEngine.ImageEngine
    public void loadThumbnail(Context context, int i2, Drawable drawable, ImageView imageView, Uri uri) {
        c.D(context).m().b(uri).l(new h().x0(i2, i2).z0(drawable).n()).m1(imageView);
    }

    @Override // com.tencent.qcloud.tuicore.component.imageEngine.ImageEngine
    public boolean supportAnimatedGif() {
        return true;
    }

    public static void loadImage(ImageView imageView, String str, g gVar) {
        c.D(TUILogin.getAppContext()).k(str).o1(gVar).l(new h().z(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).m1(imageView);
    }

    public static void loadUserIcon(ImageView imageView, Object obj, int i2) {
        try {
            i<Drawable> h2 = c.D(TUILogin.getAppContext()).h(obj);
            Context appContext = TUILogin.getAppContext();
            int i3 = R.attr.core_default_user_icon;
            h2.y0(TUIThemeManager.getAttrResId(appContext, i3)).l(new h().n().z(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), i3))).m1(imageView);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void loadImage(ImageView imageView, String str) {
        c.D(TUILogin.getAppContext()).k(str).l(new h().z(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).m1(imageView);
    }

    public static void loadUserIcon(ImageView imageView, Object obj, int i2, int i3) {
        try {
            c.D(TUILogin.getAppContext()).h(obj).y0(i2).l(new h().n().z(i2)).m1(imageView);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void loadImage(ImageView imageView, Uri uri) {
        if (uri == null) {
            return;
        }
        c.D(TUILogin.getAppContext()).b(uri).l(new h().z(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).m1(imageView);
    }

    public static void loadImage(String str, String str2) {
        try {
            c.D(TUILogin.getAppContext()).o().k(str2).C1().get().renameTo(new File(str));
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        } catch (ExecutionException e3) {
            e3.printStackTrace();
        }
    }

    public static void loadImage(ImageView imageView, Object obj) {
        if (obj == null) {
            return;
        }
        c.D(TUILogin.getAppContext()).h(obj).l(new h().z(TUIThemeManager.getAttrResId(TUILogin.getAppContext(), R.attr.core_default_user_icon))).m1(imageView);
    }

    @Override // com.tencent.qcloud.tuicore.component.imageEngine.ImageEngine
    public void loadImage(Context context, int i2, int i3, ImageView imageView, Uri uri) {
        c.D(context).b(uri).l(new h().x0(i2, i3).A0(Priority.HIGH).D()).m1(imageView);
    }
}
