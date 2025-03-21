package br.senai.sp.escolamvc.controller;

import br.senai.sp.escolamvc.model.Aluno;
import br.senai.sp.escolamvc.repository.AlunoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping("/salvar")
    public String salvar(@Valid Aluno aluno, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()) {
            return "aluno/inserir";
        }
     alunoRepository.save(aluno);
     attributes.addFlashAttribute("mensagem","Aluno salvo com sucesso!");
     return "redirect:/aluno/novo";
    }

    @GetMapping("/novo")
    public String novo(Model model){
        model.addAttribute("aluno", new Aluno());
        return "aluno/inserir";
    }

    @GetMapping("/")
    public String listar(Model model){
        model.addAttribute("alunos", alunoRepository.findAll());
        return "aluno/listagem";
    }

    /*
      Método para excluir um aluno
     */


    /*

     */
    @GetMapping("/alterar/{id}")
    public String alterar(@PathVariable("id") Long id, Model model) {

        // Busca o aluno no banco de dados
        Aluno aluno = alunoRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("ID inválido"));

        // Adiciona o aluno no objeto model para ser carregado no formulário
        model.addAttribute("aluno", aluno);

        // Retorna o template aluno/alterar.html
        return "aluno/alterar";
    }


}
