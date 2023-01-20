package com.m7.imkfsdk.chat.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class LoadingFragmentDialog extends DialogFragment {
    private boolean canTouchOutside = false;

    @Override // android.app.DialogFragment
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.ykfsdk_kf_dialog_loading, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.id_dialog_loading_msg)).setText(getActivity().getString(R.string.ykfsdk_ykf_wait));
        Dialog dialog = new Dialog(getActivity(), R.style.ykfsdk_dialog);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(this.canTouchOutside);
        return dialog;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.m7.imkfsdk.chat.dialog.LoadingFragmentDialog.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return i2 == 4;
            }
        });
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.canTouchOutside = z;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        if (isAdded()) {
            return;
        }
        try {
            super.show(fragmentManager, str);
        } catch (Exception unused) {
        }
    }
}
