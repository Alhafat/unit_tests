import random

import pytest
from Compare import Compare


@pytest.fixture
def list_1():
    return [random.randint(0, 10) for _ in range(10)]


@pytest.fixture
def list_2():
    return [random.randint(0, 10) for _ in range(10)]


def test_init(list_1, list_2):
    """Проверка корректной инициализации класса"""
    nums_list = Compare(list_1, list_2)
    assert nums_list.list_1 == list_1
    assert nums_list.list_2 == list_2


def test_first_average_more(list_1, list_2, capfd):
    """Проверка сообщения когда среднее значение первого списка больше второго"""
    nums_list = Compare(list_1, list_2)
    nums_list.compare_average_value()
    captured = capfd.readouterr()
    assert captured.out.strip() == 'Первый список имеет большее среднее значение'


def test_second_average_more(list_2, list_1, capfd):
    """Проверка сообщения когда среднее значение второго списка больше первого"""
    nums_list = Compare(list_1, list_2)
    nums_list.compare_average_value()
    captured = capfd.readouterr()
    assert captured.out.strip() == 'Второй список имеет большее среднее значение'


def test_equal_averages(list_1, capfd):
    """Проверка сообщения когда средние значения списков равны"""
    nums_list = Compare(list_1, list_1)
    nums_list.compare_average_value()
    captured = capfd.readouterr()
    assert captured.out.strip() == 'Средние значения равны'
