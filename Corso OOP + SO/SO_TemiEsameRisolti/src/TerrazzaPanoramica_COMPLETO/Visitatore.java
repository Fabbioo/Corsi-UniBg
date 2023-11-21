package TerrazzaPanoramica_COMPLETO;

public class Visitatore extends Thread
{
	private final int EST = 0; // 0 coincide con la provenienza da EST -> OVEST = 1
	TerrazzaPanoramicaIF m;
	int provenienza;

	/**
	 * 
	 * @param m    riferimento all'oggetto condiviso
	 * @param dir  direzione di viaggio
	 * @param name nome da dare al visitatore (cioè al thread)
	 */
	Visitatore(TerrazzaPanoramicaIF m, int dir, String name)
	{
		super(name);
		this.m = m;
		this.provenienza = dir;
	}

	public void run()
	{
		try {
			if(provenienza == EST) 
			{	
				/*
				 * Se il visitatore proviene dalla riva est devono essere eseguiti in ordine i seguenti metodi affinchè 
				 * il visitatore parta dalla riva est, sosti sulla terrazza panoramica e infine raggiungia la riva ovest:
				 * EntraTrattoE, EsciTrattoE, EntraTrattoO, EsciTrattoO.
				 */
				
				m.EntraTrattoE(provenienza);	    // Il visitatore esce dalla riva est e si immette nel tratto E.
				
				sleep((int) (Math.random()*2000));  // Con questa sleep simulo il passaggio a piedi del visitatore sul tratto E.
				
				m.EsciTrattoE(provenienza);		    // Il visitatore esce dal tratto E e giunge sulla terrazza panoramica.
				
				sleep((int) (Math.random()*5000));  // Con questa sleep simulo la permanenza del visitatore sulla terrazza.
				
				m.EntraTrattoO(provenienza);		// Il visitatore esce dalla terrazza panoramica e si immette nel tratto O.
				
				sleep((int) (Math.random()*2000));  // Con questa sleep simulo il passaggio a piedi del visitatore sul tratto O.
				
				m.EsciTrattoO(provenienza);			// Il visitatore esce dal tratto O e giunge sulla riva ovest.
			} 
			else // Cioè: provenienza == OVEST.
			{
				/*
				 * Se il visitatore proviene dalla riva ovest devono essere eseguiti in ordine i seguenti metodi affinchè 
				 * il visitatore parta dalla riva ovest, sosti sulla terrazza panoramica e infine raggiungia la riva est:
				 * EntraTrattoO, EsciTrattoO, EntraTrattoE, EsciTrattoE.
				 */
				
				m.EntraTrattoO(provenienza);		// Il visitatore esce dalla riva ovest e si immette nel tratto O.
				
				sleep((int) (Math.random()*2000));  // Con questa sleep simulo il passaggio a piedi del visitatore sul tratto O.
				
				m.EsciTrattoO(provenienza);			// Il visitatore esce dal tratto O e giunge sulla terrazza panoramica.
				
				sleep((int) (Math.random()*5000));  // Con questa sleep simulo la permanenza del visitatore sulla terrazza.
				
				m.EntraTrattoE(provenienza);		// Il visitatore esce dalla terrazza panoramica e si immette nel tratto E.
				
				sleep((int) (Math.random()*2000));  // Con questa sleep simulo il passaggio a piedi del visitatore sul tratto E.
				
				m.EsciTrattoE(provenienza);			// Il visitatore esce dal tratto E e giunge sulla riva est.
			}
		} catch(InterruptedException e) { }
	}
}
