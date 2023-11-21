package SingleLaneBridge_COMPLETO;

public interface Bridge
{
	public void redEnter() throws InterruptedException;
	public void redExit() throws InterruptedException;
	public void blueEnter() throws InterruptedException;
	public void blueExit() throws InterruptedException;
}
