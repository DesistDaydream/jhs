package com.bytedance.msdk.adapter.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    private SoftReference<ImageView> a;

    public DownloadImageTask(ImageView imageView) {
        this.a = new SoftReference<>(imageView);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        if (str == null) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap == null) {
            Log.d("download Image", "Error download Image fail...");
        } else if (this.a.get() != null) {
            this.a.get().setImageBitmap(bitmap);
        }
    }
}
