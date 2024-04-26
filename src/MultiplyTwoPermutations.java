import java.util.Scanner;
public class MultiplyTwoPermutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("For S_n, insert n:");
        int n = scanner.nextInt();
        Permutation perm1 = new Permutation(ProcessPermutationEntriesInput.process(n));

        Permutation perm2 = new Permutation(ProcessPermutationEntriesInput.process(n));

        perm1.multiplyWith(perm2);
        System.out.printf("%n perm1*perm2 = %s%n = %s",perm1.toCycleString(),perm1);

    }
}
