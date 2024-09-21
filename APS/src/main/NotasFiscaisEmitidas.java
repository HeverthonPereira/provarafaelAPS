package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class NotasFiscaisEmitidas {
    private String razaoSocial;
    private String cnpj;
    private String regimeTributario;
    private String email;
    private String numeroNota;
    private Date dataEmissao;
    private String servico;
    private double valor;

    public NotasFiscaisEmitidas(String razaoSocial, String cnpj, String regimeTributario, String email,
                                 String numeroNota, Date dataEmissao, String servico, double valor) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.regimeTributario = regimeTributario;
        this.email = email;
        this.numeroNota = numeroNota;
        this.dataEmissao = dataEmissao;
        this.servico = servico;
        this.valor = valor;
    }

    public double calcularImposto(NotasFiscaisEmitidas nf) {
    	double taxa = 0;
       if (nf.regimeTributario.equalsIgnoreCase("SN")) {
    	   taxa = 1.065;
       }else if (nf.regimeTributario.equalsIgnoreCase("LP")){
    	   taxa = 1.12;
       }
        
       // if (regimeTributario.equalsIgnoreCase("Simples Nacional")) {
           // taxa = 1.065; 
       // } else if (regimeTributario.equalsIgnoreCase("Lucro Presumido")) {
           // taxa = 1.12; 
        //
        double imposto = nf.valor * taxa; 
        System.out.printf("Cálculo do imposto: %.2f = %.2f", valor, taxa, imposto); 
        return imposto;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format(
            "NotaFiscal {\n" +
            "    razaoSocial='%s',\n" +
            "    cnpj='%s',\n" +
            "    regimeTributario='%s',\n" +
            "    email='%s',\n" +
            "    numeroNota='%s',\n" +
            "    dataEmissao=%s,\n" +
            "    servico='%s',\n" +
            "    valor=%.2f\n" +
            "}",
            razaoSocial, cnpj, regimeTributario, email, numeroNota, sdf.format(dataEmissao), servico, valor
        );
    }
}