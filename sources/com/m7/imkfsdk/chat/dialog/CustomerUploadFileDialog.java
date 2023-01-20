package com.m7.imkfsdk.chat.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;
import com.m7.imkfsdk.R;
import com.moor.imkf.IMChat;
import com.moor.imkf.model.entity.UploadFileBean;

/* loaded from: classes2.dex */
public class CustomerUploadFileDialog extends AppCompatDialogFragment {
    private String fileName;
    private String filePath;
    private String fileSizeStr;
    private ImageView iv_kf_closeup;
    public OnFileUploadCompletedListener listener;
    private ProgressBar progressBar;
    private TextView tv_fileName;
    private TextView tv_fileSize;
    private TextView tv_precent;

    /* loaded from: classes2.dex */
    public interface OnFileUploadCompletedListener {
        void onCompleted(UploadFileBean uploadFileBean);

        void onFailed(String str);
    }

    private void sendFile(final String str, final String str2) {
        IMChat.getInstance().upLoadXbotFromFile(str, this.fileSizeStr, new IMChat.onXbotFormUpFileListener() { // from class: com.m7.imkfsdk.chat.dialog.CustomerUploadFileDialog.3
            @Override // com.moor.imkf.IMChat.onXbotFormUpFileListener
            public void onFailed(String str3) {
                OnFileUploadCompletedListener onFileUploadCompletedListener = CustomerUploadFileDialog.this.listener;
                if (onFileUploadCompletedListener != null) {
                    onFileUploadCompletedListener.onFailed(str3);
                }
            }

            @Override // com.moor.imkf.IMChat.onXbotFormUpFileListener
            public void onUpLoading(int i2) {
                CustomerUploadFileDialog.this.progressBar.setProgress(i2);
                TextView textView = CustomerUploadFileDialog.this.tv_precent;
                textView.setText(i2 + "%");
            }

            @Override // com.moor.imkf.IMChat.onXbotFormUpFileListener
            public void onisOK(String str3) {
                if (CustomerUploadFileDialog.this.listener != null) {
                    UploadFileBean uploadFileBean = new UploadFileBean();
                    uploadFileBean.setName(str2);
                    uploadFileBean.setUrl(str3);
                    uploadFileBean.setLocalUrl(str);
                    CustomerUploadFileDialog.this.listener.onCompleted(uploadFileBean);
                }
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.ykfsdk_kf_field_file_uploading, (ViewGroup) null);
        this.tv_fileName = (TextView) inflate.findViewById(R.id.erp_field_file_upload_tv_filename);
        this.tv_fileSize = (TextView) inflate.findViewById(R.id.erp_field_file_upload_tv_filesize);
        this.tv_precent = (TextView) inflate.findViewById(R.id.erp_field_file_upload_tv_precent);
        this.progressBar = (ProgressBar) inflate.findViewById(R.id.erp_field_file_upload_pb);
        this.iv_kf_closeup = (ImageView) inflate.findViewById(R.id.iv_kf_closeup);
        Bundle arguments = getArguments();
        this.fileName = arguments.getString("fileName");
        this.fileSizeStr = arguments.getString("fileSize");
        this.filePath = arguments.getString("filePath");
        this.tv_fileName.setText(this.fileName);
        this.tv_fileSize.setText(this.fileSizeStr);
        Dialog dialog = new Dialog(getActivity(), R.style.ykfsdk_dialog);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        sendFile(this.filePath, this.fileName);
        this.iv_kf_closeup.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.dialog.CustomerUploadFileDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IMChat.getInstance().setCancel(true);
                OnFileUploadCompletedListener onFileUploadCompletedListener = CustomerUploadFileDialog.this.listener;
                if (onFileUploadCompletedListener != null) {
                    onFileUploadCompletedListener.onFailed("setCancel");
                }
            }
        });
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.m7.imkfsdk.chat.dialog.CustomerUploadFileDialog.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return i2 == 4;
            }
        });
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void setOnFileUploadCompletedListener(OnFileUploadCompletedListener onFileUploadCompletedListener) {
        this.listener = onFileUploadCompletedListener;
    }

    @Override // androidx.fragment.app.DialogFragment
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
