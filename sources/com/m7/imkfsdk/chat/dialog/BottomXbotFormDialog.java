package com.m7.imkfsdk.chat.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.gson.Gson;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.adapter.XbotFormAdapter;
import com.m7.imkfsdk.chat.dialog.CustomerUploadFileDialog;
import com.m7.imkfsdk.utils.FileUtils;
import com.m7.imkfsdk.utils.PickUtils;
import com.m7.imkfsdk.utils.ToastUtils;
import com.moor.imkf.db.dao.MessageDao;
import com.moor.imkf.event.XbotFormEvent;
import com.moor.imkf.http.HttpManager;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import com.moor.imkf.lib.utils.MoorNullUtil;
import com.moor.imkf.model.entity.AddressResult;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.entity.UploadFileBean;
import com.moor.imkf.model.entity.XbotForm;
import com.moor.imkf.requesturl.RequestUrl;
import com.tencent.android.tpns.mqtt.MqttTopic;
import e.j.a.c.f.a;
import e.j.a.c.f.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import k.c.a.c;

@SuppressLint({"ValidFragment"})
/* loaded from: classes2.dex */
public class BottomXbotFormDialog extends b {
    private static final int PICK_FILE_BottomXbotFormDialog_REQUEST_CODE = 500;
    private XbotFormAdapter adapter;
    public a dialog;
    private XbotForm.FormInfoBean fileBean;
    private CustomerUploadFileDialog fileDialog;
    private boolean isDataHasFile;
    public BottomSheetBehavior mBehavior;
    public Context mContext;
    private int position;
    public View rootView;
    private String title;
    private boolean isClickClose = false;
    public CustomerUploadFileDialog.OnFileUploadCompletedListener fileUploadCompletedListener = new CustomerUploadFileDialog.OnFileUploadCompletedListener() { // from class: com.m7.imkfsdk.chat.dialog.BottomXbotFormDialog.5
        @Override // com.m7.imkfsdk.chat.dialog.CustomerUploadFileDialog.OnFileUploadCompletedListener
        public void onCompleted(UploadFileBean uploadFileBean) {
            if (BottomXbotFormDialog.this.fileDialog != null) {
                BottomXbotFormDialog.this.fileDialog.dismiss();
            }
            if (uploadFileBean == null || BottomXbotFormDialog.this.fileBean == null) {
                return;
            }
            BottomXbotFormDialog.this.fileBean.filelist.add(uploadFileBean);
            BottomXbotFormDialog.this.adapter.notifyItemChanged(BottomXbotFormDialog.this.position, BottomXbotFormDialog.this.fileBean);
        }

        @Override // com.m7.imkfsdk.chat.dialog.CustomerUploadFileDialog.OnFileUploadCompletedListener
        public void onFailed(String str) {
            if (BottomXbotFormDialog.this.fileDialog != null) {
                if ("setCancel".equals(str)) {
                    BottomXbotFormDialog.this.fileDialog.dismiss();
                    return;
                }
                BottomXbotFormDialog bottomXbotFormDialog = BottomXbotFormDialog.this;
                ToastUtils.showShort(bottomXbotFormDialog.mContext, bottomXbotFormDialog.getString(R.string.ykfsdk_ykf_upfilefail_form));
                BottomXbotFormDialog.this.fileDialog.dismiss();
            }
        }
    };
    private XbotForm xbotForm = this.xbotForm;
    private XbotForm xbotForm = this.xbotForm;
    private String _id = this._id;
    private String _id = this._id;

    public BottomXbotFormDialog() {
        this.title = "";
        this.isDataHasFile = false;
        this.title = this.title;
        for (int i2 = 0; i2 < this.xbotForm.formInfo.size(); i2++) {
            if (XbotForm.Type_DataFile.equals(this.xbotForm.formInfo.get(i2).type) && this.xbotForm.formInfo.get(i2).filelist.size() > 0) {
                this.isDataHasFile = true;
            }
        }
    }

