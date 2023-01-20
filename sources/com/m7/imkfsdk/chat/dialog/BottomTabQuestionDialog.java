package com.m7.imkfsdk.chat.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.adapter.ChatTagQuestionMoreAdapter;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import e.j.a.c.f.a;
import e.j.a.c.f.b;
import java.util.ArrayList;

@SuppressLint({"ValidFragment"})
/* loaded from: classes2.dex */
public class BottomTabQuestionDialog extends b {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public a dialog;
    private ArrayList<String> list;
    public BottomSheetBehavior mBehavior;
    public Context mContext;
    private onQuestionClickListener mListener;
    public View rootView;
    private String title = "";

    /* loaded from: classes2.dex */
    public interface onQuestionClickListener {
        void OnItemClick(String str);
    }

    public static BottomTabQuestionDialog init(String str, ArrayList<String> arrayList) {
        BottomTabQuestionDialog bottomTabQuestionDialog = new BottomTabQuestionDialog();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("list", arrayList);
        bundle.putString("title", str);
        bottomTabQuestionDialog.setArguments(bundle);
        return bottomTabQuestionDialog;
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
        this.list = arguments.getStringArrayList("list");
        this.title = arguments.getString("title");
        if (this.rootView == null) {
            View inflate = View.inflate(this.mContext, R.layout.ykfsdk_layout_bottomtabquestion, null);
            this.rootView = inflate;
            ((TextView) inflate.findViewById(R.id.id_dialog_question_title)).setText(this.title);
            ((ImageView) this.rootView.findViewById(R.id.iv_bottom_close)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.dialog.BottomTabQuestionDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BottomTabQuestionDialog.this.dialog.dismiss();
                }
            });
            RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.rv_switch);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
            ChatTagQuestionMoreAdapter chatTagQuestionMoreAdapter = new ChatTagQuestionMoreAdapter(this.list);
            recyclerView.setAdapter(chatTagQuestionMoreAdapter);
            chatTagQuestionMoreAdapter.setOnItemClickListener(new ChatTagQuestionMoreAdapter.onItemClickListener() { // from class: com.m7.imkfsdk.chat.dialog.BottomTabQuestionDialog.2
                @Override // com.m7.imkfsdk.chat.adapter.ChatTagQuestionMoreAdapter.onItemClickListener
                public void OnItemClick(String str) {
                    BottomTabQuestionDialog.this.mListener.OnItemClick(str);
                }
            });
        }
        this.dialog.setContentView(this.rootView);
        BottomSheetBehavior z = BottomSheetBehavior.z((View) this.rootView.getParent());
        this.mBehavior = z;
        z.d0(true);
        this.mBehavior.Y(true);
        View findViewById = this.dialog.findViewById(R.id.design_bottom_sheet);
        findViewById.setBackgroundColor(this.mContext.getResources().getColor(R.color.ykfsdk_transparent));
        if (this.dialog != null) {
            findViewById.getLayoutParams().height = (MoorDensityUtil.getScreenHeight(getContext()) * 3) / 5;
        }
        this.rootView.post(new Runnable() { // from class: com.m7.imkfsdk.chat.dialog.BottomTabQuestionDialog.3
            @Override // java.lang.Runnable
            public void run() {
                BottomTabQuestionDialog bottomTabQuestionDialog = BottomTabQuestionDialog.this;
                bottomTabQuestionDialog.mBehavior.a0(bottomTabQuestionDialog.rootView.getHeight());
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

    public void setonQuestionClickListener(onQuestionClickListener onquestionclicklistener) {
        this.mListener = onquestionclicklistener;
    }
}
