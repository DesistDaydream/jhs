package e.j.a.c.a;

import android.animation.TypeEvaluator;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class c implements TypeEvaluator<Integer> {
    private static final c a = new c();

    @NonNull
    public static c b() {
        return a;
    }

    @Override // android.animation.TypeEvaluator
    @NonNull
    /* renamed from: a */
    public Integer evaluate(float f2, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f3 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = num2.intValue();
        float pow = (float) Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((intValue & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d);
        float pow5 = pow3 + (f2 * (((float) Math.pow((intValue2 & 255) / 255.0f, 2.2d)) - pow3));
        return Integer.valueOf((Math.round(((float) Math.pow(pow + ((pow4 - pow) * f2), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round((f3 + (((((intValue2 >> 24) & 255) / 255.0f) - f3) * f2)) * 255.0f) << 24) | (Math.round(((float) Math.pow(pow2 + ((((float) Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d)) - pow2) * f2), 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow(pow5, 0.45454545454545453d)) * 255.0f));
    }
}
