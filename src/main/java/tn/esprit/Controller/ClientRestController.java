package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.entities.Client;
import tn.esprit.service.ClientService;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class ClientRestController {

@Autowired
ClientService clientService;

//http://localhost:8081/SpringMVC/servlet/retrieveallclients
@GetMapping("/retrieveallclients")
public List<Client> getClients() {
List<Client> listClients = clientService.retrieveAllClient();
return listClients;
}

//http://localhost:8081/SpringMVC/servlet/retrieveClient/1
@GetMapping("/retrieveClient/{clientId}")
public Client retrieveClient(@PathVariable("clientId") Long clientId) {
return 	clientService.retrieveClient(clientId);
}

//http://localhost:8081/SpringMVC/servlet/addClients
@PostMapping("/addClients")
@ResponseBody
public Client addClient(@RequestBody Client c)
{
Client client = clientService.addClient(c);
return client;
}


//http://localhost:8081/SpringMVC/servlet/modifyClient
@PutMapping("/modifyClient")
@ResponseBody
public Client modifyClient(@RequestBody Client client) {
return clientService.updateClient(client);
}




//http://localhost:8089/SpringMVC/servlet/removeClient/4
@DeleteMapping("/removeClient/{clientId}")
@ResponseBody
public void removeClient(@PathVariable("clientId") Long clientId) {
clientService.deleteClient(clientId);
}









}