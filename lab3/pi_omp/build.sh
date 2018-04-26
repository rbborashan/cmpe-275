#!/bin/bash
#
# build using this script or cmake (note cmake needs some work)

rm mathish.py
rm *_wrap.c
rm *.o
rm *.so

# create wrapper
/usr/bin/swig -c++ -python mathish.i

# compile
g++ -fopenmp -fPIC -c pi-omp.cpp
g++ -fopenmp -O2 -fPIC -c mathish_wrap.cxx -I/System/Library/Frameworks/Python.framework/Versions/2.7/include/python2.7

# build the shared object (library)
g++ -lpython -dynamiclib pi-omp.o mathish_wrap.o -o _mathish.so -fopenmp
