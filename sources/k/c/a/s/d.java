package k.c.a.s;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/* loaded from: classes4.dex */
public class d {
    public static int a;
    public static Class<?> b;

    @TargetApi(11)
    /* loaded from: classes4.dex */
    public static class a extends DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            d.b(dialogInterface, i2, getActivity(), getArguments());
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return d.a(getActivity(), getArguments(), this);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends androidx.fragment.app.DialogFragment implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            d.b(dialogInterface, i2, getActivity(), getArguments());
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            return d.a(getActivity(), getArguments(), this);
        }
    }

    public static Dialog a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString(e.f16313d));
        builder.setMessage(bundle.getString(e.f16314e));
        int i2 = a;
        if (i2 != 0) {
            builder.setIcon(i2);
        }
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }

    public static void b(DialogInterface dialogInterface, int i2, Activity activity, Bundle bundle) {
        Class<?> cls = b;
        if (cls != null) {
            try {
                e.a.a.c().q(cls.newInstance());
            } catch (Exception e2) {
                throw new RuntimeException("Event cannot be constructed", e2);
            }
        }
        if (!bundle.getBoolean(e.f16315f, false) || activity == null) {
            return;
        }
        activity.finish();
    }
}
