# Note Management System

## Описание pet-проекта

Note Management System - это веб-приложение,для управления заметками. Пользователи могут создавать, редактировать и удалять свои заметки, а также осуществлять поиск по заголовку и категории. Это приложение разработано с использованием технологий Spring Boot и Thymeleaf.

## Функциональность

- **Авторизация и аутентификация пользователей**: Пользователи могут зарегистрироваться и войти в систему для доступа к своим заметкам.
- **Управление заметками**:
    - Создание новых заметок
    - Редактирование существующих заметок
    - Удаление заметок
- **Поиск заметок**:
    - Поиск по заголовку заметки
    - Фильтрация по категории

## Технологии

- **Backend**:
    - Java
    - Spring Boot
    - Spring Security
    - Spring Data JPA

- **Frontend**:
    - Thymeleaf (шаблонизация)

- **База данных**:
    - H2 Database (для разработки и тестирования)
    - Можно легко переключиться на другие СУБД с помощью Spring Data JPA.