public class CalculadoraSalario {
    public static String calcularSalarioHora(double salariobruto, double cargahoraria, String periculosidade, double descanso, String insalubridade, String insalubridade1, double diasdomes, double tarifa, String idavolta,double valordescontoali,double consumido,String valeali,String descontovaleali, String clt) {
        double jornada = 0, jornadamensal = 0, salario = 0, salariopericulosidade = 0, salarioinsalubridade = 0, fgts = 0, vale =0,contadescontovaleali=0;
    //calculo jornadasemanal 
        jornadamensal = cargahoraria * diasdomes;
    //calculo fgts
     if (clt.equals("sim")){fgts = salariobruto * 0.08;}                  
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
     double irrf = Calcirrf.calcularIRRF(salariobruto, inss, clt);
     double salarioliquido = salariobruto - inss - irrf - contadescontovaleali;

     //calculo do salario liquido se houver insalubridade
    if(insalubridade.equals("sim")){
        salarioliquido = salarioinsalubridade - inss - irrf - contadescontovaleali;
    }

    //calculo do salario liquido se houver periculosidade    
    if (periculosidade.equals("sim")){
        salarioliquido = salariopericulosidade - inss - irrf - contadescontovaleali;
    }
    
    //calculo do salario liquido caso tenha vale transporte           
        //double valetransporte = Calculovaletransp.calculovaletransp(salariobruto, tarifa, idavolta, diasdomes,clt); 
        //if (valetransporte > vale){
       // salarioliquido = salariobruto - inss - irrf - vale - contadescontovaleali;
       // } 
         
    //calculo vale alimentacao caso tenha desconto no salario
        if (valeali.equals("sim")){
            if(descontovaleali.equals("sim")){
             contadescontovaleali = (valordescontoali/100) * salariobruto ;
            }
        }
        double valorvaleali = calcvaleali.calcvaleali(diasdomes, consumido, descontovaleali);
    
    //exibição de resultado           
        
        String resultado = "Salário por hora: " + salario + "\n";
        resultado += "Salario Bruto: " + salariobruto + "\n";
        resultado += "Jornada semanal: " + jornada + "\n";
        resultado += "Jornada mensal: " + jornadamensal + "\n";
        resultado += "O valor do FGTS Mensal: " + fgts + "\n";
        if (fgts==0){resultado += "O trabalhador não é clt, logo nao possui FGTS" + "\n";}        
        resultado += "O valor IRRF: " + irrf + "\n";
        if (irrf==0){resultado += "O trabalhador não é clt, logo nao possui IRRF" + "\n";}
        resultado += "Valor do Salario liquido: " + salarioliquido + "\n";
        resultado += "Valor do Vale Alimentação: " + valorvaleali + "\n";
        if (valorvaleali==0){resultado += "O trabalhador não é clt, logo nao possui Vale alimentação" + "\n";}
        resultado += "Valor do Vale transporte: " + vale + "\n";
        if (vale==0){resultado += "O trabalhador não possui Vale Transporte" + "\n";}
        if (periculosidade.equals("nao")){resultado += "O trabalhador Não posui Periculosidade" + "\n";}
        if (periculosidade.equals("sim")) {
            resultado += "O salario com a periculosidade: " + salariopericulosidade + "\n";
        }
        if (clt.equals("nao")){resultado += "O trabalhador Não posui insalubridade, pois não é CLT" + "\n";}
        if (insalubridade.equals("nao")){resultado += "O trabalhador Não posui insalubridade" + "\n";}
        if (insalubridade.equals("sim")) {
            resultado += "O salario com a insalubridade: " + salarioinsalubridade + "\n";
        }
        
        
        return resultado;
    }
}
