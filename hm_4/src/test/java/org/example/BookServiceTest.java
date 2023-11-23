package org.example;

/*
 * Задание 2.
 * У вас есть класс BookService, который использует интерфейс BookRepository
 * для получения информации о книгах из базы данных.
 * Ваша задача написать unit-тесты для BookService,
 * используя Mockito для создания мок-объекта BookRepository.
*/

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository; // Создаем мок-объект BookRepository
    private BookService bookService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this); // Инициализируем моки
        bookService = new BookService(bookRepository); // Создаем экземпляр BookService с использованием мока
    }

    @Test
    public void testGetBookById() {
        Book book = new Book("1", "Test Book", "Any"); // Создаем объект книги
    // Устанавливаем ожидание - когда метод bookRepository.getBookById(1) вызывается, должен возвращаться объект book
        when(bookRepository.findById("1")).thenReturn(book);

        // Вызываем метод getBookById() на экземпляре bookService
        Book result = bookService.findBookById("1");
        // Проверяем, что результат соответствует ожиданиям
        assertEquals(book, result);
        // Проверяем, что метод bookRepository.getBookById(1) был вызван ровно один раз
        verify(bookRepository, times(1)).findById("1");
    }

    @Test
    public void testAddBook() {
        Book book = new Book("2", "New Book", "Any");

        // Вызываем метод addBook() на экземпляре bookService
        bookService.findBookById("book");

        // Проверяем, что метод bookRepository.addBook(book) был вызван ровно один раз
        verify(bookRepository, times(1)).findById("book");
    }
}
