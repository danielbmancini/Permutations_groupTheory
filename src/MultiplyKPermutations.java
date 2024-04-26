import java.util.Scanner;

public class MultiplyKPermutations { //left to right
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("For S_n, insert n:");
        int n = scanner.nextInt();
        System.out.println("Insert k:");
        int k = scanner.nextInt();

        Permutation perm = new Permutation(ProcessPermutationEntriesInput.process(n));
        for (int i = 1; i < k; i++)
            perm.multiplyWith(new Permutation(ProcessPermutationEntriesInput.process(n)));

        System.out.printf("%n ∏(i ∈ I) Permutation_i = %s%n = %s",perm.toCycleString(),perm);

    }
}
