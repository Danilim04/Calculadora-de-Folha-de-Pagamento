public class calcvaleali{
    public static double calcvaleali(double diasdomes, double consumido,String valeali){
        double resultadovaleali = 0;
        if (valeali.equals("sim")){
            resultadovaleali =  diasdomes * consumido;
            return resultadovaleali;
        }
        return 0;
    }
}