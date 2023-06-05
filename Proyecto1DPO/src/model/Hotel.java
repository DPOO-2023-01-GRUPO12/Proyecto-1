package model;

public class Hotel {
	
	
	
	private Boolean parqueaderoPagoDelHotel;
	private Boolean parqueaderoGratuitoDelHotel;
	private Boolean piscina;
	private Boolean zonasHumedas;
	private Boolean BBQ;
	private Boolean wifiGratis;
	private Boolean recepcion24Horas;
	private Boolean admiteMascotas;
	
	
	Hotel() {
		parqueaderoPagoDelHotel =false;
		
		parqueaderoGratuitoDelHotel =false;
		zonasHumedas =false;
		piscina =false;
		BBQ =false;
		wifiGratis =false;
		recepcion24Horas =false;
		admiteMascotas =  false;
		
	}
	public Boolean getParqueaderoPagoDelHotel() {
		return parqueaderoPagoDelHotel;
	}
	public void setParqueaderoPagoDelHotel(Boolean parqueaderoPagoDelHotel) {
		this.parqueaderoPagoDelHotel = parqueaderoPagoDelHotel;
	}
	public Boolean getParqueaderoGratuitoDelHotel() {
		return parqueaderoGratuitoDelHotel;
	}
	public void setParqueaderoGratuitoDelHotel(Boolean parqueaderoGratuitoDelHotel) {
		this.parqueaderoGratuitoDelHotel = parqueaderoGratuitoDelHotel;
	}
	public Boolean getPiscina() {
		return piscina;
	}
	public void setPiscina(Boolean piscina) {
		this.piscina = piscina;
	}
	public Boolean getZonasHumedas() {
		return zonasHumedas;
	}
	public void setZonasHumedas(Boolean zonasHumedas) {
		this.zonasHumedas = zonasHumedas;
	}
	public Boolean getBBQ() {
		return BBQ;
	}
	public void setBBQ(Boolean bBQ) {
		BBQ = bBQ;
	}
	public Boolean getWifiGratis() {
		return wifiGratis;
	}
	public void setWifiGratis(Boolean wifiGratis) {
		this.wifiGratis = wifiGratis;
	}
	public Boolean getRecepcion24Horas() {
		return recepcion24Horas;
	}
	public void setRecepcion24Horas(Boolean recepcion24Horas) {
		this.recepcion24Horas = recepcion24Horas;
	}
	public Boolean getAdmiteMascotas() {
		return admiteMascotas;
	}
	public void setAdmiteMascotas(Boolean admiteMascotas) {
		this.admiteMascotas = admiteMascotas;
	}
	
	

}
