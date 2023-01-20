package com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMImageElem;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMVideoElem;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuicore.util.FileUtil;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanActivity;
import com.tencent.qcloud.tuikit.tuichat.component.photoview.listener.OnMatrixChangedListener;
import com.tencent.qcloud.tuikit.tuichat.component.photoview.listener.OnPhotoTapListener;
import com.tencent.qcloud.tuikit.tuichat.component.photoview.listener.OnSingleFlingListener;
import com.tencent.qcloud.tuikit.tuichat.component.photoview.view.PhotoView;
import com.tencent.qcloud.tuikit.tuichat.component.video.UIKitVideoView;
import com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer;
import com.tencent.qcloud.tuikit.tuichat.util.DeviceUtil;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ImageVideoScanAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final String BROADCAST_DOWNLOAD_COMPLETED_ACTION = "PhotoViewActivityDownloadOriginImageCompleted";
    private static final String DOWNLOAD_ORIGIN_IMAGE_PATH = "downloadOriginImagePath";
    private static final String TAG = "ImageVideoScanAdapter";
    private BroadcastReceiver downloadReceiver;
    private Handler durationHandler;
    private Context mContext;
    private TUIMessageBean mNewLocateMessage;
    private TUIMessageBean mOldLocateMessage;
    private ImageVideoScanActivity.OnItemClickListener onItemClickListener;
    private Runnable updateSeekBarTime;
    private List<TUIMessageBean> mDataSource = new ArrayList();
    private boolean mIsVideoPlay = false;
    private String mCacheImagePath = null;

    /* renamed from: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter$3 */
    /* loaded from: classes3.dex */
    public class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ V2TIMImageElem.V2TIMImage val$finalMCurrentOriginalImage;
        public final /* synthetic */ ViewHolder val$holder;

        public AnonymousClass3(V2TIMImageElem.V2TIMImage v2TIMImage, ViewHolder viewHolder) {
            ImageVideoScanAdapter.this = r1;
            this.val$finalMCurrentOriginalImage = v2TIMImage;
            this.val$holder = viewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            V2TIMImageElem.V2TIMImage v2TIMImage = this.val$finalMCurrentOriginalImage;
            if (v2TIMImage == null) {
                TUIChatLog.e(ImageVideoScanAdapter.TAG, "finalMCurrentOriginalImage is null");
                return;
            }
            final String generateImagePath = ImageUtil.generateImagePath(v2TIMImage.getUUID(), this.val$finalMCurrentOriginalImage.getType());
            this.val$finalMCurrentOriginalImage.downloadImage(generateImagePath, new V2TIMDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.3.1
                {
                    AnonymousClass3.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i2, String str) {
                    ToastUtil.toastLongMessage("Download origin image failed , errCode = " + i2 + ", " + str);
                }

                @Override // com.tencent.imsdk.v2.V2TIMDownloadCallback
                public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
                    long round = Math.round(((v2ProgressInfo.getCurrentSize() * 1.0d) * 100.0d) / v2ProgressInfo.getTotalSize());
                    if (AnonymousClass3.this.val$holder.viewOriginalButton.getVisibility() == 4 || AnonymousClass3.this.val$holder.viewOriginalButton.getVisibility() == 8) {
                        return;
                    }
                    TextView textView = AnonymousClass3.this.val$holder.viewOriginalButton;
                    textView.setText(round + "%");
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.3.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AnonymousClass3.this.val$holder.photoView.setImageBitmap(ImageUtil.adaptBitmapFormPath(generateImagePath, DeviceUtil.getScreenSize()[0], DeviceUtil.getScreenSize()[1]));
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            anonymousClass3.val$holder.viewOriginalButton.setText(ImageVideoScanAdapter.this.mContext.getString(R.string.completed));
                            AnonymousClass3.this.val$holder.viewOriginalButton.setOnClickListener(null);
                            AnonymousClass3.this.val$holder.viewOriginalButton.setVisibility(4);
                            Intent intent = new Intent();
                            intent.setAction(ImageVideoScanAdapter.BROADCAST_DOWNLOAD_COMPLETED_ACTION);
                            intent.putExtra(ImageVideoScanAdapter.DOWNLOAD_ORIGIN_IMAGE_PATH, generateImagePath);
                            LocalBroadcastManager.getInstance(ImageVideoScanAdapter.this.mContext).sendBroadcast(intent);
                        }
                    });
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public class MatrixChangeListener implements OnMatrixChangedListener {
        private MatrixChangeListener() {
            ImageVideoScanAdapter.this = r1;
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.component.photoview.listener.OnMatrixChangedListener
        public void onMatrixChanged(RectF rectF) {
        }
    }

    /* loaded from: classes3.dex */
    public class PhotoTapListener implements OnPhotoTapListener {
        private PhotoTapListener() {
            ImageVideoScanAdapter.this = r1;
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.component.photoview.listener.OnPhotoTapListener
        public void onPhotoTap(ImageView imageView, float f2, float f3) {
            if (ImageVideoScanAdapter.this.onItemClickListener != null) {
                ImageVideoScanAdapter.this.onItemClickListener.onClickItem();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class SingleFlingListener implements OnSingleFlingListener {
        private SingleFlingListener() {
            ImageVideoScanAdapter.this = r1;
        }

        @Override // com.tencent.qcloud.tuikit.tuichat.component.photoview.listener.OnSingleFlingListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView closeButton;
        public boolean downloadVideoFailed;
        public boolean downloadVideoFinished;
        public ProgressBar loadingView;
        public ImageView pauseCenterView;
        public PhotoView photoView;
        public RelativeLayout photoViewLayout;
        public ImageView playButton;
        public LinearLayout playControlLayout;
        public SeekBar playSeekBar;
        public ImageView snapImageView;
        public TextView timeBeginView;
        public TextView timeEndView;
        public UIKitVideoView videoView;
        public FrameLayout videoViewLayout;
        public TextView viewOriginalButton;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            ImageVideoScanAdapter.this = r1;
            this.downloadVideoFailed = false;
            this.downloadVideoFinished = false;
            this.photoViewLayout = (RelativeLayout) view.findViewById(R.id.photo_view_layout);
            this.photoView = (PhotoView) view.findViewById(R.id.photo_view);
            this.viewOriginalButton = (TextView) view.findViewById(R.id.view_original_btn);
            this.videoView = (UIKitVideoView) view.findViewById(R.id.video_play_view);
            this.closeButton = (ImageView) view.findViewById(R.id.close_button);
            this.playControlLayout = (LinearLayout) view.findViewById(R.id.play_control_layout);
            this.playButton = (ImageView) view.findViewById(R.id.play_button);
            this.playSeekBar = (SeekBar) view.findViewById(R.id.play_seek);
            this.timeEndView = (TextView) view.findViewById(R.id.time_end);
            this.timeBeginView = (TextView) view.findViewById(R.id.time_begin);
            this.pauseCenterView = (ImageView) view.findViewById(R.id.pause_button_center);
            this.snapImageView = (ImageView) view.findViewById(R.id.content_image_iv);
            this.loadingView = (ProgressBar) view.findViewById(R.id.message_sending_pb);
            this.videoViewLayout = (FrameLayout) view.findViewById(R.id.video_view_layout);
        }
    }

    public ImageVideoScanAdapter() {
        this.mContext = null;
        this.mContext = TUIChatService.getAppContext();
    }

    public void clickPlayVideo(ViewHolder viewHolder) {
        if (!viewHolder.videoView.isPrepared()) {
            this.mIsVideoPlay = false;
            TUIChatLog.e(TAG, "!holder.videoView.isPrepared()");
        } else if (viewHolder.videoView.isPlaying()) {
            TUIChatLog.d(TAG, "holder.videoView.isPlaying()");
            viewHolder.videoView.pause();
            viewHolder.playButton.setImageResource(R.drawable.ic_play_icon);
            viewHolder.pauseCenterView.setVisibility(0);
            viewHolder.loadingView.setVisibility(8);
            this.mIsVideoPlay = false;
        } else if ((viewHolder.videoView.getDuration() * 1.0f) / 1000.0f <= 0.0f) {
            TUIChatLog.e(TAG, "onClick, downloading video");
            viewHolder.pauseCenterView.setVisibility(8);
            viewHolder.loadingView.setVisibility(0);
            resetVideo(viewHolder);
        } else {
            int round = Math.round((viewHolder.videoView.getDuration() * 1.0f) / 1000.0f);
            int round2 = Math.round((viewHolder.videoView.getCurrentPosition() * 1.0f) / 1000.0f);
            String str = TAG;
            TUIChatLog.d(str, "onClick playSeekBar duration == " + round + " playSeekBar progress = " + round2);
            if (viewHolder.playSeekBar.getProgress() >= round) {
                TUIChatLog.e(str, "getProgress() >= duration");
                resetVideo(viewHolder);
                return;
            }
            viewHolder.videoView.start();
            viewHolder.playButton.setImageResource(R.drawable.ic_pause_icon);
            viewHolder.pauseCenterView.setVisibility(8);
            viewHolder.loadingView.setVisibility(8);
            viewHolder.snapImageView.setVisibility(8);
            this.mIsVideoPlay = true;
            viewHolder.playSeekBar.setMax(round);
            viewHolder.playSeekBar.setProgress(round2);
            viewHolder.timeEndView.setText(DateTimeUtil.formatSecondsTo00(round));
            Handler handler = this.durationHandler;
            if (handler != null) {
                handler.postDelayed(this.updateSeekBarTime, 100L);
            }
        }
    }

    private TUIMessageBean getItem(int i2) {
        List<TUIMessageBean> list = this.mDataSource;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.mDataSource.get(i2);
    }

    private void getVideo(final ViewHolder viewHolder, String str, final VideoMessageBean videoMessageBean, final boolean z, final int i2) {
        videoMessageBean.downloadVideo(str, new VideoMessageBean.VideoDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.12
            {
                ImageVideoScanAdapter.this = this;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
            public void onError(int i3, String str2) {
                ToastUtil.toastLongMessage(TUIChatService.getAppContext().getString(R.string.download_file_error) + i3 + "=" + str2);
                videoMessageBean.setStatus(6);
                ImageVideoScanAdapter.this.notifyItemChanged(i2);
                viewHolder.downloadVideoFailed = true;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
            public void onProgress(long j2, long j3) {
                TUIChatLog.i("downloadVideo progress current:", j2 + ", total:" + j3);
                viewHolder.downloadVideoFinished = false;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
            public void onSuccess() {
                viewHolder.pauseCenterView.setVisibility(0);
                viewHolder.loadingView.setVisibility(8);
                ImageVideoScanAdapter.this.notifyItemChanged(i2);
                ViewHolder viewHolder2 = viewHolder;
                viewHolder2.downloadVideoFailed = false;
                viewHolder2.downloadVideoFinished = true;
                if (z) {
                    ImageVideoScanAdapter.this.playVideo(viewHolder2, videoMessageBean);
                }
            }
        });
    }

    private void loadPhotoView(final ViewHolder viewHolder, final ImageMessageBean imageMessageBean, int i2) {
        List<ImageMessageBean.ImageBean> imageBeanList = imageMessageBean.getImageBeanList();
        String dataPath = imageMessageBean.getDataPath();
        String originImagePath = TUIChatUtils.getOriginImagePath(imageMessageBean);
        if (!TextUtils.isEmpty(originImagePath)) {
            dataPath = originImagePath;
        }
        if (TextUtils.isEmpty(dataPath)) {
            int i3 = 0;
            while (true) {
                if (i3 >= imageBeanList.size()) {
                    break;
                }
                ImageMessageBean.ImageBean imageBean = imageBeanList.get(i3);
                if (imageBean.getType() == 2) {
                    final String generateImagePath = ImageUtil.generateImagePath(imageBean.getUUID(), 2);
                    imageBean.downloadImage(generateImagePath, new ImageMessageBean.ImageBean.ImageDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.2
                        {
                            ImageVideoScanAdapter.this = this;
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                        public void onError(int i4, String str) {
                            TUIChatLog.e("MessageAdapter img getImage", i4 + Constants.COLON_SEPARATOR + str);
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                        public void onProgress(long j2, long j3) {
                            TUIChatLog.i("downloadImage progress current:", j2 + ", total:" + j3);
                        }

                        @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean.ImageBean.ImageDownloadCallback
                        public void onSuccess() {
                            viewHolder.loadingView.setVisibility(8);
                            imageMessageBean.setDataPath(generateImagePath);
                            BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.2.1
                                {
                                    AnonymousClass2.this = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    ImageVideoScanAdapter.this.notifyDataSetChanged();
                                }
                            });
                        }
                    });
                    break;
                }
                i3++;
            }
        }
        String originImagePath2 = TUIChatUtils.getOriginImagePath(imageMessageBean);
        boolean z = originImagePath2 != null;
        V2TIMImageElem.V2TIMImage v2TIMImage = null;
        for (int i4 = 0; i4 < imageBeanList.size(); i4++) {
            ImageMessageBean.ImageBean imageBean2 = imageBeanList.get(i4);
            if (imageBean2.getType() == 0) {
                v2TIMImage = imageBean2.getV2TIMImage();
            }
            if (imageBean2.getType() == 2 && !z) {
                originImagePath2 = ImageUtil.generateImagePath(imageBean2.getUUID(), 2);
            }
        }
        if (FileUtil.getUriFromPath(originImagePath2) != null) {
            viewHolder.loadingView.setVisibility(8);
        }
        viewHolder.photoView.setDisplayMatrix(new Matrix());
        viewHolder.photoView.setOnMatrixChangeListener(new MatrixChangeListener());
        viewHolder.photoView.setOnPhotoTapListener(new PhotoTapListener());
        viewHolder.photoView.setOnSingleFlingListener(new SingleFlingListener());
        viewHolder.photoView.setImageBitmap(ImageUtil.adaptBitmapFormPath(originImagePath2, DeviceUtil.getScreenSize()[0], DeviceUtil.getScreenSize()[1]));
        if (!z) {
            viewHolder.viewOriginalButton.setVisibility(0);
            viewHolder.viewOriginalButton.setOnClickListener(new AnonymousClass3(v2TIMImage, viewHolder));
        } else if (viewHolder.photoView.getDrawable() == null) {
            ToastUtil.toastShortMessage("Downloading , please wait.");
            this.downloadReceiver = new BroadcastReceiver() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.4
                {
                    ImageVideoScanAdapter.this = this;
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    String stringExtra;
                    if (!ImageVideoScanAdapter.BROADCAST_DOWNLOAD_COMPLETED_ACTION.equals(intent.getAction()) || (stringExtra = intent.getStringExtra(ImageVideoScanAdapter.DOWNLOAD_ORIGIN_IMAGE_PATH)) == null) {
                        return;
                    }
                    viewHolder.photoView.setImageBitmap(ImageUtil.adaptBitmapFormPath(stringExtra, DeviceUtil.getScreenSize()[0], DeviceUtil.getScreenSize()[1]));
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BROADCAST_DOWNLOAD_COMPLETED_ACTION);
            LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.downloadReceiver, intentFilter);
        }
    }

    private void loadVideoView(final ViewHolder viewHolder, final VideoMessageBean videoMessageBean, int i2) {
        if (TextUtils.isEmpty(videoMessageBean.getDataPath())) {
            final String str = TUIConfig.getImageDownloadDir() + videoMessageBean.getSnapshotUUID();
            videoMessageBean.downloadSnapshot(str, new VideoMessageBean.VideoDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.5
                {
                    ImageVideoScanAdapter.this = this;
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                public void onError(int i3, String str2) {
                    TUIChatLog.e("MessageAdapter video getImage", i3 + Constants.COLON_SEPARATOR + str2);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                public void onProgress(long j2, long j3) {
                    TUIChatLog.i("downloadSnapshot progress current:", j2 + ", total:" + j3);
                }

                @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                public void onSuccess() {
                    viewHolder.pauseCenterView.setVisibility(0);
                    viewHolder.loadingView.setVisibility(8);
                    videoMessageBean.setDataPath(str);
                    ImageVideoScanAdapter.this.mCacheImagePath = str;
                    viewHolder.snapImageView.setVisibility(0);
                    GlideEngine.loadImage(viewHolder.snapImageView, str);
                    Bitmap bitmapFormPath = ImageUtil.getBitmapFormPath(str);
                    if (bitmapFormPath != null) {
                        ImageVideoScanAdapter.this.updateVideoView(viewHolder, bitmapFormPath.getWidth(), bitmapFormPath.getHeight());
                    }
                }
            });
        } else {
            String dataPath = videoMessageBean.getDataPath();
            viewHolder.snapImageView.setVisibility(0);
            GlideEngine.loadImage(viewHolder.snapImageView, dataPath);
            updateVideoViewSize(viewHolder, dataPath);
        }
        String str2 = TUIConfig.getVideoDownloadDir() + videoMessageBean.getVideoUUID();
        File file = new File(str2);
        if (file.exists() && videoMessageBean.getVideoSize() == file.length()) {
            playVideo(viewHolder, videoMessageBean);
        } else if (viewHolder.downloadVideoFailed || viewHolder.downloadVideoFinished) {
        } else {
            getVideo(viewHolder, str2, videoMessageBean, true, i2);
        }
    }

    private void performPhotoView(ViewHolder viewHolder, TUIMessageBean tUIMessageBean, int i2) {
        viewHolder.photoViewLayout.setVisibility(0);
        viewHolder.videoView.setVisibility(8);
        viewHolder.closeButton.setVisibility(8);
        viewHolder.playControlLayout.setVisibility(8);
        viewHolder.pauseCenterView.setVisibility(8);
        viewHolder.loadingView.setVisibility(0);
        viewHolder.videoViewLayout.setVisibility(8);
        if (tUIMessageBean instanceof ImageMessageBean) {
            loadPhotoView(viewHolder, (ImageMessageBean) tUIMessageBean, i2);
        } else {
            TUIChatLog.e(TAG, "is not ImageMessageBean");
        }
    }

    private void performVideoView(ViewHolder viewHolder, TUIMessageBean tUIMessageBean, int i2) {
        viewHolder.photoViewLayout.setVisibility(8);
        viewHolder.videoView.setVisibility(0);
        viewHolder.closeButton.setVisibility(0);
        viewHolder.playControlLayout.setVisibility(0);
        viewHolder.pauseCenterView.setVisibility(8);
        viewHolder.loadingView.setVisibility(0);
        viewHolder.videoViewLayout.setVisibility(0);
        if (tUIMessageBean instanceof VideoMessageBean) {
            this.mIsVideoPlay = false;
            playControlInit(viewHolder);
            loadVideoView(viewHolder, (VideoMessageBean) tUIMessageBean, i2);
            return;
        }
        TUIChatLog.e(TAG, "is not VideoMessageBean");
    }

    private void playControlInit(final ViewHolder viewHolder) {
        viewHolder.closeButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.6
            {
                ImageVideoScanAdapter.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UIKitVideoView uIKitVideoView = viewHolder.videoView;
                if (uIKitVideoView == null) {
                    TUIChatLog.e(ImageVideoScanAdapter.TAG, "videoView is null");
                } else {
                    uIKitVideoView.stop();
                }
                ImageVideoScanAdapter.this.onItemClickListener.onClickItem();
            }
        });
        viewHolder.playButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.7
            {
                ImageVideoScanAdapter.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageVideoScanAdapter.this.clickPlayVideo(viewHolder);
            }
        });
        viewHolder.playSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.8
            {
                ImageVideoScanAdapter.this = this;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                viewHolder.timeBeginView.setText(DateTimeUtil.formatSecondsTo00(i2));
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                String str = ImageVideoScanAdapter.TAG;
                TUIChatLog.i(str, "onStartTrackingTouch progress == " + progress);
                UIKitVideoView uIKitVideoView = viewHolder.videoView;
                if (uIKitVideoView != null) {
                    uIKitVideoView.seekTo(progress * 1000);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                String str = ImageVideoScanAdapter.TAG;
                TUIChatLog.i(str, "onStopTrackingTouch progress == " + progress);
                UIKitVideoView uIKitVideoView = viewHolder.videoView;
                if (uIKitVideoView != null && uIKitVideoView.isPlaying()) {
                    viewHolder.videoView.seekTo(progress * 1000);
                    viewHolder.videoView.start();
                    return;
                }
                UIKitVideoView uIKitVideoView2 = viewHolder.videoView;
                if (uIKitVideoView2 != null) {
                    uIKitVideoView2.seekTo(progress * 1000);
                }
            }
        });
        viewHolder.pauseCenterView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.9
            {
                ImageVideoScanAdapter.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ImageVideoScanAdapter.this.clickPlayVideo(viewHolder);
            }
        });
    }

    public void playVideo(final ViewHolder viewHolder, final VideoMessageBean videoMessageBean) {
        Uri processVideoMessage = processVideoMessage(videoMessageBean);
        viewHolder.pauseCenterView.setVisibility(0);
        viewHolder.loadingView.setVisibility(8);
        if (processVideoMessage == null) {
            TUIChatLog.e(TAG, "playVideo videoUri == null");
            return;
        }
        viewHolder.videoView.setVideoURI(processVideoMessage);
        viewHolder.videoView.setOnPreparedListener(new IPlayer.OnPreparedListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.10
            {
                ImageVideoScanAdapter.this = this;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnPreparedListener
            public void onPrepared(IPlayer iPlayer) {
                TUIChatLog.e(ImageVideoScanAdapter.TAG, "onPrepared()");
                viewHolder.videoView.start();
                viewHolder.videoView.pause();
                viewHolder.playButton.setImageResource(R.drawable.ic_play_icon);
                viewHolder.pauseCenterView.setVisibility(0);
                viewHolder.loadingView.setVisibility(8);
                ImageVideoScanAdapter.this.updateVideoViewSize(viewHolder, videoMessageBean.getDataPath());
                ImageVideoScanAdapter.this.mIsVideoPlay = false;
                if (ImageVideoScanAdapter.this.durationHandler != null) {
                    ImageVideoScanAdapter.this.durationHandler = null;
                }
                if (ImageVideoScanAdapter.this.updateSeekBarTime != null) {
                    ImageVideoScanAdapter.this.updateSeekBarTime = null;
                }
                ImageVideoScanAdapter.this.durationHandler = new Handler();
                ImageVideoScanAdapter.this.updateSeekBarTime = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.10.1
                    {
                        AnonymousClass10.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        int currentPosition = viewHolder.videoView.getCurrentPosition();
                        if (viewHolder.playSeekBar.getProgress() >= viewHolder.playSeekBar.getMax()) {
                            TUIChatLog.e(ImageVideoScanAdapter.TAG, "getProgress() >= getMax()");
                            AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                            ImageVideoScanAdapter.this.resetVideo(viewHolder);
                            return;
                        }
                        viewHolder.playSeekBar.setProgress(Math.round((currentPosition * 1.0f) / 1000.0f));
                        viewHolder.timeBeginView.setText(DateTimeUtil.formatSecondsTo00(Math.round((viewHolder.videoView.getCurrentPosition() * 1.0f) / 1000.0f)));
                        if (ImageVideoScanAdapter.this.mIsVideoPlay) {
                            ImageVideoScanAdapter.this.durationHandler.postDelayed(this, 100L);
                        }
                    }
                };
                int round = Math.round((iPlayer.getDuration() * 1.0f) / 1000.0f);
                int round2 = Math.round((iPlayer.getCurrentPosition() * 1.0f) / 1000.0f);
                viewHolder.playSeekBar.setMax(round);
                viewHolder.playSeekBar.setProgress(round2);
                viewHolder.timeEndView.setText(DateTimeUtil.formatSecondsTo00(round));
                ImageVideoScanAdapter.this.durationHandler.postDelayed(ImageVideoScanAdapter.this.updateSeekBarTime, 100L);
            }
        });
        viewHolder.videoView.setOnSeekCompleteListener(new IPlayer.OnSeekCompleteListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.11
            {
                ImageVideoScanAdapter.this = this;
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer.OnSeekCompleteListener
            public void OnSeekComplete(IPlayer iPlayer) {
            }
        });
    }

    private Uri processVideoMessage(VideoMessageBean videoMessageBean) {
        V2TIMMessage v2TIMMessage = videoMessageBean.getV2TIMMessage();
        V2TIMVideoElem videoElem = v2TIMMessage.getVideoElem();
        if (v2TIMMessage.isSelf() && !TextUtils.isEmpty(videoElem.getSnapshotPath())) {
            return FileUtil.getUriFromPath(videoElem.getVideoPath());
        }
        return Uri.parse(TUIConfig.getVideoDownloadDir() + videoElem.getVideoUUID());
    }

    public void updateVideoView(ViewHolder viewHolder, int i2, int i3) {
        int min;
        int max;
        String str = TAG;
        TUIChatLog.i(str, "updateVideoView videoWidth: " + i2 + " videoHeight: " + i3);
        if (i2 > 0 || i3 > 0) {
            if (this.mContext.getResources().getConfiguration().orientation != 1) {
                min = Math.max(ScreenUtil.getScreenWidth(this.mContext), ScreenUtil.getScreenHeight(this.mContext));
                max = Math.min(ScreenUtil.getScreenWidth(this.mContext), ScreenUtil.getScreenHeight(this.mContext));
            } else {
                min = Math.min(ScreenUtil.getScreenWidth(this.mContext), ScreenUtil.getScreenHeight(this.mContext));
                max = Math.max(ScreenUtil.getScreenWidth(this.mContext), ScreenUtil.getScreenHeight(this.mContext));
            }
            int[] scaledSize = ScreenUtil.scaledSize(min, max, i2, i3);
            TUIChatLog.i(str, "scaled width: " + scaledSize[0] + " height: " + scaledSize[1]);
            ViewGroup.LayoutParams layoutParams = viewHolder.videoView.getLayoutParams();
            layoutParams.width = scaledSize[0];
            layoutParams.height = scaledSize[1];
            viewHolder.videoView.setLayoutParams(layoutParams);
            if (viewHolder.snapImageView.getVisibility() == 0) {
                viewHolder.snapImageView.setLayoutParams(layoutParams);
            }
        }
    }

    public void updateVideoViewSize(ViewHolder viewHolder, String str) {
        Bitmap bitmapFormPath;
        String str2 = this.mCacheImagePath;
        if ((str2 == null || !str2.equals(str)) && (bitmapFormPath = ImageUtil.getBitmapFormPath(str)) != null) {
            updateVideoView(viewHolder, bitmapFormPath.getWidth(), bitmapFormPath.getHeight());
        }
    }

    public int addDataToSource(List<TUIMessageBean> list, int i2, int i3) {
        if (list != null && !list.isEmpty()) {
            List<TUIMessageBean> list2 = this.mDataSource;
            if (list2 == null) {
                TUIChatLog.e(TAG, "addDataToSource mDataSource is null");
                return i3;
            }
            TUIMessageBean tUIMessageBean = list2.get(i3);
            if (i2 == 0) {
                this.mOldLocateMessage = list.get(0);
                String str = TAG;
                Log.d(str, "mOldLocateMessage seq:" + this.mOldLocateMessage.getV2TIMMessage().getSeq());
                this.mDataSource.addAll(0, list);
                i3 = list.size();
            } else if (i2 == 1) {
                this.mNewLocateMessage = list.get(list.size() - 1);
                String str2 = TAG;
                Log.d(str2, "mNewLocateMessage seq:" + this.mNewLocateMessage.getV2TIMMessage().getSeq());
                this.mDataSource.addAll(list);
            } else {
                TUIChatLog.e(TAG, "addDataToSource error type");
            }
            Iterator<TUIMessageBean> it = this.mDataSource.iterator();
            while (it.hasNext()) {
                String str3 = TAG;
                TUIChatLog.d(str3, "message seq = " + it.next().getV2TIMMessage().getSeq());
            }
            if (tUIMessageBean == null) {
                TUIChatLog.e(TAG, "messageBean == null");
            }
        }
        return i3;
    }

    public void destroyView(RecyclerView recyclerView, int i2) {
        View childAt = recyclerView.getChildAt(i2);
        if (childAt != null) {
            UIKitVideoView uIKitVideoView = (UIKitVideoView) childAt.findViewById(R.id.video_play_view);
            SeekBar seekBar = (SeekBar) childAt.findViewById(R.id.play_seek);
            if (uIKitVideoView != null) {
                uIKitVideoView.stop();
            }
            if (seekBar != null) {
                seekBar.setProgress(0);
            }
        }
        if (this.downloadReceiver != null) {
            LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this.downloadReceiver);
            this.downloadReceiver = null;
        }
    }

    public List<TUIMessageBean> getDataSource() {
        return this.mDataSource;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDataSource.size();
    }

    public TUIMessageBean getNewLocateMessage() {
        return this.mNewLocateMessage;
    }

    public TUIMessageBean getOldLocateMessage() {
        return this.mOldLocateMessage;
    }

    public void resetVideo(ViewHolder viewHolder) {
        viewHolder.videoView.stop();
        viewHolder.videoView.resetVideo();
        viewHolder.playButton.setImageResource(R.drawable.ic_play_icon);
        viewHolder.pauseCenterView.setVisibility(0);
        viewHolder.snapImageView.setVisibility(8);
        viewHolder.loadingView.setVisibility(8);
        viewHolder.playSeekBar.setProgress(0);
        this.mIsVideoPlay = false;
        viewHolder.timeBeginView.setText(DateTimeUtil.formatSecondsTo00(0));
    }

    public void setDataSource(List<TUIMessageBean> list) {
        if (list != null && !list.isEmpty()) {
            this.mOldLocateMessage = list.get(0);
            this.mNewLocateMessage = list.get(list.size() - 1);
        } else {
            TUIChatLog.d(TAG, "setDataSource dataSource is Empty");
            this.mOldLocateMessage = null;
            this.mNewLocateMessage = null;
        }
        this.mDataSource = list;
        Iterator<TUIMessageBean> it = list.iterator();
        while (it.hasNext()) {
            String str = TAG;
            TUIChatLog.d(str, "message seq = " + it.next().getV2TIMMessage().getSeq());
        }
        String str2 = TAG;
        Log.d(str2, "mOldLocateMessage seq:" + this.mOldLocateMessage.getV2TIMMessage().getSeq());
        Log.d(str2, "mNewLocateMessage seq:" + this.mNewLocateMessage.getV2TIMMessage().getSeq());
    }

    public void setOnItemClickListener(ImageVideoScanActivity.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        TUIMessageBean item = getItem(i2);
        if (item == null) {
            return;
        }
        viewHolder.playSeekBar.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanAdapter.1
            {
                ImageVideoScanAdapter.this = this;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        V2TIMMessage v2TIMMessage = item.getV2TIMMessage();
        if (v2TIMMessage.getElemType() == 3) {
            performPhotoView(viewHolder, item, i2);
        } else if (v2TIMMessage.getElemType() == 5) {
            performVideoView(viewHolder, item, i2);
        } else {
            TUIChatLog.d(TAG, "error message type");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_video_scan_item, viewGroup, false));
    }
}
