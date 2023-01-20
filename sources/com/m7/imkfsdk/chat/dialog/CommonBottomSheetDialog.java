package com.m7.imkfsdk.chat.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.m7.imkfsdk.R;
import e.j.a.c.f.a;
import e.j.a.c.f.b;

/* loaded from: classes2.dex */
public class CommonBottomSheetDialog extends b {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public a dialog;
    private OnClickListener listener;
    public BottomSheetBehavior mBehavior;
    public Context mContext;
    public View rootView;

    /* loaded from: classes2.dex */
    public interface OnClickListener {
        void onClickNegative();

        void onClickPositive();
    }

    public static CommonBottomSheetDialog instance(String str, String str2, String str3) {
        CommonBottomSheetDialog commonBottomSheetDialog = new CommonBottomSheetDialog();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("positive", str2);
        bundle.putString("negative", str3);
        commonBottomSheetDialog.setArguments(bundle);
        return commonBottomSheetDialog;
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
        Bundle arguments = getArguments();
        String string = arguments.getString("title");
        String string2 = arguments.getString("positive");
        String string3 = arguments.getString("negative");
        if (this.rootView == null) {
            View inflate = View.inflate(this.mContext, R.layout.ykfsdk_layout_common_bottomsheet, null);
            this.rootView = inflate;
            ((ImageView) inflate.findViewById(R.id.iv_bottom_close)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.dialog.CommonBottomSheetDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CommonBottomSheetDialog.this.close(false);
                }
            });
            TextView textView = (TextView) this.rootView.findViewById(R.id.tv_common_title);
            TextView textView2 = (TextView) this.rootView.findViewById(R.id.tv_common_left);
            TextView textView3 = (TextView) this.rootView.findViewById(R.id.tv_common_right);
            if (TextUtils.isEmpty(string2)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
            }
            if (TextUtils.isEmpty(string3)) {
                textView3.setVisibility(8);
            } else {
                textView3.setVisibility(0);
            }
            textView.setText(string);
            textView2.setText(string2);
            textView3.setText(string3);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.dialog.CommonBottomSheetDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CommonBottomSheetDialog.this.listener != null) {
                        CommonBottomSheetDialog.this.listener.onClickPositive();
                    }
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.dialog.CommonBottomSheetDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (CommonBottomSheetDialog.this.listener != null) {
                        CommonBottomSheetDialog.this.listener.onClickNegative();
                    }
                }
            });
        }
        this.dialog.setContentView(this.rootView);
        BottomSheetBehavior z = BottomSheetBehavior.z((View) this.rootView.getParent());
        this.mBehavior = z;
        z.d0(true);
        this.mBehavior.Y(true);
        this.dialog.findViewById(R.id.design_bottom_sheet).setBackgroundColor(this.mContext.getResources().getColor(R.color.ykfsdk_transparent));
        this.rootView.post(new Runnable() { // from class: com.m7.imkfsdk.chat.dialog.CommonBottomSheetDialog.4
            @Override // java.lang.Runnable
            public void run() {
                CommonBottomSheetDialog commonBottomSheetDialog = CommonBottomSheetDialog.this;
                commonBottomSheetDialog.mBehavior.a0(commonBottomSheetDialog.rootView.getHeight());
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

    public void setListener(OnClickListener onClickListener) {
        this.listener = onClickListener;
    }
}
