#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';  #определиться с определением слова или символа, символ - это пробел?

while (<>) {
    print if /z.{3}z/;
}

