% Project by Vishnu Kadaba
% CSE 259
% ASU ID: 1217459815
%declaring 2 and 3 as primitive prime numbers
is_prime(2).
is_prime(3).
%checks if number is a prime or not
is_prime(P) :- integer(P),
P > 3,
P mod 2 =\= 0,
\+ has_factor(P,3).
%to check if N has a factor of L
has_factor(N,L) :- N mod L =:= 0.
has_factor(N,L) :- L * L < N,
L2 is L + 2,
has_factor(N,L2).
goldbach(4,[2,2]). % initialization for input 4.
goldbach(N,L) :- N mod 2 =:= 0, %even number
N > 4,
goldbach(N,L,3).
goldbach(N,[P,Q],P) :- Q is N - P, %checks if Q is N - P
is_prime(Q), %checks if Q is a prime
P < Q.
goldbach(N,L,P) :- P < N, %recursive until P is less than N
next_prime(P,P1), %finds next prime
goldbach(N,L,P1). %goldbach conjucture with new inputs
next_prime(P,P1) :- P1 is P + 2,
is_prime(P1),
!.
next_prime(P,P1) :- P2 is P + 2,
next_prime(P2,P1). %recursive loop until P2 is prime
goldbach_list(L,U) :- goldbach_list(L,U,2). %list with limit 2
goldbach_list(L,U,_):- L > U,
!.
goldbach_list(L,U,Limit):- L mod 2 =\= 0,
L1 is L + 1,
goldbach_list(L1,U,Limit).
goldbach_list(L,U,Limit) :- L =< U,
L mod 2 =:= 0,
print_goldbach(L,Limit),
L1 is L + 2,
goldbach_list(L1,U,Limit).
print_goldbach(L,_):- L < 4. %first case
print_goldbach(L,Limit) :- goldbach(L,[A,_]), %recursive loop to output all combinations
A < Limit.
print_goldbach(L , Limit) :- goldbach(L,[A,B]),
A>=Limit,
writef(" + \n",[L,A,B]).
