import java.util.*;

public class IA_CB {
    private TreeSet<String> S;
    private TreeSet<String> UnusedCodes;
    private boolean first_turn;

    private class Pair {
        private int x;
        private int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
           this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Pair aux = (Pair) obj;
            return this.x == aux.x && this.y == aux.y;
        }
    }

    private void initializePossibilities(int pos, int num) {
        if (pos == 4) {
            S.add(Integer.toString(num));
            UnusedCodes.add(Integer.toString(num));
            return;
        }
        for (int i = 1; i <= 6; ++i) initializePossibilities(pos+1,num*10+i);
    }

    private Pair calcularNB(String a, String b) {
        Pair res = new Pair(0,0);
        boolean[] vis_a = new boolean[a.length()];
        boolean[] vis_b = new boolean[b.length()];
        for (int i = 0; i < 4; ++i) {
            if (a.charAt(i) == b.charAt(i)) {
                vis_a[i] = true;
                vis_b[i] = true;
                res.setX(res.getX()+1);
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (a.charAt(i) == b.charAt(j) && !vis_a[i] && !vis_b[j]) {
                    vis_a[i] = true;
                    vis_b[j] = true;
                    res.setY(res.getY()+1);
                }
            }
        }
        return res;
    }

    private String minimax() {
        TreeSet<String> guesses = new TreeSet<>();
        int max = Integer.MIN_VALUE;
        Iterator<String> it_g = UnusedCodes.iterator();
        for (String g: UnusedCodes) {
            Map<Pair,Integer> Z_g = new HashMap<>();
            Iterator<String> it_s = S.iterator();
            for (String s : S) {
                Pair val = calcularNB(g,s);
                if (Z_g.containsKey(val)) {
                    Integer int_aux = Z_g.get(val);
                    Z_g.replace(val, int_aux+1);
                }
                else Z_g.put(val, 1);
            }
            int min = Integer.MAX_VALUE;
            Collection<Integer> col = Z_g.values();
            Iterator<Integer> it_col = col.iterator();
            for (Integer valit : col) {
                if (min > S.size()-valit) min = S.size()-valit;
            }
            if (max == min) guesses.add(g);
            else if (max < min) {
                guesses.clear();
                max = min;
                guesses.add(g);
            }
        }
        for (String r : guesses) {
            if (S.contains(r)) return r;
        }
        return guesses.first();
    }

    private String nextGuess() {
        if (first_turn) { // Comprobar que no se ha jugado nada aun
            first_turn = false;
            String r = "1122";
            S.remove(r);
            UnusedCodes.remove(r);
            return r;
        }
        String r = minimax();
        S.remove(r);
        UnusedCodes.remove(r);
        return r;
    }

    private void actualizateS(String lg, Pair lpair) {
        TreeSet<String> Saux = (TreeSet) S.clone();
        Iterator<String> it = Saux.iterator();
        for (String a : Saux) {
            Pair p = calcularNB(a,lg);
            if (!p.equals(lpair)) S.remove(a);
        }
    }

    private IA_CB() {
        S = new TreeSet<>();
        UnusedCodes = new TreeSet<>();
        first_turn = true;
        initializePossibilities(0,0);

        System.out.print("Escribe el codigo secreto: ");
        String solution;
        Scanner scan = new Scanner(System.in);
        solution = scan.next();
        scan.close();


        String a = nextGuess();
        System.out.println(a);
        while (!a.equals(solution)) {
            Pair p = calcularNB(a,solution);
            actualizateS(a,p);
            a = nextGuess();
            System.out.println(a);
        }

    }
    public static void main(String[] argv) {
        IA_CB ia = new IA_CB();
    }
}
