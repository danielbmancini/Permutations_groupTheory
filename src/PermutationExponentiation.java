import java.util.ArrayList;
import java.util.Scanner;

public class PermutationExponentiation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("For S_n, insert n, or -n for a n-cycle:");
        int n = scanner.nextInt();
        ArrayList<Integer> sigma;
        if(n < 0)
            sigma = returnNCycle(-n);
        else
        sigma = ProcessPermutationEntriesInput.process(n);


        Permutation perm = new Permutation(sigma);
        Permutation perm2 = new Permutation(sigma);


        int exponent = 1;
        do {
            exponent++;
            perm2.multiplyWith(perm);
            System.out.printf("%nσ^%d = %s", exponent, perm2.toCycleString());
        } while (!perm2.isIdentity());

    }
    static ArrayList<Integer> returnNCycle(int n){
        ArrayList<Integer> bigCycle = new ArrayList<>();
        for (int i = 0; i < n; i++)
            bigCycle.add((i + 1) % n + 1);
        return bigCycle;
    }
}
