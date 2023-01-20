package e.j.a.c.b;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.R;
import e.j.a.c.s.m;

@RequiresApi(21)
/* loaded from: classes2.dex */
public class b {
    private static final int[] a = {16843848};

    public static void a(@NonNull View view) {
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
    }

    public static void b(@NonNull View view, float f2) {
        int integer = view.getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j2 = integer;
        stateListAnimator.addState(new int[]{16842766, R.attr.state_liftable, -R.attr.state_lifted}, ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(j2));
        stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(view, "elevation", f2).setDuration(j2));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", 0.0f).setDuration(0L));
        view.setStateListAnimator(stateListAnimator);
    }

    public static void c(@NonNull View view, AttributeSet attributeSet, int i2, int i3) {
        Context context = view.getContext();
        TypedArray j2 = m.j(context, attributeSet, a, i2, i3, new int[0]);
        try {
            if (j2.hasValue(0)) {
                view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(context, j2.getResourceId(0, 0)));
            }
        } finally {
            j2.recycle();
        }
    }
}
