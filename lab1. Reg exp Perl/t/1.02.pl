#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

while (<>) {
    print if /\bcat\b/;  #https://www.regular-expressions.info/wordboundaries.html
}
