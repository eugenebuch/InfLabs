import heapq 
from collections import namedtuple

class Struct(namedtuple("Struct", ["left", "right"])):
    '''
    Binnary tree struct.
    '''
    def walk(self, code, acc):
        self.left.walk(code, acc + "0") 
        self.right.walk(code, acc + "1") 

class Pos(namedtuple("Pos", ["key"])):
    '''
    Elem. position in tree
    '''
    def walk(self, code, acc):
        code[self.key] = acc or "0"

def huffman_encode(s):
    try:
        h = []
        dic = {}
        for letter in s: 
            if letter not in dic: 
                dic[letter] = 1
            else:
                dic[letter] += 1
        dic = sorted(dic.items(), key = lambda x: x[1], reverse = True) 
        for key, value in dic:
            h.append((value, len(h), Pos(key))) 
        heapq.heapify(h)
        count = len(h)
        while len(h) > 1:
            value1, _count1, left = heapq.heappop(h) 
            value2, _count2, right = heapq.heappop(h) 
        
            heapq.heappush(h, (value1 + value2, count, Struct(left, right))) 
            count += 1 
        code = {}
        if h: 
            [(_value, _count, root)] = h
            root.walk(code, "")
        print(code)
        return code
    except:
        pass

def huffman_decode(encoded, code):
    '''
    Decoding
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
    try:
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
    except:
        pass

def decodeLZ(in_):
    try:
        output = ''
        _buffer = ''
        for i in range(len(in_)):
            _x = in_[i]
            if _x[0] == 0:
                output += _x[2]
            else:
                output += output[len(output) - _x[0]: len(output) - _x[0] + _x[1]] + _x[2]
        return output
    except:
        pass

'''
Interface
'''
def main():
    with open('fileIn.txt', 'r') as f:
        s = "".join(f.readlines()).replace("\n", "")
        code = huffman_encode(s) 
        if code:
            print('Huffman: True')
            encoded = "".join(code[key] for key in s)
            with open('fileOut.txt', 'w') as v:
                v.write('\t\t\tАЛГОРИТМ ХАФФМАНА:' + '\n' + \
                        'Начальная строка: ' + s + '\n' + \
                        'Закодированная строка: ' + encoded + '\n' + \
                        'Декодированная строка: ' + huffman_decode(encoded, code) + '\n' + \
                        'Коэффициент сжатия данных: {:.2%}'.format(len(s) / len(encoded)) + '\n')
                for key in sorted(code):
                    v.write("'{}': {}\n".format(key, code[key]))
                v.write('\n\n')
        else:
            print('Huffman False')
        
        with open('fileOut.txt', 'a') as v:
            code = encodeLZ(s)
            if code:
                print('LZ: True')
                coded = ''
                for i in range(len(code)):
                     coded += ('(' + str(code[i][0]) + ', ' + str(code[i][1]) + ', ' + code[i][2] + ')')
                v.write('\t\t\tАЛГОРИТМ ЛЕМПЕЛЯ-ЗИВА:' + '\n' + \
                        'Начальная строка: ' + s + '\n' + \
                        'Закодированная строка: ' + coded + '\n' + \
                        'Декодированная строка: ' + decodeLZ(code) + '\n' + \
                        'Коэффициент сжатия: {:.2%}'.format(len(s)/len(code)))
            else:
                print('LZ: False')
main()


