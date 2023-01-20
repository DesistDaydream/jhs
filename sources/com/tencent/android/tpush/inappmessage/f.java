package com.tencent.android.tpush.inappmessage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.tencent.android.tpush.logging.TLogger;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes3.dex */
public class f extends AsyncTask<Void, Void, Bitmap> {
    private String a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Context f6129c;

    /* renamed from: d  reason: collision with root package name */
    private int f6130d;

    public f(String str, View view, Context context, int i2) {
        this.a = str;
        this.b = view;
        this.f6129c = context;
        this.f6130d = i2;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(Void... voidArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            return BitmapFactory.decodeStream(httpURLConnection.getInputStream());
        } catch (Exception e2) {
            TLogger.e("ImageLoadTask", "InAppMsg ImageLoadTask doInBackground :" + e2.toString());
            return null;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        try {
            View view = this.b;
            if (view != null) {
                if (view instanceof ImageView) {
                    if (bitmap != null) {
                        ((ImageView) view).setImageBitmap(bitmap);
                    }
                } else if ((view instanceof RelativeLayout) && bitmap != null) {
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    float f2 = width;
                    Matrix matrix = new Matrix();
                    matrix.postScale(f2 / f2, this.b.getHeight() / height);
                    RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(this.f6129c.getResources(), Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true));
                    create.setAntiAlias(true);
                    create.setCornerRadius(this.f6130d);
                    this.b.setBackground(create);
                }
            }
        } catch (Throwable th) {
            TLogger.e("ImageLoadTask", "InAppMsg ImageLoadTask onPostExecute :" + th.toString());
        }
    }
}
