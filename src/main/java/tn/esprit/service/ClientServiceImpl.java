package tn.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Categorieclient;
import tn.esprit.entities.Client;
import tn.esprit.entities.Profession;
import tn.esprit.repository.ClientRepository;
@Service
public class ClientServiceImpl implements ClientService{

	
	@Autowired
	ClientRepository clientrepository;
	
	@Override
	public List<Client> retrieveAllClient() {
        List <Client> clients = (List<Client>) clientrepository.findAll();
		return clients;
	}

	@Override
	public Client addClient(Client client) {
		return clientrepository.save(client);
	}


	@Override
	public void deleteClient(Long id) {
		clientrepository.deleteById(id);
		
	}

	@Override
	public Client updateClient(Client client) {
		if (clientrepository.existsById(client.getIdclient())){
			Client r = clientrepository.findById(client.getIdclient()).get();
			r.setEmail(client.getEmail());
			r.setNom(client.getNom());
			r.setPrenom(client.getPrenom());
			r.setPassword(client.getPassword());
			clientrepository.save(r);
		}
		
		return client;
	}

	@Override
	public Client retrieveClient(Long i) {
		Client c =clientrepository.findById(i).get();
		return c;
	}

	@Override
	public List<Client> retrieveClientsByProfession(Profession p) {

		return clientrepository.retrieveClientsByProfession(p);
	}

	@Override
	public long updateClientCategorieByProfession(Categorieclient categorieClient, Profession profession) {
		
		return clientrepository.updateClientCategorieByProfession(categorieClient, profession);
	}

	@Override
	public long deleteClientByCategorieClientAndProfessionb(Categorieclient categorieclient, Profession profession) {
		
		return clientrepository.deleteClientByCategorieClientAndProfession(categorieclient, profession);
	}
    
}
