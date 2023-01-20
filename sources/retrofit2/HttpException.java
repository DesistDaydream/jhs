package retrofit2;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import java.util.Objects;
import javax.annotation.Nullable;
import l.r;

/* loaded from: classes4.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient r<?> response;

    public HttpException(r<?> rVar) {
        super(getMessage(rVar));
        this.code = rVar.b();
        this.message = rVar.h();
        this.response = rVar;
    }

    private static String getMessage(r<?> rVar) {
        Objects.requireNonNull(rVar, "response == null");
        return "HTTP " + rVar.b() + ExpandableTextView.N + rVar.h();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public r<?> response() {
        return this.response;
    }
}
