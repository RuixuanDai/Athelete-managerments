CREATE TABLE ATHLETE
(	Ano int primary key,
	Aname char(10)not null unique,
	Aage int check(Aage>=16 and Aage<=40),
	Aheight int check(Aheight>=140 and Aheight<=250),
	Aweight int check(Aweight>=35 and Aweight<=200),
);
