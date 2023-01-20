package com.m7.imkfsdk.view;

import android.app.Dialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.utils.ToastUtils;
import e.j.a.c.f.a;
import e.j.a.c.f.b;

/* loaded from: classes2.dex */
public class NumClickBottomSheetDialog extends b {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public a dialog;
    public BottomSheetBehavior mBehavior;
    public Context mContext;
    public View rootView;

    public static NumClickBottomSheetDialog instance(String str) {
        NumClickBottomSheetDialog numClickBottomSheetDialog = new NumClickBottomSheetDialog();
        Bundle bundle = new Bundle();
        bundle.putString("num", str);
        numClickBottomSheetDialog.setArguments(bundle);
        return numClickBottomSheetDialog;
    }

    public void close(boolean z) {
        if (z) {
            BottomSheetBehavior bottomSheetBehavior = this.mBehavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.e0(5);
                return;
            }
            return;
        }
        dismiss();
    }

    public boolean isShowing() {
        a aVar = this.dialog;
        return aVar != null && aVar.isShowing();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Override // e.j.a.c.f.b, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        this.dialog = (a) super.onCreateDialog(bundle);
        final String string = getArguments().getString("num");
        if (this.rootView == null) {
            View inflate = View.inflate(this.mContext, R.layout.ykfsdk_ykf_numclicklay, null);
            this.rootView = inflate;
            ((TextView) inflate.findViewById(R.id.tv_num_pop_num)).setText(string + ExpandableTextView.N + this.mContext.getString(R.string.ykfsdk_ykf_maybe_telphone));
            ((TextView) this.rootView.findViewById(R.id.tv_callnum)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.NumClickBottomSheetDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + string));
                    intent.setFlags(268435456);
                    NumClickBottomSheetDialog.this.mContext.startActivity(intent);
                    NumClickBottomSheetDialog.this.close(false);
                }
            });
            ((TextView) this.rootView.findViewById(R.id.tv_copynum)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.NumClickBottomSheetDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ((ClipboardManager) NumClickBottomSheetDialog.this.mContext.getSystemService("clipboard")).setText(string);
                    Context context = NumClickBottomSheetDialog.this.mContext;
                    ToastUtils.showShort(context, context.getString(R.string.ykfsdk_ykf_copyok));
                    NumClickBottomSheetDialog.this.close(false);
                }
            });
            ((TextView) this.rootView.findViewById(R.id.tv_backnum)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.NumClickBottomSheetDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    NumClickBottomSheetDialog.this.close(false);
                }
            });
        }
        this.dialog.setContentView(this.rootView);
        BottomSheetBehavior z = BottomSheetBehavior.z((View) this.rootView.getParent());
        this.mBehavior = z;
        z.d0(true);
        this.mBehavior.Y(true);
        this.dialog.findViewById(R.id.design_bottom_sheet).setBackgroundColor(this.mContext.getResources().getColor(R.color.ykfsdk_transparent));
        this.rootView.post(new Runnable() { // from class: com.m7.imkfsdk.view.NumClickBottomSheetDialog.4
            @Override // java.lang.Runnable
            public void run() {
                NumClickBottomSheetDialog numClickBottomSheetDialog = NumClickBottomSheetDialog.this;
                numClickBottomSheetDialog.mBehavior.a0(numClickBottomSheetDialog.rootView.getHeight());
            }
        });
        return this.dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mBehavior.e0(3);
    }
}
