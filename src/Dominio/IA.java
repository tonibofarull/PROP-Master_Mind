package Dominio;

import java.util.*;

public abstract class IA {

    protected class Pair {
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

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
    }

    protected Pair calcularNB(String a, String b) {
        Pair res = new Pair(0,0);
        ArrayList<Boolean> vis_a = new ArrayList<>(Arrays.asList(false,false,false,false));
        ArrayList<Boolean> vis_b = new ArrayList<>(Arrays.asList(false,false,false,false));
        for (int i = 0; i < 4; ++i) {
            if (a.charAt(i) == b.charAt(i)) {
                vis_a.set(i,true);
                vis_b.set(i,true);
                res.setX(res.getX()+1);
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                if (a.charAt(i) == b.charAt(j) && !vis_a.get(i) && !vis_b.get(j)) {
                    vis_a.set(i,true);
                    vis_b.set(j,true);
                    res.setY(res.getY()+1);
                }
            }
        }
        return res;
    }

    public IA() {}

}
