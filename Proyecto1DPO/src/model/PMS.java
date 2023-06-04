package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.DoubleAdder;

import persistencia.Cargador;
import persistencia.GuardadorInformacion;

public class PMS {
    private Cargador cargador;
    private GuardadorInformacion guardador;
    private Map<String, Habitacion> habitaciones;
    private Map<String, TipoHabitacion> tipoHabitaciones;
    private ArrayList<Cama> camas;
    private ArrayList<TarifaCuarto> tarifasCuarto;
    private ArrayList<Tarifa> tarifas;
    private Map<String, Bebida> menuBebidas;
    private Map<String, Plato> menuPlatos;
    private Map<String, ArrayList<String>> usuarios;
    private Map<String, String> usuariosHuespedes;
    private Map<String, Servicio> servicios;
    private Map<String, Reserva> reservas;
    private Map<String, Huesped> huespedes;
    private Map<String, Grupo> grupos;
    private Map<String, Consumo> consumos;
    private Map<String, Integer> fechas;



    // GRAFICAS
    private Map<String, Integer> productosPorCantidad;
    private Map<String, Double> productosPorPrecio;
    private Map<String, Integer>valorFacturasEnTiempo;
    private ArrayList<Integer> relacionConsumosyCosto;

    private Map<String, Integer> cantidadReservasPorMes;
    private Map<String, Integer> habitacionesOcupadasPorMes;


    public PMS() {

        habitaciones = new HashMap<String, Habitacion>();
        tipoHabitaciones = new HashMap<String, TipoHabitacion>();
        camas = new ArrayList<Cama>();
        tarifasCuarto = new ArrayList<TarifaCuarto>();
        tarifas = new ArrayList<Tarifa>();
        menuBebidas = new HashMap<String, Bebida>();
        menuPlatos = new HashMap<String, Plato>();
        usuarios = new HashMap<String, ArrayList<String>>();
        usuariosHuespedes = new HashMap<String, String>();
        servicios = new HashMap<String, Servicio>();
        reservas = new HashMap<String, Reserva>();
        huespedes = new HashMap<String, Huesped>();
        grupos = new HashMap<String, Grupo>();
        consumos = new HashMap<String, Consumo>();
        cargador = new Cargador(this);
        guardador = new GuardadorInformacion(this);
        fechas  = crearMapaFechas();
        productosPorCantidad = new HashMap<String,Integer>();
        productosPorPrecio = new HashMap<String,Double>();
        valorFacturasEnTiempo = crearMapaporMes();
        relacionConsumosyCosto = new ArrayList<Integer>();
        cantidadReservasPorMes = crearMapaporMes();
        habitacionesOcupadasPorMes = crearMapaporMes();


        // pruebas de las graficas 
        productosPorCantidad.putIfAbsent("Canopy", 1);
        productosPorCantidad.putIfAbsent("Piscina", 6);
        productosPorCantidad.putIfAbsent("Restaurante", 2);
        productosPorCantidad.putIfAbsent("Spa", 4);
        
        
        
        // productos por precio
        productosPorPrecio.putIfAbsent("Canopy",  152000.0);
        productosPorPrecio.putIfAbsent("Piscina",  12000.0);
        productosPorPrecio.putIfAbsent("Spa",  52000.0);
        productosPorPrecio.putIfAbsent("Caminata",  200000.0);
        productosPorPrecio.putIfAbsent("Restaurante",  40000.0);
        
        
        // facturas sobre el tiempo
        valorFacturasEnTiempo.put("Enero", 110000);
        valorFacturasEnTiempo.put("Febrero", 50000);
        valorFacturasEnTiempo.put("Marzo", 80000);
        valorFacturasEnTiempo.put("Junio", 200000);
        valorFacturasEnTiempo.put("Septiembre", 130000);
        valorFacturasEnTiempo.put("Noviembre", 123000);
        valorFacturasEnTiempo.put("Diciembre", 150000);
        
        
        
        // relacion consumo y costo
        
        relacionConsumosyCosto.add(0, 50000);
        relacionConsumosyCosto.add(1, 100000);
        
        // reservas por mes
        
        
        cantidadReservasPorMes.put("Enero", 25);
        cantidadReservasPorMes.put("Febrero", 30);
        cantidadReservasPorMes.put("Marzo", 82);
        cantidadReservasPorMes.put("Junio", 50);
        cantidadReservasPorMes.put("Septiembre", 49);
        cantidadReservasPorMes.put("Noviembre",10);
        cantidadReservasPorMes.put("Diciembre", 20);
        
    }





