#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

my $leadingSpaces = 1;
my $previousSpace = 0;

while (<>) {
    if ($leadingSpaces && !/^\s*$/) {
        $leadingSpaces = 0;
    }
    if (!$leadingSpaces) {
        if (/^\s*$/) {
            $previousSpace = 1;
        } else {
            if ($previousSpace) {
                print "\n"
            }
            $previousSpace = 0;
            s/^\s+//;
            s/\s+$/\n/;
            s/\s\s+/ /g;
            print;
        }
    }
}