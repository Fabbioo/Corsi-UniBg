package Eccezioni;

// Eccezione che si verifica quando si cerca di creare una sfida con orario non ammesso
public class OrarioNonValidoException extends Exception
{
	public OrarioNonValidoException(String msg)
	{
		super(msg);
	}
}
