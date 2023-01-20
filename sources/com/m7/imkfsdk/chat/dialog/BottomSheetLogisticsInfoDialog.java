package com.m7.imkfsdk.chat.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.adapter.LogisticsInfoRxListAdapter;
import com.m7.imkfsdk.chat.model.OrderInfoBean;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import e.j.a.c.f.a;
import e.j.a.c.f.b;
import java.util.ArrayList;

@SuppressLint({"ValidFragment"})
/* loaded from: classes2.dex */
public class BottomSheetLogisticsInfoDialog extends b {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private String _id;
    private String current;
    public a dialog;
    private ArrayList<OrderInfoBean> list;
    public BottomSheetBehavior mBehavior;
    public Context mContext;
    public View rootView;

    public static BottomSheetLogisticsInfoDialog init(ArrayList<OrderInfoBean> arrayList, String str, String str2) {
        BottomSheetLogisticsInfoDialog bottomSheetLogisticsInfoDialog = new BottomSheetLogisticsInfoDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", arrayList);
        bundle.putString("current", str);
        bundle.putString("_id", str2);
        bottomSheetLogisticsInfoDialog.setArguments(bundle);
        return bottomSheetLogisticsInfoDialog;
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
        this.list = (ArrayList) arguments.getSerializable("list");
        this.current = arguments.getString("current");
        this._id = arguments.getString("_id");
        if (this.rootView == null) {
            View inflate = View.inflate(this.mContext, R.layout.ykfsdk_layout_bottomsheet, null);
            this.rootView = inflate;
            ((ImageView) inflate.findViewById(R.id.iv_bottom_close)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.dialog.BottomSheetLogisticsInfoDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BottomSheetLogisticsInfoDialog.this.dialog.dismiss();
                }
            });
            RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.rv_switch);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
            recyclerView.setAdapter(new LogisticsInfoRxListAdapter(this.list, this.current, true, this._id, 5));
        }
        this.dialog.setContentView(this.rootView);
        BottomSheetBehavior z = BottomSheetBehavior.z((View) this.rootView.getParent());
        this.mBehavior = z;
        z.d0(true);
        this.mBehavior.Y(true);
        a aVar = this.dialog;
        if (aVar != null) {
            aVar.findViewById(R.id.design_bottom_sheet).getLayoutParams().height = (MoorDensityUtil.getScreenHeight(getContext()) * 4) / 5;
        }
        this.rootView.post(new Runnable() { // from class: com.m7.imkfsdk.chat.dialog.BottomSheetLogisticsInfoDialog.2
            @Override // java.lang.Runnable
            public void run() {
                BottomSheetLogisticsInfoDialog bottomSheetLogisticsInfoDialog = BottomSheetLogisticsInfoDialog.this;
                bottomSheetLogisticsInfoDialog.mBehavior.a0(bottomSheetLogisticsInfoDialog.rootView.getHeight());
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
