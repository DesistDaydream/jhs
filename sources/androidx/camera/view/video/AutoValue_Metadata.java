package androidx.camera.view.video;

import android.location.Location;
import androidx.annotation.Nullable;
import androidx.camera.view.video.Metadata;

/* loaded from: classes.dex */
public final class AutoValue_Metadata extends Metadata {
    private final Location location;

    /* loaded from: classes.dex */
    public static final class Builder extends Metadata.Builder {
        private Location location;

        @Override // androidx.camera.view.video.Metadata.Builder
        public Metadata build() {
            return new AutoValue_Metadata(this.location);
        }

        @Override // androidx.camera.view.video.Metadata.Builder
        public Metadata.Builder setLocation(@Nullable Location location) {
            this.location = location;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Metadata) {
            Location location = this.location;
            Location location2 = ((Metadata) obj).getLocation();
            return location == null ? location2 == null : location.equals(location2);
        }
        return false;
    }

    @Override // androidx.camera.view.video.Metadata
    @Nullable
    public Location getLocation() {
        return this.location;
    }

    public int hashCode() {
        Location location = this.location;
        return (location == null ? 0 : location.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "Metadata{location=" + this.location + "}";
    }

    private AutoValue_Metadata(@Nullable Location location) {
        this.location = location;
    }
}
