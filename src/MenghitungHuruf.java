import java.util.*;

public class MenghitungHuruf {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("Masukkan kalimat: ");
            String kalimat = input.nextLine();

            Map<Character, Integer> hurufCount = new HashMap<>();
            for (char ch : kalimat.toCharArray()) {
                if (Character.isLetter(ch)) {
                    ch = Character.toLowerCase(ch);
                    hurufCount.put(ch, hurufCount.getOrDefault(ch, 0) + 1);
                }
            }

            List<Map.Entry<Character, Integer>> sortedHuruf = new ArrayList<>(hurufCount.entrySet());
            sortedHuruf.sort((a, b) -> {
                int cmp = b.getValue().compareTo(a.getValue());
                if (cmp == 0) {
                    return a.getKey().compareTo(b.getKey());
                }
                return cmp;
            });

            System.out.println("Hasil pengelompokan dan pengurutan huruf:");
            for (Map.Entry<Character, Integer> entry : sortedHuruf) {
                char huruf = entry.getKey();
                int jumlah = entry.getValue();
                System.out.println(huruf + " = " + jumlah);
            }
        }


}
