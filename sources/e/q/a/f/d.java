package e.q.a.f;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class d extends DialogFragment {
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            dismiss();
        }
    }

    @Nullable
    public abstract View p();

    @NonNull
    public abstract List<String> q();

    @NonNull
    public abstract View r();
}
