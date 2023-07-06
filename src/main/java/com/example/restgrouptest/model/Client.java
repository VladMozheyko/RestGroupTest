package com.example.restgrouptest.model;

public class Client {           // Создаем класс модели(Entity). Обычный, старый добрый Java объект - POJO
    private Integer id;         // Поля класса
    private String name;
    private String email;
    private String phone;

    // Набор геттеров и сеттеров
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
