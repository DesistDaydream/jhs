package e.j.a.c.f0;

import android.content.Context;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* loaded from: classes2.dex */
public class a extends AccessibilityDelegateCompat {
    private final AccessibilityNodeInfoCompat.AccessibilityActionCompat a;

    public a(Context context, int i2) {
        this.a = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, context.getString(i2));
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.addAction(this.a);
    }
}
