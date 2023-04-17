public class Calcinss {
    public static double calcularInss(double salarioBruto, String clt) {
        String valorinss;
        if (clt.equals("sim")){
            double inss = 0.0;
        
            if (salarioBruto <= 1302.00) {
                inss = salarioBruto * 0.075;
            }
            else if (salarioBruto <= 2571.29) {
                inss = salarioBruto * 0.09;
            }
            else if (salarioBruto <= 3856.94) {
                inss = salarioBruto * 0.12;
            }
            else if (salarioBruto <= 7507.49) {
                inss = salarioBruto * 0.14;
            }
            else {
                inss = 7507.49 * 0.14; // o valor máximo para o cálculo do INSS é R$ 7507,49
            } 
            
            return inss;  
        }
        return 0;                              
}
}