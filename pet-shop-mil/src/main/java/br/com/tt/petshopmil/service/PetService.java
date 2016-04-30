package br.com.tt.petshopmil.service;

import java.util.List;

import br.com.tt.petshopmil.dao.PetDao;
import br.com.tt.petshopmil.model.Pet;

public class PetService {
	
	public List<Pet> consultar(Pet pet){
		List<Pet> resultado = null;
		if (pet != null && pet.getNome() != null){
			
			String nome = pet.getNome();		
			nome = "'%" + nome+ "%'";			
			pet.setNome(nome);
			
			PetDao petDao = new PetDao();
			petDao.consultar(pet);
			resultado = petDao.consultar(pet);			
		}
		return resultado;		
	}
}
