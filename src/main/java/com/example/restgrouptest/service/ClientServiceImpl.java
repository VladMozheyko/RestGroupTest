package com.example.restgrouptest.service;

import com.example.restgrouptest.model.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component                         // Этой аннотацией делаем класс пригодным для создания бинов
public class ClientServiceImpl implements ClientService{ // Сервис, в нем реализована бизнес-логика(задача, обработка) проекта

    // Хранилище клиентов
    private static final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>(); // Коллекция, где каждый элемент хранится по ключу

    // Переменная для генерации ID клиента
    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();        // ID обязательно должен быть уникальным
    @Bean                         // Само создание бина
    ClientServiceImpl clientService(){
        ClientServiceImpl clientService = new ClientServiceImpl(); // Создем объект класса
        return clientService; // Возвращаем объект класса
    }

    @Override
    public void create(Client client) {
        final int id = CLIENT_ID_HOLDER.incrementAndGet(); // Аналог автоинкремента в sql, просто присваиваем следующий номер id клиента
        client.setId(id);                                  // Присваиваем клиенту id
        CLIENT_REPOSITORY_MAP.put(id, client);             // Добавляем клиента по id в HashMap
    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());  // Записываем в ArrayList все значения HashMap и возвращаем его - получаем всех клиентов
    }

    @Override
    public Client read(int id) {

        return CLIENT_REPOSITORY_MAP.get(id);  // Вовзвращаем клиента по id
    }

    @Override
    public boolean update(Client client, int id) {
        if(CLIENT_REPOSITORY_MAP.containsKey(id)){  // Проверяем наличие элемента в HashMap, если он есть, заменяем его и возвращаем true
            client.setId(id);                       // Устанавливаем id клиенту
            CLIENT_REPOSITORY_MAP.put(id, client);  // Заменяем сам элемент
            return true;// Возвращаем true
        }
        return false;// Если элемента нет, возвращаем false
    }

    @Override
    public boolean delete(int id) {
        return CLIENT_REPOSITORY_MAP.remove(id) != null;     // Метод remove кроме удаления возвращает ссылку, если она равна null, то сравнение выдаст false и наоборот, запись эквивалента сравнению 3 == 5 => false
    }
}
