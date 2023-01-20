package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.moor.imkf.YKFConstants;

/* loaded from: classes2.dex */
public final class ConnectionResult implements Parcelable {
    public static final int API_UNAVAILABLE = 1000;
    public static final int BINDFAIL_RESOLUTION_BACKGROUND = 7;
    public static final int BINDFAIL_RESOLUTION_REQUIRED = 6;
    public static final int CANCELED = 13;
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new a();
    public static final int DEVELOPER_ERROR = 10;
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 9002;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 9000;
    public static final int RESOLUTION_REQUIRED = 9001;
    public static final int RESTRICTED_PROFILE = 9003;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UNSUPPORTED = 21;
    public static final int SERVICE_UPDATING = 9004;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 9005;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    private int apiVersion;
    private int connectionErrorCode;
    private String connectionErrorMessage;
    private PendingIntent pendingIntent;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<ConnectionResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConnectionResult createFromParcel(Parcel parcel) {
            return new ConnectionResult(parcel, (a) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConnectionResult[] newArray(int i2) {
            return new ConnectionResult[i2];
        }
    }

    public /* synthetic */ ConnectionResult(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static String getErrorString(int i2) {
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 13) {
                                if (i2 != 14) {
                                    if (i2 != 19) {
                                        if (i2 != 21) {
                                            switch (i2) {
                                                case 6:
                                                    return "RESOLUTION_REQUIRED";
                                                case 7:
                                                    return "NETWORK_ERROR";
                                                case 8:
                                                    return "INTERNAL_ERROR";
                                                case 9:
                                                    return "SERVICE_INVALID";
                                                case 10:
                                                    return "DEVELOPER_ERROR";
                                                case 11:
                                                    return "LICENSE_CHECK_FAILED";
                                                default:
                                                    return "UNKNOWN_ERROR_CODE(" + i2 + ")";
                                            }
                                        }
                                        return "API_VERSION_UPDATE_REQUIRED";
                                    }
                                    return "SERVICE_MISSING_PERMISSION";
                                }
                                return YKFConstants.TIMEOUT;
                            }
                            return "CANCELED";
                        }
                        return "SERVICE_DISABLED";
                    }
                    return "SERVICE_VERSION_UPDATE_REQUIRED";
                }
                return "SERVICE_MISSING";
            }
            return "SUCCESS";
        }
        return GrsBaseInfo.CountryCodeSource.UNKNOWN;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if ((obj instanceof ConnectionResult) && this.apiVersion == ((ConnectionResult) obj).apiVersion && this.connectionErrorCode == ((ConnectionResult) obj).connectionErrorCode && this.connectionErrorMessage.equals(((ConnectionResult) obj).connectionErrorMessage)) {
                if (this.pendingIntent.equals(((ConnectionResult) obj).pendingIntent)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public int getErrorCode() {
        return this.connectionErrorCode;
    }

    public final String getErrorMessage() {
        return this.connectionErrorMessage;
    }

    public final PendingIntent getResolution() {
        return this.pendingIntent;
    }

    public final boolean hasResolution() {
        return HuaweiApiAvailability.getInstance().isUserResolvableError(this.connectionErrorCode, this.pendingIntent);
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.apiVersion), Long.valueOf(getErrorCode()), getErrorMessage(), this.pendingIntent);
    }

    public final boolean isSuccess() {
        return this.connectionErrorCode == 0;
    }

    public final void startResolutionForResult(Activity activity, int i2) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            HuaweiApiAvailability.getInstance().resolveError(activity, this.connectionErrorCode, i2, this.pendingIntent);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.apiVersion);
        parcel.writeInt(this.connectionErrorCode);
        parcel.writeString(this.connectionErrorMessage);
        this.pendingIntent.writeToParcel(parcel, i2);
    }

    public ConnectionResult(int i2, int i3, PendingIntent pendingIntent, String str) {
        this.apiVersion = 1;
        this.pendingIntent = null;
        this.connectionErrorMessage = null;
        this.apiVersion = i2;
        this.connectionErrorCode = i3;
        this.pendingIntent = pendingIntent;
        this.connectionErrorMessage = str;
    }

    public ConnectionResult(int i2) {
        this(i2, (PendingIntent) null);
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent) {
        this(i2, pendingIntent, null);
    }

    public ConnectionResult(int i2, PendingIntent pendingIntent, String str) {
        this(1, i2, pendingIntent, str);
    }

    private ConnectionResult(Parcel parcel) {
        this.apiVersion = 1;
        this.pendingIntent = null;
        this.connectionErrorMessage = null;
        this.apiVersion = parcel.readInt();
        this.connectionErrorCode = parcel.readInt();
        this.connectionErrorMessage = parcel.readString();
        Parcelable parcelable = (Parcelable) PendingIntent.CREATOR.createFromParcel(parcel);
        if (parcelable != null) {
            this.pendingIntent = (PendingIntent) parcelable;
        }
    }
}
