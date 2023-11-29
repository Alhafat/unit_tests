class Compare:
    def __init__(self, list_1: list[int], list_2: list[int]):
        self.list_1 = list_1
        self.list_2 = list_2

    def compare_average_value(self) -> None:
        av_1, av_2 = self.average_value()
        if av_1 > av_2:
            print("Первый список имеет большее среднее значение")
        elif av_1 < av_2:
            print("Второй список имеет большее среднее значение")
        else:
            print("Средние значения равны")

    def average_value(self) -> tuple:
        av_1 = sum(self.list_1) / len(self.list_1)
        av_2 = sum(self.list_2) / len(self.list_2)
        return av_1, av_2
