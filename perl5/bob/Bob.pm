use strict;
use warnings;
no if $] >= 5.017011, warnings => 'experimental::smartmatch';
use 5.020;

package Bob {
  sub hey {
    my $stmt = shift;

    given($stmt) {
      when( /^\s*$/ )
        { "Fine. Be that way!" }
      when( /\p{Uppercase}/ && !/\p{Lowercase}/ )
        { "Woah, chill out!" }
      when( /\?$/ )
        { "Sure." }
      default
        { "Whatever." }
    }
  }
}

1;
