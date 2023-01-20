package e.j.a.b.c.x;

@e.j.a.b.c.m.a
@d0
/* loaded from: classes2.dex */
public class u {
    private u() {
    }

    @e.j.a.b.c.m.a
    public static long a(String str) {
        if (str.length() <= 16) {
            if (str.length() == 16) {
                return (Long.parseLong(str.substring(0, 8), 16) << 32) | Long.parseLong(str.substring(8), 16);
            }
            return Long.parseLong(str, 16);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37);
        sb.append("Invalid input: ");
        sb.append(str);
        sb.append(" exceeds 16 characters");
        throw new NumberFormatException(sb.toString());
    }
}
