package Pr�ctica2;

public class Fecha {
    private int anio;
    private int mes;
    private int dia;

    public Fecha() {
        anio = 1;
        mes = 1;
        dia = 1;
    }

    public Fecha(int anio, int mes, int dia) {

        boolean correcto = true;
//Validacion fechas
        if ((mes < 1) || (mes > 12)) {
            correcto = false;
        }
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia < 1 || dia > 30) {
                correcto = false;
            }
        }
        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
            if (dia < 1 || dia > 31) {
                correcto = false;
            }
        }
        if (mes == 2) {
            if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
                if (dia < 1 || dia > 29) {
                    correcto = false;
                } 
            }
            else {
                    if (dia < 1 || dia > 28) {
                        correcto = false;
                    }
                }
        }
        if (correcto) {
            this.anio = anio;
            this.mes = mes;
            this.dia = dia;
        } else {
            this.anio = 0;
            this.mes = 0;
            this.dia = 0;
        }
    }
    public int diferencia (Fecha fecha2){
        
        int anio2, mes2, dia2, i, total=0, dat0, dat1;
            anio2=fecha2.getAnio();
            mes2=fecha2.getMes();
            dia2=fecha2.getDia();
            dat0= anio*1000+mes*100+dia;
            dat1= anio2*1000+mes2*100+dia2;
            
            
            if (anio2>anio){//fechas en a�os distintos

				for (i=anio+1 ; i<anio2 ; i++){//suma de a�os
					total = total + 365;
					if ((i%4==0 && i%100!=0) || i%400==0)	total = total + 1;
				}
				for (i=mes+1; i<13; i++){//suma de meses de a�o de inicio
					if (i==1 ||i==3||i==5||i==7||i==8||i==10||i==12) total=total+31;
					if (i==4 ||i==6||i==9||i==11) total=total+30;
					if (i==2) total=total+28;
					if (i==2 && ((anio%4==0 && anio%100!=0) || anio%400==0)) total=total+1;
				}
				for (i=1; i<mes2; i++){//suma de meses de a�o de fin
					if (i==1 ||i==3||i==5||i==7||i==8||i==10||i==12) total=total+31;
					if (i==4 ||i==6||i==9||i==11) total=total+30;
					if (i==2) total=total+28;
					if (i==2 && ((anio2%4==0 && anio2%100!=0) || anio2%400==0)) total=total+1;
				}
				i=mes;//dias mes de inicio
				if (i==1 ||i==3||i==5||i==7||i==8||i==10||i==12) total=total+31-dia;
				if (i==4 ||i==6||i==9||i==11) total=total+30-dia;
				if (i==2) total=total+28-dia;
				if (i==2 && ((anio%4==0 && anio%100!=0) || anio%400==0)) total=total+1;
				total=total+dia2;//dias de mes final

			} else{
				if (anio==anio2){//fechas en el mismo a�o
					for (i=mes+1; i<mes2; i++){//suma de meses intermedios
						if (i==1 ||i==3||i==5||i==7||i==8||i==10||i==12) total=total+31;
						if (i==4 ||i==6||i==9||i==11) total=total+30;
						if (i==2) total=total+28;
						if (i==2 && ((anio%4==0 && anio%100!=0) || anio%400==0)) total=total+1;
					}
					if (mes==mes2) {//mismo a�o, mismo mes
						total=dia2-dia;
					}	else{
						i=mes;//mes de inicio
						if (i==1 ||i==3||i==5||i==7||i==8||i==10||i==12) total=total+31-dia;
						if (i==4 ||i==6||i==9||i==11) total=total+30-dia;
						if (i==2) total=total+28-dia;
						if (i==2 && ((anio%4==0 && anio%100!=0) || anio%400==0)) total=total+1;
						total=total+dia2;//dias mes final
					}
				}
			}
			return total;
            
            
    } 
    
    public Fecha sumardias(int sumarDias){
        
    	int dia=this.dia, mes=this.mes, anio=this.anio;
    	Fecha fecha2;
    	fecha2=new Fecha();
    	
    	//suma
    	if (sumarDias > 0) {
    		for (int i = 0; i < sumarDias; i++) {
    			if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
    				dia++;
    				if (dia > 30) {
    					mes++;
    					dia = 1;
    				}
    			}
    			if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
    				dia++;
    				if (dia > 31) {
    					mes++;
    					dia = 1;
    					if (mes > 12) {
    						anio++;
    						mes = 1;
    						dia = 1;
    					}
    				}
    			}
    			if (mes == 2) {
    				if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
    					dia++;
    					if (dia > 29) {
    						mes++;
    						dia = 1;
    					}
    				} else {
    					dia++;
    					if (dia > 28) {
    						mes++;
    						dia = 1;
    					}
    				}
    			}
    		}

    		fecha2.setDia(dia);
    		fecha2.setMes(mes);
    		fecha2.setAnio(anio);

    	}
    	//resta
    	if (sumarDias < 0) {


    		for (int i = 0; i > sumarDias; i--) {
    			dia=dia-1;
    			if (dia<1) {
    				mes = mes - 1;
    				if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
    					dia = 30;
    				}
    				if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
    					dia = 31;
    				}
    				if (mes == 2) {
    					if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) {
    						dia = 29;
    					}
    					if ((anio % 4 != 0) && ((anio % 100 == 0) || (anio % 400 != 0))) {
    						dia = 28;
    					}
    				}
    				if (mes < 1) {
    					anio = anio - 1;
    					mes = 12;
    					dia = 31;
    				}

    			}

    			fecha2.setDia(dia);
    			fecha2.setMes(mes);
    			fecha2.setAnio(anio);
    		}
    	}
    	return fecha2;
    }
    
    public String diadelaSemana(){
        String diasemana="";
        Fecha fecha1;
        fecha1=new Fecha(1899, 12, 31);
        int dif=fecha1.diferencia(this);
        if (dif<0) {
        	dif=-dif;
        	dif=dif%7;
        	switch(dif){
        	case 0:
        		diasemana="Domingo";
        		break;
        	case 1:
        		diasemana="Sábado";
        		break;
        	case 2:
        		diasemana="Viernes";
        		break;
        	case 3:
        		diasemana="Jueves";
        		break;
        	case 4:
        		diasemana="Miércoles";
        		break;
        	case 5:
        		diasemana="Martes";
        		break;
        	case 6:
        		diasemana="Lunes";
        		break;
        	}
        }else {

        	dif=dif%7;
        	switch(dif){
        	case 0:
        		diasemana="Domingo";
        		break;
        	case 1:
        		diasemana="Lunes";
        		break;
        	case 2:
        		diasemana="Martes";
        		break;
        	case 3:
        		diasemana="Miércoles";
        		break;
        	case 4:
        		diasemana="Jueves";
        		break;
        	case 5:
        		diasemana="Viernes";
        		break;
        	case 6:
        		diasemana="Sabado";
        		break;
        	}
        }
        return diasemana;
    }
    
    
    public void imprimir (){
        System.out.println("Día: "+dia+" Mes: "+mes+" Año: "+anio);
    }
    
    public void imprimir (String diasemana){
        System.out.println("Día: "+dia+" Mes: "+mes+" Año: "+anio+" "+diasemana);
    }
    
    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
    	//validación del año (ojo con el día)
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
    	//validación del mes (ojo con el día)
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
    	//validación del día según mes y año
        this.dia = dia;
    }

	public static void getdiferencia() {
		// TODO Auto-generated method stub
		
	}
}
