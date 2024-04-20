/**
 * Tenemos una longitud de un (1) metro para conformar un trapecio: Tales que: y+ x/2 + x/2 + y = 1 m. 
 * La suma de los lados del trapecio y un ángulo entre las paredes laterales y la horizontal.
 */
public class CalculadorAreaMaximaTrapecio{
    public static void main(String[] args){
        CalculadorAreaMaximaTrapecio solucion = new CalculadorAreaMaximaTrapecio();
        solucion.calcularAreaMaximaTrapecio();
    }
    
    public void calcularAreaMaximaTrapecio(){
        double paso = 0.01;
        double maxArea = 0;
        double mejorX = 0;
        double mejorY = 0;
        double mejorAngulo = 0;

        for (double x = paso; x <= 0.5; x += paso){
            for (double y = paso; y <= 0.5; y += paso) {
                for (double angulo = paso; angulo <= Math.PI / 2; angulo += paso) {
                    if (Math.abs(y + x/2 + x/2 + y - 1) < 1e-5) {
                        double area = calcularAreaTrapecio(x, y, angulo);
                        if (area > maxArea) {
                            maxArea = area;
                            mejorX = x;
                            mejorY = y;
                            mejorAngulo = angulo;
                        }
                    }
                }
            }
        }
        
        System.out.println("Resultados:");
        System.out.println("-----------");
        System.out.printf("Longitud del lado del trapecio (x): %.4f metros\n", mejorX);
        System.out.printf("Altura del trapecio (y): %.4f metros\n", mejorY);
        System.out.printf("Ángulo entre las paredes laterales y la horizontal: %.4f radianes\n", mejorAngulo);
        System.out.printf("Área máxima del trapecio: %.4f metros cuadrados\n", maxArea);
    }

    public double calcularAreaTrapecio(double x, double y, double angulo) {
        double baseMenor = x;
        double baseMayor = x;
        double altura = y;
        double area = (baseMenor + baseMayor) * altura / 2;
        return area;
    }
}