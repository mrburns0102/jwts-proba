package rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum.model;

public class KM {
	protected int id;
	protected String naziv;
	protected int brPosetilaca;
	protected Grad grad;

	public KM() {
		this.id = -1;
	}

	public KM(int id, String naziv, int brPosetilaca, Grad grad) {
		this.id = id;
		this.naziv = naziv;
		this.brPosetilaca = brPosetilaca;
		this.grad = grad;
	}
	
	@Override
	public String toString() {
		return naziv + " " + grad;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KM other = (KM) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getBrPosetilaca() {
		return brPosetilaca;
	}

	public void setBrPosetilaca(int brPosetilaca) {
		this.brPosetilaca = brPosetilaca;
	}

	public Grad getGrad() {
		return grad;
	}

	public void setGrad(Grad grad) {
		this.grad = grad;
	}
}