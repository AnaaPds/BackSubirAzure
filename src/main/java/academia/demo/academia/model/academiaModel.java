package academia.demo.academia.model;

import java.util.UUID;

import academia.demo.academia.record.academiaDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "academia")
public class academiaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String nome;
	private String idade;
	private String email;
	private String modalidade;
	private String url;

	public academiaModel() {

	}

	public academiaModel(String nome, String idade, String email, String modalidade, String url) {
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.modalidade = modalidade;
		this.url = url;
	}

	public academiaModel(academiaDto dto) {
		this.nome = dto.nome();
		this.idade = dto.idade();
		this.email = dto.email();
		this.modalidade = dto.modalidade();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url  = url;
	}
	}
