package com.j256.ormlite.cipher.android.apptools;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.j256.ormlite.cipher.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;

/* loaded from: classes2.dex */
public abstract class OrmLiteBaseActivity<H extends OrmLiteSqliteOpenHelper> extends Activity {
    private static Logger logger = LoggerFactory.getLogger(OrmLiteBaseActivity.class);
    private volatile boolean created = false;
    private volatile boolean destroyed = false;
    private volatile H helper;

    public ConnectionSource getConnectionSource() {
        return getHelper().getConnectionSource();
    }

    public H getHelper() {
        if (this.helper == null) {
            if (this.created) {
                if (this.destroyed) {
                    throw new IllegalStateException("A call to onDestroy has already been made and the helper cannot be used after that point");
                }
                throw new IllegalStateException("Helper is null for some unknown reason");
            }
            throw new IllegalStateException("A call has not been made to onCreate() yet so the helper is null");
        }
        return this.helper;
    }

    public H getHelperInternal(Context context) {
        H h2 = (H) OpenHelperManager.getHelper(context);
        logger.trace("{}: got new helper {} from OpenHelperManager", this, h2);
        return h2;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        if (this.helper == null) {
            this.helper = getHelperInternal(this);
            this.created = true;
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        releaseHelper(this.helper);
        this.destroyed = true;
    }

    public void releaseHelper(H h2) {
        OpenHelperManager.releaseHelper();
        logger.trace("{}: helper {} was released, set to null", this, h2);
        this.helper = null;
    }

    public String toString() {
        return getClass().getSimpleName() + TIMMentionEditText.TIM_MENTION_TAG + Integer.toHexString(super.hashCode());
    }
}
