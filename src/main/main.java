package main;

import model.AdocaoDAO;
import model.AnimalDAO;
import model.IDAO;
import model.PessoaDAO;
import dto.Adocao;
import dto.Animal;
import dto.Pessoa;

public class main {

	public static IDAO<Adocao> adocaoDao = new AdocaoDAO();
	public static IDAO<Pessoa> pessoaDao = new PessoaDAO();
	public static AnimalDAO animalDao = new AnimalDAO();
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Animais Por instituicao");
			//System.out.println(pessoaDao.list());
			for (Animal animal : animalDao.listByInstituicao("123", "") ) {
				System.out.println(animal.getNomeAdotivo());
			}
			
			
			System.out.println("Animais nao adotados por tipo");
			//System.out.println(pessoaDao.list());
			for (Animal animal : animalDao.listNaoAdotadosByTipo("gato") ) {
				System.out.println(animal.getNomeAdotivo());
			}
			
			
			
			
			
			
			
		} catch (Exception e) {
			
			System.out.println("ERRO: " + e.getMessage());
			e.printStackTrace();
		}
		
		

	}

}
