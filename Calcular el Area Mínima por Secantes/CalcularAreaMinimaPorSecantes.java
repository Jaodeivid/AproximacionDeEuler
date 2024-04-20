/**
 * DESCRIPCION DEL PROBLEMA:
 * HALLAR LA MINIMA ÁREA ENCERRADA POR LOS EJES COORDENADOS DEL 1ER CUADRANTE Y UNA TANGENTE A LA CURVA:
 * Y = 4+3X-X^2 
 */
public class CalcularAreaMinimaPorSecantes{
    public static void main(String[] args){
        System.out.println("Resultados:");
        System.out.println("-----------");
        CalcularAreaMinimaPorSecantes calculadora = new CalcularAreaMinimaPorSecantes();
        calculadora.calcularAreaMinima();
    }
    
     public void calcularAreaMinima(){
        double a = 1; 
        double b = 2; 
        double Err = 1;

        while (Err > 1E-5){
            double q0 = evaluarFuncion(a);
            double q1 = evaluarFuncion(b);
            double h = b - q1 * (b - a) / (q1 - q0);
            a = b;
            b = h;
            Err = Math.abs(evaluarFuncion(h));
        }
        double areaMinima = -1 / 2.0 * Math.pow(4 + a * a, 2) / (3 - 2 * a);
        System.out.printf("Valor de h: %.4f\n", a);
        System.out.printf("Área mínima encerrada: %.4f\n", areaMinima);
    }

    public double evaluarFuncion(double x){
        return -3 * x * x + 6 * x + 4; //-3x^2+6x+4
    }
}