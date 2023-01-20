package com.tencent.qcloud.tuikit.tuichat.component.video.proxy;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes3.dex */
public class IjkMediaPlayerWrapper implements IPlayer {
    private static final String TAG = "IjkMediaPlayerWrapper";
    private Class mMediaPlayerClass;
    private Object mMediaPlayerInstance;

    /* loaded from: classes3.dex */
    public class ListenerHandler implements InvocationHandler {
        private Object mListener;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Boolean bool = Boolean.FALSE;
            Object obj2 = this.mListener;
            if (obj2 == null) {
                return bool;
            }
            if ((obj2 instanceof IPlayer.OnInfoListener) && TextUtils.equals("onInfo", method.getName())) {
                if (((Integer) objArr[1]).intValue() == 10001) {
                    Log.i(IjkMediaPlayerWrapper.TAG, "IMediaPlayer.MEDIA_INFO_VIDEO_ROTATION_CHANGED");
                }
                ((IPlayer.OnInfoListener) this.mListener).onInfo(IjkMediaPlayerWrapper.this, ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            } else if ((this.mListener instanceof IPlayer.OnVideoSizeChangedListener) && TextUtils.equals("onVideoSizeChanged", method.getName())) {
                String str = IjkMediaPlayerWrapper.TAG;
                Log.i(str, "width: " + objArr[1] + " height: " + objArr[2] + " sarNum: " + objArr[3] + " sarDen: " + objArr[4]);
                ((IPlayer.OnVideoSizeChangedListener) this.mListener).onVideoSizeChanged(IjkMediaPlayerWrapper.this, ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            } else if ((this.mListener instanceof IPlayer.OnCompletionListener) && TextUtils.equals("onCompletion", method.getName())) {
                ((IPlayer.OnCompletionListener) this.mListener).onCompletion(IjkMediaPlayerWrapper.this);
            } else if ((this.mListener instanceof IPlayer.OnErrorListener) && TextUtils.equals("onError", method.getName())) {
                ((IPlayer.OnErrorListener) this.mListener).onError(IjkMediaPlayerWrapper.this, ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            } else if ((this.mListener instanceof IPlayer.OnPreparedListener) && TextUtils.equals("onPrepared", method.getName())) {
                ((IPlayer.OnPreparedListener) this.mListener).onPrepared(IjkMediaPlayerWrapper.this);
            }
            return bool;
        }

        private ListenerHandler(Object obj) {
            this.mListener = obj;
        }
    }

    public IjkMediaPlayerWrapper() {
        try {
            Class<?> cls = Class.forName("tv.danmaku.ijk.media.player.IjkMediaPlayer");
            this.mMediaPlayerClass = cls;
            this.mMediaPlayerInstance = cls.newInstance();
        } catch (Exception e2) {
            String str = TAG;
            Log.i(str, "no IjkMediaPlayer: " + e2.getMessage());
        }
    }

    private Object invoke(String str, Object... objArr) {
        Class<?>[] clsArr;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    clsArr = new Class[objArr.length];
                    for (int i2 = 0; i2 < objArr.length; i2++) {
                        clsArr[i2] = objArr[i2].getClass();
                        if (Context.class.isAssignableFrom(clsArr[i2])) {
                            clsArr[i2] = Context.class;
                        } else if (Uri.class.isAssignableFrom(clsArr[i2])) {
                            clsArr[i2] = Uri.class;
                        }
                    }
                    return this.mMediaPlayerClass.getMethod(str, clsArr).invoke(this.mMediaPlayerInstance, objArr);
                }
            } catch (Exception e2) {
                Log.e(TAG, "invoke failed: " + str + " error: " + e2.getCause());
                return null;
            }
        }
        objArr = null;
        clsArr = null;
        return this.mMediaPlayerClass.getMethod(str, clsArr).invoke(this.mMediaPlayerInstance, objArr);
    }

    private void invokeListener(String str, String str2, Object obj) {
        try {
            Class<?> cls = Class.forName("tv.danmaku.ijk.media.player.IMediaPlayer$" + str);
            this.mMediaPlayerClass.getMethod(str2, cls).invoke(this.mMediaPlayerInstance, Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls}, new ListenerHandler(obj)));
        } catch (Exception e2) {
            String str3 = TAG;
            Log.e(str3, str2 + " failed: " + e2.getMessage());
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public int getCurrentPosition() {
        return (int) ((Long) invoke("getCurrentPosition", new Object[0])).longValue();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public int getDuration() {
        return (int) ((Long) invoke("getDuration", new Object[0])).longValue();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public int getVideoHeight() {
        return ((Integer) invoke("getVideoHeight", new Object[0])).intValue();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public int getVideoWidth() {
        return ((Integer) invoke("getVideoWidth", new Object[0])).intValue();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public boolean isPlaying() {
        return ((Boolean) invoke("isPlaying", new Object[0])).booleanValue();
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void pause() {
        invoke("pause", new Object[0]);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void prepareAsync() {
        invoke("prepareAsync", new Object[0]);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void release() {
        invoke("release", new Object[0]);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void seekTo(int i2) {
        try {
            this.mMediaPlayerClass.getMethod("seekTo", Long.TYPE).invoke(this.mMediaPlayerInstance, Integer.valueOf(i2));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setDataSource(Context context, Uri uri) {
        invoke("setDataSource", context, uri);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        invoke("setDisplay", surfaceHolder);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setOnCompletionListener(IPlayer.OnCompletionListener onCompletionListener) {
        invokeListener("OnCompletionListener", "setOnCompletionListener", onCompletionListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setOnErrorListener(IPlayer.OnErrorListener onErrorListener) {
        invokeListener("OnErrorListener", "setOnErrorListener", onErrorListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setOnInfoListener(IPlayer.OnInfoListener onInfoListener) {
        invokeListener("OnInfoListener", "setOnInfoListener", onInfoListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setOnPreparedListener(IPlayer.OnPreparedListener onPreparedListener) {
        invokeListener("OnPreparedListener", "setOnPreparedListener", onPreparedListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setOnSeekCompleteListener(IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        invokeListener("OnSeekCompleteListener", "setOnSeekCompleteListener", onSeekCompleteListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setOnVideoSizeChangedListener(IPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        invokeListener("OnVideoSizeChangedListener", "setOnVideoSizeChangedListener", onVideoSizeChangedListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void setSurface(Surface surface) {
        invoke("setSurface", surface);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void start() {
        invoke(MessageKey.MSG_ACCEPT_TIME_START, new Object[0]);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.component.video.proxy.IPlayer
    public void stop() {
        invoke("stop", new Object[0]);
    }
}
