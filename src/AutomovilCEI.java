import java.util.Scanner;
public class AutomovilCEI {

    //Creo los atributos que voy a necesitar:

    private String matricula,fecha,descripcion; private int maxBateria, nivelBateria, porcentaje; private boolean servicio;

    //Valores getters:
    public int getMaxBateria() {return maxBateria;} public String getFecha() {return fecha;} public String getMatricula(){return matricula;} public String getDescripcion(){return descripcion;} public int getNivelBateria(){return nivelBateria;}public boolean getServicio(){return servicio;}    public int getPorcentajeBateria() {return porcentaje;}


    //Valores Setters;
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}public void setMatricula(String matricula) {this.matricula = matricula;}public void setFecha(String fecha){this.fecha=fecha;}public void setMaxBateria(int valor){this.maxBateria=valor;} public void setNivelBateria(int valor){if (valor <= maxBateria)this.nivelBateria=valor;else System.out.println("[!] El valor asignado es superior al valor máximo de la bateria, porfavor introduzca un valor inferior porfavor");}

    //Otras clases o métodos;

    public void dec_custom(int valor){System.out.println("[INFO] Usted ha seleccionado decrementar el nivel de batería actual, introduzca a continuación el valor que desea asignar a la batería: ");if(valor>=1)this.nivelBateria = this.nivelBateria - valor;}
    public void aum_custom(int valor){System.out.println(

            
    ); if(valor<=maxBateria)this.nivelBateria = this.nivelBateria + valor;}

    //-------------------------------------------
    public void utilizarEnergia(){if (nivelBateria>=1)this.nivelBateria--;} //Decrementar en 1 el nivel de la bateria
    public void recargarEnergia(){if(nivelBateria<=maxBateria)this.nivelBateria++;} //Aumenta en 1 el nivel de la bateria
    public void calcularporcentaje(){porcentaje=(100/maxBateria)*nivelBateria;} //Calcula el porcentaje de la bateria
    public void checkbateria(){calcularporcentaje();if (porcentaje<=10)servicio = false;else servicio = true;} //Calcula y asigna el porcentaje de bateria al atributo de bateria

    //El constructor de abajo Solo asignará valores a cada atributo para cuando estos no lleguen a ser asignados.
    public AutomovilCEI(){
        matricula = "Missing";
        descripcion = "Missing";
        maxBateria = 7000;
        nivelBateria = (int)( Math.floor(Math.random()*(maxBateria-1000+1)+1000)); //Genera un número aleatorio cuando sea creado de la bateria
        fecha = "18/01/2024";
        calcularporcentaje();
        checkbateria();
    }
    public void Getters(){
        System.out.println("Todos los valores del coche: ");
        System.out.println("- Matricula: "+getMatricula());
        System.out.println("- Descripcion: "+getDescripcion());
        System.out.println("- Fecha: "+getFecha());
        System.out.println("- Nivel Bateria: "+getNivelBateria()+" mAh");
        System.out.println("- Nivel Máximo de Bateria "+getMaxBateria()+" mAh");
        calcularporcentaje();
        System.out.println("- Porcentaje de bateria "+getPorcentajeBateria()+"% ("+getNivelBateria()+"/"+getMaxBateria()+")");
        System.out.println("- Servicio: "+getServicio());
    }

    public void Wait(){
        Scanner teclado = new Scanner(System.in); String opcion = "";
        System.out.println("-Pulse cualquier tecla para continuar-");
        opcion = teclado.nextLine();
    }

    public void SetSelector() {
        Scanner teclado = new Scanner(System.in);
        int subopcion;
        do {
            System.out.println("[MENU > Setters] Seleccione una de las siguientes opciones\n1- Modifica el valor para la matricula\n2- Modifica el valor para la descripcion\n3- Modifica el valor para el nivel de bateria\n4- Modifica el valor para el nivel máximo de bateria\n5- Modifica la fecha (Array de números enteros int)\n6- Aumenta en 1 la energía\n7- Decrementa en un 1 la energía\n8- Decrementa de manera personalizada la energía\n9- Aumenta de manera personalizada la energía\n0- Vuelve al menu\n(No se puede modificar el servicio ni el porcentaje ya que estos valores son calculados)");
            subopcion = teclado.nextInt();             teclado.nextLine();
            switch (subopcion) {
                case 1:
                    System.out.println("Introduzca el nuevo valor para la matricula: (String)");
                    setMatricula(teclado.nextLine());
                    Wait();
                    break;
                case 2:
                    System.out.println("Introduzca el nuevo valor para la descripción (String)");
                    setDescripcion(teclado.nextLine());
                    break;
                case 3:
                    System.out.println("Introduzca el nuevo valor para el nivel de la bateria (int)");
                    setNivelBateria(teclado.nextInt());
                    Wait();
                    break;
                case 4:
                    System.out.println("Introduzca el nuevo valor para el nivel máximo de la bateria (int)");
                    setMaxBateria(teclado.nextInt());
                    Wait();
                    break;
                case 5:
                    System.out.println("Introduzca el nuevo valor para la fecha (String)");
                    setFecha(teclado.nextLine());
                    Wait();
                    break;
                case 6:
                    System.out.println("Energía incrementada +1");
                    recargarEnergia();
                    Wait();
                    break;
                case 7:
                    System.out.println("Energía decrementada -1");
                    utilizarEnergia();
                    Wait();
                    break;
                case 8:
                    System.out.println("Introduzca un valor personalizado para restar a la energía (resta a la energía un valor personalizado)");
                    dec_custom(teclado.nextInt());
                    Wait();
                    break;
                case 9:
                    System.out.println("Introduzca un valor personalizado para aumentar a la energía (suma a la energía un valor personalizado)");
                    aum_custom(teclado.nextInt());
                    Wait();
                    break;
            }
        }while (subopcion!=0);
    }

    public void GetSelector(){
        Scanner teclado = new Scanner(System.in);
        int subopcion;
        do {
            System.out.println("[MENU > Getters] Seleccione una de las siguientes opciones\n1- Obtiene el valor de la matricula\n2- Obtiene el valor de la descripcion\n3- Obtiene el nivel de bateria (mAh)\n4- Obtiene el nivel de batería (en porcentaje)\n5- Obtiene el valor máximo del nivel de batería\n6- Obtiene todos los valores relacionados con la bateria\n7- Obtiene la fecha\n8- Obtiene el servicio  \n0- Vuelve al menu anterior\n");
            subopcion = teclado.nextInt();
            switch (subopcion) {
                case 1:
                    System.out.println("> Matricula: " + getMatricula());
                    break;
                case 2:
                    System.out.println("> Descripion: " + getDescripcion());
                    break;
                case 3:
                    System.out.println("> Nivel de batería actual" + getNivelBateria());
                    break;
                case 4:
                    System.out.println("> Nivel de batería actual (porcentaje)" + getPorcentajeBateria());
                    break;
                case 5:
                    System.out.println("> Nivel de batería actual (porcentaje)" + getMaxBateria());
                    break;
                case 6:
                    System.out.println("----Información diversa de la batería----\n>Nivel de batería actual: " + getNivelBateria() + "\n> Nivel máximo de batería: " + getMaxBateria() + "\n >Porcentaje de batería restante: " + getPorcentajeBateria()+"\n------\n");
                    break;
                case 7:
                    System.out.println("> Fecha: " + getFecha());
                    break;
                case 8:
                    System.out.println("> Servicio: "+getServicio());
            }
        }while (subopcion!=0);
    }


    public static void main(String[] args) {
        AutomovilCEI coche = new AutomovilCEI(); int opcion; Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido al menú de operaciones para el apartado 1 del ejercicio ");
        do {
            System.out.println("\n[MAIN MENU] Seleccione una de las siguientes opciones\n\n1- Obtiene la lista de atributos del vehiculo\n2- Modifica un atributo del coche (Usa un setter) \n3- Obtiene un atributo del coche (Usa un getter) \n0- Exit");
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:coche.Getters();break;
                case 2:coche.SetSelector();break;
                case 3:coche.GetSelector();break;
            }
        }while (opcion!=0);
        System.out.println("Programa finalizado");

    }




}