    private HashMap<String,Integer> crearMapaporMes(){
        HashMap<String,Integer> mapa = new HashMap<String,Integer>();
        String mes = "";
        for(int i=1; i<13;i++){
        	if(i==1) {mes = "Enero";}
        	else if(i==2) {mes = "Febrero";}
        	else if(i==3) {mes = "Marzo";}
        	else if(i==4) {mes = "Abril";}
        	else if(i==5) {mes = "Mayo";}
        	else if(i==6) {mes = "Junio";}
        	else if(i==7) {mes = "Julio";}
        	else if(i==8) {mes = "Agosto";}
        	else if(i==9) {mes = "Septiembre";}
        	else if(i==10) {mes = "Octubre";}
        	else if(i==11) {mes = "Noviembre";}
        	else if(i==12) {mes = "Diciembre";}
        	
            mapa.put(mes,0);
        }
        return mapa;
    }


    private HashMap<String, Integer> crearMapaFechas(){

        HashMap<String, Integer> mapa = new HashMap<String, Integer>();
        for(int mes = 1; mes<=12; mes++){
            for(int dia = 1; dia <=30; dia++){
                String fecha = String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + "2024";
                mapa.put(fecha, 0);

            }
        }

        // pruebas para evidenciar la concurrencia
        mapa.put("30/10/2024", 6);
        mapa.put("20/10/2024", 20);
        mapa.put("2/7/2024", 100);
        mapa.put("4/5/2024", 1);
        
        return mapa;
    }

    public Map<String, Habitacion> getInventarioHabitaciones() {
        return habitaciones;
    }

    public Map<String, Integer> getFechas() {
        return fechas;
    }

    public Map<String, TipoHabitacion> getTipoHabitaciones() {
        return tipoHabitaciones;
    }

    public ArrayList<Cama> getCamas() {
        return camas;
    }

    public ArrayList<TarifaCuarto> getTarifasCuartos() {
        return tarifasCuarto;
    }

    public ArrayList<Tarifa> getTarifas() {
        return tarifas;
    }

    public Map<String, Bebida> getMenuBebidas() {
        return menuBebidas;
    }

    public Map<String, Plato> getMenuPlatos() {
        return menuPlatos;
    }

    public Map<String, ArrayList<String>> getUsuarios() {
        return usuarios;
    }
    
    public Map<String, String> getUsuariosHuespedes() {
        return usuariosHuespedes;
    }

    public Map<String, Servicio> getServicios() {
        return servicios;
    }

    public Map<String, Reserva> getReservas() {
        return reservas;
    }

    public Map<String, Huesped> getHuespedes() {
        return huespedes;
    }

    public Map<String, Grupo> getGrupos() {
        return grupos;
    }

    public Map<String, Consumo> getConsumos() {
        return consumos;
    }


    public Map<String,Integer> getProductosporCantidad(){
        return productosPorCantidad;
    }

    public Map<String,Double> getProductosporPrecio(){
        return productosPorPrecio;
    }


    public Map<String,Integer>getValorFacturaPorTiempo(){
        return valorFacturasEnTiempo;
    }

    public ArrayList<Integer> getRelacionConsumosyCostos(){
        return relacionConsumosyCosto;
    }

    public Map<String,Integer> getHabitacionesPorMes(){
        return habitacionesOcupadasPorMes;
    }

    public Map<String,Integer> getReservasPorMes(){
        return cantidadReservasPorMes;
    }








    public void agregarFacturaPorTiempo(String mes,Integer valor){
        
        if(getValorFacturaPorTiempo().containsKey(mes)){
            Integer numero = getValorFacturaPorTiempo().get(mes);
            getValorFacturaPorTiempo().put(mes,(( valor+numero)/2));
        }
        else{
            getValorFacturaPorTiempo().put(mes,valor);
        }
       
     }

     public void agregarHabitacionOcupadaPorMes(String mes){
        Integer valorAnterior= getHabitacionesPorMes().get(mes);
        getHabitacionesPorMes().put(mes, valorAnterior+1);
     }

     public void agregarReservasOcupadaPorMes(String mes){
        Integer valorAnterior= getReservasPorMes().get(mes);
        getReservasPorMes().put(mes, valorAnterior+1);
     }

     public void agregarRelacionConsumoyCosto(Integer valorConsumo,Integer valorNoche){
        ArrayList<Integer> lista = getRelacionConsumosyCostos();
        if(lista.size()==0){
            lista.add(valorNoche);
            lista.add(valorConsumo);
        }
        else{
            lista.add(0,valorNoche + lista.get(0));
            lista.add(1,valorConsumo + lista.get(1));
            
        }
     }

    
    public void agregarProductosPorCantidad(String nombre){
       Integer valorAnterior= getProductosporCantidad().get(nombre);
       getProductosporCantidad().put(nombre, valorAnterior+1);
    }


    public void agregarProductosPorPrecio(String nombre, Double precio){
        Double valorAnterior = getProductosporPrecio().get(nombre);
        getProductosporPrecio().put(nombre,(precio + valorAnterior));
    }




    public void agregarHabitacion(Habitacion habitacion) {
        getInventarioHabitaciones().put(habitacion.getIdentificador(), habitacion);
    }

