
package com.mycompany.cuentabancaria;

import java.util.Arrays;


public class Cliente 
{
    private int la;
    private String Nombre;
    private String Dni_Propietario;
    private int Numcuentas;
    protected CuentaBancaria Cuentas[] =  new CuentaBancaria [10];


    public Cliente(String Nombre, String Dni_Propietario, int Num_cuentas, CuentaBancaria[] Cuentas) {
        this.Nombre = Nombre;
        this.Dni_Propietario = Dni_Propietario;
        this.Numcuentas = Num_cuentas;
        this.Cuentas = Cuentas;
    }
       public Cliente() {
        this.Nombre = "DEFAULT";
        this.Dni_Propietario = "000000";
        this.Numcuentas = 0;
       
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDni_Propietario() {
        return Dni_Propietario;
    }

    public void setDni_Propietario(String Dni_Propietario) {
        this.Dni_Propietario = Dni_Propietario;
    }

    public int getNumcuentas() {
        return Numcuentas;
    }

    public void setNum_cuentas(int Num_cuentas) {
        this.Numcuentas = Num_cuentas;
    }

    public CuentaBancaria[] getCuentasBancarias() {
        return Cuentas;
    }

        
    public void setCuentasBancarias(Cliente cliente, CuentaBancaria Cuentas) 
    {
        for(int i=0; i<Numcuentas; i++)
        {
            if(cliente.Cuentas[i] == null)
            {
                cliente.Cuentas[i] = Cuentas;
                break;
            }
        }
    }
    

    
    
    public void  Ver_Datos_Cliente()
    {
        System.out.println("El nombre del cliente es " + this.Nombre);
        System.out.println("El DNI del propietario es " + this.Dni_Propietario);
        System.out.println("El numero de cuentas del propietario son " + this.Numcuentas);
        System.out.println("Las cuentas del propietario son");
            for (int i = 0; i < Numcuentas; i++) 
        {
            Cuentas.toString();
            System.out.println(Cuentas[i].toString());


        }
    
    }
    
    
    
    
  
    public void añadir_cuentas( CuentaBancaria b, Cliente a)
    {
        a.Numcuentas++;
     
        a.setCuentasBancarias(a,b);
    }
          
     /*
    Reintegro_Cuenta: método que decrementará el saldo de la cuenta que
    se indique en la cantidad que también se determine
    */

public void reintegro_cuenta (int numerodecuenta, double retirada)
{
    this.Cuentas[numerodecuenta].setSaldo(-retirada);
    
    System.out.println("El saldo es " + this.Cuentas[numerodecuenta].getSaldo());
    
}

    
/*
Transferencia_cuenta_a_cuenta: método que realizará una
transferencia de una cuenta a otra que puede ser o no del propio cliente.
Si es del propio cliente no se aplicará la comisión. En el caso de que no
haya dinero suficiente se avisará y abortará la operación. Tendrá que
aceptar los parámetros correspondientes.
*/

    

 
    
public static boolean transferenciacuenta(int numerodecuentaa,int numerodecuentab, double traspaso, Cliente a, Cliente b)
{
     double comision = traspaso * 10 / 100;
     if (a.Cuentas[numerodecuentaa].getSaldo()<traspaso) 
    {
        System.out.println("SALDO INSUFICIENTE");
        System.out.println("OPERACIÓN ABORTADA");
        return false;
        
    }
    if (a.getDni_Propietario().equals(b.Cuentas[numerodecuentab].getIban()))
    {
            a.Cuentas[numerodecuentaa].reintegro1(traspaso);
            b.Cuentas[numerodecuentab].ingreso(traspaso);
            return true;
    }
    else
    {
            a.Cuentas[numerodecuentaa].reintegro1(traspaso + comision);
            b.Cuentas[numerodecuentab].ingreso(traspaso);
            return true;
    }
    
    
}


public static boolean borrar_cuenta_cliente(Cliente a, int numcuenta )
{
    double saldo = 0.00;
    
      if (numcuenta==0) {
          System.out.println("Operación abortada");
          return false;
          
        
    }else
        saldo += a.Cuentas[0].getSaldo();
        a.Cuentas[0].setSaldo(a.Cuentas[0].getSaldo() + saldo);
        a.Cuentas[numcuenta] = null;
         return true;

     
}

/*
Saldo_total_cliente: método que devolverá el saldo total de las cuentas
de un cliente
*/

public  double Saldo_total_cliente()
{
    double saldoaux = 0.00;
    for (int i = 0; i < Numcuentas; i++) {
        saldoaux += Cuentas[i].getSaldo();
    
    }
    return saldoaux;
}

/*
Máxima_cuenta_cliente: método que nos tiene que indicar cuál es la
cuenta con mayor saldo de un cliente.
*/

public void Maxima_cuenta_cliente()
{
            
            int cuentabancaria = 0;
            for (int i = 0; i < Numcuentas; i++) 
            {
                for (int j = 1; j < Numcuentas; j++) 
                {
                if (Cuentas[i].getSaldo()> Cuentas[j].getSaldo()) 
                        cuentabancaria = i;

                else 
                        cuentabancaria = j;
                }
            }
            
            System.out.println("La maxima cuenta bancaria es la  " + cuentabancaria);
}
          
    public void cuentas_ordenadas()
    {
        
//        CuentaBancaria temp = new CuentaBancaria();
//        boolean ordenado = false;
//        do
//        {
//        for (int i = 0; i < Numcuentas; i++) 
//        {
//                            if (this.Cuentas[i].getSaldo()<this.Cuentas[i+1].getSaldo()){
//                                temp = this.Cuentas[i];
//                                this.Cuentas[i] = this.Cuentas [i+1];
//                                this.Cuentas[i+1] = temp;
//                                ordenado = false;
//                            }
//                            
//        }      
//        }while  (ordenado==false){
//        ordenado=true;
        
        
    }
    
public boolean cuentasordenadas() 
{
        CuentaBancaria temp = new CuentaBancaria();
        boolean ordenado = false;
            do {
             ordenado = true;
             for (int i = 0; i < Numcuentas-1; i++) {
             if (this.Cuentas[i].getSaldo() < this.Cuentas[i + 1].getSaldo()) {
             temp = this.Cuentas[i];
             
             this.Cuentas[i + 1] = temp;
             ordenado = false;
            }
            }
        } while (!ordenado);
            
            
           return ordenado;
}
        
       
}
            
   
                            
                        
       

    
    
    
     
   
    

