import Presentacion.CtrlPresentacion;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        CtrlPresentacion CP = new CtrlPresentacion();
                    }
                }
        );
    }

}
