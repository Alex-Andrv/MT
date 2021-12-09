#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

while (<>) {   #http://neerc.ifmo.ru/teaching/parsing/2021-2022/01-perl-re.pdf
    print if /cat.*cat/;   #https://perldoc.perl.org/perlretut
}


