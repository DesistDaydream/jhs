package e.q.a.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.permissionx.guolindev.R;

/* loaded from: classes.dex */
public final class a implements ViewBinding {
    @NonNull
    private final LinearLayout a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f14387c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f14388d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f14389e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final Button f14390f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f14391g;

    private a(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull Button button, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull Button button2, @NonNull LinearLayout linearLayout4) {
        this.a = linearLayout;
        this.b = textView;
        this.f14387c = button;
        this.f14388d = linearLayout2;
        this.f14389e = linearLayout3;
        this.f14390f = button2;
        this.f14391g = linearLayout4;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i2 = R.id.messageText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i2);
        if (textView != null) {
            i2 = R.id.negativeBtn;
            Button button = (Button) ViewBindings.findChildViewById(view, i2);
            if (button != null) {
                i2 = R.id.negativeLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i2);
                if (linearLayout != null) {
                    i2 = R.id.permissionsLayout;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i2);
                    if (linearLayout2 != null) {
                        i2 = R.id.positiveBtn;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, i2);
                        if (button2 != null) {
                            i2 = R.id.positiveLayout;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i2);
                            if (linearLayout3 != null) {
                                return new a((LinearLayout) view, textView, button, linearLayout, linearLayout2, button2, linearLayout3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.permissionx_default_dialog_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.a;
    }
}
