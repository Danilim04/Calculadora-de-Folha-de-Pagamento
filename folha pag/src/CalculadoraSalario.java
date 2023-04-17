public class CalculadoraSalario {
    public static String calcularSalarioHora(double salariobruto, double cargahoraria, String periculosidade, double descanso, String insalubridade, String insalubridade1, double diasdomes, double tarifa, String idavolta,double valordescontoali,double consumido,String valeali,String descontovaleali) {
        double jornada = 0, jornadamensal = 0, salario = 0, salariopericulosidade = 0, salarioinsalubridade = 0, fgts = 0, vale =0,contadescontovaleali=0;
    //calculo jornadasemanal 
        jornadamensal = cargahoraria * diasdomes;
    //calculo fgts
        fgts = salariobruto * 0.08;       
    //calculo vale transporte padrao
        vale = salariobruto * 0.06;
    //calculo carga horaria semanal
        if (cargahoraria < 7) {
            jornada = (cargahoraria * 5) - descanso;
        } else {
            jornada = cargahoraria * 5;
        }
    //calculo salario com periculosidade
        if (periculosidade.equals("sim")) {
            double contapericulosidade = Periculosidade.periculosidade1(periculosidade, salariobruto);
            salario = (salariobruto / jornadamensal) + contapericulosidade / jornadamensal;
            salariopericulosidade = (salariobruto / jornadamensal) + contapericulosidade;

        }
    //calculo salario sem periculosidade
        if (periculosidade.equals("nao")) {
            salario = salariobruto / jornadamensal;
        }
    //calculo salario com insalubridade
        if (insalubridade.equals("sim")) {
            double containsalubridade = Calcularinsalubridade.calcularinsalubrida(insalubridade, insalubridade1);
            salario = (salariobruto / jornadamensal) + containsalubridade / jornadamensal;
            salarioinsalubridade = salariobruto + containsalubridade;
        }            
        
    //calculo salario liquido
        double inss = Calcinss.calcularInss(salariobruto, idavolta);
        double irrf = Calcirrf.calcularIRRF(salariobruto, inss);
        double salarioliquido = salariobruto - inss - irrf - contadescontovaleali;
    
    //calculo do salario liquido caso tenha vale transporte           
        double valetransporte = Calculovaletransp.calculovaletransp(salariobruto, tarifa, idavolta, diasdomes); 
        if (valetransporte > vale){
        salarioliquido = salariobruto - inss - irrf - vale - contadescontovaleali;
        } 
         
    //calculo vale alimentacao caso tenha desconto no salario
        if (valeali.equals("sim")){
            if(descontovaleali.equals("sim")){
             contadescontovaleali = (valordescontoali/100) * salariobruto ;
            }
        }
    //exibição de resultado           
        
        String resultado = "Salário por hora: " + salario + "\n";
        resultado += "Salario Bruto:" + salariobruto + "\n";
        resultado += "Jornada semanal: " + jornada + "\n";
        resultado += "Jornada mensal: " + jornadamensal + "\n";
        resultado += "O valor do FGTS Mensal: " + fgts + "\n";
        resultado += "O valor Do Inss" + inss + "\n";
        resultado += "O valor IRRF" + irrf + "\n";
        resultado += "Valor do Salario liquido" + salarioliquido + "\n";
        if (periculosidade.equals("sim")) {
            resultado += "O salario com a periculosidade: " + salariopericulosidade + "\n";
        }
        if (insalubridade.equals("sim")) {
            resultado += "O salario com a insalubridade: " + salarioinsalubridade + "\n";
        }
        
        
        return resultado;
    }
}
