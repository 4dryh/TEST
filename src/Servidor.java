public class Servidor {

private String nombre, ip, descripcion, fechaServicio; private boolean web, dns, ftp; private int puertoWeb,puertoDns,puertoFTP,defaultweb,defaultDNS,defaultFtp,type;


//Inicializa los valores del servidor
public Servidor(){
    this.nombre = "Nombre de servidor por defecto";
    this.ip = "X.X.X.X";
    this.descripcion = "Descripción del servidor por defecto";
    this.fechaServicio = "XX/XX/XXXX";
    this.web = true;
    this.dns = false;
    this.ftp = true;
    //Asigna los valores por defecto que podrán adoptar los puertos
    this.defaultDNS = 51;
    this.defaultweb = 80;
    this.defaultFtp = 21;
    //Asigna valores a los puertos:
    this.puertoWeb = 80;
    this.puertoDns = 0; //Puerto desactivado
    this.puertoFTP = 21;

}

//Getters
public String getNombre(){return nombre;} public String getIp(){return ip;} public String getDescripcion(){return descripcion;} public String getFechaServicio(){return fechaServicio;}public boolean getWeb(){return web;}public boolean getDns(){return dns;}public boolean getFtp(){return ftp;}public int getPuertoWeb(){return puertoWeb;}public int getPuertoDns(){return puertoDns;}public int getPuertoFTP(){return puertoFTP;}public int getDefaultweb(){return defaultweb;}public int getDefaultDNS(){return defaultDNS;}public int getDefaultFTP(){return defaultFtp;}

//Setters
public void setNombre(String valor){this.nombre = valor;}public void setIp(String valor){this.ip = valor;}public void setDescripcion(String valor){this.descripcion = valor;}public void setWeb (boolean valor){this.web = valor;}public void setDns (boolean valor){this.dns = valor;}public void setFtp(boolean valor){this.ftp = valor;}public void setFechaServicio (String valor) {this.fechaServicio = valor;}public void setPuertoWeb(int valor){this.puertoWeb = valor;}

public void cambiarEstadoServicio(String tipo, boolean estado){
    switch (tipo){
        case "web": this.web=estado;if (estado){type = 0; actualizar();}else this.puertoWeb = 0;break; case "dns": this.dns=estado;if (estado){type = 1; actualizar();}else this.puertoDns = 0;break; case "ftp": this.ftp=estado; if (estado){type = 2; actualizar();}else this.puertoFTP = 0; break;
    }
}

public void actualizar(){
    switch (type){
        case 0:
            if (web)this.puertoWeb= defaultweb;
        case 1:
            if (dns)this.puertoDns=defaultDNS;
        case 2:
            if (ftp)this.puertoFTP=defaultFtp;
    }
}

public void cambiarPuerto(String tipo, int puertonuevo){switch (tipo){case "web":this.defaultweb = puertonuevo; type = 0; actualizar(); break; case "dns":this.defaultDNS = puertonuevo;type = 1; actualizar(); break; case "ftp":this.defaultFtp = puertonuevo;type = 2; actualizar(); break;}}

public void obtenerAtributos(){System.out.println("\n> Nombre del servidor: "+getNombre()+"\n> Ip: "+getIp()+"\n> Descripción: "+getDescripcion()+"\n> Fecha Servicio: "+getFechaServicio()+"\n\n----ESTADOS----\n\n> Puerto Web: "+getWeb()+"\n> Puerto DNS: "+getDns()+"\n> Puerto FTP: "+getFtp()+"\n\n----VALORES DE LOS PUERTOS----\n\n> Puerto Web: "+getPuertoWeb()+"\n> Puerto DNS: "+getPuertoDns()+"\n> Puerto FTP: "+getPuertoFTP()+"\n\n----VALORES POR DEFECTO DE LOS PUERTOS----\n\n> Puerto web: "+getDefaultweb()+"\n> Puerto DNS: "+getDefaultDNS()+"\n> Puerto FTP: "+getDefaultFTP());}


public static void main(String[] args) {
    Servidor ejecutador = new Servidor();

//    Los siguientes Getteers obtienen la información de cada atributo y la muestran por pantalla:
    System.out.println("\n\n----Información del servidor----");
    System.out.println(ejecutador.getNombre());
    System.out.println(ejecutador.getDescripcion());
    System.out.println(ejecutador.getIp());
    System.out.println(ejecutador.getFechaServicio());
    System.out.println("---Estado de los puertos-----");
    System.out.println(ejecutador.getWeb());
    System.out.println(ejecutador.getDns());
    System.out.println(ejecutador.getFtp());
    System.out.println("----Valores de los puertos----");
    System.out.println(ejecutador.getPuertoWeb());
    System.out.println(ejecutador.getPuertoDns());
    System.out.println(ejecutador.getPuertoFTP());
    System.out.println("----Valores por defecto----");
    System.out.println(ejecutador.getDefaultweb());
    System.out.println(ejecutador.getDefaultDNS());
    System.out.println(ejecutador.getDefaultFTP());
    System.out.println("-------------");

    // No obstante he creado un método que hace exactamente lo mismo, reduciendo todo a una linea:

    ejecutador.obtenerAtributos();

    // Con los siguientes Setters se puede cambiar el estado o valor de los atributos, yo le pondré atributos muy parecidos a los mostrados en el ejemplo de clase:

    ejecutador.setNombre("Server Two");
    ejecutador.setIp("192.168.59.2");
    ejecutador.setDescripcion("Servicio Web y FTP | Fabricado por la empresa: Among US");
    ejecutador.setFechaServicio("23/05/912 (A.C)");

    //Mediante el método de abajo se podrá cambiar el estado del servicio:
    //el tipo tendrá que estár si o si en minúscula, sino no lo detectará

    ejecutador.cambiarEstadoServicio("web",true);
    ejecutador.cambiarEstadoServicio("dns",false);
    ejecutador.cambiarEstadoServicio("ftp",false);

    //Lo mismo ocurre con los métodos para cambiar los puertos de a continuación:

    ejecutador.cambiarPuerto("web",79);
    ejecutador.cambiarPuerto("dns",21);
    ejecutador.cambiarPuerto("ftp",456);
    System.out.println("-------");

    ejecutador.obtenerAtributos();


    /*

    Los "set" de los atributos boolean web, dns, ftp no deberían cambiarse mediante los set, porque para ello existe el método cambiarEstadoServicio
    Pero aun asi pueden ser cambiados mediante los setters:

    ejecutador.setDns(false);
    ejecutador.setWeb(false);
    ejecutador.setFtp(false);

    Insisto, en que no es recomendable su uso, debido a la existencia del método previamente mencionado. Lo mismo ocurre con los puertos web, dns y ftp.
    Pueden ser cambiados mediante los setters, pero no es recomendable ya que existe el método cambiarEstadoServicio para activarlos o desactivarlos además del método cambiarPuerto
    que permitirá cambiar el puerto por defecto de cada uno.

    Aun así, si se quisiera llegar a usar los setters de los atributos anteriormente nombrados se tendría que hacer lo siguiente:

    ejecutador.setPuertoWeb(0);
    ejecutador.setPuertoDns(0);
    ejecutador.setPuertoFTP(0);

    Los puerto DEFAULT SOLO PODRÁN CAMBIARSE MEDIANTE EL MÉTODO: cambiarPuerto

    */



}
}
