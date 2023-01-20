package com.m7.imkfsdk.chat.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.adapter.LogisticsProgressListAdapter;
import com.m7.imkfsdk.chat.model.OrderInfoBean;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import e.j.a.c.f.a;
import e.j.a.c.f.b;
import java.util.ArrayList;

@SuppressLint({"ValidFragment"})
/* loaded from: classes2.dex */
public class BottomSheetLogisticsProgressDialog extends b {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public a dialog;
    private ArrayList<OrderInfoBean> list;
    public BottomSheetBehavior mBehavior;
    public Context mContext;
    private String num;
    private String progress_title;
    public View rootView;
    private String title;

    public static BottomSheetLogisticsProgressDialog init(String str, String str2, String str3, ArrayList<OrderInfoBean> arrayList) {
        BottomSheetLogisticsProgressDialog bottomSheetLogisticsProgressDialog = new BottomSheetLogisticsProgressDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", arrayList);
        bundle.putString("num", str2);
        bundle.putString("title", str);
        bundle.putString("progress_title", str3);
        bottomSheetLogisticsProgressDialog.setArguments(bundle);
        return bottomSheetLogisticsProgressDialog;
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
        this.num = arguments.getString("num");
        this.title = arguments.getString("title");
        this.progress_title = arguments.getString("progress_title");
        if (this.rootView == null) {
            View inflate = View.inflate(this.mContext, R.layout.ykfsdk_layout_bottomsheet_progress, null);
            this.rootView = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.tv_no_data);
            TextView textView2 = (TextView) this.rootView.findViewById(R.id.tv_express_name);
            TextView textView3 = (TextView) this.rootView.findViewById(R.id.tv_express_num);
            TextView textView4 = (TextView) this.rootView.findViewById(R.id.tv_logistics_progress_title);
            ((ImageView) this.rootView.findViewById(R.id.iv_bottom_close)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.dialog.BottomSheetLogisticsProgressDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BottomSheetLogisticsProgressDialog.this.dialog.dismiss();
                }
            });
            RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.rv_switch);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
            recyclerView.setAdapter(new LogisticsProgressListAdapter(this.list, true));
            ArrayList<OrderInfoBean> arrayList = this.list;
            if (arrayList != null && arrayList.size() == 0) {
                textView.setVisibility(0);
                recyclerView.setVisibility(8);
            } else {
                textView.setVisibility(8);
                recyclerView.setVisibility(0);
            }
            textView2.setMaxWidth((MoorDensityUtil.getScreenWidth(this.mContext) / 5) * 2);
            textView3.setMaxWidth((MoorDensityUtil.getScreenWidth(this.mContext) / 5) * 3);
            if (!TextUtils.isEmpty(this.title)) {
                textView2.setVisibility(0);
                textView2.setText(this.title);
            } else {
                textView2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.num)) {
                textView3.setVisibility(0);
                textView3.setText(this.num);
            } else {
                textView3.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.progress_title)) {
                textView4.setText(this.progress_title);
            } else {
                textView4.setText(getString(R.string.ykfsdk_ykf_logistics_information));
            }
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
        this.rootView.post(new Runnable() { // from class: com.m7.imkfsdk.chat.dialog.BottomSheetLogisticsProgressDialog.2
            @Override // java.lang.Runnable
            public void run() {
                BottomSheetLogisticsProgressDialog bottomSheetLogisticsProgressDialog = BottomSheetLogisticsProgressDialog.this;
                bottomSheetLogisticsProgressDialog.mBehavior.a0(bottomSheetLogisticsProgressDialog.rootView.getHeight());
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
