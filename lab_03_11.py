import heapq #Кучи. Почему они? Потому что благодаря им можно легко обратиться к наименьшему элементу массива (или сразу к нескольким).
from collections import namedtuple

#ГЛАВНЫЙ СМЫСЛ АЛГОРИТМА ХАФФМАНА - НИ ОДИН СИМВОЛ НЕ МОЖЕТ БЫТЬ ПРЕФИКСОМ ДРУГОГО!
#ГЛАВНЫЙ СМЫСЛ АЛГОРИТМА LZ77 - СКОЛЬЗЯЩЕЕ ОКНО ПО ИСХОДНОЙ СТРОКЕ!

class Struct(namedtuple("Struct", ["left", "right"])):
    '''
    Двоичное дерево. Выбор между правой (1) и левой (0) веткой. Получает данные для заполнения дерева с класса Leaf.
    '''
    def walk(self, code, acc):
        self.left.walk(code, acc + "0") #Основной момент кодировки, бинарное представление элементов, а именно вписывание
        self.right.walk(code, acc + "1") #В код элемента "0" или "1" в зависимости от пути(выборы между право и лево) от корня дерева до элемента

class Pos(namedtuple("Pos", ["key"])):
    '''
    Определяет позицию элемента в дереве (в прямом смысле)
    '''
    def walk(self, code, acc):
        code[self.key] = acc or "0"

def huffman_encode(s):
    try:
        h = []
        dic = {}
        for letter in s: #Счетчик вхождений элемента в строку для словаря
            if letter not in dic: 
                dic[letter] = 1
            else:
                dic[letter] += 1
        dic = sorted(dic.items(), key = lambda x: x[1], reverse = True) #Сортировка словаря по значению
        for key, value in dic:
            h.append((value, len(h), Pos(key))) #Отправление элемента на позиционирование в дереве
        heapq.heapify(h)
        count = len(h)
        while len(h) > 1:
            value1, _count1, left = heapq.heappop(h) 
            value2, _count2, right = heapq.heappop(h) 
        
            heapq.heappush(h, (value1 + value2, count, Struct(left, right))) #Непосредственный алгоритм Хаффмана (попарное "Склеивание" элементов начиная с меньшей пары)
            count += 1 #По факту - двоичное дерево в текстовом формате
        code = {}
        if h: #Проверка дерева на целостность и законченность 
            [(_value, _count, root)] = h
            root.walk(code, "")
        
        return code
    except:
        pass

def huffman_decode(encoded, code):
    '''
    Однозначное декодирование. Ничего интересного, просто обращение к ключу и расшифровка по первой попавшейся комбинации.
    '''
    try:
        sx = []
        enc_key = ""
        for key in encoded:
            enc_key += key
            for dec_key in code:
                if code.get(dec_key) == enc_key:
                    sx.append(dec_key)
                    enc_key = ""
                    break
        return "".join(sx)
    except:
        pass

def encodeLZ(in_):
    history = ''
    _buffer = ''
    output = []
    letter = 0
    while 1:
        if in_[letter] in history:
            for i in range(letter, len(in_)):
                _buffer += in_[i]
                if _buffer not in history:
                    break
            cnt = letter
            if len(_buffer[:-1]) == 0: #костыль
                cnt = 0
            output.append([cnt - history.find(_buffer[:-1]), len(_buffer[:-1]), \
                            _buffer[-1]])
        else:
            history += in_[letter]
            output.append([0, 0, in_[letter]])
        history += _buffer
        letter += len(_buffer[:-1])
        _buffer = ''
        if letter == len(in_[:-1]):
            break
        letter += 1
    return output

def decodeLZ(in_):
    output = ''
    _buffer = ''
    for i in range(len(in_)):
        _x = in_[i]
        if _x[0] == 0:
            output += _x[2]
        else:
            output += output[len(output) - _x[0]: len(output) - _x[0] + _x[1]] + _x[2]
    return output

'''
Интерфейс
'''
def main():
    with open('fileIn.txt', 'r') as f:
        s = "".join(f.readlines()).replace("\n", "")
        code = huffman_encode(s) #Словарь с кодом каждого символа
        if code:
            print('Huffman: True')
            print('LZ: True')
            encoded = "".join(code[key] for key in s)
            with open('fileOut.txt', 'w') as v:
                v.write('\t\t\tАЛГОРИТМ ХАФФМАНА:' + '\n' + \
                        'Начальная строка: ' + s + '\n' + \
                        'Закодированная строка: ' + encoded + '\n' + \
                        'Декодированная строка: ' + huffman_decode(encoded, code) + '\n' + \
                        'Коэффициент сжатия данных: ' + str(len(encoded) / len(s)) + '\n')
                for key in sorted(code):
                    v.write("'{}': {}\n".format(key, code[key]))
                v.write('\n\n')
                code = encodeLZ(s)
                coded = ''
                for i in range(len(code)):
                    coded += ('(' + str(code[i][0]) + ', ' + str(code[i][1]) + ', ' + code[i][2] + ')')
                v.write('\t\t\tАЛГОРИТМ ЛЕМПЕЛЯ-ЗИВА:' + '\n' + \
                        'Начальная строка: ' + s + '\n' + \
                        'Закодированная строка: ' + coded + '\n' + \
                        'Декодированная строка: ' + decodeLZ(code) + '\n' + \
                        'Коэффициент сжатия: ' + str(len(code)/len(s)))
        else:
            print('Huffman False')
            print('LZ: False')
                        
main()
