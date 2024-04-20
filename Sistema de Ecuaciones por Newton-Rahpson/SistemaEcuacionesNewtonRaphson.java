/**
 * RESOLVER EL SIGGUIENTE SISTEMA DE ECUACIONES POR EL METODO NEWTON-RAPHSON
 * f1:=3*x-cos(y*z)-0.5 = 0;
 * f2:=x*x-81*(y+0.1)*81*(y+0.1)+sin(z)+1.06 = 0
 * f3:=exp(-x*y)+20*z+((10*pi-3)/3) = 0;
 */
public class SistemaEcuacionesNewtonRaphson{
    public static void main(String[] args){
        SistemaEcuacionesNewtonRaphson solucion = new SistemaEcuacionesNewtonRaphson();
        solucion.resolverSistemaEcuaciones();
    }

    public double f1(double x, double y, double z){
        return 3 * x - Math.cos(y * z) - 0.5;
    }

    public double f2(double x, double y, double z){
        return x * x - 81 * (y + 0.1) * (y + 0.1) + Math.sin(z) + 1.06;
    }

    public double f3(double x, double y, double z){
        return Math.exp(-x * y) + 20 * z + ((10 * Math.PI - 3) / 3);
    }

    public void resolverSistemaEcuaciones(){
        double x = 1;
        double y = 1;
        double z = 1;
        double dx = 0.01;
        double dy = 0.01;
        double dz = 0.01;

        for (int n = 1; n <= 50; n++){
            double h = x + dx;
            double k = y + dy;
            double l = z + dz;

            double f1x = f1(x, y, z);
            double f2x = f2(x, y, z);
            double f3x = f3(x, y, z);

            double J11 = (f1(h, y, z) - f1x) / dx;
            double J12 = (f1(x, k, z) - f1x) / dy;
            double J13 = (f1(x, y, l) - f1x) / dz;
            
            double J21 = (f2(h, y, z) - f2x) / dx;
            double J22 = (f2(x, k, z) - f2x) / dy;
            double J23 = (f2(x, y, l) - f2x) / dz;
            
            double J31 = (f3(h, y, z) - f3x) / dx;
            double J32 = (f3(x, k, z) - f3x) / dy;
            double J33 = (f3(x, y, l) - f3x) / dz;

            double detJ = J11 * (J22 * J33 - J23 * J32) - J12 * (J21 * J33 - J23 * J31) + J13 * (J21 * J32 - J22 * J31);

            double ds1 = ((J22 * J33 - J23 * J32) * (-f1x) - (J12 * J33 - J13 * J32) * (-f2x) + (J12 * J23 - J13 * J22) * (-f3x)) / detJ;
            double ds2 = ((-J21 * J33 + J23 * J31) * (-f1x) - (-J11 * J33 + J13 * J31) * (-f2x) + (-J11 * J23 + J13 * J21) * (-f3x)) / detJ;
            double ds3 = ((J21 * J32 - J22 * J31) * (-f1x) - (J11 * J32 - J12 * J31) * (-f2x) + (J11 * J22 - J12 * J21) * (-f3x)) / detJ;

            x += ds1;
            y += ds2;
            z += ds3;

            if (Math.abs(f1(x, y, z)) < 1E-5 && Math.abs(f2(x, y, z)) < 1E-5 && Math.abs(f3(x, y, z)) < 1E-5){
                break;
            }
        }
        System.out.println("Resultados del sistema de ecuaciones:");
        System.out.println("-------------------------------------");
        System.out.println("El valor de x = " + String.format("%.6f", x));
        System.out.println("El valor de y = " + String.format("%.6f", y));
        System.out.println("El valor de z = " + String.format("%.6f", z));
    }
}
