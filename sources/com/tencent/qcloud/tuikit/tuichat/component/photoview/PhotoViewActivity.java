package com.tencent.qcloud.tuikit.tuichat.component.photoview;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMImageElem;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.FileUtil;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.component.photoview.listener.OnMatrixChangedListener;
import com.tencent.qcloud.tuikit.tuichat.component.photoview.listener.OnPhotoTapListener;
import com.tencent.qcloud.tuikit.tuichat.component.photoview.listener.OnSingleFlingListener;
import com.tencent.qcloud.tuikit.tuichat.component.photoview.view.PhotoView;

/* loaded from: classes3.dex */
public class PhotoViewActivity extends Activity {
    private static final String BROADCAST_DOWNLOAD_COMPLETED_ACTION = "PhotoViewActivityDownloadOriginImageCompleted";
    private static final String DOWNLOAD_ORIGIN_IMAGE_PATH = "downloadOriginImagePath";
    public static V2TIMImageElem.V2TIMImage mCurrentOriginalImage;
    private BroadcastReceiver downloadReceiver;
    private Matrix mCurrentDisplayMatrix = null;
    private PhotoView mPhotoView;
    private TextView mViewOriginalBtn;

    /* renamed from: com.tencent.qcloud.tuikit.tuichat.component.photoview.PhotoViewActivity$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final String generateImagePath = ImageUtil.generateImagePath(PhotoViewActivity.mCurrentOriginalImage.getUUID(), PhotoViewActivity.mCurrentOriginalImage.getType());
            PhotoViewActivity.mCurrentOriginalImage.downloadImage(generateImagePath, new V2TIMDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.photoview.PhotoViewActivity.1.1
                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i2, String str) {
                    ToastUtil.toastLongMessage("Download origin image failed , errCode = " + i2 + ", " + str);
                }

                @Override // com.tencent.imsdk.v2.V2TIMDownloadCallback
                public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                    long round = Math.round(((v2ProgressInfo.getCurrentSize() * 1.0d) * 100.0d) / v2ProgressInfo.getTotalSize());
                    if (PhotoViewActivity.this.mViewOriginalBtn.getVisibility() == 4 || PhotoViewActivity.this.mViewOriginalBtn.getVisibility() == 8) {
                        return;
                    }
                    TextView textView = PhotoViewActivity.this.mViewOriginalBtn;
                    textView.setText(round + "%");
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.photoview.PhotoViewActivity.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PhotoViewActivity.this.mPhotoView.setImageURI(FileUtil.getUriFromPath(generateImagePath));
                            PhotoViewActivity.this.mViewOriginalBtn.setText(PhotoViewActivity.this.getString(R.string.completed));
                            PhotoViewActivity.this.mViewOriginalBtn.setOnClickListener(null);
                            PhotoViewActivity.this.mViewOriginalBtn.setVisibility(4);
                            Intent intent = new Intent();
                            intent.setAction(PhotoViewActivity.BROADCAST_DOWNLOAD_COMPLETED_ACTION);
                            intent.putExtra(PhotoViewActivity.DOWNLOAD_ORIGIN_IMAGE_PATH, generateImagePath);
                            LocalBroadcastManager.getInstance(PhotoViewActivity.this).sendBroadcast(intent);
                        }
                    });
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public class MatrixChangeListener implements OnMatrixChangedListener {
        private MatrixChangeListener() {
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.component.photoview.listener.OnMatrixChangedListener
        public void onMatrixChanged(RectF rectF) {
        }

        public /* synthetic */ MatrixChangeListener(PhotoViewActivity photoViewActivity, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class PhotoTapListener implements OnPhotoTapListener {
        private PhotoTapListener() {
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.component.photoview.listener.OnPhotoTapListener
        public void onPhotoTap(ImageView imageView, float f2, float f3) {
        }

        public /* synthetic */ PhotoTapListener(PhotoViewActivity photoViewActivity, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class SingleFlingListener implements OnSingleFlingListener {
        private SingleFlingListener() {
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.component.photoview.listener.OnSingleFlingListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return true;
        }

        public /* synthetic */ SingleFlingListener(PhotoViewActivity photoViewActivity, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_photo_view);
        Uri uriFromPath = FileUtil.getUriFromPath(getIntent().getStringExtra(TUIChatConstants.IMAGE_PREVIEW_PATH));
        boolean booleanExtra = getIntent().getBooleanExtra(TUIChatConstants.IS_ORIGIN_IMAGE, false);
        this.mCurrentDisplayMatrix = new Matrix();
        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        this.mPhotoView = photoView;
        photoView.setDisplayMatrix(this.mCurrentDisplayMatrix);
        this.mPhotoView.setOnMatrixChangeListener(new MatrixChangeListener(this, null));
        this.mPhotoView.setOnPhotoTapListener(new PhotoTapListener(this, null));
        this.mPhotoView.setOnSingleFlingListener(new SingleFlingListener(this, null));
        this.mViewOriginalBtn = (TextView) findViewById(R.id.view_original_btn);
        this.mPhotoView.setImageURI(uriFromPath);
        if (!booleanExtra) {
            this.mViewOriginalBtn.setVisibility(0);
            this.mViewOriginalBtn.setOnClickListener(new AnonymousClass1());
        } else if (this.mPhotoView.getDrawable() == null) {
            ToastUtil.toastShortMessage("Downloading , please wait.");
            this.downloadReceiver = new BroadcastReceiver() { // from class: com.tencent.qcloud.tuikit.tuichat.component.photoview.PhotoViewActivity.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    String stringExtra;
                    if (!PhotoViewActivity.BROADCAST_DOWNLOAD_COMPLETED_ACTION.equals(intent.getAction()) || (stringExtra = intent.getStringExtra(PhotoViewActivity.DOWNLOAD_ORIGIN_IMAGE_PATH)) == null) {
                        return;
                    }
                    PhotoViewActivity.this.mPhotoView.setImageURI(FileUtil.getUriFromPath(stringExtra));
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BROADCAST_DOWNLOAD_COMPLETED_ACTION);
            LocalBroadcastManager.getInstance(this).registerReceiver(this.downloadReceiver, intentFilter);
        }
        findViewById(R.id.photo_view_back).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.photoview.PhotoViewActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PhotoViewActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.downloadReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.downloadReceiver);
            this.downloadReceiver = null;
        }
    }
}
