import java.util.*;

public class PengelompokanHuruf {

    public static void main(String[] args) {
        String input = "";
        System.out.println(sortCharacters(input));
    }

    public static String sortCharacters(String input) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        List<Character> chars = new ArrayList<>(countMap.keySet());
        chars.sort((a, b) -> {
            if (Character.isUpperCase(a) && Character.isLowerCase(b)) return -1;
            if (Character.isLowerCase(a) && Character.isUpperCase(b)) return 1;
            int compare = countMap.get(b).compareTo(countMap.get(a));
            if (compare != 0) return compare;
            return Character.compare(a, b);
        });

        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (char c : chars) {
            int occurrences = countMap.get(c);
            for (int i = 0; i < occurrences; i++) {
                if (!seen.contains(c)) {
                    result.append(c);
                    seen.add(c);
                }
            }
        }
        return result.toString();
    }

}
