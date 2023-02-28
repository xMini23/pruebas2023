
package com.mycompany.cuentabancaria;


public class CuentaBancaria 
{

 
    
    private String Iban;
    public double  Saldo;
    private String dni_propietario;


    public CuentaBancaria(String Iban, double Saldo, String dni_propietario) {
        this.Iban = Iban;
        this.Saldo = Saldo;
        this.dni_propietario = dni_propietario;
    }
    public CuentaBancaria() {
        this.Iban = "4432432432423DBA";
        this.Saldo = 0.00;
        this.dni_propietario = "000000000N";
    }

    public String getIban() {
        return Iban;
    }

    public void setIban(String Iban) {
        this.Iban = Iban;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public String getDni_propietario() {
        return dni_propietario;
    }

    public void setDni_propietario(String dni_propietario) {
        this.dni_propietario = dni_propietario;
    }
    
    
    public void  ver_datos_cuenta()
    {
        System.out.println("El dni es " + this.dni_propietario);
        System.out.println("El IBAN del propietario " + this.Iban);
        System.out.println("El saldo es : " + this.Saldo);
    }
    
    public void ingreso (double ingreso)
    {   
        this.Saldo += ingreso;
        
    }
    
    public void reintegro (double reintegro)
    {
        this.Saldo = this.Saldo - reintegro;
        if (this.Saldo<0) {
            System.out.println("LA CUENTA ESTÁ EN NUMEROS ROJOS");
            System.out.println(this.Saldo);
        }
    }
    
    public void reintegro1 (double reintegro)
    {
        if (this.Saldo>=reintegro) {
                    this.Saldo = this.Saldo - reintegro;
        }else
            System.out.println("Operacion abortada");
    }
   
    public static void transferencia_cuenta_a_cuenta (CuentaBancaria a, CuentaBancaria b, double transferencia)
    {
        if (a.getSaldo()> transferencia * 0.01) {
            System.out.println("No se puede realizar ");
        }else
           a.setSaldo(a.getSaldo() - transferencia * 0.01);  
           b.setSaldo(transferencia);
            
    }
    
    
    
  
    
    public static boolean comparar_saldo_cuentas(CuentaBancaria A, CuentaBancaria B)
    {
    
        if (A.getSaldo()>B.getSaldo()) {
            return true;
        }else   
            return false;
    }
 
    public static void main(String[] args) 
    {
//        CuentaBancaria cu1 = new CuentaBancaria("1111",1000,"244444A");
//        CuentaBancaria cu2 = new CuentaBancaria("1111",2000,"244444A");
//
//        cu1.ver_datos_cuenta();
//        cu2.ver_datos_cuenta();
//        
//        transferencia_cuenta_a_cuenta(cu1,cu2,1000);
//          cu1.ver_datos_cuenta();
//        cu2.ver_datos_cuenta();
//        
        
        Cliente a = new Cliente();
        Cliente b = new Cliente();
        CuentaBancaria x = new CuentaBancaria();
//         b.Ver_Datos_Cliente();
        CuentaBancaria cosas = new CuentaBancaria();
        CuentaBancaria cosasb = new CuentaBancaria();


        a.añadir_cuentas(x,a);
        a.añadir_cuentas(cosas,a);
        b.añadir_cuentas(cosasb,b );
        
        a.Cuentas[0].setSaldo(500.00);
        a.Cuentas[1].setSaldo(600.00);
        b.Cuentas[0].setSaldo(500.00);
////      a.Ver_Datos_Cliente();
////        System.out.println("____________________________________");
////      b.Ver_Datos_Cliente();
//////      
////    
//     transferenciacuenta(0, 0, 100,a,b);
  
       System.out.println(a.Cuentas[0].getSaldo());
       System.out.println(a.Cuentas[1].getSaldo());
        
       System.out.println("____________________________");
       
    
    }
}
