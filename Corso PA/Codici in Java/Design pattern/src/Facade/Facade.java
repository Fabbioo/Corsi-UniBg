package Facade;

/*
 * Il design pattern Facade viene utilizzato quando si hanno oggetti composti da tante componenti.
 * Una classe implementata secondo questo pattern si propone di facilitare l'accesso tramite un
 * singolo oggetto e un singolo metodo ad un più vasto set di oggetti e metodi.
 * Facade si legge "faseid".
 * 
 * GUARDA LE IMMAGINI PUBBLICATE SU WIKIPEDIA PER CHIARIRE BENE IL CONCETTO.
 */

/*
 * Nota per il proseguo: implemento sia una classe Facade senza ricorrere al pattern Singleton
 * sia una classe Facade ricorrendo al pattern Singleton per mettere in evidenza la differenza
 * nell'implementazione tra i due approcci.
 */

class CPU {
	void exec() {
		System.out.println("Metodo exec()");
	}
}

class Memory {
	void load() {
		System.out.println("Metodo load()");
	}
}

class HardDrive {
	void read() {
		System.out.println("Metodo read()");
	}
}

class ComputerFacade {

	private CPU processor;
	private Memory ram;
	private HardDrive hd;

	ComputerFacade() {
		this.processor = new CPU();
		this.ram = new Memory();
		this.hd = new HardDrive();
	}

	void start() {
		processor.exec();
		ram.load();
		hd.read();
	}
}

class ComputerFacadeSingleton {

	static private ComputerFacadeSingleton computerFacadeSingleton = null;

	private CPU processor;
	private Memory ram;
	private HardDrive hd;

	private ComputerFacadeSingleton() {
		this.processor = new CPU();
		this.ram = new Memory();
		this.hd = new HardDrive();
	}

	static ComputerFacadeSingleton creaComputerFacadeSingleton() {
		if (computerFacadeSingleton == null)
			computerFacadeSingleton = new ComputerFacadeSingleton();
		return computerFacadeSingleton;
	}

	void start() {
		processor.exec();
		ram.load();
		hd.read();
	}
}

public class Facade {

	public static void main(String[] args) {

		ComputerFacade cf = new ComputerFacade();
		cf.start();

		System.out.println();

		ComputerFacadeSingleton cfs = ComputerFacadeSingleton.creaComputerFacadeSingleton();
		cfs.start();
	}
}
