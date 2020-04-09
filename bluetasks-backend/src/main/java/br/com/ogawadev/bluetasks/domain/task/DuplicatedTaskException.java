package br.com.ogawadev.bluetasks.domain.task;

@SuppressWarnings("serial")
public class DuplicatedTaskException extends Exception{

	public DuplicatedTaskException(String message) {
		super(message);
	}

	
}
