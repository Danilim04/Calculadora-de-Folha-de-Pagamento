import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String valeali = "";
        double valordescontoali = 0;
        double consumido = 0;
        String descontovaleali = "";
        String vale = "";
        String idavolta = "";
        double tarifa = 0;
        float descanso = 0;
        String descanso1 = "";
        String insalubridade = "";
        String insalubridade1 = "";

        System.out.println("Digite o Nome do Trabalhador");
        String nome = sc.nextLine();
        System.out.println("Digite a Data de Admissão");
        String data = sc.nextLine();
        System.out.println("Digite O cargo do trabalhador");
        String cargo = sc.next();
        System.out.println("O trabalhador é CLT?");
        String clt = sc.next();
        System.out.println("Digite o salario Bruto");
        double salariobruto = sc.nextDouble();
        System.out.println("Digite o Mês De referencia");
        sc.nextLine();
        String mes = sc.next();
        System.out.println("Digite a Carga Horaria diaria");
        double cargahoraria = sc.nextDouble();
        System.out.println("Digite os dias trabalhados do Mês de Referência");
        double diasdomes = sc.nextDouble();
        sc.nextLine();
        System.out.println("O trabalhador possui Periculosidade ?");
        String periculosidade = sc.next();
        sc.nextLine();
        System.out.println("O trabalhador possui insalubridade?");
        insalubridade = sc.next();
        if (insalubridade.equals("sim")) {
            System.out.println("Qual é o nivel da insalubridade? ");
            insalubridade1 = sc.nextLine();
        }
                
        double inssvalor = Calcinss.calcularInss(salariobruto, clt);
        String resultado = CalculadoraSalario.calcularSalarioHora(salariobruto, cargahoraria, periculosidade,
                descanso, insalubridade, insalubridade1, diasdomes, tarifa, idavolta, valordescontoali,consumido,valeali,descontovaleali);

        if (clt.equals("nao")) {
            
            sc.nextLine();
            System.out.println("o trabalhador possui Vale transporte?");
            vale = sc.next();
            
            if (vale.equals("sim")) {
                
                System.out.println("Qual é valor da tarifa de Transporte?");
                tarifa = Double.parseDouble(sc.next().replace(",", "."));                               
                
                sc.nextLine();               
                System.out.println("o valor e para ida e volta?");
                idavolta = sc.next();                  
                }
                sc.nextLine();            
                System.out.println("O trabalhador possui Vale Alimentação? ");
                valeali = sc.next();
            
            if (valeali.equals("sim")){
                
                System.out.println("Qual é o valor consumido por dia ?");
                consumido =  sc.nextDouble();
            
                sc.nextLine();
                System.out.println("O vale tera desconto no salario Bruto?");
                descontovaleali = sc.next();
            
                if (descontovaleali.equals("sim")){
                    System.out.println("Qual vai ser o valor do desconto");
                    valordescontoali = sc.nextDouble();                    
                }
            
                else if (descontovaleali.equals("nao")){
                    double valorvale = calcvaleali.calcvaleali(diasdomes, consumido, descontovaleali);
                    System.out.println("o valor do Vale Transporte:" + valorvale);
                }
            }
        }
            
            if (clt.equals("sim")) {
            
                System.out.println("Qual é valor da tarifa de Transporte?");
                tarifa = Double.parseDouble(sc.next().replace(",", "."));                               
                sc.nextLine();
                        
                System.out.println("o valor e para ida e volta?");
                idavolta = sc.next(); 
                        
                System.out.println("Qual é o valor consumido por dia ?");
                consumido =  sc.nextDouble();
            
                sc.nextLine();
                System.out.println("O vale tera desconto no salario Bruto?");
                descontovaleali = sc.next();
            
                if (descontovaleali.equals("sim")){
                    System.out.println("Qual vai ser o valor do desconto");
                    valordescontoali = sc.nextDouble();                    
                }
            
                else if (descontovaleali.equals("nao")){
                    double valorvale = calcvaleali.calcvaleali(diasdomes, consumido, descontovaleali);
                    System.out.println("o valor do Vale Transporte:" + valorvale);
                }

            } 
        
                
                if (inssvalor == 0) {
                    System.out.println("Não é possível calcular o INSS para trabalhadores não-CLT");
                }        
                if (periculosidade.equals("sim") && insalubridade.equals("sim")) {
                    System.out.println("o trabalhador nao pode possuir periculosidade e insalubridade juntos");
                }
                
                System.out.println("Este O Relatoria da Folho de Pagamento");

                System.out.println("Nome:" + nome);
                System.out.println("Data de Admissão: " +  data);
                System.out.println("Mês de Referência: "+ mes);
                System.out.println("Cargo: " + cargo);                

                System.out.println(resultado);
                

    }
}
