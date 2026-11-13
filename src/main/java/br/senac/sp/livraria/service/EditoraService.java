package br.senac.sp.livraria.service;

import br.senac.sp.livraria.model.Editora;
import br.senac.sp.livraria.repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {

    private EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository) {

        this.editoraRepository = editoraRepository;
    }

    public Editora salvar (Editora editora){
        return  editoraRepository.save(editora);
    }

    public List<Editora> listarLivros() {

        return editoraRepository.findAll();
    }

    public Optional<Editora> buscarPorId(int id) {

        return editoraRepository.findById(id);
    }

    public boolean excluirEditoraPorId(int id) {
        //Verificar se o livro existe no banco de dados
        Optional<Editora> editoraExcluir = editoraRepository.findById(id);

        //Se o livro exister ele será apagado, caso contrário, retornamos false
        if (editoraExcluir.isPresent()) {
            editoraRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Editora atualizar(Editora novaEditora) {

        Optional<Editora> editoraAtual = editoraRepository.findById(novaEditora.getId());

        if (editoraAtual.isPresent()) {
            return editoraRepository.save(novaEditora);
        }

        return null;
    }


    public List<Editora> findByNomeStartingWith(String nome) {
        return editoraRepository.findByNomeStartingWith(nome);
    }


}
