package academia.demo.academia.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import academia.demo.academia.model.academiaModel;
import academia.demo.academia.repository.academiaRepository;


@Service
public class academiaService {
	
	@Autowired
    private academiaRepository academiaRepository;

    // Método para criar uma nova academia
    public academiaModel createAcademia(academiaModel academia) {
        if (academia.getId() == null) {
            academia.setId(UUID.randomUUID());  // Gerar ID único se não for fornecido
        }
        return academiaRepository.save(academia);  // Salvar no banco de dados
    }

    // Método para buscar uma academia por ID
    public academiaModel getAcademiaById(UUID id) {
        Optional<academiaModel> academia = academiaRepository.findById(id);
        return academia.orElse(null);  // Retorna null se a academia não for encontrada
    }

    // Método para obter todas as academias
    public List<academiaModel> getAllAcademias() {
        return academiaRepository.findAll();  // Retorna todas as academias do banco de dados
    }

}
