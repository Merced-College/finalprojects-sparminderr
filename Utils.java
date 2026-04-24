// Parminder Singh
// 4/21/26

public class Utils {

    // recurse algorithm, if n is reached method ends.
    // time complexity O(n)
    public static void countdown(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        countdown(n - 1);
    }

}