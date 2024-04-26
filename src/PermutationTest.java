import java.util.ArrayList;

public class PermutationTest {
    public static void main(String[] args) {
        ArrayList<Integer> bigCycle = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            bigCycle.add((i + 1) % 10 + 1);

        Permutation permutation = new Permutation(bigCycle);
    }
}
