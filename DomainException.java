package model.exceptions;

public class DomainException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	/* eu fiz isso daqui que para permitir que eu possa instanciar " DomainException " minha escessao personalizada passando 
	 * uma msg para essa msg entao vai ficar armazenada dentro da minha escessao.   */
	public DomainException(String msg) {
		super(msg);
	}
	
}
