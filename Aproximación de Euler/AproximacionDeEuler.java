/**
 * Usar la aproximacion de euler con xo = 0, yo = 1, xm = 1, h = 0.001 y la función: dy/dx = -x.
 */
public class AproximacionDeEuler{
    private double xo;
    private double yo;
    private double xm;
    private double h;
    
    public AproximacionDeEuler(double xo, double yo, double xm, double h){
        this.xo = xo;
        this.yo = yo;
        this.xm = xm;
        this.h = h;
    }

    public void calcular(){
        double m = (xm - xo) / h;
        int n = (int) m;
        System.out.println("y(0) = " + yo);
        for (int i = 1; i <= n; i++){
            yo = yo + h * (-yo);
            System.out.println("y(" + i + ") = " + yo);
        }
        double error = Math.exp(-xm) - yo;
        System.out.println("Error: " + error);
    }

    public static void main(String[] args){
        System.out.println("METODO APROXIMACION DE EULER");
        double xo = 0;
        System.out.print("x0: "+ xo);
        double yo = 1;
        System.out.print("y0: "+ yo);
        double xm = 1;
        System.out.print("xm: "+ xm);
        double h = 0.001;
        System.out.print("h: "+ h);
        AproximacionDeEuler euler = new AproximacionDeEuler(xo, yo, xm, h);
        euler.calcular();
    }
}

