\\Generate RSA Pair
generateRSAPair(plength, qlength,minN) = {
	local(n,p,q,fi,e,d);
	n=1;
	while(minN > log(n)/log(length(Alf)) && floor(minN) != floor(log(n)/log(length(Alf))),
		p=nextprime(random(10^plength));
		q=nextprime(random(10^qlength));
		n=p*q
	);
	print("log(n)/log(length(Alf)) = "log(n)/log(length(Alf)));
	fi=(p-1)*(q-1);
	e=random(fi);
	while(gcd(e,fi) != 1,e=random(fi));
	d=Mod(e^(-1),fi);d=lift(d);
	print("p,q,n,fi,e,d");
	[p,q,p*q,fi,e,d];
}

