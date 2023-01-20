package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* loaded from: classes3.dex */
public class i {
    public static int a(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) == 1024 ? 16973841 : 16973840;
    }

    public static void a(@NonNull View view, int i2, boolean z) {
        SizeUtil.init(view.getContext());
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(a(z ? SizeUtil.dp20 : 0));
        shapeDrawable.getPaint().setColor(i2);
        ViewCompat.setBackground(view, shapeDrawable);
    }

    public static Shape a(int i2) {
        float f2 = i2;
        return new RoundRectShape(new float[]{f2, f2, f2, f2, f2, f2, f2, f2}, null, null);
    }

    public static Animation a(long j2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        alphaAnimation.setDuration(j2);
        return alphaAnimation;
    }
}
