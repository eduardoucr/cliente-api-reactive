package com.demo.cliente.api.reactive.reactive.service;

import com.demo.cliente.api.reactive.reactive.model.Cliente;
import com.demo.cliente.api.reactive.reactive.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    public void create(Cliente cliente){
        clienteRepository.save(cliente).subscribe();
    }

    public Flux<Cliente> findAll(){
        return clienteRepository.findAll();
    }


}
