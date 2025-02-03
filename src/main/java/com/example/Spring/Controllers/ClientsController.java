package com.example.Spring.Controllers;

import com.example.Spring.models.Client;
import com.example.Spring.models.ClientDto;
import com.example.Spring.repositories.ClientRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping({"", "/"})
    public String getClients(Model model) {
        model.addAttribute("clients", clientRepository.findAll(Sort.by(Sort.Direction.DESC, "id")));
        return "clients/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("clientDto", new ClientDto());
        return "clients/create";
    }

    @PostMapping("/create")
    public String createClient(@Valid @ModelAttribute ClientDto clientDto, BindingResult result) {
        if (result.hasErrors()) {
            return "clients/create";
        }

        Client client = new Client();
        convertDtoToEntity(clientDto, client);
        clientRepository.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client ID: " + id));

        ClientDto clientDto = new ClientDto();
        convertEntityToDto(client, clientDto);
        model.addAttribute("clientDto", clientDto);
        return "clients/edit";
    }

    @PostMapping("/{id}/edit")
    public String updateClient(@PathVariable Integer id, @Valid @ModelAttribute ClientDto clientDto, 
                              BindingResult result) {
        if (result.hasErrors()) {
            return "clients/edit";
        }

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client ID: " + id));
        convertDtoToEntity(clientDto, client);
        clientRepository.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/{id}/delete")
    public String deleteClient(@PathVariable Integer id) {
        clientRepository.deleteById(id);
        return "redirect:/clients";
    }

    private void convertDtoToEntity(ClientDto dto, Client entity) {
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        entity.setStatus(dto.getStatus());
    }

    private void convertEntityToDto(Client entity, ClientDto dto) {
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        dto.setAddress(entity.getAddress());
        dto.setStatus(entity.getStatus());
    }
}