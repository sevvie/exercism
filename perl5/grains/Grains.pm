use strict;
use warnings;
use Math::BigInt;

package Grains {
  sub square {
    Math::BigInt->new('2')->bpow((shift) - 1)->bstr;
  }

  sub total {
    my $sum = Math::BigInt->new('0');
    for (1..64) {
      $sum = Math::BigInt->new( $sum->badd( square $_ )->bstr );
    }
    return $sum;
  }

}

1;