    public static BottomXbotFormDialog init(String str, XbotForm xbotForm, String str2) {
        BottomXbotFormDialog bottomXbotFormDialog = new BottomXbotFormDialog();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putSerializable(FromToMessage.MSG_TYPE_XBOT_FORM_DATA, xbotForm);
        bundle.putString("_id", str2);
        bottomXbotFormDialog.setArguments(bundle);
        return bottomXbotFormDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFile() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        startActivityForResult(intent, 500);
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

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 500 && i3 == -1) {
            String path = PickUtils.getPath(this.mContext, intent.getData());
            if (!MoorNullUtil.checkNULL(path)) {
                Toast.makeText(this.mContext, getString(R.string.ykfsdk_ykf_not_support_file), 0).show();
                return;
            }
            File file = new File(path);
            if (file.exists()) {
                long length = file.length();
                if ((length / 1024) / 1024 > 20.0d) {
                    Context context = this.mContext;
                    Toast.makeText(context, getString(R.string.ykfsdk_sendfiletoobig) + "20MB", 0).show();
                    return;
                }
                String formatFileLength = FileUtils.formatFileLength(length);
                String substring = path.substring(path.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1);
                this.fileDialog = new CustomerUploadFileDialog();
                Bundle bundle = new Bundle();
                bundle.putString("fileSize", formatFileLength);
                bundle.putString("filePath", path);
                bundle.putString("fileName", substring);
                this.fileDialog.setArguments(bundle);
                this.fileDialog.setOnFileUploadCompletedListener(this.fileUploadCompletedListener);
                this.fileDialog.show(getFragmentManager(), "");
            }
        }
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
        AddressResult addressResult = (AddressResult) new Gson().n(FileUtils.getOriginalFundData(getContext()), AddressResult.class);
        if (this.rootView == null) {
            View inflate = View.inflate(this.mContext, R.layout.ykfsdk_layout_xbot_formfragment, null);
            this.rootView = inflate;
            ((TextView) inflate.findViewById(R.id.id_dialog_question_title)).setText(this.title);
            ((RelativeLayout) this.rootView.findViewById(R.id.iv_bottom_close)).setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.dialog.BottomXbotFormDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    BottomXbotFormDialog.this.isClickClose = true;
                    BottomXbotFormDialog.this.dialog.dismiss();
                }
            });
            RecyclerView recyclerView = (RecyclerView) this.rootView.findViewById(R.id.rv_xbotform);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mContext));
            if (!TextUtils.isEmpty(this.xbotForm.formNotes)) {
                XbotForm.FormInfoBean formInfoBean = new XbotForm.FormInfoBean();
                formInfoBean.type = XbotForm.Type_HeadNote;
                XbotForm xbotForm = this.xbotForm;
                formInfoBean.name = xbotForm.formNotes;
                xbotForm.formInfo.add(0, formInfoBean);
            }
            XbotFormAdapter xbotFormAdapter = new XbotFormAdapter(getContext(), this.xbotForm.formInfo, addressResult, this.isDataHasFile);
            this.adapter = xbotFormAdapter;
            recyclerView.setAdapter(xbotFormAdapter);
            this.adapter.setSubmitClickListener(new XbotFormAdapter.onSubmitClickListener() { // from class: com.m7.imkfsdk.chat.dialog.BottomXbotFormDialog.2
                @Override // com.m7.imkfsdk.chat.adapter.XbotFormAdapter.onSubmitClickListener
                public void OnAddFileClick(int i2, XbotForm.FormInfoBean formInfoBean2) {
                    BottomXbotFormDialog.this.position = i2;
                    BottomXbotFormDialog.this.fileBean = formInfoBean2;
                    BottomXbotFormDialog.this.openFile();
                }

                @Override // com.m7.imkfsdk.chat.adapter.XbotFormAdapter.onSubmitClickListener
                public void OnSubmitClick(List<XbotForm.FormInfoBean> list) {
                    BottomXbotFormDialog.this.isClickClose = false;
                    if (BottomXbotFormDialog.this.xbotForm.formInfo.get(0).type.equals(XbotForm.Type_HeadNote)) {
                        BottomXbotFormDialog.this.xbotForm.formInfo.remove(0);
                    }
                    String z = new Gson().z(BottomXbotFormDialog.this.xbotForm);
                    XbotFormEvent xbotFormEvent = new XbotFormEvent();
                    xbotFormEvent.xbotForm = z;
                    c.f().q(xbotFormEvent);
                    MessageDao.getInstance().updateXbotForm(BottomXbotFormDialog.this._id);
                    BottomXbotFormDialog.this.dismiss();
                }
            });
        }
        this.dialog.setContentView(this.rootView);
        BottomSheetBehavior z = BottomSheetBehavior.z((View) this.rootView.getParent());
        this.mBehavior = z;
        z.d0(true);
        this.mBehavior.Y(true);
        setCancelable(false);
        View findViewById = this.dialog.findViewById(R.id.design_bottom_sheet);
        findViewById.setBackgroundColor(this.mContext.getResources().getColor(R.color.ykfsdk_transparent));
        if (this.dialog != null) {
            findViewById.getLayoutParams().height = (MoorDensityUtil.getScreenHeight(getContext()) * 4) / 5;
        }
        this.rootView.post(new Runnable() { // from class: com.m7.imkfsdk.chat.dialog.BottomXbotFormDialog.3
            @Override // java.lang.Runnable
            public void run() {
                BottomXbotFormDialog bottomXbotFormDialog = BottomXbotFormDialog.this;
                bottomXbotFormDialog.mBehavior.a0(bottomXbotFormDialog.rootView.getHeight());
            }
        });
        this.mBehavior.S(new BottomSheetBehavior.g() { // from class: com.m7.imkfsdk.chat.dialog.BottomXbotFormDialog.4
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
            public void onSlide(@NonNull View view, float f2) {
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
            public void onStateChanged(@NonNull View view, int i2) {
                if (i2 == 1) {
                    BottomXbotFormDialog.this.mBehavior.e0(3);
                }
            }
        });
        return this.dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((ViewGroup) this.rootView.getParent()).removeView(this.rootView);
        if (!this.isClickClose || this.isDataHasFile || this.xbotForm.formInfo == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.xbotForm.formInfo.size(); i2++) {
            if (XbotForm.Type_DataFile.equals(this.xbotForm.formInfo.get(i2).type)) {
                ArrayList<UploadFileBean> arrayList2 = this.xbotForm.formInfo.get(i2).filelist;
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    arrayList.add(arrayList2.get(i3).getUrl().replace(RequestUrl.QINIU_HTTP, ""));
                }
            }
        }
        if (arrayList.size() != 0) {
            HttpManager.delXbotFormFile(arrayList, null);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mBehavior.e0(3);
    }
}
