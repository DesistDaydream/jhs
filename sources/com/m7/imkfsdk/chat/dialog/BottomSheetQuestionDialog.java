package com.m7.imkfsdk.chat.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.adapter.QuetionParentAdapter;
import com.m7.imkfsdk.chat.model.CommonQuestionBean;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import e.j.a.c.f.a;
import e.j.a.c.f.b;
import java.util.List;

@SuppressLint({"ValidFragment"})
/* loaded from: classes2.dex */
public class BottomSheetQuestionDialog extends b {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public a dialog;
    private OnClickListener listener;
    public BottomSheetBehavior mBehavior;
    public Context mContext;
    private List<CommonQuestionBean> mList;
    public View rootView;

    /* loaded from: classes2.dex */
    public interface OnClickListener {
        void onClickNegative();

        void onClickPositive();
    }

    public BottomSheetQuestionDialog(List<CommonQuestionBean> list) {
        this.mList = list;
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
        getArguments();
        if (this.rootView == null) {
            View inflate = View.inflate(this.mContext, R.layout.ykfsdk_layout_question_bottomsheet, null);
            this.rootView = inflate;
            ((ImageView) inflate.findViewById(R.id.iv_bottom_close)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.dialog.BottomSheetQuestionDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BottomSheetQuestionDialog.this.close(false);
                }
            });
            ((RecyclerView) this.rootView.findViewById(R.id.rv_question)).setAdapter(new QuetionParentAdapter(this.mContext, this.mList));
        }
        this.dialog.setContentView(this.rootView);
        BottomSheetBehavior z = BottomSheetBehavior.z((View) this.rootView.getParent());
        this.mBehavior = z;
        z.d0(true);
        this.mBehavior.Y(true);
        View findViewById = this.dialog.findViewById(R.id.design_bottom_sheet);
        findViewById.setBackgroundColor(this.mContext.getResources().getColor(R.color.ykfsdk_transparent));
        if (this.dialog != null) {
            findViewById.getLayoutParams().height = (MoorDensityUtil.getScreenHeight(getContext()) * 4) / 5;
        }
        this.rootView.post(new Runnable() { // from class: com.m7.imkfsdk.chat.dialog.BottomSheetQuestionDialog.2
            @Override // java.lang.Runnable
            public void run() {
                BottomSheetQuestionDialog bottomSheetQuestionDialog = BottomSheetQuestionDialog.this;
                bottomSheetQuestionDialog.mBehavior.a0(bottomSheetQuestionDialog.rootView.getHeight());
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
