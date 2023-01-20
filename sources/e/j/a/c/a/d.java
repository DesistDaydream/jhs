package e.j.a.c.a;

import android.util.Property;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.R;

/* loaded from: classes2.dex */
public class d extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> a = new d("childrenAlpha");

    private d(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    @NonNull
    /* renamed from: a */
    public Float get(@NonNull ViewGroup viewGroup) {
        Float f2 = (Float) viewGroup.getTag(R.id.mtrl_internal_children_alpha_tag);
        return f2 != null ? f2 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    /* renamed from: b */
    public void set(@NonNull ViewGroup viewGroup, @NonNull Float f2) {
        float floatValue = f2.floatValue();
        viewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(floatValue));
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setAlpha(floatValue);
        }
    }
}
