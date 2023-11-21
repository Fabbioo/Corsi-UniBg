package AlberoBinarioObject;

// Nodo di un albero binario.
public class NodoBinario {

	public Object elem;
	public NodoBinario padre;
	public NodoBinario sinistro;
	public NodoBinario destro;

	public NodoBinario(Object elem) {
		this.elem = elem;
		this.padre = null;
		this.sinistro = null;
		this.destro = null;
	}

}