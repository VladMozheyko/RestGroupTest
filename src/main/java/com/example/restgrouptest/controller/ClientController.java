package com.example.restgrouptest.controller;

import com.example.restgrouptest.model.Client;
import com.example.restgrouptest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {  // Котроллер, отвечающий за общение с клиентом

    private final ClientService clientService;  // Объект для полуения логики управления

    @Autowired
    public ClientController(ClientService clientService) { // Получаем конкретную логику управления из бина
        this.clientService = clientService;
    }

    @PostMapping("/clients") // Указываю запрос и место, к которому обращаемся
    public ResponseEntity<?>create(@RequestBody Client client){ // Получаем тело запроса
        clientService.create(client);  // Добавляем клиента
        return new ResponseEntity<>(HttpStatus.CREATED);// Возвращаем статус
    }

    @GetMapping(value = "/clients") // Указываем запрос и место, к которому обращаемся
    public ResponseEntity<List<Client>> read(){ // Метод для обработки запроса
        final List<Client> clients = clientService.readAll();  // Получаем всех клиентов, list final потому что мы явно запрещаем его менять
        return clients != null &&  !clients.isEmpty()  // Проверяем есть ли списко клиентов, затем, если он не пустой, возвращаем статус Ok,
                ? new ResponseEntity<>(clients, HttpStatus.OK) // в противном случае статус NOTFOUND
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
