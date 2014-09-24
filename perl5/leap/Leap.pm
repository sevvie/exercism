use strict;
use warnings;

package Leap {
  sub is_leap {
    my $year = shift;

    return 1 if $year % 400 == 0;
    return 0 if $year % 100 == 0;
    return 1 if $year % 4 == 0;
    return 0;
  }
}

1;
