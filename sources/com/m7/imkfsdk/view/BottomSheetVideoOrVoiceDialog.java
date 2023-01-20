package com.m7.imkfsdk.view;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.m7.imkfsdk.R;
import e.j.a.c.f.a;
import e.j.a.c.f.b;

@SuppressLint({"ValidFragment"})
/* loaded from: classes2.dex */
public class BottomSheetVideoOrVoiceDialog extends b {
    public a dialog;
    public BottomSheetBehavior mBehavior;
    public Context mContext;
    private onClickListener mListener;
    public View rootView;

    /* loaded from: classes2.dex */
    public interface onClickListener {
        void onClick(int i2);
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
        if (this.rootView == null) {
            this.rootView = View.inflate(this.mContext, R.layout.ykfsdk_layout_bottomsheet_video_voice, null);
        }
        ((TextView) this.rootView.findViewById(R.id.tv_video_call)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.BottomSheetVideoOrVoiceDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BottomSheetVideoOrVoiceDialog.this.mListener != null) {
                    BottomSheetVideoOrVoiceDialog.this.mListener.onClick(0);
                }
            }
        });
        ((TextView) this.rootView.findViewById(R.id.tv_voice_call)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.BottomSheetVideoOrVoiceDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BottomSheetVideoOrVoiceDialog.this.mListener != null) {
                    BottomSheetVideoOrVoiceDialog.this.mListener.onClick(1);
                }
            }
        });
        ((TextView) this.rootView.findViewById(R.id.tv_call_cancle)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.BottomSheetVideoOrVoiceDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BottomSheetVideoOrVoiceDialog.this.mListener != null) {
                    BottomSheetVideoOrVoiceDialog.this.mListener.onClick(2);
                }
            }
        });
        this.dialog.setContentView(this.rootView);
        ((View) this.rootView.getParent()).setBackgroundColor(getResources().getColor(17170445));
        BottomSheetBehavior z = BottomSheetBehavior.z((View) this.rootView.getParent());
        this.mBehavior = z;
        z.d0(true);
        this.mBehavior.Y(true);
        this.rootView.post(new Runnable() { // from class: com.m7.imkfsdk.view.BottomSheetVideoOrVoiceDialog.4
            @Override // java.lang.Runnable
            public void run() {
                BottomSheetVideoOrVoiceDialog bottomSheetVideoOrVoiceDialog = BottomSheetVideoOrVoiceDialog.this;
                bottomSheetVideoOrVoiceDialog.mBehavior.a0(bottomSheetVideoOrVoiceDialog.rootView.getHeight());
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

    public void setOnClickListener(onClickListener onclicklistener) {
        this.mListener = onclicklistener;
    }
}
