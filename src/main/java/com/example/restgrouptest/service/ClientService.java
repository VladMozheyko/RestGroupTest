package com.example.restgrouptest.service;

import com.example.restgrouptest.model.Client;

import java.util.List;

public interface ClientService {              // Создаем интерфейс(контракт) для операций CRUD

    void create(Client client);              // Метод для создания клиента

    List<Client> readAll();                  // Метод для чтения всех клиентов


    Client read(int id);                    // Метод для чтения конкретного клиента

    boolean update(Client client, int id); // Меняем клиента с id на client - т.е. ищем по id клиента и меняем его на объект client, которого передали в метод
    boolean delete(int id);                // Метод для удаления клиента
}
