package MercatoOrtofrutticolo_COMPLETO;

public interface MercatoIF
{
	public abstract void compra(int q, float budget) throws InterruptedException;
	public abstract void vendi(int q) throws InterruptedException;
}
