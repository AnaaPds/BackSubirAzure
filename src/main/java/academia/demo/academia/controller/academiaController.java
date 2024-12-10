package academia.demo.academia.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academia.demo.academia.model.academiaModel;
import academia.demo.academia.record.academiaDto;
import academia.demo.academia.repository.academiaRepository;
import academia.demo.academia.service.academiaService;

@RestController
@RequestMapping("/academias")
@CrossOrigin
public class academiaController {

    @Autowired
    private academiaService academiaService;
    @Autowired
    private academiaRepository repo;

    @PostMapping("/post")
    public ResponseEntity<?> createAcademia(@RequestBody academiaDto academia) {
    	System.out.println("Dados recebidos pelo servidor: ");
        System.out.println("Nome: " + academia.nome());
        System.out.println("Idade: " + academia.idade());
        System.out.println("Email: " + academia.email());
        System.out.println("Modalidade: " + academia.modalidade());
        System.out.println("URL: " + academia.url());

        academiaModel aca = new academiaModel(academia);
        academiaModel saved = repo.save(aca);

        System.out.println("Dados salvos no banco: ");
        System.out.println(saved);

        return ResponseEntity.ok(saved);
    }

    // Endpoint para buscar uma academia por ID
    @GetMapping("/{id}")
    public academiaModel getAcademiaById(@PathVariable UUID id) {
        academiaModel academia = academiaService.getAcademiaById(id);
        if (academia != null) {
            return academia;
        } else {
            throw new RuntimeException("Academia não encontrada");
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllAcademias() {
        return ResponseEntity.ok(academiaService.getAllAcademias());
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAcademia(@PathVariable UUID id, @RequestBody academiaDto academia) {
    	 academiaModel existingAcademia = academiaService.getAcademiaById(id);

    	    if (existingAcademia == null) {
    	        return ResponseEntity.notFound().build();
    	    }

    	    // Atualizando os dados
    	    existingAcademia.setNome(academia.nome());
    	    existingAcademia.setEmail(academia.email());
    	    existingAcademia.setIdade(academia.idade());
    	    existingAcademia.setModalidade(academia.modalidade());
    	    existingAcademia.setUrl(academia.url());

    	    academiaModel updatedAcademia = repo.save(existingAcademia);
    	    return ResponseEntity.ok(updatedAcademia);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAcademia(@PathVariable UUID id) {
        academiaModel academia = academiaService.getAcademiaById(id);

        if (academia == null) {
            return ResponseEntity.notFound().build();
        }

        // Deleta a academia
        repo.delete(academia);
        return ResponseEntity.noContent().build(); // Responde com status HTTP 204 (Sem conteúdo)
    }}
