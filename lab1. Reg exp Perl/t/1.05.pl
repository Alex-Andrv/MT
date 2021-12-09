#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

while (<>) {
    print if /[xzy].{5,17}[xzy]/;
}
