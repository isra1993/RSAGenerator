calculateED(p,q, minmcd) = {
	local(e,d,fi,n);
	n = p*q;
	fi=(p-1)*(q-1);
	e=random(fi);
	while(gcd(e,fi) != 1 || gcd(e-1,p-1) > minmcd || gcd(e-1, q-1) > minmcd ,e=random(fi));
	d=Mod(e^(-1),fi);d=lift(d);
	[n,(p-1)*(q-1),e,d]
}
