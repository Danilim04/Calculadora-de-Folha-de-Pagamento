public class Calcularinsalubridade {
    public static double calcularinsalubrida(String insalubridade, String insalubridade1) {
        double conta = 0;
        
        if (insalubridade.equals("sim")) {
            if (insalubridade1.equals("alto")) {
                conta = 1380.60 * 0.4;
            } else if (insalubridade1.equals("médio")) {
                conta = 1380.60 * 0.2;
            } else if (insalubridade1.equals("mínimo")) {
                conta = 1380.60 * 0.1;
            }    
        }
                           
        return conta;
    }
}
