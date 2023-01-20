package com.vector.view.swipe.header;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.vector.R;
import h.k2.u.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultHeader$animRotateUp$2 extends Lambda implements a<Animation> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultHeader$animRotateUp$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    public final Animation invoke() {
        return AnimationUtils.loadAnimation(this.$context, R.anim.rotate_up_opposite);
    }
}
