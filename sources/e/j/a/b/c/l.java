package e.j.a.b.c;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

/* loaded from: classes2.dex */
public class l extends DialogFragment {
    private Dialog a = null;
    private DialogInterface.OnCancelListener b = null;

    public static l p(Dialog dialog) {
        return q(dialog, null);
    }

    public static l q(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        l lVar = new l();
        Dialog dialog2 = (Dialog) e.j.a.b.c.r.a0.l(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        lVar.a = dialog2;
        if (onCancelListener != null) {
            lVar.b = onCancelListener;
        }
        return lVar;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.a == null) {
            setShowsDialog(false);
        }
        return this.a;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
