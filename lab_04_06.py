import random
# test: 100100101110001
# test: 10011010

class HammingEncoder:
    def __init__(self, string, dataBits):
        self.dataBits = dataBits
        self.string = string
        self.controlBits = HammingEncoder.control(self)
    
    def control(self):
        for m in range(2, self.dataBits + 2):
            if 2 ** m - m >= self.dataBits + 1:
                return m

    def routine(self):
        self.contr = []
        for i in range(self.controlBits):
            _ = [' ']
            _count = 0
            for j in range(2 ** i - 1):
                _.append('0')
            for k in range(2 ** i, len(self.encoded) + 1):
                if (k // (2 ** i)) % 2 == 1:
                    _.append('1')
                else:
                    _.append('0')
            _ = _[1:]
            for j in range(len(_)):
                _count += int(self.encoded[j]) * int(_[j])
            self.contr.append(str(_count % 2))
    
    def encode(self):
        self.encoded = '00' + self.string[:]
        for i in range(self.controlBits):
            if i > 1: self.encoded = self.encoded[:2**i - 1] + '0' + self.encoded[2**i - 1:]
        self.encoded = list(self.encoded)
        HammingEncoder.routine(self)
        for i in range(len(self.contr)):
            self.encoded[2**i - 1] = str(self.contr[i])
        self.encoded = ''.join(self.encoded)
        return self.encoded
    
    def decode(self):
        self.controlBits = self.dataBits
        self.encoded = list(self.string[:])
        HammingEncoder.routine(self)
        self.contr.reverse()
        self.mistake = int(''.join(self.contr), 2)
        self.decoded = list(self.string[:]) 
        if self.string[self.mistake - 1] == '0':
            self.decoded[self.mistake - 1] = '1'
        else: self.decoded[self.mistake - 1] = '0'
        return (''.join(self.decoded), self.mistake)
    
def main():
    source = input('Write ur bin code: ')
    if source:
        code = HammingEncoder(source, len(source))
        encoded = code.encode()
        print('Encoded: ', encoded)
        bless = random.randrange(len(encoded) - 1)
        example = list(encoded)
        if example[bless] == '1': example[bless] = '0'
        else: example[bless] = '1'
        example = ''.join(example)
        print('Code with mistake before decoding:', example)
        decoded = HammingEncoder(example, code.controlBits)
        decode, mistake = decoded.decode()
        print("If you count from a unit, the mistake was in pos:", mistake)
        print("Decoded:", decode)
    else:
        print('Try to write smth\n')
        main()

main()
