package com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.text.TextUtils;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ThreadHelper;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.ImageMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.FileUtil;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ImageVideoScanPresenter {
    private static final String TAG = "ImageVideoScanPresenter";
    private ImageVideoScanAdapter mAdapter;
    private String mChatID;
    private ImageVideoScanProvider mImageVideoScanProvider;
    private RecyclerView mRecyclerView;
    private ViewPagerLayoutManager mViewPagerLayoutManager;
    private int mCurrentPosition = -1;
    private int mIndex = 0;
    private boolean mIsForwardMode = false;

    public void init(final TUIMessageBean tUIMessageBean, List<TUIMessageBean> list, boolean z) {
        this.mIsForwardMode = z;
        if (z) {
            this.mAdapter.setDataSource(list);
            this.mAdapter.notifyDataSetChanged();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                } else if (list.get(i3).getId().equals(tUIMessageBean.getId())) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            this.mRecyclerView.scrollToPosition(i2);
            this.mCurrentPosition = i2;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(tUIMessageBean);
            this.mAdapter.setDataSource(arrayList);
            this.mAdapter.notifyDataSetChanged();
            this.mImageVideoScanProvider = new ImageVideoScanProvider();
            String groupID = tUIMessageBean.isGroup() ? tUIMessageBean.getV2TIMMessage().getGroupID() : tUIMessageBean.getV2TIMMessage().getUserID();
            this.mChatID = groupID;
            this.mImageVideoScanProvider.initMessageList(groupID, tUIMessageBean.isGroup(), tUIMessageBean, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanPresenter.1
                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i4, String str2) {
                    String str3 = ImageVideoScanPresenter.TAG;
                    TUIChatLog.e(str3, "loadChatMessages initMessageList failed, code = " + i4 + ", desc = " + str2);
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(List<TUIMessageBean> list2) {
                    ImageVideoScanPresenter.this.mAdapter.setDataSource(list2);
                    ImageVideoScanPresenter.this.mAdapter.notifyDataSetChanged();
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= list2.size()) {
                            break;
                        } else if (list2.get(i5).getId().equals(tUIMessageBean.getId())) {
                            i4 = i5;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    ImageVideoScanPresenter.this.mRecyclerView.scrollToPosition(i4);
                    ImageVideoScanPresenter.this.mCurrentPosition = i4;
                }
            });
        }
        this.mViewPagerLayoutManager.setOnViewPagerListener(new OnViewPagerListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanPresenter.2
            @Override // com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.OnViewPagerListener
            public void onInitComplete() {
                Log.e(ImageVideoScanPresenter.TAG, "onInitComplete");
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.OnViewPagerListener
            public void onPageRelease(boolean z2, int i4) {
                String str = ImageVideoScanPresenter.TAG;
                Log.e(str, "释放位置:" + i4 + " 下一页:" + z2);
                ImageVideoScanPresenter.this.mIndex = !z2 ? 1 : 0;
                ImageVideoScanPresenter.this.releaseUI();
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.OnViewPagerListener
            public void onPageSelected(final int i4, boolean z2, boolean z3) {
                String str = ImageVideoScanPresenter.TAG;
                Log.e(str, "选中位置:" + i4 + "  是否是滑动到底部:" + z2 + "是否左滑:" + z2);
                ImageVideoScanPresenter.this.mCurrentPosition = i4;
                if (ImageVideoScanPresenter.this.mIsForwardMode) {
                    return;
                }
                if (z3) {
                    if (i4 == 0) {
                        if (ImageVideoScanPresenter.this.mAdapter.getOldLocateMessage() != null) {
                            String str2 = ImageVideoScanPresenter.TAG;
                            Log.d(str2, "mAdapter.getOldLocateMessage() seq:" + ImageVideoScanPresenter.this.mAdapter.getOldLocateMessage().getV2TIMMessage().getSeq());
                        }
                        ImageVideoScanPresenter.this.mImageVideoScanProvider.loadLocalMediaMessageForward(ImageVideoScanPresenter.this.mChatID, tUIMessageBean.isGroup(), ImageVideoScanPresenter.this.mAdapter.getOldLocateMessage(), new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanPresenter.2.1
                            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                            public void onError(String str3, int i5, String str4) {
                                String str5 = ImageVideoScanPresenter.TAG;
                                TUIChatLog.e(str5, "onPageSelected loadLocalMediaMessageForward failed, code = " + i5 + ", desc = " + str4);
                            }

                            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                            public void onSuccess(List<TUIMessageBean> list2) {
                                if (list2 == null || list2.isEmpty()) {
                                    return;
                                }
                                ImageVideoScanPresenter.this.mRecyclerView.scrollToPosition(ImageVideoScanPresenter.this.mAdapter.addDataToSource(list2, 0, i4));
                                ImageVideoScanPresenter.this.mAdapter.notifyDataSetChanged();
                            }
                        });
                    }
                } else if (i4 == ImageVideoScanPresenter.this.mAdapter.getItemCount() - 1) {
                    if (ImageVideoScanPresenter.this.mAdapter.getNewLocateMessage() != null) {
                        String str3 = ImageVideoScanPresenter.TAG;
                        Log.d(str3, "mAdapter.getNewLocateMessage() seq:" + ImageVideoScanPresenter.this.mAdapter.getNewLocateMessage().getV2TIMMessage().getSeq());
                    }
                    ImageVideoScanPresenter.this.mImageVideoScanProvider.loadLocalMediaMessageBackward(ImageVideoScanPresenter.this.mChatID, tUIMessageBean.isGroup(), ImageVideoScanPresenter.this.mAdapter.getNewLocateMessage(), new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanPresenter.2.2
                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onError(String str4, int i5, String str5) {
                            String str6 = ImageVideoScanPresenter.TAG;
                            TUIChatLog.e(str6, "onPageSelected loadLocalMediaMessageBackward failed, code = " + i5 + ", desc = " + str5);
                        }

                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onSuccess(List<TUIMessageBean> list2) {
                            if (list2 == null || list2.isEmpty()) {
                                return;
                            }
                            ImageVideoScanPresenter.this.mRecyclerView.scrollToPosition(ImageVideoScanPresenter.this.mAdapter.addDataToSource(list2, 1, i4));
                            ImageVideoScanPresenter.this.mAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }

    public void releaseUI() {
        ImageVideoScanAdapter imageVideoScanAdapter = this.mAdapter;
        if (imageVideoScanAdapter != null) {
            imageVideoScanAdapter.destroyView(this.mRecyclerView, this.mIndex);
        }
    }

    public void saveLocal(final Context context) {
        int i2;
        String str = TAG;
        TUIChatLog.d(str, "mCurrentPosition = " + this.mCurrentPosition);
        ImageVideoScanAdapter imageVideoScanAdapter = this.mAdapter;
        if (imageVideoScanAdapter == null || (i2 = this.mCurrentPosition) < 0 || i2 >= imageVideoScanAdapter.getItemCount()) {
            return;
        }
        TUIMessageBean tUIMessageBean = this.mAdapter.getDataSource().get(this.mCurrentPosition);
        if (tUIMessageBean.getMsgType() == 3) {
            if (tUIMessageBean instanceof ImageMessageBean) {
                ImageMessageBean imageMessageBean = (ImageMessageBean) tUIMessageBean;
                imageMessageBean.getImageBeanList();
                final String dataPath = imageMessageBean.getDataPath();
                TUIChatLog.d(str, "imagePath = " + dataPath);
                String originImagePath = TUIChatUtils.getOriginImagePath(imageMessageBean);
                TUIChatLog.d(str, "originImagePath = " + originImagePath);
                if (!TextUtils.isEmpty(originImagePath)) {
                    dataPath = originImagePath;
                }
                ThreadHelper.INST.execute(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanPresenter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        FileUtil.saveImageToGallery(context, BitmapFactory.decodeFile(dataPath));
                        ToastUtil.toastShortMessage(context.getString(R.string.save_tips));
                    }
                });
                return;
            }
            TUIChatLog.e(str, "is not ImageMessageBean");
        } else if (tUIMessageBean.getMsgType() == 5) {
            if (tUIMessageBean instanceof VideoMessageBean) {
                final VideoMessageBean videoMessageBean = (VideoMessageBean) tUIMessageBean;
                final String str2 = FileUtil.rootPath + videoMessageBean.getVideoUUID();
                final ProgressDialog show = ProgressDialog.show(context, "", context.getString(R.string.saving_tips), false, true);
                videoMessageBean.downloadVideo(str2, new VideoMessageBean.VideoDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ImageVideoScanPresenter.4
                    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                    public void onError(int i3, String str3) {
                        ToastUtil.toastLongMessage(TUIChatService.getAppContext().getString(R.string.download_file_error) + i3 + "=" + str3);
                        videoMessageBean.setStatus(6);
                        show.cancel();
                    }

                    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                    public void onProgress(long j2, long j3) {
                        TUIChatLog.i("downloadVideo progress current:", j2 + ", total:" + j3);
                    }

                    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.VideoMessageBean.VideoDownloadCallback
                    public void onSuccess() {
                        show.cancel();
                        MediaScannerConnection.scanFile(context, new String[]{str2}, null, null);
                        ToastUtil.toastShortMessage(context.getString(R.string.save_tips));
                    }
                });
                return;
            }
            TUIChatLog.e(str, "is not VideoMessageBean");
        } else {
            TUIChatLog.d(str, "error message type");
        }
    }

    public void setAdapter(ImageVideoScanAdapter imageVideoScanAdapter) {
        this.mAdapter = imageVideoScanAdapter;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    public void setViewPagerLayoutManager(ViewPagerLayoutManager viewPagerLayoutManager) {
        this.mViewPagerLayoutManager = viewPagerLayoutManager;
    }
}
