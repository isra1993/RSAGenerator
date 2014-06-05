calculatePQ(rlength) = {
	local(p,q,r);
	r = nextprime(random(10^rlength));
	p = 4;
	q = 4;
	while( r != nextprime(r) || p != nextprime(p) || q != nextprime(q),
		r = nextprime(random(10^rlength));
		p = 2*r+1;
		q = 2*p+1;);
	[p,q]
}

calculateED(p,q, minmcd,alfLength) = {
	local(e,d,fi,n);
	n = p*q;
	fi=(p-1)*(q-1);
	e=random(fi);
	while(gcd(e,fi) != 1 || gcd(e-1,p-1) > minmcd || gcd(e-1, q-1) > minmcd ,e=random(fi));
	d=Mod(e^(-1),fi);d=lift(d);
	[log(n)/log(alfLength), n,(p-1)*(q-1),e,d]
}
