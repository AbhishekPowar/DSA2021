#!/bin/python
import sys
import re
import pyperclip


def makeQuestion(question):
    # question = [word.capitalize() for word in question]

    prefix = 'P_'
    question = prefix+'0'*(5-len(question[0]))+'_'.join(question)
    question = re.sub('[^a-zA-Z_0-9]', '', question)
    pyperclip.copy(question)
    print(question)


def brackets(question):
    question = ' '.join(question)
    question = question.replace('[', '{').replace(']', '}')
    pyperclip.copy(question)
    print(question)


if __name__ == '__main__':
    question = sys.argv[1:]

    target = 'mq'
    if target == 'mq':
        makeQuestion(question)
    elif target == 'br':
        brackets(question)
    
