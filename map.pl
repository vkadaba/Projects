% Project by Vishnu Kadaba
% CSE 259 
% ASU ID: 1217459815

%getting the library of colors
:- use_module(library(clpfd)).
 
%declaring all colors needed for this color graphing constraint problem. 
color(red).
color(blue).
color(green).
color(yellow).

%declaring all vertices needed
vertex(a).
vertex(b).
vertex(c).
vertex(d).
vertex(e).
vertex(f).

%edge cases for region a 
edge(a,b).
edge(a,c).
edge(a,f).
edge(a,d).

%edge cases for region b
edge(b,a).
edge(b,c).
edge(b,e).

%edge cases for region c
edge(c,b).
edge(c,a).
edge(c,f).
edge(c,d).

%edge cases for region d
edge(d,a).
edge(d,c).
edge(d,e).
edge(d,f).

%edge cases for region e
edge(e,b).
edge(e,c).
edge(e,d).

%edge cases for region f
edge(f,c).
edge(f,a).
edge(f,d).

color_map(L) :- color([],L). %main function

color(Map,L):- vertex(Vertex), %getting vertex
		\+ member([Vertex,_],Map), %checks if its already colored
		color(Color), %getting color
		maplist(validColor(Vertex,Color),Map), %checks the condition
		append(Map,[[Vertex,Color]],Map2), %updating the accumulator
		color(Map2,L). %recursive function to run through all sections

%counts number of vertices and checks the validity of the color
color(Map,L):- findall(_,vertex(_),TargetMap), 
		length(TargetMap,NumberOfVertices),
		length(Map,NumberOfVerticesColored),
		NumberOfVertices = NumberOfVerticesColored,
		L=Map.

validColor(X,_,[Y,_]):- \+edge(X,Y).  %checks validity
validColor(_,C1,[_,C2]):- C1\=C2.
		