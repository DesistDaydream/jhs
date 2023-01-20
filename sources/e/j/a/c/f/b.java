package e.j.a.c.f;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes2.dex */
public class b extends AppCompatDialogFragment {
    private boolean waitingForDismissAllowingStateLoss;

    /* renamed from: e.j.a.c.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0358b extends BottomSheetBehavior.g {
        private C0358b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onSlide(@NonNull View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onStateChanged(@NonNull View view, int i2) {
            if (i2 == 5) {
                b.this.dismissAfterAnimation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void dismissWithAnimation(@NonNull BottomSheetBehavior<?> bottomSheetBehavior, boolean z) {
        this.waitingForDismissAllowingStateLoss = z;
        if (bottomSheetBehavior.I() == 5) {
            dismissAfterAnimation();
            return;
        }
        if (getDialog() instanceof e.j.a.c.f.a) {
            ((e.j.a.c.f.a) getDialog()).i();
        }
        bottomSheetBehavior.o(new C0358b());
        bottomSheetBehavior.e0(5);
    }

    private boolean tryDismissWithAnimation(boolean z) {
        Dialog dialog = getDialog();
        if (dialog instanceof e.j.a.c.f.a) {
            e.j.a.c.f.a aVar = (e.j.a.c.f.a) dialog;
            BottomSheetBehavior<FrameLayout> f2 = aVar.f();
            if (f2.N() && aVar.g()) {
                dismissWithAnimation(f2, z);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (tryDismissWithAnimation(false)) {
            return;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (tryDismissWithAnimation(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        return new e.j.a.c.f.a(getContext(), getTheme());
    }
}
