package com.tencent.qcloud.tuikit.tuichat.util;

import android.content.Context;
import android.hardware.Camera;
import android.view.WindowManager;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class CameraParamUtil {
    private static final String TAG = "CameraParamUtil";
    private static CameraParamUtil cameraParamUtil;
    private CameraSizeComparator sizeComparator = new CameraSizeComparator();

    /* loaded from: classes3.dex */
    public class CameraSizeComparator implements Comparator<Camera.Size> {
        private CameraSizeComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            int i2 = size.width;
            int i3 = size2.width;
            if (i2 == i3) {
                return 0;
            }
            return i2 > i3 ? 1 : -1;
        }
    }

    private CameraParamUtil() {
    }

    private boolean equalRate(Camera.Size size, float f2) {
        return ((double) Math.abs((((float) size.width) / ((float) size.height)) - f2)) <= 0.2d;
    }

    private Camera.Size getBestSize(List<Camera.Size> list, float f2) {
        int i2 = 0;
        float f3 = 100.0f;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Camera.Size size = list.get(i3);
            float f4 = f2 - (size.width / size.height);
            if (Math.abs(f4) < f3) {
                f3 = Math.abs(f4);
                i2 = i3;
            }
        }
        return list.get(i2);
    }

    public static CameraParamUtil getInstance() {
        CameraParamUtil cameraParamUtil2 = cameraParamUtil;
        if (cameraParamUtil2 == null) {
            CameraParamUtil cameraParamUtil3 = new CameraParamUtil();
            cameraParamUtil = cameraParamUtil3;
            return cameraParamUtil3;
        }
        return cameraParamUtil2;
    }

    public int getCameraDisplayOrientation(Context context, int i2) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        int i3 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i3 = 90;
            } else if (rotation == 2) {
                i3 = 180;
            } else if (rotation == 3) {
                i3 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i3) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i3) + 360) % 360;
    }

    public Camera.Size getPictureSize(List<Camera.Size> list, int i2, float f2) {
        Collections.sort(list, this.sizeComparator);
        Iterator<Camera.Size> it = list.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            if (next.width > i2 && equalRate(next, f2)) {
                String str = TAG;
                TUIChatLog.i(str, "MakeSure Picture :w = " + next.width + " h = " + next.height);
                break;
            }
            i3++;
        }
        if (i3 == list.size()) {
            return getBestSize(list, f2);
        }
        return list.get(i3);
    }

    public Camera.Size getPreviewSize(List<Camera.Size> list, int i2, float f2) {
        Collections.sort(list, this.sizeComparator);
        Iterator<Camera.Size> it = list.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Camera.Size next = it.next();
            if (next.width > i2 && equalRate(next, f2)) {
                String str = TAG;
                TUIChatLog.i(str, "MakeSure Preview :w = " + next.width + " h = " + next.height);
                break;
            }
            i3++;
        }
        if (i3 == list.size()) {
            return getBestSize(list, f2);
        }
        return list.get(i3);
    }

    public boolean isSupportedFocusMode(List<String> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (str.equals(list.get(i2))) {
                String str2 = TAG;
                TUIChatLog.i(str2, "FocusMode supported " + str);
                return true;
            }
        }
        String str3 = TAG;
        TUIChatLog.i(str3, "FocusMode not supported " + str);
        return false;
    }

    public boolean isSupportedPictureFormats(List<Integer> list, int i2) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i2 == list.get(i3).intValue()) {
                String str = TAG;
                TUIChatLog.i(str, "Formats supported " + i2);
                return true;
            }
        }
        String str2 = TAG;
        TUIChatLog.i(str2, "Formats not supported " + i2);
        return false;
    }
}
