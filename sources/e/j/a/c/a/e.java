package e.j.a.c.a;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class e extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> b = new e();
    private final WeakHashMap<Drawable, Integer> a;

    private e() {
        super(Integer.class, "drawableAlphaCompat");
        this.a = new WeakHashMap<>();
    }

    @Override // android.util.Property
    @Nullable
    /* renamed from: a */
    public Integer get(@NonNull Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Integer.valueOf(drawable.getAlpha());
        }
        if (this.a.containsKey(drawable)) {
            return this.a.get(drawable);
        }
        return 255;
    }

    @Override // android.util.Property
    /* renamed from: b */
    public void set(@NonNull Drawable drawable, @NonNull Integer num) {
        if (Build.VERSION.SDK_INT < 19) {
            this.a.put(drawable, num);
        }
        drawable.setAlpha(num.intValue());
    }
}
