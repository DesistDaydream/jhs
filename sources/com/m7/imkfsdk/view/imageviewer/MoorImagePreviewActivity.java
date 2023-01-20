package com.m7.imkfsdk.view.imageviewer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.model.MoorImageInfoBean;
import com.m7.imkfsdk.utils.MoorFileUtils;
import com.m7.imkfsdk.utils.MoorPathUtil;
import com.m7.imkfsdk.utils.ToastUtils;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import com.m7.imkfsdk.utils.permission.PermissionXUtil;
import com.m7.imkfsdk.utils.permission.callback.OnRequestCallback;
import com.m7.imkfsdk.view.imageviewer.helper.MoorDragCloseHelper;
import com.m7.imkfsdk.view.imageviewer.photoview.MoorPhotoView;
import com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView;
import com.moor.imkf.lib.http.MoorBaseHttpUtils;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.lib.utils.MoorSdkVersionUtil;
import e.b.a.c;
import java.io.File;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class MoorImagePreviewActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;
    private int currentItem;
    private String currentItemPathUrl = "";
    private MoorDragCloseHelper dragCloseHelper;
    private FrameLayout fl_download;
    private FrameLayout fmCenterProgressContainer;
    private List<MoorImageInfoBean> imageInfoList;
    private MoorImagePreviewAdapter moorImagePreviewAdapter;
    private View rootView;
    private boolean scrolling;
    private TextView tvIndicator;

    public static void activityStart(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(context, MoorImagePreviewActivity.class);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.ykfsdk_image_preview_fade_in, R.anim.ykfsdk_image_preview_fade_out);
    }

    public void downloadCurrentImg() {
        if (this.currentItemPathUrl.startsWith("http")) {
            new Thread(new Runnable() { // from class: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewActivity.4
                {
                    MoorImagePreviewActivity.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final File file = c.D(MoorImagePreviewActivity.this.context).o().k(MoorImagePreviewActivity.this.currentItemPathUrl).C1().get();
                        if (MoorFileUtils.saveImage(MoorImagePreviewActivity.this, file)) {
                            MoorImagePreviewActivity.this.runOnUiThread(new Runnable() { // from class: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewActivity.4.1
                                {
                                    AnonymousClass4.this = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    MoorLogUtils.i(file.getAbsoluteFile());
                                    MoorImagePreviewActivity moorImagePreviewActivity = MoorImagePreviewActivity.this;
                                    ToastUtils.showShort(moorImagePreviewActivity, MoorImagePreviewActivity.this.getResources().getString(R.string.ykfsdk_toast_save_success) + MoorPathUtil.getImageDownLoadPath());
                                    MoorImagePreviewActivity.this.fl_download.setVisibility(8);
                                }
                            });
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }).start();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.dragCloseHelper.handleEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.ykfsdk_image_preview_fade_in, R.anim.ykfsdk_image_preview_fade_out);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.fl_download) {
            PermissionXUtil.checkPermission(this, new OnRequestCallback() { // from class: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewActivity.3
                {
                    MoorImagePreviewActivity.this = this;
                }

                @Override // com.m7.imkfsdk.utils.permission.callback.OnRequestCallback
                public void requestSuccess() {
                    MoorLogUtils.d("开始下载图片");
                    MoorImagePreviewActivity.this.fl_download.setVisibility(8);
                    new Thread(new Runnable() { // from class: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewActivity.3.1
                        {
                            AnonymousClass3.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            MoorImagePreviewActivity.this.downloadCurrentImg();
                        }
                    }).start();
                }
            }, PermissionConstants.STORE);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ykfsdk_layout_image_preview);
        this.context = this;
        if (MoorSdkVersionUtil.over21()) {
            Window window = getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } else if (MoorSdkVersionUtil.over19()) {
            getWindow().addFlags(67108864);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_download);
        this.fl_download = frameLayout;
        frameLayout.setOnClickListener(this);
        List<MoorImageInfoBean> imageInfoList = MoorImagePreview.getInstance().getImageInfoList();
        this.imageInfoList = imageInfoList;
        if (imageInfoList != null && imageInfoList.size() != 0) {
            this.currentItem = MoorImagePreview.getInstance().getIndex();
            boolean isShowIndicator = MoorImagePreview.getInstance().isShowIndicator();
            this.currentItemPathUrl = this.imageInfoList.get(this.currentItem).getPath();
            this.rootView = findViewById(R.id.rootView);
            final MoorHackyViewPager moorHackyViewPager = (MoorHackyViewPager) findViewById(R.id.viewPager);
            this.tvIndicator = (TextView) findViewById(R.id.tv_indicator);
            FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.fm_center_progress_container);
            this.fmCenterProgressContainer = frameLayout2;
            frameLayout2.setVisibility(8);
            if (!isShowIndicator) {
                this.tvIndicator.setVisibility(8);
            } else if (this.imageInfoList.size() > 1) {
                this.tvIndicator.setVisibility(0);
            } else {
                this.tvIndicator.setVisibility(8);
            }
            if (this.imageInfoList.get(this.currentItem).getPath().startsWith("http")) {
                this.fl_download.setVisibility(0);
            } else {
                this.fl_download.setVisibility(8);
            }
            TextView textView = this.tvIndicator;
            String string = getString(R.string.ykfsdk_indicator);
            textView.setText(String.format(string, (this.currentItem + 1) + "", "" + this.imageInfoList.size()));
            MoorImagePreviewAdapter moorImagePreviewAdapter = new MoorImagePreviewAdapter(this, this.imageInfoList);
            this.moorImagePreviewAdapter = moorImagePreviewAdapter;
            moorHackyViewPager.setAdapter(moorImagePreviewAdapter);
            moorHackyViewPager.setCurrentItem(this.currentItem);
            moorHackyViewPager.setOffscreenPageLimit(4);
            moorHackyViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewActivity.1
                {
                    MoorImagePreviewActivity.this = this;
                }

                @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i2) {
                    MoorImagePreviewActivity.this.scrolling = i2 != 0;
                }

                @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i2, float f2, int i3) {
                    super.onPageScrolled(i2, f2, i3);
                }

                @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i2) {
                    super.onPageSelected(i2);
                    MoorImagePreviewActivity.this.currentItem = i2;
                    MoorImageInfoBean moorImageInfoBean = (MoorImageInfoBean) MoorImagePreviewActivity.this.imageInfoList.get(i2);
                    MoorImagePreviewActivity.this.currentItemPathUrl = moorImageInfoBean.getPath();
                    TextView textView2 = MoorImagePreviewActivity.this.tvIndicator;
                    String string2 = MoorImagePreviewActivity.this.getString(R.string.ykfsdk_indicator);
                    textView2.setText(String.format(string2, (MoorImagePreviewActivity.this.currentItem + 1) + "", "" + MoorImagePreviewActivity.this.imageInfoList.size()));
                    if (moorImageInfoBean.getPath().startsWith("http")) {
                        MoorImagePreviewActivity.this.fl_download.setVisibility(0);
                    } else {
                        MoorImagePreviewActivity.this.fl_download.setVisibility(8);
                    }
                }
            });
            MoorDragCloseHelper moorDragCloseHelper = new MoorDragCloseHelper(this);
            this.dragCloseHelper = moorDragCloseHelper;
            moorDragCloseHelper.setShareElementMode(true);
            this.dragCloseHelper.setDragCloseViews(this.rootView, moorHackyViewPager);
            this.dragCloseHelper.setDragCloseListener(new MoorDragCloseHelper.DragCloseListener() { // from class: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewActivity.2
                {
                    MoorImagePreviewActivity.this = this;
                }

                @Override // com.m7.imkfsdk.view.imageviewer.helper.MoorDragCloseHelper.DragCloseListener
                public void dragCancel() {
                }

                @Override // com.m7.imkfsdk.view.imageviewer.helper.MoorDragCloseHelper.DragCloseListener
                public void dragClose(boolean z) {
                    MoorImagePreviewActivity.this.onBackPressed();
                }

                @Override // com.m7.imkfsdk.view.imageviewer.helper.MoorDragCloseHelper.DragCloseListener
                public void dragStart() {
                }

                @Override // com.m7.imkfsdk.view.imageviewer.helper.MoorDragCloseHelper.DragCloseListener
                public void dragging(float f2) {
                }

                @Override // com.m7.imkfsdk.view.imageviewer.helper.MoorDragCloseHelper.DragCloseListener
                public boolean intercept() {
                    for (Map.Entry<Integer, View> entry : MoorImagePreviewActivity.this.moorImagePreviewAdapter.getImageViewHashMap().entrySet()) {
                        if (entry.getKey().intValue() == moorHackyViewPager.getCurrentItem()) {
                            View value = entry.getValue();
                            if (value instanceof MoorPhotoView) {
                                return MoorImagePreviewActivity.this.scrolling || ((MoorPhotoView) value).getScale() > ((MoorImageInfoBean) MoorImagePreviewActivity.this.imageInfoList.get(moorHackyViewPager.getCurrentItem())).getStartScale();
                            } else if (value instanceof MoorSubsamplingScaleImageView) {
                                return MoorImagePreviewActivity.this.scrolling || ((MoorSubsamplingScaleImageView) value).getScale() > ((MoorImageInfoBean) MoorImagePreviewActivity.this.imageInfoList.get(moorHackyViewPager.getCurrentItem())).getStartScale();
                            }
                        }
                    }
                    return false;
                }
            });
            return;
        }
        onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MoorImagePreview.getInstance().reset();
        MoorBaseHttpUtils.getInstance().cancelTag(this);
        MoorImagePreviewAdapter moorImagePreviewAdapter = this.moorImagePreviewAdapter;
        if (moorImagePreviewAdapter != null) {
            moorImagePreviewAdapter.closePage();
        }
    }
}
