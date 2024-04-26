import java.util.Arrays;
public class Permutations {

    public static void perm1(String s) {
        perm1("",s);
    }

    private static void perm1(String prefix,String s) {
        int n = s.length();
        if (n == 0) System.out.println(prefix);
        else {
            for(int i = 0; i < n; i++)
                perm1(prefix + s.charAt(i),s.substring(0,i) + s.substring(i+1,n));
        }
    }
    public static void perm2(String s) {
        int n = s.length();
        char[] a = new char[n];
        for(int i = 0; i < n; i++)
            a[i] = (char) s.codePointAt(i);
        perm2(a,n);
    }
    private static void perm2(char[] a, int n) {
        if (n == 1) {
            System.out.println(Arrays.toString(a));
            return;
        }
        for(int i = 0; i < n; i++) {
            swap(a,i,n-1);
            perm2(a,n-1);
            swap(a,i,n-1);
        }
    }
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        alphabet = alphabet + alphabet.toUpperCase();
        String elements = alphabet.substring(0,n);
        perm2(elements);
    }
}
