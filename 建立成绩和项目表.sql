create table GAME
(	Gno int primary key,
	Gname char(40)not null,
	Gtime char(20),
	Gplace char(40)
);
create table SCORE
(	Gno int references GAME(Gno),
	Gname char(40),
	Ano int references ATHLETE(ANO),
	RANKS int check(RANKS>=0 and RANKS<=100)
);
