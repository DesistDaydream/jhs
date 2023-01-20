package e.q.a.f;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class c extends Dialog {
    public c(@NonNull Context context) {
        super(context);
    }

    @Nullable
    public abstract View a();

    @NonNull
    public abstract List<String> b();

    @NonNull
    public abstract View c();

    public c(@NonNull Context context, int i2) {
        super(context, i2);
    }

    public c(@NonNull Context context, boolean z, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }
}
