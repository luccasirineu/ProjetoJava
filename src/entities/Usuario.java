package entities;

public class Usuario {

	private String nome;
	private String email;
	private Integer idade;
	private Double altura;
	
	
	public Usuario(String nome, String email, Integer idade) {
		
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		
	}

	
	

	public String getNome() {
		return nome;
	}




	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", idade=" + idade + ", altura=" + altura + "]";
	}
	
	
	
	
	
	
}