    public void agregarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        getTipoHabitaciones().put(tipoHabitacion.getNombreTipo(), tipoHabitacion);
    }

    public void agregarCama(Cama Cama) {
        getCamas().add(Cama);
    }

    public void agregarTarifaCuarto(TarifaCuarto tarifa) {
        getTarifasCuartos().add(tarifa);
    }

    public void agregarBebida(Bebida bebida) {
        getMenuBebidas().put(bebida.getNombre(), bebida);
        
    }

    public void agregarPlato(Plato plato) {
        getMenuPlatos().put(plato.getNombre(), plato);
    }

    public void agregarUsuario(String login, String password) {

        ArrayList<String> usuario = new ArrayList<String>();
        usuario.add(password);

        if (login.contains("admin")) {
            usuario.add("administrador");
        }

        else if (login.contains("empleado")) {
            usuario.add("empleado");
        }

        else if (login.contains("recepcionista")) {
            usuario.add("recepcionista");
        }

        getUsuarios().put(login, usuario);
    }

    public void agregarServicio(Servicio servicio) {
        getServicios().put(servicio.getNombreTipo(), servicio);
    }

    public void agregarReserva(Reserva reserva) {
        getReservas().put(reserva.getHuespedEncargado().getDocumento(), reserva);
  
    }

    public void agregarHuesped(Huesped Huesped) {
        getHuespedes().put(Huesped.getDocumento(), Huesped);
    }

    public void agregarGrupo(Grupo grupo) {
        getGrupos().put(grupo.getHuespedEncargado().getDocumento(), grupo);

    }

    public void agregarConsumo(Consumo consumo) {
        getConsumos().put(consumo.getHuesped().getDocumento(), consumo);
    }

    public void agregarFechas(Reserva reserva){

        String fechaInicial = reserva.getFechaIn();

        String fechaFinal = reserva.getFechaOut();
   
        int cantidad = reserva.getHabitacionesReservadas().size();

        String[] listInicial = fechaInicial.split("/");
        String[] listFinal = fechaFinal.split("/");
        Integer diainicial = Integer.parseInt(listInicial[0]) ;
        Integer diafinal = Integer.parseInt(listFinal[0]);

        // condicion para ver si la reserva se hizo en el mismo mes
        if(listInicial[1] == listFinal[1]){
            for(int i = diainicial; i<diafinal;i++){
                String fechaNueva = String.valueOf(i ) + "/" + listInicial[1] + "/" + listInicial[2] ;
                System.out.println(fechaNueva);
                if(fechas.containsKey(fechaNueva)){
                    fechas.put(fechaNueva,(fechas.get(fechaNueva) + cantidad));
                }
                else{
                    fechas.put(fechaNueva, cantidad);
                }
            }
        }
        else {
            for(int i = diainicial ; i<31 ; i++){

                String fechaNueva = String.valueOf(i ) + "/" + listInicial[1] + "/" + listInicial[2] ;
                if(fechas.containsKey(fechaNueva)){
                    fechas.put(fechaNueva,(fechas.get(fechaNueva) + cantidad));
                }
                else{
                    fechas.put(fechaNueva, cantidad);
                }
            }
            for(int i = 1 ; i<=diafinal ; i++){

                String fechaNueva = String.valueOf(i ) + "/" + listFinal[1] + "/" + listInicial[2] ;
                if(fechas.containsKey(fechaNueva)){
                    fechas.put(fechaNueva,(fechas.get(fechaNueva) + cantidad));
                }
                else{
                    fechas.put(fechaNueva, cantidad);
                }
            }   
        }    
    }

    public void cambiarTarifaServicio(String nombreServicio, double valor) {

        if (getServicios().containsKey(nombreServicio)) {
            Servicio servicioEdit = getServicios().get(nombreServicio);
            servicioEdit.setTarifa(valor);
        }

    }

    public void actualizarTarifasHabitacion() {

        ArrayList<TarifaCuarto> listaTarifas = getTarifasCuartos();
        Map<String, TipoHabitacion> maptipohabitciones = getTipoHabitaciones();

        for (String tipo : maptipohabitciones.keySet()) {

            for (TarifaCuarto tarifa : listaTarifas) {
                String nombreTarifa = tarifa.getTipoCuarto();
                if (tipo.equalsIgnoreCase(nombreTarifa)) {
                    TipoHabitacion tipoActual = maptipohabitciones.get(tipo);
                    tipoActual.agregarTarifaCuarto(tarifa);
                }
            } // for tarifas

        } // for tipos

    }// método

    public Cargador getCargador() {
        return cargador;
    }

    public GuardadorInformacion getGuardador() {
        return guardador;
    }


    public void agregarUsuarioHuesped(String login, String password)
    {
        getUsuariosHuespedes().put(login, password);
	
    }

}
