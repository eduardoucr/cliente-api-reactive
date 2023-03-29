package com.demo.cliente.api.reactive.reactive.api;



import com.demo.cliente.api.reactive.reactive.model.Cliente;
import com.demo.cliente.api.reactive.reactive.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/v1/api/cliente")
public class ClienteApi {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public void create(@RequestBody Cliente cliente) {
        clienteService.create(cliente);
    }


    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Cliente> findAll() {
        return clienteService.findAll();
    }
}
