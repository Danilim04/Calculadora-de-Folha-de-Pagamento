public class Calculovaletransp {
    public static double calculovaletransp(double salariobruto,double tarifa,String idavolta, double diasdomes, String clt ){
        double conta=0;
        double valoraserpago=0;
        if (clt.equals("sim")){if (idavolta.equals("nao")){
            conta = salariobruto * 0.06;
            valoraserpago =  tarifa * diasdomes;
        }
        if (idavolta.equals("sim")){
            conta = salariobruto * 0.06;
            valoraserpago = (tarifa*2) * diasdomes;
        }}
                        
        return valoraserpago;
    }
}
