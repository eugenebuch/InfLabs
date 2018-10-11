import heapq
from collections import namedtuple

class Encoder:
    def encode(self, in_):
        self.input = in_
    def decode(self, in_):
        self.input = in_

class HuffmanEncoder(Encoder):
    """Кодирование Хаффмана"""
    def __init__(self, in_):
        self.input = in_
        self.code, self.encoded = self.encode()
        self.compressionCoef = 0
        self.decoded = self.decode()

    def __setCompressionCoef(self):
        self.compressionCoef = len(self.input)/len(self.encoded)
        return self.compressionCoef

    def getCompressionCoef(self):
        return self._HuffmanEncoder__setCompressionCoef()
        
    class Struct(namedtuple("Struct", ["left", "right"])):
        def walk(self, code, acc):
            self.left.walk(code, acc + "0") 
            self.right.walk(code, acc + "1") 

    class Pos(namedtuple("Pos", ["key"])):
        def walk(self, code, acc):
            code[self.key] = acc or "0"
            
    def encode(self):
        def huffman_encode(s):
            h = []
            dic = {}
            for letter in s: 
                if letter not in dic: 
                    dic[letter] = 1
                else:
                    dic[letter] += 1
            dic = sorted(dic.items(), key = lambda x: x[1], reverse = True) 
            for key, value in dic:
                h.append((value, len(h), self.Pos(key))) 
            heapq.heapify(h)
            count = len(h)
            while len(h) > 1:
                value1, _count1, left = heapq.heappop(h) 
                value2, _count2, right = heapq.heappop(h) 
                heapq.heappush(h, (value1 + value2, count, HuffmanEncoder.Struct(left, right)))
                count += 1 
            code = {}
            if h: 
                [(_value, _count, root)] = h
                root.walk(code, "")
            return code
        return (huffman_encode(self.input), \
               "".join(huffman_encode(self.input)[key] for key in self.input))

    def decode(self):
        def huffman_decode(encoded, code):
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
        return huffman_decode(self.encoded, self.code)

class LZEncoder(Encoder):
    def __init__(self, in_):
        self.input = in_

    def __setCompressionCoef(self):
        self.compressionCoef = len(self.input)/len(self.encode())
        return self.compressionCoef

    def getCompressionCoef(self):
        return self._LZEncoder__setCompressionCoef()
    
    def encode(self):
        in_ = self.input
        history = ''
        _buffer = ''
        coded = ''
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
        for i in range(len(output)):
            if output[i][2] == '\n': coded += ('(' + str(output[i][0]) + ',' + str(output[i][1]) + ',' + '\\n' + ')')
            else: coded += ('(' + str(output[i][0]) + ',' + str(output[i][1]) + ',' + output[i][2] + ')')
        self.encoded = output
        return coded

    def decode(self):
        in_ = self.encoded
        output = ''
        _buffer = ''
        for i in range(len(in_)):
            _x = in_[i]
            if _x[0] == 0:
                output += _x[2]
            else:
                output += output[len(output) - _x[0]: len(output) - _x[0] + _x[1]] + _x[2]
        return output


def main():
    inp = """Python is a widely used high-level programming language for
general-purpose programming, created by Guido van Rossum and
first released in 1991."""
    print("\t\t\tИСХОДНЫЙ ТЕКСТ:\n" + inp + "\n")

    print("\t\t\tМЕТОД ХАФФМАНА:")
    HuffCode = HuffmanEncoder(inp)
    print("\nЗАКОДИРОВАННЫЙ ТЕКСТ: " + HuffCode.encoded)
    print("\nДЕКОДИРОВАННЫЙ ТЕКСТ: " + HuffCode.decoded)
    print("\nКОЭФ. СЖАТИЯ: {:.2%}".format(HuffCode.getCompressionCoef()))
    print("\nКОД КАЖДОГО СИМВОЛА:")
    for key in sorted(HuffCode.code): 
        if key == '\n': print("'{}': {}".format("\\n", HuffCode.code['\n'])) #костыль для адекватного отобр. переноса
        else: print("'{}': {}".format(key, HuffCode.code[key]))

    print("\n\t\t\tМЕТОД ЛЕМПЕЛЯ-ЗИВА 77:")
    LZCode = LZEncoder(inp)
    print("\nЗАКОДИРОВАННЫЙ ТЕКСТ: " + LZCode.encode())
    print("\nДЕКОДИРОВАННЫЙ ТЕКСТ: " + LZCode.decode())
    print("\nКОЭФ. СЖАТИЯ: {:.2%}".format(LZCode.getCompressionCoef()))

main()
input("\n\nНажмите Enter чтобы выйти...")
