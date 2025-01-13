package group.aca.api.Service;

import group.aca.api.Entity.Client;
import group.aca.api.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Integer id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client createOrUpdateClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }
}
