package com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ImageVideoScanActivity extends Activity {
    private static final String TAG = ImageVideoScanActivity.class.getSimpleName();
    private ImageVideoScanAdapter mAdapter;
    private ImageView mDownloadView;
    private ImageVideoScanPresenter mImageVideoScanPresenter;
    private ViewPagerLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private TUIMessageBean mCurrentMessageBean = null;
    private List<TUIMessageBean> mForwardDataSource = new ArrayList();
    private boolean mIsForwardMode = false;

    /* loaded from: classes3.dex */
    public interface OnItemClickListener {
        void onClickItem();
    }

    private void initView() {
        this.mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        ImageView imageView = (ImageView) findViewById(R.id.download_button);
        this.mDownloadView = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TUIChatLog.d(ImageVideoScanActivity.TAG, "onClick");
                PermissionHelper.requestPermission(3, new PermissionHelper.PermissionCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity.1.1
                    @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                    public void onDenied() {
                        ToastUtil.toastShortMessage("图片保存失败，请检查权限设置");
                    }

                    @Override // com.tencent.qcloud.tuikit.tuichat.util.PermissionHelper.PermissionCallback
                    public void onGranted() {
                        ImageVideoScanActivity.this.mImageVideoScanPresenter.saveLocal(ImageVideoScanActivity.this);
                    }
                });
            }
        });
        this.mLayoutManager = new ViewPagerLayoutManager(this, 0);
        this.mAdapter = new ImageVideoScanAdapter();
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
        ImageVideoScanPresenter imageVideoScanPresenter = new ImageVideoScanPresenter();
        this.mImageVideoScanPresenter = imageVideoScanPresenter;
        imageVideoScanPresenter.setAdapter(this.mAdapter);
        this.mImageVideoScanPresenter.setRecyclerView(this.mRecyclerView);
        this.mImageVideoScanPresenter.setViewPagerLayoutManager(this.mLayoutManager);
        this.mAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity.2
            @Override // com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity.OnItemClickListener
            public void onClickItem() {
                ImageVideoScanActivity.this.finish();
            }
        });
    }

    public void initData() {
        if (getIntent() == null) {
            return;
        }
        boolean booleanExtra = getIntent().getBooleanExtra(TUIChatConstants.FORWARD_MODE, false);
        this.mIsForwardMode = booleanExtra;
        if (booleanExtra) {
            List<TUIMessageBean> list = (List) getIntent().getSerializableExtra(TUIChatConstants.OPEN_MESSAGES_SCAN_FORWARD);
            this.mForwardDataSource = list;
            if (list == null || list.isEmpty()) {
                TUIChatLog.e(TAG, "mForwardDataSource is null");
                return;
            }
        }
        TUIMessageBean tUIMessageBean = (TUIMessageBean) getIntent().getSerializableExtra(TUIChatConstants.OPEN_MESSAGE_SCAN);
        this.mCurrentMessageBean = tUIMessageBean;
        if (tUIMessageBean == null) {
            TUIChatLog.e(TAG, "mCurrentMessageBean is null");
        } else {
            this.mImageVideoScanPresenter.init(tUIMessageBean, this.mForwardDataSource, this.mIsForwardMode);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        setContentView(R.layout.image_video_scan_layout);
        initView();
        initData();
    }

    @Override // android.app.Activity
    public void onPause() {
        TUIChatLog.i(TAG, "onPause");
        super.onPause();
        ImageVideoScanPresenter imageVideoScanPresenter = this.mImageVideoScanPresenter;
        if (imageVideoScanPresenter != null) {
            imageVideoScanPresenter.releaseUI();
        }
    }
}
