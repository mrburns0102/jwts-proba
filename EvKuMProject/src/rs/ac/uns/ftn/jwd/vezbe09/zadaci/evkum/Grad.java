package rs.ac.uns.ftn.jwd.vezbe09.zadaci.evkum;

public class Grad {
	protected int pttBroj;
	protected String naziv;

	public Grad() {
	}

	public Grad(int pttBroj, String naziv) {
		this.pttBroj = pttBroj;
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return naziv;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grad other = (Grad) obj;
		if (pttBroj != other.pttBroj)
			return false;
		return true;
	}

	public int getPttBroj() {
		return pttBroj;
	}

	public void setPttBroj(int pttBroj) {
		this.pttBroj = pttBroj;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
}